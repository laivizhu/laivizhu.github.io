/**
 * 
 */
package com.envisioncn.srm.contract.action;

import java.io.File;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.Condition;
import com.envisioncn.srm.basic.model.ConditionSet;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.basic.model.type.ConditionType;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.JsonUtil;
import com.envisioncn.srm.contract.bean.DiviationBean;
import com.envisioncn.srm.contract.bean.DiviationHeadBean;
import com.envisioncn.srm.contract.bean.YearcontractBean;
import com.envisioncn.srm.contract.bean.YearcontractContentBean;
import com.envisioncn.srm.contract.common.YearContractConstants;
import com.envisioncn.srm.contract.service.DiviationHeadService;
import com.envisioncn.srm.contract.service.DiviationService;
import com.envisioncn.srm.contract.service.YearContractService;
import com.envisioncn.srm.contract.service.YearcontractContentService;
import com.envisioncn.srm.system.bean.UserBean;
import com.envisioncn.srm.system.service.UserService;


/**
 * Copyright Envision
 * 
 * @author mingsongliao
 * @version 1.0
 * @date 2012-10-15
 * 
 */
@SuppressWarnings("serial")
public class YearcontractAction extends ABasicAction<YearcontractBean> {
	
	private YearContractService yearcontractService;
	private YearcontractBean yearcontractBean;
	private YearcontractContentService yearcontractContentService;
	private DiviationService diviationService;
	private DiviationHeadService diviationHeadService;
	private UserService userService;
	
	public String yearcontractList() throws Exception {
		JsonList jsonList=new JsonList();
		for(YearcontractBean yearcontract:yearcontractService.getList(start,limit)){
			jsonList.createItem()
			.add("name", yearcontract.getName())
			.add("type", YearContractConstants.stateString(YearContractConstants.State.values()[Integer.parseInt(yearcontract.getType())]))
			.add("begindate", DateUtil.formatDate(yearcontract.getBegindate()))
			.add("enddate", DateUtil.formatDate(yearcontract.getEnddate()))
			.add("person", userService.getObjectById(UserBean.class, yearcontract.getPerson()).getName())
			.add("iseffective","有效")
			.add("callbackdata", yearcontract.getFilenumber())
			.add("id", yearcontract.getYearcontractid());
			
		}
		return response(jsonList.toPageString(yearcontractService.getCount()));
	}
   
	public String check() throws Exception {
		//ParamAssert.isNotNull(yearcontractBean.getName(), ErrorMessageConstants.Material.MATERIAL_CATEGORY_ISNOTNULL);
		//ParamAssert.isNotNull(yearcontractBean.getBegindate(), ErrorMessageConstants.Material.MATERIAL_CATEGORY_ISNOTNULL);
		//ParamAssert.isNotEqual(yearcontractBean.getType(), "",ErrorMessageConstants.Material.MATERIAL_CATEGORY_ISNOTNULL);
		//boolean isRepeat=yearcontractService.checkIsRepeat(name);
		ConditionSet conditions=new ConditionSet();
		conditions.put(new Condition("type",type)).put(new Condition("enddate",ConditionType.GE,begin));
		if(yearcontractService.getList(conditions).size()>0){
			JsonItem item = new JsonItem();
			item.add("isUnValidate", true);
			return response(JsonUtil.toJson(item));
		}else{
			JsonItem item = new JsonItem();
			item.add("isUnValidate", false);
			return response(JsonUtil.toJson(item));
		}
	}
	
	public String choise() throws Exception {
		Date today=new Date();
		ConditionSet conditions=new ConditionSet();
		conditions.put(new Condition("type",type))
		.put(new Condition("begindate",ConditionType.LE,today))
		.put(new Condition("enddate",ConditionType.GE,today));
		if(yearcontractService.getList(conditions).size()>0){
			YearcontractBean yb= yearcontractService.getList(conditions).get(0);
			JsonItem item = new JsonItem();
			item.add("yearContractChoise", true);
			item.add("yearContractId", yb.getYearcontractid());
			item.add("yearContractName", yb.getName());
			return response(JsonUtil.toJson(item));
		}else{
			JsonItem item = new JsonItem();
			item.add("yearContractChoise", false);
			return response(JsonUtil.toJson(item));
		}
	}
	
	public String diviationAdd() throws Exception {
		ConditionSet conditions=new ConditionSet();
		conditions.put(new Condition("yearcontractid",id)).put(new Condition("id",ConditionType.ACSORDER));
		if(yearcontractContentService.getList(conditions).size()>0){
			JsonList jsonList=new JsonList();
			for(YearcontractContentBean ycb:yearcontractContentService.getList(conditions)){
				jsonList.createItem()
				.add("projectnumber", ycb.getProjectnumber())
				.add("wordcontent", ycb.getWordcontent());
		    }
			return response(jsonList);
		}else{
			return null;
		}	
	}
	
