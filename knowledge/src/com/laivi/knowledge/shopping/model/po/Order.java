package com.laivi.knowledge.shopping.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.UserEntity;
import com.laivi.knowledge.shopping.model.type.StatusType;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-17
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_order")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Order extends UserEntity {

	private long id;
	private String code;
	private List<ShoppingItem> item=new ArrayList<ShoppingItem>();
	private Date createDate=new Date();
	private long userId;
	private StatusType status;
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@OneToMany(cascade ={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="orderId")
	public List<ShoppingItem> getItem() {
		return item;
	}
	public void setItem(List<ShoppingItem> item) {
		this.item = item;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setId(long id) {
		this.id = id;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
}
