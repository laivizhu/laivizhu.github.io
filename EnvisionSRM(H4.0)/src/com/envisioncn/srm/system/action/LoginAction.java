package com.envisioncn.srm.system.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.type.ResponseType;
import com.envisioncn.srm.system.bean.UserBean;
import com.envisioncn.srm.system.service.UserService;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date 2012-11-22
 * 
 */
@SuppressWarnings("serial")
public class LoginAction extends ABasicAction<UserBean>
{
	private UserService userService;
	private String loginAccount;

	@Override
	public String execute() throws Exception
	{
		String hql = "from UserBean as user where user.loginAccount = ?";
		Object[] parameters = { loginAccount };
		List<UserBean> userList = (List<UserBean>) userService.getObjectList(hql, parameters);
		if (1 != userList.size())
		{
			return response(ResponseType.HTML, false, "用户名或密码错误，请重试！");
		}
		else
		{
			UserBean user = userList.get(0);
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return response(ResponseType.HTML, true, "登录成功");
		}
	}

	public String getLoginAccount()
	{
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount)
	{
		this.loginAccount = loginAccount;
	}

	@Resource(name = "UserService")
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public JsonItem getJsonItem(UserBean object) throws Exception
	{
		return null;
	}

}
