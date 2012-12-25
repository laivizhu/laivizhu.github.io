package com.envisioncn.srm.material.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.model.SRMException;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.bean.MaterialCode;
import com.envisioncn.srm.material.dao.MaterialCategoryDao;
import com.envisioncn.srm.material.dao.MaterialCodeDao;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
@Service("MaterialCodeService")
public class MaterialCodeService extends BasicService<MaterialCode> implements IMaterialCodeService {
	private MaterialCodeDao materialCodeDao;

	private MaterialCategoryDao materialCategoryDao;

	@Resource(name = "MaterialCodeDao")
	public void setBasicDao(IBasicDao<MaterialCode> basicDao) {
		this.basicDao = basicDao;
	}

	@Resource(name = "MaterialCodeDao")
	public void setMaterialCodeDao(MaterialCodeDao materialCodeDao) {
		this.materialCodeDao = materialCodeDao;
	}

	@Resource(name = "MaterialCategoryDao")
	public void setMaterialCategoryDao(MaterialCategoryDao materialCategoryDao) {
		this.materialCategoryDao = materialCategoryDao;
	}

	public void setRelation(String materialCodeName, long materialCategoryId) throws Exception {
		CriterionSet conditions = CriterionSet.CreateCriterion().put(Restrictions.eq("code", materialCodeName));
		List<MaterialCode> codes = getList(conditions);
		if (codes.size() > 0) {
			MaterialCode code = codes.get(0);
			MaterialCategory category = materialCategoryDao.getObject(materialCategoryId);
			code.setMaterialCategory(category);
			code.setModifyDate(new Date());
			materialCodeDao.modify(code);
		} else {
			throw new SRMException(ErrorMessageConstants.OBJECT_NOT_EXIST);
		}

	}

}
