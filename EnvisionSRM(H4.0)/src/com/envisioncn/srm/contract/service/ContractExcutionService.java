/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.ContractExcutionBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("ContractExcutionService")
public class ContractExcutionService extends BasicService<ContractExcutionBean> implements
		IContractExcutionService {
	

	@Resource(name="ContractExcutionDao")
	public void setBasicDao(IBasicDao<ContractExcutionBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
