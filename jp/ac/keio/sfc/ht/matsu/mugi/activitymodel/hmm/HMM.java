/*
 * Created on 2004/12/08
 *
 * $Id: HMM.java,v 1.6 2005/01/20 08:05:03 matsu Exp $
 * 
 * モデル管理部
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.HMMManager;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

/**
 * @author matsu
 * 
 * Memo: リンクはノードで管理する
 * 
 */
public class HMM implements Serializable {

    private static final long serialVersionUID = 3258413949769953587L;

    /** ノード保持 (ノード名,ノード) */
    private Hashtable<String, HMMNode> nodes = new Hashtable<String, HMMNode>();

    
    public HMM(){
    }

    /**
     * ノードを生成
     * 
     * @param dataset
     *            データセット
     */
    public void learn(Dataset dataset) {

        // 既存の場所だったら,回数を追加
        if (nodes.get(dataset.getNodeName()) != null) {

            HMMNode _node = nodes.get(dataset.getNodeName());
            _node.addParameter(dataset.getParameterName());

            nodes.remove(dataset.getNodeName());
            nodes.put(dataset.getNodeName(), _node);

            // 新しい場所だったら，追加
        } else {
            HMMNode new_node = new HMMNode(dataset.getNodeName());
            new_node.addParameter(dataset.getParameterName());

            nodes.put(dataset.getNodeName(), new_node);
        }
        
        
        

    }

    /**
     * リンクを構築
     * 
     * @param from
     *            リンク作成元
     * @param to
     *            リンク作成先
     */
    public void link(String from, String to) {

        HMMNode _node = nodes.get(from);

        // ノードが存在したら
        if (_node != null)
            _node.addLinkTo(to);

    }
    
    public HMMNode getNode(String nodename) throws NoSuchElementException{
        
        
        if(nodes.get(nodename) == null)
            throw new NoSuchElementException(nodename);
        
        return  nodes.get(nodename);
        
    }
    

    /**
     * ノード間のリンク数を返す
     * @return
     */
    public int getAllParameterNum(){
        
        int size = 0;
        
        // パラメータ数
        for (Enumeration e = nodes.elements(); e.hasMoreElements();) {

            // buffer.append(e.nextElement() + "\n");

            HMMNode _node = (HMMNode) e.nextElement();
            size += _node.getParameterSize();
        }
        
        return size;
        
    }
    
    /**
     * ノード間のリンク数を返す
     * @return
     */
    public int getAllLinkNum(){
        
        int size = 0;
        
        // パラメータ数
        for (Enumeration e = nodes.elements(); e.hasMoreElements();) {

            // buffer.append(e.nextElement() + "\n");

            HMMNode _node = (HMMNode) e.nextElement();
            size += _node.getLinkSize();
        }
        
        return size;
        
    }
    
    
    /**
     * すべてのデータを返す
     * @return
     */
    public Hashtable getAllNodes(){
        return nodes;
    }
    
    /**
     * ノード数を返す
     * @return
     */
    public int getNodeSize(){
        return nodes.size();
    }
    
    /**
     * ノード数・パラメータ数・リンク数を返す（評価用）
     * @return
     */
    public String getStat(){
        return this.getNodeSize()+"\t"+this.getAllParameterNum()+"\t"+this.getAllLinkNum();
    }

    /**
     * デバッグ出力
     * 
     */
    public String toString() {

        StringBuffer buffer = new StringBuffer("\n");

        for (Enumeration e = nodes.elements(); e.hasMoreElements();) {

            // buffer.append(e.nextElement() + "\n");

            HMMNode _node = (HMMNode) e.nextElement();

            buffer.append("*" + _node.getNodeName() + "\n");

            for (Enumeration ep = _node.getAllLinkNames(); ep.hasMoreElements();) {
                try {
                    String _link = (String) ep.nextElement();
                    buffer.append("+ " + _link + " ("
                            + _node.getLinkProbability(_link) + ") \n");
                } catch (NoSuchElementException ns) {
                    ns.printStackTrace();
                }
            }

            buffer.append("\n");

            for (Enumeration ep = _node.getAllParameter(); ep.hasMoreElements();) {
                try {
                    String _param = (String) ep.nextElement();
                    buffer.append("-" + _param + "   ("
                            + _node.getParameterProbability(_param) + ")\n");
                } catch (NoSuchElementException ns) {
                    ns.printStackTrace();
                }
            }

        }

        return buffer.toString();

    }

    /**
     * テスト
     * 
     * @param args
     */
    public static void main(String args[]) {

        try {
            HMM hmm = HMMManager.load();

            hmm.learn(new Dataset("special", "SFC"));
            hmm.link("special", "a_ahcg");
            hmm.learn(new Dataset("a_ahcg", "ビッグボーイ"));
            hmm.learn(new Dataset("a_ahcg", "ビッグボーイ"));
            hmm.link("a_ahcg", "a_agcx");
            hmm.learn(new Dataset("a_agcx", "ミネボール"));

            HMMManager.save(hmm);

            Log.debug(hmm);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
