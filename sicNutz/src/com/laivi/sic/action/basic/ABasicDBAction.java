package com.laivi.sic.action.basic;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.json.ListResult;
import com.laivi.sic.model.po.basic.IBasicDBEntity;
import com.laivi.sic.model.to.Response;


public abstract class ABasicDBAction<T extends IBasicDBEntity> extends ABasicAction implements IBasicDBAction<T> {
	protected static final Log log=Logs.get();
	
	@Inject
	protected Dao dao;

	@Override
	@At
	@CheckLogin
	public Response add() throws Exception {
		return success();
	}

	@Override
	@At
	public Response delete(long id)throws Exception{
		dao.delete(this.getEntityClass(), id);
		return success();
	}

	@Override
	@At
	public Response deletes(String ids) throws Exception {
		dao.clear(this.getEntityClass(), Cnd.wrap("id in ("+ids+")"));
		return success();
	}

	@Override
	@At
	public Response update() throws Exception {
		return null;
	}

	@Override
	@At
	public Object list(@Param("::page.")Pager page) throws Exception {
		return new ListResult<T>(dao.query(this.getEntityClass(), null, page),dao.count(this.getEntityClass()));
	}

	@Override
	@At
	public Object get(long id) throws Exception {
		return dao.fetch(this.getEntityClass(), id);
	}
}
