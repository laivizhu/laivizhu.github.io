<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>物料类别管理</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <jsp:include page="../common/basicInclude.jsp"/>
  <script language="javascript" type="text/javascript" src="../js/material/material_common.js"></script>
  <script language="javascript" type="text/javascript" src="../js/material/category.js"></script>
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
      <td class="level2SelTab" nowrap="nowrap"><a href="category.jsp">物料类别设置</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="material_main.jsp">物料主数据查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="expenditure.jsp">物料支出分析</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="sourcing.jsp">类别管理七步法</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:15px" nowrap="nowrap">您现在的位置： 物料管理 &gt; 物料类别设置 </td>
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
    <td id="tab1" class="content_tab_title_selected" align="center" onclick="showTab(1,4);">新建类别</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab2" class="content_tab_title_unselected" align="center" onclick="showTab(2,4);">新建类别关联</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab3" class="content_tab_title_unselected" align="center" onclick="showTab(3,4);">新建SAP物料号关联</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab4" class="content_tab_title_unselected" align="center" onclick="showTab(4,4);">查询类别关联</td>
    <td class="content_tab_title_cache" style="width:100%"></td>
  </tr></tbody></table>
  </div>
  
  <div class="content_tab_detail">
  <div id="div1" class="content_tab_div_selected">
  <div id="searchBox">
  <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
    <td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 物料类别</span>
    </td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b>在</b>&nbsp;
        <select id="categoryASearchConditionId" name="searchCondition" class="search_input"  style="width:120px">
        </select>
        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找&nbsp;&nbsp;&nbsp;&nbsp;</b>
        <input type="text" name="keyword" class="search_input" style="width:150px" id="categoryKeywordId"/>&nbsp;&nbsp;
        <input type="button" value=" 立刻查找 " class="search_button" onclick="categorySearch()"/>
	</td>
    <td></td>
  </tr></tbody></table>
  </div>
  <div style="height:20px;"></div>
  
  <div id="categoryTableId" style="width:99%">
  </div>
  
  </div>

  <div id="div2" class="content_tab_div_unselected">
  <div id="searchBox">
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
        <input type="text" name="keyword" class="search_input" style="width:150px" id="materialCategoryKeywordId"/>&nbsp;&nbsp;
        <input name="submit" type="button" value=" 立刻查找 " class="search_button" onclick="categorySearch()"/>
	</td>
    <td></td>
  </tr></tbody></table>
  </div>
  <div style="height:20px;"></div>
  
  <div id="categoryListTableId" style="width:99%">
  </div>
  
  </div>
  
  <div id="div3" class="content_tab_div_unselected">
  
  <div id="searchBox">
  <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
    <td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 物料</span>
    </td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b>在</b>&nbsp;
        <select id="codeSearchConditionId" name="searchCondition" class="search_input"  style="width:120px">
        </select>
        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找&nbsp;&nbsp;&nbsp;&nbsp;</b>
        <input type="text" name="keyword" class="search_input" style="width:150px" />&nbsp;&nbsp;
        <input name="submit" type="button" value=" 立刻查找 " class="search_button"/>
	</td>
    <td></td>
  </tr></tbody></table>
  </div>
  <div style="height:20px;"></div>
  <div id="codeListTableId" style="width:99%">
  </div>
  </div>
  
  <div id="div4" class="content_tab_div_unselected">
  
  <div id="searchBox">
  <form method="post" action="#">
  <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
    <td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 物料</span>
    </td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b>在</b>&nbsp;
        <select id="codeSearchConditionTab4Id" name="searchCondition" class="search_input"  style="width:120px">
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
  <div id="searchCodeListTableId" style="width:99%">
  </div>
  </div>
  
 <!--End of content_tabl_detail-->
 </div>
