package com.envisioncn.srm.material.action;

import javax.annotation.Resource;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.material.bean.Mark;
import com.envisioncn.srm.material.service.IMarkService;
import com.envisioncn.srm.material.service.IMarkTemplateService;
import com.envisioncn.srm.material.service.IMarkWeightService;

/**
 * Copyright Envision
 *
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-12-4
 */
@SuppressWarnings("serial")
public class MaterialMarkAction extends ABasicAction<Mark> {
	private IMarkService markService;
	private IMarkTemplateService markTemplateService;
	private IMarkWeightService markWeghtService;

	public JsonItem getJsonItem(Mark object) throws Exception {
		return null;
	}
	

	@Resource(name="MarkService")
	public void setMarkService(IMarkService markService) {
		this.markService = markService;
	}

	@Resource(name="MarkTemplateService")
	public void setMarkTemplateService(IMarkTemplateService markTemplateService) {
		this.markTemplateService = markTemplateService;
	}
	@Resource(name="MarkWeghtService")
	public void setMarkWeghtService(IMarkWeightService markWeghtService) {
		this.markWeghtService = markWeghtService;
	}
}
