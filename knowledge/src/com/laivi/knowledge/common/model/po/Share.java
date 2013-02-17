package com.laivi.knowledge.common.model.po;

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
 * @Date Feb 14, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_share")
public class Share extends BasicEntity {

	private long id;
	private long autoGraphId;
	private long userId;
	private Date createDate;
	
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public long getAutoGraphId() {
		return autoGraphId;
	}
	public void setAutoGraphId(long autoGraphId) {
		this.autoGraphId = autoGraphId;
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
}
