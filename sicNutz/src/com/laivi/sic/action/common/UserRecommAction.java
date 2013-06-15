package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.po.common.UserRecomm;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.util.basic.DataUtil;

@IocBean
@At("/common/userRecomm")
public class UserRecommAction extends ABasicDBAction<UserRecomm> {

	@At
	public Response add(@Param("::userRecomm.")UserRecomm recomm){
		UserRecomm dRecomm=dao.fetch(UserRecomm.class, Cnd.where("userId", "=", this.getUserId()).and("type", "=", recomm.getType()));
		if(dRecomm!=null){
			if(!DataUtil.isIncludeId(Long.parseLong(recomm.getObjIds()), dRecomm.getObjIds())){
				dRecomm.setObjIds(dRecomm.getObjIds()+","+recomm.getObjIds());
				dao.update(dRecomm);
			}
		}else{
			recomm.setUserId(getUserId());
			dao.insert(recomm);
		}
		return success();
	}
	
	@Override
	public Class<UserRecomm> getEntityClass() {
		return UserRecomm.class;
	}

}
