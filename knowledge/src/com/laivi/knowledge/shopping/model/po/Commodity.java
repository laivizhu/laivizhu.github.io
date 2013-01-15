package com.laivi.knowledge.shopping.model.po;

import com.laivi.knowledge.basic.model.po.BasicEntity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@SuppressWarnings("serial")
//@Entity
//@Table(name="t_commodity")
public class Commodity extends BasicEntity {

	private long id;
	@Override
	public long getId() {
		return id;
	}

}
