$(document).ready(function(e) {
	var templateTable=new HouQianTable({
		url:"template_list.action",
		parentContainer:"#templateTableDivId",
		columns:[
			{name:"模板名",width:"10%",bindingProperty:"name"},
			{name:"模板文件",width:"50%",bindingProperty:"file"},
			{name:"模板类型",width:"10%",bindingProperty:"templateType"},
			{name:"是否默认",width:"10%",bindingProperty:"isDefault"},
			{name:'添加日期',width:'10%',bindingProperty:"createDate"}
		],
		commonOperations:[
			{name:"删除",isAjax:true,callback:function(data){
					
				}
			}
		],
		specialOperations:[
			{name:"添加",isAjax:true,callback:function(data){
					categoryList('template_templateTypeList.action',$("#templateSelectID"));
					dialogOpen($("#addTemplateDivId"),'新增模板',250,400);
				}
			},
			{name:"设为缺省值",isAjax:true,callback:function(data){
					houQian.getJson('template_setDefault.action?id='+data.id, function(){
						
					});
				}
			}
		],
		pageCount:pageSize
		//selectType:1
	});
	
	houQian.submitForm($('#addTemplateFormId'),'template_add.action', function(){
		dialogClose();
		templateTable.refresh();
	});
	
});