<!--End of content_tab-->
</div>  
</td></tr></tbody></table>
<div id="SAPCode" style="margin:0;display:none;">
<br />
 <form id='SAPCodeSetRelationFormId' method="post" action="materialCode_setCodeRelation.action">
 	<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
 	  <tr>
        <td align="right" valign="middle" class="td_border">SAP物料号：</td>
        <td align="left" valign="middle" class="td_border">
        <input type="text" size="25" maxlength="25" style="width:30%;" name="materialCode.code" id="materialCodeCodeId" onblur="showResult()"/>
        <label id="materialCodeLabelId"></label>
        </td>
      </tr>
      <tr>
        <td width="40%" align="right" valign="middle" class="td_border">物料分类：</td>
        <td width="60%" align="left" valign="middle" class="td_border">
        <select name="classify" id="materialCodeCategoryClassifyID" style="width:90%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="40%" align="right" valign="middle" class="td_border">物料类别：</td>
        <td width="60%" align="left" valign="middle" class="td_border">
        <select name="category" id="materialCodeCategoryID" style="width:90%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="40%" align="right" valign="middle" class="td_border">物料子类别：</td>
        <td width="60%" align="left" valign="middle" class="td_border">
        <select name="subCategory" id="materialCodeSubCategoryID" style="width:90%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="40%" align="right" valign="middle" class="td_border">物料小组：</td>
        <td width="60%" align="left" valign="middle" class="td_border">
        <select name="categoryValue" id="materialCodeTeamID" style="width:90%;">
        </select>
        </td>
     </tr>
  	</table>
        <table width="100%">
        <tr>
        <td colspan="2" align="center" height="40">
          <input class="crmbutton small save" type="submit" value="保存"  style="width:70px"/>&nbsp;
          <input class="crmbutton small cancel" type="reset" value="取消"  onclick="dialogClose()" style="width:70px"/>
        </td>
        </tr>
    </table>
 </form>
</div>

<div id="categoryAdd" style="margin:0;display:none;">
<br />
 <form id="materialCategoryAddFormId" method="post" action="materialCategory_add.action">
 	<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
      <tr>
        <td width="30%" align="right" valign="middle" class="td_border">类别：</td>
        <td width="70%" align="left" valign="middle" class="td_border">
        <select name="materialCategory.categoryType" id="categorySelectID" style="width:90%;">
        </select>
        </td>
     </tr>
     <tr>
        <td align="right" valign="middle" class="td_border">类别名称：</td>
        <td align="left" valign="middle" class="td_border">
        <input id="materialCategoryInputNameId" type="text" size="25" maxlength="25" style="width:89%;" name="materialCategory.name"/></td>
     </tr>
  	</table>
        <table width="100%">
        <tr>
        <td colspan="2" align="center" height="40">
          <input class="crmbutton small save" type="submit" value="保存" style="width:70px"/>&nbsp;
          <input class="crmbutton small cancel" type="reset" value="取消"  onclick="dialogClose()" style="width:70px"/>
        </td>
        </tr>
    </table>
 </form>
</div>

<div id="categoryRelationAdd" style="margin:0;display:none;">
<br />
 <form id="categoryRelationAddFormId" name="" method="post" action="materialCategory_settingRelation.action">
 	<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
      <tr>
        <td width="40%" align="right" valign="middle" class="td_border">物料分类：</td>
        <td width="60%" align="left" valign="middle" class="td_border">
        <select name="classify" id="materialCategoryClassifyID" style="width:90%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="40%" align="right" valign="middle" class="td_border">物料类别：</td>
        <td width="60%" align="left" valign="middle" class="td_border">
        <select name="category" id="materialCategoryID" style="width:90%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="40%" align="right" valign="middle" class="td_border">物料子类别：</td>
        <td width="60%" align="left" valign="middle" class="td_border">
        <select name="subCategory" id="materialSubCategoryID" style="width:90%;">
        </select>
        </td>
     </tr>
     <tr>
        <td width="40%" align="right" valign="middle" class="td_border">物料小组：</td>
        <td width="60%" align="left" valign="middle" class="td_border">
        <select name="team" id="materialTeamID" style="width:90%;">
        </select>
        </td>
     </tr>
  	</table>
        <table width="100%">
        <tr>
       <td colspan="2" align="center" height="40">
          <input class="crmbutton small save" type="submit" value="保存" style="width:70px"/>&nbsp;
          <input class="crmbutton small cancel" type="reset" value="取消"  onclick="dialogClose()" style="width:70px"/>
        </td>
        </tr>
    </table>
 </form>

</div>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/> 
</body>
</html>

