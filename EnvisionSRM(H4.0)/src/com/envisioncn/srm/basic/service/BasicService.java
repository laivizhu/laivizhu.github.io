package com.envisioncn.srm.basic.service;

import java.io.Serializable;
import java.util.List;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.basic.model.ConditionSet;
import com.envisioncn.srm.basic.model.CriterionSet;

public class BasicService<T extends BaseEntity> implements IBasicService<T> {

	public IBasicDao<T> basicDao;

	public long add(T object) throws Exception {
		return basicDao.add(object);
	}

	public void modify(T object) throws Exception {
		basicDao.modify(object);
	}

	public void remove(long id) throws Exception {
		basicDao.remove(id);
	}

	public T getObject(long id) throws Exception {
		return basicDao.getObject(id);
	}

	public List<T> getList(ConditionSet conditions, long start, long limit) {
		return basicDao.getList(basicDao.getConditionCriteria(conditions), start, limit);
	}

	public List<T> getList(CriterionSet conditions, long start, long limit) {
		return basicDao.getList(basicDao.getConditionCriteria(conditions), start, limit);
	}

	public List<T> getList() {
		return basicDao.getList(basicDao.getCriteria());
	}

	public List<T> getList(ConditionSet conditions) {
		return basicDao.getList(basicDao.getConditionCriteria(conditions));
	}

	public List<T> getList(CriterionSet conditions) {
		return basicDao.getList(basicDao.getConditionCriteria(conditions));
	}

	public List<T> getList(long start, long limit) {
		return basicDao.getList(basicDao.getCriteria(), start, limit);
	}

	public long getCount(ConditionSet conditions) {
		return basicDao.getTotalCount(basicDao.getConditionCriteria(conditions));
	}

	public long getCount(CriterionSet conditions) {
		return basicDao.getTotalCount(basicDao.getConditionCriteria(conditions));
	}

	public long getCount() {
		return basicDao.getTotalCount(basicDao.getCriteria());
	}

	/*--- HQL ---*/
	public List<T> getObjectList(String hql, Object[] parameters) {
		return basicDao.getObjectList(hql, parameters);
	}

	public T getObjectById(Class<T> clazz, Serializable id) {
		return basicDao.getObjectById(clazz, id);
	}

	public void addObject(T object) {
		basicDao.addObject(object);
	}

	public void removeObject(T object) {
		basicDao.removeObject(object);
	}

	public void modifyObject(T object) {
		basicDao.modifyObject(object);
	}

	public List<T> getObjectListByPage(String hql, Object[] parameters, int start, int limit) {
		return basicDao.getObjectListByPage(hql, parameters, start, limit);
	}

	public int getPageCount(String hql, Object[] parameters) {
		return basicDao.getPageCount(hql, parameters);
	}

}
