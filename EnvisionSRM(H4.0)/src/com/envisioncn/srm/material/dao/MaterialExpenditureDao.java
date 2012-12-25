package com.envisioncn.srm.material.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.material.bean.MaterialExpenditure;


@Service("MaterialExpenditureDao")
public class MaterialExpenditureDao implements IMaterialExpenditureDao{
	public SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(MaterialExpenditure.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MaterialExpenditure> getList(CriterionSet criterionSet) {
		Criteria dc = this.getCriteria();
		if (criterionSet != null) {
			for (Criterion criterion : criterionSet) 
				dc.add(criterion);
		}
		return dc.list();
	}
}

