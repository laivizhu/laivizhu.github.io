package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.common.Recommond;
import com.laivi.sic.model.po.common.SimpleDegree;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.CategoryType;
import com.laivi.sic.util.basic.DataUtil;

@IocBean
@At("/common/recomm")
public class RecommondAction extends ABasicDBAction<Recommond> {
	
	@At
	@CheckLogin
	public Response add(@Param("::recomm.")Recommond recomm) throws Exception{
		if(basicService.getCount(Recommond.class, Cnd.where("objId", "=", recomm.getObjId()).and("type", "=", recomm.getType()))>0){
			basicService.delete(Recommond.class, Cnd.where("objId", "=", recomm.getObjId()).and("type", "=", recomm.getType()));
		}else{
			/*if(basicService.getCount(Recommond.class, Cnd.where("type", "=", recomm.getType()))>=AppConstants.Blog.pageSize){
				basicService.delete(Recommond.class, Cnd.orderBy().asc("id"));
			}*/
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
	
	@At
	public Object getProposal(long id,CategoryType type) throws Exception{
		JsonList jsonList=new JsonList();
		SimpleDegree simple=basicService.get(SimpleDegree.class, Cnd.where("objId", "=", id).and("type", "=", type));
		if(simple!=null){
			for(long aId:DataUtil.changeIdString(simple.getSimpleIds())){
				if(aId!=0){
					jsonList.add(this.getJsonItem(type.toclass(),basicService.get(type.toclass(), aId), true));
				}
			}
		}
		jsonList.setSize();
		return jsonList;
	}

	@Override
	public Class<Recommond> getEntityClass() {
		return Recommond.class;
	}

}
