<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(e){
	var supplierFinallyTable=new HouQianTable({
		url:"supplierBasic_list.action?status=1",
		parentContainer:"#supplierFinallyTableId",
		columns:[
			{name:"供应商编号",width:"10%",bindingProperty:"code"},
			{name:"供应商名称",width:"30%",bindingProperty:"name"},
			{name:"供应商代表",width:"10%",bindingProperty:"personName"},
			{name:"供应商电话",width:"10%",bindingProperty:"phone"},
			{name:"供应商邮箱",width:"10%",bindingProperty:"email"},
			{name:"状态",width:"10%",bindingProperty:"status"},
			{name:'注册日期',width:'10%',bindingProperty:"applyDate"}
		],
		commonOperations:[
			{name:"删除",isAjax:true,callback:function(data){
					houQian.getJson('supplierBasic_delete.action?id='+data.id+getRandParam(), function(){
						supplierTable.refresh();
					});
				}
			}
		],
		specialOperations:[
			{name:"终审",isAjax:true,callback:function(data){
					if(houQian.isNotNull(data)){
						window.location.href="supplier_set_3_review.jsp?id="+data.id;
					}
				}
			}	
		],
		pageCount:pageSize,
		selectType:1
	});
});
</script>
<div id="supplierFinallyTableId" class="small" style="width:100%;position:relative;">

</div>
