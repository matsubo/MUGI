/*
 * Created on 2004/12/08
 *
 * $Id: EtrexGPSReader.java,v 1.4 2004/12/15 06:08:50 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator.reader;

import jp.ac.keio.sfc.ht.matsu.mugi.locator.CoordinateEvent;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.exception.UnsupportedGPSFormatException;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.parser.NMEAParser;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.comm.SerialLineListener;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.comm.SimpleRead;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

/**
 * @author matsu
 * 
 */
public class EtrexGPSReader implements SerialLineListener {

    /**
     * 
     * @uml.property name="listener"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private GPSReaderListener listener;

    public EtrexGPSReader() {

        SimpleRead reader = new SimpleRead();
        reader.addSerialLineListener(this);

    }

    /**
     * ÉäÉXÉiÅ[í«â¡
     * 
     * @param listener
     * 
     * @uml.property name="listener"
     */
    public void addGPSListener(GPSReaderListener listener) {
        this.listener = listener;
    }

    /*
     * (non-Javadoc)
     * 
     * @see jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.comm.SerialLineListener#serialData(java.lang.String)
     */
    public void serialData(String data) {

        if (listener != null) {

            GeoPoint location = null;

            try {
                location = NMEAParser.parse(data);
            } catch (UnsupportedGPSFormatException e) {
                //Log.info("Unsupported line");
            }

            if(location != null){
                listener.locateionEvent(new CoordinateEvent(this, location));
                Log.info("Notify");
                Log.debug(data);
            }
        }

    }

}
