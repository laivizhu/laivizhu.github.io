<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合同管理-采购平台</title>
  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script language="javascript" type="text/javascript" src="../js/HouqianTable.js"></script>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript" type="text/javascript" src="../js/DatePicker/WdatePicker.js"></script>
<script language="javascript">

function check(){
	var begin = $("#begin").val();
	var end = $("#end").val();
	var type = $("#type").val();
    $.getJSON("yearContract_check.action",{begin:""+begin,end:""+end,type:""+type},
		function(data){
			if(data.isUnValidate){
				alert("年度合同起止日期无效");	
			}else{
				document.yearcontract.submit();
			}	
		});
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
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_maincontractlist.jsp">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
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
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 年度合同 &gt; 上传年度合同
    </td>
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
  <td width="100%" align="left" valign="top">
<!-- 内容开始 -->
<div class="contentListDiv">

<form id="yearcontract" name="yearcontract" action="contract_uploadAdd.action" method="post" enctype="multipart/form-data" target="_parent">
<input type="hidden" name="person" value='<s:property value="#session.loginInfo.username"/>' />
<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
<td class="dvtTabCache" style="width:10px" >&nbsp;</td>
<td id="test1" class="dvtSelectedCell" align="center" nowrap="nowrap" style="width:10%">上传年度合同</td>
<td class="dvtTabCache" style="width:100%" >&nbsp;</td>
</tr><tr>
</tr></tbody></table>
</td>
</tr>
<tr>
<td valign="top" align="left">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
<tbody><tr>
<td id="autocom"></td>
</tr>
<tr>
<td >
<!-- General details -->
<table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
<tbody>
  <tr style="height:25px">
    <td width="30%" align="left" class="dvtCellInfo"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
        <tr>
          <td colspan="4" style="padding:5px">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="4" class="detailedViewHeader"><b>年度合同上传信息</b></td>
        </tr>
        <tr style="height:25px">
          <td width="20%" height="33" align="right" class="dvtCellLabel">年度合同名称</td>
          <td width="30%" align="left" class="dvtCellInfo"><input type="text" id="contractname" name="yearcontractBean.name" class="detailedViewTextBox" style="width:60%;" value="" /></td>
          <td width="20%" class="dvtCellLabel" align="right">年度合同附件 </td>
          <td width="80%" align="left" class="dvtCellInfo"><input type="file" name="word_path" tabindex="" class="detailedViewTextBox" style="width:100%;height:24px" value="" /></td>
        </tr>
        <tr style="height:25px">
          <td width="20%" height="31" align="right" class="dvtCellLabel">生效起始日期</td>
          <td width="30%" align="left" class="dvtCellInfo"><input type="text" name="yearcontractBean.begindate" tabindex="" class="Wdate" id="begin" style="width:60%;" value="" onClick="WdatePicker()" />
          </td>
          <td width="20%" class="dvtCellLabel" align="right">生效截止日期 </td>
          <td width="80%" align="left" class="dvtCellInfo"><input type="text" name="yearcontractBean.enddate" tabindex="" class="Wdate" style="width:60%;" id="end" value="" onClick="WdatePicker()" />
          </td>
        </tr>
        <tr style="height:25px">
          <td width="20%" height="31" align="right" class="dvtCellLabel">年度合同模板类型</td>
          <td colspan="3" align="left" class="dvtCellInfo">
            <select name="yearcontractBean.type" id="type" style="width:22%;height:24px">
              <option value="">---请选择模板类型---</option>
              <option value="0">生产性物料年度合同模板</option>
              <option value="1">非生产性物料年度合同模板</option>
            </select>
          </td>
          </tr>
        <tr>
          <td colspan="4" style="padding:5px" height="40"><div align="center">
            <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save"  type="button" value="  保存  " style="width:70px" onclick="check()"/>
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
</form>
</div>
<!-- Basic Information Tab Closed -->
</td>
</tr>

</tbody></table>
<script>
var thisForm = document.yearcontract;
</script>
<!-- 网站底部 -->

<jsp:include page="../common/bottom.jsp" flush="true"/>

</body>
</html>