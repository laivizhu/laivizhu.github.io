package com.laivi.knowledge.basic.action;

import java.util.List;

import org.hibernate.criterion.Order;

import com.laivi.knowledge.basic.model.annotation.CheckLogin;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.model.po.BasicEntity;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
@SuppressWarnings("serial")
public abstract class ABasicAction<T extends BasicEntity> extends BasicAction<T> {
	protected IBasicService<T> basicService;
	
	public String search()throws Exception{
		getSearchConditions();
		return response(list(!notBreakPage,true));
	}

	@CheckLogin
	public String delete() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		basicService.remove(id);
		return response(true);
	}
	@CheckLogin
	public String deletes()throws Exception{
		ParamAssert.isNotEmptyString(ids, "error.object.notChoose");
		basicService.remove(ids);
		return response(true);
	}

	public String get() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		return response(this.basicService.getObject(id).toFormJson(true));
	}

	public String list() throws Exception {
		return response(list(true,true));
	}
	
	protected String list(boolean isBreakPage,boolean isAddUserCondition)throws Exception{
		JsonList jsonList = new JsonList();
		if(isAddUserCondition){
			this.conditions=this.getUserCriterionList();
		}
		if(conditions==null){
			conditions=CriterionList.CreateCriterion();
		}
		conditions.put(Order.desc("createDate"));
		List<T> list;
		if(isBreakPage){
			list=this.basicService.getList(conditions, start, limit);
		}else{
			list=this.basicService.getList(conditions);
		}
		for (T o :list) {
			this.addData(jsonList, o);
		}
		return jsonList.toPageString(basicService.getCount(conditions));
	}

	public String update() throws Exception {
		return null;
	}

	public String add() throws Exception {
		return null;
	}

	@Override
	public T getNewObject() {
		return null;
	}
}
