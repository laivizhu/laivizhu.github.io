package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.po.common.Reply;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/reply")
public class ReplyAction extends ABasicDBAction<Reply> {
	
	@At
	@CheckValue
	public Response add(@Param("::reply.")Reply reply){
		reply.setUserId(this.getUserId());
		dao.insert(reply);
		return success();
	}
	
	@At
	public Object listByType(@Param("::reply.")Reply reply){
		return this.list(null, Cnd.where("type", "=", reply.getType()).and("objId","=",reply.getObjId()));
	}

	@Override
	public Class<Reply> getEntityClass() {
		return Reply.class;
	}

}
