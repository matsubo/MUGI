/*
 * Created on 2004/12/08
 *
 * $Id: LocationInformationGetter.java,v 1.2 2005/01/20 03:20:27 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis;

import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.Dataset;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;

/**
 * @author matsu
 * 
 */
public interface LocationInformationGetter {
    
    public Dataset getAttribute(GeoPoint location) throws NoClosePlaceException;

}
