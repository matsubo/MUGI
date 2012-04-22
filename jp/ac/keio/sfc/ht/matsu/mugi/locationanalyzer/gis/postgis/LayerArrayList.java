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
 * �Q�Ƃ��郌�C���[�̃��X�g
 */
public class LayerArrayList {

    
    
    private static String[] layer = {
    "c_any",
//    "c_chiban", ���ԍ�
//    "c_cross", �����_
    "c_eki_jr",
    "c_eki_oh",
//    "c_gaiku", �X��ԍ�
//    "c_gname1",��{�s����
//    "c_gname2",
//    "c_gname3",
//    "c_gname4",
//    "c_hwsapa",
//    "c_juukyo", �Z���ԍ��H�H
//    "c_rail",���H
//    "c_rd_any",�g���l��
//    "c_rl_any",
//    "c_road", ��
//    "c_touban",�@�����̓��ԍ�
//    "c_water",�@��
    "s_airpt",
    "s_any_l",
    "s_any_s",
    "s_bank",
//    "s_bus",�o�X��
    "s_cpark",
    "s_cvs",
//    "s_eki_s",�@�w�������ǁC�f�[�^����
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
//    "s_kenno", �����ʎq
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
//    "s_signal",�M���@
    "s_taki",
    "s_yakuba",
    "c_matsuspecial",
    //"s_yama"
    };
    
    
    public  static final ArrayList<String> layers = new ArrayList<String>(Arrays.asList(layer));
    
}
