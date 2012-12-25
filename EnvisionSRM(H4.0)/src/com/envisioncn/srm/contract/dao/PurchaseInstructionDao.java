/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.PurchaseInstructionBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("PurchaseInstructionDao")
public class PurchaseInstructionDao extends ABasicDao<PurchaseInstructionBean> implements IPurchaseInstructionDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(PurchaseInstructionBean.class);
	}
}
