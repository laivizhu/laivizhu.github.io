<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合理化建议列表</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/common.css"/>
  <link rel="stylesheet" type="text/css" href="../css/content.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_performance.jsp">供应商日常绩效管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_monthManage.jsp">供应商月度绩效评价</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="complaint_list.jsp">供应商投诉</a> </td>
      <td class="level2SelTab" nowrap="nowrap"><a href="advice_list.jsp">供应商合理化建议</a></td>
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
  <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 供应商日常管理 &gt; 合理化建议 &gt; 合理化建议列表 </td>
  <td width="100%">&nbsp;</td>
  <td align="right" style="padding-right:15px;">
  	<jsp:include page="../common/toolbar.jsp" flush="true"/>
  </td>
</tr></tbody>
</table>

<!-- 列表 -->	
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" ><tbody><tr><td width="100%" align="left" valign="top">
<div class="contentListDiv">
<div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td class="content_tab_title_selected" align="center">合理化建议</td>
    <td class="content_tab_title_cache" style="width:100%"></td>
  </tr></tbody></table>
  </div>
  
<div class="content_tab_detail">
<div id="searchBox">
  <form id="searcMaterialCategory" method="post" action="#">
  <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
    <td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 合理化建议</span>
    </td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b>在</b>&nbsp;
        <select name="searchCondition" class="search_input"  style="width:120px">
            <option value="name" selected="selected">建议ID</option>
            <option value="createTime">建议标题</option>
            <option value="createTime">提出者</option>
            <option value="modifyTime">提出时间</option>
        </select>
        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找&nbsp;&nbsp;&nbsp;&nbsp;</b>
        <input type="text" name="keyword" class="search_input" style="width:150px" />&nbsp;&nbsp;
        <input name="submit" type="button" value=" 立刻查找 " class="search_button"/>
	</td>
    <td></td>
  </tr></tbody></table>
  </form>
  </div>

<div style="height:25px;">&nbsp;</div>

<table width="98%" align="center" border="0" cellspacing="0" cellpadding="2"  class="small">
<tbody><tr>
<td width="20%" height="20">&nbsp;</td>
<td width="60%" align="center" nowrap="nowrap">
共 2 页，
<a href="#" style="text-decoration:none;"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a>
&nbsp;当前第&nbsp;1&nbsp;页&nbsp;
<a href="#" style="text-decoration:none;"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a>
</td>
<td width="20%" align="right">每页显示 8 条记录</td>	
</tr></tbody>
</table>

<table width="98%" align="center" border="0" cellspacing="1" cellpadding="3"  class="lvt small"><tbody>

  <tr>
	<td width="10%" height="25" align="left" class="lvtCol">建议ID</td>
	<td width="25%" align="left" class="lvtCol">建议标题</td>
	<td width="10%" align="left" class="lvtCol">提出者</td>
	<td width="10%" align="left" class="lvtCol">提出时间</td>
	<td width="10%" align="left" class="lvtCol">是否受理</td>
	<td width="10%" align="left" class="lvtCol">是否处理</td>
	<td width="10%" align="left" class="lvtCol">是否反馈</td>
	<td width="15%" align="left" class="lvtCol">操作</td>
  </tr>


<tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
  <td height="19" align="left" >3001</td>
  <td align="left" >缩短审核时间</td>
  <td align="left" >关云长</td>
  <td align="left" >2012-12-09</td>
  <td align="left" >已受理</td>
  <td align="left" >未处理</td>
  <td align="left" >未反馈</td>
  <td align="left" >查看&nbsp;|&nbsp;受理&nbsp;|&nbsp;处理&nbsp;|&nbsp;删除
  </td>
</tr>
<tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
  <td height="19" align="left" >3002</td>
  <td align="left" >合理化建议1</td>
  <td align="left" >诸葛亮</td>
  <td align="left" >2012-12-09</td>
  <td align="left" >已受理</td>
  <td align="left" >未处理</td>
  <td align="left" >未反馈</td>
  <td align="left" >查看&nbsp;|&nbsp;受理&nbsp;|&nbsp;处理&nbsp;|&nbsp;删除</td>
</tr>
<tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
  <td height="19" align="left" >3003</td>
  <td align="left" >合理化建议2</td>
  <td align="left" >张翼德</td>
  <td align="left" >2012-12-09</td>
  <td align="left" >已受理</td>
  <td align="left" >未处理</td>
  <td align="left" >未反馈</td>
  <td align="left" >查看&nbsp;|&nbsp;受理&nbsp;|&nbsp;处理&nbsp;|&nbsp;删除</td>
</tr>
<tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
  <td height="19" align="left" >3003</td>
  <td align="left" >合理化建议3</td>
  <td align="left" >诸葛亮</td>
  <td align="left" >2012-12-09</td>
  <td align="left" >已受理</td>
  <td align="left" >未处理</td>
  <td align="left" >未反馈</td>
  <td align="left" >查看&nbsp;|&nbsp;受理&nbsp;|&nbsp;处理&nbsp;|&nbsp;删除</td>
</tr>
<tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
  <td height="19" align="left" >3003</td>
  <td align="left" >合理化建议4</td>
  <td align="left" >诸葛亮</td>
  <td align="left" >2012-12-09</td>
  <td align="left" >已受理</td>
  <td align="left" >未处理</td>
  <td align="left" >未反馈</td>
  <td align="left" >查看&nbsp;|&nbsp;受理&nbsp;|&nbsp;处理&nbsp;|&nbsp;删除</td>
</tr>
<tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
  <td height="19" align="left" >3003</td>
  <td align="left" >合理化建议5</td>
  <td align="left" >诸葛亮</td>
  <td align="left" >2012-12-09</td>
  <td align="left" >已受理</td>
  <td align="left" >未处理</td>
  <td align="left" >未反馈</td>
  <td align="left" >查看&nbsp;|&nbsp;受理&nbsp;|&nbsp;处理&nbsp;|&nbsp;删除</td>
</tr>
<tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
  <td height="19" align="left" >3003</td>
  <td align="left" >合理化建议6</td>
  <td align="left" >诸葛亮</td>
  <td align="left" >2012-12-09</td>
  <td align="left" >已受理</td>
  <td align="left" >未处理</td>
  <td align="left" >未反馈</td>
  <td align="left" >查看&nbsp;|&nbsp;受理&nbsp;|&nbsp;处理&nbsp;|&nbsp;删除</td>
</tr>
<tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
  <td height="19" align="left" >3003</td>
  <td align="left" >合理化建议7</td>
  <td align="left" >诸葛亮</td>
  <td align="left" >2012-12-09</td>
  <td align="left" >已受理</td>
  <td align="left" >未处理</td>
  <td align="left" >未反馈</td>
  <td align="left" >查看&nbsp;|&nbsp;受理&nbsp;|&nbsp;处理&nbsp;|&nbsp;删除</td>
</tr>
        
</tbody></table>

<table width="98%" align="center" border="0" cellspacing="0" cellpadding="2"  class="small">
<tbody><tr>
<td width="20%" height="20">&nbsp;</td>
<td width="60%" align="center" nowrap="nowrap">
共 2 页，
<a href="#" style="text-decoration:none;"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a>
&nbsp;当前第&nbsp;1&nbsp;页&nbsp;
<a href="#" style="text-decoration:none;"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a>
</td>
<td width="20%" align="right">每页显示 8 条记录</td>	
</tr></tbody>
</table>

</div>
</div>
  
</td></tr></tbody></table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>


