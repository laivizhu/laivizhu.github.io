package com.laivi.knowledge.user.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.BasicEntity;
@SuppressWarnings("serial")
@Entity
@Table(name = "t_User")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends BasicEntity{
	private long id;
	private String account;
	private String userName;
	private String password;
	private String email;
	private Date createDate=new Date();
	private boolean sysUser;
	private String description;
	private long money;
	private boolean enable;
	private long roleId;
	private boolean reset; // 0表示不需要重置密码；1表示需要重置密码

    public User(String account, String userName, String password, boolean sysUser, boolean enable) {
        this.account = account;
        this.userName = userName;
        this.password = password;
        this.sysUser = sysUser;
        this.enable = enable;
    }

    public User() {
    }

    @Id
	@GeneratedValue
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSysUser() {
        return sysUser;
    }

    public void setSysUser(boolean sysUser) {
        this.sysUser = sysUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}
}
