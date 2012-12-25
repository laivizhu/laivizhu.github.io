/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.LogisticBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("LogisticService")
public class LogisticService extends BasicService<LogisticBean> implements
		ILogisticService {
	

	@Resource(name="LogisticDao")
	public void setBasicDao(IBasicDao<LogisticBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
