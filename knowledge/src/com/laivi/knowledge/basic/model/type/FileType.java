package com.laivi.knowledge.basic.model.type;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-12-1
 */
public enum FileType {
	DOC(".doc"),DOCX(".docx"),PDF(".pdf"),
	XSLX(".xlsx"),XLS(".xls"),XML(".xml"),
	PPTX(".pptx"),PPT(".ppt"),TXT(".txt"),
	JPG(".jpg"),BMP(".bmp"),GIF(".gif"),
	ZIP(".zip"),RAR(".rar"),JAR(".jar"),
	HTML(".html"),CSS(".css"),JSP(".jsp"),
	JS(".js"),JAVA(".java"),
	MP3(".mp3"),WMA(".wma"),
	AVI(".avi"),RMVB(".rmvb");

	private final String suffix;

	FileType(String suffix) {
		this.suffix = suffix;
	}

	public String toSuffix() {
		return this.suffix;
	}

}
