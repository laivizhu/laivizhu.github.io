package com.laivi.knowledge.knowledge.action;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.annotation.HistoryRecordTag;
import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.common.model.type.FavoriteType;
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
	
	public String update()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
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
	
	@HistoryRecordTag(type=FavoriteType.KNOWLEDGE)
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

	public JsonItem getJsonItem(Knowledge object,boolean isSub) throws Exception {
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
		knowledgeService.add(knowledge);
		return response(true);
	}
	
	public String getIndexList()throws Exception{
		JsonItemList jsonList=new JsonItemList();
		CriterionList conditions=CriterionList.CreateCriterion().put(Order.desc("createDate"));
		for(Knowledge knowledge:this.knowledgeService.getList(conditions, 0, AppConstants.INDEXSIZE)){
			jsonList.createItem().add("url", AppConstants.URL+"knowledge/knowledge_view.jsp?id="+knowledge.getId())
			.add("title", knowledge.getTitle()).add("createDate", DateUtil.formatDate(knowledge.getCreateDate()));
		}
		return response(jsonList);
	}
	
	public JsonItemList getSearchComboList()throws ErrorException{
		JsonItemList jsonList=new JsonItemList();
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
}
