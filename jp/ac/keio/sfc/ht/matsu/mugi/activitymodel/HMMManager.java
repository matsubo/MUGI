/*
 * Created on 2004/12/20
 *
 * $Id: HMMManager.java,v 1.5 2005/01/21 03:19:10 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.activitymodel;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.Dataset;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.HMM;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

/**
 * @author matsu
 * 
 * HMM��ۑ��C�ǂݍ��݂��s���N���X
 * 
 */
public class HMMManager {

    public static final String filename = "serialized.dat";

    /**
     * �ۑ�
     * 
     */
    public synchronized static void save(HMM hmm) {

        try {
            FileOutputStream f = new FileOutputStream(filename);
            ObjectOutput s = new ObjectOutputStream(f);
            s.writeObject(hmm);
            s.flush();
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    /**
     * HMM
     * 
     * @return
     */
    public synchronized static HMM load() throws Exception {

        HMM hmm = null;

        try{
	        FileInputStream in = new FileInputStream(filename);
	        ObjectInputStream s = new ObjectInputStream(in);
	        hmm = (HMM) s.readObject();

	        // �ۑ����ꂽ�t�@�C�����Ȃ����
        }catch(FileNotFoundException f){
            f.printStackTrace();
            hmm = new HMM();
        }catch(EOFException e){
            e.printStackTrace();
            hmm = new HMM();
        }
        
        return hmm;

    }

    /**
     * �e�X�g
     * 
     * @param args
     */
    public static void main(String[] args) {

        try {
            HMM hmm = HMMManager.load();

            hmm.learn(new Dataset("���X�g����", "�f�j�[�Y"));
            hmm.link("���X�g����", "�J�t�F");
            hmm.learn(new Dataset("�J�t�F", "�X�^�[�o�b�N�X"));
            hmm.link("���X�g����", "����");
            hmm.learn(new Dataset("����", "����"));
            hmm.link("����", "����");
            hmm.learn(new Dataset("����", "SFC"));
            hmm.link("����", "���X�g����");
            hmm.learn(new Dataset("���X�g����", "�A���[��"));
            hmm.link("�y��", "GEO");
            hmm.learn(new Dataset("�y��", "HMV"));
            hmm.link("�y��", "����");
            hmm.learn(new Dataset("����", "����"));

            //Log.debug(hmm);

            HMMManager.save(hmm);
            
            
            System.out.println(new File("serialized.dat").length());
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
