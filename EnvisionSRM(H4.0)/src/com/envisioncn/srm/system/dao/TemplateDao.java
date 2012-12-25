/**
 * 
 */
package com.envisioncn.srm.system.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.system.bean.Template;

/**
 * Copyright Envision
 *
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-25
 */
@Service("TemplateDao")
public class TemplateDao extends ABasicDao<Template> implements ITemplateDao {
	
	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(Template.class);
	}
	
}
