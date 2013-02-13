package com.laivi.knowledge.user.action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.AutoGraph;
import com.laivi.knowledge.user.model.po.Friends;
import com.laivi.knowledge.user.model.type.FriendsDirection;
import com.laivi.knowledge.user.service.IFriendsService;
import com.laivi.knowledge.user.service.IUserService;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 11, 2013
 */
@SuppressWarnings("serial")
public class AutoGraphAction extends ABasicAction<AutoGraph> {

	private AutoGraph autoGraph;
	private IFriendsService friendService;
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(autoGraph.getContent(), "");
		autoGraph.setUserId(this.getCurrentUserId());
		if(autoGraph.getParentId()!=0){
			AutoGraph parentAutoGraph=this.basicService.getObject(autoGraph.getParentId());
			parentAutoGraph.setParentIs(true);
			this.basicService.modify(parentAutoGraph);
		}
		this.basicService.add(autoGraph);
		return response(true);
	}
	
	public String listFriendAutoGraph()throws Exception{
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
		List<Friends> friendList=this.friendService.getList(conditions);
		Long[] friendIds=new Long[friendList.size()];
		for(int i=0;i<friendIds.length;i++){
			if(userId!=friendList.get(i).getUserId()){
				friendIds[i]=friendList.get(i).getUserId();
			}else{
				friendIds[i]=friendList.get(i).getFriendId();
			}
		}
		conditions.clear();
		conditions.put(Restrictions.in("userId", friendIds));
		return response(list(true,false));
	}
	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}
	
	@Override
	public JsonItem getJsonItem(AutoGraph object, boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("content", object.getContent())
		.add("user", this.userService.getObject(object.getUserId()))
		.add("createDate", DateUtil.formatDate(object.getCreateDate()));
		return item;
	}

	public AutoGraph getAutoGraph() {
		return autoGraph;
	}

	public void setAutoGraph(AutoGraph autoGraph) {
		this.autoGraph = autoGraph;
	}
	
	@Resource(name="AutoGraphService")
	public void setBasicService(IBasicService<AutoGraph> basicService){
		this.basicService=basicService;
	}
	
	@Resource(name="UserService")
	public void setUserService(IUserService userService){
		this.userService=userService;
	}

	@Resource(name="FriendsService")
	public void setFriendService(IFriendsService friendService) {
		this.friendService = friendService;
	}
}
