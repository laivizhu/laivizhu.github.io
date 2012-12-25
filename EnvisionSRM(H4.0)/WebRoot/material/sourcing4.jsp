<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>4.分析供应市场</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/content.css"/>
  <link rel="stylesheet" type="text/css" href="../css/common.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
  <script language="javascript" type="text/javascript" src="../js/common.js"></script>
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="expenditure.jsp">物料支出分析</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="sourcing.jsp">类别管理七步法</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap">您现在的位置： 采购项目管理 &gt; 类别管理七步法 &gt; 4.分析供应市场</td>
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
<div style="padding-left:15px;">
  <a href="sourcing.jsp" target="_self">1.&nbsp;分析类别支出</a> &gt; 
  <a href="sourcing2.jsp" target="_self">2.&nbsp;分析采购需求</a> &gt;
  <a href="sourcing3.jsp" target="_self">3.&nbsp;组建类别团队</a> &gt;
  <a href="sourcing4.jsp" target="_self" style="font-weight:bold;">4.&nbsp;分析供应市场</a> &gt;
  <a href="sourcing5.jsp" target="_self">5.&nbsp;制定类别策略</a> &gt;
  <a href="sourcing6.jsp" target="_self">6.&nbsp;制定实施计划</a> &gt;
  <a href="sourcing7.jsp" target="_self">7.&nbsp;查询方案进度</a>
</div>
<hr style="width:98%; margin-top:10px; margin-bottom:10px;"  />
<!-- Content Tab Tabs -->
<div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab1" class="content_tab_title_selected" align="center" onclick="showTab(1,4);">供应市场信息库</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab2" class="content_tab_title_unselected" align="center" onclick="showTab(2,4);">价值链分析</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab3" class="content_tab_title_unselected" align="center" onclick="showTab(3,4);">波特五力分析</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab4" class="content_tab_title_unselected" align="center" onclick="showTab(4,4);">SWOT分析</td>
    <td class="content_tab_title_cache" style="width:100%"></td>
  </tr></tbody></table>
</div>

<!-- Content Tab Divs -->
<div class="content_tab_detail">
    <div id="div1" class="content_tab_div_selected">
   <div id="searchBox">
  <form id="searcMaterialCategory" method="post" action="#">
  <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
  	<td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 文件</span>
    </td>
	<td nowrap="nowrap" align="center" valign="middle">
        <b>在</b>&nbsp;
        <select name="searchCondition" class="search_input"  style="width:120px">
            <option value="name" selected="selected">文件ID</option>
            <option value="createTime">文件名称</option>
            <option value="createTime">文件简介</option>
           
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
  
  
  <table border="0" cellspacing="0" cellpadding="2" width="100%">
    <tr>
    <td width="20%" height="25" style=" white-space:nowrap;"><input class="crmbutton small edit" type="button" value="上传"/>
	<td width="60%" align="center" nowrap="nowrap">
    共 10 页，
    <a href="#"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a>
    &nbsp;当前第&nbsp;1&nbsp;页&nbsp;
    <a href="#"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a>
	</td>
    <td width="20%" align="right" style="padding-right:15px; white-space:nowrap;">每页显示 6 条记录</td>	
  </tr></table>
  <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
	  
      	<!-- List Content Title -->
        <tr>
         
          <td width="10%" align="left" class="lvtCol">文件ID</td>
          <td width="25%" align="left" class="lvtCol">文件名称</td>
          <td width="30%" align="left" class="lvtCol">文件简介</td>
          <td width="10%" align="left" class="lvtCol">上传人</td>
          <td width="10%" align="left" class="lvtCol">上传时间</td>
          <td width="15%" align="left" class="lvtCol">操作</td>
        </tr>
        
        <div id="list">
        <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
          
          <td align="left" height="19" >1000001</td>
          <td align="left" >市场最新调查报告</td>
          <td align="left" >对市场上最新的调查报告</td>
          <td align="left" >张飞</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看 | 下载 | 删除</td>
        </tr>
        <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
          <td height="19" align="left" >1000002</td>
          <td align="left" >市场最新调查报告2</td>
          <td align="left" >对市场上最新的调查报告</td>
          <td align="left" >关羽</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看 | 下载 | 删除</td>
        </tr>
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
          <td height="19" align="left" >1000002</td>
          <td align="left" >市场最新调查报告2</td>
          <td align="left" >对市场上最新的调查报告</td>
          <td align="left" >关羽</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看 | 下载 | 删除</td>
        </tr> 
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
          <td height="19" align="left" >1000002</td>
          <td align="left" >市场最新调查报告2</td>
          <td align="left" >对市场上最新的调查报告</td>
          <td align="left" >关羽</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看 | 下载 | 删除</td>
        </tr> 
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
          <td height="19" align="left" >1000002</td>
          <td align="left" >市场最新调查报告2</td>
          <td align="left" >对市场上最新的调查报告</td>
          <td align="left" >关羽</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看 | 下载 | 删除</td>
        </tr> 
         <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
          <td height="19" align="left" >1000002</td>
          <td align="left" >市场最新调查报告2</td>
          <td align="left" >对市场上最新的调查报告</td>
          <td align="left" >关羽</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >查看 | 下载 | 删除</td>
        </tr> 
        </div>
	  </table>
  <table border="0" cellspacing="0" cellpadding="2" width="100%">
    <tr>
    <td width="20%" height="25" style=" white-space:nowrap;"><input class="crmbutton small edit" type="button" value="上传"/>
    </td>
	<td width="60%" align="center" nowrap="nowrap">
    共 10 页，
    <a href="#"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a>
    &nbsp;当前第&nbsp;1&nbsp;页&nbsp;
    <a href="#"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a>
	</td>
    <td width="20%" align="right" style="padding-right:15px; white-space:nowrap;">每页显示 6 条记录</td>	
  </tr></table>
  <div style="height:20px;"></div>
  </div>
    <div id="div2" class="content_tab_div_unselected">
    <form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>价值链分析</b></td>
    </tr></table>
