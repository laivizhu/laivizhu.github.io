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
import com.laivi.knowledge.basic.model.type.TagType;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.knowledge.model.po.Tag;
import com.laivi.knowledge.knowledge.service.ITagService;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:53
 */
@SuppressWarnings("serial")
public class TagAction extends ABasicAction<Tag> {
	private ITagService tagService;
	private Tag tag;
	
	private String tagIds;

	public String add()throws Exception{
		ParamAssert.isNotNull(tag, "error.tag.name.notNULL");
		ParamAssert.isNotEmptyString(tag.getName(), "error.tag.name.notNULL");
		ParamAssert.isTrue(tag.getType()!=0, "error.tag.type.notNULL");
		tag.setUserId(this.getCurrentUserId());
		tag.setCreateDate(new Date());
		tagService.add(tag);
		return response(true);
	}
	
	public String update()throws Exception{
		ParamAssert.isTrue(id!=0, "error.object.notChoose");
		ParamAssert.isNotNull(tag, "error.tag.name.notNULL");
		ParamAssert.isNotEmptyString(tag.getName(), "error.tag.name.notNULL");
		ParamAssert.isTrue(tag.getType()!=0, "error.tag.type.notNULL");
		Tag dTag=this.tagService.getObject(id);
		dTag.setName(tag.getName());
		dTag.setType(tag.getType());
		this.tagService.modify(dTag);
		return response(true);
	}
	
	public String delete()throws Exception{
		ParamAssert.isNotEmptyString(tagIds, "error.object.notChoose");
		this.tagService.remove(tagIds);
		return response(true);
	}
	
	public String list()throws Exception{
		CriterionList conditions=this.getUserCriterionList();
		JsonList jsonList=new JsonList();
		for(Tag tag:tagService.getList(conditions,start,limit)){
			jsonList.add(this.getJsonItem(tag));
		}
		return response(jsonList.toPageString(tagService.getCount(conditions)));
	}
	
	public String comboList()throws Exception{
		JsonList jsonList=new JsonList();
		CriterionList conditions=this.getUserCriterionList();
		conditions.put(Restrictions.eq("type", tag.getType()));
		for(Tag tag:tagService.getList(conditions,start,limit)){
			jsonList.createItem().add("value", tag.getId()).add("text", tag.getName());
		}
		return response(jsonList);
	}
	
	public String typeList()throws Exception{
		JsonList jsonList=new JsonList();
		for(TagType type:TagType.values()){
			jsonList.createItem().add("value", type.toValue()).add("text", type.toText());
		}
		return response(jsonList);
	}
	
	public String get()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		Tag tag=this.tagService.getObject(id);
		JsonItem item =new JsonItem();
		item.add("id", tag.getId()).add("tag.name", tag.getName()).add("tag.type", tag.getType());
		return response(item.toFormDataString(true));
	}
	
	
	public JsonList getSearchComboList()throws ErrorException{
		JsonList jsonList=new JsonList();
		jsonList.createItem().add("value", "name").add("text", "标签名");
		jsonList.createItem().add("value", "type").add("text", "标签类型");
		jsonList.createItem().add("value", "createDate").add("text", "创建时间");
		return jsonList;
	}

    public JsonItem getJsonItem(Tag object) throws Exception {
    	JsonItem item=new JsonItem();
    	item.add("id", object.getId())
    	.add("name", object.getName())
    	.add("type", TagType.fromValue(object.getType()).toText())
    	.add("createDate", DateUtil.formatDate(object.getCreateDate()));
        return item;
    }
    
    @Resource(name="TagService")
	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	}
    
    @Resource(name = "TagService")
    public void setBasicService(IBasicService<Tag> basicService){
    	this.basicService=basicService;
    }

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
}
