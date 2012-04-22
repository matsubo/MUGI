/*
 * Created on 2004/12/18
 *
 * $Id: MappleLocationInformation.java,v 1.3 2005/01/20 07:51:26 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis;

import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.Dataset;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.postgis.PostGISConnection;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.postgis.PostGISSearch;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;

/**
 * @author matsu
 * 
 */
public class MappleLocationInformation implements LocationInformationGetter{
    
    
    private PostGISSearch map ;
    
    /**
     * コンストラクタ 
     */
    public MappleLocationInformation(){
        
//      接続
        PostGISConnection con = PostGISConnection.getInstance();
        
        
        map = new PostGISSearch(con);
        
        
    }

    /* (non-Javadoc)
     * @see jp.ac.keio.sfc.ht.matsu.mugi.gis.LocationInformationGetter#getAttribute(jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint)
     */
    public Dataset getAttribute(GeoPoint location) throws NoClosePlaceException{
        
        return map.getNearestDataset(location);
        
        
    }
    
    
    
    /**
     * テスト
     * @param args
     * @throws NoClosePlaceException
     */
    public static void main(String args[]) throws NoClosePlaceException{
        
        MappleLocationInformation map = new MappleLocationInformation();
        
        Dataset dataset = map.getAttribute(new GeoPoint(35.3894083333333,139.428691666667));
        
        Log.debug(dataset.getNodeName() + " "+dataset.getParameterName());
        
        
//        GeoPoint point = new GeoPoint(35.3963416666667,139.466569444444);
//        Log.debug(point.getLatitude());
//        Log.debug(point.getLongitude());
//        
//        Log.debug(String.valueOf(point.getPoint().getX()));
//        Log.debug(String.valueOf(point.getPoint().getY()));
//        
    }

}