	public String newIdGet() throws Exception {
		ConditionSet conditions=new ConditionSet();
		String projectnum1=projectnum+".";
		conditions.put(new Condition("yearcontractid",id)).put(new Condition("projectnumber",ConditionType.LIEK,projectnum1+"%")).put(new Condition("id",ConditionType.ACSORDER));
		//conditions.put(Restrictions.eq("yearcontractid", id)).put(Restrictions.like("projectnumber", projectnum1+"%")).put(Order.asc("id"));
		List<YearcontractContentBean> ycbList=yearcontractContentService.getList(conditions);
		if(null==ycbList || ycbList.size()==0){
			String newId=projectnum+".1";
			JsonItem item = new JsonItem();
			item.add("newId", newId);
			return response(JsonUtil.toJson(item));
		}else{
			int size=yearcontractContentService.getList(conditions).size();
			YearcontractContentBean ycb= yearcontractContentService.getList(conditions).get(size-1);
			String tempid=ycb.getProjectnumber();
			String beforeid=tempid.substring(0,tempid.lastIndexOf(".")+1);
			String endid=tempid.substring(tempid.lastIndexOf(".")+1,tempid.length());
			String newId=beforeid+String.valueOf(Integer.parseInt(endid)+1);
			JsonItem item = new JsonItem();
			item.add("newId", newId);
			return response(JsonUtil.toJson(item));
		}
		
	}
	
	public String diviationInsert() throws Exception {
		ConditionSet conditions=new ConditionSet();
		conditions.put(new Condition("yearcontractid",id)).put(new Condition("id",ConditionType.ACSORDER));
		if(yearcontractContentService.getList(conditions).size()>0){
			JsonList jsonList=new JsonList();
			for(YearcontractContentBean ycb:yearcontractContentService.getList(conditions)){
				String projectnumber_1=ycb.getProjectnumber();
				if(projectnumber_1.split("\\.").length<3){
					jsonList.createItem()
					.add("projectnumber", ycb.getProjectnumber());
				}
		    }
			return response(jsonList);
		}else{
			return null;
		}	
	}
	
	public String diviationSave() throws Exception {
		DiviationBean db = new DiviationBean();
		String contentold1=URLDecoder.decode(contentold,"UTF-8");
		String contentnew1=URLDecoder.decode(contentnew,"UTF-8");
		db.setDiviationId(String.valueOf(id));
		db.setProjectnumber(projectnum);
		db.setContentold(contentold1);
		db.setContentnew(contentnew1);
		diviationService.add(db);
		return null;
	}
	
	public String diviationHeadSave() throws Exception {
		DiviationHeadBean dhb = new DiviationHeadBean();
	//	String diviationId=String.valueOf(id)+String.valueOf(supplierId)+"V"+projectnum;
	//	dhb.setDiviationId(Long.parseLong(diviationId));
		dhb.setVersion(projectnum);
		diviationHeadService.add(dhb);
		
		String diviationTempId=String.valueOf(dhb.getId());
		ConditionSet conditions=new ConditionSet();
		conditions.put(new Condition("diviationId",ConditionType.LIEK,String.valueOf(id)));
		for(DiviationBean db:diviationService.getList(conditions)){
			db.setDiviationId(diviationTempId);
			diviationService.modify(db);
		}
		
		JsonItem item = new JsonItem();
		item.add("diviationId", diviationTempId);
		return response(JsonUtil.toJson(item));
	}
	
	public String diviationInsertSave() throws Exception {
		DiviationBean db = new DiviationBean();
		String contentold1=URLDecoder.decode(contentold,"UTF-8");
		String contentnew1=URLDecoder.decode(contentnew,"UTF-8");
		db.setDiviationId(String.valueOf(id));
		db.setProjectnumber(projectnum);
		db.setContentold(contentold1);
		db.setContentnew(contentnew1);
		diviationService.add(db);
		
		return null;
	}
	
	public String diviationList() throws Exception {
		ConditionSet conditions=new ConditionSet();
		conditions.put(new Condition("diviationId",ConditionType.LIEK,String.valueOf(id))).put(new Condition("projectnumber",ConditionType.ACSORDER));
		if(diviationService.getList(conditions).size()>0){
			JsonList jsonList=new JsonList();
			for(DiviationBean ycb:diviationService.getList(conditions)){
				JsonItem item=jsonList.createItem()
				.add("id", ycb.getId())
				.add("projectnumber", ycb.getProjectnumber());
				if(null==ycb.getContentold()||"".equals(ycb.getContentold())){
					item.add("contentold", "");
				}else{
					item.add("contentold", ycb.getContentold());
				}
				    item.add("contentnew", ycb.getContentnew());
		    }
			return response(jsonList);
		}else{
			return null;
		}	
	}
	
