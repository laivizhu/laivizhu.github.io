/**
 * 
 */
package com.envisioncn.srm.contract.bean;

import javax.persistence.Column;
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
 * @version 1.0
 * @date  2012-10-7
 * 
 */
@Entity
@Table(name = "srm_contract_yearContent")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class YearcontractContentBean implements BaseEntity{
   private long id;
   private long yearcontractid;
   private String projectnumber;
   private String wordcontent;

@Id
@GeneratedValue
public long getId() {
	return id;
}
public String getProjectnumber() {
	return projectnumber;
}


public long getYearcontractid() {
	return yearcontractid;
}
public void setYearcontractid(long yearcontractid) {
	this.yearcontractid = yearcontractid;
}
@Column(length=3000)
public String getWordcontent() {
	return wordcontent;
}
public void setId(long id) {
	this.id = id;
}
public void setProjectnumber(String projectnumber) {
	this.projectnumber = projectnumber;
}
public void setWordcontent(String wordcontent) {
	this.wordcontent = wordcontent;
}
  
   
}
