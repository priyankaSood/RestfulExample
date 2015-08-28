package com.infosys.util;

import java.sql.Connection;

public interface DBUtil {
	 //void createTable() throws Exception;
	Connection getConnection() throws Exception;
	
}
