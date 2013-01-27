package com.laivi.knowledge.shopping.action;

import java.io.File;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.annotation.HistoryRecordTag;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.type.ResponseType;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.FileUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.shopping.model.constant.ShoppingConstants;
import com.laivi.knowledge.shopping.model.po.Category;
import com.laivi.knowledge.shopping.model.po.Commodity;
import com.laivi.knowledge.shopping.service.ICategoryService;
import com.laivi.knowledge.shopping.service.ICommodityService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@SuppressWarnings("serial")
public class CommodityAction extends ABasicAction<Commodity> {
	
	private ICommodityService commodityService;
	private ICategoryService categoryService;
	private Commodity commodity;
	private long categoryId;
	private File picture;
	private String pictureFileName;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(commodity.getName(), "error.shopping.commodity.name.notNULL");
		ParamAssert.isNotEmptyString(commodity.getDescription(), "error.shopping.commodity.description.notNULL");
		ParamAssert.isTrue(commodity.getPrice()>0, "error.shopping.commodity.price.notNULL");
		ParamAssert.isTrue(commodity.getSaveCount()>0, "error.shopping.commodity.saveCount.notNULL");
		ParamAssert.isTrue(categoryId>0, "error.shopping.commodity.category.notNULL");
		ParamAssert.isNotNull(picture, "error.shopping.commodity.pictrue.notNULL");
		Category category=this.categoryService.getObject(categoryId);
		commodity.setCategory(category);
		commodity.setPicturePath(FileUtil.saveCodingFile(picture,this.getRealPath(ShoppingConstants.PICTURE_PATH), pictureFileName));
		this.commodityService.add(commodity);
		return response(ResponseType.HTML,"{success:true}");
	}
	
	public String update()throws Exception{
		ParamAssert.isTrue(id>0, "");
		ParamAssert.isNotEmptyString(commodity.getName(), "error.shopping.commodity.name.notNULL");
		ParamAssert.isNotEmptyString(commodity.getDescription(), "error.shopping.commodity.description.notNULL");
		ParamAssert.isTrue(commodity.getPrice()>0, "error.shopping.commodity.price.notNULL");
		ParamAssert.isTrue(commodity.getSaveCount()>0, "error.shopping.commodity.saveCount.notNULL");
		ParamAssert.isTrue(categoryId>0, "error.shopping.commodity.category.notNULL");
		Category category=this.categoryService.getObject(categoryId);
		Commodity dCommodity=this.commodityService.getObject(id);
		dCommodity.setName(commodity.getName());
		dCommodity.setCategory(category);
		dCommodity.setDescription(commodity.getDescription());
		dCommodity.setPrice(commodity.getPrice());
		dCommodity.setSaveCount(commodity.getSaveCount());
		if(picture!=null){
			dCommodity.setPicturePath(FileUtil.saveCodingFile(picture,this.getRealPath(ShoppingConstants.PICTURE_PATH), pictureFileName));
		}
		this.commodityService.modify(dCommodity);
		return response(ResponseType.HTML,"{success:true}");
	}
	
	@HistoryRecordTag
	public String get()throws Exception{
		Commodity commodity=this.commodityService.getObject(id);
		JsonItem item=new JsonItem();
		if(font){
			item=this.getJsonItem(commodity, false);
		}else{
			item.add("id", commodity.getId())
			.add("commodity.name", commodity.getName()).add("commodity.description", commodity.getDescription())
			.add("commodity.price", commodity.getPrice()).add("commodity.saveCount", commodity.getSaveCount())
			.add("categoryId", commodity.getCategory().getId())
			.add("secondCategoryId", commodity.getCategory().getParentId())
			.add("rootCategoryId", this.categoryService.getObject(commodity.getCategory().getParentId()).getParentId());
		}
		return response(item.toFormDataString(true));
	}
	
	public String list()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		for(Commodity commodity:this.commodityService.getList(start,limit)){
			jsonList.add(this.getJsonItem(commodity,true));
		}
		return response(jsonList.toPageString(this.commodityService.getCount()));
	}
	
	public String categoryList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		CriterionList conditions=CriterionList.CreateCriterion();
		Long[] parentIds=this.categoryService.getListIds(this.categoryService.getList(conditions.put(Restrictions.eq("parentId", categoryId))));
		DetachedCriteria dc=DetachedCriteria.forClass(Commodity.class);
		dc.createAlias("category", "c").add(Restrictions.in("c.parentId", parentIds));
		for(Commodity commodity:this.commodityService.getList(dc,start,limit)){
			jsonList.add(this.getJsonItem(commodity,true));
		}
		return response(jsonList.toPageString(this.commodityService.getCount(dc)));
	}
	

	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		JsonItemList jsonList=new JsonItemList();
		jsonList.createItem().add("text", "商品名").add("value", "name");
		jsonList.createItem().add("text", "商品价格").add("value", "price");
		jsonList.createItem().add("text", "商品存量").add("value", "saveCount");
		jsonList.createItem().add("text", "商品描述").add("value", "desciption");
		return jsonList;
	}

	@Override
	public JsonItem getJsonItem(Commodity object,boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("name", object.getName())
		.add("pictrue", object.getPicturePath())
		.add("description", object.getDescription())
		.add("price", object.getPrice())
		.add("category", object.getCategory().getName())
		.add("saveCount", object.getSaveCount());
		return item;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Resource(name="CommodityService")
	public void setCommodityService(ICommodityService commodityService) {
		this.commodityService = commodityService;
	}
	@Resource(name="CommodityService")
	public void setBasicService(IBasicService<Commodity> basicService){
		this.basicService=basicService;
	}
	@Resource(name="CategoryService")
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

}
