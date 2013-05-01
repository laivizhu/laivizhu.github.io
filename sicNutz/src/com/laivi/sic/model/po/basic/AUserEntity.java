package com.laivi.sic.model.po.basic;

import java.util.Date;

@SuppressWarnings("serial")
public abstract class AUserEntity extends ABasicEntity implements IUserEntity {

	protected long userId;
	
	protected Date createDate=new Date();


	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
}
