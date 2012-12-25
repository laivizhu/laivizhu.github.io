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
import com.envisioncn.srm.supplier_development.bean.SecuritBean;

/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-14
 */
@Service("SecuritDao")
public class SecuritDao extends ABasicDao<SecuritBean> implements ISecuritDao{

	public Criteria getCriteria() {
		return sessionFactory.getCurrentSession().createCriteria(SecuritBean.class);
	}
	
}
