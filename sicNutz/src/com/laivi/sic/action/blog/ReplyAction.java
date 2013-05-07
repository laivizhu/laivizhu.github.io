package com.laivi.sic.action.blog;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.po.blog.Reply;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/reply")
public class ReplyAction extends ABasicDBAction<Reply> {
	
	@At
	@CheckValue
	public Response add(@Param("::reply.")Reply reply){
		dao.insert(reply);
		return success();
	}

	@Override
	public Class<Reply> getEntityClass() {
		return Reply.class;
	}

}
