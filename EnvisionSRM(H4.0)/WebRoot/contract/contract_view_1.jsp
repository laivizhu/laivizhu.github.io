<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合同管理-采购平台</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript">
$(document).ready(function(e) {
	var contractId = $("#contractId");
	var id = window.location.href.split("=")[1];
	$.getJSON("frameContract_get.action?id=" + id+"&time="+Math.random(),function(returnData){
		    $("#contractId").html(returnData.contractId);
		    $("#supplierName").html(returnData.supplierName);
			$("#purchaser").html(returnData.purchaseName);
			$("#status").html(returnData.status);
			$("#yearContractType").html(returnData.yearContractType);
			$("#yearContractName").html(returnData.yearContractName);
			$("#priceRemark").html(returnData.priceRemark);
			$("#diviationRemark").html(returnData.diviationRemark);
			$("#quanlityRemark").html(returnData.quanlityRemark);
			$("#purchaseInstructionRemark").html(returnData.purchaseInstructionRemark);
			$("#technologyRemark").html(returnData.technologyRemark);
			$("#supervisionRemark").html(returnData.supervisionRemark);
			$("#logisticRemark").html(returnData.logisticRemark);
			$("#ehsRemark").html(returnData.ehsRemark);
			
			$("#price").html(returnData.price);
			//alert(returnData.gson.length);
			
			for(var i = 0; i <returnData.gson.length;i++){
				var array = returnData.gson[i];//取得一种协议
				var pact="";
				if(0==i){
				for(var j=0; j<array.length;j++){
					var obj = array[j];
				    pact=obj.quanlity+','+pact;
				}
				$("#quanlity").html(pact);
				}
				if(1==i){
				for(var j=0; j<array.length;j++){
					var obj = array[j];
				    pact=obj.purchaseInstruction+','+pact;
				}
				$("#purchaseInstruction").html(pact);
				}
				if(2==i){
				for(var j=0; j<array.length;j++){
					var obj = array[j];
				    pact=obj.technology+','+pact;
				}
				$("#technology").html(pact);
				}
				if(3==i){
				for(var j=0; j<array.length;j++){
					var obj = array[j];
				    pact=obj.supervision+','+pact;
				}
				$("#supervision").html(pact);
				}
				if(4==i){
				for(var j=0; j<array.length;j++){
					var obj = array[j];
				    pact=obj.logistic+','+pact;
				}
				$("#logistic").html(pact);
				}
				if(5==i){
				for(var j=0; j<array.length;j++){
					var obj = array[j];
				    pact=obj.ehs+','+pact;
				}
				$("#ehs").html(pact);
				}
			}
		});
    });
</script>
</head>

<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>

<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>

<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
<tbody><tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_maincontractlist.jsp">年度合同模板</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">合同查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 框架合同 &gt; 查看框架合同</td>
	<td width="100%" align="center">&nbsp;</td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>


<!-- 网站中部 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top" style="padding-left:10px; padding-top:20px;" >
<!-- -->
<div class="small">
<form name="EditView" method="" action="" onsubmit="">

<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
<td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>框架合同 信息</b></td>
<td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
</tr><tr>
</tr></tbody></table>
</td>
</tr>
<tr>
<td valign="top" align="left">

<div id="basicTab" style="display: block; ">

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
<tbody><tr>
<td align="left">


