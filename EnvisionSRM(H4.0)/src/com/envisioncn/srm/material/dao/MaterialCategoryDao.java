package com.envisioncn.srm.material.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.model.CategoryType;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
@Service("MaterialCategoryDao")
public class MaterialCategoryDao extends ABasicDao<MaterialCategory> implements IMaterialCategoryDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(MaterialCategory.class);
	}

	public boolean isExist(CategoryType type, String name) {
		Criteria dc = this.getCriteria();
		dc.add(Restrictions.eq("categoryType", type.toText()));
		dc.add(Restrictions.eq("name", name));
		if (dc.list().size() > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<MaterialCategory> listCategoryByType(CategoryType type, boolean islocked) {
		Criteria dc = this.getCriteria();
		dc.add(Restrictions.eq("categoryType", type.toText())).add(Restrictions.eq("islock", islocked));
		return dc.list();
	}

	public void setCategoryRelation(long classifyId, long categoryId, long subCategoryId, long teamId) {
		MaterialCategory classify = this.getObject(classifyId);
		MaterialCategory category = this.getObject(categoryId);
		MaterialCategory subCategory = this.getObject(subCategoryId);
		MaterialCategory team = this.getObject(teamId);
		category.setParentId(classifyId);
		subCategory.setParentId(categoryId);
		team.setParentId(subCategoryId);
		team.setModifyDate(new Date());
		subCategory.setModifyDate(new Date());
		category.setModifyDate(new Date());
		classify.setModifyDate(new Date());
		this.modify(classify);
		this.modify(category);
		this.modify(subCategory);
		this.modify(team);
	}

}
