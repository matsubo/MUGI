/*
 * Created on 2004/12/18
 *
 * $Id: LayerArrayList.java,v 1.1 2004/12/27 06:27:20 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.postgis;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author matsu
 * 
 * 参照するレイヤーのリスト
 */
public class LayerArrayList {

    
    
    private static String[] layer = {
    "c_any",
//    "c_chiban", 町番号
//    "c_cross", 交差点
    "c_eki_jr",
    "c_eki_oh",
//    "c_gaiku", 街区番号
//    "c_gname1",基本行政名
//    "c_gname2",
//    "c_gname3",
//    "c_gname4",
//    "c_hwsapa",
//    "c_juukyo", 住居番号？？
//    "c_rail",線路
//    "c_rd_any",トンネル
//    "c_rl_any",
//    "c_road", 道
//    "c_touban",　建物の棟番号
//    "c_water",　川
    "s_airpt",
    "s_any_l",
    "s_any_s",
    "s_bank",
//    "s_bus",バス停
    "s_cpark",
    "s_cvs",
//    "s_eki_s",　駅名だけど，データ無し
    "s_famres",
    "s_ff",
    "s_fw",
    "s_fw_s",
    "s_gs",
    "s_hosp",
    "s_hotel",
    "s_hwno",
    "s_jiin",
    "s_jinja",
    "s_kan",
    "s_kan_db",
//    "s_kenno", 県識別子
    "s_kokuno",
    "s_kouban",
    "s_onsen",
    "s_plant",
    "s_police",
    "s_post",
    "s_post_s",
    "s_rdstn",
    "s_scl",
    "s_scl_db",
//    "s_signal",信号機
    "s_taki",
    "s_yakuba",
    "c_matsuspecial",
    //"s_yama"
    };
    
    
    public  static final ArrayList<String> layers = new ArrayList<String>(Arrays.asList(layer));
    
}
