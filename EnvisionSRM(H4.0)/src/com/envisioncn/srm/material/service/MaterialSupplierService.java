package com.envisioncn.srm.material.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.MaterialSupplier;
import com.envisioncn.srm.material.dao.IMaterialSupplierDao;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-26
 */
@Service("MaterialSupplierService")
public class MaterialSupplierService extends BasicService<MaterialSupplier> implements IMaterialSupplierService {
	@SuppressWarnings("unused")
	private IMaterialSupplierDao materialSupplierDao;

	@Resource(name = "MaterialSupplierDao")
	public void setBasicDao(IBasicDao<MaterialSupplier> basicDao) {
		this.basicDao = basicDao;
	}

	@Resource(name = "MaterialSupplierDao")
	public void setMaterialSupplierDao(IMaterialSupplierDao materialSupplierDao) {
		this.materialSupplierDao = materialSupplierDao;
	}

}
