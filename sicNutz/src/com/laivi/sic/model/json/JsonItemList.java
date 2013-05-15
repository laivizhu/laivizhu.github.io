package com.laivi.sic.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public final class JsonItemList implements Serializable {
	private List<JsonItem> root = new ArrayList<JsonItem>();
	
	public JsonItem createItem() {
		JsonItem item = new JsonItem();
		root.add(item);
		return item;
	}

    public void add(JsonItem item) {
    	root.add(item);
    }

	public ListResult<JsonItem> toList() {
		return new ListResult<JsonItem>(root, root.size());
	}
	
	public ListResult<JsonItem> toPageList(int size){
		return new ListResult<JsonItem>(root,size);
	}

	public List<JsonItem> getRoot() {
		return root;
	}
	
}
