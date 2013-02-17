package com.laivi.knowledge.common.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.laivi.knowledge.basic.model.po.BasicEntity;
import com.laivi.knowledge.common.model.type.FromOtherType;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 17, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_fromOther")
public class FromOther extends BasicEntity {

	private long id;
	private long objectId;
	private long userId;
	private FromOtherType type;
	private Date createDate=new Date();
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public long getObjectId() {
		return objectId;
	}
	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public FromOtherType getType() {
		return type;
	}
	public void setType(FromOtherType type) {
		this.type = type;
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
