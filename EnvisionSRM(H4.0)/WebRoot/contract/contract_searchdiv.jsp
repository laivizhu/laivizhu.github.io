<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript" type="text/javascript">
	$(document).ready(function(e) {
		var table4 = new HouQianTable({
					url:"frameContract_list.action?status="+"",
					parentContainer:"#div4",
					columns:[
						{name:"合同编号",width:"15%",bindingProperty:"contractId"},
						{name:"供应商名称",width:"37%",bindingProperty:"suppierId"},
						{name:"采购员",width:"10%",bindingProperty:"userId"},
						{name:"创建时间",width:"10%",bindingProperty:"createTime"},
						{name:"合同状态",width:"10%",bindingProperty:"status"},
					],
					commonOperations:[
						{name:"查看",callback:function(data){
						   window.location.href = "contractOperate_view.action?id="+data.id;
						}},
						
					],
					
					pageCount:8,
					selectType:0
				});

    });
</script>


<div id="div4" class="small" style="width:100%;position:relative;">

</div>
