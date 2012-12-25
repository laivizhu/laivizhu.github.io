<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>外部公告列表</title>
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
		url:"noticeOuter_list.action",
		parentContainer:"#list",
		columns:[
		   {name:"公告ID",width:"7%",bindingProperty:"id"},
			{name:"公告标题",width:"30%",bindingProperty:"title"},
			{name:"公告类型",width:"10%",bindingProperty:"type"},
			{name:"发布部门",width:"10%",bindingProperty:"department"},
			{name:"修改时间",width:"10%",bindingProperty:"modifyTime"},
			{name:"附件",width:"18%",bindingProperty:"attachment",callback:function(data){
				if(data.attchment != "")
					window.location.href = "noticeOuter_download.action?id="+data.id;
			}}				
		],
		commonOperations:[
			{name:"查看",callback:function(data){
				window.location.href = 'notice_outer_view.jsp?id='+data.id;	
			}},
			{name:"修改",callback:function(data){
				window.location.href = 'notice_outer_modify.jsp?id='+data.id;	
			}},
			{name:"删除",callback:function(data){
				if(window.confirm("确认删除？"))
				{
					$.getJSON("noticeOuter_delete.action?id="+data.id,function(returnData){
						if(returnData.success)
						{
							window.alert(returnData.msg);
							window.location.reload();
						}
					});
				}	
			}}
		],
		specialOperations:[
			{name:"新增",callback:function(data){
				window.location.href = 'notice_outer_add.jsp';
			}}
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
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="notice_inner_list.jsp" target="_self">内部公告</a></td>
    <td class="level2SelTab" nowrap="nowrap"> <a href="notice_outer_list.jsp" target="_self">外部公告</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 信息中心 &gt; 外部公告 &gt; 公告列表 </td>
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
    <td class="content_tab_title_selected" align="center">外部公告</td>
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
        <span class="search_title">搜索 - 外部公告</span>
    </td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b>在</b>&nbsp;
        <select name="searchCondition" class="search_input"  style="width:120px">
            <option value="name" selected="selected">公告ID</option>
            <option value="createTime">公告标题</option>
            <option value="createTime">创建时间</option>
            <option value="modifyTime">修改时间</option>
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

<div id="list" style="width:99%; margin:auto auto;"></div>


</div>
  
</div>
  </td>
</tr></tbody>
</table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>


