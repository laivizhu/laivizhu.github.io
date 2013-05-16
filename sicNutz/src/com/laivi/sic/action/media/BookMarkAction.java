package com.laivi.sic.action.media;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.po.media.BookMark;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/media/mark")
public class BookMarkAction extends ABasicDBAction<BookMark> {
	
	@At
	public Response add(@Param("::mark.")BookMark mark){
		if(dao.count(BookMark.class, Cnd.where("userid", "=", this.getUserId()).and("chapterId", "=", mark.getChapterId()))>0){
			return failure("已经添加过该章节书签");
		}
		mark.setUserId(getUserId());
		dao.insert(mark);
		return success();
	}

	@Override
	public Class<BookMark> getEntityClass() {
		return BookMark.class;
	}

}
