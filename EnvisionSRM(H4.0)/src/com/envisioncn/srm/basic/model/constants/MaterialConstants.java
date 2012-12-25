package com.envisioncn.srm.basic.model.constants;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-28
 */
public interface MaterialConstants {
	interface ValueConstants {

	}

	interface InfoMessage {
		String TABLE_EMPTY = "未设置";
		String SUB_EMPTY = "--";
		String HASH_IMPORT = "已导入";
		String NOT_IMPORT = "未导入";
	}

	interface ErrorMessage {
		String MATERIAL_CATEGORY_NAME_NOTNULL = "类别名不能为空！";
		String MATERIAL_CATEGORY_TYPE_NOTNULL = "类别类型不能为空！";
		String MATERIAL_CATEGORY_OBJECT_HASEXIST = "记录已存在";
		String CATEGORY_EXIST_CHILDREN = "类别存在子对象,请删除子对象再删除该对象";

		String MATERIAL_CLASSIFY_NOTCHOOSE = "请选择物料分类";
		String MATERIAL_CATEGORY_NOTCHOOSE = "请选择物料类别";
		String MATERIAL_SUBCATEGORY_NOTCHOOSE = "请选择物料子类别";
		String MATERIAL_TEAM_NOTCHOOSE = "请选择物料小组";

		String MATERIAL_GROUP_NAME_NOTNULL = "小组名不能为空";
		String MATERIAL_GROUP_CATEGORY_NOTCHOISE = "物料类别不能为空";
		String MATERIAL_SAP_CODE = "SAP code不能为空";
		String MATERIAL_SAPCODE_HASHSETTING = "该SAP code已经设置过";
		String SAPCODE_NOTEXIST = "该SAP code不存在";
	}
}
