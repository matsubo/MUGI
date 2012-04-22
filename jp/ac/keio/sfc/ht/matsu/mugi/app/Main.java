/*
 * Created on 2005/01/09
 *
 * $Id: Main.java,v 1.2 2005/01/20 11:48:11 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import jp.ac.keio.sfc.ht.matsu.mugi.app.panels.HMMViewerPanel;
import jp.ac.keio.sfc.ht.matsu.mugi.app.panels.MapPanel;
import jp.ac.keio.sfc.ht.matsu.mugi.app.panels.RecommendationPanel;
import jp.ac.keio.sfc.ht.matsu.mugi.app.panels.RouteEvalationPane;

/**
 * @author matsu
 * 
 */
public class Main implements ActionListener {

    /**
     * �R���X�g���N�^
     * 
     */
    public Main() {

        JFrame frame = new JFrame("MUGICHOCO application");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        // frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setBounds(0, 0, Param.windowsize.width,
        // Param.windowsize.height);
        // frame.setPreferredSize(new Dimension(768,600));

        frame.setJMenuBar(makeMenu());
        frame.setVisible(true);

        // �E��^�u
        JPanel rightup_panel = new JPanel();
        //left_panel.setLayout(grid);
        rightup_panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),"���݈ʒu"));
        rightup_panel.add(new MapPanel());
        
        
        // �E���^�u
        JPanel rightdown_panel = new JPanel();
        //left_panel.setLayout(grid);
        rightdown_panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),"MUGI - �s�����f��"));
        rightdown_panel.add(new HMMViewerPanel());
        
        // �E���\�z
        Container right_container = new Container();
        right_container.setLayout(new BorderLayout());
        right_container.add(rightup_panel, BorderLayout.NORTH);
        right_container.add(rightdown_panel, BorderLayout.SOUTH);

        // ���^�u
        JTabbedPane left_tab = new JTabbedPane();
        left_tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        left_tab.add("�M���Ƀx�X�g�Ȍo�H", new RouteEvalationPane());
        left_tab.add("���R�R�i�r�I", new RecommendationPanel());

        // ���p�l��
        JPanel left_panel = new JPanel();
        //left_panel.setLayout(grid);
        left_panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),"�A�v���P�[�V�����G���A"));
        left_panel.add(left_tab);
        
        // �\��t��
        container.add(left_panel, BorderLayout.CENTER);
        container.add(right_container, BorderLayout.EAST);
        
        
        
        frame.pack();

    }
    
    
    
    private JMenuBar makeMenu(){
        
        JMenuBar bar = new JMenuBar();
        
        // 1
        JMenu menu1 = new JMenu("�t�@�C�� (F)");
        menu1.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem item11 = new JMenuItem("�I�� (X)");
        item11.setMnemonic(KeyEvent.VK_X);
        item11.addActionListener(this);
        menu1.add(item11);
        
        bar.add(menu1);
        
        
        
        
        return bar;
        
    }
    
    
    private void exitApplication(int code){
        
        System.exit(code);
        
    }

    /**
     * ���C��
     * 
     * @param args
     */
    public static void main(String[] args) {

        Main main = new Main();

    }


    

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("�I�� (C)"))
                    exitApplication(0);
            

    }
}
