/*
 * Created on 2004/12/13
 *
 * $Id: NoSuchHistoryException.java,v 1.1 2004/12/13 02:32:38 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator.history;

/**
 * @author matsu
 * 
 */
public class NoSuchHistoryException extends Exception {

    private static final long serialVersionUID = 3690758380109443377L;

    public NoSuchHistoryException() {
        super();
    }
    
    public NoSuchHistoryException(String message){
        super(message);
    }

}
