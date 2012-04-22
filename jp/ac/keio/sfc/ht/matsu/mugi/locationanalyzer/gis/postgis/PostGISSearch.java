/*
 * Created on: 2004/10/31
 *
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.postgis;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.Dataset;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.NoClosePlaceException;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;


/**
 * @author niya modified by matsu
 * 
 */
public class PostGISSearch{

    
    /** 検索する距離 */
    public final int search_distance = 300;
    
    /** DBへの接続 */
    private PostGISConnection connection = null;
    
    
    /**
     * コンストラクタ
     * @param connection
     */
    public PostGISSearch(PostGISConnection connection) {
        this.connection = connection;
    }

    

    /**
     * 現地点最寄りの属性を取得
     * @param location
     * @return
     */
    public Dataset getNearestDataset(GeoPoint location) throws NoClosePlaceException {

        // レイヤのリスト取得
        Iterator layer_iterator = LayerArrayList.layers.iterator();
        
        // 結果を保持
        Dataset return_data = null;
        
        
        // 最近接距離保存
        double most_close = 10000000;
        
        
        //long time_start = System.currentTimeMillis();
        
        // すべてのレイヤ
        while (layer_iterator.hasNext()) {
            
            try {
                
                String layer_name = (String) layer_iterator.next();
                Statement s = connection.getStatement();
                

               // Not using index
                String query = "SELECT  code,label, Distance(GeometryFromText('POINT("+location.getPoint().getY()+" "+location.getPoint().getX()+")',2451),trans_geom) AS distance FROM "+layer_name + " WHERE Distance(GeometryFromText('POINT("+location.getPoint().getY()+" "+location.getPoint().getX()+")', 2451),trans_geom) < "+search_distance+" ORDER BY distance";
                
                // Using index
                //String query = "SELECT  code,label, Distance(GeometryFromText('POINT("+location.getPoint().getY()+" "+location.getPoint().getX()+")',2451),trans_geom) AS distance FROM "+lName + " WHERE trans_geom && Expand(GeometryFromText('POINT("+location.getPoint().getY()+" "+location.getPoint().getX()+")', 2451), "+search_distance+") AND Distance(GeometryFromText('POINT("+location.getPoint().getY()+" "+location.getPoint().getX()+")', 2451),trans_geom) < "+search_distance+" ORDER BY distance";
                
                
                //Log.debug(query);
                
                // 実行
                ResultSet r = s.executeQuery(query);
                


                // データ格納 
                while (r.next()) {
                    
                    String code         =  r.getString(1);
                    String label        = (String) r.getObject(2);
                    double distance    = Double.parseDouble((String)r.getString(3));
                    
                    // データセットを生成
                    if(most_close > distance){
                        
                        code = code.substring(0, code.length() -1);
                        
                        return_data = new Dataset(code,label);
                        most_close = distance;
                    }

                        
                    
                    //Log.debug("table:"+layer_name+"		code:"+code+"	label:"+label+"		distance:"+distance+" m");
                    
                }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(return_data == null)
            throw new NoClosePlaceException();
        
        
        //Log.debug(return_data.getNodeName() + return_data.getParameterName());
        
        
        //Log.debug(new Long(System.currentTimeMillis() - time_start));
        

        return return_data;
        
        
    }
    

}
