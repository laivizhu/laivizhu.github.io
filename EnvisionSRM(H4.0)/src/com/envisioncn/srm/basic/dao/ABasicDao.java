package com.envisioncn.srm.basic.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.basic.model.Condition;
import com.envisioncn.srm.basic.model.ConditionSet;
import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.model.constants.AppConstants;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public abstract class ABasicDao<T extends BaseEntity> implements IBasicDao<T> {

	public SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<T> getList(Criteria dc) {
		dc.addOrder(Order.desc("id"));
		return dc.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getList(Criteria dc, long start, long limit) {
		dc.addOrder(Order.desc("id"));
		dc.setFirstResult((int) start);
		dc.setMaxResults((int) limit);
		return dc.list();
	}

	@SuppressWarnings("unchecked")
	public T getObject(long id) {
		Criteria dc = this.getCriteria();
		dc = dc.add(Restrictions.eq("id", id));
		List<T> list = dc.list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public long add(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.save(object);
		return object.getId();
	}

	public void modify(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.update(object);
	}

	public void remove(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(this.getObject(id));
	}

	public long getTotalCount(Criteria criteria) {
		long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		criteria.setProjection(null);
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		return totalCount;
	}

	public Criteria getConditionCriteria(ConditionSet conditionSet) {
		Criteria dc = this.getCriteria();
		if (conditionSet == null) {
			return dc;
		}
		for (Condition condition : conditionSet) {
			if (condition.isCascade()) {
				dc = addCascadeCondition(dc, condition);
			} else {
				getCriteria(dc, condition.getProperty(), condition);
			}
		}
		return dc;
	}

	public Criteria addCascadeCondition(Criteria dc, Condition condition) {
		String[] classes = condition.getProperty().split("\\.");
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < classes.length - 1; i++) {
			if (i == 0) {
				dc.createAlias(classes[0], AppConstants.CASCADE_REPLACE + i);
			} else {
				prefix.replace(0, prefix.length(), AppConstants.CASCADE_REPLACE + (i - 1) + "." + classes[i]);
				dc.createAlias(prefix.toString(), AppConstants.CASCADE_REPLACE);
			}
		}
		dc = getCriteria(dc, AppConstants.CASCADE_REPLACE + (classes.length - 2) + "." + classes[classes.length - 1],
				condition);
		return dc;
	}

	public Criteria getCriteria(Criteria dc, String properties, Condition condition) {
		switch (condition.getConditonType()) {
		case BETWEENT:
			dc.add(Restrictions.between(properties, condition.getFirstValue(), condition.getSecondValue()));
			break;
		case EQ:
			dc.add(Restrictions.eq(properties, condition.getFirstValue()));
			break;
		case GE:
			dc.add(Restrictions.ge(properties, condition.getFirstValue()));
			break;
		case GT:
			dc.add(Restrictions.gt(properties, condition.getFirstValue()));
			break;
		case LE:
			dc.add(Restrictions.le(properties, condition.getFirstValue()));
			break;
		case LIEK:
			dc.add(Restrictions.like(properties, condition.getFirstValue()));
			break;
		case LT:
			dc.add(Restrictions.lt(properties, condition.getFirstValue()));
			break;
		case DESCORDER:
			dc.addOrder(Order.desc(properties));
			break;
		case ACSORDER:
			dc.addOrder(Order.asc(properties));
			break;
		case NOT:
			dc.add(Restrictions.ne(properties, condition.getFirstValue()));
			break;
		case OR:
			break;
		default:
			dc.add(Restrictions.eq(properties, condition.getFirstValue()));
		}
		return dc;
	}

	public Criteria getConditionCriteria(CriterionSet criterionSet) {
		Criteria dc = this.getCriteria();
		if (criterionSet == null) {
			return dc;
		}
		for (Criterion criterion : criterionSet) {
			dc.add(criterion);
		}
		return dc;
	}

	@SuppressWarnings("unchecked")
	public T getObjectById(Class<T> clazz, Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getObjectList(String hql, Object[] parameters) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (parameters != null && parameters.length != 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return (List<T>) query.list();
	}

	public void addObject(T objectect) {
		Session session = sessionFactory.getCurrentSession();
		session.save(objectect);
	}

	public void modifyObject(T objectect) {
		Session session = sessionFactory.getCurrentSession();
		session.update(objectect);
	}

	public void removeObject(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(object);
	}

	public int getPageCount(String hql, Object[] parameters) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return Integer.parseInt(query.uniqueResult().toString());
	}

	@SuppressWarnings("unchecked")
	public T getObjectByHql(String hql, Object[] parameters) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> getObjectListByPage(String hql, Object[] parameters, int start, int limit) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return (List<T>) query.setFirstResult(start).setMaxResults(limit).list();
	}
}
