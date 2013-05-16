package com.laivi.sic.model.po.media;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;

@SuppressWarnings("serial")
@Table("sic_bookshelf")
public class BookShelf extends AUserEntity {

	private long bookId;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	
}
