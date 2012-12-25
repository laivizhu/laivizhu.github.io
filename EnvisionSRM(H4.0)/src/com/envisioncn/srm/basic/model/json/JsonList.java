package com.envisioncn.srm.basic.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public final class JsonList implements Serializable {
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

	public String toPageString(long size) {
		return new ListResult<JsonItem>(list, size).toJson();
	}

}
