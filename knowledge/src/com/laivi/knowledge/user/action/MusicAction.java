package com.laivi.knowledge.user.action;

import java.io.File;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.FileUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.constant.SystemConstants;
import com.laivi.knowledge.user.model.po.Album;
import com.laivi.knowledge.user.model.po.Music;
import com.laivi.knowledge.user.service.IAlbumService;
import com.laivi.knowledge.user.service.IMusicService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 29, 2013
 */
@SuppressWarnings("serial")
public class MusicAction extends ABasicAction<Music> {
	private IMusicService musicService;
	private IAlbumService albumService;
	private Music music;
	private File[] musics;
	private String[] musicsFileName;
	private long albumId;

	public MusicAction() {
		this.downLoadPath=SystemConstants.MUSIC_DOWNLOAD;
	}
	
	public String upload()throws Exception{
		if(musics!=null){
			return response(musicService.upload(musics, musicsFileName,this.getRealPath(SystemConstants.MUSIC_UPLOADPATH),albumId).toString());
		}else{
			return response(false);
		}
	}
	
	public String delete()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		basicService.remove(id);
		File file=FileUtil.getFile(this.getRealPath(SystemConstants.MUSIC_UPLOADPATH)+"\\"+fileName);
		if(file.exists()){
			file.delete();
		}
		return response(true);
	}
	
	public String musicList()throws Exception{
		ParamAssert.isTrue(albumId != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		Album album=this.albumService.getObject(albumId);
		JsonItemList jsonList=new JsonItemList();
		CriterionList conditions=CriterionList.CreateCriterion();
		if(DataUtil.notEmptyString(album.getItemIds())){
			conditions.put(Restrictions.in("id", DataUtil.changeIdString(album.getItemIds())));
			for(Music music:this.basicService.getList(conditions,start,limit)){
				jsonList.createItem().add("title", music.getName()).add("mp3", "../music/"+music.getPath());
			}
		}
		return response(jsonList.toPageString(this.basicService.getCount(conditions)));
	}

	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		JsonItemList jsonList=new JsonItemList();
		return jsonList;
	}

	@Override
	public JsonItem getJsonItem(Music object, boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("name", object.getName())
		.add("path",object.getPath())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()));
		return item;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public File[] getMusics() {
		return musics;
	}

	public void setMusics(File[] musics) {
		this.musics = musics;
	}

	public String[] getMusicsFileName() {
		return musicsFileName;
	}

	public void setMusicsFileName(String[] musicsFileName) {
		this.musicsFileName = musicsFileName;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}
	@Resource(name="MusicService")
	public void setMusicService(IMusicService musicService) {
		this.musicService = musicService;
	}
	@Resource(name="AlbumService")
	public void setAlbumService(IAlbumService albumService) {
		this.albumService = albumService;
	}
	
	@Resource(name="MusicService")
	public void setBasicService(IBasicService<Music> basicService){
		this.basicService=basicService;
	}
}
