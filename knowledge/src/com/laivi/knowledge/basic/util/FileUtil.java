package com.laivi.knowledge.basic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorFileException;
import com.laivi.knowledge.basic.model.type.FileType;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-25
 */
public class FileUtil {

	/**
	 * 
	 * description:通过路径和文件名获取文件 data 2012-11-26 user Janlu.Zhu
	 *
	 * @return
	 */
	public static File getFile(String filePath) {
		return new File(filePath);
	}

	/**
	 * @throws ErrorFileException
	 * 
	 * 函数功能说明:保存文件处理 修改者名字Janlu 修改日期 2012-11-25 修改内容
	 * 
	 * @参数： @param file
	 * @参数： @param filepath
	 * @return void
	 * @throws
	 */
	public static String saveCodingFile(File file, String path, String fileName) throws ErrorFileException {
		//FileType type = FileUtil.getFileType(fileName);
		//String name = DateUtil.getCurrentDateFormatString() + type.toSuffix();
		FileOutputStream fos = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			fos = new FileOutputStream(path + "\\" + fileName);
			byte[] buffer = new byte[5120];
			int length;
			while ((length = is.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileName;
	}

	public static String saveCodingFileNew(File file, String path, String fileName) {
		String name = DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT) + AppConstants.LINE + fileName;
		FileOutputStream fos = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			fos = new FileOutputStream(path + "\\" + name);
			byte[] buffer = new byte[5120];
			int length;
			while ((length = is.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return name;
	}

	public static void saveFile(File file, String path, String fileName) {
		FileOutputStream fos = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			fos = new FileOutputStream(path + "\\" + fileName);
			byte[] buffer = new byte[5120];
			int length;
			while ((length = is.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getFileUrl(String url, String fileName, String fileTitle) throws ErrorFileException {
		if (DataUtil.notEmptyString(fileName)) {
			FileType type = FileUtil.getFileType(fileName);
			if(FileUtil.getFileType(fileTitle)!=null){
				return "<a href='" + url + "?fileName=" + fileName + "&downLoadFileName=" + fileTitle+ "'>" + fileTitle + "</a>";
			}
			return "<a href='" + url + "?fileName=" + fileName + "&downLoadFileName=" + fileTitle + type.toSuffix()
					+ "'>" + fileTitle + "</a>";
		} else {
			return AppConstants.EMPTY;
		}
	}

	public static FileType getFileType(String fileName) throws ErrorFileException {
		for (FileType type : FileType.values()) {
			if(!fileName.contains(AppConstants.POINT))
				return null;
			if (fileName.toLowerCase().endsWith(type.toSuffix())) {
				return type;
			}
		}
		throw new ErrorFileException(ErrorMessageConstants.Common.FILE_TYPE_NOT_FOUND);
	}

	public static String getCodingFileName(String fileName) throws ErrorFileException {
		FileType type = FileUtil.getFileType(fileName);
		String name = DateUtil.getCurrentDateFormatString() + type.toSuffix();
		return name;
	}
}
