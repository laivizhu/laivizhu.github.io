/**
 * 
 */
package com.envisioncn.srm.material.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.MaterialGroup;
import com.envisioncn.srm.material.dao.MaterialGroupDao;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-18
 */
@Service("MaterialGroupService")
public class MaterialGroupService extends BasicService<MaterialGroup> implements IMaterialGroupService {
	@SuppressWarnings("unused")
	private MaterialGroupDao materialGroupDao;

	@Resource(name = "MaterialGroupDao")
	public void setBasicDao(IBasicDao<MaterialGroup> basicDao) {
		this.basicDao = basicDao;
	}

	@Resource(name = "MaterialGroupDao")
	public void setMaterialGroupDao(MaterialGroupDao materialGroupDao) {
		this.materialGroupDao = materialGroupDao;
	}

}
