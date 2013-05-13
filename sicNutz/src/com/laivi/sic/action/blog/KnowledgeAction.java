package com.laivi.sic.action.blog;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.blog.Knowledge;
import com.laivi.sic.model.to.Response;

@At("/blog/knowledge")
@IocBean
public class KnowledgeAction extends ABasicDBAction<Knowledge> {
	
	@At
	@CheckValue
	public Response add(@Param("::knowledge.")Knowledge knowledge){
		knowledge.setUserId(this.getUserId());
		dao.insert(knowledge);
		return success();
	}
	
	@At
	@CheckValue
	public Response update(@Param("::knowledge.")Knowledge knowledge){
		Knowledge dKnowledge=dao.fetch(Knowledge.class, knowledge.getId());
		dKnowledge.setQuestion(knowledge.getQuestion());
		dKnowledge.setAnswer(knowledge.getAnswer());
		dKnowledge.setTagId(knowledge.getTagId());
		dKnowledge.setTitle(knowledge.getTitle());
		dao.update(dKnowledge);
		return success();
	}
	
	@At
	public Object listAllTitle(){
		JsonList jsonList=new JsonList();
		this.cnd=this.getUserCnd();
		for(Knowledge knowledge:dao.query(this.getEntityClass(), cnd)){
			jsonList.add("\""+knowledge.getTitle()+"\"");
		}
		return jsonList;
	}

	@Override
	public Class<Knowledge> getEntityClass() {
		return Knowledge.class;
	}

}
