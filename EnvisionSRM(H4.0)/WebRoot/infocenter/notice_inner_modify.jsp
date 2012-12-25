<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>修改公告</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery.form.js"></script>
  <script language="javascript" type="text/javascript" src="../ckeditor/ckeditor.js"></script>
  <script language="javascript" type="text/javascript" src="../ckeditor/adapters/jquery.js"></script>

  <script language="javascript" type="text/javascript">
  	$(document).ready(function(e) {
		id = window.location.href.split("=")[1];
		title = $("input[name='title']");
		attchment = $('input[name="attchment"]');
		attchment2 = $('#attchment2');
		content = $('textarea[name="content"]');
		type = $("select[name='type']");
		typeValue = "";
		
		$("#content").ckeditor({
			toolbar:"MyToolbar"
		});
		
		$("#preview").dialog({
			autoOpen:false,
			title:"发布预览",
			modal:true,
			width:740,
			height:520,
		});
				
		$.getJSON("noticeInner_get.action?id=" + id+"&time="+Math.random(),function(returnData){
			title.val(returnData.title);
			content.val(returnData.content);
			typeValue = returnData.type;
			if(returnData.attchment != null){
				var a = $("<a>");
				a.html(returnData.attchment);
				a.attr("href","noticeInner_download.action?id="+id);
				attchment2.append(a);
			}
		});
		
		$.getJSON("noticeType_list.action?time="+Math.random(),function(data){
			$.each(data.root,function(i,item){
				if(item.name == typeValue)
					type.append("<option selected value='"+item.id+"'>"+item.name+"</option>");
				else
					type.append("<option value='"+item.id+"'>"+item.name+"</option>");
			});
		});
		
		$("#previewBtn").click(function(){
			if(validate()){
				
				$("#title3").html(title.val());
				$("#type3").html(type.find("option:selected").text());
				
				if(attchment.val() != "")
					$("#attchment3").html(attchment.val());
				else
					$("#attchment3").html(attchment2.text());
				$("#content3").html(content.val());
				$("#preview").dialog("open");
			}
		});
		
		$("#cancelBtn").click(function(){
			$("#preview").dialog("close");
		});
		
		$("#submitBtn").click(function(){
			var form = $("#addForm");
			form.ajaxSubmit({
				url:"noticeInner_update.action",
				data:{"id":id},
				success:function(returnData){
					var data = $.parseJSON(returnData);
					alert(data.msg);
					window.location.href = "notice_inner_list.jsp";
				}
			});
		});

    });
	
	function validate(formData, jqForm, options)
	{
		if(title.val().length <= 0)
		{
			alert("标题不能为空！");
			return false;
		}
		if(title.val().length > 50)
		{
			alert("标题长度不能大于50个字符！");
			return false;
		}
		if(type.val() == 0)
		{
			alert("请选择公告类型！");
			return false;
		}
		return true;
	}
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
    <td class="level2SelTab" nowrap="nowrap"> <a href="notice_inner_list.jsp" target="_self">内部公告</a></td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="notice_outer_list.jsp" target="_self">外部公告</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 信息中心 &gt; 内部公告 &gt; 修改公告 </td>
	<td width="100%">&nbsp;</td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>
<!-- 修改公告 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">

<div class="contentViewDiv">
<form id="addForm" method="post" enctype="multipart/form-data">

<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center"><tbody>
  <tr>
    <td colspan="3" class="detailedViewHeader"><b>修改内部公告</b></td>
  </tr>
  <tr>
	<td width="15%" height="30px" class="dvtCellLabel" align="right"><font color="red">*</font>标题</td>
	<td width="50%" align="left" class="dvtCellInfo" style="padding:5px;">
	  <input name="title" type="text" id="title" style="width:97%;" size="30" maxlength="50" />
	</td>
	<td width="35%" align="left" class="dvtCellLabel">标题不能为空，最多50个字符</td>
  </tr>

  <tr>
	<td height="30px" class="dvtCellLabel" align="right"><font color="red">*</font>公告类型</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;">
      <select name="type" style="width:98%;">
    	<option value="0">请选择公告类别</option>
      </select>
    </td>
	<td width="35" align="left" class="dvtCellLabel">请选择公告类型</td>
  </tr>
  <tr>
	<td align="right" height="30px" class="dvtCellLabel">已上传附件</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;" id="attchment2" >&nbsp;</td>
	<td align="left" class="dvtCellLabel">已经上传附件名称，上传新附件将覆盖原附件</td>
  </tr>
  <tr>
	<td align="right" height="30px" class="dvtCellLabel">附件</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;"><input type="file" name="attchment" style="width:98%;" /></td>
	<td align="left" class="dvtCellLabel">选择附件，多个文件请打包上传</td>
  </tr>
  <tr>
    <td class="dvtCellLabel" align="right">公告内容</td>
	<td class="dvtCellLabel" align="center" valign="top" colspan="2" style="padding:5px;"><textarea id="content" name="content"></textarea></td>
  </tr>


<tr>
<td colspan="10" align="center" height="40">
  <input id="previewBtn" class="crmbutton small save" type="button" value="  发布预览  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>

</tbody></table>
</form>
</div>

  </td></tr>
</tbody></table>
<div id="preview">
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody>
  <tr>
	<td class="detailedViewHeader" colspan="10">&nbsp;</td>
  </tr>
  <tr>
	<td align="center" valign="middle" class="dvtCellLabel" colspan="10" style="height:50px;">
    	<h2 id="title3">&nbsp;</h2>
    </td>
  </tr>
  <tr>
    <td width="20%" height="30px" align="right" valign="middle" class="dvtCellLabel">公告类型：</td>
    <td width="80%" align="left" valign="middle" class="dvtCellInfo" id="type3">&nbsp;</td>
  </tr>
  <tr>
    <td width="20%" height="30px" align="right" valign="middle" class="dvtCellLabel" style="height:30px;">附件：</td>
    <td width="80%" align="left" valign="middle" class="dvtCellInfo" id="attchment3"></td>
  </tr>
  <tr>
	<td width="100%" align="center" valign="top" colspan="10" class="dvtCellLabel">
    	<div id="content3" style="margin:10px auto; width:95%; background-color:#FFFFFF; text-align:left;"></div>
    </td>
  </tr>
<tr>
<td colspan="10" align="center" height="40">&nbsp;&nbsp;
  <input id="submitBtn" class="crmbutton small save" type="button" value="  发布  " style="width:70px"/>&nbsp;&nbsp;
  <input id="cancelBtn" class="crmbutton small cancel" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</tbody></table>

</div>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>
