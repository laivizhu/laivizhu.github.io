package com.laivi.sic.model.po.common;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.CategoryType;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_reply")
public class Reply extends AUserEntity {
	
	@Validations(required=true,errorMsg="评论内容不能为空")
	private String content;
	
	private long objId;
	
	private CategoryType type;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getObjId() {
		return objId;
	}

	public void setObjId(long objId) {
		this.objId = objId;
	}

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}
}
