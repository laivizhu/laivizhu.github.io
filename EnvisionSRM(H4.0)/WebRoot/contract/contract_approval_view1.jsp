<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合同管理-采购平台</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript">
$(document).ready(function(e) {
	$("#approval_failed_reason").dialog({
			autoOpen: false,
			title: "审批意见",
			modal:true,
			width:350,
			height:200,
			resizable:false,
		});
});
function contractApproval(){
   var id=$("#returnId").val();
   houQian.confirm('确定审批通过？',function(){
		houQian.getJson('frameContract_confirmPass.action?id='+id+'&status='+'60'+getRandParam(),                         function(result){
			  houQian.alert(result.msg);
			  window.location.href = "contract_approval.jsp#2";
			});
		});
}
function contractDisapproval(){
   var id=$("#returnId").val();
   var contractId=$("#returnContractId").val();
  $("#approval_failed_reason").dialog("open");
						   $("#failedReason").empty();
						   $("#contractId").val(id);
						   $("#failedReason").append("<tr><td class='dvtCellLabel'><b>合同编号</b></td><td class='dvtCellInfo'>"+contractId+"</td></tr><tr><td class='dvtCellLabel'><b>审批意见</b></td><td class='dvtCellInfo'><textarea name='confirmOption' id='confirmOption'></textarea></td></tr>")
}

