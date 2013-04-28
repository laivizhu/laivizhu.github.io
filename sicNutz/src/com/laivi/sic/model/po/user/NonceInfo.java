package com.laivi.sic.model.po.user;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicEntity;

@SuppressWarnings("serial")
@Table("sic_noceInfo")
public class NonceInfo extends ABasicEntity {

	@Id
	private long id;
	
	@Name
	private String nonce;
	
	private long expireTime;
	
	@Override
	public long getId() {
		return id;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public long getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}
	public void setId(long id) {
		this.id = id;
	}
}
