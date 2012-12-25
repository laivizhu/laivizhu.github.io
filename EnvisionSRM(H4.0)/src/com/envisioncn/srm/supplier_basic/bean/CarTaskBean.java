/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-28
 */
package com.envisioncn.srm.supplier_basic.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "srm_supplier_carTask")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CarTaskBean implements BaseEntity, JsonEntity {
	
	private long id;                            //ID
	private int type;                           //类型
	private String verificationResults;         //验证结果
	private String dutyOfficer;                 //责任人
	private Date finishTime;                    //完成时间
	private int state;                          //状态
	
	private CarBean car;                        //car表外键
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getVerificationResults() {
		return verificationResults;
	}

	public void setVerificationResults(String verificationResults) {
		this.verificationResults = verificationResults;
	}

	public String getDutyOfficer() {
		return dutyOfficer;
	}

	public void setDutyOfficer(String dutyOfficer) {
		this.dutyOfficer = dutyOfficer;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	@OneToOne
	public CarBean getCar() {
		return car;
	}

	public void setCar(CarBean car) {
		this.car = car;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String toJson() {
		return null;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
}
