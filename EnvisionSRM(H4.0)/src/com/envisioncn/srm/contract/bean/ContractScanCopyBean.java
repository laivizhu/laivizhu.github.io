/**
 * 
 */
package com.envisioncn.srm.contract.bean;

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
@Table(name = "srm_contract_scancopy")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ContractScanCopyBean implements BaseEntity {

	private long id;
	private String contractid;
	private String yearContract;
	private String diviation;
	private String price;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public String getContractid() {
		return contractid;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setContractid(String contractid) {
		this.contractid = contractid;
	}
	public String getYearContract() {
		return yearContract;
	}
	public String getDiviation() {
		return diviation;
	}
	public String getPrice() {
		return price;
	}
	public void setYearContract(String yearContract) {
		this.yearContract = yearContract;
	}
	public void setDiviation(String diviation) {
		this.diviation = diviation;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
