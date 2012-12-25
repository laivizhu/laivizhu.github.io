/**
 * 
 */
package com.envisioncn.srm.contract.bean;

import java.util.Date;

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
@Table(name = "srm_contract_contractExcution")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ContractExcutionBean implements BaseEntity {

	private long id;
	private String contractid;
	private long cancelReason;
	private String confirmOption;
	private String confirmPerson;
	private Date confirmTime;
	private Date cancelTime;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public String getContractid() {
		return contractid;
	}
	public long getCancelReason() {
		return cancelReason;
	}
	@Column(length=200)
	public String getConfirmOption() {
		return confirmOption;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setContractid(String contractid) {
		this.contractid = contractid;
	}
	public void setCancelReason(long cancelReason) {
		this.cancelReason = cancelReason;
	}
	public void setConfirmOption(String confirmOption) {
		this.confirmOption = confirmOption;
	}
	public String getConfirmPerson() {
		return confirmPerson;
	}
	public Date getConfirmTime() {
		return confirmTime;
	}
	public Date getCancelTime() {
		return cancelTime;
	}
	public void setConfirmPerson(String confirmPerson) {
		this.confirmPerson = confirmPerson;
	}
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	

}
