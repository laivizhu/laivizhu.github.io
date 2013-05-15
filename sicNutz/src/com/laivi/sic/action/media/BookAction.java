package com.laivi.sic.action.media;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ADownloadAction;
import com.laivi.sic.model.po.media.Book;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/media/book")
public class BookAction extends ADownloadAction<Book> {
	
	@At
	public Response add(@Param("::book.")Book book){
		book.setUserId(this.getUserId());
		dao.insert(book);
		return success();
	}

	@Override
	public Class<Book> getEntityClass() {
		return Book.class;
	}

}
