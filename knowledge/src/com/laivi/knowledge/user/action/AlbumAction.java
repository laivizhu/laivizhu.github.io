package com.laivi.knowledge.user.action;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.Album;
import com.laivi.knowledge.user.model.type.AlbumType;
import com.laivi.knowledge.user.service.IPictureService;
import com.laivi.knowledge.user.service.IUserService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
@SuppressWarnings("serial")
public class AlbumAction extends ABasicAction<Album> {
	
	private IUserService userService;
	private IPictureService pictureService;
	private Album album;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(album.getName(), "error.album.name.notNULL");
		ParamAssert.isNotEmptyString(album.getDescription(), "error.album.description.notNULL");
		ParamAssert.isTrue(album.getType()!=null, "");
		album.setUserId(this.getCurrentUserId());
		this.basicService.add(album);
		return response(true);
	}
	
	public String update()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		ParamAssert.isNotEmptyString(album.getName(), "error.album.name.notNULL");
		ParamAssert.isNotEmptyString(album.getDescription(), "error.album.description.notNULL");
		Album dAlbum=this.basicService.getObject(id);
		dAlbum.setDescription(album.getDescription());
		dAlbum.setName(album.getName());
		this.basicService.modify(dAlbum);
		return response(true);
	}
	
	public String get()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		Album dAlbum=this.basicService.getObject(id);
		JsonItem item=new JsonItem();
		if(font){
			item=this.getJsonItem(dAlbum, false);
		}else{
			item.add("id", dAlbum.getId()).add("album.name", dAlbum.getName()).add("album.description", dAlbum.getDescription()).add("album.type", dAlbum.getType());
		}
		return response(item.toFormDataString(true));
	}
	
	public String list()throws Exception{
		conditions=CriterionList.CreateCriterion();
		if(album.getType()!=null){
			conditions.put(Restrictions.eq("type",album.getType()));
		}
		return response(list(true,true));
	}
	
	public String typeList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		for(AlbumType type:AlbumType.values()){
			jsonList.createItem().add("value", type.name()).add("text", type.toText());
		}
		return response(jsonList);
	}
	
	public JsonItem getJsonItem(Album object,boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("name", object.getName())
		.add("description", isSub?DataUtil.getDefaultChar(object.getDescription()):object.getDescription())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()))
		.add("type",object.getType().toText())
		.add("user", this.userService.getObject(object.getUserId()).getUserName());
		if(DataUtil.notEmptyString(object.getItemIds()) && object.getType().toText().equals(AlbumType.PICTURE)){
			item.add("defaultPicture", this.pictureService.getObject(DataUtil.getIndexStringId(object.getItemIds(), 1)).getPath());
		}else{
			item.add("defaultPicture", "album.jpg");
		}
		return item;
	}
	
	public JsonItemList getSearchComboList()throws ErrorException{
		JsonItemList jsonList=new JsonItemList();
		jsonList.createItem().add("value", "name").add("text", "相册名");
		jsonList.createItem().add("value", "description").add("text", "相册描述");
		return jsonList;
	}
	
	@Resource(name="AlbumService")
	public void setBasicService(IBasicService<Album> basicService){
    	this.basicService=basicService;
    }
	
	@Resource(name="UserService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@Resource(name="PictureService")
	public void setPictureService(IPictureService pictureService) {
		this.pictureService = pictureService;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}
