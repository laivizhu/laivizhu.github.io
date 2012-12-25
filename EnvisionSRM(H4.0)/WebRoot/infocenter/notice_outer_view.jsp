<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>查看公告</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript">
  	$(document).ready(function(e) {
        var title = $("#title");
		var department = $("#department");
		var createTime = $("#createTime");
		var modifyTime = $("#modifyTime");
		var attachment = $("#attachment");
		var content = $("#content");
		var type = $("#type");
		var suppliers = $("#suppliers");
		var id = window.location.href.split("=")[1];
		$.getJSON("noticeOuter_get.action?id=" + id+"&time="+Math.random(),function(returnData){
			title.html(returnData.title);
			department.html(returnData.department);
			createTime.html(returnData.createTime);
			modifyTime.html(returnData.modifyTime);
			content.html(returnData.content);
			type.html(returnData.type);
			var suppliersVal = "";
			$.each(returnData.suppliers,function(i,item){
				suppliersVal +=item.name+",";
			});
			suppliers.val(suppliersVal);
			if(returnData.attachment != ""){
				var a2 = $("<a>");
				a2.attr("href", "noticeOuter_download.action?id=" + id);
				a2.html(returnData.attachment);
				attachment.append(a2);
			}
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
    <td class="level2UnSelTab" nowrap="nowrap"><a href="notice_inner_list.jsp" target="_self">内部公告</a></td>
    <td class="level2SelTab" nowrap="nowrap"><a href="notice_outer_list.jsp" target="_self">外部公告</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 信息中心 &gt; 外部公告 &gt; 查看公告 </td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>

<!-- 查看公告 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">
<!-- 内容开始 -->
<div class="contentViewDiv">
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody>

  <tr>
	<td class="detailedViewHeader" colspan="10">&nbsp;</td>
  </tr>

  <tr>
	<td align="center" valign="middle" class="dvtCellLabel" colspan="10" style="height:50px;">
    	<h1 id="title">&nbsp;</h1>
    </td>
  </tr>
  
  <tr>
	<td width="15%" align="right" valign="middle" class="dvtCellLabel" height="30">发布部门</td>
    <td width="35%" align="left" valign="middle" class="dvtCellInfo" id="department">&nbsp;</td>
    <td width="15%" align="right" valign="middle" class="dvtCellLabel">公告类型</td>
    <td width="35%" align="left" valign="middle" class="dvtCellInfo" id="type">&nbsp;</td>
  </tr>
  <tr>
	<td height="30px" align="right" valign="middle" class="dvtCellLabel" style="height:30px;">创建时间</td>
    <td align="left" valign="middle" class="dvtCellInfo" id="createTime">&nbsp;</td>
    <td align="right" valign="middle" class="dvtCellLabel">修改时间</td>
    <td align="left" valign="middle" class="dvtCellInfo" id="modifyTime">&nbsp;</td>
  </tr>
  <tr>
    <td align="right" class="dvtCellLabel">接收供应商</td>
	<td colspan="3" align="left" class="dvtCellInfo" style="padding:5px;">
      <textarea id="suppliers" disabled="disabled" readonly="readonly" style="height:40px;width:99%; overflow-y:auto;"></textarea>
    </td>
  </tr>
  <tr>
	<td height="30" align="right" valign="middle" class="dvtCellLabel" style="height:30px;">附件</td>
    <td colspan="3" align="left" valign="middle" class="dvtCellInfo" id="attachment"></td>
  </tr>


  <tr>
	<td width="100%" align="center" valign="top" colspan="10" class="dvtCellLabel">
    	<div id="content" style=" margin:10px auto;width:95%; background-color:#FFFFFF;">
        </div>
    </td>
  </tr>
<tr>
<td colspan="10" align="center" height="40">
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  返回  " style="width:70px"/>
</td>
</tr>
</tbody></table>

</div>

  </td></tr>
</tbody></table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>
