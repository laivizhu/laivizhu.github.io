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
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonItemList;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.media.Album;
import com.laivi.sic.model.po.media.Music;
import com.laivi.sic.model.po.user.User;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.util.basic.FileUtil;

@IocBean
@At("/media/music")
public class MusicAction extends ABasicDBAction<Music> {

	@At
	@AdaptBy(type = UploadAdaptor.class,args="ioc:upload")
	public Object upload(@Param("pictures")TempFile[] tempFiles,long albumId){
		JsonItemList jsonList=new JsonItemList();
		for(TempFile tempFile:tempFiles){
			File file=tempFile.getFile();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			Music music=new Music(tempFile.getMeta().getFileLocalName(),uuid+"."+Files.getSuffixName(file).toLowerCase(),albumId);
			music.setPrice(0);
			dao.insert(music);
			jsonList.createItem().add("id",music.getId()).add("name", music.getName())
								 .add("size", file.length()).add("delete_type","GET")
								 .add("url","").add("delete_url","../media/music/deleteFile.nut?id="+music.getId()+"&fileName="+music.getPath());
			String dest=this.getRealPath(AppConstants.MUSIC_UPLOAD+uuid)+"."+Files.getSuffixName(file).toLowerCase();
			try{
				file.renameTo(new File(dest));
			}catch(Throwable e){
				e.printStackTrace();
			}
		}
		return jsonList.getRoot();
	}
	
	@At
	public Object musicList(@Param("::page.")Pager page,long albumId){
		JsonList jsonList=new JsonList();
		Album album=dao.fetch(Album.class, albumId);
		User user=dao.fetch(User.class, album.getUserId());
		for(Music music:dao.query(Music.class, Cnd.where("albumId", "=", albumId).desc("id"),page)){
			jsonList.add(new JsonItem().add("title", music.getName())
					.add("artist",user.getName())
					.add("album",album.getName())
					.add("cover", "http://x.libdd.com/farm1/79cec1/7103dc78/01.jpg")
					.add("mp3", "../upload/music/"+music.getPath()));
		}
		jsonList.setTotalProperty(dao.count(Music.class, Cnd.where("albumId", "=", albumId).desc("id")));
		return jsonList;
	}
	
	@At
	public Response deleteFile(long id,String fileName){
		dao.delete(Music.class, id);
		File file=FileUtil.getFile(this.getRealPath(AppConstants.MUSIC_UPLOAD)+"\\"+fileName);
		if(file.exists()){
			file.delete();
		}
		return success();
	}
	
	@Override
	public Class<Music> getEntityClass() {
		return Music.class;
	}

}
