package com.envisioncn.srm.material.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.Quota;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-26
 */
@Service("QuotaService")
public class QuotaService extends BasicService<Quota> implements IQuotaService {

	@Resource(name = "QuotaDao")
	public void setBasicDao(IBasicDao<Quota> basicDao) {
		this.basicDao = basicDao;
	}

}
