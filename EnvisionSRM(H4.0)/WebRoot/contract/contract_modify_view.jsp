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
		$("#diviationEdit").dialog({
			autoOpen: false,
			title: "偏差编辑",
			modal:true,
			width:800,
			height:500,
			resizable:false,
            
		});
		
		$("#diviation_changeId").dialog({
			autoOpen: false,
		//	title: "新增偏差",
			modal:true,
			width:800,
			height:500,
			resizable:false,
            
		});
		
		$("#diviation_insertId").dialog({
			autoOpen: false,
		//	title: "新增偏差",
			modal:true,
			width:800,
			height:500,
			resizable:false,   
		});
		
		$("#submitBtn").click(function(){
			var form = $("#contractModifyForm");
			form.ajaxForm({
				async: false,//async:false 同步请求
				url:"frameContract_contractModify.action",
				//beforeSubmit:validate,
				//dataType:"json",
				success:function(returnData){
					var data = $.parseJSON(returnData);
					alert(data.msg);
					window.location.href = "contract_modify.jsp";
				}
			});
		});
    });

function modifyDiviation(){
   var dialog = $("#diviationEdit");
   dialog.dialog("open");
   $("#diviation_changeId").dialog("close");
   $("#diviation_insertId").dialog("close");
   var id10 = $("#diviation0").val();
   var yearContractId=$("#yearContract0").val();
   $.getJSON("yearContract_diviationModify.action",{id:""+id10,diviationId:""+yearContractId,rand:Math.random()},
		 function(data){
		   $("#diviationList").empty();
		   $("#diviationList").append("<tr class='detailedViewHeader'><td width='15%' height='30'><b>序号</b></td><td width='40%'><b>预览</b></td><td width='40%'><b>偏差</b></td><td width='5%'><b>操作</b></td></tr>");
		   $.each(data.root,function(i,item){
		   $("#diviationList").append("<tr><td class='dvtCellInfo'>"+item.projectnumber+"</td><td class='dvtCellInfo'>"+item.contentold+"</td><td class='dvtCellInfo'><textarea class='textarea_style'>"+item.contentnew+"</textarea></td><td class='dvtCellInfo'><a href='#' onclick='diviationDelete("+item.id+")'>删除</a></td></tr>");
			});
		 
		 });
		 
}
	
function showDiviationEditDialog()
{
		var dialog = $("#diviationEdit");
		var id10 = $("#yearContract0").val();
		dialog.dialog("open");
		$("#diviation_changeId").dialog("close");
		$("#diviation_insertId").dialog("close");
		$.getJSON("yearContract_diviationList.action",{id:""+id10,rand:Math.random()},
		 function(data){
		  $("#diviationList").empty();
		  $("#diviationList").append("<tr class='detailedViewHeader'><td width='15%' height='30'><b>序号</b></td><td width='40%'><b>预览</b></td><td width='40%'><b>偏差</b></td><td width='5%'><b>操作</b></td></tr>");
		  $.each(data.root,function(i,item){
			$("#diviationList").append("<tr><td class='dvtCellInfo'>"+item.projectnumber+"</td><td class='dvtCellInfo'>"+item.contentold+"</td><td class='dvtCellInfo'><textarea class='textarea_style'>"+item.contentnew+"</textarea></td><td class='dvtCellInfo'><a href='#' onclick='diviationDelete("+item.id+")'>删除</a></td></tr>");
			});
		});	
}

 function showDiviationChangeDialog()
 {
	var dialog = $("#diviationEdit");
	dialog.dialog("open");
	$("#diviation_changeId").dialog("close");
	$("#diviation_insertId").dialog("close");
	var id = $("#yearContract0").val();
	var projectnum=$("#diviationid").val();
	var contentold=$("#wordcontent").val();
	var contentnew=$("#diviationContent").val();
	$.getJSON("yearContract_diviationSave.action",{id:""+id,projectnum:""+projectnum,contentold:encodeURI(""+contentold,"utf-8"),contentnew:""+encodeURI(contentnew,"utf-8"),rand:Math.random()},
		function(data){
			  showDiviationEditDialog();
		});	
	
 }
 function showDiviationInsertDialog(){
	 var dialog = $("#diviationEdit");
	dialog.dialog("open");
	$("#diviation_changeId").dialog("close");
	$("#diviation_insertId").dialog("close");
	var id = $("#yearContract0").val();
	var projectnum=$("#newid").val();
	var contentold="";
	var contentnew=$("#diviationContent1").val();
	$.getJSON("yearContract_diviationInsertSave.action",{id:""+id,projectnum:""+projectnum,contentold:encodeURI(""+contentold,"utf-8"),contentnew:""+encodeURI(contentnew,"utf-8"),rand:Math.random()},
		function(data){
			  $("#diviationList").html(""); 
			  $("#diviationList").append("<tr class='detailedViewHeader'><td width='15%' height='30'><b>序号</b></td><td width='40%'><b>预览</b></td><td width='40%'><b>偏差</b></td><td width='5%'><b>操作</b></td></tr>");
			  showDiviationEditDialog();
		});	
 }
 function diviationDelete(id){
	 $.getJSON("yearContract_diviationDelete.action",{id:""+id,rand:Math.random()},
		     function(data){
			  showDiviationEditDialog();
			});	
 }
