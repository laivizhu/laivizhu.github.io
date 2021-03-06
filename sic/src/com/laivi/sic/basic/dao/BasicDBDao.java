package com.laivi.sic.basic.dao;

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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.laivi.sic.basic.model.po.IBasicDBEntity;
import com.laivi.sic.basic.model.to.CriterionList;

@Service("BasicDBDao")
public class BasicDBDao<T extends IBasicDBEntity> implements IBasicDBDao<T>{
	protected HibernateTemplate hibernateTemplate;
	protected JdbcTemplate jdbcTemplate;

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Resource(name="jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
	public Serializable add(T object) {
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

	@Override
	public T getObject(Class<T> clazz, CriterionList conditions) {
		List<T> list=this.getList(clazz, conditions);
		if(list!=null &&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public void executeSql(String sql,Object[] params){
		jdbcTemplate.update(sql);
	}
	
	public Object getObjectByHql(String hql, Object[] parameters) {
		return hibernateTemplate.find(hql, parameters).get(0);
	}
}
