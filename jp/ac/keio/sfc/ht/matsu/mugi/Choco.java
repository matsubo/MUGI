/*
 * Created on 2004/12/20
 *
 * $Id: Choco.java,v 1.2 2005/01/20 03:20:28 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi;

import jp.ac.keio.sfc.ht.matsu.mugi.activitymodel.hmm.Dataset;

/**
 * @author matsu
 * 
 */
public interface Choco {
 
    /**
     * 次に行きそうな場所
     * @param place
     * @return
     */
    public Dataset getNextProb(String place);
}
