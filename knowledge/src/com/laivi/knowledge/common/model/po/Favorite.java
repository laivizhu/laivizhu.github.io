package com.laivi.knowledge.common.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import com.laivi.knowledge.basic.model.po.BasicEntity;
import com.laivi.knowledge.common.model.type.FavoriteType;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_favorite")
public class Favorite extends BasicEntity {

	private long id;
	private String title;
	private Date createDate;
	private FavoriteType type;
	private long favoriteId;
	private long userId;

	
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Enumerated(EnumType.STRING)
	public FavoriteType getType() {
		return type;
	}

	public void setType(FavoriteType type) {
		this.type = type;
	}

	public long getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(long favoriteId) {
		this.favoriteId = favoriteId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
