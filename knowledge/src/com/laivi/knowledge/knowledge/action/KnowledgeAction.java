package com.laivi.knowledge.knowledge.action;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.knowledge.model.po.Knowledge;
import com.laivi.knowledge.knowledge.service.IKnowledgeService;
import com.laivi.knowledge.knowledge.service.ITagService;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午10:58
 */
@SuppressWarnings("serial")
public class KnowledgeAction extends ABasicAction<Knowledge> {
	private IKnowledgeService knowledgeService;
	private ITagService tagService;
	private Knowledge knowledge;
	
	private String knowledgeIds;
	
	public String delete()throws Exception{
		ParamAssert.isNotEmptyString(knowledgeIds, "error.objcet.notChoose");
		this.knowledgeService.remove(knowledgeIds);
		return response(true);
	}
	
	public String update()throws Exception{
		ParamAssert.isNotEmptyString(knowledge.getTitle(), "error.knowledge.title.notNULL");
		ParamAssert.isNotEmptyString(knowledge.getQuestion(), "error.knowledge.question.notNULL");
		ParamAssert.isNotEmptyString(knowledge.getContent(), "error.knowledge.content.notNULL");
		ParamAssert.isNotEmptyString(knowledge.getTagIds(), "error.knowledge.tag.notNULL");
		Knowledge dKnowledge=this.knowledgeService.getObject(id);
		dKnowledge.setContent(knowledge.getContent());
		dKnowledge.setTitle(knowledge.getTitle());
		dKnowledge.setQuestion(knowledge.getQuestion());
		dKnowledge.setTagIds(knowledge.getTagIds());
		this.knowledgeService.modify(dKnowledge);
		return response(true);
	}
	
	public String get()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		Knowledge dKnowledge=this.knowledgeService.getObject(id);
		JsonItem item =new JsonItem();
		item.add("id", dKnowledge.getId())
		.add("knowledge.title", dKnowledge.getTitle())
		.add("knowledge.question", dKnowledge.getQuestion())
		.add("knowledge.content", dKnowledge.getContent())
		.add("knowledge.tagIds",dKnowledge.getTagIds());
		return response(item.toFormDataString(true));
	}
	
	public String list()throws Exception{
		JsonList jsonList=new JsonList();
		CriterionList conditions=CriterionList.CreateCriterion().put(Restrictions.eq("userId", this.getCurrentUserId()));
		for(Knowledge knowledge:this.knowledgeService.getList(conditions,start,limit)){
			jsonList.add(this.getJsonItem(knowledge));
		}
		return response(jsonList.toPageString(this.knowledgeService.getCount(conditions)));
	}

	public JsonItem getJsonItem(Knowledge object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("question",DataUtil.getDefaultChar(object.getQuestion()))
		.add("content", DataUtil.getDefaultChar(object.getContent()))
		.add("tags",this.tagService.getTagsName(object.getTagIds()))
		.add("createDate", DateUtil.formatDate(object.getCreateDate()));
        return item;
    }
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(knowledge.getTitle(), "error.knowledge.title.notNULL");
		ParamAssert.isNotEmptyString(knowledge.getQuestion(), "error.knowledge.question.notNULL");
		ParamAssert.isNotEmptyString(knowledge.getContent(), "error.knowledge.content.notNULL");
		ParamAssert.isNotEmptyString(knowledge.getTagIds(), "error.knowledge.tag.notNULL");
		knowledge.setUserId(this.getCurrentUserId());
		knowledge.setCreateDate(new Date());
		knowledgeService.add(knowledge);
		return response(true);
	}
	
	public JsonList getSearchComboList()throws ErrorException{
		JsonList jsonList=new JsonList();
		jsonList.createItem().add("value", "title").add("text", "标题");
		jsonList.createItem().add("value", "question").add("text", "问题");
		jsonList.createItem().add("value", "content").add("text", "解决方案");
		return jsonList;
	}


	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	@Resource(name="KnowledgeService")
	public void setKnowledgeService(IKnowledgeService knowledgeService) {
		this.knowledgeService = knowledgeService;
	}
	
	@Resource(name = "KnowledgeService")
    public void setBasicService(IBasicService<Knowledge> basicService){
    	this.basicService=basicService;
    }

	@Resource(name = "TagService")
	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	}
	
	public String getKnowledgeIds() {
		return knowledgeIds;
	}

	public void setKnowledgeIds(String knowledgeIds) {
		this.knowledgeIds = knowledgeIds;
	}

}
