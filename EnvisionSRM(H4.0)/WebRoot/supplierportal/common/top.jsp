<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>

<table border="0" cellspacing="0" cellpadding="0" width="100%" class="hdrNameBg">
<tbody><tr>
  <td valign="middle" height="40px" style="padding-left:5px;">
    <img src="../images/logo.png" style="width:110px;height:30px;">
  </td>
  <td nowrap="nowrap" valign="middle" style="font-size:14px; color:#005EA6; font-weight:bold; padding-top:11px; padding-left:10px;">供应商门户</td>
  <td width="100%">&nbsp;</td>
  
  <td class="small" nowrap="nowrap">
	<table border="0" cellspacing="0" cellpadding="0">
	<tbody><tr>
    <td style="padding-left:10px;padding-right:10px;padding-top:6px" class="small" nowrap="nowrap">
      <s:property value="#session.loginInfo.username"/>
    </td>
	
    <td style="padding-left:10px;padding-right:5px;padding-top:6px" class="small" nowrap="nowrap">
    <a href="#">注销</a>
    </td>
    
    <td style="padding-left:5px;padding-right:5px;padding-top:6px" class="small" nowrap="nowrap">
    <a href="#" onclick="">反馈</a>
    </td>
    
    <td style="padding-left:5px;padding-right:5px;padding-top:6px" class="small" nowrap="nowrap">
    <a href="" target="_blank">帮助</a>
    </td>
    
    <td class="small" style="padding-left:5px;padding-right:10px;padding-top:6px"  nowrap="nowrap">
    <a href="http://www.envisioncn.com/about-us.html" target="_blank">关于我们</a>
    </td> 
	
    </tr></tbody>
    </table>
	</td>
</tr></tbody></table>
