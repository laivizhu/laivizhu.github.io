<%--
	User: janlu.sword@gmail.com
	Time: 12-11-11 下午11:08
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>信息记录管理</title>
	<link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.8.5.custom.css" />
	<link rel="stylesheet" type="text/css" href="../css/jquery.portlet.css?v=1.1.2" />
	<link rel="stylesheet" type="text/css" href="../css/style_laivi.css" />
	<link rel="stylesheet" type="text/css" href="../css/common.css"/>
	<link rel="stylesheet" type="text/css" href="../css/jbox_Green/jbox.css"/>
	<link rel="stylesheet" type="text/css" href="../css/jquery.qtip.min.css" />
	<script src="../js/jquery-1.8.2.js"></script>
	<script src="../js/jquery.form.js"></script>
	<script src="../js/jquery-ui-1.8.14.custom.min.js"></script>
	<script src="../js/jquery.portlet.js?v=1.1.2"></script>
	<script src="../js/jquery.qtip-1.0.0.min.js"></script>
	<script type="text/javascript" src="../js/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript" src="../js/system/information_list.js"></script>
	<style>
    body {font-size: 13px;}
    .highlight-content {color: red;}
    </style>
</head>
<body>
<div id="informationListDivId"></div>


<div id="informationDivId" style="margin:0;display:none;">
<br />
 	<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
      <tr>
        <td width="30%" align="right" valign="middle" class="td_border">标题：</td>
        <td width="70%" align="center" valign="middle" class="td_border">
        	<label id="titleFormFieldId"></label>
        </td>
     </tr>
     <tr height="150px">
        <td align="right" valign="middle" class="td_border">信息内容：</td>
        <td align="left" align="center" valign="middle" class="td_border">
        	<label id="contentFormFieldId"></label>
     </tr>
      <tr>
        <td align="right" valign="middle" class="td_border">情况等级：</td>
        <td align="left" align="center" valign="middle" class="td_border">
        	<label id="levelFormFieldId"></label>
     </tr>
     <tr>
        <td align="right" valign="middle" class="td_border">发布日期：</td>
        <td align="left"  align="center" valign="middle" class="td_border">
        	<label id="createDateFormFieldId"></label>
     </tr>
     <tr>
        <td align="right" valign="middle" class="td_border">发布人：</td>
        <td align="left" align="center" valign="middle" class="td_border">
        	<label id="userFormFieldId"></label>
     </tr>
  	</table>
        <table width="100%">
        <tr>
        <td colspan="2" align="center" height="40">
          <input class="crmbutton small cancel" type="reset" value="取消"  onclick="laivi.dialogClose()" style="width:70px"/>
        </td>
        </tr>
    </table>
</div>
</body>
</html>
		