package com.laivi.knowledge.basic.model.po;

import com.laivi.knowledge.basic.model.json.JsonEntity;
import com.laivi.knowledge.basic.util.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Janlu
 * Date: 13-1-8
 * Time: 下午8:08
 * To change this template use File | Settings | File Templates.
 */
public class BasicEntity implements JsonEntity{
    @Override
    public String toJson() {
        return JsonUtil.toJson(this);
    }
}
