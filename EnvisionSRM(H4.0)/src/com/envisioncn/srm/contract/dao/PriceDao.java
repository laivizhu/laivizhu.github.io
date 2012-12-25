/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.PriceBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("PriceDao")
public class PriceDao extends ABasicDao<PriceBean> implements IPriceDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(PriceBean.class);
	}
}
