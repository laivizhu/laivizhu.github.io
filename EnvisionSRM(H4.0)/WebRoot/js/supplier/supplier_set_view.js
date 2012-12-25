$(document).ready(function(e) {
	var id=houQian.getUrlVar('id');
	houQian.setFormVaule("supplierBasic_get.action?id="+id);
	houQian.setFormVaule("supplierBasic_getSupplierInfoForm?id="+id);
});

var firstPass=function(){
	houQian.confirm("确认要初审通过?", function(){
		var id=houQian.getUrlVar('id');
		houQian.getJson("supplierBasic_passDeal?id="+id+"&status=1", function(){
			window.location.href='supplier_set.jsp';
		});
	});
};
var finallyPass=function(){
	houQian.confirm("确认要通过吗?", function(){
		var id=houQian.getUrlVar('id');
		var deliveryNo=$("#deliveryNoId").val();
		var receFileDate=$("#receFileDateId").val();
		houQian.getJson("supplierBasic_passDeal?id="+id+"&status=2&deliveryNo="+deliveryNo+"&receFileDate="+receFileDate, function(){
			window.location.href='supplier_set.jsp';
		});
	});
};
var unPass=function(){
	houQian.confirm("确认要不通过吗?", function(){
		var id=houQian.getUrlVar('id');
		houQian.getJson("supplierBasic_passDeal?id="+id+"&status=3", function(){
			window.location.href='supplier_set.jsp';
		});
	});
};
var reject=function(){
	var id=houQian.getUrlVar('id');
	dialogOpen($("#rejectDivId"),'驳回原因',300,500);
	houQian.submitForm($('#rejectFormId'),'supplierBasic_reject?id='+id, function(){
		dialogClose();
		window.location.href='supplier_set.jsp';
	});
};