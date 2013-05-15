package com.laivi.sic.util.basic;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.constants.ErrorMessageConstants;
import com.laivi.sic.model.exception.ErrorFileException;
import com.laivi.sic.model.type.FileType;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Copyright Laivi
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
	public static String saveFile(File file, String path, String fileName) throws ErrorFileException {
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

	public static String saveCodingFile(File file, String path, String fileName) throws ErrorFileException {
		FileType fileType=FileUtil.getFileType(fileName);
		String name = UUID.randomUUID().toString()+DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT)+ fileType.toSuffix();
		Pattern pattern = Pattern.compile(".bmp|.gif|.gepg|.png");
		Matcher matcher = pattern.matcher(fileType.toSuffix());
		if(matcher.find()){
			FileUtil.compressImage(file, path, name);
		}else{
			FileUtil.saveFile(file, path, name);
		}
		return name;
	}

	public static String getFileUrl(String url, String fileName, String fileTitle) throws ErrorFileException {
		if (DataUtil.notEmptyString(fileName)) {
			FileType type = FileUtil.getFileType(fileName);
			if(FileUtil.getFileType(fileTitle)!=null){
				return "<a href='" + url + "?fileName=" + fileName + "&downLoadFileName=" + fileTitle+ "'><i class='icon-download'></i>" + fileTitle + "</a>";
			}
			return "<a href='" + url + "?fileName=" + fileName + "&downLoadFileName=" + fileTitle + type.toSuffix()
					+ "' class='btn btn-primary'><i class='icon-download'></i>下载</a>";
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
	
	public static void compressImage(File file, String path, String fileName) throws ErrorFileException {
		FileOutputStream fos=null;
		try{
			Image img=ImageIO.read(file);
			BufferedImage tag=new BufferedImage((int) (img.getWidth(null)*AppConstants.PICTURE_COMPRESS_RATE),(int) (img.getHeight(null)*AppConstants.PICTURE_COMPRESS_RATE),BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(img.getScaledInstance((int) (img.getWidth(null)*AppConstants.PICTURE_COMPRESS_RATE),(int) (img.getHeight(null)*AppConstants.PICTURE_COMPRESS_RATE), Image.SCALE_SMOOTH), 0, 0, null);
			fos = new FileOutputStream(path + "\\" + fileName);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos); 
			encoder.encode(tag); 
			fos.close(); 
		}catch(IOException e){
			throw new ErrorFileException("");
		} 
		
	}
}
