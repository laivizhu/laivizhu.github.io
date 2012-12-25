package com.envisioncn.srm.material.service;

import java.util.List;

import com.envisioncn.srm.basic.service.IBasicService;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.model.CategoryType;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
public interface IMaterialCategoryService extends IBasicService<MaterialCategory> {

	boolean isExist(CategoryType type, String name) throws Exception;

	public List<MaterialCategory> categoryListByType(CategoryType type, boolean islocked) throws Exception;

	public void updateCategoryRelation(long classify, long category, long subCategory, long team) throws Exception;

	public MaterialCategory getParentCategoryByType(long categoryId, CategoryType type) throws Exception;

	public List<MaterialCategory> getChildrenCategoryBy(long categoryId, CategoryType type) throws Exception;

}
