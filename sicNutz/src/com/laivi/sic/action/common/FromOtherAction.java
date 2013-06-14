package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.basic.IUserEntity;
import com.laivi.sic.model.po.common.FromOther;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.CategoryType;

@IocBean
@At("/common/fromother")
public class FromOtherAction extends ABasicDBAction<FromOther> {
	
	@At
	@CheckLogin
	public Response add(@Param("::fromOther.")FromOther fromOther,int flag){
		IUserEntity entity=(IUserEntity)dao.fetch(fromOther.getType().toclass(),fromOther.getObjId());
		if(entity.getUserId()==this.getUserId()){
			return failure("此对象已属于该用户");
		}else{
			FromOther other=dao.fetch(FromOther.class, Cnd.where("userId", "=", this.getUserId()).and("type","=",fromOther.getType()).and("objId", "=", fromOther.getObjId()));
			if(other!=null){
				setFromOther(other,flag);
				if(!other.isFavoriteIs()&&!other.isShareIs()&&!other.isFromOtherIs()&&!other.isSelfIs()){
					dao.delete(other);
				}else{
					dao.update(other);
				}
			}else{
				fromOther.setUserId(this.getUserId());
				setFromOther(fromOther,flag);
				dao.insert(fromOther);
			}
			return success();
		}
	}
	
	private void setFromOther(FromOther other,int flag){
		if(flag==0){
			other.setFavoriteIs(!other.isFavoriteIs());
		}else if(flag==1){
			other.setShareIs(!other.isShareIs());
		}else if(flag==2){
			other.setFromOtherIs(!other.isFromOtherIs());
		}
	}
	
	@At
	public Object getFromOther(@Param("::fromOther.")FromOther fromOther){
		JsonItem item=new JsonItem();
		if(this.isLogined()){
			FromOther tempOther=dao.fetch(FromOther.class, Cnd.where("objId", "=", fromOther.getObjId()).and("type", "=", fromOther.getType()).and("userId","=",this.getUserId()));
			if(tempOther==null){
				item.add("isFavorited", false).add("isShare", false).add("isFromOther", false);
			}else{
				item.add("isFavorited", tempOther.isFavoriteIs()).add("isShare", tempOther.isShareIs()).add("isFromOther", tempOther.isFromOtherIs());
			}
		}else{
			item.add("isFavorited", false).add("isShare", false).add("isFromOther", false);
		}
		item.add("favoriteCount", dao.count(FromOther.class, Cnd.where("objId", "=", fromOther.getObjId()).and("type", "=", fromOther.getType()).and("favoriteIs", "=",true)));
		item.add("shareCount", dao.count(FromOther.class, Cnd.where("objId", "=", fromOther.getObjId()).and("type", "=", fromOther.getType()).and("shareIs", "=",true)));
		item.add("fromOtherCount", dao.count(FromOther.class, Cnd.where("objId", "=", fromOther.getObjId()).and("type", "=", fromOther.getType()).and("fromOtherIs", "=",true)));
		return item.toJsonForm();
	}
	
	@At
	public Object listByCategory(@Param("::page.")Pager page,boolean fold,CategoryType type)throws Exception {
		Cnd condition=Cnd.where(this.getBasicCnd()).and("type", "=",type);
		if(this.isSys()){
			this.cnd= condition.and("selfIs", "=", true).desc("createDate");
		}else{
			this.cnd= condition.desc("createDate");
		}
		return listByCategory(page,cnd,type,fold);
	}

	protected JsonList listByCategory(Pager page, Condition cnd,CategoryType type,boolean fold)throws Exception {
		JsonList jsonList=new JsonList();
		for(FromOther obj:basicService.list(FromOther.class,cnd,page)){
			JsonItem item=this.getJsonItem(obj,true);
			item.add(type.toclass().getSimpleName().toLowerCase(), this.getJsonItem(type.toclass(),basicService.get(type.toclass(), obj.getObjId()), true));
			jsonList.add(item);
		}
		jsonList.setTotalProperty(dao.count(this.getEntityClass(), cnd));
		return jsonList;
	}

	@Override
	public Class<FromOther> getEntityClass() {
		return FromOther.class;
	}
}
