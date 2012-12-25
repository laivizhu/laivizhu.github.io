$(document).ready(function(e) {
	var id=houQian.getUrlVar('id');
	houQian.setFormVaule("materialCode_get.action?id="+id);
	houQian.setFormVaule("materialCode_getMaterialMainValue.action?id="+id);
	new HouQianTable({
		url:"materialCode_getPriceTable.action?id="+id,
		parentContainer:"#priceTableId",
		columns:[
			{name:"起始日期",width:"10%",bindingProperty:"startDate"},
			{name:"截止日期",width:"10%",bindingProperty:"endDate"},
			{name:"净价",width:"20%",bindingProperty:"currency"},
			{name:"货币",width:"20%",bindingProperty:"nett"},
			{name:"价格单位",width:"20%",bindingProperty:"priceUnit"},
			{name:"计价单位",width:"20%",bindingProperty:"countUnit"}
		],
		pageCount:pageSize,
		selectType:0
	});
	
	new HouQianTable({
		url:"materialCode_getOrderTable.action?id="+id,
		parentContainer:"#orderTableId",
		columns:[
			{name:"有效起始日",width:"20%",bindingProperty:"startDate"},
			{name:"有效截止日",width:"20%",bindingProperty:"endDate"},
			{name:"采购组织",width:"20%",bindingProperty:"purcharOrg"},
			{name:"订单单位",width:"20%",bindingProperty:"orderUnit"},
			{name:"计划协议",width:"20%",bindingProperty:"planPro"}
		],
		pageCount:pageSize,
		selectType:0
	});
	
	new HouQianTable({
		url:"materialCode_getQuatoTable.action?id="+id,
		parentContainer:"#quotaTableId",
		columns:[
			{name:"采购类型",width:"20%",bindingProperty:"purchType"},
			{name:"特殊采购类型",width:"20%",bindingProperty:"specialPurchType"},
			{name:"供应商账号",width:"30%",bindingProperty:"supplierAccount"},
			{name:"供应商工厂",width:"30%",bindingProperty:"supplierFactory"}
		],
		pageCount:pageSize,
		selectType:0
	});
});