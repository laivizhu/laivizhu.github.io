/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.DiviationBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("DiviationService")
public class DiviationService extends BasicService<DiviationBean> implements
		IDiviationService {
	

	@Resource(name="DiviationDao")
	public void setBasicDao(IBasicDao<DiviationBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
