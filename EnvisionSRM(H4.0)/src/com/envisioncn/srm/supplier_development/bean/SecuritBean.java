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
@Table(name = "srm_relation_securit")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SecuritBean implements BaseEntity, JsonEntity {
	private long id;                     // ID
	private long supplierID;             // 供应商ID
	private long securitTemplateID;      // 模板ID
	private String name;                 // 采购项目名称
	private Date newTime;                // 新建时间
	private Date effectTime;             // 生效时间
	private Date sureTime;               // 确认时间
	private Date cancelTime;             // 终止时间
	private String effectReason;         // 终止原因
	private String securitSupplier;      // 供应商回复保密协议名称（标准/非标准）
	private String nonstandardTemplate;  // 非标准保密协议
	private String remark;               // 备注
	private int state;                   // 状态（已发送/已确认/已生效/已作废）
	private boolean isStandard;          // 是否为标准模板（标准/不标准）


	@Id
	@GeneratedValue
	@Column(length = 20)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(long supplierID) {
		this.supplierID = supplierID;
	}

	public long getSecuritTemplateID() {
		return securitTemplateID;
	}

	public void setSecuritTemplateID(long securitTemplateID) {
		this.securitTemplateID = securitTemplateID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getNewTime() {
		return newTime;
	}

	public void setNewTime(Date newTime) {
		this.newTime = newTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getSureTime() {
		return sureTime;
	}

	public void setSureTime(Date sureTime) {
		this.sureTime = sureTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getEffectReason() {
		return effectReason;
	}

	public void setEffectReason(String effectReason) {
		this.effectReason = effectReason;
	}

	public String getSecuritSupplier() {
		return securitSupplier;
	}

	public void setSecuritSupplier(String securitSupplier) {
		this.securitSupplier = securitSupplier;
	}

	public String getNonstandardTemplate() {
		return nonstandardTemplate;
	}

	public void setNonstandardTemplate(String nonstandardTemplate) {
		this.nonstandardTemplate = nonstandardTemplate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public boolean getIsStandard() {
		return isStandard;
	}

	public void setIsStandard(boolean isStandard) {
		this.isStandard = isStandard;
	}

	public String toJson() {
		return null;
	}

}
