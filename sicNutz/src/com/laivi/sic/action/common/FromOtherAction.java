package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.po.basic.IUserEntity;
import com.laivi.sic.model.po.common.FromOther;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/common/fromOther")
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
				if(flag==0){
					other.setFavoriteIs(true);
				}else if(flag==1){
					other.setShareIs(true);
				}else if(flag==2){
					other.setFromOtherIs(true);
				}
				dao.update(other);
			}else{
				fromOther.setUserId(this.getUserId());
				if(flag==0){
					fromOther.setFavoriteIs(true);
				}else if(flag==1){
					fromOther.setShareIs(true);
				}else if(flag==2){
					fromOther.setFromOtherIs(true);
				}
				dao.insert(fromOther);
			}
			return success();
		}
	}
	
	@At
	public Object getFromOther(){
		return null;
	}

	@Override
	public Class<FromOther> getEntityClass() {
		
		return FromOther.class;
	}

}
