package com.laivi.knowledge.basic.util;

import java.io.File;

import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;

/**
 * Copyright Envision 参数验证处理工具
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public final class ParamAssert {
	private ParamAssert() {
	}

	public static void isNotEmptyString(String s, String errorInfo) throws ErrorException {
		isTrue(s != null && DataUtil.notEmptyString(s), errorInfo);
	}
	
	public static void isNotEmptyString(String s, String errorInfo,boolean isMsg) throws ErrorException {
		isTrue(s != null && DataUtil.notEmptyString(s), errorInfo,isMsg);
	}

	public static void isNotNull(Object o, String errorInfo) throws ErrorException {
		isTrue(o != null, errorInfo);
	}

	public static void isNull(Object o, String errorInfo) throws ErrorException {
		isTrue(o == null, errorInfo);
	}

	public static void isEqual(Object a, Object b, String errorInfo) throws ErrorException {
		isTrue(a.equals(b), errorInfo);
	}

	public static void isNotEqual(Object a, Object b, String errorInfo) throws ErrorException {
		isTrue(!a.equals(b), errorInfo);
	}

	public static void isSame(Object a, Object b, String errorInfo) throws ErrorException {
		isTrue(a == b, errorInfo);
	}

	public static void isTrue(boolean result, String errorInfo) throws ErrorException {
		if (!result) {
			throw new ErrorException(errorInfo);
		}
	}
	
	public static void isTrue(boolean result, String errorInfo,boolean isMsg) throws ErrorException {
		if (!result) {
			throw new ErrorException(errorInfo,isMsg);
		}
	}

	public static void isFalse(boolean result, String errorInfo) throws ErrorException {
		if (result) {
			throw new ErrorException(errorInfo);
		}
	}

	public static void isNotNULLFileDOC(File file, String fileName, String errorInfo) throws ErrorException {
		if (file == null) {
			throw new ErrorException(errorInfo);
		}
		if (!fileName.toLowerCase().endsWith("doc")) {
			throw new ErrorException(fileName + ErrorMessageConstants.Common.FILE_NOT_DOC);
		}
	}

	public static void isNotNULLFilePDF(File file, String fileName, String errorInfo) throws ErrorException {
		if (file == null) {
			throw new ErrorException(errorInfo);
		}

		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.PDF)) {
			throw new ErrorException(fileName + ErrorMessageConstants.Common.FILE_NOT_PDF);
		}
	}

	public static void isNotFilePDF(File file, String fileName) throws ErrorException {
		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.PDF)) {
			throw new ErrorException(fileName + ErrorMessageConstants.Common.FILE_NOT_PDF);
		}
	}

	public static void isFileExcel(File file, String fileName) throws ErrorException {
		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.EXCEL)) {
			throw new ErrorException(fileName + ErrorMessageConstants.Common.FILE_NOT_EXCEL);
		}
	}

	public static void isNotNULLFileExcel(File file, String fileName, String errorInfo) throws ErrorException {
		if (file == null) {
			throw new ErrorException(errorInfo);
		}
		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.EXCEL)) {
			throw new ErrorException(fileName + ErrorMessageConstants.Common.FILE_NOT_EXCEL);
		}
	}

}
