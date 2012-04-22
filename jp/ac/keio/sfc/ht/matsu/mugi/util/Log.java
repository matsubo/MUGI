/*
 * Created on 2004/12/08
 *
 * $Id: Log.java,v 1.4 2004/12/23 10:28:34 matsu Exp $
 * 
 * ÉçÉMÉìÉOÉNÉâÉX
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.util;

/**
 * @author matsu
 * 
 */
public class Log {

    public static final int DEBUG = 0;

    public static final int INFO = 1;

    public static final int WARN = 2;

    public static final int FATAL = 3;

    /** Log output level */
    private static  int mode = DEBUG;
    
    public static void debug(Object message) {
        if (mode == 0)
            System.out.println("DEBUG: " + message);
    }

    public static void info(Object message) {
        if (mode <= 1)
            System.out.println("INFO: " + message);
    }

    public static void warn(Object message) {
        if (mode <= 2)
            System.err.println("WARN: " + message);
    }

    public static void fatal(Object message) {
        if (mode <= 3)
            System.err.println("FATAL: " + message);
    }

}
