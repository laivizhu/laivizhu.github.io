/**
 * Copyright Laivi 2013-4-13
 * Version 1.0 sic
 */
package com.laivi.sic.basic.service;

import java.io.Serializable;
import java.util.List;

import com.laivi.sic.basic.model.exception.ErrorException;
import com.laivi.sic.basic.model.po.IBasicDBEntity;
import com.laivi.sic.basic.model.to.CriterionList;

/**
 * @author laivi
 * Desc:
 */
public interface IBasicDBService<T extends IBasicDBEntity> extends IBasicService {
	Serializable add(T object);
	
	void remove(Class<T> clazz,Serializable id);
	
	void remove(T object);
	
	void remove(Class<T> clazz,String ids);
	
	void modify(T object);
	
	T getObject(Class<T> clazz,Serializable id);
	
	T getObject(Class<T> clazz,CriterionList conditions);
	
	List<T> getList(Class<T> clazz);
	
	List<T> getList(Class<T> clazz, CriterionList conditions);
	
	List<T> getList(Class<T> clazz, CriterionList conditions, int start,int limit);
	
	long getCount(Class<T> clazz, CriterionList conditions);
	
	Serializable[] getListIds(List<T> list);
	
	void executeSql(String sql,Object[] params)throws ErrorException;
	
	Object getObjectByHql(String hql, Object[] parameters);

}
