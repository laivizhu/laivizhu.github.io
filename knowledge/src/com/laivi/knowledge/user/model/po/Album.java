package com.laivi.knowledge.user.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.BasicEntity;
import com.laivi.knowledge.user.model.type.AlbumType;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-24
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_album")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Album extends BasicEntity {

	private long id;
	private String name;
	private String description;
	private AlbumType type;
	private Date createDate=new Date();
	private long userId;
	private String itemIds;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Lob
	public String getItemIds() {
		return itemIds;
	}

	public void setItemIds(String itemIds) {
		this.itemIds = itemIds;
	}

	public AlbumType getType() {
		return type;
	}

	public void setType(AlbumType type) {
		this.type = type;
	}
}
