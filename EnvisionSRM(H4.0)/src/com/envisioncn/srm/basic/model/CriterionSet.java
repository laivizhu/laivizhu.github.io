/**
 * 
 */
package com.envisioncn.srm.basic.model;

import java.util.HashSet;

import org.hibernate.criterion.Criterion;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-18
 */
@SuppressWarnings("serial")
public class CriterionSet extends HashSet<Criterion> {

	public static CriterionSet CreateCriterion() {
		return new CriterionSet();
	}

	public CriterionSet put(Criterion criterion) {
		this.add(criterion);
		return this;
	}

}
