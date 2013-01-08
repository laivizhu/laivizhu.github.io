package com.laivi.knowledge.basic.dao;

import java.io.Serializable;
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
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.po.BaseEntity;

@Service("LBasicDao")
public class LBasicDao<T extends BaseEntity> implements ILBasicDao<T>{
	protected HibernateTemplate hibernateTemplate;

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public T getObject(Class<T> clazz, Serializable id) {
		return hibernateTemplate.get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(Class<T> clazz) {
		DetachedCriteria dc=DetachedCriteria.forClass(clazz);
		return hibernateTemplate.findByCriteria(dc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(Class<T> clazz, CriterionList conditions) {
		DetachedCriteria dc=this.getConditionCriteria(clazz, conditions);
		return hibernateTemplate.findByCriteria(dc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(Class<T> clazz, CriterionList conditions, int start,
			int limit) {
		DetachedCriteria dc=this.getConditionCriteria(clazz, conditions);
		return hibernateTemplate.findByCriteria(dc,start,limit);
	}

	@Override
	public DetachedCriteria getConditionCriteria(Class<T> clazz,
			CriterionList criterionSet) {
		DetachedCriteria dc=DetachedCriteria.forClass(clazz);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public long getCount(final DetachedCriteria dc) {
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

	@Override
	public long add(T object) {
		hibernateTemplate.save(object);
		return object.getId();
	}

	@Override
	public void remove(Class<T> clazz, Serializable id) {
		hibernateTemplate.delete(this.getObject(clazz, id));
	}

	@Override
	public void remove(T object) {
		hibernateTemplate.delete(object);
	}

	@Override
	public void modify(T object) {
		hibernateTemplate.update(object);
	}
}
