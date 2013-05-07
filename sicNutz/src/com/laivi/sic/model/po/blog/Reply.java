package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.Table;
import org.nutz.validation.annotation.Validations;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.TagType;

@SuppressWarnings("serial")
@Table("sic_reply")
public class Reply extends AUserEntity {
	
	@Validations(required=true,errorMsg="")
	private String content;
	
	private long objId;
	
	private TagType type;

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

	public TagType getType() {
		return type;
	}

	public void setType(TagType type) {
		this.type = type;
	}
	
}
