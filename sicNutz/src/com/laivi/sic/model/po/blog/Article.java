package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.Table;
import org.nutz.validation.annotation.Validations;

import com.laivi.sic.model.po.basic.AUserEntity;

@SuppressWarnings("serial")
@Table("sic_article")
public class Article extends AUserEntity {
	
	@Validations(required=true,errorMsg="文章题目不能为空")
	private String title;
	
	@Validations(required=true,errorMsg="文章内容不能为空")
	private String content;
	
	private long viewCount;
	
	private long tagId;

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

	public long getViewCount() {
		return viewCount;
	}

	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the tagId
	 */
	public long getTagId() {
		return tagId;
	}

	/**
	 * @param tagId the tagId to set
	 */
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
	
}
