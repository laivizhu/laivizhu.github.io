package com.envisioncn.srm.supplier_basic.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.supplier_basic.bean.CarTaskBean;

/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-12-03
 */

@Service("CarTaskService")
public class CarTaskService extends BasicService<CarTaskBean> implements ICarTaskService {
	@Resource(name = "CarTaskDao")
	public void setBasicDao(IBasicDao<CarTaskBean> basicDao) {
		this.basicDao = basicDao;
	}

}
