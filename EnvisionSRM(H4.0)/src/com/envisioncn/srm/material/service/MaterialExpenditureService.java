package com.envisioncn.srm.material.service;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.bean.MaterialExpenditure;
import com.envisioncn.srm.material.dao.MaterialCategoryDao;
import com.envisioncn.srm.material.dao.MaterialExpenditureDao;

/**
 * Copyright Envision
 *
 * @author cehn.chen
 * @version 1.0
 * @data 2012-11-28
 */
@Service("MaterialExpenditureService")
public class MaterialExpenditureService implements IMaterialExpenditureService {
	
	private static final int showNumber = 25;
	
	private MaterialCategoryDao materialCategoryDao;
	private MaterialExpenditureDao materialExpenditureDao;


	@Resource(name = "MaterialCategoryDao")
	public void setMaterialCategoryDao(MaterialCategoryDao basicDao) {
		this.materialCategoryDao = basicDao;
	}
	
	@Resource(name = "MaterialExpenditureDao")
	public void setMaterialExpenditureDao(MaterialExpenditureDao materialExpenditureDao)
	{
		this.materialExpenditureDao = materialExpenditureDao;
	}
	
	private List<Map.Entry<String, Double>> mapToSortList(Map<String,Double> map){
		List<Map.Entry<String, Double>> infoIds = new ArrayList<Map.Entry<String, Double>>(map.entrySet());
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Double>>() {   
		    public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) { 
		    	if(o2.getValue() - o1.getValue() > 0)
		    		return 1;
		    	else if(o2.getValue() - o1.getValue() < 0)
		    		return -1;
		    	else
		    		return 0; 
		    }
		}); 
		return infoIds;
	}
	
	private Double doubleToDouble(Double dou){
		dou *= 100;
		Integer temp = dou.intValue();
		dou = temp.doubleValue();
		dou /= 100;
		return dou;
	}
	
	private JSONArray mapToTwoDimArray(Map<String,Double> map,Double total){
		List<Map.Entry<String, Double>> infoIds = this.mapToSortList(map);
		
		JSONArray tmpJsonArray = new JSONArray();
		int tmpCount = 0;
		double tmpTotal = 0;
		
		for (int i = 0; i < infoIds.size(); i++) {
			tmpCount ++;
			if(tmpCount < showNumber){
				JSONArray tmpArray = new JSONArray();
				tmpArray.add(infoIds.get(i).getKey().toString());
				tmpArray.add(infoIds.get(i).getValue());
				tmpJsonArray.add(tmpArray);
			}else
				tmpTotal += infoIds.get(i).getValue();
		}
		if(tmpCount >= showNumber){
			JSONArray tmpArray = new JSONArray();
			tmpArray.add("其他");
			tmpArray.add(tmpTotal);
			tmpJsonArray.add(tmpArray);
		}
		return tmpJsonArray;
	}
	
	private JSONArray mapToArray(Map<String,Double> map,Double total){
		List<Map.Entry<String, Double>> infoIds = this.mapToSortList(map);
		
		JSONArray tmpJsonArray = new JSONArray();
		JSONArray tmpJsonArray1 = new JSONArray();
		JSONArray tmpJsonArray2 = new JSONArray();
		JSONArray tmpJsonArray3 = new JSONArray();
		
		Double per = 0.0;
		Double temp = 0.0;
		int tmpCount = 0;
		double tmpTotal = 0;

		
		for (int i = 0; i < infoIds.size(); i++) {
			tmpCount ++;
			if(tmpCount < showNumber){
				tmpJsonArray1.add(infoIds.get(i).getKey().toString());
				temp += infoIds.get(i).getValue();
				per += (infoIds.get(i).getValue() / total) * 100;
				tmpJsonArray2.add(doubleToDouble(per));
				tmpJsonArray3.add(infoIds.get(i).getValue()/10000);
			}else
				tmpTotal += infoIds.get(i).getValue();
		}
		if(tmpCount >= showNumber){
			tmpJsonArray1.add("其他");
			tmpJsonArray2.add(doubleToDouble(per + tmpTotal / total * 100));
			tmpJsonArray3.add(tmpTotal/10000);
		}
		System.out.println(temp + "\t:\t" + total);
		tmpJsonArray.add(tmpJsonArray1);
		tmpJsonArray.add(tmpJsonArray2);
		tmpJsonArray.add(tmpJsonArray3);
		return tmpJsonArray;
	}

	private JsonList mapToJsonList(Map<String,Double> map,Double total){
		List<Map.Entry<String, Double>> infoIds = this.mapToSortList(map);
		
		JsonList josnList = new JsonList();
		int tmpCount = 0;
		double tmpTotal = 0;
		Format fm1 = new DecimalFormat("####0.00");
		Format fm2 = new DecimalFormat("#,###.00");
		for (int i = 0; i < infoIds.size(); i++) {
			tmpCount ++;
			if(tmpCount < showNumber){
				JsonItem jsonItem = new JsonItem();
				jsonItem.add("no", tmpCount);
				jsonItem.add("category",infoIds.get(i).getKey().toString());
				jsonItem.add("expenditure",fm2.format(infoIds.get(i).getValue()));
				jsonItem.add("per",fm1.format(infoIds.get(i).getValue() / total * 100).toString() + "%");
				josnList.add(jsonItem);
			}else
				tmpTotal += infoIds.get(i).getValue();
		}
		if(tmpCount >= showNumber){
			JsonItem jsonItem = new JsonItem();
			jsonItem.add("no", showNumber);
			jsonItem.add("category","其他合计");
			jsonItem.add("expenditure",fm2.format(tmpTotal));
			jsonItem.add("per",fm1.format(tmpTotal / total * 100).toString() + "%");
			josnList.add(jsonItem);
		}
		
		
		JsonItem jsonItem = new JsonItem();
		jsonItem.add("no", "");
		jsonItem.add("category","合计");
		jsonItem.add("expenditure",fm2.format(total));
		jsonItem.add("per","");
		josnList.add(jsonItem);
		return josnList;
	}
	
	private CriterionSet buildFirstCriterionSet(Integer level,
												Long longParentId1,
												Long longParentId2,
												Long longParentId3,
												Long longParentId4){
		CriterionSet conditions = CriterionSet.CreateCriterion();
		switch(level){
		case 1:
			conditions.add(Restrictions.eq("id", longParentId4));
			break;
		case 2:
			conditions.add(Restrictions.or(Restrictions.eq("id", longParentId4),
					Restrictions.eq("id", longParentId3)));
			break;
		case 3:
			conditions.add(Restrictions.or(Restrictions.eq("id", longParentId4),
					Restrictions.eq("id", longParentId3),
					Restrictions.eq("id", longParentId2)));
			break;
		case 4:
			conditions.add(Restrictions.or(Restrictions.eq("id", longParentId4),
					Restrictions.eq("id", longParentId3),
					Restrictions.eq("id", longParentId2),
					Restrictions.eq("id", longParentId1)));
			break;
		}	
		return conditions;
	}
	
	private CriterionSet buildSecondCriterionSet(List<MaterialCategory> tmpList,
												Integer level,
												Long longParentId1,
												Long longParentId2,
												Long longParentId3,
												Long longParentId4){
		CriterionSet conditions = CriterionSet.CreateCriterion();
		String parentId1="",parentId2="",parentId3="",parentId4="";
		if(level > 0){
			for(int i = 0; i < tmpList.size(); i++){
				if(tmpList.get(i).getId() == longParentId1){
					parentId1 = tmpList.get(i).getName();
				}
				if(tmpList.get(i).getId() == longParentId2){
					parentId2 = tmpList.get(i).getName();
				}
				if(tmpList.get(i).getId() == longParentId3){
					parentId3 = tmpList.get(i).getName();
				}
				if(tmpList.get(i).getId() == longParentId4){
					parentId4 = tmpList.get(i).getName();
				}
			}
		}

		switch(level){
		case 1:
			conditions.add(Restrictions.eq("parentid4", parentId4));
			break;
		case 2:
			conditions.add(Restrictions.eq("parentid3", parentId3));
			conditions.add(Restrictions.eq("parentid4", parentId4));
			break;
		case 3:
			conditions.add(Restrictions.eq("parentid2", parentId2));
			conditions.add(Restrictions.eq("parentid3", parentId3));
			conditions.add(Restrictions.eq("parentid4", parentId4));
			break;
		case 4:
			conditions.add(Restrictions.eq("parentid1", parentId1));
			conditions.add(Restrictions.eq("parentid2", parentId2));
			conditions.add(Restrictions.eq("parentid3", parentId3));
			conditions.add(Restrictions.eq("parentid4", parentId4));
			break;
		}	
		return conditions;
	}
	
	public JSONArray getChartStaticValue(String parentId1, String parentId2, String parentId3, String parentId4)
	{
		// 计算物料选择层次
		int level = 0;
		long longParentId1 = -1,longParentId2 = -1,longParentId3 = -1,longParentId4 = -1;
		if(!parentId4.endsWith("null") && !parentId4.equals("0")){
			level++;
			longParentId4 = Long.parseLong(parentId4);
		}
		if(!parentId3.endsWith("null") && !parentId3.equals("0")){
			level++;
			longParentId3 = Long.parseLong(parentId3);
		}	
		if(!parentId2.endsWith("null") && !parentId2.equals("0")){
			level++;
			longParentId2 = Long.parseLong(parentId2);
		}
		if(!parentId1.endsWith("null")&& !parentId1.equals("0")){
			level++;
			longParentId1 = Long.parseLong(parentId1);
		}
		
		//构建第一次查找条件
		CriterionSet conditions = this.buildFirstCriterionSet(level, longParentId1, longParentId2, longParentId3, longParentId4);

		
		//查找物料层次名称
		List<MaterialCategory> tmpList = this.getMaterialCategoryList(conditions);
		
		
		//构建第二次查找条件
		conditions.clear();
		conditions = this.buildSecondCriterionSet(tmpList, level, longParentId1, longParentId2, longParentId3, longParentId4);
		
		
		//查询物料支出
		List<MaterialExpenditure> tmpExpenditureList = this.getMaterialExpenditureList(conditions);
		
		//物料货源地/物料数量百分比
		Map<String,Double> locationQtyMap = new HashMap<String,Double>();
		//物料货源地/金额支出百分比
		Map<String,Double> locationCostMap = new HashMap<String,Double>();
		//物料小组支出累计数值
		Map<String,Double> materialCostMap = new HashMap<String,Double>();
		//供应商支出累计数值
		Map<String,Double> supplierCostMap = new HashMap<String,Double>();
		
		
		
		//计算数据
		double totalCost = 0;
		double totalQty = 0;
		for(MaterialExpenditure mtlExpenditure : tmpExpenditureList){
			totalCost += mtlExpenditure.getTotalSpending();
			totalQty += (double)mtlExpenditure.getQty();
			if(mtlExpenditure.getMTLSourceCoun().equals("中国")){
				if(locationCostMap.get(mtlExpenditure.getMTLSourcePvc()) != null){
					locationCostMap.put(mtlExpenditure.getMTLSourcePvc(), locationCostMap.get(mtlExpenditure.getMTLSourcePvc()) + mtlExpenditure.getTotalSpending());
					locationQtyMap.put(mtlExpenditure.getMTLSourcePvc(), locationQtyMap.get(mtlExpenditure.getMTLSourcePvc()) + mtlExpenditure.getQty());
				}else{
					locationCostMap.put(mtlExpenditure.getMTLSourcePvc(), mtlExpenditure.getTotalSpending());
					locationQtyMap.put(mtlExpenditure.getMTLSourcePvc(), (double) mtlExpenditure.getQty());
				}
			}else{
				if(locationCostMap.get(mtlExpenditure.getMTLSourceCoun()) != null){
					locationCostMap.put(mtlExpenditure.getMTLSourceCoun(), locationCostMap.get(mtlExpenditure.getMTLSourceCoun()) + mtlExpenditure.getTotalSpending());
					locationQtyMap.put(mtlExpenditure.getMTLSourceCoun(), locationQtyMap.get(mtlExpenditure.getMTLSourceCoun()) + mtlExpenditure.getQty());
				}else{
					locationCostMap.put(mtlExpenditure.getMTLSourceCoun(), mtlExpenditure.getTotalSpending());
					locationQtyMap.put(mtlExpenditure.getMTLSourceCoun(), (double) mtlExpenditure.getQty());
				}
			}
			
			if(supplierCostMap.get(mtlExpenditure.getSupplierName()) != null){
				supplierCostMap.put(mtlExpenditure.getSupplierName(), supplierCostMap.get(mtlExpenditure.getSupplierName()) + mtlExpenditure.getTotalSpending());
			}else{
				supplierCostMap.put(mtlExpenditure.getSupplierName(), mtlExpenditure.getTotalSpending());
			}
			
			if(materialCostMap.get(mtlExpenditure.getParentid1()) != null){
				materialCostMap.put(mtlExpenditure.getParentid1(), materialCostMap.get(mtlExpenditure.getParentid1()) + mtlExpenditure.getTotalSpending());
			}else{
				materialCostMap.put(mtlExpenditure.getParentid1(), mtlExpenditure.getTotalSpending());
			}
		}
		
		
		//map排序,构造JSONArray
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(mapToTwoDimArray(locationQtyMap,totalQty));
		jsonArray.add(mapToTwoDimArray(locationCostMap,totalCost));
		jsonArray.add(mapToArray(materialCostMap,totalCost));
		jsonArray.add(mapToArray(supplierCostMap,totalCost));
		
		
		return jsonArray;
	}

	public List<MaterialCategory> getMaterialCategoryList(CriterionSet conditions){
		return materialCategoryDao.getList(materialCategoryDao.getConditionCriteria(conditions));
	}
	
	public List<MaterialExpenditure> getMaterialExpenditureList(CriterionSet conditions){
		return materialExpenditureDao.getList(conditions);
	}

	public JsonList getReportStaticValue(String parentId1, String parentId2, String parentId3, String parentId4)
	{
		// 计算物料选择层次
		int level = 0;
		long longParentId1 = -1,longParentId2 = -1,longParentId3 = -1,longParentId4 = -1;
		if(!parentId4.endsWith("null") && !parentId4.equals("0")){
			level++;
			longParentId4 = Long.parseLong(parentId4);
		}
		if(!parentId3.endsWith("null") && !parentId3.equals("0")){
			level++;
			longParentId3 = Long.parseLong(parentId3);
		}	
		if(!parentId2.endsWith("null") && !parentId2.equals("0")){
			level++;
			longParentId2 = Long.parseLong(parentId2);
		}
		if(!parentId1.endsWith("null")&& !parentId1.equals("0")){
			level++;
			longParentId1 = Long.parseLong(parentId1);
		}
		
		//构建第一次查找条件
		CriterionSet conditions = this.buildFirstCriterionSet(level, longParentId1, longParentId2, longParentId3, longParentId4);

		
		//查找物料层次名称
		List<MaterialCategory> tmpList = this.getMaterialCategoryList(conditions);
		
		
		//构建第二次查找条件
		conditions.clear();
		conditions = this.buildSecondCriterionSet(tmpList, level, longParentId1, longParentId2, longParentId3, longParentId4);
		
		
		//查询物料支出
		List<MaterialExpenditure> tmpExpenditureList = this.getMaterialExpenditureList(conditions);

		//物料小组支出累计数值
		Map<String,Double> materialCostMap = new HashMap<String,Double>();
		
		//计算数据
		double totalCost = 0;
		for(MaterialExpenditure mtlExpenditure : tmpExpenditureList){
			totalCost += mtlExpenditure.getTotalSpending();
			if(materialCostMap.get(mtlExpenditure.getParentid1()) != null){
				materialCostMap.put(mtlExpenditure.getParentid1(), materialCostMap.get(mtlExpenditure.getParentid1()) + mtlExpenditure.getTotalSpending());
			}else{
				materialCostMap.put(mtlExpenditure.getParentid1(), mtlExpenditure.getTotalSpending());
			}
		}
		return mapToJsonList(materialCostMap,totalCost);
	}
	
}
