package com.laivi.sic.model.po.user;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicEntity;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_user")
public class User extends ABasicEntity {
	
	@Validations(required=true,errorMsg="用户名必填")
	private String name;
	
	private String description;
	
	@ColDefine(type=ColType.VARCHAR, width=200)
	private String roleIds;
	
	private long score;
	
	private long money;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}
}
