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
import com.envisioncn.srm.supplier_basic.bean.CarBean;

/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-14
 */
@Service("CarDao")
public class CarDao extends ABasicDao<CarBean> implements ICarDao{

	public Criteria getCriteria() {
		return sessionFactory.getCurrentSession().createCriteria(CarBean.class);
	}
	
}
