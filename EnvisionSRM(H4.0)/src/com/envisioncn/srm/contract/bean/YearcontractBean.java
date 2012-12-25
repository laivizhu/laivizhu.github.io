/**
 * 
 */
package com.envisioncn.srm.contract.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.envisioncn.srm.basic.model.BaseEntity;

/**
 * Copyright Envision
 * 
 * @author mingsongliao
 * @version 1.0
 * @date 2012-10-7
 * 
 */

@Entity
@Table(name = "srm_contract_yearcontract")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class YearcontractBean implements BaseEntity {
	private long id;
	private long yearcontractid;
	private String name;
	private String path;
	private Date begindate;
	private Date enddate;
	private long person;
	private String type;
	private String filenumber;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public long getYearcontractid() {
		return yearcontractid;
	}

	public void setYearcontractid(long yearcontractid) {
		this.yearcontractid = yearcontractid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getBegindate() {
		return begindate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public long getPerson() {
		return person;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setPerson(long person) {
		this.person = person;
	}

	public String getFilenumber() {
		return filenumber;
	}

	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}

}
