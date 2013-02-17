package com.laivi.knowledge.user.action;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.Friends;
import com.laivi.knowledge.user.model.po.Message;
import com.laivi.knowledge.user.model.po.User;
import com.laivi.knowledge.user.model.type.FriendsDirection;
import com.laivi.knowledge.user.service.IMessageService;
import com.laivi.knowledge.user.service.IUserService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 11, 2013
 */
@SuppressWarnings("serial")
public class FriendsAction extends ABasicAction<Friends> {

	private Friends friend;
	private IMessageService messageService;
	
	public String add()throws Exception{
		ParamAssert.isTrue(friend.getFriendId()!=0, "error.Friend.notChoise");
		long userId=this.getCurrentUserId();
		ParamAssert.isTrue(userId!=friend.getFriendId(), "error.Friend.notChoiesSelf");
		CriterionList conditions=CriterionList.CreateCriterion().put(
				Restrictions.or(
						Restrictions.and(
								Restrictions.eq("userId", userId),
								Restrictions.eq("friendId", friend.getFriendId())),
						Restrictions.and(
								Restrictions.eq("userId", friend.getFriendId()),
								Restrictions.eq("friendId",userId))));
		if(this.basicService.getCount(conditions)>0){
			throw new ErrorException("该朋友已经存在",true);
		}
		friend.setUserId(userId);
		friend.setDirection(FriendsDirection.INIT);
		this.basicService.add(friend);
		messageService.sendAddFriendMessage(userId, friend.getFriendId());
		return response(true);
	}
	
	public String delete()throws Exception{
		ParamAssert.isTrue(id!=0, "error.object.notChoose");
		Friends friend=this.basicService.getObject(id);
		if(friend.getDirection()==FriendsDirection.DOUBLE){
			if(friend.getUserId()==this.getCurrentUserId()){
				friend.setDirection(FriendsDirection.AFTER);
			}else{
				friend.setDirection(FriendsDirection.BEFORE);
			}
			this.basicService.modify(friend);
		}else{
			this.basicService.remove(friend);
		}
		return response(true);
	}
	
	public String confirm()throws Exception{
		ParamAssert.isTrue(id!=0, "error.object.notChoose");
		Message message=this.messageService.getObject(id);
		CriterionList condition=CriterionList.CreateCriterion()
				.put(Restrictions.eq("userId",message.getUserId()))
				.put(Restrictions.eq("friendId", message.getToUserId()))
				.put(Restrictions.eq("direction",FriendsDirection.INIT));
		Friends dfriend=this.basicService.getObject(condition);
		dfriend.setDirection(friend.getDirection());
		this.basicService.modify(dfriend);
		message.setReadIs(true);
		this.messageService.modify(message);
		return response(true);
	}
	
	public String listAllFriendsName()throws Exception{
		JsonList jsonList=new JsonList();
		for(User user:this.userService.getList()){
			jsonList.add("\""+user.getUserName()+"\"");
		}
		return response(jsonList);
	}
	
	public String listUserFriends()throws Exception{
		long userId=this.getCurrentUserId();
		this.conditions=CriterionList.CreateCriterion().put(
				Restrictions.or(
						Restrictions.or(
								Restrictions.and(
										Restrictions.eq("userId",userId),
										Restrictions.eq("direction", FriendsDirection.BEFORE)),
								Restrictions.and(
										Restrictions.eq("userId",userId),
										Restrictions.eq("direction", FriendsDirection.DOUBLE))),
						Restrictions.or(
								Restrictions.and(
										Restrictions.eq("friendId",userId),
										Restrictions.eq("direction", FriendsDirection.AFTER)),
								Restrictions.and(
										Restrictions.eq("friendId",userId),
										Restrictions.eq("direction", FriendsDirection.DOUBLE)))
				));
		
		return response(list(true,false));
	}
	
	public String listGroupFriends()throws Exception{
		return response(list(true,false));
	}
	
	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	@Override
	public JsonItem getJsonItem(Friends object, boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId());
		User user=this.userService.getObject(object.getUserId());
		User friend=this.userService.getObject(object.getFriendId());
		if(user.getId()==this.getCurrentUserId()){
			item.add("user", user)
			.add("friend", friend);
		}else{
			item.add("friend", user)
			.add("user", friend);
		}
		return item;
	}
	
	@Resource(name="FriendsService")
	public void setBasicService(IBasicService<Friends> basicService){
		this.basicService=basicService;
	}
	
	@Resource(name="UserService")
	public void setUserService(IUserService userService){
		this.userService=userService;
	}

	public Friends getFriend() {
		return friend;
	}

	public void setFriend(Friends friend) {
		this.friend = friend;
	}
	@Resource(name="MessageService")
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	
}
