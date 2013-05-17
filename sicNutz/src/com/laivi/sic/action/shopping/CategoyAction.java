package com.laivi.sic.action.shopping;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonItemList;
import com.laivi.sic.model.po.shopping.Category;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.CategoryLevel;

@IocBean
@At("/shopping/category")
public class CategoyAction extends ABasicDBAction<Category> {
	
	@At
	@CheckValue
	@CheckLogin
	public Response add(@Param("::category")Category category){
		category.setPriority(dao.func(Category.class,"max","priority")+1);
		dao.insert(category);
		return success();
	}
	
	@At
	@CheckValue
	@CheckLogin
	public Response update(@Param("::category")Category category){
		Category dCategory=dao.fetch(Category.class,category.getId());
		dCategory.setName(category.getName());
		dCategory.setLevel(category.getLevel());
		if(category.getParentId()!=0){
			dCategory.setParentId(category.getParentId());
		}
		dao.update(dCategory);
		return success();
	}
	
	@At
	public Object typeList(){
		JsonItemList jsonList=new JsonItemList();
		for(CategoryLevel level:CategoryLevel.values()){
			jsonList.createItem().add("value", level.name()).add("text", level.toText());
		}
		return jsonList.toList();
	}
	
	@At
	public Object parentList(@Param("::category")Category category){
		JsonItemList jsonList=new JsonItemList();
		if(category.getLevel()!=null){
			this.cnd=Cnd.where("level", "=", category.getLevel()).desc("priority");
		}else{
			this.cnd=Cnd.orderBy().desc("priority");
		}
		for(Category dcategory:dao.query(Category.class,this.cnd)){
			jsonList.createItem().add("value", dcategory.getId()).add("text", dcategory.getName());
		}
		return null;
	}
	
	@At
	public Object childrenList(@Param("::category")Category category){
		JsonItemList jsonList=new JsonItemList();
		for(Category dcategory:dao.query(Category.class, Cnd.where("parentId", "=", category.getParentId()).desc("priority"))){
			jsonList.createItem().add("value", dcategory.getId()).add("text", dcategory.getName());
		}
		return jsonList.toList();	
	}

	@Override
	public Class<Category> getEntityClass() {
		return Category.class;
	}

}
