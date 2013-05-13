package com.laivi.sic.action.media;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import com.laivi.sic.action.basic.ADownloadAction;
import com.laivi.sic.model.po.media.Book;

@IocBean
@At("/media/book")
public class BookAction extends ADownloadAction<Book> {

	@Override
	public Class<Book> getEntityClass() {
		return Book.class;
	}

}
