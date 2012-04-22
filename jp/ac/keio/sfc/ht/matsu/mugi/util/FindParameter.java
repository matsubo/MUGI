/*
 * �쐬��: 2004/12/22
 *
 * TODO ���̐������ꂽ�t�@�C���̃e���v���[�g��ύX����ɂ͎��փW�����v:
 * �E�B���h�E - �ݒ� - Java - �R�[�h�E�X�^�C�� - �R�[�h�E�e���v���[�g
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
 * �n�}�T�[�o���瑮�������擾����
 * 
 */
public class FindParameter {

    public FindParameter(){
    
    }
    
    
	public String lookup(String label){
		
		PostGISConnection connection = PostGISConnection.getInstance();
		
        // ���C���̃��X�g�擾
        Iterator layer_iterator = LayerArrayList.layers.iterator();
        
        StringBuffer buffer = new StringBuffer();
        
        while (layer_iterator.hasNext()) {
            
            try {
                
                String layer_name = (String) layer_iterator.next();
                Statement s = connection.getStatement();
                

               // Not using index
                String query = "SELECT  code,label FROM "+layer_name+" WHERE label LIKE '%"+label+"%' GROUP BY code,label";
                
                //Log.debug(query);
                
                // ���s
                ResultSet r = s.executeQuery(query);
                


                // �f�[�^�i�[ 
                while (r.next()) {
                    
                    String code         =  r.getString(1);
                    String rlabel       =  r.getString(2);
                    
                    // code�̍Ō�1����������
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
