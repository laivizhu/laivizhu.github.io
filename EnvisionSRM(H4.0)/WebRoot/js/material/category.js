var categoryTable;
var categoryRelationTable;
var SAPTable;
$(document).ready(function(e) {
	var level1 = $("#materialCategoryClassifyID");
	var level2 = $("#materialCategoryID");
	var level3 = $("#materialSubCategoryID");
	var level4 = $("#materialTeamID");
	
	var level11 = $("#materialCodeCategoryClassifyID");
	var level21 = $("#materialCodeCategoryID");
	var level31 = $("#materialCodeSubCategoryID");
	var level41 = $("#materialCodeTeamID");

	categoryTable=new HouQianTable({
		url:"materialCategory_categoryTableList.action",
		parentContainer:"#categoryTableId",
		columns:[
			{name:"类别类型",width:"10%",bindingProperty:"categoryType"},
			{name:"类别名称",width:"60%",bindingProperty:"name"},
			{name:"是否锁定",width:"10%",bindingProperty:"islock"},
			{name:"创建日期",width:"10%",bindingProperty:"createDate"}
		],
		commonOperations:[
			{name:"删除",isAjax:true,callback:function(data){
				houQian.confirm('确定要删除该物料类别？',function(){
					houQian.getJson('materialCategory_delete.action?id='+data.id+getRandParam(), function(){
						categoryTable.refresh();
					});
				});
				
			}}
		],
		specialOperations:[
			{name:"新建",isAjax:true,callback:function(){
					dialogOpen($("#categoryAdd"),'新增类别',200,400);
					$('#materialCategoryAddFormId').resetForm();
				}
			}	
		],
		pageCount:pageSize,
		selectType:0
	});
	
	
	categoryRelationTable=new HouQianTable({
		url:"materialCategory_list.action",
		parentContainer:"#categoryListTableId",
		columns:[
			{name:"物料小组",width:"20%",bindingProperty:"name"},
			{name:"物料子类别",width:"20%",bindingProperty:"subCategory"},
			{name:"物料类别",width:"20%",bindingProperty:"category"},
			{name:"物料分类",width:"20%",bindingProperty:"classify"},
			{name:"创建日期",width:"10%",bindingProperty:"createDate"}
		],
		commonOperations:[
			{name:"删除",isAjax:true,callback:function(data){
				houQian.confirm('确定要删除该物料小组的类别的关系吗？',function(){
					houQian.getJson('materialCategory_deleteRelation.action?id='+data.id+getRandParam(), function(){
						categoryRelationTable.refresh();
					});
				});
			}}
		],
		specialOperations:[
			{name:"新建",isAjax:true,callback:function(data){
					dialogOpen($("#categoryRelationAdd"),'类别关联设置',240,400);
					$("#materialCategoryClassifyID").empty();
					$("#materialCategoryID").empty();
					$("#materialSubCategoryID").empty();
					$("#materialTeamID").empty();
					$("#materialCategoryID").attr("disabled","diabled");
					$("#materialSubCategoryID").attr("disabled","diabled");
					$("#materialTeamID").attr("disabled","diabled");
					categoryList('materialCategory_categoryListByType.action',$("#materialCategoryClassifyID"),"categoryValue=0");
				}
			}
		],
		pageCount:pageSize,
		selectType:0
	});
	
	SAPTable=new HouQianTable({
		url:"materialCode_list.action",
		parentContainer:"#codeListTableId",
		columns:[
			{name:"SAP物料号",width:"10%",bindingProperty:"code"},
			{name:"SAP物料描述",width:"30%",bindingProperty:"name"},
			{name:"SAP物料组",width:"10%",bindingProperty:"materialSAPGroup"},
			{name:"物料小组",width:"10%",bindingProperty:"categoryTeam"},
			{name:"物料子类别",width:"10%",bindingProperty:"subCategory"},
			{name:"物料类别",width:"10%",bindingProperty:"category"},
			{name:"物料分类",width:"10%",bindingProperty:"classify"}
		],
		commonOperations:[
  			{name:"删除",isAjax:true,callback:function(data){
  				houQian.confirm('确定要删除该SAP的物料类别关系吗？',function(){
					houQian.getJson('materialCode_deleteCodeRelation.action?id='+data.id+getRandParam(), function(){
						SAPTable.refresh();
					});
				});
  			}}
  		],
		specialOperations:[
			{name:"新建",isAjax:true,callback:function(data){
					$("#materialCodeLabelId").html('');
					$('#SAPCodeSetRelationFormId').resetForm();
					dialogOpen($("#SAPCode"),'SAP Code关联',280,400);
					$("#materialCodeCategoryClassifyID").empty();
					$("#materialCodeCategoryID").empty();
					$("#materialCodeSubCategoryID").empty();
					$("#materialCodeTeamID").empty();
					$("#materialCodeCategoryID").attr("disabled","diabled");
					$("#materialCodeSubCategoryID").attr("disabled","diabled");
					$("#materialCodeTeamID").attr("disabled","diabled");
					categoryList('materialCategory_categoryListByType.action',$("#materialCodeCategoryClassifyID"),"categoryValue=0");
				}
			}
		],
		pageCount:pageSize
	});
	
	new HouQianTable({
		url:"materialCode_list.action",
		parentContainer:"#searchCodeListTableId",
		columns:[
			{name:"SAP物料号",width:"10%",bindingProperty:"code"},
			{name:"SAP物料描述",width:"40%",bindingProperty:"name"},
			{name:"SAP物料组",width:"10%",bindingProperty:"materialSAPGroup"},
			{name:"物料小组",width:"10%",bindingProperty:"categoryTeam"},
			{name:"物料子类别",width:"10%",bindingProperty:"subCategory"},
			{name:"物料类别",width:"10%",bindingProperty:"category"},
			{name:"物料分类",width:"10%",bindingProperty:"classify"}
		],
		pageCount:pageSize
	});
	
	var categoryListUrl='materialCategory_categoryListByType.action';
	cascadeChoose(categoryListUrl,level1,level2,level3,level4,false);
	cascadeChoose(categoryListUrl,level11,level21,level31,level41,true);
	//cascadeChoose(categoryListUrl,level12,level22,level32);
	
	categoryList("materialCategory_categoryList.action",$("#categorySelectID"));
	
	categoryList("materialCategory_categorySearchConditionList.action",$("#categoryASearchConditionId"));
	
	categoryList("materialCategory_categorySearchConditionList.action",$("#categorySearchConditionId"));
	
	categoryList("materialCode_codeSearchConditionList.action",$("#codeSearchConditionId"));
	
	categoryList("materialCode_codeSearchConditionList.action",$("#codeSearchConditionTab4Id"));
	
	houQian.submitForm($('#materialCategoryAddFormId'), 'materialCategory_add.action', function(){
		categoryTable.refresh();
		dialogClose();
	});
	
	houQian.submitForm($('#SAPCodeSetRelationFormId'), 'materialCode_setCodeRelation.action', function(){
		SAPTable.refresh();
		dialogClose();
	});
	
	houQian.submitForm($('#categoryRelationAddFormId'), 'materialCategory_settingRelation.action', function(){
		categoryRelationTable.refresh();
		dialogClose();
	});
});

var showResult=function(){
	$.getJSON("materialCode_showCodeResult.action?materialCode.code="+$("#materialCodeCodeId").val(),function(data){
		if(data.success=='true'){
			$("#materialCodeLabelId").html(data.msg);
		}else{
			$("#materialCodeLabelId").html('<font color=red>'+data.msg+'</font>');
		}
	});
};

function categorySearch(){
	var keyword=$("#categoryASearchConditionId").val();
	var value=$("#categoryKeywordId").val();
	categoryTable.mOptions.url="materialCategory_search.action?key="+keyword+"&value="+value;
	categoryTable.refresh();
}