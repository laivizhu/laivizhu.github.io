package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.po.common.SearchItem;

@IocBean
@At
public class SearchAction extends ABasicDBAction<SearchItem>{
	
	@At
	public Object showResult(){
		return null;
	}

	@At
	public Object topKeywordList(){
		return list(dao.createPager(1, 20),Cnd.orderBy().desc("count"));
	}

	@Override
	public Class<SearchItem> getEntityClass() {
		return SearchItem.class;
	}
}
