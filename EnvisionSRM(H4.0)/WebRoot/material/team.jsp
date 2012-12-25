<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>物料类别管理</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/content.css"/>
  <link rel="stylesheet" type="text/css" href="../css/common.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
  <script language="javascript" type="text/javascript">
  	$(document).ready(function(e) {
        $("#GroupAdd").dialog({
			autoOpen:false,
			title:"新增物料小组",
			width:500,
			height:300,
			modal:true,
			resizable:false
		});
		$("input[name='GroupAdd']").click(function(){
			$("body").css("overflow","hidden");
			$("#GroupAdd").dialog("open");
		});
		
    });
  
  </script>
</head>

<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级导航 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
<tbody><tr>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="category.jsp" target="_self">物料类别设置</a></td>
    <td class="level2SelTab" nowrap="nowrap"> <a href="team.jsp" target="_self">类别团队设置</a></td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="#" target="_self">物料主数据</a></td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="#" target="_self">物料类别查询</a></td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="#" target="_self">物料支出分析</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:15px; white-space:nowrap">您现在的位置： 物料管理 &gt; 物料小组设置 &gt; 物料小组列表</td>
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
<div class="content_list">
 <div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab1" class="content_tab_title_selected" align="center">物料小组设置</td>
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
        <span class="search_title">搜索 - 物料小组</span>
    </td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b>在</b>&nbsp;
        <select name="searchCondition" class="search_input"  style="width:120px">
            <option value="name" selected="selected">小组ID</option>
            <option value="createTime">小组名称</option>
            <option value="createTime">所属类别</option>
            <option value="modifyTime">创建时间</option>
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
  <div style="height:20px;"></div>
  
 
  <table border="0" cellspacing="0" cellpadding="2" width="100%"><tr>

    <td width="20%" style="white-space:nowrap;">
      <input name="GroupAdd" class="crmbutton small edit" type="button" value="新增小组"/>
	<td width="60%" align="center" nowrap="nowrap">
    共 10 页，
    <a href="#"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a>
    &nbsp;当前第&nbsp;1&nbsp;页&nbsp;
    <a href="#"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a>
	</td>
    <td width="20%" align="right" style="padding-right:15px; white-space:nowrap;">每页显示 10 条记录</td>	
  </tr></table>
  <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
	  
      	<!-- List Content Title -->
        <tr>

          <td width="10%" height="25" align="left" class="lvtCol">小组ID</td>
          <td width="25%" align="left" class="lvtCol">小组名称</td>
          <td width="20%" align="left" class="lvtCol">所属类别</td>
          <td width="10%" align="left" class="lvtCol">小组负责人</td>
          <td width="10%" align="left" class="lvtCol">创建时间</td>
          <td width="10%" align="left" class="lvtCol">修改时间</td>
          <td width="15%" align="left" class="lvtCol">操作</td>
        </tr>
        
        <div id="list">
        <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">

          <td height="19" align="left" >5000001</td>
          <td align="left" >定制紧固件物料小组</td>
          <td align="left" >定制紧固件</td>
          <td align="left">张三</td>
          <td align="left" >2012-10-10</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看&nbsp;|&nbsp;修改&nbsp;|&nbsp;删除</td>
        </tr>
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">

          <td height="19" align="left" >5000002</td>
          <td align="left" >定制塑料件物料小组</td>
          <td align="left" >定制塑料件</td>
          <td align="left">关羽</td>
          <td align="left" >2012-10-10</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看&nbsp;|&nbsp;修改&nbsp;|&nbsp;删除</td>
        </tr>
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">

          <td height="19" align="left" >5000003</td>
          <td align="left" >焊接钣金件（发电机底座）物料小组</td>
          <td align="left" >焊接钣金件</td>
          <td align="left">曹操</td>
          <td align="left" >2012-10-10</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看&nbsp;|&nbsp;修改&nbsp;|&nbsp;删除</td>
        </tr>
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">

          <td height="19" align="left" >5000004</td>
          <td align="left" >焊接钣金件（非铝合金）物料小组</td>
          <td align="left" >焊接钣金件</td>
          <td align="left">刘备</td>
          <td align="left" >2012-10-10</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看&nbsp;|&nbsp;修改&nbsp;|&nbsp;删除</td>
        </tr>
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">

          <td height="19" align="left" >5000005</td>
          <td align="left" >焊接钣金件（铝合金）物料小组</td>
          <td align="left" >焊接钣金件</td>
          <td align="left">张翼德</td>
          <td align="left" >2012-10-10</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看&nbsp;|&nbsp;修改&nbsp;|&nbsp;删除</td>
        </tr>
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">

          <td height="19" align="left" >5000006</td>
          <td align="left" >塔筒物料小组</td>
          <td align="left" >塔筒</td>
          <td align="left">关云长</td>
          <td align="left" >2012-10-10</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看&nbsp;|&nbsp;修改&nbsp;|&nbsp;删除</td>
        </tr>
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">

          <td height="19" align="left" >5000007</td>
          <td align="left" >贴字物料小组</td>
          <td align="left" >贴字</td>
          <td align="left">李四</td>
          <td align="left" >2012-10-10</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看&nbsp;|&nbsp;修改&nbsp;|&nbsp;删除</td>
        </tr>
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">

          <td height="19" align="left" >5000008</td>
          <td align="left" >油管&amp;接头物料小组</td>
          <td align="left" >油管&amp;接头</td>
          <td align="left">王五</td>
          <td align="left" >2012-10-10</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看&nbsp;|&nbsp;修改&nbsp;|&nbsp;删除</td>
        </tr>
        
        </div>
        
      
	  </table>
  <table border="0" cellspacing="0" cellpadding="2" width="100%"><tr>

    <td width="20%" style="white-space:nowrap;">
      <input name="GroupAdd" class="crmbutton small edit" type="button" value="新增小组"/>
    </td>
	<td width="60%" align="center" nowrap="nowrap">
    共 10 页，
    <a href="#"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a>
    &nbsp;当前第&nbsp;1&nbsp;页&nbsp;
    <a href="#"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a>
	</td>
    <td width="20%" align="right" style="padding-right:15px; white-space:nowrap;">每页显示 10 条记录</td>	
  </tr></table>
