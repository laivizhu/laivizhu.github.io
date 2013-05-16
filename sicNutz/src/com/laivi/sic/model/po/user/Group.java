package com.laivi.sic.model.po.user;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;

@SuppressWarnings("serial")
@Table("sic_group")
public class Group extends AUserEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
