package com.envisioncn.srm.basic.model.to;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-24
 */
public class ConfirmMailInfo {

	private String randSuffix;

	private String userName;

	private String account;

	private String password;

	public ConfirmMailInfo() {
	}

	/**
	 * @param randSuffix
	 * @param userName
	 * @param account
	 * @param password
	 */
	public ConfirmMailInfo(String randSuffix, String userName, String account, String password) {
		super();
		this.randSuffix = randSuffix;
		this.userName = userName;
		this.account = account;
		this.password = password;
	}

	public String getRandSuffix() {
		return randSuffix;
	}

	public void setRandSuffix(String randSuffix) {
		this.randSuffix = randSuffix;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

}
