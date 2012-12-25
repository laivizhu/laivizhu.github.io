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
@Table(name = "srm_contract_diviationHead")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DiviationHeadBean implements BaseEntity {

	private long id;
	private long diviationId;
	private String contractid;
	private String version;
	private String attachment;
	private String remark;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public long getDiviationId() {
		return diviationId;
	}
	public String getContractid() {
		return contractid;
	}
	public String getVersion() {
		return version;
	}
	public String getAttachment() {
		return attachment;
	}
	public String getRemark() {
		return remark;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setDiviationId(long diviationId) {
		this.diviationId = diviationId;
	}
	public void setContractid(String contractid) {
		this.contractid = contractid;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	

}
