$(document).ready(function(e) {
	new HouQianTable({
		url:"supplierBasic_list.action",
		parentContainer:"#supplierListTableId",
		columns:[
		    {name:"编号",width:"10%",bindingProperty:"code"},
			{name:"供应商名称",width:"30%",bindingProperty:"name"},
			{name:"电话",width:"10%",bindingProperty:"phone"},
			{name:"负责人",width:"10%",bindingProperty:"personName"},
			{name:"创办时间",width:"10%",bindingProperty:"establishDate"}
		],
		specialOperations:[
			{name:"确定",isAjax:true,callback:chooseSupplier}	
		],
		pageCount:pageSize,
		selectType:1
	});
	categoryList('supplierBasic_searchTypeList.action',$("bas_searchfield"));
});

var chooseSupplier=function(data){
	$("#supplierNameInputId").val(data.name);
	$("#supplierInputId").val(data.id);
	$("#supplier").dialog("close");
};