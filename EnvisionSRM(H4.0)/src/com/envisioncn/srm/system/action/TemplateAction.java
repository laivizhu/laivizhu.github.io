/**
 * 
 */
package com.envisioncn.srm.system.action;

import java.io.File;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.model.GlobalVal;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.ParamAssert;
import com.envisioncn.srm.system.bean.Template;
import com.envisioncn.srm.system.model.TemplateType;
import com.envisioncn.srm.system.service.ITemplateService;

/**
 * Copyright Envision
 *
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-25
 */
@SuppressWarnings("serial")
public class TemplateAction extends ABasicAction<Template> {
	private Template template;
	private ITemplateService templateService;
	private File file;
	private String filefileName;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(template.getName(), ErrorMessageConstants.System.Template.NAME_NOTNULL);
		ParamAssert.isTrue(file!=null, ErrorMessageConstants.System.Template.TEMPLATE_FILE_NOTNULL);
		
		return response();
	}
	
	public String setDefault()throws Exception{
		return response();
	}
	
	public String comboList()throws Exception{
		ParamAssert.isNotEmptyString(template.getTemplateType(), ErrorMessageConstants.System.Template.TYPE_NOTNULL);
		CriterionSet conditions=CriterionSet.CreateCriterion().put(Restrictions.eq("templateType", template.getTemplateType()));
		JsonList jsonList=new JsonList();
		for(Template template:this.templateService.getList(conditions)){
			jsonList.createItem().add("id", template.getId()).add("name", template.getName());
		}
		return response(jsonList);
	}
	
	public String templateTypeList()throws Exception{
		JsonList jsonList=new JsonList();
		for(TemplateType type:TemplateType.values()){
			jsonList.createItem().add("id", type.toText()).add("name", type.toText());
		}
		return response(jsonList);
	}

	public JsonItem getJsonItem(Template object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("name", object.getName())
		.add("file", object.getPath())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()))
		.add("isDefault", object.getId()==GlobalVal.getSupplierDefaultTemplate()?AppConstants.Template.IS_DEFAULT:AppConstants.Template.NOT_DEFAULT)
		.add("templateType", object.getTemplateType());
		return item;
	}
	
	public String list()throws Exception{
		JsonList jsonList=new JsonList();
		for(Template template:this.templateService.getList(start, limit)){
			jsonList.add(this.getJsonItem(template));
		}
		return response(jsonList.toPageString(this.templateService.getCount()));
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFilefileName() {
		return filefileName;
	}

	public void setFilefileName(String filefileName) {
		this.filefileName = filefileName;
	}

	@Resource(name="TemplateService")
	public void setTemplateService(ITemplateService templateService) {
		this.templateService = templateService;
	}
}
