$(document).ready(function(e) {
	new HouqianTab({
		parentContainer:"#supplierInformationTabDiv",
		tabs:[
			{name:"修改供应商信息",page:"supplier_information_1.jsp"},
			{name:"终止供应商",page:"supplier_information_2.jsp"}
		]
	});
});