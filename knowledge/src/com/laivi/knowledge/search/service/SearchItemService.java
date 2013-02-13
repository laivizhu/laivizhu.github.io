package com.laivi.knowledge.search.service;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.search.model.po.SearchItem;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2012-12-31
 */
@Service("SearchItemService")
public class SearchItemService extends BasicService<SearchItem> implements ISearchItemService {

	@Resource(name="SearchItemDao")
    public void setBasicDao(IBasicDao<SearchItem> basicDao){
        this.basicDao=basicDao;
    }

	@Override
	public void configSearchItem(String keyword) throws ErrorException {
		CriterionList conditions=CriterionList.CreateCriterion();
		conditions.put(Restrictions.eq("keyword", keyword));
		SearchItem item=this.getObject(conditions);
		try {
			if(item==null){
				item=new SearchItem(keyword,1);
				this.add(item);
			}else{
				item.setCount(item.getCount()+1);
				this.modify(item);
			}
		}catch (Exception e) {
			throw new ErrorException("");
		}
	}

}
