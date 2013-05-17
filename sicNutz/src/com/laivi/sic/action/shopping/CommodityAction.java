package com.laivi.sic.action.shopping;

import java.io.File;
import java.util.UUID;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.json.JsonItemList;
import com.laivi.sic.model.po.shopping.Commodity;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/shopping/commodity")
public class CommodityAction extends ABasicDBAction<Commodity> {
	
	@At
	@CheckLogin
	@CheckValue
	@AdaptBy(type = UploadAdaptor.class,args="ioc:upload")
	public Response add(@Param("::commodity.")Commodity commodity,@Param("picture")TempFile tempFile){
		File file=tempFile.getFile();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String dest=this.getRealPath(AppConstants.PICTURE_UPLOAD+uuid)+"."+Files.getSuffixName(file).toLowerCase();
		try{
			file.renameTo(new File(dest));
		}catch(Throwable e){
			e.printStackTrace();
		}
		commodity.setPicturePath(uuid+"."+Files.getSuffixName(file).toLowerCase());
		dao.insert(commodity);
		return success();
	}
	
	@At
	public Object categoryList(long categoryId){
		JsonItemList jsonList=new JsonItemList();
		return jsonList;
	}

	@Override
	public Class<Commodity> getEntityClass() {
		return Commodity.class;
	}

}
