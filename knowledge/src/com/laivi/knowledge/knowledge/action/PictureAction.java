package com.laivi.knowledge.knowledge.action;

import java.io.File;

import javax.annotation.Resource;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.FileUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.knowledge.model.po.Picture;
import com.laivi.knowledge.knowledge.service.IPictureService;
import com.laivi.knowledge.knowledge.service.ITagService;

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
	private ITagService tagService;
	private Picture picture;
	private File[] pictures;
	private String[] picturesFileName;
	
	public PictureAction(){
		downLoadPath=AppConstants.PICTURE_DOWNLOAD;
	}
	
	public String upload()throws Exception{
		if(pictures!=null){
			return response(pictureService.upload(pictures, picturesFileName, this.getCurrentUserId(),this.getRealPath(AppConstants.PICTURE_UPLOAD)).toString());
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

	@Override
	public JsonItem getJsonItem(Picture object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("description", object.getDescription())
		.add("tagIds", this.tagService.getTagsName(object.getTagIds()))
		.add("path",object.getPath())
		.add("inDate", DateUtil.formatDate(object.getIndate()));
		return item;
	}
	
	public JsonList getSearchComboList()throws ErrorException{
		JsonList jsonList=new JsonList();
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
	
	@Resource(name = "TagService")
	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
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
