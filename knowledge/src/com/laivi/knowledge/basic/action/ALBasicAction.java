package com.laivi.knowledge.basic.action;

import java.util.List;

import org.hibernate.criterion.Order;

import com.laivi.knowledge.basic.model.annotation.CheckLogin;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.model.po.BasicEntity;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.LBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.User;


/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 14, 2013
 */
@SuppressWarnings("serial")
public abstract class ALBasicAction<T extends BasicEntity> extends BasicAction<T> {

	protected LBasicService<T> basicService;
	protected LBasicService<User> userService;
	
	@Override
	public String add() throws Exception {
		return null;
	}

	@Override
	public String delete() throws Exception {
		this.basicService.remove(this.getObjectClass(), id);
		return response(true);
	}
	
	@CheckLogin
	public String deletes()throws Exception{
		ParamAssert.isNotEmptyString(ids, "error.object.notChoose");
		this.basicService.remove(this.getObjectClass(), ids);
		return response(true);
	}

	@Override
	public String update() throws Exception {
		return null;
	}

	@Override
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
			list=this.basicService.getList(this.getObjectClass(),conditions, start, limit);
		}else{
			list=this.basicService.getList(this.getObjectClass(),conditions);
		}
		for (T o :list) {
			this.addData(jsonList, o);
		}
		return jsonList.toPageString(basicService.getCount(this.getObjectClass(),conditions));
	}

	@Override
	public String get() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		return response(this.basicService.getObject(this.getObjectClass(),id).toFormJson(true));
	}

	@Override
	public String search() throws Exception {
		getSearchConditions();
		return response(list(!notBreakPage,true));
	}
	
	abstract public Class<T> getObjectClass()throws Exception;
	
	@Override
	public T getNewObject() {
		return null;
	}
}
