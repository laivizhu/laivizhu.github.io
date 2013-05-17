package com.laivi.sic.model.po.common;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_autograph")
public class AutoGraph extends AUserEntity {

	@Validations(required=true,errorMsg="发表内容不能为空")
	@ColDefine(type=ColType.VARCHAR, width=3000)
	private String content;
	
	private long parentId;
	
	private boolean parentIs;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public boolean isParentIs() {
		return parentIs;
	}

	public void setParentIs(boolean parentIs) {
		this.parentIs = parentIs;
	}
	
}
