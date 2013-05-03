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

	Response add() throws Exception;
	Response delete(long id)throws Exception;
	Response deletes(String ids)throws Exception;
	Response update()throws Exception;
	Object list(Pager page)throws Exception;
	Object get(long id)throws Exception;
	
	Class<T> getEntityClass();
	
	JsonItem getJsonItem(T obj);
	
}
