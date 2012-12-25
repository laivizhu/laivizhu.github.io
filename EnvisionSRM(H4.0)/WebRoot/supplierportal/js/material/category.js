$(document).ready(function(e) {
	showTab(2,3);
	
	var level1 = $("#materialCategoryClassifyID");
	var level2 = $("#materialCategoryID");
	var level3 = $("#materialSubCategoryID");
	var level4 = $("#materialTeamID");
	
	var level11 = $("#materialCodeCategoryClassifyID");
	var level21 = $("#materialCodeCategoryID");
	var level31 = $("#materialCodeSubCategoryID");
	var level41 = $("#materialCodeTeamID");
	
	/*var level12 = $("#materialCategoryClassifyIDU");
	var level22 = $("#materialCategoryIDU");
	var level32 = $("#materialSubCategoryIDU");*/
	
	new HouQianTable({
		url:"materialCategory_categoryTableList.action",
		parentContainer:"#categoryTableId",
		columns:[
			{name:"类别类型",width:"10%",bindingProperty:"categoryType"},
			{name:"类别名称",width:"10%",bindingProperty:"name"},
			{name:"创建日期",width:"10%",bindingProperty:"createDate"},
			{name:"是否锁定",width:"10%",bindingProperty:"islock"}
		],
		commonOperations:[
			{name:"删除",isAjax:true,callback:deleteCategory}
		],
		specialOperations:[
			{name:"新增类别",isAjax:true,callback:addCategory}	
		],
		pageCount:pageSize,
		selectType:0
	});
	
	
	new HouQianTable({
		url:"materialCategory_list.action",
		parentContainer:"#categoryListTableId",
		columns:[
			{name:"物料小组",width:"10%",bindingProperty:"name"},
			{name:"物料子类别",width:"10%",bindingProperty:"subCategory"},
			{name:"物料类别",width:"10%",bindingProperty:"category"},
			{name:"物料分类",width:"10%",bindingProperty:"classify"},
			{name:"创建日期",width:"10%",bindingProperty:"createDate"}
		],
		commonOperations:[
			{name:"删除",isAjax:true,callback:deleteCategoryRelation}
		],
		specialOperations:[
			{name:"新建类别关联",isAjax:true,callback:settingCategoryRelation}
		],
		pageCount:pageSize,
		selectType:0
	});
	
	
	
	new HouQianTable({
		url:"materialCode_list.action",
		parentContainer:"#codeListTableId",
		columns:[
			{name:"SAP Code",width:"10%",bindingProperty:"code"},
			{name:"SAP 物料名称",width:"42%",bindingProperty:"name"},
			{name:"SAP 物料组",width:"10%",bindingProperty:"materialSAPGroup"},
			{name:"物料小组",width:"10%",bindingProperty:"categoryTeam"},
			{name:"物料子类别",width:"10%",bindingProperty:"subCategory"},
			{name:"物料类别",width:"10%",bindingProperty:"category"},
			{name:"物料分类",width:"10%",bindingProperty:"classify"}
			
			
		],
		commonOperations:[
  			{name:"删除",isAjax:true,callback:deleteSAPRelation}
  		],
		specialOperations:[
			{name:"新建SAP Code关联",isAjax:true,callback:setSAPCodeRelation}
		],
		pageCount:pageSize,
		selectType:1
	});
	
	var categoryListUrl='materialCategory_categoryListByType.action';
	cascadeChoose(categoryListUrl,level1,level2,level3,level4,false);
	cascadeChoose(categoryListUrl,level11,level21,level31,level41,true);
	//cascadeChoose(categoryListUrl,level12,level22,level32);
	
	categoryList("materialCategory_categoryList.action",$("#categorySelectID"));
	
	categoryList("materialCategory_categorySearchConditionList.action",$("#categoryASearchConditionId"));
	
	categoryList("materialCategory_categorySearchConditionList.action",$("#categorySearchConditionId"));
	
	categoryList("materialCode_codeSearchConditionList.action",$("#codeSearchConditionId"));
});

var addCategory = function(data){
	dialogOpen($("#categoryAdd"),'新增类别',200,520);
};

var settingCategoryRelation=function(data){
	dialogOpen($("#categoryRelationAdd"),'类别关联设置',240,520);
	$("#materialCategoryID").attr("disabled","diabled");
	$("#materialSubCategoryID").attr("disabled","diabled");
	$("#materialTeamID").attr("disabled","diabled");
};

var setSAPCodeRelation=function(data){
	$("#materialCodeId").val(data.id);
	$("#materialCodeCodeId").val(data.code);
	dialogOpen($("#SAPCode"),'SAP Code关联',280,400);
	$("#materialCodeCategoryID").attr("disabled","diabled");
	$("#materialCodeSubCategoryID").attr("disabled","diabled");
	$("#materialCodeTeamID").attr("disabled","diabled");
};

var deleteCategory=function(data){
	if(window.confirm('确定要删除该物料类别？')){
		$.getJSON('materialCategory_delete.action?id='+data.id+getRandParam(),function(result){
			if(result.success){
				window.location.href="category.jsp";
			}else{
				alert(result.msg);
			}
		});
	}
};

var deleteCategoryRelation=function(data){
	if(window.confirm('确定要删除该物料小组的类别的关系吗？')){
		$.getJSON('materialCategory_deleteRelation.action?id='+data.id+getRandParam(),function(result){
			if(result.success){
				window.location.href="category.jsp";
			}else{
				alert(result.msg);
			}
		});
	}
};

var deleteSAPRelation=function(data){
	if(window.confirm('确定要删除该SAP的物料类别关系吗？')){
		$.getJSON('materialCode_deleteCodeRelation.action?id='+data.id+getRandParam(),function(result){
			if(result.success){
				window.location.href="category.jsp";
			}else{
				alert(result.msg);
			}
		});
	}
};

var updateCategory=function(result){
	$.getJSON('materialCategory_get.action?id='+result.id+getRandParam(),function(data){
		if(data.success){
			$("#CategoryTeamId").val(result.id);
			$("#materialCategoryNameId").val(data.data.name);
			$("#materialCategoryClassifyIDU").val(data.data.classify);
			$("#materialCategoryIDU").val(data.data.category);
			$("#materialSubCategoryIDU").val(data.data.subCategory);

		}else{
			alert("加载数据失败");
		}
	});
	dialogOpen($("#categoryRelationUpdate"),'类别关联修改',300,520);
};