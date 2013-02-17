package com.laivi.knowledge.common.action;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ALBasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.LBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.common.model.po.FromOther;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 17, 2013
 */
@SuppressWarnings("serial")
public class FromOtherAction extends ALBasicAction<FromOther> {

	private FromOther fromOther;
	
	public String add()throws Exception{
		long userId=this.getCurrentUserId();
		this.conditions=CriterionList.CreateCriterion()
				.put(Restrictions.eq("userId", userId))
				.put(Restrictions.eq("objectId", fromOther.getObjectId()))
				.put(Restrictions.eq("type", fromOther.getType()));
		ParamAssert.isTrue(this.basicService.getCount(this.getObjectClass(), conditions)==0,"");
		fromOther.setUserId(userId);
		this.basicService.add(fromOther);
		return response(true);
	}
	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	
	@Override
	public JsonItem getJsonItem(FromOther object, boolean isSub) throws Exception {
		return null;
	}

	@Override
	public Class<FromOther> getObjectClass() throws Exception {
		return FromOther.class;
	}
	
	@Resource(name="LBasicService")
	public void setBasicService(LBasicService<FromOther> basicService){
		this.basicService=basicService;
	}

	public FromOther getFromOther() {
		return fromOther;
	}

	public void setFromOther(FromOther fromOther) {
		this.fromOther = fromOther;
	}
}
