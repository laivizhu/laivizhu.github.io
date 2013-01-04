package com.laivi.knowledge.search.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.search.model.po.SearchItem;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2012-12-31
 */
@Service("SearchItemDao")
public class SearchItemDao extends ABasicDao<SearchItem> implements ISearchItemDao {
	
	@Override
	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(SearchItem.class);
	}

}
