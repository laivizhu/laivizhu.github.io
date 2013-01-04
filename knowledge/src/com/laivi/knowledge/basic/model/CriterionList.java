package com.laivi.knowledge.basic.model;

import java.util.ArrayList;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-18
 */
@SuppressWarnings("serial")
public class CriterionList extends ArrayList<Object> {

	public static CriterionList CreateCriterion() {
		return new CriterionList();
	}

	public CriterionList put(Object criterion) {
		this.add(criterion);
		return this;
	}

}
