/*
 * Created on 2004/12/08
 *
 * $Id: AverageSpeedTest.java,v 1.2 2005/01/20 03:20:28 matsu Exp $
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator;

import jp.ac.keio.sfc.ht.matsu.mugi.Choco;
import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.Dataset;
import jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.JudgeMovement;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.FileGPSReader;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.GPSReaderListener;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

/**
 * @author matsu
 * 
 */
public class AverageSpeedTest implements GPSReaderListener ,Choco{

    /** 訪問場所判定モジュール */
    private JudgeMovement judge = null;

    private static AverageSpeedTest main = new AverageSpeedTest();

    /**
     * メイン処理
     * 
     */
    private AverageSpeedTest() {

        // 位置情報取得
        // TestGPSReader reader = new TestGPSReader();
        FileGPSReader reader = new FileGPSReader();
        // EtrexGPSReader reader = new EtrexGPSReader();

        reader.addGPSListener(this);

        // 行動状態判断
        judge = new JudgeMovement();
        //judge.addActivityStateChangeEventListener(this);

    }

    /**
     * Singleton
     * 
     * @return
     */
    public static Choco getInstance() {

        return (Choco) main;

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

    /*
     * (non-Javadoc)
     * 
     * @see jp.ac.keio.sfc.ht.matsu.mugi.Mugi#getNextProb(java.lang.String)
     */
    public Dataset getNextProb(String place) {
        return null;
    }

    /**
     * テスト
     * 
     * @param args
     */
    public static void main(String args[]) {

        Log.debug("<!-- Starting..");
        Choco mugi = AverageSpeedTest.getInstance();
        Log.debug("-->");

    }

}
