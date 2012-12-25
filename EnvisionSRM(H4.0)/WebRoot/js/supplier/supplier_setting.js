$(document).ready(function(e) {
	new HouqianTab({
		parentContainer:"#supplierBasicTabDiv",
		tabs:[
			{name:"注册供应商",page:"supplier_set_1.jsp"},
			{name:"初审供应商",page:"supplier_set_2.jsp"},
			{name:"终审供应商",page:"supplier_set_3.jsp"}
		]
	});
});