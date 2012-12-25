<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>物料支出分析</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <jsp:include page="../common/basicInclude.jsp"/>
  
  
  <!-- cehn add script -->
  <script language="javascript" type="text/javascript" src="../js/material/material_common.js"></script>
  <script language="javascript" type="text/javascript" src="../js/material/expenditure.js"></script>
  <script language="javascript" type="text/javascript" src="../js/material/chart.js"></script>
  <script language="javascript" type="text/javascript" src="../js/highcharts.js"></script>
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="material_main.jsp">物料主数据查询</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="expenditure.jsp">物料支出分析</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="sourcing.jsp">类别管理七步法</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap">您现在的位置： 物料管理 &gt; 物料支出分析</td>
  <td width="100%">&nbsp;</td>
  <td align="right" style="padding-right:15px;">
  	<jsp:include page="../common/toolbar.jsp" flush="true"/>
  </td>
</tr></tbody>
</table>

<!-- Content -->	
<table width="100%" class="content_background" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody><tr>
<td width="100%" align="left" valign="top">
<!-- 内容开始 -->
<div id="tabs" class="content_tab">


<div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="2" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab1" class="content_tab_title_selected" align="center" onclick="showTab(1,2);">类别支出图表输出</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab2" class="content_tab_title_unselected" align="center" onclick="showTab(2,2);">类别支出报表输出</td>
    <td class="content_tab_title_cache" style="width:100%"></td>
  </tr></tbody></table>
</div>

<!-- 
<div id="categoryChartTableId" style="width:99%">

  </div>
 -->
<div id="div1" class="content_tab_div_selected" style="margin:0;">
<br />
 <form id="categoryChoiceFormId" name="" method="post" action="materialExpenditure_categoryChoice.action">
     <table width="100%" align="center" cellpadding="3" cellspacing="0">
      <tr>
        <td class="detailedViewHeader"><b>类别支出报表输出</b></td>
      </tr>
    </table>
 	<table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
     <tr>
        <td width="37%" align="right" class="dvtCellLabel">物料分类：</td>
        <td width="63%" align="left" class="dvtCellInfo">
        <select name="classify" id="materialCategoryClassifyID" style="width:40%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="37%" align="right" class="dvtCellLabel">物料类别：</td>
        <td width="63%" align="left" class="dvtCellInfo">
        <select name="category" id="materialCategoryID" style="width:40%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="37%" align="right" class="dvtCellLabel">物料子类别：</td>
        <td width="63%" align="left" class="dvtCellInfo">
        <select name="subCategory" id="materialSubCategoryID" style="width:40%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="37%" align="right" class="dvtCellLabel">物料小组：</td>
        <td width="63%" align="left" class="dvtCellInfo">
        <select name="team" id="materialTeamID" style="width:40%;">
        </select>
        </td>
     </tr>
  	</table>
    <table width="100%">
        <tr>
       <td colspan="2" align="center" height="40">
          <!-- <input class="search_button" type="submit" value="立即查找" style="width:70px"/>&nbsp; -->
          <input type="button" value=" 立刻查找 " class="search_button" onclick="categoryExpenditureChartSearch()"/>
        </td>
        </tr>
    </table>
 </form>
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>物料货源地/物料数量占比</b></td>
  </tr></table>
		<div id="container1" align="center" style="min-width:800px;height: 400px; margin: 0 auto"></div>
		
		  <table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>物料货源地/金额占比</b></td>
  </tr></table>
		<div id="container2" align="center" style="min-width: 800px; height: 400px; margin: 0 auto"></div>
		
	<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>物料累计占比</b></td>
    </tr></table>
		<div id="container3" align="center"  style="min-width: 800px; height: 400px; margin: 0 auto"></div>
		
	<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>供应商支出及累计占比</b></td>
  </tr></table>
		<div id="container4" align="center" style="min-width: 800px; height: 400px; margin: 0 auto"></div>
  
</div>
 
 


<div id="div2" class="content_tab_div_unselected" style="margin:0;">
<br />
 <form id="categoryChoiceFormId" name="" method="post" action="materialExpenditure_categoryChoice.action">
     <table width="100%" align="center" cellpadding="3" cellspacing="0">
      <tr>
        <td class="detailedViewHeader"><b>类别支出报表输出</b></td>
      </tr>
    </table>
 	<table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
     <tr>
        <td width="37%" align="right" class="dvtCellLabel">物料分类：</td>
        <td width="63%" align="left" class="dvtCellInfo">
        <select name="classify" id="materialCategoryClassifyID2" style="width:40%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="37%" align="right" class="dvtCellLabel">物料类别：</td>
        <td width="63%" align="left" class="dvtCellInfo">
        <select name="category" id="materialCategoryID2" style="width:40%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="37%" align="right" class="dvtCellLabel">物料子类别：</td>
        <td width="63%" align="left" class="dvtCellInfo">
        <select name="subCategory" id="materialSubCategoryID2" style="width:40%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="37%" align="right" class="dvtCellLabel">物料小组：</td>
        <td width="63%" align="left" class="dvtCellInfo">
        <select name="team" id="materialTeamID2" style="width:40%;">
        </select>
        </td>
     </tr>
  	</table>
    <table width="100%">
        <tr>
       <td colspan="2" align="center" height="40">
          <input type="button" value=" 立刻查找 " class="search_button" onclick="categoryExpenditureReportSearch()"/>
        </td>
        </tr>
    </table>
 </form>
	<!--  add there -->
	<div id="materialReportTableId" style="width:99%">

  </div>
</div>
</div> 
</td>
</tr>
</tbody>
</table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/> 
</body>
</html>