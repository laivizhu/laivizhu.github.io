package com.laivi.sic.action.common;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.po.common.RateScore;
import com.laivi.sic.model.to.Response;

@IocBean
@At("/score")
public class ScoreAction extends ABasicDBAction<RateScore> {
	
	@At
	public Response add(@Param("::score.")RateScore score){
		long userId=this.getUserId();
		if(dao.count(RateScore.class,Cnd.where("objectId", "=", score.getObjectId())
									.and("userId", "=", userId)
									.and("type", "=", score.getType()))>0){
			return failure("已经评价过了");
		}else{
			score.setUserId(userId);
			dao.insert(score);
		}
		return success();
	}
	
	@At
	public Object getScore(@Param("::score.")RateScore score){
		JsonItem item=new JsonItem();
		Cnd scoreCnd=Cnd.where("objectId", "=", score.getObjectId()).and("type", "=", score.getType());
		if(this.isLogined()){
			scoreCnd=scoreCnd.and("userId", "=", this.getUserId());
			RateScore myScore=dao.fetch(RateScore.class, scoreCnd);
			if(myScore!=null){
				item.add("score", myScore.getScore());
				return item.toJsonForm();
			}
		}
		
		long totalScore=0;
		int i=0;
		for(RateScore tempScore:dao.query(RateScore.class, scoreCnd)){
			i++;
			totalScore+=tempScore.getScore();
		}
		if(i==0){
			item.add("score", 0);
		}else{
			item.add("score", totalScore/i);
		}
		
		return item.toJsonForm();
	}

	@Override
	public Class<RateScore> getEntityClass() {
		return RateScore.class;
	}

}
