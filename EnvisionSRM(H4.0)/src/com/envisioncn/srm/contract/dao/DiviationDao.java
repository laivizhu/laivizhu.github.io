/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.DiviationBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("DiviationDao")
public class DiviationDao extends ABasicDao<DiviationBean> implements IDiviationDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(DiviationBean.class);
	}
}
