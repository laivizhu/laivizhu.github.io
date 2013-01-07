package com.laivi.knowledge.basic.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.laivi.knowledge.basic.model.CriterionList;

public interface ILBasicDao<T> {
	T getObject(Class<T> clazz,Serializable id);
	
	List<T> getList(Class<T> clazz);
	
	List<T> getList(Class<T> clazz,CriterionList conditions);
	
	List<T> getList(Class<T> clazz,CriterionList conditions,int start,int limit);
	
	DetachedCriteria getConditionCriteria(Class<T> clazz,CriterionList criterionSet);
	
	long getCount(final DetachedCriteria dc);
	
	long add(T object); 
	
	void remove(Class<T> clazz,Serializable id);
	
	void remove(T object);
	
	void modify(T object);
}