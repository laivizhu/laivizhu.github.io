package com.envisioncn.srm.material.dao;


import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.model.CategoryType;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
public interface IMaterialCategoryDao extends IBasicDao<MaterialCategory> {

	boolean isExist(CategoryType type, String name);
	
}
