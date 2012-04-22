/*
 * Created on 2004/12/08
 *
 * $Id: GPSReaderListener.java,v 1.2 2004/12/21 08:51:45 matsu Exp $
 * 
 * GPS位置取得機器から座標を読むインターフェイス
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator.reader;

import jp.ac.keio.sfc.ht.matsu.mugi.locator.CoordinateEvent;

/**
 * @author matsu
 * 
 */
public interface GPSReaderListener {
    void locateionEvent(CoordinateEvent coordiante_event);
}