</div>

</div>
  
  
</td></tr></tbody></table>
<div id="GroupAdd" style="margin:0;display:none;">
<br />
<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="30%" align="right" valign="middle" class="td_border">物料类别：</td>
    <td width="70%" align="left" valign="middle" class="td_border">
    <select name="select" id="select" style="width:80%;">
    	<option value="1" >请选择类别</option>
    </select>
    </td>
    </tr>
  <tr>
    <td align="right" valign="middle" class="td_border">小组名称：</td>
    <td align="left" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" style="width:79%;" /></td>
    </tr>
  <tr>
  <tr>
    <td align="right" valign="middle" class="td_border">负责人：</td>
    <td align="left" valign="middle" class="td_border">
    <input type="text" size="25" maxlength="25" style="width:79%;" />
    <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" align="absmiddle" style="cursor:hand;cursor:pointer"/> 
    <img src="../images/clear.gif" alt="清除" title="清除" align="absmiddle" style="cursor:hand;cursor:pointer" />
    </td>
    </tr>
  <tr>
  <tr>
    <td align="right" valign="middle" class="td_border">成员：</td>
    <td align="left" valign="middle" class="td_border">
    <input type="text" size="25" maxlength="25" style="width:79%;" />
    <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" align="absmiddle" style="cursor:hand;cursor:pointer"/> 
    <img src="../images/clear.gif" alt="清除" title="清除" align="absmiddle" style="cursor:hand;cursor:pointer" />
    </td>
    </tr>
  <tr>
    <td align="right" valign="middle" class="td_border">小组描述：</td>
    <td align="left" valign="middle" class="td_border"><textarea name="textarea12" rows="5" class="textarea_style" style="width:80%;"></textarea></td>
  </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
</td>
</tr>
</table>
</div>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>