package com.laivi.knowledge.search.service;

import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.search.model.po.SearchItem;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2012-12-31
 */
public interface ISearchItemService extends IBasicService<SearchItem> {
	
	void configSearchItem(String keyword)throws ErrorException;

}
