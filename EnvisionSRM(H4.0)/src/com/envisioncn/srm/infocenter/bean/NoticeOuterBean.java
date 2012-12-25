package com.envisioncn.srm.infocenter.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.supplier_basic.bean.SupplierBasic;
import com.envisioncn.srm.system.bean.DepartmentBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date 2012-11-22
 * 
 */

@Entity
@Table(name = "SRM_INFOCENTER_NOTICEOUTER")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class NoticeOuterBean implements BaseEntity
{

	private long id;
	private String title;
	private String content;
	private Date createTime;
	private Date modifyTime;
	private String attachment;
	private DepartmentBean department;
	private NoticeTypeBean noticeType;
	private List<SupplierBasic> suppliers = new ArrayList<SupplierBasic>();

	@Id
	@GeneratedValue
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	@Column(length = 50)
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	@Column(length = 10000)
	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifyTime()
	{
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime)
	{
		this.modifyTime = modifyTime;
	}

	public String getAttachment()
	{
		return attachment;
	}

	public void setAttachment(String attachment)
	{
		this.attachment = attachment;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	public DepartmentBean getDepartment()
	{
		return department;
	}

	public void setDepartment(DepartmentBean department)
	{
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	public NoticeTypeBean getNoticeType()
	{
		return noticeType;
	}

	public void setNoticeType(NoticeTypeBean noticeType)
	{
		this.noticeType = noticeType;
	}

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(
		name = "SRM_INFOCENTER_OUTER_SUPPLIER", 
		joinColumns = @JoinColumn(name = "noticeOuter_id"),
		inverseJoinColumns = @JoinColumn(name = "supplier_id"))
	public List<SupplierBasic> getSuppliers()
	{
		return suppliers;
	}

	public void setSuppliers(List<SupplierBasic> suppliers)
	{
		this.suppliers = suppliers;
	}
}
