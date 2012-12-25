/**
 * 
 */
package com.envisioncn.srm.contract.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.ContractScanCopyBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("ContractScanCopyService")
public class ContractScanCopyService extends BasicService<ContractScanCopyBean> implements
		IContractScanCopyService {
	
	@Resource(name="ContractScanCopyDao")
	public void setBasicDao(IBasicDao<ContractScanCopyBean> basicDao){
		this.basicDao=basicDao;
	}

}
