var id=10;
$(document).ready(function(e) {
	houQian.setFormVaule("supplierBasic_get.action?id="+id);
	houQian.setFormVaule("supplierBasic_getSupplierInfoForm?id="+id,true);
});

var saveSupplierInfo=function(){
	houQian.confirm("确认保存", function(){
		var url="supplierBasic_supplierInfoSave.action?id="+id;
		houQian.submitForm($("#supplierInfoFormId"),url,function(){
			houQian.alert("保存成功");
		},true,true);
	});
};

var submitSupplierInfo=function(){
	houQian.confirm("确认要提交吗?", function(){
		houQian.submitForm($("#supplierInfoFormId"),"supplierBasic_supplierSubmit.action?id="+id, function(data){
			houQian.alert('提交成功');
			$("#supplierInfoFormId").resetForm();
		},true,true);
	});
};