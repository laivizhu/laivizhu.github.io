package com.envisioncn.srm.supplier_basic.bean;

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
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-28
 */
@Entity
@Table(name = "srm_supplier_RFI")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SupplierRFI implements BaseEntity {
	private long id;

	private String companyName;
	private String companyCategory;
	private String createDate; // 成立时间
	private String RegCapital; // 注册资金
	private String Shareholder; // 股东情况
	private String address; // 公司地址
	private String state; // 国家
	private String city; // 城市
	private String subCompanyAddress; // 子公司地址
	private String person; // 联系人
	private String email;
	private String telPhone;
	private String fax; // 传真
	private String personTotal; // 员工总数
	private String manageTotal; // 管理人员总数
	private String engineerTotal; // 工程师总数
	private String techolTotal; // 技术人员总数
	private String beforeLastYearSale; // 前年年销售额
	private String lastYearSale; // 去年年销售额
	private String todayYearSale; // 今年年销售额
	private String currentCap; // 当前产能
	private String expandPlan; // 扩充计划

	private String consumerIds;
	private String produceDeviceIds;
	private String detectDeviceIds;
	private String producesIds;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(String companyCategory) {
		this.companyCategory = companyCategory;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getRegCapital() {
		return RegCapital;
	}

	public void setRegCapital(String regCapital) {
		RegCapital = regCapital;
	}

	public String getShareholder() {
		return Shareholder;
	}

	public void setShareholder(String shareholder) {
		Shareholder = shareholder;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSubCompanyAddress() {
		return subCompanyAddress;
	}

	public void setSubCompanyAddress(String subCompanyAddress) {
		this.subCompanyAddress = subCompanyAddress;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPersonTotal() {
		return personTotal;
	}

	public void setPersonTotal(String personTotal) {
		this.personTotal = personTotal;
	}

	public String getManageTotal() {
		return manageTotal;
	}

	public void setManageTotal(String manageTotal) {
		this.manageTotal = manageTotal;
	}

	public String getEngineerTotal() {
		return engineerTotal;
	}

	public void setEngineerTotal(String engineerTotal) {
		this.engineerTotal = engineerTotal;
	}

	public String getTecholTotal() {
		return techolTotal;
	}

	public void setTecholTotal(String techolTotal) {
		this.techolTotal = techolTotal;
	}

	public String getBeforeLastYearSale() {
		return beforeLastYearSale;
	}

	public void setBeforeLastYearSale(String beforeLastYearSale) {
		this.beforeLastYearSale = beforeLastYearSale;
	}

	public String getLastYearSale() {
		return lastYearSale;
	}

	public void setLastYearSale(String lastYearSale) {
		this.lastYearSale = lastYearSale;
	}

	public String getTodayYearSale() {
		return todayYearSale;
	}

	public void setTodayYearSale(String todayYearSale) {
		this.todayYearSale = todayYearSale;
	}

	public String getCurrentCap() {
		return currentCap;
	}

	public void setCurrentCap(String currentCap) {
		this.currentCap = currentCap;
	}

	public String getExpandPlan() {
		return expandPlan;
	}

	public void setExpandPlan(String expandPlan) {
		this.expandPlan = expandPlan;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConsumerIds() {
		return consumerIds;
	}

	public void setConsumerIds(String consumerIds) {
		this.consumerIds = consumerIds;
	}

	public String getProduceDeviceIds() {
		return produceDeviceIds;
	}

	public void setProduceDeviceIds(String produceDeviceIds) {
		this.produceDeviceIds = produceDeviceIds;
	}

	public String getDetectDeviceIds() {
		return detectDeviceIds;
	}

	public void setDetectDeviceIds(String detectDeviceIds) {
		this.detectDeviceIds = detectDeviceIds;
	}

	public String getProducesIds() {
		return producesIds;
	}

	public void setProducesIds(String producesIds) {
		this.producesIds = producesIds;
	}
}
