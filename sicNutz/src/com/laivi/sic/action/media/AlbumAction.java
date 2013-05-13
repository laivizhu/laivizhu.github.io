package com.laivi.sic.action.media;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.po.media.Album;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/media/album")
public class AlbumAction extends ABasicDBAction<Album> {
	
	public Response add(@Param("::album.")Album album){
		album.setUserId(this.getUserId());
		dao.insert(album);
		return success();
	}

	@Override
	public Class<Album> getEntityClass() {
		return Album.class;
	}

}
