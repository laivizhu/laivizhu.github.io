package com.laivi.knowledge.book.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.UserEntity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 17, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_book")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Book extends UserEntity{

	private long id;
	private String name;
	private String description;
	private long tagId;
	private String path;
	private Date createDate=new Date();
	private long userId;
	private int price;
	private boolean createIs;
	private String userIds;
	
	public Book() {
	}
	public Book(String name, String path, long userId) {
		this.name = name;
		this.path = path;
		this.userId = userId;
	}
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Lob
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCreateIs() {
		return createIs;
	}
	public void setCreateIs(boolean createIs) {
		this.createIs = createIs;
	}
	public long getTagId() {
		return tagId;
	}
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
	@Lob
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	
}
