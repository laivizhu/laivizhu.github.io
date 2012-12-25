package com.envisioncn.srm.material.action;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.model.constants.MaterialConstants;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.basic.util.DataUtil;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.ParamAssert;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.model.CategorySearchConditionType;
import com.envisioncn.srm.material.model.CategoryType;
import com.envisioncn.srm.material.service.IMaterialCategoryService;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
@SuppressWarnings("serial")
public class MaterialCategoryAction extends ABasicAction<MaterialCategory> {
	private MaterialCategory materialCategory;
	private IMaterialCategoryService materialCategoryService;

	private int categoryValue;
	private long classify;
	private long category;
	private long subCategory;
	private long team;

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-18 修改内容
	 * 
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return String
	 * @throws
	 */
	public String search() throws Exception {
		try {
			ParamAssert.isNotEmptyString(key, ErrorMessageConstants.SEARCH_KEY_NOTEMPTY);
			CriterionSet conditions = null;
			if (DataUtil.notEmptyString(value)) {
				conditions = CriterionSet.CreateCriterion();
				if (key.indexOf("Date") != -1) {
					conditions.put(Restrictions.between(key, DateUtil.formatString(value),
							DateUtil.formateAddOneDate(value)));
				} else {
					conditions.put(Restrictions.like(encodeString(key), encodeString(value), MatchMode.ANYWHERE));
				}

			}
			JsonList jsonList = new JsonList();
			for (MaterialCategory category : materialCategoryService.getList(conditions, start, limit)) {
				jsonList.add(getCategoryJsonItem(category));
			}
			return response(jsonList.toPageString(materialCategoryService.getCount(conditions)));
		} catch (Exception e) {
			return response();
		}
	}

	public String add() throws Exception {
		ParamAssert.isNotEmptyString(materialCategory.getName(),
				MaterialConstants.ErrorMessage.MATERIAL_CATEGORY_NAME_NOTNULL);
		ParamAssert.isNotNull(materialCategory.getCategoryType(),
				MaterialConstants.ErrorMessage.MATERIAL_CATEGORY_TYPE_NOTNULL);
		materialCategory.setCreateDate(new Date());
		materialCategory.setIslock(false);
		if (!materialCategoryService.isExist(CategoryType.fromValue(materialCategory.getCategoryType()),
				materialCategory.getName())) {
			materialCategoryService.add(materialCategory);
			return response(true);
		} else {
			return response(false, ErrorMessageConstants.OBJECT_HASEXIST);
		}
	}

