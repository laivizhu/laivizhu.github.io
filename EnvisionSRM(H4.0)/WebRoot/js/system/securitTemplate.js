$(document).ready(function(e) {
	var securitTemplateTable=new HouQianTable({
		url:"securitTemplate_securitList.action",
		parentContainer:"#securitTemplateTableDivId",
		columns:[
			{name:"模板编号",width:"10%",bindingProperty:"id"},
			{name:"模板名称",width:"35%",bindingProperty:"templateName"},
			{name:"附件",width:"35%",bindingProperty:"accessory",callback:function(data){
				window.location.href="securitTemplate_download.action?id="+data.id;
				
			}},
			{name:'新建日期',width:'10%',bindingProperty:"createDate"}
		],
		commonOperations:[
			{name:"删除",isAjax:true,callback:function(data){
				houQian.confirm('确定要删除此标准模板？',function(){
					houQian.getJson('securitTemplate_delete.action?id='+data.id, function(data){
						houQian.alert(data.msg);
						securitTemplateTable.refresh();
					});
				});
				}
			}
		],
		specialOperations:[
			{name:"添加",isAjax:true,callback:function(data){
					dialogOpen($("#addSecuritTemplateDivId"),'新增标准保密协议模板',180,400);
				}
			}
		],
		pageCount:pageSize
	});
	
	houQian.submitForm($('#addSecuritTemplateFormId'),'securitTemplate_add.action', function(data){
		dialogClose();
		houQian.alert(data.msg);
		securitTemplateTable.refresh();
	});
	
});