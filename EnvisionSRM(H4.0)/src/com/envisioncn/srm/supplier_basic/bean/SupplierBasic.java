/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-17
 */
package com.envisioncn.srm.supplier_basic.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.basic.model.json.JsonEntity;
import com.envisioncn.srm.infocenter.bean.NoticeOuterBean;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.supplier_development.bean.SecuritBean;

/**
 * Copyright Envision
 * 
 * @author Mars
 * @version
 * @data 2012-11-17
 */

@Entity
@Table(name = "srm_supplier_baisc")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SupplierBasic implements BaseEntity, JsonEntity {
	private long id;
	private String name; // 供应商名称
	private String Account; // 供应商登录账号
	private String password; // 供应商登录密码
	private String address; // 供应商地址
	private String email; // 供应商邮箱
	private String personName; // 负责人
	private String phone; // 负责人手机号
	private Date establishDate; // 创办时间
	private List<MaterialCategory> materialCategory = new ArrayList<MaterialCategory>(); // 物料类别
	private boolean productivityMaterial; // 是否生产性物料
	private String keyInfo; // 关键信息
	private int status; // 状 态
	private long userId; // 采购部申请人Id
	private Date applyDate; // 注册日期
	private String stopReason; // 终止原因

	private long supplierInfoId;
	private SecuritBean securit;

	private Set<NoticeOuterBean> notices = new HashSet<NoticeOuterBean>();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getKeyInfo() {
		return keyInfo;
	}

	public void setKeyInfo(String keyInfo) {
		this.keyInfo = keyInfo;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "srm_supplier_material", joinColumns = { @JoinColumn(name = "supplierId") }, inverseJoinColumns = { @JoinColumn(name = "materialCategoryId") })
	public List<MaterialCategory> getMaterialCategory() {
		return materialCategory;
	}

	public void setMaterialCategory(List<MaterialCategory> materialCategory) {
		this.materialCategory = materialCategory;
	}

	public String toJson() {
		return null;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Date getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public SecuritBean getSecurit() {
		return securit;
	}

	public void setSecurit(SecuritBean securit) {
		this.securit = securit;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public boolean isProductivityMaterial() {
		return productivityMaterial;
	}

	public void setProductivityMaterial(boolean productivityMaterial) {
		this.productivityMaterial = productivityMaterial;
	}

	public long getSupplierInfoId() {
		return supplierInfoId;
	}

	public void setSupplierInfoId(long supplierInfoId) {
		this.supplierInfoId = supplierInfoId;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "suppliers")
	public Set<NoticeOuterBean> getNotices() {
		return notices;
	}

	public void setNotices(Set<NoticeOuterBean> notices) {
		this.notices = notices;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}
}
