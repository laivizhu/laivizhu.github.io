/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-14
 */
package com.envisioncn.srm.supplier_development.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.supplier_development.bean.SecuritTemplateBean;

/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-14
 */
@Service("SecuritTemplateDao")
public class SecuritTemplateDao extends ABasicDao<SecuritTemplateBean> implements ISecuritTemplateDao{

	public Criteria getCriteria() {
		return sessionFactory.getCurrentSession().createCriteria(SecuritTemplateBean.class);
	}
	
	

}
