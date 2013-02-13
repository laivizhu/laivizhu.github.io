package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.knowledge.model.po.Information;
import com.laivi.knowledge.knowledge.model.type.InformationLevel;
import com.laivi.knowledge.user.service.IUserService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
@SuppressWarnings("serial")
public class InformationAction extends ABasicAction<Information> {

	private IUserService userService;
	private Information information;
	private int type;
	
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(information.getTitle(), "error.information.title.notNULL");
		ParamAssert.isNotEmptyString(information.getContent(), "error.information.content.notNULL");
		information.setUserId(getCurrentUserId());
		this.basicService.add(information);
		return response(true);
	}
	
	public String update()throws Exception{
		ParamAssert.isNotEmptyString(information.getTitle(), "error.information.title.notNULL");
		ParamAssert.isNotEmptyString(information.getContent(), "error.information.content.notNULL");
		Information info=this.basicService.getObject(id);
		info.setTitle(information.getTitle());
		info.setContent(information.getContent());
		info.setLevel(information.getLevel());
		this.basicService.modify(info);
		return response(true);
	}
	
	public String getIndexList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		CriterionList conditions=CriterionList.CreateCriterion().put(Order.desc("createDate"));
		for(Information info:this.basicService.getList(conditions, 0, AppConstants.INDEXSIZE)){
			jsonList.createItem().add("url", "knowledge/information_view.jsp?id="+info.getId())
			.add("title", info.getTitle()).add("createDate", DateUtil.formatDate(info.getCreateDate()));
		}
		return response(jsonList);
	}
	
	public String get()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		Information info=this.basicService.getObject(id);
		JsonItem item=new JsonItem();
		if(type==1){
			item=this.getJsonItem(info,false);
		}else{
			item.add("id", info.getId()).add("information.title", info.getTitle()).add("information.content", info.getContent())
			.add("information.level", info.getLevel());
		}
		return response(item.toFormDataString(true));
	}
	
	public String list()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		CriterionList conditions=CriterionList.CreateCriterion();
		conditions.put(Order.desc("level")).put(Order.desc("createDate"));
		for(Information info:this.basicService.getList(conditions,start,limit)){
			jsonList.add(this.getJsonItem(info,true));
		}
		return response(jsonList.toPageString(basicService.getCount(conditions)));
	}
	
	public String typeList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		for(InformationLevel type:InformationLevel.values()){
			jsonList.createItem().add("value", type.name()).add("text", type.toText());
		}
		return response(jsonList);
	}
	
	public JsonItem getJsonItem(Information object,boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("content", DataUtil.getDefaultChar(object.getContent()))
		.add("createDate", DateUtil.formatDate(object.getCreateDate()))
		.add("level",object.getLevel().toText())
		.add("user", userService.getObject(object.getUserId()).getUserName());
		return item;
	}
	
	public JsonItemList getSearchComboList()throws ErrorException{
		JsonItemList jsonList=new JsonItemList();
		return jsonList;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	@Resource(name="InformationService")
	public void setBasicService(IBasicService<Information> basicService){
    	this.basicService=basicService;
    }
	@Resource(name="UserService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
