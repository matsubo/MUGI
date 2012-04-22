/*
 *  : 2004/10/31
 *
 * 
 */
package jp.ac.keio.sfc.ht.matsu.mugi.locationanalyzer.gis.postgis;

import java.util.Iterator;
import java.util.Vector;
import java.util.prefs.Preferences;

/**
 * @author niya
 *
 * ¤³¤ÎÀ¸À®¤µ¤?¤¿¥³¥á¥ó¥È¤ÎÁÞÆ?¤µ¤?¤?¥Æ¥ó¥×¥?¡¼¥È¤òÊÑ¹¹¤¹¤?¤¿¤?
 * ¥¦¥£¥ó¥É¥¦ > ÀßÄ? > Java > ¥³¡¼¥ÉÀ¸À® > ¥³¡¼¥É¤È¥³¥á¥ó¥È
 */
class PostGISServerSetting {
    
	private Preferences preferences = Preferences.userNodeForPackage(this.getClass());
	private Vector<String> serverList = new Vector<String>();
	private String address = preferences.get("address", "map.ht.sfc.keio.ac.jp");
	private int port = preferences.getInt("port",5432);
	private String user = preferences.get("user","postgres"); 
	private String dbName = preferences.get("dbName", "map");
	private String password = preferences.get("passwd", "");
	

	PostGISServerSetting(){
		initServerList();
	}

	private void initServerList(){
		int addressListSize = preferences.getInt("listSize", 0);

		for(int i = 0; i < addressListSize; i++){
			serverList.add(preferences.get("address["+i+"]",""));
		}
		
		if(addressListSize == 0){
			serverList.add("map.ht.sfc.keio.ac.jp");
			serverList.add("localhost");
			refreshServerList();
		}
		
	}
	private void refreshServerList(){
		preferences.putInt("listSize", serverList.size());
		for(int i = 0; i < serverList.size(); i++){
			preferences.put("address["+i+"]", (String)serverList.get(i));
		}
	}

	protected Iterator serverIterator(){
		return serverList.iterator();
	}
	protected String getURL(){

		String url = "jdbc:postgresql://" + address + ":" + port + "/" + dbName;
		return url;
		
	}
	
	protected void preserve(){
		preferences.put("address", address);
		preferences.putInt("port",port);
		preferences.put("user",user); 
		preferences.put("dbName", dbName);


		serverList.remove(address);
		serverList.add(0, address);
		refreshServerList();
	}
	
	protected String getAddress() {
		return address;
	}

	protected String getDBName() {
		return dbName;
	}

	protected String getPassword() {
		return password;
	}
	protected int getPort() {
		return port;
	}

	protected String getUser() {
		return user;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	protected void setDbName(String dbName) {
		this.dbName = dbName;
	}

	protected void setPassword(String passwd) {
		this.password = passwd;
	}


	protected void setPort(int port) {
		this.port = port;
	}

	protected void setUser(String user) {
		this.user = user;
	}
}
