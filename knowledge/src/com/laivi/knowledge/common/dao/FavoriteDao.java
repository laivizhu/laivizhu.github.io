package com.laivi.knowledge.common.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.common.model.po.Favorite;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@Service("FavoriteDao")
public class FavoriteDao extends ABasicDao<Favorite> implements IFavoriteDao {
	
	@Override
	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(Favorite.class);
	}

}
