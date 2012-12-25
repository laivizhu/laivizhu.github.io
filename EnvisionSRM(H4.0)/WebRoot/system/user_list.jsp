<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>角色分配</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/common.css"/>
  <link rel="stylesheet" type="text/css" href="../css/content.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/HouqianTable.js"></script>
  <script language="javascript" type="text/javascript">
  $(document).ready(function(){
	var table = new HouQianTable({
		url:"user_list.action",
		parentContainer:"#list",
		columns:[
			{name:"工号",width:"10%",bindingProperty:"workNumber"},
			{name:"登录账号",width:"15%",bindingProperty:"loginAccount"},
			{name:"姓名",width:"10%",bindingProperty:"name"},
			{name:"电子邮件",width:"15%",bindingProperty:"email"},
			{name:"办公电话",width:"10%",bindingProperty:"telephone"},
			{name:"手机",width:"10%",bindingProperty:"mobile"},
			{name:"部门",width:"10%",bindingProperty:"department"},
			{name:"职位",width:"10%",bindingProperty:"position"}					
		],
		commonOperations:[
			{name:"查看",callback:function(data){
				alert(data.name);
			}},
			{name:"授权",callback:function(data){
				alert(data.name);
			
			}},
		],
		
		pageCount:8,
		selectType:0
	});
    });
  
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
    <td class="level2SelTab" nowrap="nowrap"> <a href="user_list.jsp" target="_self">角色分配</a></td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="role_list.jsp" target="_self">角色管理</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 系统管理 &gt; 角色分配</td>
	<td width="100%">&nbsp;</td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>

<!-- 公告列表 -->
	
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">

<div class="contentListDiv">
<div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td class="content_tab_title_selected" align="center">用户管理</td>
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
        <span class="search_title">搜索 - 用户</span>
    </td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b>在</b>&nbsp;
        <select name="searchCondition" class="search_input"  style="width:120px">
            <option value="name" selected="selected">登录账号</option>
            <option value="createTime">工号</option>
            <option value="createTime">姓名</option>
            <option value="modifyTime">电子邮件</option>
            <option value="modifyTime">办公电话</option>
            <option value="modifyTime">手机</option>
            <option value="modifyTime">部门</option>
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

<div id="list" style="width:99%; margin:0 auto;">

</div>

</div>
<jsp:include page="../common/bottom.jsp" flush="true"/>
  
</div>
  </td>
</tr></tbody>
</table>

<!-- 网站底部 -->
</body>
</html>


