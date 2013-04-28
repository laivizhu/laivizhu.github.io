package com.laivi.sic.model.po.user;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.validation.annotation.Validations;

import com.laivi.sic.model.po.basic.ABasicEntity;

@SuppressWarnings("serial")
@Table("sic_user")
public class User extends ABasicEntity{
	
	@Id
	private long id;
	
	@Validations(required=true,errorMsg="用户名必填")
	private String name;
	
	private String description;
	
	@ColDefine(type=ColType.VARCHAR, width=200)
	private String roleIds;
	
	private long score;
	
	private long money;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
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
