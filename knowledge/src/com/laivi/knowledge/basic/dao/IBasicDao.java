package com.laivi.knowledge.basic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.laivi.knowledge.basic.model.po.BaseEntity;
import com.laivi.knowledge.basic.model.to.CriterionList;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public interface IBasicDao<T extends BaseEntity> {

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param dc
	 * @参数： @return
	 * @return List<T>
	 * @throws
	 */
	List<T> getList(DetachedCriteria dc);

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param dc
	 * @参数： @param start
	 * @参数： @param limit
	 * @参数： @return
	 * @return List<T>
	 * @throws
	 */
	List<T> getList(DetachedCriteria dc, long start, long limit);

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param id
	 * @参数： @return
	 * @return T
	 * @throws
	 */
	T getObject(long id);
	
	T getObject(DetachedCriteria dc);

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @return
	 * @return Criteria
	 * @throws
	 */
	DetachedCriteria getCriteria();

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param object
	 * @return void
	 * @throws
	 */
	long add(T object);

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param object
	 * @return void
	 * @throws
	 */
	void modify(T object);

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param id
	 * @return void
	 * @throws
	 */
	void remove(long id);
	
	/**
	 * 
	 * @param object
	 */
	void remove(T object);

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param dc
	 * @参数： @return
	 * @return long
	 * @throws
	 */
	long getTotalCount(DetachedCriteria dc);

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param criterionSet
	 * @参数： @return
	 * @return Criteria
	 * @throws
	 */
	DetachedCriteria getConditionCriteria(CriterionList criterionSet);

	Object getObjectByHql(String hql, Object[] parameters);
	
	public void executeSql(String sql,Object[] params);
}
