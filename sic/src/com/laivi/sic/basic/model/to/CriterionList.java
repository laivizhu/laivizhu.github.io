/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.basic.model.to;

import java.util.ArrayList;

/**
 * @author laivi
 * Desc:
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
