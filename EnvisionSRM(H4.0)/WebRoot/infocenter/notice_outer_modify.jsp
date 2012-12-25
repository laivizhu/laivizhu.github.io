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
		
		$("#content").ckeditor({
			toolbar:"MyToolbar",
		});
		
		var title = $("input[name='title']");
		var attchment = $('input[name="#attchment"]');
		var attchment2 = $('#attchment2');
		var content = $('textarea[name="content"]');
		var type = $("select[name='type_id']");
		var id = window.location.href.split("=")[1];
		
		$.getJSON("noticeOuter_get.action?id=" + id+"&time="+Math.random(),function(returnData){
			title.val(returnData.title);
			content.val(returnData.content);
			type = returnData.type;
			if(returnData.attchment == "无"){
				attchment2.html("无");
			}else{
				attchment2.html('<a href="noticeOuter_download.action?id='+id+'" target="_self">'+returnData.attchment+'</a>');
			}
		});
		
		$.getJSON("noticeType_list.action?time="+Math.random(),function(data){
			$.each(data.root,function(i,item){
				if(item.name == type)
					$("#type_id").append("<option selected='selected' value='"+item.id+"'>"+item.name+"</option>");
				else
					$("#type_id").append("<option value='"+item.id+"'>"+item.name+"</option>");
			});
		});
		
		$("#submitBtn").click(function(){
			var form = $("#addForm");
			form.ajaxForm({
				url:"noticeOuter_update.action",
				data:{"id":id},
				beforeSubmit:validate,
				//dataType:"json",
				success:function(returnData){
					var data = $.parseJSON(returnData);
					alert(data.msg);
					window.location.href = "notice_outer_list.jsp";
				}
			});
		});

    });
	
	function validate(formData, jqForm, options)
	{
		var title =  $('input[name="title"]');
		var type = $('select[name="type_id"]');
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
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="notice_inner_list.jsp" target="_self">内部公告</a></td>
    <td class="level2SelTab" nowrap="nowrap"> <a href="notice_outer_list.jsp" target="_self">外部公告</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 信息中心 &gt; 外部公告 &gt; 修改公告 </td>
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
    <td colspan="3" class="detailedViewHeader"><b>修改外部公告</b></td>
  </tr>
  <tr>
	<td width="15%" height="30px" class="dvtCellLabel" align="right"><font color="red">*</font>标题</td>
	<td width="50%" align="left" class="dvtCellInfo" style="padding:5px;">
	  <input name="title" type="text" id="title" style="width:98%;" size="30" maxlength="50" />
	</td>
	<td width="35%" align="left" class="dvtCellLabel">标题不能为空，最多50个字符</td>
  </tr>

  <tr>
	<td height="30px" class="dvtCellLabel" align="right"><font color="red">*</font>公告类型</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;">
      <select name="type_id" id="type_id" style="width:99%;">
    	<option value="0">请选择类别</option>
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
	<td align="left" class="dvtCellInfo" style="padding:5px;"><input type="file" name="attchment" id="attchment" style="width:99%;" /></td>
	<td align="left" class="dvtCellLabel">选择附件，多个文件请打包上传</td>
  </tr>
  <tr>
    <td class="dvtCellLabel" align="right">公告内容</td>
	<td class="dvtCellLabel" align="center" valign="top" colspan="2" style="padding:5px;"><textarea id="content" name="content"></textarea></td>
  </tr>


<tr>
<td colspan="10" align="center" height="40">
  <input id="submitBtn" class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>

</tbody></table>
</form>
</div>

  </td></tr>
</tbody></table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>
