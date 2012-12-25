package com.envisioncn.srm.material.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.MarkTemplate;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-26
 */
@Service("MarkTemplateService")
public class MarkTemplateService extends BasicService<MarkTemplate> implements IMarkTemplateService {
	@Resource(name = "MarkTemplateDao")
	public void setBasicDao(IBasicDao<MarkTemplate> basicDao) {
		this.basicDao = basicDao;
	}

}
