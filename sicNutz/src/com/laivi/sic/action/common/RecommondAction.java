package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.constants.AppConstants;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.po.common.Recommond;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/common/recomm")
public class RecommondAction extends ABasicDBAction<Recommond> {
	
	@At
	@CheckLogin
	public Response add(@Param("::recomm.")Recommond recomm) throws Exception{
		if(basicService.getCount(Recommond.class, Cnd.where("objId", "=", recomm.getObjId()).and("type", "=", recomm.getType()))>0){
			basicService.delete(Recommond.class, Cnd.where("objId", "=", recomm.getObjId()).and("type", "=", recomm.getType()));
		}else{
			if(basicService.getCount(Recommond.class, Cnd.where("type", "=", recomm.getType()))>=AppConstants.Blog.pageSize){
				basicService.delete(Recommond.class, Cnd.orderBy().asc("id"));
			}
			basicService.add(recomm);
		}
		return success();
	}
	
	@At
	public Object getRecomm(@Param("::recomm.")Recommond recomm)throws Exception{
		JsonItem item=new JsonItem();
		if(basicService.getCount(Recommond.class, Cnd.where("objId", "=", recomm.getObjId()).and("type", "=", recomm.getType()))>0){
			item.add("isRecommon", true);
		}else{
			item.add("isRecommon", false);
		}
		return item.toJsonForm();
	}

	@Override
	public Class<Recommond> getEntityClass() {
		return Recommond.class;
	}

}
