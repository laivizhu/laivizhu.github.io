package com.laivi.knowledge.user.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.BasicEntity;
import com.laivi.knowledge.user.model.type.FriendsDirection;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 10, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_friends")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Friends extends BasicEntity {

	private long id;
	private long userId;
	private long friendId;
	private Date createDate=new Date();
	private long userGroupId;
	private long friendGroupId;
	private FriendsDirection direction;
	
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFriendId() {
		return friendId;
	}

	public void setFriendId(long friendId) {
		this.friendId = friendId;
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

	public long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(long userGroupId) {
		this.userGroupId = userGroupId;
	}

	public long getFriendGroupId() {
		return friendGroupId;
	}

	public void setFriendGroupId(long friendGroupId) {
		this.friendGroupId = friendGroupId;
	}

	public FriendsDirection getDirection() {
		return direction;
	}

	public void setDirection(FriendsDirection direction) {
		this.direction = direction;
	}
	
}
