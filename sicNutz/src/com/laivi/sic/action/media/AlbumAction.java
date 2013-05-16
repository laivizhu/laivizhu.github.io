package com.laivi.sic.action.media;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonItemList;
import com.laivi.sic.model.po.media.Album;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.AlbumType;

@IocBean
@At("/media/album")
public class AlbumAction extends ABasicDBAction<Album> {
	
	@At
	@CheckLogin
	@CheckValue
	public Response add(@Param("::album.")Album album){
		album.setUserId(this.getUserId());
		dao.insert(album);
		return success();
	}
	
	@At
	public Response delete(long id)throws Exception{
		Album album=dao.fetch(Album.class, id);
		dao.clear(album.getType().toKlass(), Cnd.where("albumId", "=", album.getId()));
		dao.delete(album);
		return success();
	}
	
	@At
	@CheckLogin
	@CheckValue
	public Response update(@Param("::album.")Album album){
		Album dAlbum=dao.fetch(Album.class,album.getId());
		dAlbum.setType(album.getType());
		dAlbum.setName(album.getName());
		dAlbum.setDescription(album.getDescription());
		dAlbum.setTagId(album.getTagId());
		dao.update(dAlbum);
		return success();
	}
	
	@At
	public Object typeList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		for(AlbumType type:AlbumType.values()){
			jsonList.createItem().add("id", type.name()).add("name", type.toText());
		}
		return jsonList.toList();
	}
	
	@At
	public Object albumList(@Param("::page")Pager page,@Param("::album.")Album album){
		return this.list(page, Cnd.where("type", "=", album.getType()));
	}

	@Override
	public Class<Album> getEntityClass() {
		return Album.class;
	}

}
