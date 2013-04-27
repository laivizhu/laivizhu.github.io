package com.laivi.sic.service.basic;

import java.util.List;

import org.nutz.dao.Condition;

public interface IBasicDBService<T> {
	long add(T object);
	
	void delete(Class<T> klass,long id);
	
	void update(T obj);
	
	T get(Class<T> klass,long id);
	
	T get(Class<T> klass,Condition cnd);
	
	List<T> list(Class<T> klass,Condition cnd,int start,int limit);
	
	List<T> list(Class<T> klass,Condition cnd);
	
	List<T> list(Class<T> klass);
	
	int getCount(Class<T> klass,Condition cnd);
	
	int getCount(Class<T> klass);
}
