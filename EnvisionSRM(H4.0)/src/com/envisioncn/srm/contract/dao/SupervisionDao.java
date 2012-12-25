/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.SupervisionBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("SupervisionDao")
public class SupervisionDao extends ABasicDao<SupervisionBean> implements ISupervisionDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(SupervisionBean.class);
	}
}
