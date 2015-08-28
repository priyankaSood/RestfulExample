package com.infosys.util;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import com.ibm.json.java.JSON;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;
	
public class DBUtilImpl implements DBUtil{
	/*public DBUtilImpl() {
		try {
			createTable();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}*/
	/**
	 * Create the posts table if it doesn't already exist
	 * 
	 * @throws Exception
	 */
	/*public void createTable() throws Exception {
		String sql = "CREATE TABLE IF NOT EXISTS Person (" +
						" id SERIAL PRIMARY KEY NOT NULL, " +
						"name varchar(20) NOT NULL DEFAULT ''," +
						"country varchar(20) DEFAULT NULL"+
					 ");";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		} finally {			
			if (statement != null) {
				statement.close();
			}
			
			if (connection != null) {
				connection.close();
			}
		}
	}*/
	
	public  Connection getConnection() throws Exception {
		Map<String, String> env = System.getenv();
		
		if (env.containsKey("VCAP_SERVICES")) {
			// we are running on cloud foundry, let's grab the service details from vcap_services
			JSONObject vcap = (JSONObject) JSON.parse(env.get("VCAP_SERVICES"));
			JSONObject service = null;
			
			// We don't know exactly what the service is called, but it will contain "elephantsql"
			for (Object key : vcap.keySet()) {
				String keyStr = (String) key;
				if (keyStr.toLowerCase().contains("sqldb")) {
					service = (JSONObject) ((JSONArray) vcap.get(keyStr)).get(0);
					break;
				}
			}
			
			if (service != null) {
				JSONObject creds = (JSONObject) service.get("credentials");
				URI uri = URI.create((String) creds.get("uri"));
				String url = "jdbc:db2://" + uri.getHost() + ":" + uri.getPort() + uri.getPath();
				String username = uri.getUserInfo().split(":")[0];
				String password = uri.getUserInfo().split(":")[1];
				return DriverManager.getConnection(url, username, password);
			}
		}
		
		throw new Exception("No Postgresql service URL found. Make sure you have bound the correct services to your app.");
	}
	
	
}
