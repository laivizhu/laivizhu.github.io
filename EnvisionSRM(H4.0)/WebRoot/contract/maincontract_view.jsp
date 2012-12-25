<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合同管理-采购平台</title>
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript">


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
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 年度合同 &gt; 查看年度合同
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
<!-- -->
<div class="contentViewDiv">
<form id="yearcontract" action="yearcontractUpload.action" method="post" >
<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
<td class="dvtTabCache" style="width:10px" >&nbsp;</td>
<td id="test1" class="dvtSelectedCell" align="center" nowrap="nowrap" style="width:10%">年度合同信息</td>
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
          <td colspan="4" class="detailedViewHeader"><b>年度合同详细信息</b></td>
        </tr>
        <s:if test="#request.yearcontractContentList == null || #request.yearcontractContentList.size == 0 ">
        <tr style="height:25px">
        	<td align="center" height="30px" colspan="2" class="dvtCellLabel">&nbsp;<b>暂无数据！</b>&nbsp;</td>
        </tr>
        </s:if>
        <s:else>
        <s:iterator value="#request.yearcontractContentList" id="yearcontractContent" >
          <tr style="height:25px">
             <td width="7%" height="25" align="left" class="dvtCellLabel"><s:property value="#yearcontractContent.projectnumber"/></td>
             <td width="93%" align="left" class="dvtCellInfo"><s:property value="#yearcontractContent.wordcontent"/></td>
          </tr>
        </s:iterator>
        </s:else>
        <tr>
          <td colspan="2" style="padding:5px" height="40"><div align="center">
            <input title="返回[Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  返回  " style="width:70px" />
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

<!-- 网站底部 -->

<jsp:include page="../common/bottom.jsp" flush="true"/>

</body>
</html>