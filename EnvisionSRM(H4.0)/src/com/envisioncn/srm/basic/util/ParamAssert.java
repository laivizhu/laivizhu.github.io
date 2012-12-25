package com.envisioncn.srm.basic.util;

import java.io.File;

import com.envisioncn.srm.basic.model.SRMException;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;

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

	public static void isNotEmptyString(String s, String errorInfo) throws SRMException {
		isTrue(s != null && !s.isEmpty(), errorInfo);
	}

	public static void isNotNull(Object o, String errorInfo) throws SRMException {
		isTrue(o != null, errorInfo);
	}

	public static void isNull(Object o, String errorInfo) throws SRMException {
		isTrue(o == null, errorInfo);
	}

	public static void isEqual(Object a, Object b, String errorInfo) throws SRMException {
		isTrue(a.equals(b), errorInfo);
	}

	public static void isNotEqual(Object a, Object b, String errorInfo) throws SRMException {
		isTrue(!a.equals(b), errorInfo);
	}

	public static void isSame(Object a, Object b, String errorInfo) throws SRMException {
		isTrue(a == b, errorInfo);
	}

	public static void isTrue(boolean result, String errorInfo) throws SRMException {
		if (!result) {
			throw new SRMException(errorInfo);
		}
	}

	public static void isFalse(boolean result, String errorInfo) throws SRMException {
		if (result) {
			throw new SRMException(errorInfo);
		}
	}

	public static void isNotNULLFileDOC(File file, String fileName, String errorInfo) throws SRMException {
		if (file == null) {
			throw new SRMException(errorInfo);
		}
		if (!fileName.toLowerCase().endsWith("doc")) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_DOC);
		}
	}

	public static void isNotNULLFilePDF(File file, String fileName, String errorInfo) throws SRMException {
		if (file == null) {
			throw new SRMException(errorInfo);
		}

		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.PDF)) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_PDF);
		}
	}

	public static void isNotFilePDF(File file, String fileName) throws SRMException {
		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.PDF)) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_PDF);
		}
	}
	
	public static void isFileExcel(File file, String fileName) throws SRMException {
		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.EXCEL)) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_EXCEL);
		}
	}
	
	public static void isNotNULLFileExcel(File file, String fileName, String errorInfo) throws SRMException {
		if (file == null) {
			throw new SRMException(errorInfo);
		}
		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.EXCEL)) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_EXCEL);
		}
	}

}
