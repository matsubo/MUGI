/*
 * Created on 2004/12/08
 *
 * $Id: HMMNode.java,v 1.4 2005/01/21 03:19:10 matsu Exp $
 * HMMのノード
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author matsu
 * 
 */
public class HMMNode implements Serializable {

    private static final long serialVersionUID = 3258413949769953587L;

    /** ノード名 */
    private String name;

    /** パラメータ <パラメータ名,回数> */
    private Hashtable<String, Integer> parameter = new Hashtable<String, Integer>();
    
    /** リンク <リンク先,回数>*/
    private Hashtable<String, Integer> link      = new Hashtable<String, Integer>();
    
    

    /**
     * コンストラクタ
     * 
     * @param name ノード名
     */
    protected HMMNode(String name) {
        this.name = name;
    }
    
    

    /**
     * 属性追加または，属性カウントアップ
     */
    protected void addParameter(String parameter_name) {

        // 既に存在するパラメータの
        if (parameter.get(parameter_name) != null) {

            // その場所をインクリメント
            Integer num = (Integer) parameter.get(parameter_name);
            int newnum = num.intValue() + 1;
            
            parameter.remove(parameter_name);
            parameter.put(parameter_name, new Integer(newnum));

        }

        
        // 初めてのパラメータ
        else{
            
            // リストに追加
            parameter.put(parameter_name, new Integer(1));
            
            
        }
    }
    
    
    /**
     * リンクを追加
     * @param node_name リンク先の名前
     */
    protected void addLinkTo(String node_name){
        
        // 既に存在するパラメータの
        if (link.get(node_name) != null) {

            // その場所をインクリメント
            Integer num = (Integer) link.get(node_name);
            int newnum = num.intValue() + 1;
            
            link.remove(node_name);
            link.put(node_name, new Integer(newnum));

        }

        
        // 初めてのパラメータ
        else if (link.get(node_name) == null) {
            
            // リストに追加
            link.put(node_name, new Integer(1));
            
            
        }        
        
    }
    
    
    /**
     * 伸びているリンクを返す
     * @return
     */
    public  Enumeration<String> getAllLinkNames(){
        
        return link.keys();
        
    }
    
    /**
     * 保持しているパラメータを返す
     * @return
     */
    public Enumeration<String> getAllParameter(){
        
        
        return parameter.keys();
        
    }
    
    
    /**
     * 指定したノードへの遷移確率を返す
     * @param node_name
     * @return
     */
    public float getLinkProbability(String node_name){
        
        int total = 0;
        int want  = 0;
        
        for(Enumeration e = link.keys(); e.hasMoreElements();){
            
            String _key = (String)e.nextElement();
            
            // 回数
            if(_key.equals(node_name))
                want = ((Integer)link.get(_key)).intValue();
                
            // 合計
            total += ((Integer)link.get(_key)).intValue();
            
            
        }
        
        
        
        return (float)want/total;
        
    }
    
    
    /**
     * 指定したパラメータの確率
     * @param parameter_name
     * @return
     */
    public float getParameterProbability(String parameter_name){
        
       int total = 0;
       int want  = 0;
       
       for(Enumeration e = parameter.keys(); e.hasMoreElements();){
           
           String _key = (String)e.nextElement();
           
           
           if(_key.equals(parameter_name))
               want = ((Integer)parameter.get(_key)).intValue();
               
           
           total += ((Integer)parameter.get(_key)).intValue();
           
           
       }
       
       
       
       return (float)want/total;
        
    }

    /**
     * パラメータの軸の数を返す
     * @return
     */
    protected int getParameterSize(){
        
        return parameter.size();
        
    }
    

    /**
     * リンク数を返す
     * @return
     */
    protected int getLinkSize(){
        
        return link.size();
        
    }
    
    /**
     * ノード名を返す
     * @return ノード名を返す
     */
    public String getNodeName(){
        return name;
    }
    
    
    
    /**
     * 
     * @param parameter_name
     * @return
     */
    public String toString(){
        
        
        StringBuffer buffer = new StringBuffer();
       
       for(Enumeration e = parameter.keys(); e.hasMoreElements();){
           
           String _key = (String)e.nextElement();
           
           int want = ((Integer)parameter.get(_key)).intValue();
               
           
           buffer.append(_key+":"+want+"\n");
           
       }
       
       
       return buffer.toString();
       
        
    }

}
