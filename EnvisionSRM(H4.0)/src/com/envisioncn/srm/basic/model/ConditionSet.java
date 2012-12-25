/**
 * 
 */
package com.envisioncn.srm.basic.model;

import java.util.HashSet;

/**
 * @author Janlu
 * 
 */
@SuppressWarnings("serial")
public class ConditionSet extends HashSet<Condition> {

	public static ConditionSet CreateCondition() {
		return new ConditionSet();
	}

	public ConditionSet put(Condition condition) {
		this.add(condition);
		return this;
	}

}
