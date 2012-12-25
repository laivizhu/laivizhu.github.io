/**
 * 
 */
package com.envisioncn.srm.contract.bean;

import javax.persistence.Column;
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
 * @version
 * @data 2012-11-19
 */
@Entity
@Table(name = "srm_contract_diviation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DiviationBean implements BaseEntity {

	private long id;
	private long yearcontractid;
	private String diviationId;
	private String projectnumber;
	private String contentold;
	private String contentnew;
	private String remark;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public long getYearcontractid() {
		return yearcontractid;
	}
	public String getProjectnumber() {
		return projectnumber;
	}
	
	@Column(length=2000)
	public String getContentold() {
		return contentold;
	}
	
	@Column(length=500)
	public String getContentnew() {
		return contentnew;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setYearcontractid(long yearcontractid) {
		this.yearcontractid = yearcontractid;
	}
	public void setProjectnumber(String projectnumber) {
		this.projectnumber = projectnumber;
	}
	public void setContentold(String contentold) {
		this.contentold = contentold;
	}
	public void setContentnew(String contentnew) {
		this.contentnew = contentnew;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDiviationId() {
		return diviationId;
	}
	public void setDiviationId(String diviationId) {
		this.diviationId = diviationId;
	}
	

}
