package com.laivi.maptable.dao;

import java.sql.Connection;
import java.util.Map;

public class JdbcDao {
	
	private Connection conn;

	public JdbcDao(Connection conn) {
		this.conn = conn;
	}
	
	
	public void update(String table,Map<String,Object> value){
		
	}
	

}
