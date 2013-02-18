package com.laivi.knowledge.book.model.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.BasicEntity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 17, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_chapter")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Chapter extends BasicEntity {

	private long id;
	private long bookId;
	private String title;
	private String content;
	private int indexChapter;
	
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
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
	@Lob
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIndexChapter() {
		return indexChapter;
	}
	public void setIndexChapter(int indexChapter) {
		this.indexChapter = indexChapter;
	}
}
