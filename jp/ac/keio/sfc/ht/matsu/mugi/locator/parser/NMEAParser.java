/*
 * Created on 2004/12/11
 *
 * $Id: NMEAParser.java,v 1.3 2004/12/21 08:51:44 matsu Exp $
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locator.parser;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

import jp.ac.keio.sfc.ht.matsu.mugi.locator.exception.UnsupportedGPSFormatException;
import jp.ac.keio.sfc.ht.niya.datumlibrary.GeoPoint;

/**
 * @author matsu
 * 
 */
public class NMEAParser {

    /**
     * 
     * @param line
     * @return
     */
    public static GeoPoint parse(String line)
            throws UnsupportedGPSFormatException {

        // 正規表現を書く
        Pattern pattern = Pattern.compile(",");

        // 正規表現とマッチ
        String[] matches = pattern.split(line);

        // for (int i=0;i<matches.length;i++) Log.debug(matches[i]);

        // Format check
        if (!matches[0].equals("$GPRMC"))
            throw new UnsupportedGPSFormatException(matches[0]);

        // f1: UTC time of the GGA position fix associated with this
        // sentence(hhmmss.ss)
        
        Calendar _calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        try{
        _calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(matches[1]
                .substring(0, 2)));
        _calendar.set(Calendar.MINUTE, Integer.parseInt(matches[1].substring(2,
                4)));
        _calendar.set(Calendar.SECOND, Integer.parseInt(matches[1].substring(4,
                6)));
        }catch(StringIndexOutOfBoundsException e){
            throw new UnsupportedGPSFormatException(matches[1]);
        }


        // c2: Status: A=data valid, V=navigation receiver warming
        if (!matches[2].equals("A"))
            throw new UnsupportedGPSFormatException(matches[2]);

        // f3: Latitude (ddmm.mmmm) -> dd
        int    _lat_degree   = Integer.parseInt(matches[3].substring(0, matches[3].length() - 7)); // Degrees
        double _lat_min       = Double.parseDouble(matches[3].substring(2, matches[3].length())); // Minutes

        double f3 = (_lat_degree + _lat_min/60);
        

        //Log.debug(new Double(f3));

        // c4: Latitude direction: N=north, S=south
        if (matches[4].equals("S"))
            f3 *= -1;
        
        if(!(matches[4].equals("N") || matches[4].equals("S")))
            throw new UnsupportedGPSFormatException(matches[4]);

        //Log.debug(new Integer(c4));

        // f5: Longitude (dddmm.mmmm)
        int    _lon_degree   = Integer.parseInt(matches[5].substring(0, matches[5].length() - 7)); // Degrees
        double _lon_min       = Double.parseDouble(matches[5].substring(3, matches[5].length())); // Minutes

        double f5 = (_lon_degree + _lon_min/60);
        
        //System.out.println(f5);

        // System.out.println(new Double((_lon_degree*60*60 + _lon_min*60 +
        // _lon_afterdot)*60-30000000));
        // System.out.println(new Double((_lon_degree*60*60 + _lon_min*60 +
        // _lon_afterdot)*60).intValue());

        //Log.debug(new Double(f5));

        // c6: Longitude direction: E=east, W=west
        if (matches[6].equals("W"))
            f5 *= -1;
        
        
        if(!(matches[6].equals("E") || matches[6].equals("W")))
            throw new UnsupportedGPSFormatException(matches[6]);

//        Log.debug(new Integer(c6));

        // f7: Speed over ground in knots
        try{
            float f7 = Float.parseFloat(matches[7]);
        }catch(NumberFormatException e){
            //throw new UnsupportedGPSFormatException(matches[7]);
        }

        //Log.debug(new Float(f7));

        // f8: Course over ground in degrees from the true north
        float f8 = Float.parseFloat(matches[8]);

//        Log.debug(new Float(f8));

        // s9: Date (ddmmyy)
        _calendar.set(Integer.parseInt(matches[9].substring(4, 6)) + 2000,
                Integer.parseInt(matches[9].substring(2, 4)) - 1, Integer
                        .parseInt(matches[9].substring(0, 2)));

        // _calendar.set(2004,Calendar.DECEMBER,1);

        Date date = _calendar.getTime();
//        Log.debug(date);

        // f10: Magnetic variation in degrees NMEA 0183 v3.0 only

        // c11: Direction of variation: NMEA 0183 v3.0 only
        // E=east: Easterly variation(E) subtracts from true courses.
        // W=west: Westerly variation(W) adds from true courses.
        // c12: Mode indicator: NMEA 0183 v3.0 only
        // A=autonomous, D=differential, E=Estimated (dead reckoning),
        // M=manual input, S=simulator, N=data not valid
        // cc: Hexadecimal cheksum computed by exclusive-ORing all bytes
        // in the message between, but not including, the $ and the *.
        // The results is *hh, where h is a hex character 0-9 or A-F.
        
        
        
        

        return new GeoPoint(f3, f5);
    }

    public static void main(String args[]) {

        try {

            long start1 = System.currentTimeMillis();

//            for (int i = 0; i < 10; i++) {
                GeoPoint location = NMEAParser
                        .parse("$GPRMC,073638,A,3523.3362,N,13925.5458,E,0.0,355.8,111204,7.0,W,A*08");
//            }

            long end1 = System.currentTimeMillis();

            long time1 = end1 - start1;

            
            System.out.println(time1 + " ms");
            

        } catch (UnsupportedGPSFormatException e) {
            e.printStackTrace();
        }

    }
}
