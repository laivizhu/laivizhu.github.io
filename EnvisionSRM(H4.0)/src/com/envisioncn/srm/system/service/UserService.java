package com.envisioncn.srm.system.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.system.bean.UserBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date 2012-11-13
 * 
 */

@Service("UserService")
public class UserService extends BasicService<UserBean> implements IUserService {

	@Resource(name = "UserDao")
	public void setBasicDao(IBasicDao<UserBean> basicDao) {
		this.basicDao = basicDao;
	}

}
