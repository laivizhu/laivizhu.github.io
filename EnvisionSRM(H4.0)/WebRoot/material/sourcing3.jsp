<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>3.组建类别团队</title>
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
  <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap">您现在的位置： 采购项目管理 &gt; 类别管理七步法 &gt; 3.组建类别团队</td>
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
  <a href="sourcing3.jsp" target="_self" style="font-weight:bold;">3.&nbsp;组建类别团队</a> &gt;
  <a href="sourcing4.jsp" target="_self">4.&nbsp;分析供应市场</a> &gt;
  <a href="sourcing5.jsp" target="_self">5.&nbsp;制定类别策略</a> &gt;
  <a href="sourcing6.jsp" target="_self">6.&nbsp;制定实施计划</a> &gt;
  <a href="sourcing7.jsp" target="_self">7.&nbsp;查询方案进度</a>
</div>
<hr style="width:98%; margin-top:10px; margin-bottom:10px;"  />

<!-- Content Tab Tabs -->
<div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab1" class="content_tab_title_selected" align="center" onclick="showTab(1,2);">当前类别团队</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab2" class="content_tab_title_unselected" align="center" onclick="showTab(2,2);">定义成功标准</td>
    <td class="content_tab_title_cache" style="width:100%"></td>
  </tr></tbody></table>
</div>

<!-- Content Tab Divs -->
<div class="content_tab_detail" style="height:320px;">
    <div id="div1" class="content_tab_div_selected">
    <table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>当前类别团队详情</b></td>
    </tr></table>
    <table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
      <tr>
        <td width="25%" align="right" valign="middle" class="td_border_title">团队名称：</td>
        <td width="75%" valign="middle" class="td_border">风机类别团队</td>
        </tr>
      <tr>
        <td align="right" valign="middle" class="td_border_title">团队负责人：</td>
        <td valign="middle" class="td_border">刘备</td>
      </tr>
      <tr>
        <td align="right" valign="middle" class="td_border_title">创建时间：</td>
        <td valign="middle" class="td_border">2012-11-08</td>
      </tr>
      <tr>
        <td align="right" valign="middle" class="td_border_title">修改时间：</td>
        <td valign="middle" class="td_border">2012-11-11</td>
      </tr>
      <tr>
        <td align="right" valign="middle" class="td_border_title">团队成员：</td>
        <td valign="middle" class="td_border">张飞、关羽、诸葛亮</td>
      </tr>
    
    </table>
    
    </div>
    <div id="div2" class="content_tab_div_unselected">
    <form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>项目风险记录</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="10%" align="center" valign="middle" class="td_border_title">序号</td>
    <td width="15%" align="center" valign="middle" class="td_border_title">风险描述</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">提出人</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">提出时间</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">严重程度</td>
    <td width="15%" align="center" valign="middle" class="td_border_title">解决方案</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">责任人</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">计划解决日期</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">问题状态</td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">1</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border">
    <select name="select" id="select">
    	<option value="0">张飞</option>
        <option value="1">诸葛亮</option>
    </select>
    </td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border">
    <select name="select3" id="select3">
      <option value="1">不严重</option>
      <option value="0">一般</option>
      <option value="1">很严重</option>
    </select></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea7" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><select name="select2" id="select2">
      <option value="0">张飞</option>
      <option value="1">诸葛亮</option>
    </select></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><select name="select4" id="select4">
      <option value="1">已解决</option>
      <option value="0">正在进行中</option>
      <option value="1">尚未开始</option>
    </select></td>
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