package com.laivi.knowledge.common.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ALBasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.LBasicService;
import com.laivi.knowledge.common.model.po.Application;


/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 14, 2013
 */
@SuppressWarnings("serial")
public class ApplicationAction extends ALBasicAction<Application> {

	private Application application;
	
	public String add()throws Exception{
		this.basicService.add(application);
		return response(true);
	}
	
	public String delete()throws Exception{
		this.basicService.remove(Application.class, id);
		return response(true);
	}
	
	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	@Override
	public JsonItem getJsonItem(Application object, boolean isSub) throws Exception {
		return null;
	}

	@Resource(name="LBasicService")
	public void setBasicService(LBasicService<Application> basicService) {
		this.basicService = basicService;
	}

	@Override
	public Class<Application> getObjectClass() throws Exception {
		return Application.class;
	}

}
