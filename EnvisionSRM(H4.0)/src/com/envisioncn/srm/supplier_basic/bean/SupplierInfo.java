package com.envisioncn.srm.supplier_basic.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.basic.model.json.JsonEntity;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
@Entity
@Table(name = "srm_supplier_info")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SupplierInfo implements BaseEntity, JsonEntity {
	private long id;

	private String sellName; // 销售联系人
	private String sellPhone; // 销售电话
	private String sellLandline; // 销售座机
	private String sellEmail; // 销售Email

	private String qualityName; // 质量
	private String qualityPhone;
	private String qualityLandLine;
	private String qualityEmail;

	private String iTName; // IT技术和研发
	private String iTPhone;
	private String iTLandLine;
	private String iTEmail;

	private String logName; // 物流
	private String logPhone;
	private String logLandLine;
	private String logEmail;

	private String afterSaleName; // 售后
	private String afterSalePhone;
	private String afterSaleLandLine;
	private String afterSaleEmail;

	private String businessLicense; // 营业执照
	private String legalerIdentity; // 法人身份证明
	private String orgCodeCertificate; // 组织结构代码证
	private String taxRegCertificate; // 税务登记证
	private String bankAccountInfo; // 银行账户信息
	private String supplierDesc; // 供应商商介绍
	private String capacityDesc; // 产能说明
	private String creditRatingCertificate; // 资信等级证书
	private String envManageCertificate; // 环境管理认证
	private String qualityManageCertificate; // 质量管理认证
	private String securityManageCertificate; // 安全管理认证
	private String proprietaryMaterial; // 专利材料
	private String otherMaterial; // 其他补充材料
	private String surveyTable; // 供应商信息调查表
	private String productionLicense; // 生产许可证

	private Date receiveFileDate; // 正本文件日期
	private String deliveryNo; // 快递单号

	public String toJson() {
		return null;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return this.id;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getLegalerIdentity() {
		return legalerIdentity;
	}

	public void setLegalerIdentity(String legalerIdentity) {
		this.legalerIdentity = legalerIdentity;
	}

	public String getOrgCodeCertificate() {
		return orgCodeCertificate;
	}

	public void setOrgCodeCertificate(String orgCodeCertificate) {
		this.orgCodeCertificate = orgCodeCertificate;
	}

	public String getTaxRegCertificate() {
		return taxRegCertificate;
	}

	public void setTaxRegCertificate(String taxRegCertificate) {
		this.taxRegCertificate = taxRegCertificate;
	}

	public String getBankAccountInfo() {
		return bankAccountInfo;
	}

	public void setBankAccountInfo(String bankAccountInfo) {
		this.bankAccountInfo = bankAccountInfo;
	}

	public String getSupplierDesc() {
		return supplierDesc;
	}

	public void setSupplierDesc(String supplierDesc) {
		this.supplierDesc = supplierDesc;
	}

	public String getCapacityDesc() {
		return capacityDesc;
	}

	public void setCapacityDesc(String capacityDesc) {
		this.capacityDesc = capacityDesc;
	}

	public String getCreditRatingCertificate() {
		return creditRatingCertificate;
	}

	public void setCreditRatingCertificate(String creditRatingCertificate) {
		this.creditRatingCertificate = creditRatingCertificate;
	}

	public String getEnvManageCertificate() {
		return envManageCertificate;
	}

	public void setEnvManageCertificate(String envManageCertificate) {
		this.envManageCertificate = envManageCertificate;
	}

	public String getQualityManageCertificate() {
		return qualityManageCertificate;
	}

	public void setQualityManageCertificate(String qualityManageCertificate) {
		this.qualityManageCertificate = qualityManageCertificate;
	}

	public String getSecurityManageCertificate() {
		return securityManageCertificate;
	}

	public void setSecurityManageCertificate(String securityManageCertificate) {
		this.securityManageCertificate = securityManageCertificate;
	}

	public String getProprietaryMaterial() {
		return proprietaryMaterial;
	}

	public void setProprietaryMaterial(String proprietaryMaterial) {
		this.proprietaryMaterial = proprietaryMaterial;
	}

	public String getOtherMaterial() {
		return otherMaterial;
	}

	public void setOtherMaterial(String otherMaterial) {
		this.otherMaterial = otherMaterial;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getReceiveFileDate() {
		return receiveFileDate;
	}

	public void setReceiveFileDate(Date receiveFileDate) {
		this.receiveFileDate = receiveFileDate;
	}

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getSellName() {
		return sellName;
	}

	public void setSellName(String sellName) {
		this.sellName = sellName;
	}

	public String getSellPhone() {
		return sellPhone;
	}

	public void setSellPhone(String sellPhone) {
		this.sellPhone = sellPhone;
	}

	public String getSellLandline() {
		return sellLandline;
	}

	public void setSellLandline(String sellLandline) {
		this.sellLandline = sellLandline;
	}

	public String getSellEmail() {
		return sellEmail;
	}

	public void setSellEmail(String sellEmail) {
		this.sellEmail = sellEmail;
	}

	public String getQualityName() {
		return qualityName;
	}

	public void setQualityName(String qualityName) {
		this.qualityName = qualityName;
	}

	public String getQualityPhone() {
		return qualityPhone;
	}

	public void setQualityPhone(String qualityPhone) {
		this.qualityPhone = qualityPhone;
	}

	public String getQualityLandLine() {
		return qualityLandLine;
	}

	public void setQualityLandLine(String qualityLandLine) {
		this.qualityLandLine = qualityLandLine;
	}

	public String getQualityEmail() {
		return qualityEmail;
	}

	public void setQualityEmail(String qualityEmail) {
		this.qualityEmail = qualityEmail;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getLogPhone() {
		return logPhone;
	}

	public void setLogPhone(String logPhone) {
		this.logPhone = logPhone;
	}

	public String getLogLandLine() {
		return logLandLine;
	}

	public void setLogLandLine(String logLandLine) {
		this.logLandLine = logLandLine;
	}

	public String getLogEmail() {
		return logEmail;
	}

	public void setLogEmail(String logEmail) {
		this.logEmail = logEmail;
	}

	public String getAfterSaleName() {
		return afterSaleName;
	}

	public void setAfterSaleName(String afterSaleName) {
		this.afterSaleName = afterSaleName;
	}

	public String getAfterSalePhone() {
		return afterSalePhone;
	}

	public void setAfterSalePhone(String afterSalePhone) {
		this.afterSalePhone = afterSalePhone;
	}

	public String getAfterSaleLandLine() {
		return afterSaleLandLine;
	}

	public void setAfterSaleLandLine(String afterSaleLandLine) {
		this.afterSaleLandLine = afterSaleLandLine;
	}

	public String getAfterSaleEmail() {
		return afterSaleEmail;
	}

	public void setAfterSaleEmail(String afterSaleEmail) {
		this.afterSaleEmail = afterSaleEmail;
	}

	public String getSurveyTable() {
		return surveyTable;
	}

	public void setSurveyTable(String surveyTable) {
		this.surveyTable = surveyTable;
	}

	public String getProductionLicense() {
		return productionLicense;
	}

	public void setProductionLicense(String productionLicense) {
		this.productionLicense = productionLicense;
	}

	public String getITName() {
		return iTName;
	}

	public void setITName(String iTName) {
		this.iTName = iTName;
	}

	public String getITPhone() {
		return iTPhone;
	}

	public void setITPhone(String iTPhone) {
		this.iTPhone = iTPhone;
	}

	public String getITLandLine() {
		return iTLandLine;
	}

	public void setITLandLine(String iTLandLine) {
		this.iTLandLine = iTLandLine;
	}

	public String getITEmail() {
		return iTEmail;
	}

	public void setITEmail(String iTEmail) {
		this.iTEmail = iTEmail;
	}

}
