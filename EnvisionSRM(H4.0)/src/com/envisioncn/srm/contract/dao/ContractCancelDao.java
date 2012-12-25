/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.ContractCancelBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("ContractCancelDao")
public class ContractCancelDao extends ABasicDao<ContractCancelBean> implements IContractCancelDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(ContractCancelBean.class);
	}
}
