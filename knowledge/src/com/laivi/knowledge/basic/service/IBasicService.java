package com.laivi.knowledge.basic.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.po.BaseEntity;
import com.laivi.knowledge.basic.model.to.CriterionList;



public interface IBasicService<T extends BaseEntity> {

	long add(T object) throws Exception;

	void modify(T object) throws Exception;

	void remove(long id) throws Exception;
	
	void remove(String idStrings)throws Exception;

	void remove(T object) throws Exception;

	T getObject(long id) throws Exception;

	T getObject(CriterionList conditions)throws Exception;
	
	T getObject(DetachedCriteria dc)throws Exception;

	List<T> getList(CriterionList conditions, long start, long limit);
	
	List<T> getList(DetachedCriteria dc, long start, long limit);

	List<T> getList(long start, long limit);
	
	List<T> getList(String idStrings);
	
	Long[] getListIds(List<T> list);

	void getValue(DetachedCriteria dc);

	List<T> getList();

	List<T> getList(CriterionList conditions);

	List<T> getList(DetachedCriteria dc);

	long getCount();

	long getCount(CriterionList conditions);

	long getCount(DetachedCriteria dc);

	Object getObjectByHql(String hql, Object[] parameters);
	
	void executeSql(String sql,Object[] params)throws ErrorException;

}
