package com.laivi.knowledge.user.model.po;

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
 * @Date 2013-1-28
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_music")
public class Music extends BasicEntity {

	private long id;
	private String name;
	private Date createDate=new Date();
	private String path;

	public Music() {
	}

	/**
	 * @param name
	 * @param path
	 */
	public Music(String name, String path) {
		this.name = name;
		this.path = path;
	}

	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
}
