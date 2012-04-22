/*
 * Created on 2004/12/08
 *
 * $Id: Main.java,v 1.15 2005/01/20 07:51:27 matsu Exp $
 */
package jp.ac.keio.sfc.ht.matsu.mugi;

import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.HMMAlgorithm;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.HMMManager;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.Dataset;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.HMM;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.ActivityStateChangeEventListener;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.JudgeMovement;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.MovementStateEvent;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.LocationInformationGetter;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.MappleLocationInformation;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.NoClosePlaceException;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.CoordinateEvent;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.FileGPSReader;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.GPSReaderListener;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

/**
 * @author matsu
 * 
 */
public class Main implements GPSReaderListener,
        ActivityStateChangeEventListener{

    /** �K��ꏊ���胂�W���[�� */
    private JudgeMovement judge = null;

    private HMM hmm = null;

    private static Main main = new Main();

    /**
     * ���C������
     * 
     */
    private Main() {

        // �ʒu���擾
         FileGPSReader reader = new FileGPSReader();
        //EtrexGPSReader reader = new EtrexGPSReader();

        reader.addGPSListener(this);

        // �s����Ԕ��f
        judge = new JudgeMovement();
        judge.addActivityStateChangeEventListener(this);

        // �s�����f�����R���X�g���N�g
        try {
            hmm = HMMManager.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Singleton
     * 
     * @return
     */
    public static Choco getInstance() {

        return HMMAlgorithm.getInstance();

    }

    /**
     * 1.�ʒu����update���󂯎��
     * 
     * @see jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.GPSReaderListener#locateionEvent(jp.ac.keio.sfc.ht.matsu.mugi.locator.CoordinateEvent)
     */
    public void locateionEvent(CoordinateEvent coordiante_event) {

        // �s����Ԕ��f���֓�����
        judge.currentPosition(coordiante_event.getCoordinate());

    }

    /**
     * 2.�s����Ԃ�update���󂯎��
     * 
     * @see jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.ActivityStateChangeEventListener#activityStateChangeEvent(jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.MovementStateEvent)
     */
    public void activityStateChangeEvent(MovementStateEvent event) {

        // �����o�����Ƃ�
        if (event.getState() == MovementStateEvent.MOVING) {

            // �f�o�b�O���b�Z�[�W
            Log.info("�s���J�n at �ܓx:" + event.getLocation().getLatitude() + " �o�x:"
                    + event.getLocation().getLongitude());

        }
        // �~�܂����Ƃ�
        else if (event.getState() == MovementStateEvent.STAYING) {

            // �f�o�b�O���b�Z�[�W
            Log.info("�؍݊J�n at �ܓx:" + event.getLocation().getLatitude() + " �o�x:"
                    + event.getLocation().getLongitude());

            // �ꏊ�̑����𒲂ׂ�
            LocationInformationGetter getter = (LocationInformationGetter) new MappleLocationInformation();

            try {
                Dataset place = getter.getAttribute(event.getLocation());

                // �擾�����ꏊ�̑���
                //Log.info(place.getNodeName() + " " + place.getParameterName());

                // ���f���֓����
                hmm.learn(place);
                //Log.debug(hmm);
                HMMManager.save(hmm);

            } catch (NoClosePlaceException e) {
                // e.printStackTrace();
                Log.warn("Could not find a near place.");
            }

        }

    }


    /**
     * �e�X�g
     * 
     * @param args
     */
    public static void main(String args[]) {

        Log.debug("<!-- Starting..");
        Choco choco = Main.getInstance();
        
        Dataset result = choco.getNextProb("a_acbb");
        Log.debug(result.getNodeName());
        Log.debug(result.getParameterName());
        
        Log.debug("-->");

    }

}
