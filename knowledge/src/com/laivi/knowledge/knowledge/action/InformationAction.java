package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.knowledge.model.po.Information;
import com.laivi.knowledge.knowledge.service.IInformationService;

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
	private Information information;
	
	@Override
	public JsonItem getJsonItem(Information object) throws Exception {
		return null;
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

}
