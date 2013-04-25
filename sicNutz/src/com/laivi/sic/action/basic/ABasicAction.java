package com.laivi.sic.action.basic;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;

import com.laivi.sic.model.json.FormDataItem;
import com.laivi.sic.model.po.user.User;

public abstract class ABasicAction implements IBasicDBAction {
	protected static final Log log=Logs.get();
	
	@Inject
	protected Dao dao;

	@Override
	@At
	public Object add() throws Exception {
		User user=new User();
		user.setName("aa");
		FormDataItem<User> data=new FormDataItem<User>(true,user);
		System.out.println("User="+Json.toJson(data));
		return null;
	}

	@Override
	@At
	public String delete() throws Exception {
		return null;
	}

	@Override
	public String deletes() throws Exception {
		return null;
	}

	@Override
	public String update() throws Exception {
		return null;
	}

	@Override
	public String list() throws Exception {
		return null;
	}

	@Override
	public String get() throws Exception {
		return null;
	}
	
	
	
}
