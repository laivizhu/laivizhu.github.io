package com.laivi.knowledge.basic.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.laivi.knowledge.basic.util.JsonUtil;

@SuppressWarnings("serial")
public final class JsonList implements Serializable {
	private List<String> list = new ArrayList<String>();
	
    public void add(String item) {
        list.add(item);
    }

	@Override
	public String toString() {
		return new ListResult<String>(list, list.size()).toJson();
	}
	
	public String toPageString(long size){
		return new ListResult<String>(list,(int)size).toJson();
	}

    public String toListString(){
        return JsonUtil.parseArray(list);
    }
}
