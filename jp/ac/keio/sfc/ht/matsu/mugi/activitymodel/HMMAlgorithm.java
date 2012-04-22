/*
 * Created on 2005/01/20
 *
 * $Id: HMMAlgorithm.java,v 1.3 2005/01/21 03:19:11 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.activitymodel;

import java.util.Enumeration;

import jp.ac.keio.sfc.ht.matsu.mugi.Choco;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.Dataset;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.HMM;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.HMMNode;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;



/**
 * @author matsu
 * 
 */
public class HMMAlgorithm implements Choco {

    private HMM hmm = null;

    
    private static HMMAlgorithm thisobject = new HMMAlgorithm();
    
    private HMMAlgorithm() {


    }
    
    public static Choco getInstance(){
        
        return thisobject;
        
    }

    /*
     * (non-Javadoc)
     * 
     * @see jp.ac.keio.sfc.ht.matsu.mugi.Choco#getNextProb(java.lang.String)
     */
    public Dataset getNextProb(String param) {
        
        
        try {
            hmm = HMMManager.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        HMMNode node =  hmm.getNode(param);
        //Log.debug(node.getNodeName());
        
        // 返却するデータ
        Dataset returndata = new Dataset("","");
        
        // もっともよい確率
        double probability = 0.0;
        
        
        
        // 1つめのノードからのリンク
        for(Enumeration  e = node.getAllLinkNames() ; e.hasMoreElements(); ){
            
            String link_node_name = (String)e.nextElement();
            
//          SPecialなら除外
            if(link_node_name.equals("special"))
                break;
            
            double node_link = node.getLinkProbability(link_node_name);
            
            HMMNode node2 = hmm.getNode(link_node_name);
            
            //Log.debug(link_node_name);
            
            
            
            
            
            for(Enumeration e2 = node2.getAllParameter(); e2.hasMoreElements();){
                
                String parameter_name = (String)e2.nextElement();
                double parameter_probability = node2.getParameterProbability(parameter_name);
                
                double this_probability = node_link * parameter_probability;
                
                // 確率が高ければ値を保存
                if(this_probability > probability){
                    probability = this_probability;
                    returndata.setNodeName(link_node_name);
                    returndata.setParameterName(parameter_name);
                    returndata.setProbability(probability);
                }
                
            }
            
        }
        
        

        return returndata;
    }

    /**
     * CHOCOの使い方
     * @param args
     */
    public static void main(String args[]) {

        Choco main = HMMAlgorithm.getInstance();
        Dataset dataset = main.getNextProb("special");
        
        
        System.out.println(dataset.getNodeName());
        System.out.println(dataset.getParameterName());
        

    }

}
