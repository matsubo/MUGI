/*
 * Created on 2004/12/08
 *
 * $Id: CoordinateEvent.java,v 1.2 2004/12/15 06:08:50 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator;

import java.util.EventObject;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;

/**
 * @author matsu
 * 
 */
public class CoordinateEvent extends EventObject {
    
    private static final long serialVersionUID = 3906925686106044214L;

    /**
     * ç¿ïWíl
     * 
     * @uml.property name="coordinate"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private GeoPoint location;


    public CoordinateEvent(Object object, GeoPoint coordinate){
        
        super(object);
        this.location = coordinate;
        
    }

    /**
     * @return Returns the coordinate.
     * 
     * @uml.property name="coordinate"
     */
    public GeoPoint getCoordinate() {
        return location;
    }

    /**
     * @param coordinate The coordinate to set.
     * 
     * @uml.property name="coordinate"
     */
    public void setCoordinate(GeoPoint coordinate) {
        this.location = coordinate;
    }

    
    
    public String toString(){
        
        return " lat:"+location.getLatitude() + " lon:"+location.getLongitude();
        
    }
    
}
