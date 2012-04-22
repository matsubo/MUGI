/*
 * Created on 2004/12/08
 *
 * $Id: HistoryLogger.java,v 1.4 2004/12/15 06:08:50 matsu Exp $
 * 行動履歴ロガー
 * Singleton
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator.history;

import java.util.Vector;

import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;
import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

/**
 * @author matsu
 * 
 */
public class HistoryLogger {

    /** Max vector num */
    public static final int CAPACITY = 5*60;	

    /** Current number */
    private int index = 0;

    /** For singleton */
    private static HistoryLogger logger = new HistoryLogger();

    /** Save log */
    private Vector<GeoPoint> vector = new Vector<GeoPoint>(CAPACITY);

    /**
     * Singletonコンストラクタ
     * 
     */
    private HistoryLogger() {
    }

    /**
     * 追加
     * 
     * @param location
     */
    public void add(GeoPoint location) {

        //Log.debug(new Integer(index));
        
        try {
            if (vector.elementAt(index % CAPACITY) != null) {
                
                //Log.debug("set: at "+index%CAPACITY+" of "+location.getLat());
                vector.setElementAt(location,index % CAPACITY);
                
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            
            //Log.debug("add: at "+index%CAPACITY+" of "+location.getLat());
            vector.add(index % CAPACITY,location);
            

        }

        index += 1;

    }

    /**
     * クリア
     * 
     */
    public void clear() {
        index = 0;
        vector.clear();
    }

    /**
     * 指定した回数前の位置を取得
     * 
     * @param num
     * @return
     */
    public GeoPoint getPrevious(int num) throws NoSuchHistoryException {

        // キャパシティで保存しているより前のログを要求されたとき
        if (num > CAPACITY)
            throw new ArrayIndexOutOfBoundsException(num);

        // 返却する番号
        int ret = index % CAPACITY - num;
        // Log.debug("ret="+ret);

        // 0より下だったら，折り返す
        if (ret < 0)
            ret += CAPACITY;

        if (vector.size() < ret)
            throw new NoSuchHistoryException("No such log: " + ret);

        // Log.debug(ret+"番目を返します");

        return vector.elementAt(ret);

    }

    public int getCurrentIndex() {
        return index % CAPACITY;
    }

    public Vector getAllHistory() {
        return vector;
    }

    public void show() {

        for (int i = 0; i < vector.size(); i++) {

            GeoPoint object = vector.elementAt(i);
            System.out.println(i + ":" + object.getLatitude());

        }

    }

    /**
     * Singleton
     * 
     * @return
     */
    public static HistoryLogger getInstance() {
        return logger;
    }

    /**
     * テストコード
     * 
     * @param args
     */
    public static void main(String args[]) {

        HistoryLogger logger = HistoryLogger.getInstance();

        logger.add(new GeoPoint(000.0, 000.0));
        logger.add(new GeoPoint(100.0, 100.0));
        logger.add(new GeoPoint(200.0, 200.0));
        logger.add(new GeoPoint(300.0, 300.0));
        logger.add(new GeoPoint(400.0, 400.0));

        try {

            Log.debug(new Integer(logger.getCurrentIndex()));

            // Log.debug(new Double(logger.getPrevious(4).getLat()));
            Log.debug(logger.getPrevious(3).getLatitude());
            Log.debug(logger.getPrevious(2).getLatitude());
            Log.debug(logger.getPrevious(1).getLatitude());
            

            logger.show();

        } catch (NoSuchHistoryException e) {
            e.printStackTrace();
        }

        Log.debug("Finished");

    }

}