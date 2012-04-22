/*
 * Created on 2004/12/08
 *
 * $Id: MovementStateEvent.java,v 1.4 2004/12/15 06:08:49 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer;

import java.util.EventObject;

import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;

/**
 * @author matsu
 * 
 */
public class MovementStateEvent extends EventObject {

    private static final long serialVersionUID = 3258413949769953587L;

    
    /** 初期状態 */
    public static final int NONE = 0;
    
    /** 滞在している */
    public static final int STAYING = 1;

    /** 動いている */
    public static final int MOVING = 2;

    private int state = 0;

    private GeoPoint location;


    /**
     * コンストラクタ
     * 
     * @param object
     * @param state
     */
    public MovementStateEvent(Object object, int state, GeoPoint location) {

        super(object);
        this.state = state;
        this.location = location;

    }

    /**
     * 行動状態取得
     * 
     * @return
     */
    public int getState() {

        return state;
    }

    /**
     * 位置情報
     * 
     */
    public GeoPoint getLocation() {
        return location;
    }
    

    
}
