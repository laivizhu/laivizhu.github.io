package com.envisioncn.srm.basic.model.constants;

/**
 * 
 * Copyright Envision 系统通用错误常量定义
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public interface ErrorMessageConstants {
	String SEARCH_KEY_NOTEMPTY = "查询条件的类别不能为空";
	String SEARCH_VALUE_NOTEMPTY = "查询内容不能为空";
	String OBJECT_NOT_EXIST = "对象不存在";
	String DELETE_FAILURE = "删除失败";
	String OBJECT_HASEXIST = "记录已存在";

	interface Common {
		String FILE_NOT_DOC = "文件必须是.doc格式";
		String FILE_NOT_PDF = "文件必须是.pdf格式";
		String FILE_NOT_EXCEL = "文件必须是.xlsx格式";
		String FILE_NOT_FOUND = "文件加载失败，没找到。";
		String FILE_TYPE_NOT_FOUND = "文件类型找不到";
	}

	interface System {
		interface Template {
			String TYPE_NOTNULL = "模板类型不能为空";
			String NAME_NOTNULL = "模板名不能为空";
			String TEMPLATE_FILE_NOTNULL = "模板文件不能为空";
		}
	}

	interface EmailService {
		String EMAIL_TEMPLATE_NOTFOUNT = "不能找到邮件模板";
		String EMAIL_TEMPLATE_LONGDINGERROR = "加载邮件模板错误";
		String EMAIL_SEND_ERROR = "发送邮件失败";
	}

}
