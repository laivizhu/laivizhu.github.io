<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script language="javascript" type="text/javascript">
	$(document).ready(function(e) {
		var table3 = new HouQianTable({
					url:"frameContract_listScanCopy.action?status=20",
					parentContainer:"#div3",
					columns:[
						{name:"合同编号",width:"15%",bindingProperty:"contractId"},
						{name:"供应商名称",width:"22%",bindingProperty:"suppierId"},
						{name:"采购员",width:"10%",bindingProperty:"userId"},
						{name:"审批时间",width:"10%",bindingProperty:"createTime"},
						{name:"合同状态",width:"10%",bindingProperty:"status"},
						{name:"年度合同扫描件",width:"10%",bindingProperty:"yearContract"},
						{name:"偏差协议扫描件",width:"10%",bindingProperty:"diviation"},
						{name:"价格协议扫描件",width:"10%",bindingProperty:"price"},
					],
					specialOperations:[
						{name:"上传",callback:function(data){
						//  if(houQian.isNotNull(data)){
						   window.location.href = "scancopy_upload.jsp?id="+data.id;
						  }
						}
						//}
					],
					pageCount:8,
					selectType:1
				});
	   });
</script>
<div id="div3" class="small" style="width:100%;position:relative;"></div>
