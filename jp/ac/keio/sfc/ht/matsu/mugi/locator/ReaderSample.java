/*
 * Created on 2004/12/08
 *
 * $Id: ReaderSample.java,v 1.1 2004/12/12 21:17:37 matsu Exp $
 * 
 * GPSリーダ周りをチェックするためのテストクラス
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator;

import jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.FileGPSReader;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.GPSReaderListener;

/**
 * @author matsu
 * 
 */
public class ReaderSample implements GPSReaderListener{

    public static void main(String args[]){
        
        ReaderSample test = new ReaderSample();
        
    }
    
    public ReaderSample(){
        
        //TestGPSReader reader = new TestGPSReader();
        FileGPSReader reader = new FileGPSReader();
        
        reader.addGPSListener(this);
        
    }
    
    
    
    

    /* (non-Javadoc)
     * @see jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.GPSReaderListener#locateionEvent(jp.ac.keio.sfc.ht.matsu.mugi.locator.CoordinateEvent)
     */
    public void locateionEvent(CoordinateEvent coordiante_event) {

        // Output 
        jp.ac.keio.sfc.ht.matsu.mugi.util.Log.debug("Listener: "+coordiante_event);
        
        
        // Logging
//        HistoryLogger.getInstance().write(coordiante_event.getCoordinate());
        
    }
    
}
