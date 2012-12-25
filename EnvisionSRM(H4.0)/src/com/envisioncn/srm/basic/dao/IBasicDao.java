package com.envisioncn.srm.basic.dao;

import java.util.List;

import org.hibernate.Criteria;

import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.basic.model.ConditionSet;
import com.envisioncn.srm.basic.model.CriterionSet;

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
	List<T> getList(Criteria dc);

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
	List<T> getList(Criteria dc, long start, long limit);

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

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @return
	 * @return Criteria
	 * @throws
	 */
	Criteria getCriteria();

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
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param dc
	 * @参数： @return
	 * @return long
	 * @throws
	 */
	long getTotalCount(Criteria dc);

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param conditionSet
	 * @参数： @return
	 * @return Criteria
	 * @throws
	 */
	Criteria getConditionCriteria(ConditionSet conditionSet);

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-23 修改内容
	 * 
	 * @参数： @param criterionSet
	 * @参数： @return
	 * @return Criteria
	 * @throws
	 */
	Criteria getConditionCriteria(CriterionSet criterionSet);

	/*--- HQL操纵数据库 ---*/

	/**
	 * 从数据中获得对象
	 * 
	 * @param clazz
	 * @param id
	 * @return Object
	 */
	public T getObjectById(Class<T> clazz, java.io.Serializable id);

	/**
	 * 
	 * @param hql
	 * @param parameters
	 * @return
	 */
	public T getObjectByHql(String hql, Object[] parameters);

	/**
	 * 根据HQL语句从数据库中查询
	 * 
	 * @param hql
	 * @param parameters
	 * @return Object List
	 */
	public List<T> getObjectList(String hql, Object[] parameters);

	/**
	 * 增加对象
	 * 
	 * @param object
	 */
	public void addObject(T object);

	/**
	 * 删除对象
	 * 
	 * @param object
	 */
	public void removeObject(T object);

	/**
	 * 修改对象
	 * 
	 * @param object
	 */
	public void modifyObject(T object);

	/**
	 * 带分页的对象列表
	 * 
	 * @param hql
	 * @param parameters
	 * @return
	 */
	public List<T> getObjectListByPage(String hql, Object[] parameters, int start, int limit);

	/**
	 * 
	 * @param hql
	 * @param parameters
	 * @return
	 */
	public int getPageCount(String hql, Object[] parameters);

}
