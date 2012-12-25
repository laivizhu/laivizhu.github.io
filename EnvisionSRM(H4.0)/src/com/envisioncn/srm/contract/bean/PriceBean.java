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
@Table(name = "srm_contract_price")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PriceBean implements BaseEntity {

	private long id;
	private long priceId;
	private String contractid;
	private int version;
	private String remark;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	public String getContractid() {
		return contractid;
	}
	public String getRemark() {
		return remark;
	}
	public long getPriceId() {
		return priceId;
	}

	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}
    
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setId(long id) {
		this.id = id;
	}
	public void setContractid(String contractid) {
		this.contractid = contractid;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	

}
