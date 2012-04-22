/*
 * Created on 2004/12/08
 *
 * $Id: HMMNode.java,v 1.4 2005/01/21 03:19:10 matsu Exp $
 * HMM�̃m�[�h
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

    /** �m�[�h�� */
    private String name;

    /** �p�����[�^ <�p�����[�^��,��> */
    private Hashtable<String, Integer> parameter = new Hashtable<String, Integer>();
    
    /** �����N <�����N��,��>*/
    private Hashtable<String, Integer> link      = new Hashtable<String, Integer>();
    
    

    /**
     * �R���X�g���N�^
     * 
     * @param name �m�[�h��
     */
    protected HMMNode(String name) {
        this.name = name;
    }
    
    

    /**
     * �����ǉ��܂��́C�����J�E���g�A�b�v
     */
    protected void addParameter(String parameter_name) {

        // ���ɑ��݂���p�����[�^��
        if (parameter.get(parameter_name) != null) {

            // ���̏ꏊ���C���N�������g
            Integer num = (Integer) parameter.get(parameter_name);
            int newnum = num.intValue() + 1;
            
            parameter.remove(parameter_name);
            parameter.put(parameter_name, new Integer(newnum));

        }

        
        // ���߂Ẵp�����[�^
        else{
            
            // ���X�g�ɒǉ�
            parameter.put(parameter_name, new Integer(1));
            
            
        }
    }
    
    
    /**
     * �����N��ǉ�
     * @param node_name �����N��̖��O
     */
    protected void addLinkTo(String node_name){
        
        // ���ɑ��݂���p�����[�^��
        if (link.get(node_name) != null) {

            // ���̏ꏊ���C���N�������g
            Integer num = (Integer) link.get(node_name);
            int newnum = num.intValue() + 1;
            
            link.remove(node_name);
            link.put(node_name, new Integer(newnum));

        }

        
        // ���߂Ẵp�����[�^
        else if (link.get(node_name) == null) {
            
            // ���X�g�ɒǉ�
            link.put(node_name, new Integer(1));
            
            
        }        
        
    }
    
    
    /**
     * �L�тĂ��郊���N��Ԃ�
     * @return
     */
    public  Enumeration<String> getAllLinkNames(){
        
        return link.keys();
        
    }
    
    /**
     * �ێ����Ă���p�����[�^��Ԃ�
     * @return
     */
    public Enumeration<String> getAllParameter(){
        
        
        return parameter.keys();
        
    }
    
    
    /**
     * �w�肵���m�[�h�ւ̑J�ڊm����Ԃ�
     * @param node_name
     * @return
     */
    public float getLinkProbability(String node_name){
        
        int total = 0;
        int want  = 0;
        
        for(Enumeration e = link.keys(); e.hasMoreElements();){
            
            String _key = (String)e.nextElement();
            
            // ��
            if(_key.equals(node_name))
                want = ((Integer)link.get(_key)).intValue();
                
            // ���v
            total += ((Integer)link.get(_key)).intValue();
            
            
        }
        
        
        
        return (float)want/total;
        
    }
    
    
    /**
     * �w�肵���p�����[�^�̊m��
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
     * �p�����[�^�̎��̐���Ԃ�
     * @return
     */
    protected int getParameterSize(){
        
        return parameter.size();
        
    }
    

    /**
     * �����N����Ԃ�
     * @return
     */
    protected int getLinkSize(){
        
        return link.size();
        
    }
    
    /**
     * �m�[�h����Ԃ�
     * @return �m�[�h����Ԃ�
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
