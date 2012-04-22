/*
 * Created on 2004/12/08
 *
 * $Id: FileGPSReader.java,v 1.4 2004/12/15 13:22:36 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.ac.keio.sfc.ht.matsu.mugi.locator.CoordinateEvent;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.exception.UnsupportedGPSFormatException;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.history.HistoryLogger;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.parser.NMEAParser;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;

/**
 * @author matsu
 * 
 */
public class FileGPSReader implements Runnable {

    private boolean is_thread = true;

    /**
     * 
     * @uml.property name="listener"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private GPSReaderListener listener;

    FileInputStream fis = null;

    InputStreamReader ir = null;

    BufferedReader br = null;
    
    
    public FileGPSReader(String file){
        init(file);
    }
    
    public FileGPSReader(){
        
        //init("jp/ac/keio/sfc/ht/matsu/mugi/data/GPRMC.txt");
        //init("jp/ac/keio/sfc/ht/matsu/mugi/data/apartof20041118.nme");
        //init("jp/ac/keio/sfc/ht/matsu/mugi/data/komeda_kaeri.nme");
        init("jp/ac/keio/sfc/ht/matsu/mugi/data/komeda_iki.nme");
        
        
    }
    
    
    /**
     * 初期化
     * @param file
     */
    public void init(String file) {

        try {
            
            fis = new FileInputStream(file);
            ir = new InputStreamReader(fis, "MS932");
            br = new BufferedReader(ir);

        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(this).start();

    }
    

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run() {

        while (is_thread) {

            try {

                String msg = br.readLine();
                if (msg == null)
                    break;

                //Log.debug(msg);
                GeoPoint location = NMEAParser.parse(msg);
                
                // ログへ書き込み
                HistoryLogger.getInstance().add(location);
                
                

                if (listener != null)
                    listener.locateionEvent(new CoordinateEvent(this, location));

                // Thread.sleep(1);

                // } catch (InterruptedException e) {
                // e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedGPSFormatException e) {
                //e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        // Close

        try {
            fis.close();
            ir.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    
    /**
     * スレッド停止
     * 
     */
    public void stop() {
        this.is_thread = false;
    }

    /**
     * リスナー追加
     * 
     * @param listener
     * 
     * @uml.property name="listener"
     */
    public void addGPSListener(GPSReaderListener listener) {
        this.listener = listener;
    }

}
