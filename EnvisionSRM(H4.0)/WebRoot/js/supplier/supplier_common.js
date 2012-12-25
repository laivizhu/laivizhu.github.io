var loadSupplier=function(isMultChoose){
	var isMultChooseFlag=isMultChoose||false;
	new HouQianTable({
		url:"../supplier_basic/supplierBasic_list.action?status=-1",
		parentContainer:"#supplierListTableId",
		columns:[
		    {name:"供应商编号",width:"20%",bindingProperty:"code"},
			{name:"供应商名称",width:"40%",bindingProperty:"name"},
			{name:"物料分类",width:"40%",bindingProperty:"category"}
		],
		specialOperations:[
			{name:"确定",isAjax:true,callback:function(data){
					if(isMultChooseFlag){
						var Ids=$("#supplierInputId").val().split(",");
						$.each(Ids,function(i,item){
							if(data.id==item){
								$("#supplier").dialog("close");
								return ;
							}
						});
						if($("#supplierInputId").val()=='' || $("#supplierInputId").val()==0){
							$("#supplierNameInputId").val(data.name);
							$("#supplierInputId").val(data.id);
						}else{
							$("#supplierNameInputId").val($("#supplierNameInputId").val()+','+data.name);
							$("#supplierInputId").val($("#supplierInputId").val()+","+data.id);
						}
					}else{
						$("#supplierNameInputId").val(data.name);
						$("#supplierInputId").val(data.id);
					}
					$("#supplier").dialog("close");
				}
			}	
		],
		pageCount:pageSize,
		selectType:1
	});
	categoryList('supplierBasic_searchTypeList.action',$("bas_searchfield"));
};

function supplierChoose() {
	dialogOpen($("#supplier"),'选择供应商',500,800);
}

function cleanSupplier(){
	$("#supplierNameInputId").val('');
	$("#supplierInputId").val('');
}
