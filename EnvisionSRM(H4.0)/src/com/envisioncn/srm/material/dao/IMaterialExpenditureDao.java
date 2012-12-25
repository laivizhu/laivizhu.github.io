package com.envisioncn.srm.material.dao;

import java.util.List;

import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.material.bean.MaterialExpenditure;


public interface IMaterialExpenditureDao{
	
	public List<MaterialExpenditure> getList(CriterionSet criterionSet);
}
