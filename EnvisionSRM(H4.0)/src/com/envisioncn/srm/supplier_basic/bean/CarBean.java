/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-28
 */
package com.envisioncn.srm.supplier_basic.bean;

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

/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-28
 */

@Entity
@Table(name = "srm_supplier_car")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CarBean implements BaseEntity,JsonEntity {
	private long id;                            //ID
	private String componentName;               //零部件名称
	private long  componentID;                  //部件序列号
	private long drawingID;                     //图纸编号 
	private long drawingVersionID;              //图纸版本号
	private int defectLevels;                   //缺陷等级
	private String questionDescription;         //问题描述
	private String foundName;                   //发现人员
	private String happenPlace;                 //发生地点
	private Date happenTime;                    //发生时间
	private String effectScope;                 //潜在影响范围
	private String attachment;                  //附件（图片、视频相关文件等）
	private String attachmentCar;               //上传概述对策报告书
	private int department;                     //远景内部负责部门（采购部、质量工程部）
	private String supplierName;                //供应商名称

	private String reviewOpinion;                //责任SQE结案审查意见
	private String attachmentRelativeFile;       //附件相关文件
	
	
	@Id
	@GeneratedValue
	@Column(length = 20)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public long getComponentID() {
		return componentID;
	}

	public void setComponentID(long componentID) {
		this.componentID = componentID;
	}

	public long getDrawingID() {
		return drawingID;
	}

	public void setDrawingID(long drawingID) {
		this.drawingID = drawingID;
	}

	public long getDrawingVersionID() {
		return drawingVersionID;
	}

	public void setDrawingVersionID(long drawingVersionID) {
		this.drawingVersionID = drawingVersionID;
	}

	public int getDefectLevels() {
		return defectLevels;
	}

	public void setDefectLevels(int defectLevels) {
		this.defectLevels = defectLevels;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getFoundName() {
		return foundName;
	}

	public void setFoundName(String foundName) {
		this.foundName = foundName;
	}

	public String getHappenPlace() {
		return happenPlace;
	}

	public void setHappenPlace(String happenPlace) {
		this.happenPlace = happenPlace;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getHappenTime() {
		return happenTime;
	}

	public void setHappenTime(Date happenTime) {
		this.happenTime = happenTime;
	}

	public String getEffectScope() {
		return effectScope;
	}

	public void setEffectScope(String effectScope) {
		this.effectScope = effectScope;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentCar() {
		return attachmentCar;
	}

	public void setAttachmentCar(String attachmentCar) {
		this.attachmentCar = attachmentCar;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getReviewOpinion() {
		return reviewOpinion;
	}

	public void setReviewOpinion(String reviewOpinion) {
		this.reviewOpinion = reviewOpinion;
	}

	public String getAttachmentRelativeFile() {
		return attachmentRelativeFile;
	}

	public void setAttachmentRelativeFile(String attachmentRelativeFile) {
		this.attachmentRelativeFile = attachmentRelativeFile;
	}

	public String toJson() {
		return null;
	}
}
