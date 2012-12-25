package com.envisioncn.srm.basic.service;

import java.util.List;

import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.basic.model.ConditionSet;
import com.envisioncn.srm.basic.model.CriterionSet;

public interface IBasicService<T extends BaseEntity> {

	long add(T objectect) throws Exception;

	void modify(T objectect) throws Exception;

	void remove(long id) throws Exception;

	T getObject(long id) throws Exception;

	List<T> getList(ConditionSet conditions, long start, long limit);

	List<T> getList(CriterionSet conditions, long start, long limit);

	List<T> getList(long start, long limit);

	List<T> getList();

	List<T> getList(ConditionSet conditions);

	List<T> getList(CriterionSet conditions);

	long getCount(ConditionSet conditions);

	long getCount();

	long getCount(CriterionSet conditions);

	/*--- hql service  ---*/

	public List<T> getObjectList(String hql, Object[] parameters);

	public T getObjectById(Class<T> clazz, java.io.Serializable id);

	public void addObject(T object);

	public void removeObject(T object);

	public void modifyObject(T object);

	public List<T> getObjectListByPage(String hql, Object[] parameters, int start, int limit);

	public int getPageCount(String hql, Object[] parameters);

}
