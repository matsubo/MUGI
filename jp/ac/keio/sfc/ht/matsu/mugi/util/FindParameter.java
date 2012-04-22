/*
 * 作成日: 2004/12/22
 *
 * TODO この生成されたファイルのテンプレートを変更するには次へジャンプ:
 * ウィンドウ - 設定 - Java - コード・スタイル - コード・テンプレート
 */
package jp.ac.keio.sfc.ht.matsu.mugi.util;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.postgis.LayerArrayList;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.postgis.PostGISConnection;

/**
 * @author matsu
 *
 * 地図サーバから属性名を取得する
 * 
 */
public class FindParameter {

    public FindParameter(){
    
    }
    
    
	public String lookup(String label){
		
		PostGISConnection connection = PostGISConnection.getInstance();
		
        // レイヤのリスト取得
        Iterator layer_iterator = LayerArrayList.layers.iterator();
        
        StringBuffer buffer = new StringBuffer();
        
        while (layer_iterator.hasNext()) {
            
            try {
                
                String layer_name = (String) layer_iterator.next();
                Statement s = connection.getStatement();
                

               // Not using index
                String query = "SELECT  code,label FROM "+layer_name+" WHERE label LIKE '%"+label+"%' GROUP BY code,label";
                
                //Log.debug(query);
                
                // 実行
                ResultSet r = s.executeQuery(query);
                


                // データ格納 
                while (r.next()) {
                    
                    String code         =  r.getString(1);
                    String rlabel       =  r.getString(2);
                    
                    // codeの最後1文字を消す
                    code = code.substring(0, code.length() -1);
                    
                    //String label        = (String) r.getObject(2);
                    //double distance    = Double.parseDouble((String)r.getString(3));
                    
                    //Log.debug(code +"("+layer_name+") "+ rlabel);
                    buffer.append("("+layer_name+") \t\t"+ rlabel+"\n");
                    
                }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return buffer.toString();
		
	}
	
	public static void main(String args[]){
		
		if(args.length < 1){
			Log.warn("java FndParameter <search word>");
			System.exit(1);
		}
		
		FindParameter main = new FindParameter();
        System.out.println(main.lookup(args[0]));
        
		
	}
	
}
