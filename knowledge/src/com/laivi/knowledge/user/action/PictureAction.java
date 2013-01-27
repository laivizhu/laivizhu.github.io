package com.laivi.knowledge.user.action;

import java.io.File;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.FileUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.Picture;
import com.laivi.knowledge.user.service.IPictureService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-1
 */
@SuppressWarnings("serial")
public class PictureAction extends ABasicAction<Picture> {
	private IPictureService pictureService;
	private Picture picture;
	private File[] pictures;
	private String[] picturesFileName;
	
	public PictureAction(){
		downLoadPath=AppConstants.PICTURE_DOWNLOAD;
	}
	
	public String upload()throws Exception{
		if(pictures!=null){
			return response(pictureService.upload(pictures, picturesFileName,this.getRealPath(AppConstants.PICTURE_UPLOAD)).toString());
		}else{
			return response(false);
		}
	}
	
	public String delete()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		basicService.remove(id);
		File file=FileUtil.getFile(this.getRealPath(AppConstants.PICTURE_UPLOAD)+"\\"+fileName);
		if(file.exists()){
			file.delete();
		}
		return response(true);
	}

	public JsonItem getJsonItem(Picture object,boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("description", object.getDescription())
		.add("path",object.getPath())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()));
		return item;
	}
	
	public JsonItemList getSearchComboList()throws ErrorException{
		JsonItemList jsonList=new JsonItemList();
		return jsonList;
	}

	@Resource(name="PictureService")
	public void setPictureService(IPictureService pictureService) {
		this.pictureService = pictureService;
	}
	
	@Resource(name = "PictureService")
    public void setBasicService(IBasicService<Picture> basicService){
    	this.basicService=basicService;
    }

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String[] getPicturesFileName() {
		return picturesFileName;
	}

	public void setPicturesFileName(String[] picturesFileName) {
		this.picturesFileName = picturesFileName;
	}

	public File[] getPictures() {
		return pictures;
	}

	public void setPictures(File[] pictures) {
		this.pictures = pictures;
	}
}
