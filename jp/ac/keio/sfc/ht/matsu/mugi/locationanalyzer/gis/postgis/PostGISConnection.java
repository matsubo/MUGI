/*
 * Created on : 2004/10/31
 *
 * コネクタ
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.postgis;

import java.awt.Shape;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp.ac.keio.sfc.ht.matsu.mugi.util.Log;

import org.geotools.renderer.lite.LiteShape;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;




/**
 * @author niya
 * 
 * PostGISに接続
 */
public class PostGISConnection {

    private java.sql.Connection conn;

    private static PostGISConnection post_gis_connection = new PostGISConnection(
            new PostGISServerSetting());

    

    /**
     * 接続
     * 
     * @param setting
     */
    private PostGISConnection(PostGISServerSetting setting) {

        try {
            /*
             * Load the JDBC driver and establish a connection.
             */
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(setting.getURL(), setting
                    .getUser(), setting.getPassword());

            /*
             * Add the geometry types to the connection.
             * 
             * Note that you must cast the connection to the pgsql-specific
             * connection * implementation before calling the addDataType()
             * method.
             */
            ((org.postgresql.PGConnection) conn).addDataType("geometry",
                    "org.postgis.PGgeometry");
            ((org.postgresql.PGConnection) conn).addDataType("box3d",
                    "org.postgis.PGbox3d");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static synchronized PostGISConnection getInstance() {

        return post_gis_connection;

    }

    /**
     * Statement取得
     * 
     * @return
     * @throws SQLException
     */
    public Statement getStatement() throws SQLException {

        if (conn == null) {
            throw new SQLException("Not connected");
        }

        Statement s = conn.createStatement();
        return s;
    }

    /**
     * 切断
     * 
     */
    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * テスト
     * 
     * @param args
     */
    public static void main(String args[]) throws Exception {

        PostGISConnection con = PostGISConnection.getInstance();
        WKTReader reader = new WKTReader();

        Statement statement = con.getStatement();
        ResultSet r = statement
                .executeQuery("SELECT  gid,code, label, AsText(trans_geom)  from c_any LIMIT 10");

        while (r.next()) {

            // column1
            int id = r.getInt(1);

            // column2
            String code = (String) r.getObject(2);

            // column3
            String label = (String) r.getObject(3);

            // column4
            Geometry geom = reader.read((String)r.getObject(4));
            Shape shape = new LiteShape(geom, false);
            
                        
            Log.info(id+": "+code+label+"		("+geom.getInteriorPoint().getX()+","+geom.getInteriorPoint().getY()+")");
            //Log.info(id+": "+code+label+shape);

        }

        con.disconnect();

    }
}
