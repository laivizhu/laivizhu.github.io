package com.laivi.sic.model.constants;

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
	String URL="";
	int INDEXSIZE=5;
	
	long SYSTEM_USER_ID=1;

	String PICTURE_UPLOAD="/upload/picture/";
	String MUSIC_UPLOAD="/upload/music/";
	String BOOK_UPLOAD="/upload/book/";
	
	double PICTURE_COMPRESS_RATE=0.5;

	interface FileCategory {
		String DOC = ".doc";
		String PDF = "pdf";
		String EXCEL = "xlsx";
	}

	interface MailTemplate {
	}
	
	

}
