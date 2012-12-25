/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.PurchaseInstructionBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("PurchaseInstructionService")
public class PurchaseInstructionService extends BasicService<PurchaseInstructionBean> implements
		IPurchaseInstructionService {
	

	@Resource(name="PurchaseInstructionDao")
	public void setBasicDao(IBasicDao<PurchaseInstructionBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
