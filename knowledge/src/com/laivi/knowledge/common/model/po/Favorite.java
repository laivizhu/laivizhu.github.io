package com.laivi.knowledge.common.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.UserEntity;
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
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Favorite extends UserEntity {

	private long id;
	private String title;
	private Date createDate=new Date();
	private FavoriteType type;
	private long userId;
	private String url;

	
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
		this.title=title;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public FavoriteType getType() {
		return type;
	}

	public void setType(FavoriteType type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
