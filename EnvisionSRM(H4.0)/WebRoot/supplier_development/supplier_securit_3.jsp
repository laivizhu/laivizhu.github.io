<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(
		function(){
			
			var table3 = new HouQianTable({
				url:"securit_list.action?statusType=-1",
				parentContainer:"#div3",
				columns:[
					{name:"供应商编号",width:"10%",bindingProperty:"supplierID"},
					{name:"供应商名称",width:"10%",bindingProperty:"supplierName"},
					{name:"供应商回复标准保密协议",width:"20%",bindingProperty:"standardTemplate",callback:function(data){
						if(data.isStandard == true){
							window.location.href="securit_SupplierReplyDownload.action?id="+data.id;
						}
					}},
					{name:"供应商回复非标准保密协议",width:"25%",bindingProperty:"nonstandardSupplier",callback:function(data){
						if(data.isStandard == false){
							window.location.href="securit_SupplierReplyDownload.action?id="+data.id;
						}
					}},
					{name:"状态",width:"10%",bindingProperty:"state"},
					{name:"生效时间",width:"10%",bindingProperty:"effectTime"},
					{name:"供应商邮箱",width:"12%",bindingProperty:"supplierEmail"}
				],
				specialOperations:[
					{name:"查看保密协议",callback:CheckSecurit}
				],
				pageCount:10,
				selectType:1
			});
		}
	);
	
	function CheckSecurit(data){
	   window.location="securit_check.action?id="+data.id;
	}
</script>


<div id="div3" class="small" style="width:100%;position:relative;display:none"></div>
