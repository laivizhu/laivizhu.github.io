package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.TagType;

@SuppressWarnings("serial")
@Table("sic_tag")
public class Tag extends AUserEntity {

	private String name;
	
	private TagType type;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public TagType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TagType type) {
		this.type = type;
	}
	
	
}
