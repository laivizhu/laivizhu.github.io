package com.laivi.sic.service.common;

import org.nutz.ioc.loader.annotation.IocBean;

import com.laivi.sic.model.po.common.AutoGraph;
import com.laivi.sic.service.basic.BasicDBService;

@IocBean
public class AutoGraphService extends BasicDBService{

	public void add(AutoGraph autoGraph){
		if(autoGraph.getParentId()!=0){
			AutoGraph parentAutoGraph=dao.fetch(AutoGraph.class, autoGraph.getParentId());
			if(!parentAutoGraph.isParentIs()){
				parentAutoGraph.setParentIs(true);
				dao.update(parentAutoGraph);
			}
		}
		dao.insert(autoGraph);
	}
}
