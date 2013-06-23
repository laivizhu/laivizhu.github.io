package com.laivi.maptable.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.alibaba.druid.pool.DruidDataSource;

public class JdbcConn {
	private static Log log=Logs.get();
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private static DataSource dataSource=null;
	
	static{
		DruidDataSource ddataSource=new DruidDataSource();
		ddataSource.setUrl("");
		//ddataSource.setdr
		
	}
	
	public JdbcConn(String driver, String url, String user,
			String password) {
		this.driver = driver;
		this.url=url;
		this.user = user;
		this.password = password;
	}
	
	public JdbcConn() {
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static Connection getConnection(JdbcConn conn) {
		Connection con = null;  //创建用于连接数据库的Connection对象
		try{
			 Class.forName(conn.driver);
			 con=DriverManager.getConnection(conn.url,conn.user,conn.password);
		}catch(SQLException e){
			log.debug("get the Connection Error!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.debug("get the JDBC Driver Error!");
			e.printStackTrace();
		}
		return con;
	}

}
