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
 * @version
 * @data 2012-11-19
 */
@Entity
@Table(name = "srm_contract_contract")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ContractBean implements BaseEntity {

	private long id;
	private long yearcontractId;
	private String contractId;
	private long supplierId;
	private String status;
	private String isModify;
	private long userid;
	private Date createTime;
	private long diviationId;
	private String parentContractId;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public long getYearcontractId() {
		return yearcontractId;
	}
	public String getContractId() {
		return contractId;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public String getStatus() {
		return status;
	}
	public String getIsModify() {
		return isModify;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setYearcontractId(long yearcontractId) {
		this.yearcontractId = yearcontractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setIsModify(String isModify) {
		this.isModify = isModify;
	}
	public long getUserid() {
		return userid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public long getDiviationId() {
		return diviationId;
	}
	public void setDiviationId(long diviationId) {
		this.diviationId = diviationId;
	}
	public String getParentContractId()
	{
		return parentContractId;
	}
	public void setParentContractId(String parentContractId)
	{
		this.parentContractId = parentContractId;
	}
	
	

}
