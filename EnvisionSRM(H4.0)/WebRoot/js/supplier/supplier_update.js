$(document).ready(function(e) {
	var id=houQian.getUrlVar('id');
	loadUser();
	var level1 = $("#materialClassifyId");
	var level2 = $("#materialCategoryId");
	var level3 = $("#materialSubCategoryId");
	var categoryListUrl='materialCategory_categoryListByType.action';
	categoryList('materialCategory_categoryListByType.action',level1,"categoryValue=0");
	cascadeChoose(categoryListUrl,level1,level2,level3,null,true);
	houQian.setFormVaule("supplierBasic_get.action?id="+id,true);
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
