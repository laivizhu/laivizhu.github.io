package com.laivi.knowledge.basic.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.po.BaseEntity;
import com.laivi.knowledge.basic.util.DataUtil;

public class BasicService<T extends BaseEntity> implements IBasicService<T> {

	protected IBasicDao<T> basicDao;

	public long add(T object) throws Exception {
		return basicDao.add(object);
	}

	public void modify(T object) throws Exception {
		basicDao.modify(object);
	}

	public void remove(long id) throws Exception {
		basicDao.remove(id);
	}
	
	public void remove(T object) throws Exception{
		basicDao.remove(object);
	}

	public T getObject(long id) throws Exception {
		return basicDao.getObject(id);
	}

	public List<T> getList(CriterionList conditions, long start, long limit) {
		return basicDao.getList(basicDao.getConditionCriteria(conditions), start, limit);
	}

	public List<T> getList() {
		return basicDao.getList(basicDao.getCriteria());
	}

	public List<T> getList(CriterionList conditions) {
		return basicDao.getList(basicDao.getConditionCriteria(conditions));
	}

	public List<T> getList(long start, long limit) {
		return basicDao.getList(basicDao.getCriteria(), start, limit);
	}

	public long getCount(CriterionList conditions) {
		return basicDao.getTotalCount(basicDao.getConditionCriteria(conditions));
	}

	public long getCount() {
		return basicDao.getTotalCount(basicDao.getCriteria());
	}

	public T getObject(CriterionList conditions){
		return basicDao.getObject(basicDao.getConditionCriteria(conditions));
	}

	public void getValue(DetachedCriteria dc){
		
	}
	
	public Object getObjectByHql(String hql, Object[] parameters) {
		return basicDao.getObjectByHql(hql, parameters);
	}

	@Override
	public void remove(String idStrings) throws Exception {
		for(long id:DataUtil.changeIdString(idStrings)){
			this.remove(id);
		}
	}

	@Override
	public List<T> getList(String idStrings) {
		CriterionList conditions=CriterionList.CreateCriterion().put(Restrictions.in("id", DataUtil.changeIdString(idStrings)));
		return this.getList(conditions);
	}
	
	public void executeSql(String sql,Object[] params)throws ErrorException{
		try{
			basicDao.executeSql(sql, params);
		}catch(Exception e){
			throw new ErrorException("error.sql");
		}
	}
	
	public Long[] getListIds(List<T> list){
		Long[] idArray=new Long[list.size()];
		for(int i=0;i<idArray.length;i++){
			idArray[i]=list.get(i).getId();
		}
		return idArray;
	}
	
	@Override
	public T getObject(DetachedCriteria dc) throws Exception {
		return basicDao.getObject(dc);
	}

	@Override
	public List<T> getList(DetachedCriteria dc, long start, long limit) {
		return basicDao.getList(dc, start, limit);
	}

	@Override
	public List<T> getList(DetachedCriteria dc) {
		return basicDao.getList(dc);
	}

	@Override
	public long getCount(DetachedCriteria dc) {
		return basicDao.getTotalCount(dc);
	}
}
