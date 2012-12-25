<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/widget.css"/>

<div id="widget_advice" class="widgetMainFrame">

<!-- Widget Handle -->
<table width="100%" cellpadding="0" cellspacing="0" class="widgetHandle">
  <tbody><tr>
	<td width="70%" nowrap="nowarp" class="widgetHandleTitle">合理化建议</td>
	<td align="right" width="30%" nowrap="nowrap">
		<img src="../images/windowRefresh.gif" border="0" alt="刷新" title="刷新" hspace="1" align="absmiddle" style="cursor:pointer;">
        <img src="../images/windowMinMax.gif" border="0" alt="最大化" title="最大化" hspace="1" align="absmiddle" style="cursor:pointer;">
        <img src="../images/windowClose.gif" border="0" alt="关闭" title="关闭" hspace="1" align="absmiddle" style="cursor:pointer;" onclick="delWidget('widget_complaint');">
	</td>
  </tr></tbody>
</table>
	
<!-- Widget Content -->
<div class="widgetContent small">
<table width="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td class="widget_content_title">投诉标题</td>
	<td class="widget_content_title" width="60px">处理状态</td>
  </tr>
  <div id="content">
  <tr>
    <td class="widgetContentDetail"><a href="#" title="">合理化建议1</a></td>
    <td class="widgetContentDetail">待处理</td>
  </tr>
  <tr>
    <td class="widgetContentDetail"><a href="#" title="">合理化建议2</a></td>
    <td class="widgetContentDetail">已处理</td>
  </tr>
  </div>
</table>
</div>

<table width="100%" class="small">
<tbody><tr>
  <td align="right" valign="top" class="widgetBottom">
  <a href="../infocenter/adviceList.action" target="_self">更多  </a>
  </td>
</tr></tbody>
</table>
</div>

