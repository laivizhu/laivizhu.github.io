/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.QuanlityBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("QuanlityService")
public class QuanlityService extends BasicService<QuanlityBean> implements
		IQuanlityService {
	

	@Resource(name="QuanlityDao")
	public void setBasicDao(IBasicDao<QuanlityBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
