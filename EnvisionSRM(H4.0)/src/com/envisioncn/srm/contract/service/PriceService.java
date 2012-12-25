/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.PriceBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("PriceService")
public class PriceService extends BasicService<PriceBean> implements
		IPriceService {
	

	@Resource(name="PriceDao")
	public void setBasicDao(IBasicDao<PriceBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
