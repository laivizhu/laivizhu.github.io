package com.laivi.knowledge.shopping.model.po;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.po.BasicEntity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-17
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_shoppingItem")
public class ShoppingItem extends BasicEntity {

	private long id;
	private Commodity commodity;
	private int count;
	private float price;

	@Override
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "commodityId")
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
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

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toJson() {
		JsonItem item = new JsonItem();
		item.add("id", this.getId()).add("count", this.getCount())
				.add("price", this.getPrice())
				.add("name", this.getCommodity().getName())
				.add("category", this.getCommodity().getCategory().getName());
		return item.toString();
	}

}