//新增偏差
function changediviation(){
    $("#diviationEdit").dialog("close");
    $("#diviation_changeId").dialog("open");
	var id = $("#yearContract0").val();
    $.getJSON("yearContract_diviationAdd.action",{id:""+id,rand:Math.random()},
		function(data){
			$("#diviationid").empty();
			$.each(data.root,function(i,item){
					$("#diviationid").append("<option value='"+item.projectnumber+"'>"+item.projectnumber+"</option>");
				});
		});	
}
function changedetail()
{
  projectnum=$("#diviationid").val();
  var id = $("#yearContract0").val();
  $.getJSON("yearContract_wordcontentGet.action",{id:""+id,projectnum:""+projectnum,rand:Math.random()},
		function(data){
			$("#wordcontent").val(data.wordContent);
		});	

}
//插入偏差
function insertdiviation(){
    $("#diviationEdit").dialog("close");
    $("#diviation_insertId").dialog("open");	
	var id = $("#yearContract0").val();
    $.getJSON("yearContract_diviationInsert.action",{id:""+id,rand:Math.random()},
		function(data){
			$("#diviationid1").empty();
			$.each(data.root,function(i,item){
					$("#diviationid1").append("<option value='"+item.projectnumber+"'>"+item.projectnumber+"</option>");
				});
		});	
}
function changediviationid(){
  projectnum=$("#diviationid1").val();
  var id = $("#yearContract0").val();
  $.getJSON("yearContract_newIdGet.action",{id:""+id,projectnum:""+projectnum,rand:Math.random()},
		function(data){
			$("#newid").val(data.newId);
		});	
}
//保存
function confirmDiviation(){
    $("#diviationEdit").dialog("close");
    $("#diviation_changeId").dialog("close");
    $("#diviation_insertId").dialog("close");
	var name="偏差V02";
	var id = $("#yearContract0").val();
    var supplierId=$("#supplierInputId").val();
	var version="02";
	$.getJSON("yearContract_diviationHeadSave.action",{id:""+id,projectnum:""+version,supplierId:""+supplierId,rand:Math.random()},
		function(data){
			$("#diviationHead").val(data.diviationId);
			$("#diviationName").val(name);
		});	
}
function diviationCancel(){
    $("#diviationEdit").dialog("open");
    $("#diviation_changeId").dialog("close");
    $("#diviation_insertId").dialog("close");
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_maincontractlist.jsp">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 合同变更 </td>
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
<form id="contractModifyForm" method="post" enctype="multipart/form-data" >
<input type="hidden" name="id" id="id" value='<s:property value="#request.contractConcent.id"/>' />
<input type="hidden" name="diviationId0" id="diviation0" value='<s:property value="#request.contractConcent.diviationId"/>' />
<input type="hidden" name="diviationId1" id="diviation1" value="" />
<input type="hidden" name="contractId0" id="contractId0" value='<s:property value="#request.contractConcent.contractId"/>' />
<input type="hidden" name="supplierInputId" id="supplierInputId" value='<s:property value="#request.contractConcent.supplierId"/>' />
<input type="hidden" name="yearContract0" id="yearContract0" value='<s:property value="#request.contractConcent.yearContractId"/>' />
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
<td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>合同变更</b></td>
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
          <td width="25%"  align="left" class="dvtCellInfo" id="contractId"><s:property value="#request.contractConcent.contractId"/></td>
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
          <input type="hidden" name="diviationHead" id="diviationHead" value="" />
            <input type="text" style="width:250px" name="diviationName" id="diviationName" value="" readonly="readonly"/>&nbsp;&nbsp;&nbsp;
            <input type="button" value="编辑偏差" style="font-size:12px;height:22px;" onclick="modifyDiviation()"/>
          </td>
          <td colspan="2" align="left" class="dvtCellInfo" id="diviationRemark"><input type="text" name="diviationRemark" id="diviationRemark" style="width:80%" value='<s:property value="#request.contractConcent.diviationRemark"/>' /></td>
        </tr>
          <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">保密协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">保密协议.pdf</a></td>
           <td colspan="2" align="left" class="dvtCellInfo" id="secrecyRemark"><s:property value="#request.contractConcent.secrecyRemark"/></td>
        </tr>
          <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">价格协议</td>
          <td align="left" class="dvtCellInfo" ><s:property value="#request.contractConcent.price"/></td>
          <td align="left" class="dvtCellInfo" ><input type="file" name="price" id="price" class="detailedViewTextBox" style="width:400px; height:22px" value="" /></td>
           <td colspan="2" align="left" class="dvtCellInfo" id="priceRemark">
             <input type="text" name="priceRemark" id="priceRemark2" style="width:80%" value='<s:property value="#request.contractConcent.priceRemark"/>' /></td>
        </tr>
        <tr style="height:25px">
          <td height="25" class="dvtCellLabel" align="right">质量协议</td>
          <td colspan="2" align="left" class="dvtCellInfo" id="quanlity">
            <s:if test="#request.quanlityList == null || #request.quanlityList.size == 0 ">无</s:if>
            <s:else>
              <s:iterator value="#request.quanlityList" id="attachmentBean" >
                <s:property value="#attachmentBean.attachmentName"/>&nbsp;;&nbsp;
              </s:iterator>
            </s:else></td>
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
          <td colspan="5" style="padding:5px" height="40"><div align="center">
            <input id="submitBtn" title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="" type="submit" name="button" value="  保存  " style="width:70px" />
            &nbsp;
            <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  取消  " style="width:70px" />
          </div></td>
        </tr>
      </tbody>
    </table></td>
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
<div id="diviationEdit" style="display:none">
 <jsp:include page="diviation_edit.jsp" flush="true"/>
</div> 
<div id="diviation_changeId" style="display:none">
 <jsp:include page="diviation_change.jsp" flush="true"/>
</div> 
<div id="diviation_insertId" style="display:none">
 <jsp:include page="diviation_insert.jsp" flush="true"/>
</div> 
<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>