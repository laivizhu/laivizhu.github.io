package com.laivi.sic.model.po.user;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicEntity;

@SuppressWarnings("serial")
@Table("sic_role")
public class Role extends ABasicEntity {
	
	@Id
	private long id;
	
	private String name;
	
	private String description;

	@Override
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
	}

}
