package com.laivi.knowledge.shopping.action;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.shopping.model.po.Category;
import com.laivi.knowledge.shopping.model.type.CategoryLevel;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@SuppressWarnings("serial")
public class CategoryAction extends ABasicAction<Category> {
	private Category category;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(category.getName(),"error.shopping.category.name.notNULL");
		Integer maxPriority=(Integer)basicService.getObjectByHql("select max(priority) from Category where level="+category.getLevel(), null);
		if(maxPriority==null){
			category.setPriority(1);
		}else{
			category.setPriority(maxPriority+1);
		}
		basicService.add(category);
		return response(true);
	}
	
	public String update()throws Exception{
		ParamAssert.isNotEmptyString(category.getName(),"error.shopping.category.name.notNULL");
		Category dCategory=basicService.getObject(id);
		dCategory.setName(category.getName());
		dCategory.setLevel(category.getLevel());
		if(category.getParentId()!=0){
			dCategory.setParentId(category.getParentId());
		}
		basicService.modify(dCategory);
		return response(true);
	}
	
	public String get()throws Exception{
		Category dCategory=basicService.getObject(id);
		JsonItem item=new JsonItem();
		item.add("id", dCategory.getId())
		.add("category.name", dCategory.getName())
		.add("category.level", dCategory.getLevel())
		.add("category.parentId", dCategory.getParentId());
		return response(item.toFormDataString(true));
	}
	
	public String list()throws Exception{
		CriterionList conditions=CriterionList.CreateCriterion();
		conditions.put(Order.desc("level")).put(Order.desc("priority"));
		if(category.getLevel()!=0){
			conditions.put(Restrictions.eq("level", category.getLevel()));	
		}
		return response(list(true,true));
	}
	
	public String typeList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		for(CategoryLevel level:CategoryLevel.values()){
			jsonList.createItem().add("value", level.toValue()).add("text", level.toText());
		}
		return response(jsonList);
	}
	
	public String parentList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		CriterionList conditions=CriterionList.CreateCriterion();
		conditions.put(Order.desc("priority"));
		if(category.getLevel()!=0){
			conditions.put(Restrictions.eq("level", category.getLevel()-1));	
		}
		for(Category category:basicService.getList(conditions)){
			jsonList.createItem().add("value", category.getId()).add("text", category.getName());
		}
		return response(jsonList);
	}
	
	public String childrenList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		CriterionList conditions=CriterionList.CreateCriterion();
		conditions.put(Order.desc("priority")).put(Restrictions.eq("parentId", category.getParentId()));
		for(Category category:basicService.getList(conditions)){
			jsonList.createItem().add("value", category.getId()).add("text", category.getName());
		}
		return response(jsonList);
	}


	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		JsonItemList jsonList=new JsonItemList();
		jsonList.createItem().add("value", "name").add("text", "类别名");
		//jsonList.createItem().add("value", "level").add("text", "类别等级");
		return jsonList;
	}

	@Override
	public JsonItem getJsonItem(Category object,boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("name", object.getName())
		.add("level", CategoryLevel.fromValue(object.getLevel()).toText());
		if(object.getParentId()!=0){
			item.add("parent", basicService.getObject(object.getParentId()).getName());
		}else{
			item.add("parent", AppConstants.EMPTY);
		}
		return item;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Resource(name="CategoryService")
	public void setBasicService(IBasicService<Category> basicService){
		this.basicService=basicService;
	}
}
