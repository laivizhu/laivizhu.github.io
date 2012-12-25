<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript" type="text/javascript" src="../js/HouqianTable.js"></script>
<script type="text/javascript">
	$(document).ready(
		function(){
			var table2 = new HouQianTable({
				url:"supplierPortalSecurit_supplierList.action?statusType=0",
				parentContainer:"#div1",
				columns:[
					{name:"供应商编号",width:"10%",bindingProperty:"supplierID"},
					{name:"供应商名称",width:"10%",bindingProperty:"supplierName"},
					{name:"标准报名协议模板名称",width:"20%" ,bindingProperty:"standardTemplate",callback:function(data){
						if(data.standardTemplate!='空'){
							window.location.href="supplierPortalSecurit_standardDownload.action?id="+data.id;
						}
						
					}},
					{name:"非标准保密协议名称",width:"25%",bindingProperty:"nonstandardTemplate",callback:function(data){
						if(data.nonStandardTemplate!='空'){	
							window.location.href="supplierPortalSecurit_nonStandardDownload.action?id="+data.id;
						}
					}},
					{name:"状态",width:"10%",bindingProperty:"state"},
					{name:"新建时间",width:"10%",bindingProperty:"newTime"},
					{name:"供应商邮箱",width:"15%",bindingProperty:"supplierEmail"}
				],
				pageCount:10,
				selectType:0
			});
		}
	);

</script>


<div id="div1" class="small" style="width:100%;position:relative;"></div>
