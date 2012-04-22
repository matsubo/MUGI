/*
 * Created on 2005/01/09
 *
 * $Id: MapPanel.java,v 1.1 2005/01/11 07:56:36 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.app.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author matsu
 * 
 */
public class MapPanel extends JPanel {

    private static final long serialVersionUID = 3256727277474886968L;

    private ImageIcon map = null;

    public MapPanel() {

        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(384, 288));

        map = new ImageIcon("jp/ac/keio/sfc/ht/matsu/mugi/app/panels/map.gif");

    }

    /**
     * ‰æ‘œ‚ð•\Ž¦
     */
    public void paintComponent(Graphics g) {

        g.drawImage(map.getImage(), 0, 0, null);

    }

}
