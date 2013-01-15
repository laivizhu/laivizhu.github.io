package com.laivi.knowledge.common.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.common.model.po.Favorite;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@Service("FavoriteService")
public class FavoriteService extends BasicService<Favorite> implements IFavoriteService {
	@Resource(name="FavoriteDao")
	public void setBasicDao(IBasicDao<Favorite> basicDao){
		this.basicDao=basicDao;
	}
	

}
