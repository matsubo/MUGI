/*
 * Created on 2004/12/08
 *
 * $Id: JudgeMovement.java,v 1.6 2005/01/11 07:56:36 matsu Exp $
 * 行動履歴から，ユーザの行動状態を判断する
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer;

import jp.ac.keio.sfc.ht.matsu.mugi.locator.history.HistoryLogger;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.history.NoSuchHistoryException;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;

/**
 * @author matsu
 * 
 * 時速と秒速の変換
 * <ul>
 * <li>時速60km(16.666m/s)</li>
 * <li>時速90km(25m/s)</li>
 * <li>時速5km (1.388m/s)</li>
 * <li>calc;90000/60/60</li>
 * </ul>
 * 
 * 座標と距離変換
 * <ul>
 * <li>緯度 1秒=約31m</li>
 * <li>経度 1秒=約25m</li>
 * </ul>
 */
public class JudgeMovement {

    private ActivityStateChangeEventListener listener;

    private HistoryLogger logger = null;

    private int current_state = MovementStateEvent.NONE;

    public JudgeMovement() {
        logger = HistoryLogger.getInstance();
    }

    public void currentPosition(GeoPoint location) {

        try {


            /* ********** 判断 *********** */
            int heikin_log_num;
            double diff;
            GeoPoint prev_location;
            
            /* ********** 止まっているか判断 *********** */
            heikin_log_num = 8;
            prev_location = logger.getPrevious(heikin_log_num + 1);
            
            // 移動距離を求める
            diff = location.getPoint().distance(prev_location.getPoint()); // From niya
            
            // 1秒の移動平均
            diff = diff/heikin_log_num;
            
            
            // 移動距離を出力するにはコメントアウト
            //System.out.println(diff);
            
            if (diff <= 0.8)
                this.notify(MovementStateEvent.STAYING, location);
            else
                this.notify(MovementStateEvent.MOVING, prev_location);
            
            
            

        } catch (NoSuchHistoryException e) {
            // 要求した履歴がないときにエラー
            // ひとまずOFF
            // e.printStackTrace();
        }

    }

    /**
     * リスナへ通知
     * 
     * @param new_state
     */
    private void notify(int new_state, GeoPoint location) {

        // リスナへ通知
        if (listener != null) {

            if (current_state != new_state) {

                // 前回の状態と変化したときだけ
                listener.activityStateChangeEvent(new MovementStateEvent(this,
                        new_state, location));
            }

            current_state = new_state;
        }

    }

    /**
     * リスナー登録
     * 
     * @param listener
     */
    public void addActivityStateChangeEventListener(
            ActivityStateChangeEventListener listener) {
        this.listener = listener;
    }

}
