package com.laivi.knowledge.common.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.BasicEntity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 14, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_oauth")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class OAuth extends BasicEntity {

	private long id;
	private long applicationId;
	private long userId;
	private String token;
	private Date createDate=new Date();
	
	
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
