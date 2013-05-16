package com.laivi.sic.model.po.media;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicEntity;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_book_chapter")
public class Chapter extends ABasicEntity {

	private long bookId;
	
	@Validations(required=true,errorMsg="章节标题不能为空")
	@ColDefine(type=ColType.VARCHAR, width=255)
	private String title;
	
	@Validations(required=true,errorMsg="章节内容不能为空")
	private String content;
	
	private int indexChapter;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIndexChapter() {
		return indexChapter;
	}

	public void setIndexChapter(int indexChapter) {
		this.indexChapter = indexChapter;
	}
}
