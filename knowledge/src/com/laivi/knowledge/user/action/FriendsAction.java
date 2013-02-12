package com.laivi.knowledge.user.action;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.Friends;
import com.laivi.knowledge.user.model.po.User;
import com.laivi.knowledge.user.model.type.FriendsDirection;
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
	private int friendDirection;
	
	public String add()throws Exception{
		ParamAssert.isTrue(friend.getFriendId()!=0, "error.Friend.notChoise");
		long userId=this.getCurrentUserId();
		ParamAssert.isTrue(userId!=friend.getFriendId(), "error.Friend.notChoiesSelf");
		CriterionList conditions=CriterionList.CreateCriterion()
				.put(Restrictions.eq("userId", userId))
				.put(Restrictions.eq("friendId", friend.getFriendId()));
		if(this.basicService.getCount(conditions)>0){
			throw new ErrorException("该朋友已经存在",true);
		}
		friend.setUserId(userId);
		friend.setDirection(FriendsDirection.INIT.toValue());
		this.basicService.add(friend);
		return response(true);
	}
	
	public String delete()throws Exception{
		ParamAssert.isTrue(id!=0, "error.object.notChoose");
		Friends friend=this.basicService.getObject(id);
		if(friend.getDirection()==FriendsDirection.DOUBLE.toValue()){
			if(friend.getUserId()==this.getCurrentUserId()){
				friend.setDirection(FriendsDirection.AFTER.toValue());
			}else{
				friend.setDirection(FriendsDirection.BEFORE.toValue());
			}
			this.basicService.modify(friend);
		}else{
			this.basicService.remove(friend);
		}
		return response(true);
	}
	
	public String confirm()throws Exception{
		ParamAssert.isTrue(id!=0, "error.object.notChoose");
		Friends friend=this.basicService.getObject(id);
		friend.setDirection(friendDirection);
		this.basicService.modify(friend);
		return response(true);
	}
	
	public String listUserFriends()throws Exception{
		long userId=this.getCurrentUserId();
		this.conditions=CriterionList.CreateCriterion().put(
				Restrictions.or(
						Restrictions.or(
								Restrictions.and(
										Restrictions.eq("userId",userId),
										Restrictions.eq("direction", FriendsDirection.BEFORE.toValue())),
								Restrictions.and(
										Restrictions.eq("userId",userId),
										Restrictions.eq("direction", FriendsDirection.DOUBLE.toValue()))),
						Restrictions.or(
								Restrictions.and(
										Restrictions.eq("friendId",userId),
										Restrictions.eq("direction", FriendsDirection.AFTER.toValue())),
								Restrictions.and(
										Restrictions.eq("friendId",userId),
										Restrictions.eq("direction", FriendsDirection.DOUBLE.toValue())))
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
			item.add("user", user.getUserName())
			.add("friend", friend.getUserName());
		}else{
			item.add("friend", user.getUserName())
			.add("user", friend.getUserName());
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

	public int getFriendDirection() {
		return friendDirection;
	}

	public void setFriendDirection(int friendDirection) {
		this.friendDirection = friendDirection;
	}
}
