<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>日程提醒</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.0.custom.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
</head>

<body class="small" style="margin:0px;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
<tbody><tr>
    <td class="level2UnSelTab" nowrap="nowrap"><a href="index.jsp">首页</a></td>
    <td class="level2SelTab" nowrap="nowrap"> <a href="schedule.jsp">日程提醒</a> </td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:15px" nowrap="nowrap">您现在的位置： 工作台 &gt; 日程提醒</td>
  <td width="100%" align="center" valign="middle"></td>
  <td align="right" style="padding-right:15px;">
  	<jsp:include page="../common/toolbar.jsp" flush="true"/>
  </td>  
</tr></tbody>
</table>

<!--  -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody><tr><td width="100%" align="left" valign="top" >
  	<div style="margin:auto; width:90%; height:400px; text-align:center; padding-top:40px;">
	<h1>页面建设中……</h1>
    </div>
</td></tr></tbody></table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