	public String delete() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		MaterialCategory category = this.materialCategoryService.getObject(id);
		if (category == null) {
			return response(false, ErrorMessageConstants.OBJECT_NOT_EXIST);
		} else {
			if (this.materialCategoryService.getCount(CriterionSet.CreateCriterion().put(
					Restrictions.eq("parentId", category.getId()))) > 0) {
				return response(false, MaterialConstants.ErrorMessage.CATEGORY_EXIST_CHILDREN);
			}
			try {
				materialCategoryService.remove(id);
				return response(true);
			} catch (Exception e) {
				return response(false, ErrorMessageConstants.DELETE_FAILURE);
			}

		}
	}

	public String deleteRelation() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		MaterialCategory category = materialCategoryService.getObject(id);
		category.setParentId(0);
		category.setIslock(false);
		materialCategoryService.modify(category);
		return response(true);
	}

	public String update() throws Exception {
		try {
			ParamAssert.isNotNull(materialCategory.getName(),
					MaterialConstants.ErrorMessage.MATERIAL_CATEGORY_NAME_NOTNULL);
			MaterialCategory tempCategory = materialCategoryService.getObject(id);
			if (CategoryType.MaterialTeam.toText().equals(tempCategory.getCategoryType())) {
				materialCategoryService.updateCategoryRelation(classify, category, subCategory, id);
			}
			if (!tempCategory.getName().equals(materialCategory.getName())) {
				tempCategory.setName(materialCategory.getName());
				materialCategoryService.modify(tempCategory);
			}
			return SUCCESS;
		} catch (Exception e) {
			return response();
		}
	}

	public String list() throws Exception {
		JsonList jsonList = new JsonList();
		CriterionSet conditions = CriterionSet.CreateCriterion()
				.put(Restrictions.eq("categoryType", CategoryType.MaterialTeam.toText()))
				.put(Restrictions.ne("parentId", (long) 0));
		for (MaterialCategory category : materialCategoryService.getList(conditions, start, limit)) {
			jsonList.add(getJsonItem(category));
		}
		return response(jsonList.toPageString(materialCategoryService.getCount(conditions)));
	}

	public String get() throws Exception {
		MaterialCategory tempMaterialCategory = materialCategoryService.getObject(id);
		JsonItem item = new JsonItem();
		item.add("name", tempMaterialCategory.getName());
		return response(item.toFormDataString(true));
	}

	/**
	 * 
	 * description:设置物料类别之间的关联关系 data 2012-11-17 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	public String settingRelation() throws Exception {
		ParamAssert.isTrue(classify != 0, MaterialConstants.ErrorMessage.MATERIAL_CLASSIFY_NOTCHOOSE);
		ParamAssert.isTrue(category != 0, MaterialConstants.ErrorMessage.MATERIAL_CATEGORY_NOTCHOOSE);
		ParamAssert.isTrue(subCategory != 0, MaterialConstants.ErrorMessage.MATERIAL_SUBCATEGORY_NOTCHOOSE);
		ParamAssert.isTrue(team != 0, MaterialConstants.ErrorMessage.MATERIAL_TEAM_NOTCHOOSE);
		materialCategoryService.updateCategoryRelation(classify, category, subCategory, team);
		return response(true);
	}

	/**
	 * 
	 * description:物料类型列表 data 2012-11-17 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	public String categoryList() throws Exception {
		JsonList jsonList = new JsonList();
		for (CategoryType type : CategoryType.values()) {
			jsonList.createItem().add("id", type.toText()).add("name", type.toText());
		}
		return response(jsonList);
	}

	public String categoryTableList() throws Exception {
		JsonList jsonList = new JsonList();
		for (MaterialCategory category : materialCategoryService.getList(start, limit)) {
			jsonList.add(getCategoryJsonItem(category));
		}
		return response(jsonList.toPageString(materialCategoryService.getCount()));
	}

	/**
	 * 
	 * description:类别查询条件列表 data 2012-11-17 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	public String categorySearchConditionList() throws Exception {
		JsonList jsonList = new JsonList();
		for (CategorySearchConditionType condition : CategorySearchConditionType.values()) {
			jsonList.createItem().add("id", condition.toProperty()).add("name", condition.toText());
		}
		return response(jsonList);
	}

	/**
	 * 
	 * 函数功能说明: 修改者名字Janlu 修改日期 2012-11-18 修改内容
	 * 
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return String
	 * @throws
	 */
	public String categoryListByType() throws Exception {
		JsonList jsonList = new JsonList();
		CriterionSet conditions = CriterionSet.CreateCriterion();
		if (id != 0) {
			conditions.put(Restrictions.eq("parentId", id));
		} else {
			conditions.put(Restrictions.eq("categoryType", CategoryType.fromValue(categoryValue).toText()));
		}
		jsonList.createItem().add("id", 0).add("name", AppConstants.EMPTY);
		for (MaterialCategory category : materialCategoryService.getList(conditions)) {
			if (CategoryType.MaterialTeam.toText().equals(CategoryType.fromValue(categoryValue).toText()) && id == 0) {
				if (category.getParentId() == 0) {
					jsonList.createItem().add("id", category.getId()).add("name", category.getName());
				}
			} else {
				jsonList.createItem().add("id", category.getId()).add("name", category.getName());
			}
		}
		return response(jsonList);
	}

	public JsonItem getCategoryJsonItem(MaterialCategory category) throws Exception {
		JsonItem item = new JsonItem();
		item.add("id", category.getId()).add("categoryType", category.getCategoryType())
				.add("name", category.getName()).add("createDate", DateUtil.formatDate(category.getCreateDate()));
		if (category.isIslock()) {
			item.add("islock", "已锁");
		} else {
			item.add("islock", "未锁");
		}
		return item;
	}

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-18 修改内容
	 * 
	 * @参数： @param team
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return JsonItem
	 * @throws
	 */
	public JsonItem getJsonItem(MaterialCategory team) throws Exception {
		JsonItem item = new JsonItem();
		item.add("id", team.getId()).add("createDate", DateUtil.formatDate(team.getCreateDate()))
				.add("modifyDate", DateUtil.formatDate(team.getModifyDate()));
		switch (CategoryType.fromValue(team.getCategoryType())) {
		case MaterialCategory:
			getCategoryJsonItem(team, item);
			item.add("name", MaterialConstants.InfoMessage.SUB_EMPTY);
			item.add("subCategory", MaterialConstants.InfoMessage.SUB_EMPTY);
			break;
		case MaterialClassify:
			getClassifyJsonItem(team, item);
			item.add("name", MaterialConstants.InfoMessage.SUB_EMPTY);
			item.add("subCategory", MaterialConstants.InfoMessage.SUB_EMPTY);
			item.add("category", MaterialConstants.InfoMessage.SUB_EMPTY);
			break;
		case MaterialSubCategory:
			getSubCategoryJsonItem(team, item);
			item.add("name", MaterialConstants.InfoMessage.SUB_EMPTY);
			break;
		case MaterialTeam:
			getTeamCategoryJsonItem(team, item);
			break;

		}
		return item;
	}

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-18 修改内容
	 * 
	 * @参数： @param team
	 * @参数： @param item
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return JsonItem
	 * @throws
	 */
	private JsonItem getTeamCategoryJsonItem(MaterialCategory team, JsonItem item) throws Exception {
		item.add("name", team.getName());
		if (team.getParentId() != 0) {
			getSubCategoryJsonItem(materialCategoryService.getObject(team.getParentId()), item);
		} else {
			item.add("subCategory", MaterialConstants.InfoMessage.TABLE_EMPTY);
			item.add("category", MaterialConstants.InfoMessage.TABLE_EMPTY);
			item.add("classify", MaterialConstants.InfoMessage.TABLE_EMPTY);
		}
		return item;
	}

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-18 修改内容
	 * 
	 * @参数： @param subCategory
	 * @参数： @param item
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return JsonItem
	 * @throws
	 */
	private JsonItem getSubCategoryJsonItem(MaterialCategory subCategory, JsonItem item) throws Exception {
		item.add("subCategory", subCategory.getName());
		if (subCategory.getParentId() != 0) {
			getCategoryJsonItem(materialCategoryService.getObject(subCategory.getParentId()), item);
		} else {
			item.add("category", MaterialConstants.InfoMessage.TABLE_EMPTY);
			item.add("classify", MaterialConstants.InfoMessage.TABLE_EMPTY);
		}
		return item;
	}

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-18 修改内容
	 * 
	 * @参数： @param category
	 * @参数： @param item
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return JsonItem
	 * @throws
	 */
	private JsonItem getCategoryJsonItem(MaterialCategory category, JsonItem item) throws Exception {
		item.add("category", category.getName());
		if (category.getParentId() != 0) {
			getClassifyJsonItem(materialCategoryService.getObject(category.getParentId()), item);
		} else {
			item.add("classify", MaterialConstants.InfoMessage.TABLE_EMPTY);
		}
		return item;
	}

	/**
	 * 
	 * 函数功能说明 修改者名字Janlu 修改日期 2012-11-18 修改内容
	 * 
	 * @参数： @param classify
	 * @参数： @param item
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return JsonItem
	 * @throws
	 */
	private JsonItem getClassifyJsonItem(MaterialCategory classify, JsonItem item) throws Exception {
		item.add("classify", classify.getName());
		return item;
	}

	@Resource(name = "MaterialCategoryService")
	public void setMaterialCategoryService(IMaterialCategoryService materialCategoryService) {
		this.materialCategoryService = materialCategoryService;
	}

	public MaterialCategory getMaterialCategory() {
		return materialCategory;
	}

	public void setMaterialCategory(MaterialCategory materialCategory) {
		this.materialCategory = materialCategory;
	}

	public int getCategoryValue() {
		return categoryValue;
	}

	public void setCategoryValue(int categoryValue) {
		this.categoryValue = categoryValue;
	}

	public long getClassify() {
		return classify;
	}

	public void setClassify(long classify) {
		this.classify = classify;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public long getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(long subCategory) {
		this.subCategory = subCategory;
	}

	public long getTeam() {
		return team;
	}

	public void setTeam(long team) {
		this.team = team;
	}
}
