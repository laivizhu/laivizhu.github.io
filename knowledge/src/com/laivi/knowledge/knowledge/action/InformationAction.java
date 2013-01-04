package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.knowledge.model.po.Information;
import com.laivi.knowledge.knowledge.service.IInformationService;
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

	private IInformationService informationService;
	private IUserService userService;
	private Information information;
	
	public String add()throws Exception{
		return response();
	}
	
	public String update()throws Exception{
		return response();
	}
	
	@Override
	public JsonItem getJsonItem(Information object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("content", DataUtil.getDefaultChar(object.getContent()))
		.add("pubDate", DateUtil.formatDate(object.getPubDate()))
		.add("user", userService.getObject(object.getUserId()).getUserName());
		return item;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	@Resource(name="InformationService")
	public void setInformationService(IInformationService informationService) {
		this.informationService = informationService;
	}
	@Resource(name="InformationService")
	public void setBasicService(IBasicService<Information> basicService){
    	this.basicService=basicService;
    }
	@Resource(name="UserService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
