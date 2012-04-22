/*
 * Created on 2005/01/09
 *
 * $Id: HMMViewerPanel.java,v 1.4 2005/01/21 08:44:27 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.app.panels;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.HMMManager;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.HMM;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.HMMNode;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

/**
 * @author matsu
 * 
 */
public class HMMViewerPanel extends JPanel implements MouseMotionListener,
        MouseListener {

    private static final long serialVersionUID = 3256727277474886968L;

    private Dimension size = new Dimension(384, 288);

    /** マウスで選択しているノード */
    private Node pick;

    boolean pickfixed;

    private int nnodes;

    private Node nodes[] = new Node[100];

    private int nedges;

    private Edge edges[] = new Edge[200];

    private HMM hmm = null;
    
    /**
     * コンストラクタ
     *
     */
    public HMMViewerPanel() {

        this.setPreferredSize(size);
        
        
        // HMM 読み込み
        try {

            hmm = HMMManager.load();
            Log.debug(hmm);

        } catch (Exception e) {
            System.err.println("Unable to load HMM");
            e.printStackTrace();
            System.exit(1);
        }

        addMouseListener(this);
        addMouseMotionListener(this);

        
        
        // ビューアの変数へ格納
        for(Enumeration e = hmm.getAllNodes().elements(); e.hasMoreElements();){
            
            // ノード
            HMMNode node = (HMMNode)e.nextElement();
            this.addNode(node.getNodeName());
            
            // リンク
            
            for(Enumeration e2 = node.getAllLinkNames(); e2.hasMoreElements();){
                
                String link_to = (String)e2.nextElement();
                float link_to_probability = node.getLinkProbability(link_to);
                
                this.addEdge(node.getNodeName(), link_to, link_to_probability);
                
            }
            
            
        }
        
        

    }

    
    
    int findNode(String lbl) {
        for (int i = 0; i < nnodes; i++) {
            if (nodes[i].lbl.equals(lbl)) {
                return i;
            }
        }
        //Log.debug("MADE!!"+lbl);
        return addNode(lbl);
    }

    int addNode(String lbl) {
        

        
        // 既にノードが合ったら，リターン
        for (int i = 0; i < nnodes; i++) {
            if (nodes[i].lbl.equals(lbl)) {
                return 0;
            }
        }

        
        Node n = new Node();
        n.x = -10 + size.width * Math.random();
        n.y = -10 + size.height * Math.random();
        n.lbl = lbl;
        nodes[nnodes] = n;
        return nnodes++;
    }

    void addEdge(String from, String to, float len) {
        Edge e = new Edge();
        e.from = findNode(from);
        e.to = findNode(to);
        e.len = len;
        edges[nedges++] = e;
    }
    
    

    /**
     * 画像を表示
     */
    public void paintComponent(Graphics real_g) {

        // Java2D オブジェクトへキャスト

        Image offscreen = createImage(getWidth(), getHeight());
        Graphics off_g = offscreen.getGraphics();
        Graphics2D g = (Graphics2D) off_g;

        // Java2D設定
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // 背景
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, getWidth(), getHeight());

        // 描画
        /** **************************************** */

        // 透明化
        // AlphaComposite composite = AlphaComposite.getInstance(
        // AlphaComposite.SRC_OVER, 0.8f);
        // g.setComposite(composite);
        // 線を描画
        // g.draw(new Line2D.Double(test, 50, 180, 120));
        // 画像を表示
        // g.drawImage(map.getImage(),0,0,null);
        // 線の太さ
        g.setStroke(new BasicStroke(1.5f));

        /*
         * int start_x = 0; int start_y = 0; int width = 90; int height = 20;
         * 
         * for (int i = 0; i < 10; i++) {
         * 
         * start_x = i * 10; start_y = i * 10;
         * 
         * g.setPaint(Color.yellow); g.fill(new Rectangle2D.Double(start_x,
         * start_y, width, height)); g.setPaint(Color.gray); g.draw(new
         * Rectangle2D.Double(start_x, start_y, width, height));
         * 
         * g.setPaint(Color.BLACK); g.setFont(new Font("ＭＳ Ｐゴシック", Font.PLAIN,
         * 9)); g.drawString("レストラン", start_x + 5, start_y + 15); }
         */

        paintEdges(g);
        paintNode(g);

        /** **************************************** */

        // バッファを描画
        real_g.drawImage(offscreen, 0, 0, null);

    }

    /**
     * ノードを描画
     * 
     * @param g
     * @param n
     * @param fm
     */
    private void paintNode(Graphics2D g) {

        g.setStroke(new BasicStroke(1.5f));
        FontMetrics fm = g.getFontMetrics();

        for (int i = 0; i < nnodes; i++) {

            int x = (int) nodes[i].x;
            int y = (int) nodes[i].y;
            g.setPaint((nodes[i] == pick) ? Color.PINK
                    : (nodes[i].fixed ? Color.PINK : Color.YELLOW));

            int w = fm.stringWidth(Lookup.lookup(nodes[i].lbl)) + 10;
            int h = fm.getHeight() + 4;
            g.fill(new Rectangle2D.Double(x - w / 2, y - h / 2, w, h));
            g.setPaint(Color.black);
            g.draw(new Rectangle2D.Double(x - w / 2, y - h / 2, w - 1, h - 1));
            g.drawString(Lookup.lookup(nodes[i].lbl), x - (w - 10) / 2, (y - (h - 4) / 2)
                    + fm.getAscent());

            
            
            
            // 隠れ属性の描画
            if (nodes[i] == pick) {

                // 暗くする
                g.setComposite(AlphaComposite.getInstance(
                        AlphaComposite.SRC_OVER, 0.2f));
                g.setPaint(Color.GREEN);
                g.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));


                // テーブル属性
                int x_start = x + 20;
                int y_start = y + 20;
                int width = 200;
                int height = h = fm.getHeight();
                
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

                // 隠れ属性描画
                HMMNode hmmnode = (HMMNode)hmm.getAllNodes().get(nodes[i].lbl);
                
                
                
                // 背景
                g.setPaint(Color.WHITE);
                g.fill(new Rectangle2D.Double(x_start, y_start, width,height));
                
                
                g.setPaint(Color.BLACK);
                g.setStroke(new BasicStroke(1.0f));// 枠
                g.draw(new Rectangle2D.Double(x_start, y_start, width/2, height));//セル
                g.draw(new Rectangle2D.Double(x_start + width / 2, y_start, width / 2, height));//セル
                
                g.setPaint(Color.BLACK);
                w = fm.stringWidth("属性");
                g.drawString("属性", x_start + width / 4 - w / 2, y_start+ height - height / 4);

                w = fm.stringWidth("確率");
                g.drawString("確率", x_start + 3*width / 4 - w / 2, y_start + height - height / 4);
                    
                    
                
                
                
                
                int j = 1;
                for(Enumeration e = hmmnode.getAllParameter(); e.hasMoreElements();){

                    String parameter_name = (String)e.nextElement();
                    
                    int y_current = y_start + height * j;
                    
                    
                    // 背景
                    g.setPaint(Color.WHITE);
                    g.fill(new Rectangle2D.Double(x_start, y_current, width,height));
                    g.setStroke(new BasicStroke(1.0f));
                    g.setPaint(Color.BLACK);
                    
                    g.draw(new Rectangle2D.Double(x_start, y_current, width/2, height));
                    g.draw(new Rectangle2D.Double(x_start + width / 2, y_current, width / 2, height));
                    
                    
                    
                    g.drawString(parameter_name , x_start +2 , y_current + height - height / 4);
                    g.drawString(new Float(hmmnode.getParameterProbability(parameter_name)).toString() , x_start + width/2 +2 , y_current + height - height / 4);
                        
                        
                    //System.out.println(hmmnode.getLinkProbability(parameter_name));
                    
                    j++;

                }

                // g.draw("hoge",x+200,y+200);
                // g.drawString("hoge",x+200,y+200);

            }

        }

    }
    
    
    
    
    
    
    /**
     * 線を描画
     * 
     * @param g
     */
    private void paintEdges(Graphics2D g) {

        /*
         * 
         * int from_x = 0; int from_y = 10; int to_x = 50; int to_y = 10;
         * 
         * g.setPaint(Color.gray); g.draw(new
         * Line2D.Double(from_x,from_y,to_x,to_y));
         * 
         * GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
         * polygon.moveTo(to_x, to_y); polygon.lineTo(to_x-8, to_y-5);
         * polygon.lineTo(to_x-8, to_y+5); polygon.lineTo(to_x, to_y);
         * polygon.closePath();
         * 
         * g.fill(polygon);
         * 
         */

        g.setStroke(new BasicStroke(3.0f));

        for (int i = 0; i < nedges; i++) {
            Edge e = edges[i];
            int x1 = (int) nodes[e.from].x;
            int y1 = (int) nodes[e.from].y;
            int x2 = (int) nodes[e.to].x;
            int y2 = (int) nodes[e.to].y;

            
            
            // 線の太さ
            if(e.len == 1.0){
                g.setStroke(new BasicStroke(3.0f));                
            }else if (e.len >0.7){
                g.setStroke(new BasicStroke(2.0f));                
            }else if (e.len >0.3){
            	g.setStroke(new BasicStroke(1.5f));                
        	}else if (e.len > 0.0){
        		g.setStroke(new BasicStroke(1.0f));                
        	}
            
            
            // 確率取得
            String lbl = String.valueOf((float) e.len);
            
            // 線を描画
            // g.setPaint(Color.BLACK);
            g.setPaint(new GradientPaint(x1, y1, Color.BLUE, x2, y2, new Color(
                    255, 255, 255), false));

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    0.7f));
            g.draw(new Line2D.Double(x1, y1, x2, y2));

            // String lbl = String.valueOf(len);
            

            
            
            
            // ループバックを描画
            if (e.from == e.to) {

                // g.setPaint(Color.BLUE);
                g.setPaint(new GradientPaint(x1, y1, Color.BLUE, x1 + 40,
                        y1 + 40, new Color(200, 200, 200), false));
                g.draw(new Ellipse2D.Double(x1, y1, 40, 40));

                g.setPaint(Color.BLACK);
                g.drawString(lbl, x1 + 20, y1 + 20);

            }

            
            Vector<String> vector = new Vector<String>();
            
            vector.add("a");
            vector.add("b");
            
            
            String string = vector.get(0);
            
            
            
            
            // 文字列描画
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1.0f));
            g.setPaint(Color.BLACK);
            g.drawString(lbl, x1 + (x2 - x1) / 5, y1 + (y2 - y1) / 5);

        }

        g.setComposite(AlphaComposite
                .getInstance(AlphaComposite.SRC_OVER, 1.0f));

    }

    /**
     * デバッグ
     * 
     * @param args
     */
    public static void main(String args[]) {

        JFrame frame = new JFrame("MUGI Viewer");
        frame.getContentPane().add(new HMMViewerPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    public void mouseDragged(MouseEvent e) {
        pick.x = e.getX();
        pick.y = e.getY();
        repaint();
        e.consume();

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    public void mousePressed(MouseEvent e) {

        double bestdist = Double.MAX_VALUE;
        int x = e.getX();
        int y = e.getY();
        for (int i = 0; i < nnodes; i++) {
            Node n = nodes[i];
            double dist = (n.x - x) * (n.x - x) + (n.y - y) * (n.y - y);
            if (dist < bestdist) {
                pick = n;
                bestdist = dist;
            }
        }
        pickfixed = pick.fixed;
        pick.fixed = true;
        pick.x = x;
        pick.y = y;
        repaint();

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    public void mouseReleased(MouseEvent e) {
        if (pick != null) {
            pick.x = e.getX();
            pick.y = e.getY();
            pick.fixed = pickfixed;
            pick = null;
        }
        repaint();
        e.consume();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

}

class Node {

    double x;

    double y;

    // double dx;
    //
    // double dy;
    //
    // 止まっているノードか（色づけに利用）
    boolean fixed = false;

    String lbl;
}

class Edge {
    int from;

    int to;

    float len;
}

class Lookup{
    
    public static String lookup(String param){
        
        Hashtable<String,String> hash = new Hashtable<String,String>();
        
        
        /*
        hash.put("a_acbb","私鉄駅");
        hash.put("a_agch","書店");
        hash.put("a_agck","銀行");
        
        hash.put("a_agcf","工場");
        hash.put("a_ahcg","他レストラン");
        hash.put("a_agcx","一般注記");
        hash.put("a_ahc","レストラン");
        hash.put("a_ahd","ファーストフード");
        hash.put("a_ahb","コンビニエンスストア");
        hash.put("a_agcn","スーパーストア");
        hash.put("a_agaf","普通郵便局");
        hash.put("a_agcl","アパートマンション");
        */
        
        if(hash.get(param) != null){
            return hash.get(param);
        }else{
            return param;
        }
        
    }

}
