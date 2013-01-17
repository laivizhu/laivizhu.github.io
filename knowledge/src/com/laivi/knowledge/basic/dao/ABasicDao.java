package com.laivi.knowledge.basic.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.po.BaseEntity;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public abstract class ABasicDao<T extends BaseEntity> implements IBasicDao<T> {
	protected HibernateTemplate hibernateTemplate;

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public List<T> getList(DetachedCriteria dc) {
		return hibernateTemplate.findByCriteria(dc);
	}

	@SuppressWarnings("unchecked")
	public List<T> getList(DetachedCriteria dc, long start, long limit) {
		return hibernateTemplate.findByCriteria(dc, (int) start, (int) limit);
	}

	public T getObject(long id) {
		DetachedCriteria dc = this.getCriteria();
		dc = dc.add(Restrictions.eq("id", id));
		List<T> list = this.getList(dc);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T getObject(DetachedCriteria dc){
		if(dc!=null){
			List<T> objects=hibernateTemplate.findByCriteria(dc);
			if(objects.size()>0){
				return objects.get(0);
			}
		}
		return null;
	}

	public long add(T object) {
		hibernateTemplate.save(object);
		return object.getId();
	}

	public void modify(T object) {
		hibernateTemplate.update(object);
	}

	public void remove(long id) {
		hibernateTemplate.delete(this.getObject(id));
	}
	
	public void remove(T object) {
		hibernateTemplate.delete(object);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public long getTotalCount(final DetachedCriteria dc) {
		return (Long) hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = dc.getExecutableCriteria(session);
				long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
				criteria.setProjection(null);
				criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
				return totalCount;
			}
		});
	}

	public DetachedCriteria getConditionCriteria(CriterionList criterionSet) {
		DetachedCriteria dc = this.getCriteria();
		if (criterionSet == null) {
			return dc;
		}
		for (Object obj : criterionSet) {
			if(obj instanceof Criterion){
				dc.add((Criterion)obj);
			}else if(obj instanceof Order){
				dc.addOrder((Order)obj);
			}
		}
		return dc;
	}
	
	public Object getObjectByHql(String hql, Object[] parameters) {
		return hibernateTemplate.find(hql, parameters).get(0);
	}
}
