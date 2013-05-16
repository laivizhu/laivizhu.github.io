package com.laivi.sic.action.media;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.po.media.BookShelf;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/media/bookshelf")
public class BookShelfAction extends ABasicDBAction<BookShelf> {
	
	@At
	@CheckLogin
	public Response add(@Param("::shelf")BookShelf shelf){
		return success();
	}

	@Override
	public Class<BookShelf> getEntityClass() {
		return BookShelf.class;
	}

}
