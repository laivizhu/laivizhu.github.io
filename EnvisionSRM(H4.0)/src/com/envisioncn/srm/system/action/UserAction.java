package com.envisioncn.srm.system.action;

import java.util.List;

import javax.annotation.Resource;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.util.GsonUtil;
import com.envisioncn.srm.system.bean.UserBean;
import com.envisioncn.srm.system.service.UserService;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-13
 * 
 */

@SuppressWarnings("serial")
public class UserAction extends ABasicAction<UserBean> {

	private UserService userService;
	
	public String add() throws Exception {
		return null;
	}

	public String delete() throws Exception {
		return null;
	}

	public String update() throws Exception {
		return null;
	}

	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		String hql = "from UserBean user order by user.workNumber";
		String hql2 = "select count(*) " + hql;
		List<UserBean> list = (List<UserBean>)userService.getObjectListByPage(hql, null, start, limit);
		int recordCount = userService.getPageCount(hql2, null);
		return response(GsonUtil.toJson(list,recordCount));
	}

	public String get() throws Exception {
		return null;
	}
	
	
	@Resource(name="UserService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public JsonItem getJsonItem(UserBean object) throws Exception {
		return null;
	}
	

	
}
