/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.ContractExcutionBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("ContractExcutionDao")
public class ContractExcutionDao extends ABasicDao<ContractExcutionBean> implements IContractExcutionDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(ContractExcutionBean.class);
	}
}
