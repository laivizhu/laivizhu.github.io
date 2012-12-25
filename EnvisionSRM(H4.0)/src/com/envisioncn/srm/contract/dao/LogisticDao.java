/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.LogisticBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("LogisticDao")
public class LogisticDao extends ABasicDao<LogisticBean> implements ILogisticDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(LogisticBean.class);
	}
}
