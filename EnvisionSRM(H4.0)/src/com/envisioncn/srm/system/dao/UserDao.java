package com.envisioncn.srm.system.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.system.bean.UserBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date 2012-11-13
 * 
 */

@Service("UserDao")
public class UserDao extends ABasicDao<UserBean> implements IUserDao {

	public Criteria getCriteria() {
		return null;
	}

}
