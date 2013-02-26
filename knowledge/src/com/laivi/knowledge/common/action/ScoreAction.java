package com.laivi.knowledge.common.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ALBasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.LBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.common.model.po.RateScore;
import com.laivi.knowledge.user.model.po.User;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 19, 2013
 */
@SuppressWarnings("serial")
public class ScoreAction extends ALBasicAction<RateScore>{

	private RateScore score;
	
	public String add()throws Exception{
		long userId=this.getCurrentUserId();
		this.conditions=CriterionList.CreateCriterion()
				.put(Restrictions.eq("objectId", score.getObjectId()))
				.put(Restrictions.eq("userId", userId)).put(Restrictions.eq("type", score.getType()));
		ParamAssert.isTrue(this.basicService.getCount(this.getObjectClass(), conditions)==0, "已经评价过了",true);
		score.setUserId(userId);
		this.basicService.add(score);
		return response(true);
	}
	
	public String get()throws Exception{
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		boolean notLogin=false;
		this.conditions=CriterionList.CreateCriterion()
				.put(Restrictions.eq("objectId", score.getObjectId()))
				.put(Restrictions.eq("type", score.getType()));
		if(user!=null){
			this.conditions.put(Restrictions.eq("userId",user.getId()));
		}else{
			notLogin=true;
		}
				
		JsonItem item=new JsonItem();
		if(!notLogin && this.basicService.getCount(this.getObjectClass(), conditions)>0){
			RateScore statScore=this.basicService.getObject(this.getObjectClass(), conditions);
			item.add("score", statScore.getScore());
		}else{
			if(!notLogin){
				this.conditions.remove(2);
			}
			long totalScore=0;
			int i=0;
			for(RateScore statScore:this.basicService.getList(this.getObjectClass(), conditions)){
				i++;
				totalScore+=statScore.getScore();
			}
			
			if(i==0){
				item.add("score", 0);
			}else{
				item.add("score", totalScore/i);
			}
		}
		return response(item.toFormDataString(true));
	}
	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	@Override
	public JsonItem getJsonItem(RateScore object, boolean isSub) throws Exception {
		return null;
	}

	@Override
	public Class<RateScore> getObjectClass() throws Exception {
		return RateScore.class;
	}
	
	@Resource(name="LBasicService")
	public void setBasicService(LBasicService<RateScore> basicService){
		this.basicService=basicService;
	}

	public RateScore getScore() {
		return score;
	}

	public void setScore(RateScore score) {
		this.score = score;
	}

}
