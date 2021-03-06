<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script language="javascript">
$(document).ready(function(e) {
	var table = new HouQianTable({
					url:"frameContract_list.action?status=10",
					parentContainer:"#approvalDiv",
					columns:[
						{name:"合同编号",width:"15%",bindingProperty:"contractId"},
						{name:"供应商名称",width:"37%",bindingProperty:"suppierId"},
						{name:"采购员",width:"10%",bindingProperty:"userId"},
						{name:"提交审批时间",width:"10%",bindingProperty:"createTime"},
						{name:"合同状态",width:"10%",bindingProperty:"status"},
					],
					commonOperations:[
						{name:"查看",callback:function(data){
						   window.location.href = "contractOperate_view.action?id="+data.id;	
						}},
					],
					specialOperations:[
						{name:"审批",callback:function(data){
						   window.location.href = "contractApproval_view.action?id="+data.id;	
						}},
						
					],
					pageCount:2,
					selectType:1
				});

   });
   
   
</script>


<div id="approvalDiv" class="small" style="width:100%;position:relative;"></div>



