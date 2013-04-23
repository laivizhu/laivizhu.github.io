package com.laivi.sic.basic.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.laivi.sic.basic.util.JsonUtil;

@SuppressWarnings("serial")
public final class JsonItemList implements Serializable {
	private List<JsonItem> list = new ArrayList<JsonItem>();
	
	public JsonItem createItem() {
		JsonItem item = new JsonItem();
		list.add(item);
		return item;
	}

    public void add(JsonItem item) {
        list.add(item);
    }

	@Override
	public String toString() {
		return new ListResult<JsonItem>(list, list.size()).toJson();
	}
	
	public String toPageString(long size){
		return new ListResult<JsonItem>(list,(int)size).toJson();
	}

    public String toListString(){
        return JsonUtil.parseArray(list);
    }
	
	
}
