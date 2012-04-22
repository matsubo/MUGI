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
 * HMMを保存，読み込みを行うクラス
 * 
 */
public class HMMManager {

    public static final String filename = "serialized.dat";

    /**
     * 保存
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

	        // 保存されたファイルがなければ
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
     * テスト
     * 
     * @param args
     */
    public static void main(String[] args) {

        try {
            HMM hmm = HMMManager.load();

            hmm.learn(new Dataset("レストラン", "デニーズ"));
            hmm.link("レストラン", "カフェ");
            hmm.learn(new Dataset("カフェ", "スターバックス"));
            hmm.link("レストラン", "特別");
            hmm.learn(new Dataset("特別", "自宅"));
            hmm.link("特別", "特別");
            hmm.learn(new Dataset("特別", "SFC"));
            hmm.link("特別", "レストラン");
            hmm.learn(new Dataset("レストラン", "アローム"));
            hmm.link("楽器", "GEO");
            hmm.learn(new Dataset("楽器", "HMV"));
            hmm.link("楽器", "特別");
            hmm.learn(new Dataset("特別", "自宅"));

            //Log.debug(hmm);

            HMMManager.save(hmm);
            
            
            System.out.println(new File("serialized.dat").length());
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
