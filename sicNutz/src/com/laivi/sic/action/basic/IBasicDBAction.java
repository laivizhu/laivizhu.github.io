/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.action.basic;

import org.nutz.dao.pager.Pager;

import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.to.Response;

/**
 * @author laivi
 * Desc:
 */
public interface IBasicDBAction<T> extends IBasicAction{

	Response delete(long id);
	Response deletes(String ids);
	Object list(Pager page,boolean fold);
	Object get(long id,boolean fold);
	
	Class<T> getEntityClass();
	
	JsonItem getJsonItem(T obj,boolean fold);
	
	JsonItem getJsonItem(Class<?>klass,Object obj,boolean fold);
	
}
