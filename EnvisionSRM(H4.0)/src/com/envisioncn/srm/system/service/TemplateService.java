/**
 * 
 */
package com.envisioncn.srm.system.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.system.bean.Template;

/**
 * Copyright Envision
 *
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-25
 */
@Service("TemplateService")
public class TemplateService extends BasicService<Template> implements ITemplateService {

	@Resource(name="TemplateDao")
	public void setBasicDao(IBasicDao<Template> basicDao){
		this.basicDao=basicDao;
	}

}
