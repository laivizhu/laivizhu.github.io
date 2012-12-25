var loadUser=function(isMultChoose){
	var isMultChooseFlag=isMultChoose|false;
	new HouQianTable({
		url:"user_list.action",
		parentContainer:"#userTableId",
		columns:[
		    {name:"工号",width:"10%",bindingProperty:"workNumber"},
			{name:"登录账号",width:"12%",bindingProperty:"loginAccount"},
			{name:"姓名",width:"10%",bindingProperty:"name"},
			{name:"电子邮件",width:"15%",bindingProperty:"email"},
			{name:"办公电话",width:"10%",bindingProperty:"telephone"},
			{name:"手机",width:"10%",bindingProperty:"mobile"},
			{name:"部门",width:"15%",bindingProperty:"department"},
			{name:"职位",width:"15%",bindingProperty:"position"}
		],
		specialOperations:[
			{name:"确定",isAjax:true,callback:function(data){
					if(isMultChooseFlag){
						var Ids=$("#userInputId").val().split(",");
						$.each(Ids,function(i,item){
							if(data.id==item){
								$("#userDivId").dialog("close");
								return ;
							}
						});
						if($("#userInputId").val()=="" ||$("#userInputId").val()==0){
							$("#userNameInputId").val(data.name);
							$("#userInputId").val(data.id);
						}else{
							$("#userNameInputId").val($("#userNameInputId").val()+','+data.name);
							$("#userInputId").val($("#userInputId").val()+","+data.id);
						}
						
					}else{
						$("#userNameInputId").val(data.name);
						$("#userInputId").val(data.id);
					}
					$("#userDivId").dialog("close");
				}
			}	
		],
		pageCount:pageSize,
		selectType:1
	});
	//categoryList('supplierBasic_searchTypeList.action',$("bas_searchfield"));
};

function userChoose() {
	dialogOpen($("#userDivId"),'选择采购部用户',500,800);
}

function cleanUser(){
	$("#userNameInputId").val('');
	$("#userInputId").val('');
}