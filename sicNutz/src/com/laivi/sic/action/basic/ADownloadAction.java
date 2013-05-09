package com.laivi.sic.action.basic;

import java.io.File;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import com.laivi.sic.model.po.basic.IBasicDBEntity;
import com.laivi.sic.util.basic.FileUtil;

public abstract class ADownloadAction<T extends IBasicDBEntity> extends ABasicDBAction<T> {
	protected String downLoadPath="picture";
	
	@At
	@Ok("raw")
	public File download(String fileName){
		return FileUtil.getFile(this.getRealPath(downLoadPath+"\\"+fileName));
	}

}
