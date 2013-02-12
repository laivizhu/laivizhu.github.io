package com.laivi.knowledge.user.action;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.AutoGraph;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 11, 2013
 */
@SuppressWarnings("serial")
public class AutoGraphAction extends ABasicAction<AutoGraph> {

	private AutoGraph autoGraph;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(autoGraph.getContent(), "");
		autoGraph.setUserId(this.getCurrentUserId());
		if(autoGraph.getParentId()!=0){
			AutoGraph parentAutoGraph=this.basicService.getObject(autoGraph.getParentId());
			parentAutoGraph.setParentIs(true);
			this.basicService.modify(parentAutoGraph);
		}
		this.basicService.add(autoGraph);
		return response(true);
	}
	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	
	@Override
	public JsonItem getJsonItem(AutoGraph object, boolean isSub) throws Exception {
		return null;
	}


	public AutoGraph getAutoGraph() {
		return autoGraph;
	}


	public void setAutoGraph(AutoGraph autoGraph) {
		this.autoGraph = autoGraph;
	}
	
	@Resource(name="AutoGraphService")
	public void setBasicService(IBasicService<AutoGraph> basicService){
		this.basicService=basicService;
	}

}
