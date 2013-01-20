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
	String POINT = ".";
	String LINE = "-";
	String SUCCESS_DOWNLOAD_RESULT = "successDownLoad";
	String PLEASE_CHOOSE="---请选择---";
	String SUCCESS="success";
	String ELLIPSIS="...";
	String URL="http://localhost:8080/knowledge/";
	int INDEXSIZE=5;


	String PICTURE_UPLOAD="picture\\";
	String PICTURE_DOWNLOAD="/picture/";
	double PICTURE_COMPRESS_RATE=0.5;

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

}
