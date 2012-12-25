/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.SupervisionBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("SupervisionService")
public class SupervisionService extends BasicService<SupervisionBean> implements
		ISupervisionService {
	

	@Resource(name="SupervisionDao")
	public void setBasicDao(IBasicDao<SupervisionBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
