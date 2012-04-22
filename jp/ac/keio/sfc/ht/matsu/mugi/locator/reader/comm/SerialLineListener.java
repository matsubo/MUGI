/*
 * Created on 2004/12/13
 *
 * $Id: SerialLineListener.java,v 1.1 2004/12/12 21:17:41 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.comm;

/**
 * @author matsu
 * 
 */
public interface SerialLineListener {

    public void serialData(String data);
    
}