<table border="0" cellspacing="0" cellpadding="0" width="100%">
<tbody><tr>
<td id="autocom"></td>
</tr>
<tr>
<td style="padding:10px">
<!-- General details -->
<table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
<tbody>
  <tr style="height:25px">
    <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
      
        <tr>
          <td colspan="5" class="detailedViewHeader"><b>合同基本信息</b></td>
        </tr>
        <tr style="height:25px">
          <td width="25%" height="25" class="dvtCellLabel" align="right">合同编号</td>
          <td width="25%"  align="left" class="dvtCellInfo" id="contractId">&nbsp;</td>
          <td width="25%" class="dvtCellLabel" align="right">供应商名称</td>
          <td width="25%" align="left" class="dvtCellInfo" id="supplierName">&nbsp;
          </td>
          <!-- Non Editable field, only configured value will be loaded -->         
        </tr>
        <tr style="height:25px">
          <td width="25%" height="25" class="dvtCellLabel" align="right">采购负责人</td>
          <td width="25%"  align="left" class="dvtCellInfo" id="purchaser">&nbsp;</td>
          <td width="25%" class="dvtCellLabel" align="right">状态</td>
          <td width="25%" align="left" class="dvtCellInfo" id="status">&nbsp;</td>
          <!-- Non Editable field, only configured value will be loaded -->         
        </tr>
        <tr>
          <td colspan="5" class="detailedViewHeader"><b>主合同条款</b></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" height="25" class="dvtCellLabel" align="right">年度合同类型</td>
          <td colspan="" align="left" class="dvtCellInfo" id="yearContractType"></td>
          <td colspan="" align="right" class="dvtCellLabel">当前年度合同</td>
          <td colspan="" align="left" class="dvtCellInfo" id="yearContractName"></td>
        </tr>
         <tr>
          <td colspan="5" class="detailedViewHeader"><b>合同附件信息</b></td>
        </tr>
          <tr style="height:25px">
          <td width="20%" height="25" align="right" class="dvtCellLabel"></td>
          <td width="30%" colspan="2" align="left" class="dvtCellInfo"><b>附件信息</b></td>
          <td width="30%" colspan="2" align="left" class="dvtCellInfo"><b>备注说明</b></td>
          
        </tr>
         <tr style="height:25px">
          <td height="469" align="right" class="dvtCellLabel">偏差</td>
          <td colspan="2" align="left" class="dvtCellInfo">
           <a href="javascript:diviationView()">查看偏差</a>
          </td>
          <td colspan="2" align="left" class="dvtCellInfo" id="diviationRemark">&nbsp;</td>
        </tr>
          <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">保密协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">保密协议.pdf</a></td>
           <td colspan="2" align="left" class="dvtCellInfo" id="secrecyRemark">&nbsp;</td>
        </tr>
          <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">价格协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="price">&nbsp;</td>
           <td colspan="2" align="left" class="dvtCellInfo" id="priceRemark">&nbsp;</td>
        </tr>
          <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">质量协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="quanlity">&nbsp;</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="quanlityRemark">&nbsp;</td>
        </tr>
         <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">采购说明书</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="purchaseInstruction">&nbsp;</td>
           <td colspan="2" align="left" class="dvtCellInfo" id="purchaseInstructionRemark">&nbsp;</td>
        </tr>
         <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">技术协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="technology">&nbsp;</td>
           <td colspan="2" align="left" class="dvtCellInfo" id="technologyRemark">&nbsp;</td>
        </tr>
         <tr style="height:25px">
          <td height="25" align="right" class="dvtCellLabel">监造协议</td>
          <td colspan="2"  align="left" class="dvtCellInfo" id="supervision">&nbsp;</td>
           <td colspan="2" align="left" class="dvtCellInfo" id="supervisionRemark">&nbsp;</td>
        </tr>
          <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">物流协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="logistic">&nbsp;</td>
           <td colspan="2" align="left" class="dvtCellInfo" id="logisticRemark">&nbsp;</td>
        </tr>
        <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">EHS协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="ehs">&nbsp;</td>
           <td colspan="2" align="left" class="dvtCellInfo" id="ehsRemark">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="5" style="padding:5px" height="40"><div align="center">
            <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  返回  " style="width:70px" />
          </div></td>
        </tr>
      </tbody>
    </table>      <span id="assign_user" style="display:block"></span></td>
  </tr>
</tbody></table></td>
</tr>
</tbody></table>
</td>
</tr>
</tbody></table>
</div>
<!-- Basic Information Tab Closed -->

  </td></tr>
  </tbody></table>
</form>
</div>

</td></tr></tbody></table>

<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>