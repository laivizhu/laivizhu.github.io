/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.DiviationHeadBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("DiviationHeadDao")
public class DiviationHeadDao extends ABasicDao<DiviationHeadBean> implements IDiviationHeadDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(DiviationHeadBean.class);
	}
}
