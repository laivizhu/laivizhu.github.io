$(document).ready(function(e) {

	new HouQianTable({
		url:"materialCode_newList.action",
		parentContainer:"#codeTableId",
		columns:[
			{name:"SAP物料号",width:"10%",bindingProperty:"code"},
			{name:"SAP物料描述",width:"20%",bindingProperty:"name"},
			{name:"供应商账户号",width:"20%",bindingProperty:"supplierAccountNo"},
			{name:"基本单位",width:"5%",bindingProperty:"basicUnit"},
			{name:"规格",width:"5%",bindingProperty:"norm"},
			{name:"图号",width:"5%",bindingProperty:"drawNo"},
			{name:"物料组",width:"10%",bindingProperty:"materialSAPGroup"},
			{name:"采购组",width:"10%",bindingProperty:"purchaseGroup"},
			{name:"是否已导入",width:"5%",bindingProperty:"isImport"},
		],
		commonOperations:[
			{name:"查看",isAjax:true,callback:function(data){
					window.location.href="material_main_view.jsp?id="+data.id;
				}
			}
		],
		pageCount:pageSize
	});
	
	categoryList("materialCategory_categorySearchConditionList.action",$("#categorySearchConditionId"));
	
});
