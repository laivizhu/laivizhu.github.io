var loadMaterial=function(isMultChoose){
	var isMultChooseFlag=isMultChoose||false;
	new HouQianTable({
		url:"materialCode_list.action",
		parentContainer:"#materialTableId",
		columns:[
		    {name:"物料名称",width:"20%",bindingProperty:"name"},
			{name:"物料小组",width:"20%",bindingProperty:"categoryTeam"},
			{name:"物料子类别",width:"20%",bindingProperty:"subCategory"},
			{name:"物料类别",width:"20%",bindingProperty:"category"},
			{name:"物料分类",width:"20%",bindingProperty:"classify"}
		],
		specialOperations:[
			{name:"确定",isAjax:true,callback:function(){
					if(isMultChooseFlag){
						var Ids=$("#materialInputId").val().split(",");
						$.each(Ids,function(i,item){
							if(data.id==item){
								$("#material").dialog("close");
								return ;
							}
						});
						if($("#materialInputId").val()==''|| $("#materialInputId").val()==0){
							$("#materialNameInputId").val(data.name);
							$("#materialInputId").val(data.id);
						}else{
							$("#materialNameInputId").val($("#materialNameInputId").val()+','+data.name);
							$("#materialInputId").val($("#materialInputId").val()+","+data.id);
						}
						
					}else{
						$("#materialNameInputId").val(data.name);
						$("#materialInputId").val(data.id);
					}
					$("#material").dialog("close");
				}
			}	
		],
		pageCount:pageSize,
		selectType:1
	});
	categoryList('materialCode_codeSearchConditionList.action',$("bas_searchfield"));
};

function materialChoose() {
	dialogOpen($("#material"),'选择供应商',500,800);
}

function cleanMaterial(){
	$("#materialNameInputId").val('');
	$("#materialInputId").val('');
}
