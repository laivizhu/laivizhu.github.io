package com.laivi.sic.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	public ListResult<JsonItem> toList() {
		return new ListResult<JsonItem>(list, list.size());
	}
	
	public ListResult<JsonItem> toPageList(int size){
		return new ListResult<JsonItem>(list,size);
	}
	
	
}
