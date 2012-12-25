package com.envisioncn.srm.infocenter.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.envisioncn.srm.basic.model.BaseEntity;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date 2012-11-17
 * 
 */
@Entity
@Table(name="SRM_INFOCENTER_NOTICETYPE")
public class NoticeTypeBean implements BaseEntity {

	private long id;
	private String name;
	private String description;

	
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

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

}
