/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.ContractBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("ContractDao")
public class ContractDao extends ABasicDao<ContractBean> implements IContractDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(ContractBean.class);
	}
}
