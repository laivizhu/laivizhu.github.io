package com.laivi.sic.action.media;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.po.media.Picture;

@IocBean
@At("/media/picture")
public class PictureAction extends ABasicDBAction<Picture> {

	@Override
	public Class<Picture> getEntityClass() {
		return Picture.class;
	}

}
