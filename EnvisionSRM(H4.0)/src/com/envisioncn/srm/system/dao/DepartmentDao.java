package com.envisioncn.srm.system.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.system.bean.DepartmentBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date 2012-11-29
 * 
 */

@Service("DepartmentDao")
public class DepartmentDao extends ABasicDao<DepartmentBean> implements IDepartmentDao<DepartmentBean>
{
	public Criteria getCriteria()
	{
		return null;
	}

}
