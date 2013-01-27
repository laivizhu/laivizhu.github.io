package com.laivi.knowledge.common.action;

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
import com.laivi.knowledge.common.model.po.Favorite;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@SuppressWarnings("serial")
public class FavoriteAction extends ABasicAction<Favorite> {
    private Favorite favorite;

    public String add()throws Exception{
        ParamAssert.isTrue(id!=0,"");
        CriterionList conditions=this.getUserCriterionList();
        conditions.put(Restrictions.eq("favoriteId", id)).put(Restrictions.eq("type", favorite.getType()));
        if(this.basicService.getCount(conditions)>0){
        	return response(false,"已收藏");
        }else{
	        favorite.setUserId(this.getCurrentUserId());
	        favorite.setFavoriteId(id);
	        favorite.setTitle(this.encodeExtString(favorite.getTitle()));
	        this.basicService.add(favorite);
	        return response(true);
        }
    }

	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		JsonItemList jsonList=new JsonItemList();
		jsonList.createItem().add("value", "title").add("text", "标题");
		return jsonList;
	}

	@Override
	public JsonItem getJsonItem(Favorite object,boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("createDate", DateUtil.formatDate(object.getCreateDate()))
		.add("user", object.getUserId())
		.add("favoriteId", object.getFavoriteId())
		.add("type", object.getType());
		return item;
	}

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }
    
    @Resource(name = "FavoriteService")
    public void setBasicService(IBasicService<Favorite> basicService){
    	this.basicService=basicService;
    }
}
