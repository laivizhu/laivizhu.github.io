package com.envisioncn.srm.basic.model.type;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-12-1
 */
public enum FileType {
	DOC(".doc"), PDF(".pdf"), XSLX(".xlsx"), XLS(".xls");

	private final String suffix;

	FileType(String suffix) {
		this.suffix = suffix;
	}

	public String toSuffix() {
		return this.suffix;
	}

}
