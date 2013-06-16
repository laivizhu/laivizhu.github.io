package com.laivi.maptable.dao;

import java.sql.Connection;
import java.util.Map;

import org.sql2o.Query;
import org.sql2o.Sql2o;

public class JdbcDao {
	
	private Connection conn;
	
	private Sql2o sql2o;

	public JdbcDao(Connection conn) {
		this.conn = conn;
	}
	
	public JdbcDao(String url,String user,String password){
		sql2o=new Sql2o(url,user,password);
	}
	
	
	public void update(String table,Map<String,Object> value,String where){
		StringBuilder sql=new StringBuilder("update "+table+" set ");
		sql.append(this.getSetValue(value));
		Query query=sql2o.createQuery(sql.toString());
		for(Map.Entry<String,Object>entry:value.entrySet()){
			query.addParameter(entry.getKey(), entry.getValue());
		}
		sql.append(" where ");
		sql.append(where);
		org.sql2o.Connection connection = sql2o.beginTransaction();
		query.executeUpdate();
		connection.commit();
	}
	
	private String getSetValue(Map<String,Object> value){
		StringBuilder sb=new StringBuilder();
		for(Map.Entry<String, Object> entry:value.entrySet()){
			sb.append(entry.getKey()+"=:"+entry.getKey()+",");
		}
		return sb.toString().substring(0, sb.length()-1);
	}
	

}
