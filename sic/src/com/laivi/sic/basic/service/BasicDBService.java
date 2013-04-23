/**
 * Copyright Laivi 2013-4-13
 * Version 1.0 sic
 */
package com.laivi.sic.basic.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.sic.basic.dao.BasicDBDao;
import com.laivi.sic.basic.model.exception.ErrorException;
import com.laivi.sic.basic.model.po.IBasicDBEntity;
import com.laivi.sic.basic.model.to.CriterionList;
import com.laivi.sic.basic.util.DataUtil;

/**
 * @author laivi
 * Desc:
 */
@Service("BasicDBService")
public class BasicDBService<T extends IBasicDBEntity> implements IBasicDBService<T> {
	protected BasicDBDao<T> basicDao;
	
	/**
	 * @param basicDao the basicDao to set
	 */
	@Resource(name="BasicDBDao")
	public void setBasicDao(BasicDBDao<T> basicDao) {
		this.basicDao = basicDao;
	}	
	
	public Serializable add(T object){
		return this.basicDao.add(object);
	}
	
	public void remove(Class<T> clazz,Serializable id){
		this.basicDao.remove(clazz, id);
	}
	
	public void remove(T object){
		this.basicDao.remove(object);
	}
	
	public void remove(Class<T> clazz,String ids){
		for(long id:DataUtil.changeIdString(ids)){
			this.remove(clazz,id);
		}
	}
	
	public void modify(T object){
		this.basicDao.modify(object);
	}
	
	public T getObject(Class<T> clazz,Serializable id){
		return this.basicDao.getObject(clazz, id);
	}
	
	public T getObject(Class<T> clazz,CriterionList conditions){
		return this.basicDao.getObject(clazz, conditions);
	}
	
	public List<T> getList(Class<T> clazz) {
		return this.basicDao.getList(clazz);
	}

	public List<T> getList(Class<T> clazz, CriterionList conditions) {
		return this.basicDao.getList(clazz, conditions);
	}
	
	public List<T> getList(Class<T> clazz, CriterionList conditions, int start,
			int limit) {
		return this.basicDao.getList(clazz, conditions, start, limit);
	}
	
	public long getCount(Class<T> clazz, CriterionList conditions){
		return this.basicDao.getCount(this.basicDao.getConditionCriteria(clazz, conditions));
	}
	
	public Serializable[] getListIds(List<T> list){
		Serializable[] idArray=new Long[list.size()];
		for(int i=0;i<idArray.length;i++){
			idArray[i]=list.get(i).getId();
		}
		return idArray;
	}
	
	public void executeSql(String sql,Object[] params)throws ErrorException{
		try{
			basicDao.executeSql(sql, params);
		}catch(Exception e){
			throw new ErrorException("error.sql");
		}
	}
	
	public Object getObjectByHql(String hql, Object[] parameters) {
		return basicDao.getObjectByHql(hql, parameters);
	}

}
