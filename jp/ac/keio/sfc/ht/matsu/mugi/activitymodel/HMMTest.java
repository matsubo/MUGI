/*
 * Created on 2004/12/22
 *
 * $Id: HMMTest.java,v 1.7 2005/01/21 03:19:11 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.activitymodel;

import java.io.File;

import jp.ac.keio.sfc.ht.matsu.mugi.Choco;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.Dataset;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.HMM;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

/**
 * @author matsu
 * 
 */
public class HMMTest {

    public HMMTest() {

        try {

            HMM hmm = HMMManager.load();
            File file = new File("serialized.dat");
            
            for (int i = 0; i < 588; i++) {
                
                

                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","ビッグボーイ"));hmm.link("a_ahc","a_agcx");hmm.learn(new Dataset("a_agcx","ミネボール"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","ミネボール"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahb");hmm.learn(new Dataset("a_ahb","サークルＫ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahb","サークルＫ"));hmm.link("a_ahb","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","サイゼリア"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","サイゼリア"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","すき家"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","里のうどん"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","里のうどん"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","サイゼリア"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","サイゼリア"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","吉野家"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","吉野家"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","ガスト"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","ガスト"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_acbb","湘南台駅"));hmm.link("a_acbb","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","辰巳屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","辰巳屋"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","吉野家"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","吉野家"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","湘南台駅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","ラ・パウザ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","ラ・パウザ"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcl");hmm.learn(new Dataset("a_agcl","みずほ銀行"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcl","みずほ銀行"));hmm.link("a_agcl","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_agch");hmm.learn(new Dataset("a_agch","有隣堂"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agch","有隣堂"));hmm.link("a_agch","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","木の子"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","すき家"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","湘南台駅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","湘南台駅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_acbb","湘南台駅"));hmm.link("a_acbb","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","すき家"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","すき家"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","すき家"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","すし音頭"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","すし音頭"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","ラ・パウザ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","ラ・パウザ"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","吉野家"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","吉野家"));hmm.link("a_ahd","a_agcx");hmm.learn(new Dataset("a_agcx","コジマ電気"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","コジマ電気"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","コジマ電気"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","看護医療学部"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","看護医療学部"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","コメダ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","ラーメン屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","ラーメン屋"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","焼肉屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","焼肉屋"));hmm.link("a_ahc","a_agaf");hmm.learn(new Dataset("a_agaf","郵便局"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agaf","郵便局"));hmm.link("a_agaf","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_agcn");hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","木の子"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","木の子"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","コメダ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","コメダ"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcn");hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcn");hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","コメダ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","コメダ"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","辰巳屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","辰巳屋"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcn");hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","湘南台駅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","アローム"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","アローム"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","八田"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","八田"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","うお屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","うお屋"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","湘南台駅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_acbb","湘南台駅"));hmm.link("a_acbb","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","コメダ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","コメダ"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_agcf");hmm.learn(new Dataset("a_agcf","クリーニング屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcf","クリーニング屋"));hmm.link("a_agcf","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","タイ料理屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","タイ料理屋"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","焼き肉ざんまい"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","焼き肉ざんまい"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","飲み屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","ガスト"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","ガスト"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","ドトール"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","トドール"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","タージマハール"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","タージマハール"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_agcx");hmm.learn(new Dataset("a_agcx","コジマ電気"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","コジマ電気"));hmm.link("a_agcx","a_ahd");hmm.learn(new Dataset("a_ahd","マクドナルド"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","マクドナルド"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","すき家"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","すき家"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","ラ・パウザ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","ラ・パウザ"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","辰巳屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","コメダ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","コメダ"));hmm.link("a_ahd","a_agcx");hmm.learn(new Dataset("a_agcx","ダイソー"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","ダイソー"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","ガスト"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","ガスト"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_agcx");hmm.learn(new Dataset("a_agcx","秋葉台文化体育館"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","秋葉台文化体育館"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","吉野家"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","吉野家"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","べご"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","べご"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","タージマハール"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","タージマハール"));hmm.link("a_ahc","a_agcn");hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","すし屋"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","すし屋"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","コメダ"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","タージマハール"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","タージマハール"));hmm.link("a_ahc","a_ahc");hmm.learn(new Dataset("a_ahc","イタリア料理"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","イタリア料理"));hmm.link("a_ahc","a_agcx");hmm.learn(new Dataset("a_agcx","テニスコート"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","テニスコート"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","湘南台駅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_acbb","湘南台駅"));hmm.link("a_acbb","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","入舟"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","入船"));hmm.link("a_ahc","a_agcn");hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","イトーヨーカドー"));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","SFC"));hmm.link("a_ahc","a_ahc");hmm.learn(new Dataset("a_ahc","ペピタライオン"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","ペピタライオン"));hmm.link("a_ahc","a_ahd");hmm.learn(new Dataset("a_ahd","スターバックス"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","スターバックス"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","コメダ"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcx");hmm.learn(new Dataset("a_agcx","秋葉台文化体育館"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","秋葉台文化体育館"));hmm.link("a_agcx","a_ahc");hmm.learn(new Dataset("a_ahc","木の子"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","木の子"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","自宅"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","自宅"));hmm.link("special","a_ahb");hmm.learn(new Dataset("a_ahb","サークルＫ"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahb","サークルＫ"));hmm.link("a_ahb","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);

                
                
                //Log.debug(hmm.getStat());
                
                
                
                
                
                
                long before = System.currentTimeMillis();
                Choco main = HMMAlgorithm.getInstance();
                Dataset dataset = main.getNextProb("a_ahc");
                long after = System.currentTimeMillis();
                
                //System.out.print("ログ数");
                System.out.print((i+1)*177+"\t");
                
                //System.out.print("処理時間");
                System.out.println(after-before);
                
                //System.out.println("filesize:"+new File("serialized.dat").length());
               
                //System.out.println(hmm.getNode("special").toString());
                
                
                
//                System.out.println(dataset.getNodeName());
//                System.out.println(dataset.getParameterName());                
//                System.out.println(dataset.getProbability());                
//                

                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new HMMTest();

    }
}
