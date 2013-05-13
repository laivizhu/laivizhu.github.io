package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.po.common.Favorite;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/common/favorite")
public class FavoriteAction extends ABasicDBAction<Favorite> {
	
	@At
	@CheckLogin
	@CheckValue
	public Response add(@Param("::favorite.")Favorite favorite){
		if(dao.count(Favorite.class, Cnd.where("url", "=", favorite.getUrl()).and("userId", "=", getUserId()))>0){
			return failure("已经收藏过");
		}
		favorite.setUserId(getUserId());
		favorite.setTitle(this.encodeString(favorite.getTitle()));
		dao.insert(favorite);
		return success();
	}
	
	@At
	public Object getFavoriteCount(String url){
		JsonItem item=new JsonItem();
		if(this.isLogined()){
			item.add("isFavorited",dao.count(Favorite.class, Cnd.where("url", "=", url).and("userId","=",this.getUserId()))>0);
		}else{
			item.add("isFavorited", false);
		}
		item.add("count", dao.count(Favorite.class, Cnd.where("url", "=", url)));
		return item.toJsonForm();
	}

	@Override
	public Class<Favorite> getEntityClass() {
		return Favorite.class;
	}

}
