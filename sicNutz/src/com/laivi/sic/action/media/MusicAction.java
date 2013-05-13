package com.laivi.sic.action.media;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.po.media.Music;

@IocBean
@At("/media/music")
public class MusicAction extends ABasicDBAction<Music> {

	@Override
	public Class<Music> getEntityClass() {
		return Music.class;
	}

}