<!--<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="30%" height="25" align="center" valign="middle" class="td_border_title">供应链现状</td>
    <td width="5%" align="center" valign="middle" class="td_border_title">&nbsp;</td>
    <td width="30%" align="center" valign="middle" class="td_border_title">启示</td>
    <td width="5%" align="center" valign="middle" class="td_border_title">&nbsp;</td>
    <td width="30%" align="center" valign="middle" class="td_border_title">策略关注点</td>
    </tr>
  <tr>
    <td align="center" height="100" valign="middle" class="td_border" ><textarea name="textarea6" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border">
    	<img src="../images/arrow_right.png" width="30" height="80" />
    </td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea8" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><img src="../images/arrow_right.png" width="30" height="80" /></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea9" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    </tr>
</table>-->

<table width="98%" align="center" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
      <td width="30%" align="right" class="td_border">上传文件：</td>
      <td width="70%" align="left" class="td_border"><input type="file" style="width:300px"/></td>  
  </tr>
  <tr>
 	<td width="30%" align="right" class="td_border">初步发现&nbsp;&nbsp;&nbsp;&nbsp;<br />（大于20字）</td>
    <td width="70%" class="td_border"><textarea style="width:80%;height:202px;overflow-y:auto;"></textarea></td>
  </tr>
</table>
    
    
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>
    
    </div>
    <div id="div3" class="content_tab_div_unselected">
    	<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    <td class="detailedViewHeader"><b>波特五力</b></td>
</tr></table>

<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border" style="border:1px solid #DDDDDD;">
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td height="25" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">进入者威胁</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center" valign="middle" style="background-color:#E1E1E1">
      <textarea name="textarea10" rows="10" wrap="hard" class="textarea_style"></textarea>
    </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center" valign="middle"><img src="../images/arrow_down.png" width="80" height="30" /></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="30%" height="25" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">供应商协议能力</td>
    <td width="5%" rowspan="2" align="center" valign="middle"><img src="../images/arrow_right.png" width="30" height="80" /></td>
    <td width="30%" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">市场竞争</td>
    <td width="5%" rowspan="2" align="center" valign="middle"><img src="../images/arrow_left.png" width="30" height="80" /></td>
    <td width="30%" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">客户议价能力</td>
  </tr>
  <tr>
    <td align="center" height="100" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">
      <textarea name="textarea6" rows="10" wrap="hard" class="textarea_style"></textarea>
    </td>
    <td align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;"><textarea name="textarea8" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;"><textarea name="textarea9" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td height="25" align="center" valign="middle"><img src="../images/arrow_up.png" width="80" height="30" /></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td height="25" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">替代者威胁</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">
      <textarea name="textarea10" rows="10" wrap="hard" class="textarea_style"></textarea>
    </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>
    </div>
    <div id="div4" class="content_tab_div_unselected">
    	<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>SWOT分析</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="10%" rowspan="2" align="center" valign="middle" class="td_border" style=" font-weight:bold; font-size:large;">内<br/><br />部</td>
    <td width="45%" height="25" align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;">本类别的优势（S）</td>
    <td width="45%" align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;">本类别的劣势（W）</td>
    </tr>
  <tr>
    <td align="center" height="100" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;" ><textarea name="textarea6" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;"><textarea name="textarea8" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    </tr>
  <tr>
    <td  rowspan="2" align="center" valign="middle" class="td_border" style=" font-weight:bold; font-size:large;">外<br/><br />部</td>
    <td height="25" align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;">本类别的机会（O）</td>
    <td align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;">本类别的挑战（T）</td>
    </tr>
  <tr>
    <td align="center" height="100" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;" ><textarea name="textarea6" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;"><textarea name="textarea8" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>
    </div>
</div>
  
 
</div>


</td>
</tr></tbody></table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>