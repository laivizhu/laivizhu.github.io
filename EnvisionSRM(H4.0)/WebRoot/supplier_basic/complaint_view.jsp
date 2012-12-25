<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>投诉列表-信息中心</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
</head>
<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_performance.jsp">供应商日常绩效管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_monthManage.jsp">供应商月度绩效评价</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="complaint_list.jsp">供应商投诉</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="advice_list.jsp">供应商合理化建议</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_report.jsp">供应商改善对策报告</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_terrace.jsp">供应商质量管理平台</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_document.jsp">供应商质量文档中心</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap">您现在的位置： 供应商日常管理 &gt; 供应商投诉 &gt; 查看投诉</td>
	<td width="100%" align="center">&nbsp;</td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>

<!-- 内容 -->
	
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">
  <!-- 内容开始 -->
<div class="contentViewDiv">
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody>
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>投诉标题</b></td>
  </tr>
  <tr>
	<td width="15%" class="dvtCellLabel" align="right">标题</td>
	<td width="85%" align="left" class="dvtCellInfo">
		<s:property value='#request.complaint.title'/>
	</td>
  </tr>
  
  <tr>
  	<td width="100%" height="20" colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>投诉内容</b></td>
  </tr>
  
  <tr>
	<td align="right" class="dvtCellLabel">内容</td>
	<td align="left"  valign="top" class="dvtCellInfo" style="padding-top:5px; padding-bottom:5px;">
    	<s:property value='#request.complaint.detail'/>
    </td>
  </tr>
  
  <tr>
  	<td width="100%" height="20" colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>受理信息</b></td>
  </tr>
  
  <tr>
	<td align="right" class="dvtCellLabel">受理状态：</td>
	<td align="left" class="dvtCellInfo">
    	<s:property value='#request.complaint.acceptStatus == false?"未受理":"已受理"'/>
    </td>
  </tr>
  
  <s:if test="#request.complaint.acceptStatus == true">
  <tr>
	<td align="right" class="dvtCellLabel">受理人：</td>
	<td align="left" class="dvtCellInfo">
    	<s:property value='#request.complaint.acceptUser'/>
    </td>
  </tr>
  </s:if>
  
   <tr>
  	<td width="100%" height="20" colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>处理信息</b></td>
  </tr>
  
  <tr>
	<td align="right" class="dvtCellLabel">处理状态：</td>
	<td align="left" class="dvtCellInfo">
    	<s:property value='#request.complaint.disposeStatus == false?"未处理":"已处理"'/>
    </td>
  </tr>
  
  <s:if test="#request.complaint.disposeStatus == true">
  <tr>
	<td align="right" class="dvtCellLabel">处理结果：</td>
	<td align="left" class="dvtCellInfo">
    	<s:property value='#request.complaint.dispose'/>
    </td>
  </tr>
  </s:if>
  
  <tr>
  	<td width="100%" height="20" colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>反馈信息</b></td>
  </tr>
  
  <tr>
	<td align="right" class="dvtCellLabel">反馈状态：</td>
	<td align="left" class="dvtCellInfo">
    	<s:property value='#request.complaint.feedbackStatus == false?"未反馈":"已反馈"'/>
    </td>
  </tr>
  
  <s:if test="#request.complaint.feedbackStatus == true">
  <tr>
	<td align="right" class="dvtCellLabel">反馈结果：</td>
	<td align="left" class="dvtCellInfo">
    	<s:property value='#request.complaint.feedback'/>
    </td>
  </tr>
  </s:if>
  
  <tr>
	<td colspan="3" align="center" width="100%" height="40" style="padding-right:20px;">
	  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="   返回  " style="width:70px"/>
	</td>
  </tr>
</tbody></table>
</div>
  
  </td>
</tr></tbody>
</table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>


