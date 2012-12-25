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
@Table(name = "srm_contract_attachment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AttachmentBean implements BaseEntity {

	private long id;
	private long pactId;
	private String attachmentName;
	private String type;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public long getPactId() {
		return pactId;
	}
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setPactId(long pactId) {
		this.pactId = pactId;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
