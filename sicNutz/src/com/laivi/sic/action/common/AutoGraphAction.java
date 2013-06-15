package com.laivi.sic.action.common;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.common.AutoGraph;
import com.laivi.sic.model.po.user.Friend;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.FriendsDirection;
import com.laivi.sic.service.common.AutoGraphService;

@IocBean
@At("/common/autograph")
public class AutoGraphAction extends ABasicDBAction<AutoGraph> {
	
	@Inject
	private AutoGraphService autoGraphService;
	
	@At
	@CheckLogin
	@CheckValue
	public Response add(@Param("::autoGraph.")AutoGraph autoGraph){
		autoGraph.setUserId(getUserId());
		autoGraphService.add(autoGraph);
		return success();
	}
	
	@At
	public Response delete(long id){
		AutoGraph autoGraph=dao.fetch(AutoGraph.class, id);
		if(autoGraph.getParentId()!=0){
			if(dao.count(AutoGraph.class, Cnd.where("parentId", "=", autoGraph.getParentId()))==0){
				AutoGraph parentAutoGraph=dao.fetch(AutoGraph.class, autoGraph.getParentId());
				parentAutoGraph.setParentIs(false);
				dao.update(parentAutoGraph);
			}
		}
		if(dao.count(AutoGraph.class, Cnd.where("parentId", "=", id))>0){
			return failure("该记录存在子回复，请先删除子回复");
		}
		dao.delete(autoGraph);
		return success();
	}
	
	@SuppressWarnings("unused")
	private void delete(AutoGraph autoGraph){
		if(autoGraph.isParentIs()){
			for(AutoGraph subAutoGraph:dao.query(AutoGraph.class,Cnd.where("parentId", "=", autoGraph.getId()))){
				delete(subAutoGraph);
			}
		}else{
			dao.delete(autoGraph);
		}
	}
	
	@At
	public Object listFriendAutoGraph(@Param("::page")Pager page) throws Exception{
		long userId=this.getUserId();
		long[] friendIds=null;
		SqlExpressionGroup e1=Cnd.exps("userId", "=",userId).and("direction", "=", FriendsDirection.BEFORE);
		SqlExpressionGroup e2=Cnd.exps("userId", "=",userId).and("direction", "=", FriendsDirection.DOUBLE);
		SqlExpressionGroup e3=Cnd.exps("friendId", "=",userId).and("direction", "=", FriendsDirection.DOUBLE);
		SqlExpressionGroup e4=Cnd.exps("friendId", "=",userId).and("direction", "=", FriendsDirection.AFTER);
		SqlExpressionGroup e5=Cnd.exps(e1).or(e2);
		SqlExpressionGroup e6=Cnd.exps(e3).or(e4);
		this.cnd=Cnd.where(e5).or(e6);
		List<Friend> friendList=dao.query(Friend.class, this.cnd);
		if(friendList.size()>0){
			friendIds=new long[friendList.size()];
			for(int i=0;i<friendIds.length;i++){
				if(userId!=friendList.get(i).getUserId()){
					friendIds[i]=friendList.get(i).getUserId();
				}else{
					friendIds[i]=friendList.get(i).getFriendId();
				}
			}
			return list(page,Cnd.where(Cnd.exps("deleteIs","=",false).andIn("userId", friendIds)).desc("createDate"),true);
		}else{
			return new JsonList();
		}
	}

	@Override
	public Class<AutoGraph> getEntityClass() {
		return AutoGraph.class;
	}

}
