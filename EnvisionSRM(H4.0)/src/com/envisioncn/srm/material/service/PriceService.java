package com.envisioncn.srm.material.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.Price;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-26
 */
@Service("MaterialPriceService")
public class PriceService extends BasicService<Price> implements IPriceService {

	@Resource(name = "MaterialPriceDao")
	public void setBasicDao(IBasicDao<Price> basicDao) {
		this.basicDao = basicDao;
	}
}
