package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.CategoryType;

@SuppressWarnings("serial")
@Table("sic_tag")
public class Tag extends AUserEntity {

	private String name;
	
	private CategoryType type;

	public Tag() {
		super();
	}

	public Tag(String name, CategoryType type) {
		super();
		this.name = name;
		this.type = type;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}

}
