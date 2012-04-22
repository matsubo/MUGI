/*
 * Created on 2005/01/20
 *
 * $Id: FindParameterGUI.java,v 1.1 2005/01/20 07:51:27 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.util;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author matsu
 * 
 */
public class FindParameterGUI implements ActionListener{
    
    
    private JTextField text_field = new JTextField(20);
    private JButton button = new JButton("Search");
    private JTextArea text_area = new JTextArea(10,40);
    

    public FindParameterGUI() {

        JFrame frame = new JFrame("場所の属性取得");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        // frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setBounds(0, 0, Param.windowsize.width,
        // Param.windowsize.height);
        // frame.setPreferredSize(new Dimension(768,600));

        frame.setJMenuBar(makeMenu());
        frame.setVisible(true);

        // p1
        JPanel p1 = new JPanel();
        button.addActionListener(this);
        p1.add(new JLabel("場所の名称"));
        p1.add(text_field);
        p1.add(button);
        
        
        
        // p2
        JPanel p2 = new JPanel();
        JScrollPane scrollPane = new JScrollPane(text_area,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        p2.add(scrollPane);
        
        container.setLayout(new BorderLayout());
        
        container.add(p1, BorderLayout.NORTH);
        container.add(p2, BorderLayout.CENTER);
        
        
        
        frame.pack();

    }

    private JMenuBar makeMenu() {

        JMenuBar bar = new JMenuBar();

        // 1
        JMenu menu1 = new JMenu("ファイル (F)");
        menu1.setMnemonic(KeyEvent.VK_F);

        JMenuItem item11 = new JMenuItem("終了 (X)");
        item11.setMnemonic(KeyEvent.VK_X);
        item11.addActionListener(this);
        menu1.add(item11);

        bar.add(menu1);

        return bar;

    }

    public static void main(String args[]) {

        FindParameterGUI main = new FindParameterGUI();

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button){
            FindParameter lookup = new FindParameter();
            text_area.setText(lookup.lookup(text_field.getText()));
            
        }
        
        if (e.getActionCommand().equals("終了 (X)"))
            System.exit(0);

        
        
    }

}

