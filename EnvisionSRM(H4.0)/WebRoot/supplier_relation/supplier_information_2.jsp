<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
<!--
	$(document).ready(function(e) {
	var supplierTable=new HouQianTable({
		url:"supplierBasic_list.action?status=2",
		parentContainer:"#suppliersInforTableId",
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
					houQian.confirm("确定要删除吗？", function(){
						houQian.getJson('supplierBasic_delete.action?id='+data.id+getRandParam(), function(){
							supplierTable.refresh();
						});
					});
				}
			}
		],
		specialOperations:[
			{name:"终止",isAjax:true,callback:function(data){
					if(houQian.isNotNull(data)){
						dialogOpen($("#stopDivId"),'终止原因',300,500);
						houQian.submitForm($('#stopFormId'),'supplierBasic_stop?id='+data.id, function(){
							dialogClose();
							supplierTable.refresh();
						});
					}
				}
			}	
		],
		pageCount:pageSize,
		selectType:1
	});
});
//-->
</script>
<div id="suppliersInforTableId" class="small" style="width:100%;position:relative;"></div>
<div id="stopDivId" style="margin:0;display:none;">
<br />
 <form id="stopFormId" method="post" action="">
 	<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
      <tr>
        <td align="center" valign="middle" class="td_border">终止原因</td>
     </tr>
     <tr>
        <td align="center" valign="middle" class="td_border">
        <textarea rows="30"  cols="50" name="reason"></textarea>
        </td>
     </tr>
  	</table>
        <table width="100%">
        <tr>
        <td colspan="2" align="center" height="40">
          <input class="crmbutton small save" type="submit" value="保存" style="width:70px"/>&nbsp;
          <input class="crmbutton small cancel" type="reset" value="取消"  onclick="dialogClose()" style="width:70px"/>
        </td>
        </tr>
    </table>
 </form>
</div>