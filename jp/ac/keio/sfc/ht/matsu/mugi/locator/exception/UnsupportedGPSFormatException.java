/*
 * Created on 2004/12/11
 *
 * $Id: UnsupportedGPSFormatException.java,v 1.1 2004/12/11 16:31:45 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator.exception;

/**
 * @author matsu
 * 
 */
public class UnsupportedGPSFormatException extends Exception{

    private static final long serialVersionUID = 3257291314054836536L;
    
    public UnsupportedGPSFormatException(String message){
        super(message);
    }

}
