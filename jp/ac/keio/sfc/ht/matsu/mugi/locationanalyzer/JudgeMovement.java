/*
 * Created on 2004/12/08
 *
 * $Id: JudgeMovement.java,v 1.6 2005/01/11 07:56:36 matsu Exp $
 * �s����������C���[�U�̍s����Ԃ𔻒f����
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer;

import jp.ac.keio.sfc.ht.matsu.mugi.locator.history.HistoryLogger;
import jp.ac.keio.sfc.ht.matsu.mugi.locator.history.NoSuchHistoryException;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;

/**
 * @author matsu
 * 
 * �����ƕb���̕ϊ�
 * <ul>
 * <li>����60km(16.666m/s)</li>
 * <li>����90km(25m/s)</li>
 * <li>����5km (1.388m/s)</li>
 * <li>calc;90000/60/60</li>
 * </ul>
 * 
 * ���W�Ƌ����ϊ�
 * <ul>
 * <li>�ܓx 1�b=��31m</li>
 * <li>�o�x 1�b=��25m</li>
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


            /* ********** ���f *********** */
            int heikin_log_num;
            double diff;
            GeoPoint prev_location;
            
            /* ********** �~�܂��Ă��邩���f *********** */
            heikin_log_num = 8;
            prev_location = logger.getPrevious(heikin_log_num + 1);
            
            // �ړ����������߂�
            diff = location.getPoint().distance(prev_location.getPoint()); // From niya
            
            // 1�b�̈ړ�����
            diff = diff/heikin_log_num;
            
            
            // �ړ��������o�͂���ɂ̓R�����g�A�E�g
            //System.out.println(diff);
            
            if (diff <= 0.8)
                this.notify(MovementStateEvent.STAYING, location);
            else
                this.notify(MovementStateEvent.MOVING, prev_location);
            
            
            

        } catch (NoSuchHistoryException e) {
            // �v�������������Ȃ��Ƃ��ɃG���[
            // �ЂƂ܂�OFF
            // e.printStackTrace();
        }

    }

    /**
     * ���X�i�֒ʒm
     * 
     * @param new_state
     */
    private void notify(int new_state, GeoPoint location) {

        // ���X�i�֒ʒm
        if (listener != null) {

            if (current_state != new_state) {

                // �O��̏�Ԃƕω������Ƃ�����
                listener.activityStateChangeEvent(new MovementStateEvent(this,
                        new_state, location));
            }

            current_state = new_state;
        }

    }

    /**
     * ���X�i�[�o�^
     * 
     * @param listener
     */
    public void addActivityStateChangeEventListener(
            ActivityStateChangeEventListener listener) {
        this.listener = listener;
    }

}
