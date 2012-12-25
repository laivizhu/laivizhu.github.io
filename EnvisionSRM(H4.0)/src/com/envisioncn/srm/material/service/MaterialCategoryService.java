package com.envisioncn.srm.material.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.dao.MaterialCategoryDao;
import com.envisioncn.srm.material.model.CategoryType;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
@Service("MaterialCategoryService")
public class MaterialCategoryService extends BasicService<MaterialCategory> implements IMaterialCategoryService {
	private MaterialCategoryDao materialCategoryDao;

	@Resource(name = "MaterialCategoryDao")
	public void setBasicDao(IBasicDao<MaterialCategory> basicDao) {
		this.basicDao = basicDao;
	}

	@Resource(name = "MaterialCategoryDao")
	public void setMaterialCategoryDao(MaterialCategoryDao basicDao) {
		this.materialCategoryDao = basicDao;
	}

	@Override
	public void remove(long id) throws Exception {
		// MaterialCategory category=materialCategoryDao.getObject(id);
		CriterionSet conditions = CriterionSet.CreateCriterion().put(Restrictions.eq("parentId", id));
		if (this.getCount(conditions) == 0) {
			super.remove(id);
		}
	}

	public boolean isExist(CategoryType type, String name) throws Exception {
		return materialCategoryDao.isExist(type, name);
	}

	public List<MaterialCategory> categoryListByType(CategoryType type, boolean islocked) throws Exception {
		return materialCategoryDao.listCategoryByType(type, islocked);
	}

	public void updateCategoryRelation(long classifyId, long categoryId, long subCategoryId, long teamId)
			throws Exception {
		materialCategoryDao.setCategoryRelation(classifyId, categoryId, subCategoryId, teamId);
	}

	public MaterialCategory getParentCategoryByType(long categoryId, CategoryType type) throws Exception {
		MaterialCategory category = materialCategoryDao.getObject(categoryId);
		CategoryType currentType = CategoryType.fromValue(category.getCategoryType());
		if (type.toValue() == currentType.toValue()) {
			return category;
		} else if (type.toValue() < currentType.toValue()) {
			return getParentCategoryByType(category.getParentId(), type);
		} else {
			return null;
		}
	}

	public List<MaterialCategory> getChildrenCategoryBy(long categoryId, CategoryType type) throws Exception {
		MaterialCategory category = materialCategoryDao.getObject(categoryId);
		CategoryType currentType = CategoryType.fromValue(category.getCategoryType());
		if (currentType.toValue() == 3 || type.toValue() < currentType.toValue()) {
			return null;
		} else if (type.toValue() == currentType.toValue()) {
			// CriterionSet
			// conditions=CriterionSet.CreateCriterion().put(Restrictions.eq("parentId",
			// category.getId()));

		} else {

		}
		return null;
	}

}
