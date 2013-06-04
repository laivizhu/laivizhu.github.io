package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_article")
public class Article extends AUserEntity {
	
	@Validations(required=true,strLen={1,200},errorMsg="文章题目不能为空")
	@ColDefine(type=ColType.VARCHAR, width=255)
	private String title;
	
	@Validations(required=true,errorMsg="文章内容不能为空")
	@ColDefine(type=ColType.TEXT)
	private String content;
	
	private long viewCount;
	
	private long tagId;
	
	private boolean otherIs;

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
	
	public long getTagId() {
		return tagId;
	}
	
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public boolean isOtherIs() {
		return otherIs;
	}

	public void setOtherIs(boolean otherIs) {
		this.otherIs = otherIs;
	}
}
