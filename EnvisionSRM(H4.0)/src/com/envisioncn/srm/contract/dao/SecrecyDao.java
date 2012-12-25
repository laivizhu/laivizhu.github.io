/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.SecrecyBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("SecrecyDao")
public class SecrecyDao extends ABasicDao<SecrecyBean> implements ISecrecyDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(SecrecyBean.class);
	}
}
