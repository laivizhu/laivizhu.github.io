/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.ContractCancelBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("ContractCancelService")
public class ContractCancelService extends BasicService<ContractCancelBean> implements
		IContractCancelService {
	

	@Resource(name="ContractCancelDao")
	public void setBasicDao(IBasicDao<ContractCancelBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
