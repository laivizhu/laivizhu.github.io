package com.laivi.sic.basic.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.laivi.sic.basic.model.to.CriterionList;

public interface IBasicDBDao<T> extends IBasicDao{
	T getObject(Class<T> clazz,Serializable id);
	
	T getObject(Class<T> clazz,CriterionList conditions);
	
	List<T> getList(Class<T> clazz);
	
	List<T> getList(Class<T> clazz,CriterionList conditions);
	
	List<T> getList(Class<T> clazz,CriterionList conditions,int start,int limit);
	
	DetachedCriteria getConditionCriteria(Class<T> clazz,CriterionList criterionSet);
	
	long getCount(final DetachedCriteria dc);
	
	Serializable add(T object); 
	
	void remove(Class<T> clazz,Serializable id);
	
	void remove(T object);
	
	void modify(T object);
	
	void executeSql(String sql,Object[] params);
	
	Object getObjectByHql(String hql, Object[] parameters);
}
