package com.envisioncn.srm.material.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.Mark;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-26
 */
@Service("MarkService")
public class MarkService extends BasicService<Mark> implements IMarkService {
	@Resource(name = "MarkDao")
	public void setBasicDao(IBasicDao<Mark> basicDao) {
		this.basicDao = basicDao;
	}

}
