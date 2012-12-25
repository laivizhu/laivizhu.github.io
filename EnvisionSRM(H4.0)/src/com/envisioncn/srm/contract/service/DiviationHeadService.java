/**
 * 
 */
package com.envisioncn.srm.contract.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.DiviationHeadBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("DiviationHeadService")
public class DiviationHeadService extends BasicService<DiviationHeadBean> implements
		IDiviationHeadService {
	
	@Resource(name="DiviationHeadDao")
	public void setBasicDao(IBasicDao<DiviationHeadBean> basicDao){
		this.basicDao=basicDao;
	}

	public long getCount(Map<String, String> conditions) {
		// TODO Auto-generated method stub
		return 0;
	}
}
