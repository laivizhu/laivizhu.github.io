package com.laivi.knowledge.user.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.Group;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 11, 2013
 */
@SuppressWarnings("serial")
public class GroupAction extends ABasicAction<Group> {
	
	private Group group;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(group.getName(), "");
		group.setUserId(this.getCurrentUserId());
		return response();
	}

	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	@Override
	public JsonItem getJsonItem(Group object, boolean isSub) throws Exception {
		return null;
	}

	@Resource(name="GroupService")
	public void setBasicService(BasicService<Group> basicService){
		this.basicService=basicService;
	}
}
