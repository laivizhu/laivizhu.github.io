package com.laivi.sic.model.po.user;

import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.validation.annotation.Validations;

import com.laivi.sic.model.po.basic.ABasicEntity;

@SuppressWarnings("serial")
@Table("sic_login_user")
public class LoginUser extends ABasicEntity{
	@Id
	private long id;

	@Name
	@ColDefine(type=ColType.VARCHAR, width=200)
	private String Uidendity;
	
	@Validations(account=true,strLen={8,20},errorMsg="密码长度至少8位")
	private transient String password;
	
	@Validations(email=true,errorMsg="email格式不正确")
	private String email;
	
	private Date createDate=new Date();
	
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUidendity() {
		return Uidendity;
	}

	public void setUidendity(String uidendity) {
		Uidendity = uidendity;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
