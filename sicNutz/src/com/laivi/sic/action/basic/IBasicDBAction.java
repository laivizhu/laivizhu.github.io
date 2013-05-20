/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.action.basic;

import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;

import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.to.Response;

/**
 * @author laivi
 * Desc:
 */
public interface IBasicDBAction<T> extends IBasicAction{

	Response delete(long id);
	Response deletes(String ids);
	Object get(long id,boolean fold);
	Object list(Pager page,boolean fold);
	
	JsonList list(Pager page,Class<?> klass,Condition cnd,boolean fold);
	
	JsonList list(Pager page,Class<?> klass,String sql,String count) throws Exception;
	
	JsonItem getJsonItem(T obj,boolean fold);
	
	JsonItem getJsonItem(Class<?>klass,Object obj,boolean fold);
	
	Class<T> getEntityClass();
	
}
