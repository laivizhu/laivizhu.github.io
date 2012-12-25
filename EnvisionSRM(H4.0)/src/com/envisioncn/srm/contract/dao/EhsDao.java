/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.EhsBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("EhsDao")
public class EhsDao extends ABasicDao<EhsBean> implements IEhsDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(EhsBean.class);
	}
}
