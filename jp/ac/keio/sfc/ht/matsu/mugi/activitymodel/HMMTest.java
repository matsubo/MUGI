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
                
                

                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�r�b�O�{�[�C"));hmm.link("a_ahc","a_agcx");hmm.learn(new Dataset("a_agcx","�~�l�{�[��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","�~�l�{�[��"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahb");hmm.learn(new Dataset("a_ahb","�T�[�N���j"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahb","�T�[�N���j"));hmm.link("a_ahb","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�T�C�[���A"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�T�C�[���A"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","������"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","���̂��ǂ�"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","���̂��ǂ�"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�T�C�[���A"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�T�C�[���A"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�g���"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�g���"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�K�X�g"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�K�X�g"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_acbb","�Ó��w"));hmm.link("a_acbb","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�C����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�C����"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�g���"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�g���"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","�Ó��w"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","���E�p�E�U"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","���E�p�E�U"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcl");hmm.learn(new Dataset("a_agcl","�݂��ً�s"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcl","�݂��ً�s"));hmm.link("a_agcl","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_agch");hmm.learn(new Dataset("a_agch","�L�ד�"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agch","�L�ד�"));hmm.link("a_agch","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�؂̎q"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","������"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","�Ó��w"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","�Ó��w"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_acbb","�Ó��w"));hmm.link("a_acbb","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","������"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","������"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","������"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","��������"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","��������"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","���E�p�E�U"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","���E�p�E�U"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�g���"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�g���"));hmm.link("a_ahd","a_agcx");hmm.learn(new Dataset("a_agcx","�R�W�}�d�C"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","�R�W�}�d�C"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","�R�W�}�d�C"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","�Ō��Êw��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","�Ō��Êw��"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�R���_"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","���[������"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","���[������"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�ē���"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�ē���"));hmm.link("a_ahc","a_agaf");hmm.learn(new Dataset("a_agaf","�X�֋�"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agaf","�X�֋�"));hmm.link("a_agaf","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_agcn");hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�؂̎q"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�؂̎q"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�R���_"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�R���_"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcn");hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcn");hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�R���_"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�R���_"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�C����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�C����"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcn");hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","�Ó��w"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�A���[��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�A���[��"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","���c"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","���c"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","������"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","������"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","�Ó��w"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_acbb","�Ó��w"));hmm.link("a_acbb","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�R���_"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�R���_"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_agcf");hmm.learn(new Dataset("a_agcf","�N���[�j���O��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcf","�N���[�j���O��"));hmm.link("a_agcf","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�^�C������"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�^�C������"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�Ă�������܂�"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�Ă�������܂�"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","���݉�"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�K�X�g"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�K�X�g"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�h�g�[��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�g�h�[��"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�^�[�W�}�n�[��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�^�[�W�}�n�[��"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_agcx");hmm.learn(new Dataset("a_agcx","�R�W�}�d�C"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","�R�W�}�d�C"));hmm.link("a_agcx","a_ahd");hmm.learn(new Dataset("a_ahd","�}�N�h�i���h"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�}�N�h�i���h"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","������"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","������"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","���E�p�E�U"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","���E�p�E�U"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�C����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�R���_"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�R���_"));hmm.link("a_ahd","a_agcx");hmm.learn(new Dataset("a_agcx","�_�C�\�["));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","�_�C�\�["));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�K�X�g"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�K�X�g"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_agcx");hmm.learn(new Dataset("a_agcx","�H�t�䕶���̈��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","�H�t�䕶���̈��"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahd");hmm.learn(new Dataset("a_ahd","�g���"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�g���"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�ׂ�"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�ׂ�"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�^�[�W�}�n�[��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�^�[�W�}�n�[��"));hmm.link("a_ahc","a_agcn");hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","������"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","������"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�R���_"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","�^�[�W�}�n�[��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�^�[�W�}�n�[��"));hmm.link("a_ahc","a_ahc");hmm.learn(new Dataset("a_ahc","�C�^���A����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�C�^���A����"));hmm.link("a_ahc","a_agcx");hmm.learn(new Dataset("a_agcx","�e�j�X�R�[�g"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","�e�j�X�R�[�g"));hmm.link("a_agcx","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_acbb");hmm.learn(new Dataset("a_acbb","�Ó��w"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_acbb","�Ó��w"));hmm.link("a_acbb","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahc");hmm.learn(new Dataset("a_ahc","���M"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","���D"));hmm.link("a_ahc","a_agcn");hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcn","�C�g�[���[�J�h�["));hmm.link("a_agcn","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","SFC"));hmm.link("a_ahc","a_ahc");hmm.learn(new Dataset("a_ahc","�y�s�^���C�I��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�y�s�^���C�I��"));hmm.link("a_ahc","a_ahd");hmm.learn(new Dataset("a_ahd","�X�^�[�o�b�N�X"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�X�^�[�o�b�N�X"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahd","�R���_"));hmm.link("a_ahd","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","SFC"));hmm.link("special","a_agcx");hmm.learn(new Dataset("a_agcx","�H�t�䕶���̈��"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_agcx","�H�t�䕶���̈��"));hmm.link("a_agcx","a_ahc");hmm.learn(new Dataset("a_ahc","�؂̎q"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahc","�؂̎q"));hmm.link("a_ahc","special");hmm.learn(new Dataset("special","����"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("special","����"));hmm.link("special","a_ahb");hmm.learn(new Dataset("a_ahb","�T�[�N���j"));Thread.sleep(10);HMMManager.save(hmm);
                hmm = HMMManager.load();hmm.learn(new Dataset("a_ahb","�T�[�N���j"));hmm.link("a_ahb","special");hmm.learn(new Dataset("special","SFC"));Thread.sleep(10);HMMManager.save(hmm);

                
                
                //Log.debug(hmm.getStat());
                
                
                
                
                
                
                long before = System.currentTimeMillis();
                Choco main = HMMAlgorithm.getInstance();
                Dataset dataset = main.getNextProb("a_ahc");
                long after = System.currentTimeMillis();
                
                //System.out.print("���O��");
                System.out.print((i+1)*177+"\t");
                
                //System.out.print("��������");
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
