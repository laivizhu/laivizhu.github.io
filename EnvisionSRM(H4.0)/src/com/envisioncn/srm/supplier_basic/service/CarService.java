package com.envisioncn.srm.supplier_basic.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.supplier_basic.bean.CarBean;

/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-12-03
 */

@Service("CarService")
public class CarService extends BasicService<CarBean> implements ICarService {
	@Resource(name = "CarDao")
	public void setBasicDao(IBasicDao<CarBean> basicDao) {
		this.basicDao = basicDao;
	}

}
