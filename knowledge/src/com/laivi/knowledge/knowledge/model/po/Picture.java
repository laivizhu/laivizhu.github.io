package com.laivi.knowledge.knowledge.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.laivi.knowledge.basic.model.po.BaseEntity;

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
public class Picture implements BaseEntity {
	private long id;
	private String description;
	private String path;
	private Date indate;
	private String tagIds;
	private long userId;

	public Picture() {
	}

	public Picture(String description, String path, Date indate, long userId) {
		this.description = description;
		this.path = path;
		this.indate = indate;
		this.userId = userId;
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

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
