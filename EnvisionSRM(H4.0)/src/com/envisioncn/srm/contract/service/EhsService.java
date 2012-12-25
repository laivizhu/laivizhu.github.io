/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.EhsBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("EhsService")
public class EhsService extends BasicService<EhsBean> implements
		IEhsService {
	

	@Resource(name="EhsDao")
	public void setBasicDao(IBasicDao<EhsBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
