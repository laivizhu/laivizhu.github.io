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
 * @Date Feb 14, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_application")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Application extends BasicEntity {

	private long id;
	private String name;
	private boolean legalIs;
	private long time=0;
	private Date createDate=new Date();
	
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

	public void setId(long id) {
		this.id = id;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public boolean isLegalIs() {
		return legalIs;
	}

	public void setLegalIs(boolean legalIs) {
		this.legalIs = legalIs;
	}
}
