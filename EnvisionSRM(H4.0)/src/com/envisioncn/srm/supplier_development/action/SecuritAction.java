/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-13
 */
package com.envisioncn.srm.supplier_development.action;

import java.io.File;
import java.io.InputStream;
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
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.supplier_basic.service.ISupplierBasicService;
import com.envisioncn.srm.supplier_development.bean.SecuritBean;
import com.envisioncn.srm.supplier_development.bean.SecuritTemplateBean;
import com.envisioncn.srm.supplier_development.common.SecuritState;
import com.envisioncn.srm.supplier_development.service.ISecuritService;
import com.envisioncn.srm.supplier_development.service.ISecuritTemplateService;

@SuppressWarnings("serial")
public class SecuritAction extends ABasicAction<SecuritBean> {
	private ISecuritService securitService;
	private ISupplierBasicService supplierBasicService;
	private ISecuritTemplateService securitTemplateService;

	private SecuritBean securitBean;
	private long id;
	private File upload;
	@SuppressWarnings("unused")
	private InputStream file;//下载标准保密协议模板
	@SuppressWarnings("unused")
	private InputStream file2;//下载非标准保密协议模板
	@SuppressWarnings("unused")
	private InputStream file3;//下载供应商回复的保密协议
	
	private String statusType;
	private String savePath = getRealPath("/upload/template/nonstandardTemplate");
	private String savePath2 = getRealPath("/upload/template/standardTemplate");
	private String savePath3 = getRealPath("/upload/supplierReplySecurit");
	private String uploadFileName;
	
	
	/**
	 * 
	 * description:采购端——发送保密协议
	 * data 2012-11-16
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		if (securitBean.getSecuritTemplateID() == -2) {
			File file = upload;
			String name = uploadFileName;
			File targetFile = new File(savePath + "/" + name);
			file.renameTo(targetFile);
			securitBean.setNonstandardTemplate(name);
		}
		securitBean.setNewTime(new Date());
		securitBean.setState(SecuritState.STATE_UNCONFIRM.toValue());
		securitBean.setIsStandard(this.securitBean.getSecuritTemplateID() >= 0);
		securitService.add(securitBean);
		return AppConstants.RelationConstants.SUCCESS_SECURIT_ADD;
	}
	
	
	/**
	 * 
	 * description:供应商端——查看保密协议列表
	 * data 2012-11-16
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String supplierList() throws Exception {
		JsonList jsonList = new JsonList();
		ConditionSet conditions = new ConditionSet();
		conditions.put(new Condition("state", Integer.parseInt(statusType))).put(new Condition("supplierID",(long)1));
		List<SecuritBean> beans = securitService.getList(conditions, start, limit);
		for(SecuritBean securitBean:beans){
			long templateID = securitBean.getSecuritTemplateID();
			String standardTemplateName = "空";
			String noStandardTemplateName = "空";
			if(templateID == -2){
				noStandardTemplateName = securitBean.getNonstandardTemplate();
			}else{
				SecuritTemplateBean templateBean = securitTemplateService.getObject(templateID);
				standardTemplateName = templateBean.getTemplateName();
			}
			
			JsonItem item=jsonList.createItem()
			.add("id", securitBean.getId())
			.add("supplierID",securitBean.getSupplierID())
			.add("supplierName", supplierBasicService.getObject(securitBean.getSupplierID()).getName())  
			.add("standardTemplate", standardTemplateName)
			.add("nonstandardTemplate", noStandardTemplateName)
			.add("supplierEmail", supplierBasicService.getObject(securitBean.getSupplierID()).getEmail());
			switch(SecuritState.fromValue(Integer.parseInt(statusType))){
			case STATE_CONFIRM:
				item.add("state", SecuritState.STATE_CONFIRM.toText());
				item.add("sureTime", DateUtil.formatDate(securitBean.getSureTime()));
				break;
			case STATE_DELETE:
				item.add("state", SecuritState.STATE_DELETE.toText());
				item.add("sureTime", DateUtil.formatDate(securitBean.getCancelTime()));
				break;
			case STATE_EFFECT:
				item.add("state", SecuritState.STATE_EFFECT.toText());
				item.add("sureTime", DateUtil.formatDate(securitBean.getEffectTime()));
				break;
			case STATE_UNCONFIRM:
				item.add("state", SecuritState.STATE_UNCONFIRM.toText());
				item.add("newTime", DateUtil.formatDate(securitBean.getNewTime()));
				break;
			}
		}
		
		return response(jsonList.toPageString(securitService.getCount()));
	}
	
	/**
	 * 
	 * description:供应商端——下载标准保密协议
	 * data 2012-11-27
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String standardDownload() throws Exception {
		SecuritBean securitBean = securitService.getObject(id);
		SecuritTemplateBean bean = securitTemplateService.getObject(securitBean.getSecuritTemplateID());
		String fileName = bean.getAccessory();
		this.setUploadFileName(new String(fileName.getBytes(), "ISO8859-1"));
		File downFile = new File(savePath + "/" + fileName);
		this.setUpload(downFile);
		return "standardDownload";
	}
	
	public InputStream getFile() {
		InputStream inputStream = ServletActionContext.getServletContext().getResourceAsStream("/upload/template/standardTemplate/" + upload.getName());
		return inputStream;
	}
	
	
	/**
	 * 
	 * description:供应商端——下载非标准保密协议
	 * data 2012-11-27
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String nonStandardDownload() throws Exception {
		SecuritBean securitBean = securitService.getObject(id);
		String fileName = securitBean.getNonstandardTemplate();
	
		this.setUploadFileName(new String(fileName.getBytes(), "ISO8859-1"));
		File downFile = new File(savePath2 + "/" + fileName);
		this.setUpload(downFile);
		return "nonStandardDownload";
	}
	
	public InputStream getFile2() {
		InputStream inputStream = ServletActionContext.getServletContext().getResourceAsStream("/upload/template/nonstandardTemplate/" + upload.getName());
		return inputStream;
	}
	
	
	
	/**
	 * 
	 * description:供应商端——检查是否为标准协议
	 * data 2012-11-22
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String checkIsStandard() throws Exception {
		ConditionSet conditions = new ConditionSet();
		conditions.put(new Condition("state", SecuritState.STATE_UNCONFIRM.toValue())).put(new Condition("supplierID",(long)1));
		SecuritBean securitBean = this.securitService.getList(conditions, 0, 1).get(0);
		boolean isStandard = securitBean.getIsStandard();
		ServletActionContext.getRequest().setAttribute("isStandard", isStandard);
		return AppConstants.RelationConstants.SUCCESS_SECURIT_IS_STANDARD;
	}
	
	/**
	 * 
	 * description:供应商端——上传保密协议
	 * data 2012-11-22
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String supplierAdd() throws Exception {
		ConditionSet conditions = new ConditionSet();
		conditions.put(
				new Condition("state", SecuritState.STATE_UNCONFIRM.toValue()))
				.put(new Condition("supplierID", (long) 1));
		List<SecuritBean> beans = this.securitService.getList(conditions, 0, 1);
		SecuritBean securitBean = beans.get(0);

		File file = upload;
		String name = uploadFileName;
		File targetFile = new File(savePath3 + "/" + name);
		file.renameTo(targetFile);

		securitBean.setSecuritSupplier(name);

		securitService.modify(securitBean);
		return AppConstants.RelationConstants.SUCCESS_SECURIT_SUPPLIERADD;
	}

	
	/**
	 * 
	 * description:采购端——确认保密协议列表，查看所有保密协议列表，终止保密协议列表
	 * data 2012-11-22
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		JsonList jsonList = new JsonList();
		ConditionSet conditions = new ConditionSet();
		if(Integer.parseInt(statusType)!=-1){
			conditions.put(new Condition("state", Integer.parseInt(statusType)));
		}
		for(SecuritBean securitBean:securitService.getList(conditions, start, limit)){
			JsonItem item=jsonList.createItem()
			.add("id", securitBean.getId())
			.add("supplierID", securitBean.getSupplierID())
			.add("supplierName", supplierBasicService.getObject(securitBean.getSupplierID()).getName())
			.add("supplierEmail", supplierBasicService.getObject(securitBean.getSupplierID()).getEmail()); 
			switch(SecuritState.fromValue(securitBean.getState())){
			case STATE_CONFIRM:
				item.add("state", SecuritState.STATE_CONFIRM.toText());
				item.add("sureTime", DateUtil.formatDate(securitBean.getSureTime()));
				break;
			case STATE_DELETE:
				item.add("state", SecuritState.STATE_DELETE.toText());
				item.add("sureTime", DateUtil.formatDate(securitBean.getCancelTime()));
				break;
			case STATE_EFFECT:
				item.add("state", SecuritState.STATE_EFFECT.toText());
				item.add("sureTime", DateUtil.formatDate(securitBean.getEffectTime()));
				break;
			case STATE_UNCONFIRM:
				item.add("state", SecuritState.STATE_UNCONFIRM.toText());
				item.add("newTime", DateUtil.formatDate(securitBean.getNewTime()));
				break;
			}
			if(securitBean.getSecuritTemplateID() == -2){
				item.add("standardTemplate", "空")
				.add("nonstandardSupplier", securitBean.getSecuritSupplier());
			}else{
				item.add("standardTemplate", securitBean.getSecuritSupplier())
				.add("nonstandardSupplier", "空");
			}
			item.add("isStandard", securitBean.getIsStandard());	
		}
		return response(jsonList.toPageString(securitService.getCount()));
	}
	
	/**
	 * 
	 * description:采购端——下载非标准保密协议
	 * data 2012-11-27
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String SupplierReplyDownload() throws Exception {
		SecuritBean securitBean = securitService.getObject(id);
		String fileName = securitBean.getSecuritSupplier();
	
		this.setUploadFileName(new String(fileName.getBytes(), "ISO8859-1"));
		File downFile = new File(savePath3 + "/" + fileName);
		this.setUpload(downFile);
		return "SupplierReplyDownload";
	}
	
	public InputStream getFile3() {
		InputStream inputStream = ServletActionContext.getServletContext().getResourceAsStream("/upload/supplierReplySecurit/" + upload.getName());
		return inputStream;
	}
	
	
	
	
	/**
	 * 
	 * description:采购端——确认保密协议详情
	 * data 2012-11-16
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String sure() throws Exception {
		SecuritBean securitBean = securitService.getObject(id);
		
		boolean isStandard = securitBean.getIsStandard();
		ServletActionContext.getRequest().setAttribute("isStandard", isStandard);
		
		String supplierName = supplierBasicService.getObject(securitBean.getSupplierID()).getName();
		ServletActionContext.getRequest().setAttribute("supplierName", supplierName);
		
		ServletActionContext.getRequest().setAttribute("securitBean", securitBean);
		return AppConstants.RelationConstants.SUCCESS_SECURIT_SUREDETAILS;
	}
	
	/**
	 * 
	 * description:采购端——确认保密协议详情按钮
	 * data 2012-11-16
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String confirmSure() throws Exception {
		SecuritBean securitBean = securitService.getObject(id);
		securitBean.setState(SecuritState.STATE_EFFECT.toValue());
		securitBean.setSureTime(new Date());
		securitBean.setEffectTime(new Date());
		securitService.modify(securitBean);
		ServletActionContext.getRequest().setAttribute("securitBean", securitBean);
		return AppConstants.RelationConstants.SUCCESS_SECURIT_SURE;
	}
	
	/**
	 * 
	 * description:采购端——查看所有保密协议详情
	 * data 2012-11-16
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String check() throws Exception {
		SecuritBean securitBean = securitService.getObject(id);
		String supplierName = supplierBasicService.getObject(securitBean.getSupplierID()).getName();
		boolean isStandard = securitBean.getIsStandard();
		ServletActionContext.getRequest().setAttribute("isStandard", isStandard);
		ServletActionContext.getRequest().setAttribute("supplierName", supplierName);
		
		
		ServletActionContext.getRequest().setAttribute("securitBean", securitBean);
		return AppConstants.RelationConstants.SUCCESS_SECURIT_CHECKDETAILS;
	}
	
	/**
	 * 
	 * description:采购端——终止保密协议详情
	 * data 2012-11-16
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String cancel() throws Exception {
		SecuritBean securitBean = securitService.getObject(id);

		boolean isStandard = securitBean.getIsStandard();
		ServletActionContext.getRequest().setAttribute("isStandard", isStandard);
		
		String supplierName = supplierBasicService.getObject(securitBean.getSupplierID()).getName();
		ServletActionContext.getRequest().setAttribute("supplierName", supplierName);
		new JsonList().createItem().add("effectReason", securitBean.getEffectReason());
		ServletActionContext.getRequest().setAttribute("securitBean", securitBean);
		return AppConstants.RelationConstants.SUCCESS_SECURIT_CANCELDETAILS;
	}
	
	/**
	 * 
	 * description:采购端——终止保密协议详情按钮
	 * data 2012-11-16
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String confirmCancel() throws Exception {
		SecuritBean securitBean = securitService.getObject(id);
		securitBean.setState(SecuritState.STATE_DELETE.toValue());
		securitBean.setCancelTime(new Date());
		securitService.modify(securitBean);
		ServletActionContext.getRequest().setAttribute("securitBean", securitBean);
		return AppConstants.RelationConstants.SUCCESS_SECURIT_CANCEL;
	}

	
	
	
	public JsonItem getJsonItem(SecuritBean object) throws Exception {
		
		return null;
	}


/*	public void setUploadFileName(String filename) {
		// 防止重名，改名
		String format = filename.substring(filename.lastIndexOf("."));
		String file_name = filename.substring(filename.lastIndexOf("\\") + 1,
				filename.lastIndexOf("."));
		Date m_date_now = new Date();
		SimpleDateFormat timeformat = new SimpleDateFormat("yyyyMMddHHmmss",
				java.util.Locale.CHINA);
		String m_date = timeformat.format(m_date_now);
		filename = m_date + file_name + format;
		this.uploadFileName = filename;
	}*/

	public SecuritBean getSecuritBean() {
		return securitBean;
	}

	public void setSecuritBean(SecuritBean securitBean) {
		this.securitBean = securitBean;
	}
	

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	@Resource(name = "SecuritService")
	public void setSecuritService(ISecuritService securitService) {
		this.securitService = securitService;
	}
	
	public String getStatusType() {
		return this.statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	public String update() throws Exception {
		return null;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Resource(name="SupplierBasicService")
	public void setSupplierBasicService(ISupplierBasicService supplierBasicService) {
		this.supplierBasicService = supplierBasicService;
	}
	

	
	@Resource(name="SecuritTemplateService")
	public void setSecuritTemplateService(ISecuritTemplateService securitTemplateService) {
		this.securitTemplateService = securitTemplateService;
	}

}
