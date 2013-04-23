/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.user.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.sic.basic.model.po.ABasicJsonEntity;

/**
 * @author laivi
 * Desc:
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_loginUser")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LoginUser extends ABasicJsonEntity {
	private long id;
	
	private String account;
	
	private String password;
	
	private Date createDate;
	
	private boolean sysIs;
	
	private boolean enableIs;
	
	private boolean resetPasswordIs;
	
	private long userId;
	
	
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the sysIs
	 */
	public boolean isSysIs() {
		return sysIs;
	}

	/**
	 * @param sysIs the sysIs to set
	 */
	public void setSysIs(boolean sysIs) {
		this.sysIs = sysIs;
	}

	/**
	 * @return the enableIs
	 */
	public boolean isEnableIs() {
		return enableIs;
	}

	/**
	 * @param enableIs the enableIs to set
	 */
	public void setEnableIs(boolean enableIs) {
		this.enableIs = enableIs;
	}

	/**
	 * @return the resetPasswordIs
	 */
	public boolean isResetPasswordIs() {
		return resetPasswordIs;
	}

	/**
	 * @param resetPasswordIs the resetPasswordIs to set
	 */
	public void setResetPasswordIs(boolean resetPasswordIs) {
		this.resetPasswordIs = resetPasswordIs;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
