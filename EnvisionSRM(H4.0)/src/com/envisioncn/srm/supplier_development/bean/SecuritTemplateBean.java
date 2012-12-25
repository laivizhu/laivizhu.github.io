/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-22
 */
package com.envisioncn.srm.supplier_development.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.basic.model.json.JsonEntity;


@Entity
@Table(name = "srm_relation_securittemplate")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SecuritTemplateBean implements BaseEntity, JsonEntity {
	private long id;                // ID
	private String templateName;    // 标准保密协议模板名称
	private String accessory;       // 附件
	private Date createDate;        // 新建时间
	private boolean cancelState;    // 失效状态（是，否）

	@Id
	@GeneratedValue
	@Column(length = 20)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public boolean isCancelState() {
		return cancelState;
	}

	public void setCancelState(boolean cancelState) {
		this.cancelState = cancelState;
	}

	public String getAccessory() {
		return accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String toJson() {
		return null;
	}

}
