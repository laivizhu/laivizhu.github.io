package com.laivi.maptable.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.sql2o.Query;
import org.sql2o.Sql2o;

import com.laivi.basic.mirror.Mirrors;

public class JdbcDao {

	private Connection conn;

	private Sql2o sql2o;

	public JdbcDao(Connection conn) {
		this.conn = conn;
	}

	public JdbcDao(String url, String user, String password) {
		sql2o = new Sql2o(url, user, password);
	}

	public void update(String table, Map<String, Object> value, String where) {
		StringBuilder sql = new StringBuilder("update " + table + " set ");
		sql.append(this.getSetValue(value));
		sql.append(" where ");
		sql.append(where);
		Query query = sql2o.createQuery(sql.toString());
		for (Map.Entry<String, Object> entry : value.entrySet()) {
			query.addParameter(entry.getKey(), entry.getValue());
		}
		org.sql2o.Connection connection = sql2o.beginTransaction();
		query.executeUpdate();
		connection.commit();
	}

	public void insert(String table, Class<?> klass, Object obj) {
		Map<String, Object> values = new LinkedHashMap<String, Object>();
		for (Field field : Mirrors.getFields(klass)) {
			boolean accessFlag = field.isAccessible();
			field.setAccessible(true);
			try {
				if (field.get(obj) != null) {
					values.put(field.getName(), field.get(obj));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} finally {
				field.setAccessible(accessFlag);
			}
		}

		insert(table, values);
	}

	public void insert(String table, Map<String, Object> value) {
		StringBuilder sql = new StringBuilder("insert into " + table + "(");
		for (Map.Entry<String, Object> entry : value.entrySet()) {
			sql.append(entry.getKey() + ",");
		}
		sql = new StringBuilder(sql.substring(0, sql.length() - 1));
		sql.append(") values(");
		for (Map.Entry<String, Object> entry : value.entrySet()) {
			sql.append(":" + entry.getKey() + ",");
		}
		sql = new StringBuilder(sql.substring(0, sql.length() - 1));
		sql.append(")");
		Query query = sql2o.createQuery(sql.toString());
		for (Map.Entry<String, Object> entry : value.entrySet()) {
			query.addParameter(entry.getKey(), entry.getValue());
		}
		org.sql2o.Connection connection = sql2o.beginTransaction();
		query.executeUpdate();
		connection.commit();
	}

	private String getSetValue(Map<String, Object> value) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Object> entry : value.entrySet()) {
			sb.append(entry.getKey() + "=:" + entry.getKey() + ",");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	public <T> List<T> getList(String table, Class<T> klass, String where) {
		StringBuilder sql = new StringBuilder("select * from " + table);
		if (where != null && !"".equals(where)) {
			sql.append(" where " + where);
		}
		return sql2o.createQuery(sql.toString()).executeAndFetch(klass);
	}

}
