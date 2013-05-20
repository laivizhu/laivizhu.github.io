package com.laivi.sic.service.basic;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.laivi.sic.model.po.basic.IBasicDBEntity;

public interface IBasicDBService {
	<T extends IBasicDBEntity> long add(T object)throws Exception;
	
	<T> void delete(Class<T> klass,long id)throws Exception;
	
	<T> void update(T obj)throws Exception;
	
	<T> T get(Class<T> klass,long id)throws Exception;
	
	<T> T get(Class<T> klass,Condition cnd)throws Exception;
	
	<T> List<T> list(Class<T> klass,Condition cnd,int start,int limit)throws Exception;
	
	<T> List<T> list(Class<T> klass,Condition cnd,Pager page)throws Exception;
	
	<T> List<T> list(Class<T> klass,Condition cnd)throws Exception;
	
	<T> List<T> list(Class<T> klass)throws Exception;
	
	<T> List<T> list(Class<T> klass,String sql,Pager page)throws Exception;
	
	<T> int getCount(Class<T> klass,Condition cnd)throws Exception;
	
	<T> int getCount(Class<T> klass)throws Exception;
	
	<T> int getCount(Class<T> klass,String sql)throws Exception;
	
	
	
	
}
