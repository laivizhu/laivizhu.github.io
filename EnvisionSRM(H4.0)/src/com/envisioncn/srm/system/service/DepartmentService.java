package com.envisioncn.srm.system.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.system.bean.DepartmentBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-29
 * 
 */

@Service("DepartmentService")
public class DepartmentService extends BasicService<DepartmentBean> implements IDepartmentService
{
	@Resource(name = "DepartmentDao")
	public void setBasicDao(IBasicDao<DepartmentBean> basicDao) {
		this.basicDao = basicDao;
	}
	


}
