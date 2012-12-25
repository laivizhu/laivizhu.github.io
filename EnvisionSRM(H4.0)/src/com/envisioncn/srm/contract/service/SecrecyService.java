/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.SecrecyBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("SecrecyService")
public class SecrecyService extends BasicService<SecrecyBean> implements
		ISecrecyService {
	

	@Resource(name="SecrecyDao")
	public void setBasicDao(IBasicDao<SecrecyBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
