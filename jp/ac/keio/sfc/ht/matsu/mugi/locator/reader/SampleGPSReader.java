/*
 * Created on 2004/12/08
 *
 * $Id: SampleGPSReader.java,v 1.2 2004/12/15 06:08:50 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator.reader;

import jp.ac.keio.sfc.ht.matsu.mugi.locator.CoordinateEvent;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;


/**
 * @author matsu
 * 
 */
public class SampleGPSReader implements Runnable{
    
    private boolean is_thread = true;

    /**
     * 
     * @uml.property name="listener"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private GPSReaderListener listener;


    
    public SampleGPSReader(){
        
        new Thread(this).start();
        
    }
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        
        while(is_thread){
            
            if(listener != null)
                listener.locateionEvent(new CoordinateEvent(this, new GeoPoint(35.23362,139.255458)));
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    
    /**
     * スレッド停止
     * 
     */
    public void stop(){
        this.is_thread = false;
    }

    /**
     * リスナー追加
     * @param listener
     * 
     * @uml.property name="listener"
     */
    public void addGPSListener(GPSReaderListener listener) {
        this.listener = listener;
    }

    
    
}
