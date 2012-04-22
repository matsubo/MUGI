/*
 * Created on 2004/12/08
 *
 * $Id: Dataset.java,v 1.2 2005/01/20 11:48:11 matsu Exp $
 * 場所の属性保存
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm;

/**
 * @author matsu
 * 
 */
public class Dataset {

    private String node_name;

    private String parameter_name;
    
    double probability = 0.0;

    /**
     * コンストラクタ
     * 
     * @param node_name ノード名
     * @param parameter_name パラメータ名
     */
    public Dataset(String node_name, String parameter_name) {

        this.node_name = node_name;
        this.parameter_name = parameter_name;

    }

    public String getNodeName() {
        return node_name;
    }

    public void setNodeName(String node_name) {
        this.node_name = node_name;
    }

    public String getParameterName() {
        return parameter_name;
    }

    public void setParameterName(String parameter_name) {
        this.parameter_name = parameter_name;
    }
    
    public void setProbability(double prob){
        this.probability = prob;
    }
    
    public double getProbability(){
        return probability;
    }
}
