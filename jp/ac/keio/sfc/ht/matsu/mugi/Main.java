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

    /** 訪問場所判定モジュール */
    private JudgeMovement judge = null;

    private HMM hmm = null;

    private static Main main = new Main();

    /**
     * メイン処理
     * 
     */
    private Main() {

        // 位置情報取得
         FileGPSReader reader = new FileGPSReader();
        //EtrexGPSReader reader = new EtrexGPSReader();

        reader.addGPSListener(this);

        // 行動状態判断
        judge = new JudgeMovement();
        judge.addActivityStateChangeEventListener(this);

        // 行動モデル部コンストラクト
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
     * 1.位置情報のupdateを受け取る
     * 
     * @see jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.GPSReaderListener#locateionEvent(jp.ac.keio.sfc.ht.matsu.mugi.locator.CoordinateEvent)
     */
    public void locateionEvent(CoordinateEvent coordiante_event) {

        // 行動状態判断部へ投げる
        judge.currentPosition(coordiante_event.getCoordinate());

    }

    /**
     * 2.行動状態のupdateを受け取る
     * 
     * @see jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.ActivityStateChangeEventListener#activityStateChangeEvent(jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.MovementStateEvent)
     */
    public void activityStateChangeEvent(MovementStateEvent event) {

        // 動き出したとき
        if (event.getState() == MovementStateEvent.MOVING) {

            // デバッグメッセージ
            Log.info("行動開始 at 緯度:" + event.getLocation().getLatitude() + " 経度:"
                    + event.getLocation().getLongitude());

        }
        // 止まったとき
        else if (event.getState() == MovementStateEvent.STAYING) {

            // デバッグメッセージ
            Log.info("滞在開始 at 緯度:" + event.getLocation().getLatitude() + " 経度:"
                    + event.getLocation().getLongitude());

            // 場所の属性を調べる
            LocationInformationGetter getter = (LocationInformationGetter) new MappleLocationInformation();

            try {
                Dataset place = getter.getAttribute(event.getLocation());

                // 取得した場所の属性
                //Log.info(place.getNodeName() + " " + place.getParameterName());

                // モデルへ入れる
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
     * テスト
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
