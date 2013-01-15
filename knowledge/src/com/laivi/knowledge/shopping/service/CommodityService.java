package com.laivi.knowledge.shopping.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.shopping.model.po.Commodity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@Service("CommodityService")
public class CommodityService extends BasicService<Commodity> implements ICommodityService {

	@Resource(name="CommodityDao")
	public void setBasicDao(IBasicDao<Commodity> basicDao){
		this.basicDao=basicDao;
	}

}
