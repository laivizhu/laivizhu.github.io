package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.TagType;

@SuppressWarnings("serial")
@Table("sic_tag")
public class Tag extends AUserEntity {

	private String name;
	
	private TagType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TagType getType() {
		return type;
	}

	public void setType(TagType type) {
		this.type = type;
	}

}
