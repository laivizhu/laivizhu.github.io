/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.QuanlityBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("QuanlityDao")
public class QuanlityDao extends ABasicDao<QuanlityBean> implements IQuanlityDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(QuanlityBean.class);
	}
}
