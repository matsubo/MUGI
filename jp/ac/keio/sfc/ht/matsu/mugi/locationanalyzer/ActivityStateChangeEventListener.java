/*
 * Created on 2004/12/08
 *
 * $Id: ActivityStateChangeEventListener.java,v 1.2 2004/12/21 08:51:45 matsu Exp $
 * �s�����ς�����Ƃ��ɌĂяo�����
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer;

/**
 * @author matsu
 * 
 */
public interface ActivityStateChangeEventListener {
    
    void activityStateChangeEvent(MovementStateEvent event);

}
