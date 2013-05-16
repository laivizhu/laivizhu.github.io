package com.laivi.sic.model.po.shopping;


import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicEntity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-17
 */
@SuppressWarnings("serial")
@Table("sic_shoppingItem")
public class ShoppingItem extends ABasicEntity {

	private long commodityId;
	private int count;
	private float price;
	
	public long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
