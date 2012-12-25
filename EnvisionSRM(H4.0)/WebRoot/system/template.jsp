<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>模板管理</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<jsp:include page="../common/basicInclude.jsp" />
	<script language="javascript" type="text/javascript" src="../js/system/template.js"></script>
	<script language="javascript" type="text/javascript" src="../js/system/securitTemplate.js"></script>
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="#">用户查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="#">人员管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="#">角色管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="#">权限管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="#">工作台管理</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="template.jsp">模板管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="#">数据同步</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap">您现在的位置： 系统管理 &gt; 模板管理</td>
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
<div id="tabs" class="content_tab">

<div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab1" class="content_tab_title_selected" align="center" onclick="showTab(1,3);">管理文件模板</td>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab2" class="content_tab_title_unselected" align="center" onclick="showTab(2,3);">标准保密协议模板</td>
    <td class="content_tab_title_cache" style="width:100%"></td>
  </tr></tbody></table>
</div>

<div class="content_tab_detail">
  <!-- 管理文件模板 -->
  <div id="div1" class="content_tab_div_selected"><div id="searchBox">
      <form id="searcMaterialCategory" method="post" action="#">
    	  <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
        <tbody><tr>
        <td></td>
        <td align="left" nowrap="nowrap">
            <span class="search_title">搜索 - 文件模板</span></td>
        <td nowrap="nowrap" align="right" valign="middle">
            <b> 在</b>&nbsp;
            <select name="searchCondition" class="search_input"  style="width:120px">
                <option value="name" selected="selected">模板类型</option>
                <option value="createTime">模板名称</option>
                <option value="modifyTime">创建时间</option>
            </select>
            <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找&nbsp;&nbsp;&nbsp;&nbsp;</b>
            <input type="text" name="keyword" class="search_input" style="width:150px" />&nbsp;&nbsp;
            <input name="submit" type="button" value=" 立刻查找 " class="search_button"/>
        </td>
        <td></td>
      </tr></tbody></table>
      </form>
  </div><div style="height:20px;"></div>

  <div id="templateTableDivId" style="width:99%"></div>
  <div style="margin-top:14px;"></div>
  
  </div>
  
  <!-- 标准保密协议模板 Mars -->
  <div id="div2" class="content_tab_div_unselected">
  <div id="searchBox">
  <form id="searcMaterialCategory" method="post" action="#">
  <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
    <td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 文件模板</span></td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b> 在</b>&nbsp;
        <select name="searchCondition" class="search_input"  style="width:120px">
            <option value="name" selected="selected">模板类型</option>
            <option value="createTime">模板名称</option>
            <option value="modifyTime">创建时间</option>
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
  <div id="securitTemplateTableDivId" style="width:99%"></div>
  </div>
  
</div>

</div>
</td>
</tr></tbody></table>






<div id="addTemplateDivId" style="margin:0;display:none;">
<br />
 <form id="addTemplateFormId" method="post" action="">
 	<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
       <tr>
        <td width="30%" align="right" valign="middle" class="td_border">模板类型：</td>
        <td width="70%" align="left" valign="middle" class="td_border">
        <select name="template.templateType" id="templateSelectID" style="width:90%;">
        </select>
        </td>
     </tr>
     <tr>
        <td align="right" valign="middle" class="td_border">模板名称：</td>
        <td align="left" valign="middle" class="td_border">
        <input  type="text" size="25" maxlength="25" style="width:89%;" name="template.name"/></td>
     </tr>
     <tr>
        <td width="30%" align="right" valign="middle" class="td_border">模板文件：</td>
        <td width="70%" align="left" valign="middle" class="td_border">
        	<input type="file" name="file"/>
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








<!-- 添加标准保密协议模板 Mars -->
<div id="addSecuritTemplateDivId" style="margin:0;display:none;">
<br />
 <form id="addSecuritTemplateFormId" method="post" enctype="multipart/form-data" action="">
 	<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
     <tr>
        <td align="right" valign="middle" class="td_border">模板名称：</td>
        <td align="left" valign="middle" class="td_border">
        <input  type="text" size="25" maxlength="25" style="width:89%;" name="securitTemplateBean.templateName"/></td>
     </tr>
     <tr>
        <td width="30%" align="right" valign="middle" class="td_border">模板文件：</td>
        <td width="70%" align="left" valign="middle" class="td_border">
        	<input type="file" name="upload"/>
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