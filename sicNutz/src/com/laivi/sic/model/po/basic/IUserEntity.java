package com.laivi.sic.model.po.basic;

import java.util.Date;

public interface IUserEntity extends IBasicDBEntity{
	
	public long getUserId();
	
	public Date getCreateDate();
	
	public void setUserId(long userId);

}
