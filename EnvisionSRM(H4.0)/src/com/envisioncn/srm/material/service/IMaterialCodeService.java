package com.envisioncn.srm.material.service;

import com.envisioncn.srm.basic.service.IBasicService;
import com.envisioncn.srm.material.bean.MaterialCode;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
public interface IMaterialCodeService extends IBasicService<MaterialCode> {

	void setRelation(String materialCodeName, long materialCategoryId) throws Exception;

}
