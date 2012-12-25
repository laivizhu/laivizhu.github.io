package com.envisioncn.srm.material.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.hibernate.criterion.Restrictions;


import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.service.IMaterialExpenditureService;


/**
 * Copyright Envision
 *
 * @author cehn.chen
 * @version 1.0
 * @data 2012-12-01
 */
@SuppressWarnings("serial")
public class MaterialExpenditureAction  extends ABasicAction<MaterialCategory>{
	
	private IMaterialExpenditureService materialExpenditureService;
	
	private Map<Long, List<MaterialCategory>> materialCategoryMap;
	
	private long categoryValue;
	//private long parentId;
	private long id;
	
	private String parentId1;
	private String parentId2;
	private String parentId3;
	private String parentId4;

	public String getParentId1()
	{
		return parentId1;
	}

	public void setParentId1(String parentId1)
	{
		this.parentId1 = parentId1;
	}

	public String getParentId2()
	{
		return parentId2;
	}

	public void setParentId2(String parentId2)
	{
		this.parentId2 = parentId2;
	}

	public String getParentId3()
	{
		return parentId3;
	}

	public void setParentId3(String parentId3)
	{
		this.parentId3 = parentId3;
	}

	public String getParentId4()
	{
		return parentId4;
	}

	public void setParentId4(String parentId4)
	{
		this.parentId4 = parentId4;
	}

	public Map<Long, List<MaterialCategory>> getMaterialCategoryMap(){
		return materialCategoryMap;
	}

	public void setMaterialCategoryMap(Map<Long, List<MaterialCategory>> materialCategoryMap){
		this.materialCategoryMap = materialCategoryMap;
	}

	public long getCategoryValue(){
		return categoryValue;
	}

	public void setCategoryValue(long categoryValue){
		this.categoryValue = categoryValue;
	}

	
	public JsonItem getJsonItem(MaterialCategory object) throws Exception {
		return null;
	}
	
	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public IMaterialExpenditureService getMaterialExpenditureService(){
		return materialExpenditureService;
	}
	@Resource(name = "MaterialExpenditureService")
	public void setMaterialExpenditureService(IMaterialExpenditureService materialExpenditureService){
		this.materialExpenditureService = materialExpenditureService;
	}

	public String categoryListByType() throws Exception {
		JsonList jsonList = new JsonList();
		CriterionSet conditions = CriterionSet.CreateCriterion();
		conditions.put(Restrictions.eq("parentId", id));
		jsonList.createItem().add("id", 0).add("name", "---请选择---");
		List<MaterialCategory> tmpList = materialExpenditureService.getMaterialCategoryList(conditions);
		for (MaterialCategory category : tmpList) {
			jsonList.createItem().add("id", category.getId()).add("name", category.getName());
		}
		return response(jsonList);
	}
	
	
	public String searchReport()throws Exception{
		return response(this.materialExpenditureService.getReportStaticValue(parentId1,parentId2,parentId3,parentId4));
	}
	
	public String searchChart()throws Exception{
		return response(this.materialExpenditureService.getChartStaticValue(parentId1,parentId2,parentId3,parentId4));
	}
}
