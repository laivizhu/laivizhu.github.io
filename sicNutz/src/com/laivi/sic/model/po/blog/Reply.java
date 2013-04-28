package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;

@SuppressWarnings("serial")
@Table("sic_reply")
public class Reply extends AUserEntity {
	
	private String content;
	
	private long articleId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

}
