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

	Response delete(long id)throws Exception;
	Response deletes(String ids)throws Exception;
	Object get(long id,boolean fold)throws Exception;
	Object list(Pager page,boolean fold)throws Exception;
	
	JsonList list(Pager page,Class<?> klass,Condition cnd,boolean fold)throws Exception;
	
	JsonList list(Pager page,Class<?> klass,String sql,String count) throws Exception;
	
	JsonItem getJsonItem(T obj,boolean fold);
	
	JsonItem getJsonItem(Class<?>klass,Object obj,boolean fold);
	
	Class<T> getEntityClass();
	
}
