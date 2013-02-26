package com.laivi.knowledge.common.action;

import com.laivi.knowledge.basic.action.ALBasicAction;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.common.model.po.Advertisement;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 23, 2013
 */
@SuppressWarnings("serial")
public class AdvertisementAction extends ALBasicAction<Advertisement> {
	

	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	@Override
	public JsonItem getJsonItem(Advertisement object, boolean isSub) throws Exception {
		return null;
	}

	@Override
	public Class<Advertisement> getObjectClass() throws Exception {
		return Advertisement.class;
	}

}
