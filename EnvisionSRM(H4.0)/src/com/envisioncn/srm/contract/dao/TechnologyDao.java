/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.TechnologyBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("TechnologyDao")
public class TechnologyDao extends ABasicDao<TechnologyBean> implements ITechnologyDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(TechnologyBean.class);
	}
}
