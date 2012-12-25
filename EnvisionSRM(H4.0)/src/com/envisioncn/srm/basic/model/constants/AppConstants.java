package com.envisioncn.srm.basic.model.constants;

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
	String CASCADE_REPLACE = "c";
	String POINT = ".";
	String LINE = "-";
	String SUCCESS_DOWNLOAD_RESULT = "successDownLoad";

	interface SupplierRelation {
		String FILE_SAVE_PATH = "/upload/nonstandardTemplate/";
	}

	interface Contract {
		String CONTRACT_DOWNLOAD_PATH = "/upload/contract/";
	}

	interface ContractReturnConstants {
		String SUCCESS_CONTRACT_CANCEL_VIEW = "success.contract.view1";
		String SUCCESS_CONTRACT_MODIFY_VIEW = "success.contract.view2";
		String SUCCESS_CONTRACT_MODIFYVIEW = "success.contract.modify.view";
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
	}

}
