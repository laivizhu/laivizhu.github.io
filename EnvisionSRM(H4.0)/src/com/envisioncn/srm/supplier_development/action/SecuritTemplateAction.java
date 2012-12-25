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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.JsonUtil;
import com.envisioncn.srm.basic.util.ParamAssert;
import com.envisioncn.srm.supplier_development.bean.SecuritTemplateBean;
import com.envisioncn.srm.supplier_development.service.SecuritTemplateService;

/**
 * Copyright Envision
 * 
 * @author Mars
 * @version
 * @data 2012-11-13
 */
@SuppressWarnings("serial")
public class SecuritTemplateAction extends ABasicAction<SecuritTemplateBean> {

	private SecuritTemplateService securitTemplateService;
	private SecuritTemplateBean securitTemplateBean;
	private File upload;
	private String savePath = getRealPath("/upload/template/standardTemplate");
	private String uploadFileName;
	@SuppressWarnings("unused")
	private InputStream file;
	
	/**
	 * 
	 * description:添加标准保密协议
	 * data 2012-11-27
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	
	public String add() throws Exception {
		String name = uploadFileName;
		File targetFile = new File(savePath + "/" + name);
		upload.renameTo(targetFile);
		
		securitTemplateBean.setAccessory(name);
		securitTemplateBean.setCreateDate(new Date());
		securitTemplateService.add(securitTemplateBean);	
		securitTemplateService.modify(securitTemplateBean);
		ParamAssert.isNotEmptyString(securitTemplateBean.getTemplateName(), ErrorMessageConstants.System.Template.NAME_NOTNULL);
		ParamAssert.isTrue(upload!=null, ErrorMessageConstants.System.Template.TEMPLATE_FILE_NOTNULL);
		return response(true,"新增成功！");
	}

	
	/**
	 * 
	 * description:删除标准保密协议
	 * data 2012-11-27
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		SecuritTemplateBean securitTemplateBean = this.securitTemplateService.getObject(id);
		if (securitTemplateBean == null) {
			return response(false, ErrorMessageConstants.OBJECT_NOT_EXIST);
		} else {
			try {
				securitTemplateService.removeObject(securitTemplateBean);
				return response(true,"删除成功！");
			} catch (Exception e) {
				return response(false, ErrorMessageConstants.DELETE_FAILURE);
			}
		}
	}
	
	
	/**
	 * 
	 * description:下载标准保密协议
	 * data 2012-11-27
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {
		SecuritTemplateBean bean = securitTemplateService.getObject(id);
		String fileName = bean.getAccessory();
		this.setUploadFileName(new String(fileName.getBytes(), "ISO8859-1"));
		File downFile = new File(savePath + "/" + fileName);
		this.setUpload(downFile);
		return "Download";
	}
	
	public InputStream getFile() {
		InputStream inputStream = ServletActionContext.getServletContext().getResourceAsStream("/upload/template/standardTemplate/" + upload.getName());
		return inputStream;
	}
	
	
	
	/**
	 * 
	 * description:保密协议模版JSON数据
	 * data 2012-11-27
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public JsonItem getSecuritJsonItem(SecuritTemplateBean object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("standardTemplateID", object.getId())
		.add("templateName", object.getTemplateName())
		.add("accessory", object.getAccessory())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()));
		return item;
	}
	
	
	
	/**
	 * 
	 * description:标准保密协议列表
	 * data 2012-11-27
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String securitList() throws Exception {
		JsonList jsonList = new JsonList();
		for (SecuritTemplateBean securitTemplateBean : this.securitTemplateService.getList(start, limit)) {
			jsonList.add(this.getSecuritJsonItem(securitTemplateBean));
		}
		return response(jsonList.toPageString(this.securitTemplateService.getCount()));
	}

	
	
	
	
	/**
	 * 
	 * description:添加保密协议下拉列表
	 * data 2012-11-27
	 * user Mars
	 * @return
	 * @throws Exception
	 */
	public String selectList() throws Exception {
		List<SecuritTemplateBean> securitTemplateList = securitTemplateService.getList();
		ArrayList<SecuritTemplateBean> list = new ArrayList<SecuritTemplateBean>(); 
		for(SecuritTemplateBean bean:securitTemplateList){ 
			list.add(bean); 
		}
		
		return response(JsonUtil.parseArray(list)); 
	}

	public SecuritTemplateBean getSecuritTemplateBean() {
		return securitTemplateBean;
	}

	public void setSecuritTemplateBean(SecuritTemplateBean securitTemplateBean) {
		this.securitTemplateBean = securitTemplateBean;
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

	@Resource(name = "SecuritTemplateService")
	public void setSecuritTemplateService(SecuritTemplateService securitTemplateService) {
		this.securitTemplateService = securitTemplateService;
	}

	public JsonItem getJsonItem(SecuritTemplateBean object) throws Exception {
		return null;
	}

}
