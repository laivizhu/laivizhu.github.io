<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>首页-供应商门户</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.0.custom.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
  <script type="text/javascript" language="javascript">
	$(document).ready(function(e) {
        //Widget排序
		$("#main").sortable({
			handle:$(".widgetHandle"),
			opacity:0.8,
			revert: true,
			scroll:false,
			tolerance:"pointer",
			update:function(event, ui)
			{
				$("#message").html("信息块位置已保存！");
				$("#message").show();
				$("#message").fadeOut(1500);
			}
		});
		//对话框
		$("#dialog").dialog(
		{
			autoOpen: false,
			title: "采购管理平台警告：",
			modal:true,
		
			width:300,
			height:180,
			resizable:false,
		
			z_index:30000,

		});
			
    });
  
  
		
	function delWidget(obj)
	{
		var obj = $("#"+obj);
		var dialog = $("#dialog");
		dialog.html("确认删除？");
		dialog.dialog("option","buttons",{
			"确认":function()
			{
				obj.remove();
				$("#message").html("信息删除成功！");
				$("#message").show();
				$("#message").fadeOut(1500);
				dialog.dialog("close");
				
			},
			"取消":function()
			{
				dialog.dialog("close");
			}
		});
		dialog.dialog("open");

	}
	
	function maxWidget(obj)
	{
		var obj = $("#"+obj+"_max");
		obj.dialog("open");
	}
  </script>
  

</head>

<body class="small" style="margin:0px;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
<tbody><tr>
    <td class="level2SelTab" nowrap="nowrap"><a href="index.jsp">首页</a></td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="schedule.jsp">日程提醒</a> </td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:15px" nowrap="nowrap">您现在的位置： 工作台 &gt; 首页</td>
  <td width="100%" align="center" valign="middle">
  	<div id="message" style="background-color:#E0ECFF;z-index:10;display:none;width:200px;height:22px; padding-top:8px;"></div>
  </td>
  <td align="right" style="padding-right:10px;">
    <table><tbody><tr>
      <td align="right" nowrap="nowrap">工作台设置：</td>
	  <td><img width="27" height="27" src="../images/btnL3Add.gif" border="0" title="增加信息块" alt="增加信息块" style="cursor:pointer;"/></td>
    </tr></tbody></table>
  </td>
  <td align="right" style="padding-right:15px;">
  	<jsp:include page="../common/toolbar.jsp" flush="true"/>
  </td>  
</tr></tbody>
</table>

<!-- 工作台 首页 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody><tr><td width="100%" align="left" valign="top">
  	
<div id="main" style="margin-top:20px; margin-left:10px;">
    <jsp:include page="widget_notice_inner.jsp" flush="true"/>
    <jsp:include page="widget_notice_outer.jsp" flush="true"/>
    <jsp:include page="widget_task.jsp" flush="true"/>
    <jsp:include page="widget_po.jsp" flush="true"/>
    <jsp:include page="widget_pr.jsp" flush="true"/>
    <jsp:include page="widget_complaint.jsp" flush="true"/>
    <jsp:include page="widget_advice.jsp" flush="true"/>
    <jsp:include page="widget_invoice.jsp" flush="true"/>
</div>

</td></tr></tbody></table>


<div id="dialog"></div>


<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>

</body>
</html>
