package com.envisioncn.srm.material.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.MarkWeight;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-26
 */
@Service("MarkWeightService")
public class MarkWeightService extends BasicService<MarkWeight> implements IMarkWeightService {
	@Resource(name = "MarkWeightDao")
	public void setBasicDao(IBasicDao<MarkWeight> basicDao) {
		this.basicDao = basicDao;
	}

}
