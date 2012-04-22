/*
 * Created on 2004/12/08
 *
 * $Id: HMM.java,v 1.6 2005/01/20 08:05:03 matsu Exp $
 * 
 * ���f���Ǘ���
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.HMMManager;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

/**
 * @author matsu
 * 
 * Memo: �����N�̓m�[�h�ŊǗ�����
 * 
 */
public class HMM implements Serializable {

    private static final long serialVersionUID = 3258413949769953587L;

    /** �m�[�h�ێ� (�m�[�h��,�m�[�h) */
    private Hashtable<String, HMMNode> nodes = new Hashtable<String, HMMNode>();

    
    public HMM(){
    }

    /**
     * �m�[�h�𐶐�
     * 
     * @param dataset
     *            �f�[�^�Z�b�g
     */
    public void learn(Dataset dataset) {

        // �����̏ꏊ��������,�񐔂�ǉ�
        if (nodes.get(dataset.getNodeName()) != null) {

            HMMNode _node = nodes.get(dataset.getNodeName());
            _node.addParameter(dataset.getParameterName());

            nodes.remove(dataset.getNodeName());
            nodes.put(dataset.getNodeName(), _node);

            // �V�����ꏊ��������C�ǉ�
        } else {
            HMMNode new_node = new HMMNode(dataset.getNodeName());
            new_node.addParameter(dataset.getParameterName());

            nodes.put(dataset.getNodeName(), new_node);
        }
        
        
        

    }

    /**
     * �����N���\�z
     * 
     * @param from
     *            �����N�쐬��
     * @param to
     *            �����N�쐬��
     */
    public void link(String from, String to) {

        HMMNode _node = nodes.get(from);

        // �m�[�h�����݂�����
        if (_node != null)
            _node.addLinkTo(to);

    }
    
    public HMMNode getNode(String nodename) throws NoSuchElementException{
        
        
        if(nodes.get(nodename) == null)
            throw new NoSuchElementException(nodename);
        
        return  nodes.get(nodename);
        
    }
    

    /**
     * �m�[�h�Ԃ̃����N����Ԃ�
     * @return
     */
    public int getAllParameterNum(){
        
        int size = 0;
        
        // �p�����[�^��
        for (Enumeration e = nodes.elements(); e.hasMoreElements();) {

            // buffer.append(e.nextElement() + "\n");

            HMMNode _node = (HMMNode) e.nextElement();
            size += _node.getParameterSize();
        }
        
        return size;
        
    }
    
    /**
     * �m�[�h�Ԃ̃����N����Ԃ�
     * @return
     */
    public int getAllLinkNum(){
        
        int size = 0;
        
        // �p�����[�^��
        for (Enumeration e = nodes.elements(); e.hasMoreElements();) {

            // buffer.append(e.nextElement() + "\n");

            HMMNode _node = (HMMNode) e.nextElement();
            size += _node.getLinkSize();
        }
        
        return size;
        
    }
    
    
    /**
     * ���ׂẴf�[�^��Ԃ�
     * @return
     */
    public Hashtable getAllNodes(){
        return nodes;
    }
    
    /**
     * �m�[�h����Ԃ�
     * @return
     */
    public int getNodeSize(){
        return nodes.size();
    }
    
    /**
     * �m�[�h���E�p�����[�^���E�����N����Ԃ��i�]���p�j
     * @return
     */
    public String getStat(){
        return this.getNodeSize()+"\t"+this.getAllParameterNum()+"\t"+this.getAllLinkNum();
    }

    /**
     * �f�o�b�O�o��
     * 
     */
    public String toString() {

        StringBuffer buffer = new StringBuffer("\n");

        for (Enumeration e = nodes.elements(); e.hasMoreElements();) {

            // buffer.append(e.nextElement() + "\n");

            HMMNode _node = (HMMNode) e.nextElement();

            buffer.append("*" + _node.getNodeName() + "\n");

            for (Enumeration ep = _node.getAllLinkNames(); ep.hasMoreElements();) {
                try {
                    String _link = (String) ep.nextElement();
                    buffer.append("+ " + _link + " ("
                            + _node.getLinkProbability(_link) + ") \n");
                } catch (NoSuchElementException ns) {
                    ns.printStackTrace();
                }
            }

            buffer.append("\n");

            for (Enumeration ep = _node.getAllParameter(); ep.hasMoreElements();) {
                try {
                    String _param = (String) ep.nextElement();
                    buffer.append("-" + _param + "   ("
                            + _node.getParameterProbability(_param) + ")\n");
                } catch (NoSuchElementException ns) {
                    ns.printStackTrace();
                }
            }

        }

        return buffer.toString();

    }

    /**
     * �e�X�g
     * 
     * @param args
     */
    public static void main(String args[]) {

        try {
            HMM hmm = HMMManager.load();

            hmm.learn(new Dataset("special", "SFC"));
            hmm.link("special", "a_ahcg");
            hmm.learn(new Dataset("a_ahcg", "�r�b�O�{�[�C"));
            hmm.learn(new Dataset("a_ahcg", "�r�b�O�{�[�C"));
            hmm.link("a_ahcg", "a_agcx");
            hmm.learn(new Dataset("a_agcx", "�~�l�{�[��"));

            HMMManager.save(hmm);

            Log.debug(hmm);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
