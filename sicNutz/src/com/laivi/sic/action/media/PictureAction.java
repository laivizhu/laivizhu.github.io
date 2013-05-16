package com.laivi.sic.action.media;

import java.io.File;
import java.util.UUID;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.json.JsonItemList;
import com.laivi.sic.model.po.media.Picture;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.util.basic.FileUtil;

@IocBean
@At("/media/picture")
public class PictureAction extends ABasicDBAction<Picture> {
	
	@At
	@AdaptBy(type = UploadAdaptor.class,args="ioc:upload")
	public Object upload(@Param("pictures")TempFile[] tempFiles,long albumId){
		JsonItemList jsonList=new JsonItemList();
		for(TempFile tempFile:tempFiles){
			File file=tempFile.getFile();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			Picture picture=new Picture(tempFile.getMeta().getFileLocalName(),uuid+"."+Files.getSuffixName(file).toLowerCase(),albumId);
			dao.insert(picture);
			jsonList.createItem().add("id",picture.getId()).add("name", picture.getName())
								 .add("size", file.length()).add("delete_type","GET")
								 .add("url","").add("delete_url","../media/picture/deleteFile.nut?id="+picture.getId()+"&fileName="+picture.getPath());
			String dest=this.getRealPath(AppConstants.PICTURE_UPLOAD+uuid)+"."+Files.getSuffixName(file).toLowerCase();
			//String smallPath = this.getRealPath("/upload/picture/"+uuid) + "_128x128." + Files.getSuffixName(file).toLowerCase();
			try{
				//Images.zoomScale(file, new File(smallPath), 128, 128,Color.BLACK);
				file.renameTo(new File(dest));
			}catch(Throwable e){
				e.printStackTrace();
			}
		}
		return jsonList.getRoot();
	}
	
	@At
	public Object pictureList(@Param("::page.")Pager page,long albumId){
		return list(page,Cnd.where("albumId", "=", albumId).desc("id"));
	}
	
	@At
	public Response deleteFile(long id,String fileName){
		dao.delete(Picture.class, id);
		File file=FileUtil.getFile(this.getRealPath(AppConstants.PICTURE_UPLOAD)+"\\"+fileName);
		if(file.exists()){
			file.delete();
		}
		return success();
	}

	@Override
	public Class<Picture> getEntityClass() {
		return Picture.class;
	}

}
