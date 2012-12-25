package com.envisioncn.srm.material.service;

import java.util.List;

import net.sf.json.JSONArray;

import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.bean.MaterialExpenditure;


/**
 * Copyright Envision
 *
 * @author cehn.chen
 * @version 1.0
 * @data 2012-11-28
 */
public interface IMaterialExpenditureService{
	
	/**
	 * 得到统计信息
	 * 
	 * @param parentId1 物料小组
	 * @param parentId2 物料子分类
	 * @param parentId3 物料分类
	 * @param parentId4 物料类别
	 * @return JSONArray，     第一个map key：地名（单位：国内以省，国外以国家），value：数量
	 * 						第二个map key：地名（单位：国内以省，国外以国家），value：金额
	 * 						第三个map key：供应商名，value：金额
	 * 						第四个map key：物料小组，value：金额
	 */
	JSONArray getChartStaticValue(String parentId1, String parentId2, String parentId3, String parentId4);

	List<MaterialCategory> getMaterialCategoryList(CriterionSet conditions);
	
	List<MaterialExpenditure> getMaterialExpenditureList(CriterionSet conditions);

	JsonList getReportStaticValue(String parentId1, String parentId2, String parentId3, String parentId4);
	
}
