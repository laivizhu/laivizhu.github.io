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
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonItemList;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.media.Music;

@IocBean
@At("/media/music")
public class MusicAction extends ABasicDBAction<Music> {

	@At
	@AdaptBy(type = UploadAdaptor.class,args="ioc:upload")
	public Object upload(@Param("musics")TempFile[] tempFiles,long albumId){
		JsonItemList jsonList=new JsonItemList();
		for(TempFile tempFile:tempFiles){
			File file=tempFile.getFile();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			Music music=new Music(tempFile.getMeta().getFileLocalName(),uuid+"."+Files.getSuffixName(file).toLowerCase(),albumId);
			dao.insert(music);
			jsonList.createItem().add("id",music.getId()).add("name", music.getName())
								 .add("size", file.length()).add("delete_type","GET")
								 .add("url","").add("delete_url","");
			String dest=this.getRealPath("/upload/music/"+uuid)+"."+Files.getSuffixName(file).toLowerCase();
			//String smallPath = this.getRealPath("/upload/music/"+uuid) + "_128x128." + Files.getSuffixName(file).toLowerCase();
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
	public Object musicList(@Param("::page.")Pager page,long albumId){
		JsonList jsonList=new JsonList();
		for(Music music:dao.query(Music.class, Cnd.where("albumId", "=", albumId).desc("id"),page)){
			jsonList.add(new JsonItem().add("title", music.getName()).add("mp3", "../upload/music/"+music.getPath()));
		}
		jsonList.setTotalProperty(dao.count(Music.class, Cnd.where("albumId", "=", albumId).desc("id")));
		return jsonList;
	}
	@Override
	public Class<Music> getEntityClass() {
		return Music.class;
	}

}
