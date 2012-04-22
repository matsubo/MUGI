/*
 * Created on 2005/01/09
 *
 * $Id: RouteEvalationPane.java,v 1.1 2005/01/11 07:56:37 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.app.panels;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;



/**
 * @author matsu
 * 
 */
public class RouteEvalationPane extends JPanel {

    private static final long serialVersionUID = 3256727277474886968L;

    private String[][] tabledata = { 
            { "�o�H3", "100" },
            { "�o�H2", "88" },
            { "�o�H1", "28" },
            { "�o�H5", "18" },
            { "�o�H7", "8" },
            { "�o�H6", "2" },
            }; 

    
    private String[][] detaildata = { 
            { "�A���[��", "abcde" },
            { "�X�^�[�o�b�N�X", "aefa" },
            { "�V����", "eqwa" },
            { "�R���r�j", "ewqrf" },
            }; 
    
    private String[] columns = { "�o�H��", "�K���x"};
    
    private String[] detailcolumns = { "�ꏊ�̖��O", "����"};

    public RouteEvalationPane() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // 1
        JTable table = new JTable(tabledata, columns);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        

        JScrollPane route = new JScrollPane();
        route.getViewport().setView(table);
        route.setPreferredSize(new Dimension(384, 250));
        

        route.setBorder(BorderFactory.createTitledBorder("�M���D�݂̌o�H"));
        add(route);

        // 2
        
        JTable table2 = new JTable(detaildata, detailcolumns);
        table2.setRowSelectionAllowed(true);
        table2.setColumnSelectionAllowed(false);
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        

        JScrollPane route2 = new JScrollPane();
        route2.getViewport().setView(table2);
        route2.setPreferredSize(new Dimension(384, 250));

        route2.setBorder(BorderFactory.createTitledBorder("�ڍ׌o�H"));
        add(route2);
        
        
        
        
//        this.setPreferredSize(new Dimension(384, 576));

    }

}
