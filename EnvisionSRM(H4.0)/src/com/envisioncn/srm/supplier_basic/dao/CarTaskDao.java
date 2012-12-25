/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-14
 */
package com.envisioncn.srm.supplier_basic.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.supplier_basic.bean.CarTaskBean;

/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-12-03
 */
@Service("CarTaskDao")
public class CarTaskDao extends ABasicDao<CarTaskBean> implements ICarTaskDao{

	public Criteria getCriteria() {
		return sessionFactory.getCurrentSession().createCriteria(CarTaskBean.class);
	}
	
}
