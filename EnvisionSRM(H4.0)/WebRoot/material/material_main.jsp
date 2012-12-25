<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>物料主数据查询</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <jsp:include page="../common/basicInclude.jsp"/>
  <script language="javascript" type="text/javascript" src="../js/material/material_common.js"></script>
  <script language="javascript" type="text/javascript" src="../js/material/material_main.js"></script>
</head>

<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级导航 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="category.jsp">物料类别设置</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="material_main.jsp">物料主数据查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="expenditure.jsp">物料支出分析</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="sourcing.jsp">类别管理七步法</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:15px" nowrap="nowrap">您现在的位置： 物料管理 &gt; 物料主数据查询 </td>
  <td width="100%">&nbsp;</td>
  <td align="right" style="padding-right:15px;">
  	<jsp:include page="../common/toolbar.jsp" flush="true"/>
  </td>
</tr></tbody>
</table>

<!-- Content -->	
<table width="100%" class="content_background" cellpadding="0" cellspacing="0" border="0" align="center" ><tbody><tr>
<td width="100%" align="left" valign="top">
<!-- 内容开始 -->
<div class="content_tab_fixed">

  <div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab1" class="content_tab_title_selected" align="center" onclick="showTab(1,1);">查询 物料主数据</td>
    <td class="content_tab_title_cache" style="width:100%"></td>
  </tr></tbody></table>
  </div>
  
  <div class="content_tab_detail">
  <div id="div1" class="content_tab_div_selected">
  <div id="searchBox">
  <form id="searcMaterialCategory" method="post" action="#">
  <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
    <td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 物料类别</span>
    </td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b>在</b>&nbsp;
        <select id="categorySearchConditionId" name="searchCondition" class="search_input"  style="width:120px">
        </select>
        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找&nbsp;&nbsp;&nbsp;&nbsp;</b>
        <input type="text" name="keyword" class="search_input" style="width:150px" />&nbsp;&nbsp;
        <input name="submit" type="button" value=" 立刻查找 " class="search_button"/>
	</td>
    <td></td>
  </tr></tbody></table>
  </form>
  </div>
  <div style="height:20px;"></div>
  
  <div id="codeTableId" style="width:99%">
  </div>
  
  </div>

 <!--End of content_tabl_detail-->
 </div>
<!--End of content_tab-->
</div>  
</td></tr></tbody></table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/> 
</body>
</html>

