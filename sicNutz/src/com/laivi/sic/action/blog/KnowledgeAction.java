package com.laivi.sic.action.blog;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.blog.Knowledge;
import com.laivi.sic.model.po.common.FromOther;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.CategoryType;

@At("/blog/knowledge")
@IocBean
public class KnowledgeAction extends ABasicDBAction<Knowledge> {
	
	@At
	@CheckValue
	public Response add(@Param("::knowledge.")final Knowledge knowledge){
		knowledge.setUserId(this.getUserId());
		Trans.exec(new Atom(){
			@Override
			public void run() {
				FromOther fromOther=new FromOther();
				dao.insert(knowledge);
				fromOther.setObjId(knowledge.getId());
				fromOther.setUserId(knowledge.getUserId());
				fromOther.setType(CategoryType.KNOWLEDGE);
				fromOther.setSelfIs(true);
				dao.insert(fromOther);
			}
			
		});
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
	public Response delete(long id){
		dao.delete(FromOther.class, id);
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
	@At
	public Object getAll(@Param("::page.")Pager page){
		return list(page,Cnd.where("deleteIs","=", false).and("type", "=",CategoryType.KNOWLEDGE).and("selfIs", "=", true).desc("createDate"));
	}
	
	@Override
	@At
	public Object list(Pager page,boolean fold) {
		if(this.isSys()){
			this.cnd= Cnd.where("deleteIs","=", false).and("type", "=",CategoryType.KNOWLEDGE).and("selfIs", "=", true);
		}else{
			this.cnd= Cnd.where("deleteIs","=", false).and("userId","=",this.getUserId()).and("type", "=",CategoryType.KNOWLEDGE);
		}
		return list(page,this.cnd);
	}
	
	@Override
	protected JsonList list(Pager page, Condition cnd) {
		JsonList jsonList=new JsonList();
		for(FromOther obj:dao.query(FromOther.class, cnd, page)){
			JsonItem item=this.getJsonItem(FromOther.class,obj,true);
			item.add("knowledge", this.getJsonItem(dao.fetch(Knowledge.class, obj.getObjId()), true));
			jsonList.add(item);
		}
		jsonList.setTotalProperty(dao.count(FromOther.class, cnd));
		return jsonList;
	}

	@Override
	public Class<Knowledge> getEntityClass() {
		return Knowledge.class;
	}

}
