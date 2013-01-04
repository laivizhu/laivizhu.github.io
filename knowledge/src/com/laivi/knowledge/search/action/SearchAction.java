/**
 * 
 */
package com.laivi.knowledge.search.action;

import javax.annotation.Resource;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.knowledge.model.po.Knowledge;
import com.laivi.knowledge.knowledge.service.IKnowledgeService;
import com.laivi.knowledge.knowledge.service.ITagService;
import com.laivi.knowledge.search.model.po.SearchItem;
import com.laivi.knowledge.search.service.ISearchItemService;

/**
 * @author Janlu
 *
 */
@SuppressWarnings("serial")
public class SearchAction extends ABasicAction<SearchItem> {
	private IKnowledgeService knowledgeService;
	private ITagService tagService;
	private ISearchItemService searchItemService;
	
	
	public String showResult()throws Exception{
		JsonList jsonList=new JsonList();
		CriterionList conditions=CriterionList.CreateCriterion()
				.put(Restrictions.eq("userId", this.getCurrentUserId()))
				.put(Restrictions.or(Restrictions.like("title", value,MatchMode.ANYWHERE), Restrictions.like("question", value,MatchMode.ANYWHERE)));
		for(Knowledge knowledge:this.knowledgeService.getList(conditions,start,limit)){
			jsonList.add(this.getKnowledgeJsonItem(knowledge));
		}
		long count=this.knowledgeService.getCount(conditions);
		if(count>0 && start==0){
			searchItemService.configSearchItem(value);
		}
		return response(jsonList.toPageString(count));
	}
	
	public String topKeywordList()throws Exception{
		JsonList jsonList=new JsonList();
		CriterionList conditions=CriterionList.CreateCriterion().put(Order.desc("count"));
		for(SearchItem item:this.basicService.getList(conditions,0,20)){
			jsonList.add(this.getJsonItem(item));
		}
		return response(jsonList);
	}
	
	@Override
	public JsonItem getJsonItem(SearchItem object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("keyword", object.getKeyword())
		.add("count",object.getCount())
		.add("url", "search_result.jsp?keyword="+object.getKeyword());
		return item;
	}
	
	public JsonItem getKnowledgeJsonItem(Knowledge object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("question",object.getQuestion())
		.add("content", object.getContent())
		.add("tags",this.tagService.getTagsName(object.getTagIds()));
        return item;
	}
	
	@Resource(name="KnowledgeService")
	public void setKnowledgeService(IKnowledgeService knowledgeService) {
		this.knowledgeService = knowledgeService;
	}
	
	@Resource(name = "SearchItemService")
    public void setBasicService(IBasicService<SearchItem> basicService){
    	this.basicService=basicService;
    }
	
	@Resource(name = "SearchItemService")
	public void setSearchItemService(ISearchItemService searchItemService) {
		this.searchItemService = searchItemService;
	}

	@Resource(name = "TagService")
	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	}

}
