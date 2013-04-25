package com.laivi.sic.model.po.user;

import java.util.Date;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicJsonEntity;
import com.laivi.sic.model.po.basic.IBasicDBEntity;

@SuppressWarnings("serial")
@Table("sic_login_user")
public class LoginUser extends ABasicJsonEntity implements IBasicDBEntity{
	@Id
	private long id;
	
	@Name
	private String account;
	
	private transient String password;
	
	private Date createDate;
	
	private boolean sysIs;
	
	private boolean enableIs;
	
	private boolean resetPasswordIs;
	
	private long userId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isSysIs() {
		return sysIs;
	}

	public void setSysIs(boolean sysIs) {
		this.sysIs = sysIs;
	}

	public boolean isEnableIs() {
		return enableIs;
	}

	public void setEnableIs(boolean enableIs) {
		this.enableIs = enableIs;
	}

	public boolean isResetPasswordIs() {
		return resetPasswordIs;
	}

	public void setResetPasswordIs(boolean resetPasswordIs) {
		this.resetPasswordIs = resetPasswordIs;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
