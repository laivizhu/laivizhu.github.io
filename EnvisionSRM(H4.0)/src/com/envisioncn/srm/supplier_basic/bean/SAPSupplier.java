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
 * @data 2012-11-29
 */

@Entity
@Table(name = "srm_supplier_SAPSupplier")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SAPSupplier implements BaseEntity {
	private long id;
	private String salePerson; // 销售员
	private String salePhone; // 销售员电话
	private String pucharGroup; // 采购组
	private String code; // 供应商代码
	private String zipCode; // 邮编
	private String indexItem; // 检索项

	private String area; // 地区
	private String email; // email
	private String city; // 城市
	private String state; // 国家
	private String fax; // 传真
	private String branchPhone; // 分支电话
	private String phone; // 电话
	private String address; // 供应商地址
	private String handPhone; // 手机号码
	private String taxCode; // 税号
	private String saleItem; // 付款条款
	private String regCapital; // 注册资金
	private String realCapital; // 实收货币
	private String tradeCurrency; // 交易货币
	private String accountGroup; // 账号组
	private String bankcountry; // 银行国家
	private String bankCode; // 银行代码
	private String swiftCode; // SWIFT码
	private String bankAccount; // 银行账号
	private String referenceDetails; // 参考细节
	private String bankName; // 银行名
	private String maintainBankAccount; // 继续维护银行账号

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getSalePerson() {
		return salePerson;
	}

	public void setSalePerson(String salePerson) {
		this.salePerson = salePerson;
	}

	public String getSalePhone() {
		return salePhone;
	}

	public void setSalePhone(String salePhone) {
		this.salePhone = salePhone;
	}

	public String getPucharGroup() {
		return pucharGroup;
	}

	public void setPucharGroup(String pucharGroup) {
		this.pucharGroup = pucharGroup;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getBranchPhone() {
		return branchPhone;
	}

	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHandPhone() {
		return handPhone;
	}

	public void setHandPhone(String handPhone) {
		this.handPhone = handPhone;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getSaleItem() {
		return saleItem;
	}

	public void setSaleItem(String saleItem) {
		this.saleItem = saleItem;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getRealCapital() {
		return realCapital;
	}

	public void setRealCapital(String realCapital) {
		this.realCapital = realCapital;
	}

	public String getTradeCurrency() {
		return tradeCurrency;
	}

	public void setTradeCurrency(String tradeCurrency) {
		this.tradeCurrency = tradeCurrency;
	}

	public String getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	public String getBankcountry() {
		return bankcountry;
	}

	public void setBankcountry(String bankcountry) {
		this.bankcountry = bankcountry;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getReferenceDetails() {
		return referenceDetails;
	}

	public void setReferenceDetails(String referenceDetails) {
		this.referenceDetails = referenceDetails;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getMaintainBankAccount() {
		return maintainBankAccount;
	}

	public void setMaintainBankAccount(String maintainBankAccount) {
		this.maintainBankAccount = maintainBankAccount;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndexItem() {
		return indexItem;
	}

	public void setIndexItem(String indexItem) {
		this.indexItem = indexItem;
	}

}