	public String diviationModify() throws Exception {
		ConditionSet conditions=new ConditionSet();
		System.out.println("****id="+id);
		conditions.put(new Condition("diviationId",ConditionType.LIEK,String.valueOf(id))).put(new Condition("projectnumber",ConditionType.ACSORDER));
		if(diviationService.getList(conditions).size()>0){
			JsonList jsonList=new JsonList();
			for(DiviationBean ycb:diviationService.getList(conditions)){
				DiviationBean dbNew = new DiviationBean();
				dbNew.setDiviationId(diviationId);
				dbNew.setProjectnumber(ycb.getProjectnumber());
				dbNew.setContentold(ycb.getContentold());
				dbNew.setContentnew(ycb.getContentnew());
				diviationService.add(dbNew);
				
				JsonItem item=jsonList.createItem()
				.add("id", dbNew.getId())
				.add("projectnumber", dbNew.getProjectnumber());
				if(null==dbNew.getContentold()||"".equals(dbNew.getContentold())){
					item.add("contentold", "");
				}else{
					item.add("contentold", dbNew.getContentold());
				}
				    item.add("contentnew", dbNew.getContentnew());
		    }
			return response(jsonList);
		}else{
			return null;
		}	
	}
	
	public String diviationDelete() throws Exception {
		
		diviationService.remove(id);
		return null;
		
	}
	
	public String wordcontentGet() throws Exception {
		ConditionSet conditions=new ConditionSet();
		conditions.put(new Condition("yearcontractid",id)).put(new Condition("projectnumber",projectnum));
		if(yearcontractContentService.getList(conditions).size()>0){
			YearcontractContentBean ycb= yearcontractContentService.getList(conditions).get(0);
			JsonItem item = new JsonItem();
			item.add("yearContractId", ycb.getYearcontractid());
			item.add("wordContent", ycb.getWordcontent());
			return response(JsonUtil.toJson(item));
		}else{
			return null;
		}	
		
	}
	

	public String uploadAdd() throws Exception {
	try{
		yearcontractService.addYearContract(yearcontractBean,word_path, this.getRealPath("/upload/contract"));
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
		return SUCCESS;
	}

	public String yearcontractView() throws Exception {
		List<?> yearcontractContentList = yearcontractContentService
				.getListObjects(id);
		ServletActionContext.getRequest().setAttribute(
				"yearcontractContentList", yearcontractContentList);
		return SUCCESS;
	}
   
	public InputStream getTargetFile() throws Exception{
		return ServletActionContext.getServletContext().getResourceAsStream(AppConstants.Contract.CONTRACT_DOWNLOAD_PATH+filename);
	}
	
	public String yearcontractDownload() throws Exception {
		return SUCCESS;
	}
	
	private File word_path;
    private String inputPath;
    private String filename;
    private Date begin;
	private Date end;
	private String type;
	private String name;
	private String projectnum;
	private String contentold;
	private String contentnew;
	private long supplierId;
	private String diviationId;
    
	
	
	public String getDiviationId()
	{
		return diviationId;
	}

	public void setDiviationId(String diviationId)
	{
		this.diviationId = diviationId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getContentold() {
		return contentold;
	}

	public String getContentnew() {
		return contentnew;
	}

	public void setContentold(String contentold) {
		this.contentold = contentold;
	}

	public void setContentnew(String contentnew) {
		this.contentnew = contentnew;
	}

	public String getProjectnum() {
		return projectnum;
	}

	public void setProjectnum(String projectnum) {
		this.projectnum = projectnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public YearContractService getYearcontractService() {
		return yearcontractService;
	}

	@Resource(name = "UserService")
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	@Resource(name = "YearcontractService")
	public void setYearcontractService(YearContractService yearcontractService) {
		this.yearcontractService = yearcontractService;
	}

	@Resource(name = "YearcontractContentService")
	public void setYearcontractContentService(
			YearcontractContentService yearcontractContentService) {
		this.yearcontractContentService = yearcontractContentService;
	}
   
	@Resource(name = "DiviationService")
	public void setDiviationService(DiviationService diviationService) {
		this.diviationService = diviationService;
	}
    
	@Resource(name = "DiviationHeadService")
	public void setDiviationHeadService(
			DiviationHeadService diviationHeadService) {
		this.diviationHeadService = diviationHeadService;
	}
	public YearcontractBean getYearcontractBean() {
		return yearcontractBean;
	}

	public void setYearcontractBean(YearcontractBean yearcontractBean) {
		this.yearcontractBean = yearcontractBean;
	}

	public File getWord_path() {
		return word_path;
	}

	public void setWord_path(File word_path) {
		this.word_path = word_path;
	}
	
	public Date getBegin() {
		return begin;
	}

	public Date getEnd() {
		return end;
	}

	public String getType() {
		return type;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public void setType(String type) {
		this.type = type;
	}

	public JsonItem getJsonItem(YearcontractBean object) throws Exception {
		return null;
	}

	

}
