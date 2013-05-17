package com.laivi.sic.action.user;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.exception.ErrorException;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.common.Message;
import com.laivi.sic.model.po.user.Friend;
import com.laivi.sic.model.po.user.User;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.FriendsDirection;
import com.laivi.sic.model.type.Status;
import com.laivi.sic.service.common.MessageService;
import com.laivi.sic.util.basic.ParamAssert;

@IocBean
@At("/user/friend")
public class FriendAction extends ABasicDBAction<Friend> {
	
	@Inject
	private MessageService messageService;

	@At
	@CheckLogin
	public Response add(@Param("::friend.")Friend friend) throws ErrorException{
		long userId=this.getUserId();
		ParamAssert.isTrue(friend.getFriendId()!=this.getUserId(),"不能添加自己为朋友");
		SqlExpressionGroup e1=Cnd.exps("userId", "=",userId).and("friendId", "=", friend.getFriendId());
		SqlExpressionGroup e2=Cnd.exps("userId", "=",friend.getFriendId()).and("friendId", "=", userId);
		ParamAssert.isTrue(dao.count(Friend.class, Cnd.where(e1).or(e2))==0,"该朋友已经存在");
		friend.setUserId(userId);
		friend.setDirection(FriendsDirection.INIT);
		dao.insert(friend);
		messageService.sendAddFriendMessage(userId, friend.getFriendId());
		return success();
	}
	
	@At
	public Response delete(long id){
		Friend friend=dao.fetch(Friend.class, id);
		if(friend.getDirection()==FriendsDirection.DOUBLE){
			if(friend.getUserId()==this.getUserId()){
				friend.setDirection(FriendsDirection.AFTER);
			}else{
				friend.setDirection(FriendsDirection.BEFORE);
			}
			dao.update(friend);
		}else{
			dao.delete(friend);
		}
		return success();
	}
	
	@At
	public Response confirm(@Param("::friend.")Friend friend,long id){
		Message message=dao.fetch(Message.class, id);
		Friend dFriend=dao.fetch(Friend.class, Cnd.where("userId","=",message.getUserId())
				.and("friendId","=",message.getToUserId()).and("direction", "=", FriendsDirection.INIT));
		dFriend.setDirection(friend.getDirection());
		dao.update(dFriend);
		message.setStatus(Status.READED);
		dao.update(message);
		return success();
	}
	
	@At
	public Object listAllFriendsName(){
		JsonList jsonList=new JsonList();
		for(User user:dao.query(User.class, null)){
			jsonList.add("\""+user.getName()+"\"");
		}
		return jsonList;
	}
	
	@At
	public Object listUserFriends(@Param("::page.")Pager page){
		long userId=this.getUserId();
		SqlExpressionGroup e1=Cnd.exps("userId", "=",userId).and("direction", "=", FriendsDirection.BEFORE);
		SqlExpressionGroup e2=Cnd.exps("userId", "=",userId).and("direction", "=", FriendsDirection.DOUBLE);
		SqlExpressionGroup e3=Cnd.exps("friendId", "=",userId).and("direction", "=", FriendsDirection.DOUBLE);
		SqlExpressionGroup e4=Cnd.exps("friendId", "=",userId).and("direction", "=", FriendsDirection.AFTER);
		SqlExpressionGroup e5=Cnd.exps(e1).or(e2);
		SqlExpressionGroup e6=Cnd.exps(e3).or(e4);
		return list(page,Cnd.where(e5).or(e6));
	}
	
	@Override
	public Class<Friend> getEntityClass() {
		return Friend.class;
	}

}