function saveReason(){
	   var form = $("#addReason");
	   form.ajaxForm({
				url:"frameContract_confirmFailed.action",
				beforeSubmit:validate,
				success:function(returnData){
					alert(returnData.msg);
					$("#approval_failed_reason").dialog("close");
					window.location.href = "contract_approval.jsp#2";
				}
			});
   }
   function validate(formData, jqForm, options){
	 var reason=$("#confirmOption").val();
	 if(reason.length <= 0){
	    alert("审批意见不能为空！");
		return false;
	 }
   }
   function dialogClose1(){
	   $("#approval_failed_reason").dialog("close");
   }
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
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_approval.jsp">合同审批</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 合同审批 &gt; 审批取消合同</td>
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
<input type="hidden" name="returnId" id="returnId" value='<s:property value="#request.contractConcent.id"/>' />
<input type="hidden" name="returnContractId" id="returnContractId" value='<s:property value="#request.contractConcent.contractId"/>' />
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
<td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>审批取消合同</b></td>
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
          <td width="25%"  align="left" class="dvtCellInfo"><s:property value="#request.contractConcent.contractId"/></td>
          <td width="25%" class="dvtCellLabel" align="right">供应商名称</td>
          <td width="25%" align="left" class="dvtCellInfo" id="supplierName"><s:property value="#request.contractConcent.supplierName"/>
          </td>        
        </tr>
        <tr style="height:25px">
          <td width="25%" height="25" class="dvtCellLabel" align="right">采购负责人</td>
          <td width="25%"  align="left" class="dvtCellInfo" id="purchaser"><s:property value="#request.contractConcent.purchaseName"/></td>
          <td width="25%" class="dvtCellLabel" align="right">状态</td>
          <td width="25%" align="left" class="dvtCellInfo" id="status"><s:property value="#request.contractConcent.status"/></td>      
        </tr>
        <tr>
          <td colspan="5" class="detailedViewHeader"><b>主合同条款</b></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" height="25" class="dvtCellLabel" align="right">年度合同类型</td>
          <td colspan="" align="left" class="dvtCellInfo" id="yearContractType"><s:property value="#request.contractConcent.yearContractType"/></td>
          <td colspan="" align="right" class="dvtCellLabel">当前年度合同</td>
          <td colspan="" align="left" class="dvtCellInfo" id="yearContractName"><s:property value="#request.contractConcent.yearContractName"/></td>
        </tr>
        <tr>
           <td colspan="4" class="detailedViewHeader"><b>合同偏差信息</b></td>
        </tr>
        <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">偏差版本号</td>
          <td align="left" class="dvtCellLabel">偏差序号</td>
          <td align="left" class="dvtCellLabel">年度合同协议内容</td>
           <td align="left" class="dvtCellLabel">偏差内容</td>
        </tr>
        <s:if test="#request.diviationList == null || #request.diviationList.size == 0 ">
        <tr style="height:25px">
           <td align="center" height="30px" colspan="4" class="dvtCellInfo">&nbsp;<b>暂无数据！</b>&nbsp;</td>
        </tr>
        </s:if>
        <s:else>
        <s:iterator value="#request.diviationList" id="diviationBean" >
        <tr style="height:25px">
          <td height="25" align="right" class="dvtCellInfo">V<s:property value="#request.contractConcent.diviationVersion"/></td>
          <td height="25" align="left" class="dvtCellInfo"><s:property value="#diviationBean.projectnumber"/></td>
          <td height="25" align="left" class="dvtCellInfo"><textarea rows="2" style="height:50px;" readonly="readonly"><s:property value="#diviationBean.contentold"/></textarea></td>
          <td height="25" align="left" class="dvtCellInfo"><s:property value="#diviationBean.contentnew"/></td>
        </tr>
        </s:iterator>
        </s:else>
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
          <td colspan="2" align="left" class="dvtCellInfo" id="diviationRemark"><s:property value="#request.contractConcent.diviationRemark"/></td>
        </tr>
          <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">保密协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">保密协议.pdf</a></td>
           <td colspan="2" align="left" class="dvtCellInfo" id="secrecyRemark"><s:property value="#request.contractConcent.secrecyRemark"/></td>
        </tr>
          <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">价格协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="price"><s:property value="#request.contractConcent.price"/></td>
           <td colspan="2" align="left" class="dvtCellInfo" id="priceRemark"><s:property value="#request.contractConcent.priceRemark"/></td>
        </tr>
        <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">质量协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="quanlity">
            <s:if test="#request.quanlityList == null || #request.quanlityList.size == 0 ">无</s:if>
            <s:else>
              <s:iterator value="#request.quanlityList" id="attachmentBean" >
                <s:property value="#attachmentBean.attachmentName"/>&nbsp;;&nbsp;
              </s:iterator>
            </s:else>
          </td>
          <td colspan="2" align="left" class="dvtCellInfo" id="quanlityRemark"><s:property value="#request.contractConcent.quanlityRemark"/></td>
        </tr>
         <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">采购说明书</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="purchaseInstruction">
            <s:if test="#request.purchaseInstructionList == null || #request.purchaseInstructionList.size == 0 ">无</s:if>
            <s:else>
              <s:iterator value="#request.purchaseInstructionList" id="attachmentBean" >
                <s:property value="#attachmentBean.attachmentName"/>&nbsp;;&nbsp;
              </s:iterator>
            </s:else>
          </td>
           <td colspan="2" align="left" class="dvtCellInfo" id="purchaseInstructionRemark"><s:property value="#request.contractConcent.purchaseInstructionRemark"/></td>
        </tr>
         <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">技术协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="technology">
            <s:if test="#request.technologyList == null || #request.technologyList.size == 0 ">无</s:if>
            <s:else>
              <s:iterator value="#request.technologyList" id="attachmentBean" >
                <s:property value="#attachmentBean.attachmentName"/>&nbsp;;&nbsp;
              </s:iterator>
            </s:else>
          </td>
           <td colspan="2" align="left" class="dvtCellInfo" id="technologyRemark"><s:property value="#request.contractConcent.technologyRemark"/></td>
        </tr>
         <tr style="height:25px">
          <td height="25" align="right" class="dvtCellLabel">监造协议</td>
          <td colspan="2"  align="left" class="dvtCellInfo" id="supervision">
            <s:if test="#request.supervisionList == null || #request.supervisionList.size == 0 ">无</s:if>
            <s:else>
              <s:iterator value="#request.supervisionList" id="attachmentBean" >
                <s:property value="#attachmentBean.attachmentName"/>&nbsp;;&nbsp;
              </s:iterator>
            </s:else>
          </td>
           <td colspan="2" align="left" class="dvtCellInfo" id="supervisionRemark"><s:property value="#request.contractConcent.supervisionRemark"/></td>
        </tr>
          <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">物流协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="logistic">
            <s:if test="#request.logisticList == null || #request.logisticList.size == 0 ">无</s:if>
            <s:else>
              <s:iterator value="#request.logisticList" id="attachmentBean" >
                <s:property value="#attachmentBean.attachmentName"/>&nbsp;;&nbsp;
              </s:iterator>
            </s:else>
          </td>
           <td colspan="2" align="left" class="dvtCellInfo" id="logisticRemark"><s:property value="#request.contractConcent.logisticRemark"/></td>
        </tr>
        <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">EHS协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="ehs">
            <s:if test="#request.ehsList == null || #request.ehsList.size == 0 ">无</s:if>
            <s:else>
              <s:iterator value="#request.ehsList" id="attachmentBean" >
                <s:property value="#attachmentBean.attachmentName"/>&nbsp;;&nbsp;
              </s:iterator>
            </s:else>
          </td>
           <td colspan="2" align="left" class="dvtCellInfo" id="ehsRemark"><s:property value="#request.contractConcent.ehsRemark"/></td>
        </tr>
        <tr>
          <td width="25%" class="detailedViewHeader"><b>合同取消原因</b></td>
          <td colspan="4"  align="left" class="dvtCellInfo"><s:property value="#request.contractConcent.cancelReason"/></td>
        </tr>
        <tr>
          <td colspan="5" style="padding:5px" height="40"><div align="center">
            <input title="同意 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="contractApproval()" type="button" name="button" value="  同意  " style="width:70px" />
            &nbsp;
            <input title="不同意 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="contractDisapproval()" type="button" name="button" value="不同意  " style="width:70px" />
            &nbsp;
            <input title="返回 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  返回  " style="width:70px" />
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

</div>

</td></tr></tbody></table>

<div id="approval_failed_reason" style="display:none">
<form id="addReason"  method="post">
<input type="hidden" name="id" id="contractId" value="" />
<table id="failedReason" width="100%" border="0" class="small">
</table>  
<table width="100%" border="0" class="small">
<tr><td colspan="2" style="padding:5px" height="40">
<div align="center">
<input title="保存" class="crmbutton small save" onclick="saveReason()" type="submit"  value="  保存  " style="width:70px"/>
&nbsp;
<input title="取消" class="crmbutton small cancel" onclick="dialogClose1()" type="button" value="  取消  " style="width:70px"/>
</div>
</td></tr>
</table>
</form>
</div>
<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>