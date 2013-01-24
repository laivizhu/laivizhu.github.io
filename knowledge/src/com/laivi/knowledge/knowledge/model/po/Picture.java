package com.laivi.knowledge.knowledge.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.laivi.knowledge.basic.model.po.BasicEntity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-1
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_picture")
public class Picture extends BasicEntity{
	private long id;
	private String description;
	private String path;
	private Date createDate=new Date();

	public Picture() {
	}

	public Picture(String description, String path, Date indate) {
		this.description = description;
		this.path = path;
		this.createDate = indate;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
