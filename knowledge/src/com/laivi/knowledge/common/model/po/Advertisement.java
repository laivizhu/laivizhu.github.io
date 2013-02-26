package com.laivi.knowledge.common.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.BasicEntity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 23, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_advertisement")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Advertisement extends BasicEntity {

	private long id;
	
	private String title;
	
	private String content;
	
	private String url;
	
	private Date createDate=new Date();
	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setId(long id) {
		this.id = id;
	}
}
