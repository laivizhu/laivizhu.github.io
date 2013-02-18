package com.laivi.knowledge.basic.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ILBasicDao;
import com.laivi.knowledge.basic.model.po.BasicEntity;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.util.DataUtil;

@Service("LBasicService")
public class LBasicService<T extends BasicEntity> {
	
	protected ILBasicDao<T> basicDao;
	
	@Resource(name="LBasicDao")
	public void setBasicDao(ILBasicDao<T> basicDao) {
		this.basicDao = basicDao;
	}
	
	public long add(T object){
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
	
	Long[] getListIds(List<T> list){
		Long[] idArray=new Long[list.size()];
		for(int i=0;i<idArray.length;i++){
			idArray[i]=list.get(i).getId();
		}
		return idArray;
	}
}
