package com.laivi.knowledge.basic.model.constants;

/**
 * 
 * Copyright Envision 系统通用部分常量定义
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public interface AppConstants {
	String EMPTY = "";
	String YES = "是";
	String NO = "否";
	String CASCADE_REPLACE = "c";
	String POINT = ".";
	String LINE = "-";
	String SUCCESS_DOWNLOAD_RESULT = "successDownLoad";
	String PLEASE_CHOOSE="---请选择---";
	String SUCCESS="success";
	int SUPPLIER_PORT_FLAG=1;

	String PICTURE_UPLOAD="picture\\";
	String PICTURE_DOWNLOAD="/picture/";


	interface ContractReturnConstants {
		String SUCCESS_CONTRACT_CANCEL_VIEW = "success.contract.view1";
		String SUCCESS_CONTRACT_MODIFY_VIEW = "success.contract.view2";
		String SUCCESS_CONTRACT_MODIFYVIEW = "success.contract.modify.view";
		String SUCCESS_CONTRACT_TOTALVIEW = "success.contract.total.view";
		String SUCCESS_YEARCONTRACT_VIEW="success.contract";
		String SUCCESS_CONTRACT_EDIT="success.contract.edit";
		String SUCCESS_CONTRACT_MODIFY_EDIT = "success.contract.modify.edit";
	}

	interface Material {
		String TABLE_EMPTY = "未设置";
		String SUB_EMPTY = "--";
		String HASH_IMPORT = "已导入";
		String NOT_IMPORT = "未导入";
	}

	interface RelationConstants {
		String SUCCESS_SECURIT_ADD = "success.securit.add";
		String SUCCESS_SECURIT_SUREDETAILS = "success.securit.suredetails";
		String SUCCESS_SECURIT_SURE = "success.securit.sure";
		String SUCCESS_SECURIT_CHECKDETAILS = "success.securit.checkdetails";
		String SUCCESS_SECURIT_CANCELDETAILS = "success.securit.canceldetails";
		String SUCCESS_SECURIT_CANCEL = "success.securit.cancel";
		String SUCCESS_SECURIT_SUPPLIERADD = "success.securit.supplieradd";
		String SUCCESS_SECURIT_IS_STANDARD = "success.securit.is.standard";
		String SUCCESS_SECURIT_TEMPLATE_ADD = "success.securit.template.add";
	}

	interface Template {
		String IS_DEFAULT = "默认";
		String NOT_DEFAULT = "非默认";
	}

	interface FileCategory {
		String DOC = ".doc";
		String PDF = "pdf";
		String EXCEL = "xlsx";

	}

	interface MailTemplate {
		String REGISTERCONFIRM = "confirm.ftl";
		String SUPPLIER_REJECT = "reason.ftl";
		String SUPPLIER_REPORT="report.ftl";
		String SUPPLIER_REPORT_REJECT="report_reason.ftl";
		String SECURIT_TEMPLATE_CONFIRM = "securitTemplateConfirm.ftl";
	}
	
	interface Result{
		String SESSION_OUTTIME="outtime";
		String SUPPLIER_SESSION_OUTTIME="supplierouttime";
	}

}
