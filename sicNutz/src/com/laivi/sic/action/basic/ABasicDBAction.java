package com.laivi.sic.action.basic;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.basic.IBasicDBEntity;
import com.laivi.sic.model.to.Response;


public abstract class ABasicDBAction<T extends IBasicDBEntity> extends ABasicAction implements IBasicDBAction<T> {
	protected static final Log log=Logs.get();
	
	@Inject
	protected Dao dao;
	
	protected Condition cnd=null;

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
		if(cnd==null){
			//cnd=Cnd.where("userId", op, value)
		}
		JsonList jsonList=new JsonList();
		for(T obj:dao.query(this.getEntityClass(), cnd, page)){
			jsonList.add(this.dataJson(obj));
		}
		return null;
	}
	
	protected String dataJson(T obj){
		JsonItem item=this.getJsonItem(obj);
		if(item==null){
			return obj.toObjJson();
		}else{
			return item.returnJson();
		}
	}
	
	
	
	

	@Override
	@At
	public Object get(long id) throws Exception {
		return dao.fetch(this.getEntityClass(), id);
	}

	@Override
	public JsonItem getJsonItem(T obj) {
		return null;
	}
	
	
}
