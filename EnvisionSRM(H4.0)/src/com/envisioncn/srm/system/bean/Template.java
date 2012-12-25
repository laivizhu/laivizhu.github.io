/**
 * 
 */
package com.envisioncn.srm.system.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.envisioncn.srm.basic.model.BaseEntity;

/**
 * Copyright Envision
 *
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-25
 */
@Entity
@Table(name="srm_system_template")
public class Template implements BaseEntity{
	private long id;
	
	private String name;
	
	private String path;
	
	private String templateType;
	
	private Date createDate;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
