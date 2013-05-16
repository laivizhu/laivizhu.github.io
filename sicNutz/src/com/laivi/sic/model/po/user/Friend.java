package com.laivi.sic.model.po.user;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.FriendsDirection;

@SuppressWarnings("serial")
@Table("sic_friend")
public class Friend extends AUserEntity {

	private long friendId;
	
	private long userGroupId;
	
	private long friendGroupId;
	
	private FriendsDirection direction;

	public long getFriendId() {
		return friendId;
	}

	public void setFriendId(long friendId) {
		this.friendId = friendId;
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
