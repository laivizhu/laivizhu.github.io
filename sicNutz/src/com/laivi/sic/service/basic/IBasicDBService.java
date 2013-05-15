package com.laivi.sic.service.basic;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.laivi.sic.model.po.basic.IBasicDBEntity;

public interface IBasicDBService {
	<T extends IBasicDBEntity> long add(T object);
	
	<T> void delete(Class<T> klass,long id);
	
	<T> void update(T obj);
	
	<T> T get(Class<T> klass,long id);
	
	<T> T get(Class<T> klass,Condition cnd);
	
	<T> List<T> list(Class<T> klass,Condition cnd,int start,int limit);
	
	<T> List<T> list(Class<T> klass,Condition cnd,Pager page);
	
	<T> List<T> list(Class<T> klass,Condition cnd);
	
	<T> List<T> list(Class<T> klass);
	
	<T> int getCount(Class<T> klass,Condition cnd);
	
	<T> int getCount(Class<T> klass);
}
