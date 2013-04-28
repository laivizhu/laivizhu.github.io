package com.laivi.sic.model.po.basic;

import java.util.Date;

@SuppressWarnings("serial")
public abstract class AUserEntity extends ABasicEntity {

	protected long useId;
	
	protected Date createDate=new Date();

	public long getUseId() {
		return useId;
	}

	public void setUseId(long useId) {
		this.useId = useId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
