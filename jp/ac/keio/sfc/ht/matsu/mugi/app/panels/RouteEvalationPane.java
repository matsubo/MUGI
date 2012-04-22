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
            { "経路3", "100" },
            { "経路2", "88" },
            { "経路1", "28" },
            { "経路5", "18" },
            { "経路7", "8" },
            { "経路6", "2" },
            }; 

    
    private String[][] detaildata = { 
            { "アローム", "abcde" },
            { "スターバックス", "aefa" },
            { "新星堂", "eqwa" },
            { "コンビニ", "ewqrf" },
            }; 
    
    private String[] columns = { "経路名", "適合度"};
    
    private String[] detailcolumns = { "場所の名前", "属性"};

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
        

        route.setBorder(BorderFactory.createTitledBorder("貴方好みの経路"));
        add(route);

        // 2
        
        JTable table2 = new JTable(detaildata, detailcolumns);
        table2.setRowSelectionAllowed(true);
        table2.setColumnSelectionAllowed(false);
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        

        JScrollPane route2 = new JScrollPane();
        route2.getViewport().setView(table2);
        route2.setPreferredSize(new Dimension(384, 250));

        route2.setBorder(BorderFactory.createTitledBorder("詳細経路"));
        add(route2);
        
        
        
        
//        this.setPreferredSize(new Dimension(384, 576));

    }

}
