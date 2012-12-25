<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>供应商基本信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp"/>
<script language="javascript" type="text/javascript" src="../js/supplier/supplier_information.js"></script>

</head>
<body class="small" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0"  rightmargin="0" bottommargin="0">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_importance.jsp">物料重要性分析</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_attraction.jsp">相对吸引力分析</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_subdivide.jsp">供应商关系细分分析</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_annual.jsp">供应商年度评价</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_distinguish.jsp">供应商区分及策略</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="supplier_information.jsp">供应商信息维护</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap"> 您现在的位置：供应商日常管理 &gt; 供应商信息维护</td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>

<!-- 工作台 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
  <tbody>
    <tr>
      <td width="100%" align="left" valign="top" id="supplierInformationTabDiv">
		<!-- 内容开始 --> 
        
      </td>
    </tr>
  </tbody>
</table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
