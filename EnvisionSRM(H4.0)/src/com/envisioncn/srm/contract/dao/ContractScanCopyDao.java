/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.ContractScanCopyBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("ContractScanCopyDao")
public class ContractScanCopyDao extends ABasicDao<ContractScanCopyBean> implements IContractScanCopyDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(ContractScanCopyBean.class);
	}
}
