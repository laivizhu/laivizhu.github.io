package com.laivi.knowledge.common.action;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.common.model.po.Favorite;
import com.laivi.knowledge.common.service.IFavoriteService;
import org.apache.commons.httpclient.util.DateUtil;

import javax.annotation.Resource;

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
    private IFavoriteService favoriteService;

    public String add()throws Exception{
        ParamAssert.isTrue(favorite.getFavoriteId()!=0,"");
        return response();
    }

	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		JsonItemList jsonList=new JsonItemList();
		jsonList.createItem().add("value", "type").add("text","类型");
		jsonList.createItem().add("value", "title").add("text", "标题");
		return jsonList;
	}

	@Override
	public JsonItem getJsonItem(Favorite object) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("title", object.getTitle())
		.add("crateDate", DateUtil.formatDate(object.getCreateDate()))
		.add("user", object.getUserId())
		.add("type", object.getType().toText());
		return item;
	}

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    @Resource(name = "FavoriteService")
    public void setFavoriteService(IFavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }
}
