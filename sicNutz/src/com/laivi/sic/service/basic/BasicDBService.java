package com.laivi.sic.service.basic;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.service.IdNameEntityService;

import com.laivi.sic.model.po.basic.IBasicDBEntity;

public abstract class BasicDBService<T extends IBasicDBEntity> extends IdNameEntityService<T> implements IBasicDBService<T> {

	public BasicDBService(Dao dao){
		super(dao);
	}
	
	public long add(T object){
		dao().insert(object);
		return object.getId();
	}
	
	public void delete(Class<T> klass,long id){
		dao().delete(klass, id);
	}
	
	public void update(T obj){
		dao().update(obj);
	}
	
	public T get(Class<T> klass,long id){
		return dao().fetch(klass, id);
	}
	
	public T get(Class<T> klass,Condition cnd){
		return dao().fetch(klass, cnd);
	}
	
	public List<T> list(Class<T> klass,Condition cnd,int start,int limit){
		return dao().query(klass, cnd, dao().createPager(limit==0?0:start/limit, limit));
	}
	
	public List<T> list(Class<T> klass,Condition cnd){
		return dao().query(klass, cnd,null);
	}
	
	public List<T> list(Class<T> klass){
		return dao().query(klass,null,null);
	}
	
	public int getCount(Class<T> klass,Condition cnd){
		return dao().count(klass, cnd);
	}
	
	public int getCount(Class<T> klass){
		return dao().count(klass);
	}
}
