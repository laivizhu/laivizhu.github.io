<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>新增外部公告</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery.form.js"></script>
  <script language="javascript" type="text/javascript" src="../ckeditor/ckeditor.js"></script>
  <script language="javascript" type="text/javascript" src="../ckeditor/adapters/jquery.js"></script>
  <script language="javascript" type="text/javascript" src="../js/basic.js"></script>
  <script language="javascript" type="text/javascript" src="../js/HouqianTable.js"></script>
  <script language="javascript" type="text/javascript" src="../js/supplier/supplier_common.js"></script>

  <script language="javascript" type="text/javascript">
 
  	$(document).ready(function(e) {
		title = $("input[name='title']:first");
		type = $("select[name='type_id']");
		department = $("select[name='department_id']");
		suppliers = $("textarea[name='suppliers']");
		attachment = $("input[name='attachment']");
		content = $("textarea[name='content']");
	
		loadSupplier(true);
		
		content.ckeditor({
			toolbar:"MyToolbar",
		});
		
		
		$.getJSON("noticeType_list.action?time="+Math.random(),function(data){
			$.each(data.root,function(i,item){
				var option = $("<option>");
				option.val(item.id);
				option.text(item.name);
				type.append(option);
			});
		});
		
		$.getJSON("../system/department_listAll.action?time="+Math.random(),function(data){
			$.each(data,function(i,item){
				var option = $("<option>");
				option.val(item.id);
				option.text(item.name);
				department.append(option);
			});
		});
		
		$("#preview").dialog({
			autoOpen:false,
			title:"发布预览",
			modal:true,
			width:740,
			height:520				
		});
		
		$("#previewBtn").click(function(){
			if(validate()){
				$("#title2").html(title.val());
				$("#type2").html(type.find("option:selected").text());
				$("#department2").html(department.find("option:selected").text());
				$("#suppliers2").val(suppliers.val());
				$("#attachment2").html(attachment.val().split("\\")[attachment.val().split("\\").length-1]);
				$("#content2").html(content.val());
				$("#preview").dialog("open");
			}
		});
		
		$("#cancleBtn").click(function(){
			$("#preview").dialog("close");
		});
		
		
		$("#submitBtn").click(function(){
			var form = $("#addForm");
			form.ajaxSubmit({
				url:"noticeOuter_add.action",
				success:function(returnData){
					var data = $.parseJSON(returnData);
					alert(data.msg);
					window.location.href = "notice_outer_list.jsp";
				}
			});
		});

    });
	
	function validate()
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
		if(department.val() == 0)
		{
			alert("请选择发布部门！");
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
    <td class="level2UnSelTab" nowrap="nowrap"><a href="notice_inner_list.jsp" target="_self">内部公告</a></td>
    <td class="level2SelTab" nowrap="nowrap"><a href="notice_outer_list.jsp" target="_self">外部公告</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 信息中心 &gt; 外部公告 &gt; 新增公告 </td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>

<!-- 内容 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">

<div class="contentViewDiv">
<form id="addForm" method="post" enctype="multipart/form-data">

<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center"><tbody>
  <tr>
    <td colspan="3" class="detailedViewHeader"><b>新增外部公告</b></td>
  </tr>
  <tr>
	<td width="15%" height="30px" class="dvtCellLabel" align="right"><font color="red">*</font>标题</td>
	<td width="50%" align="left" class="dvtCellInfo" style="padding:5px;">
	  <input name="title" type="text" style="width:98%;" size="30" maxlength="50" />
	</td>
	<td width="35%" align="left" class="dvtCellLabel">标题不能为空，最多50个字符</td>
  </tr>

  <tr>
	<td height="30px" class="dvtCellLabel" align="right"><font color="red">*</font>公告类型</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;">
      <select name="type_id" style="width:99%;">
    	<option value="0">请选择公告类型</option>
      </select>
    </td>
	<td align="left" class="dvtCellLabel">请选择公告类型</td>
  </tr>
  <tr>
	<td height="30px" class="dvtCellLabel" align="right"><font color="red">*</font>发布部门</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;">
      <select name="department_id" id="department_id" style="width:99%;">
    	<option value="0">请选择发布部门</option>
      </select>
    </td>
	<td align="left" class="dvtCellLabel">请选择发布部门</td>
  </tr>
  <tr>
	<td rowspan="2" align="right" class="dvtCellLabel">接收供应商</td>
	<td rowspan="2" align="left" class="dvtCellInfo" style="padding:5px;">
    <input type="hidden" name="supplierInputId" id="supplierInputId" value=""/>
    <textarea id="supplierNameInputId" name="suppliers" rows="5" readonly="readonly" style="width:99%; overflow-y:auto;">全部供应商</textarea></td>
	<td height="35px" align="left" class="dvtCellLabel">请选择供应商，默认发送给所有供应商。</td>
  </tr>
  <tr>
    <td align="left" class="dvtCellLabel">
    浏览供应商: <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer"/>
    <img src="../images/clear.gif" alt="清除" title="清除" align="absmiddle" onclick="cleanSupplier()" style="cursor:hand;cursor:pointer" /></td>
  </tr>
  <tr>
	<td align="right" height="30px" class="dvtCellLabel">附件</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;">
	  <input type="file" name="attachment" style="width:99%;" />
	</td>
	<td align="left" class="dvtCellLabel">选择附件，多个文件请打包上传</td>
  </tr>
  <tr>
    <td class="dvtCellLabel" align="right">公告内容</td>
	<td class="dvtCellLabel" align="center" valign="top" colspan="2" style="padding:5px;"><textarea name="content"></textarea></td>
  </tr>


<tr>
<td colspan="10" align="center" height="40">
  <input id="previewBtn" class="crmbutton small save" type="button" value=" 发布预览 " style="width:80px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:80px"/>
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
    	<h2 id="title2">&nbsp;</h2>
    </td>
  </tr>
  
  <tr>
    <td width="15%" height="30px" align="right" valign="middle" class="dvtCellLabel">公告类型：</td>
    <td width="35%" align="left" valign="middle" class="dvtCellInfo" id="type2">&nbsp;</td>
    <td width="15%" height="30px" align="right" valign="middle" class="dvtCellLabel">发布部门：</td>
    <td width="35%" align="left" valign="middle" class="dvtCellInfo" id="department2">&nbsp;</td>
  </tr>
  <tr>
    <td height="50px" align="right" class="dvtCellLabel">接收供应商</td>
	<td colspan="3" align="left" class="dvtCellInfo" style="padding:5px;"><textarea id="suppliers2" disabled="disabled" readonly="readonly" style="height:40px;width:99%; overflow-y:auto;"></textarea></td>
  </tr>
  <tr>
    <td height="30px" align="right" valign="middle" class="dvtCellLabel" style="height:30px;">附件：</td>
    <td colspan="3" align="left" valign="middle" class="dvtCellInfo" id="attachment2"></td>
  </tr>


  <tr>
	<td width="100%" align="center" valign="top" colspan="10" class="dvtCellLabel">
    	<div id="content2" style="margin:10px auto; width:98%; background-color:#FFFFFF; text-align:left;">
        </div>
    </td>
  </tr>
<tr>
<td colspan="10" align="center" height="40">
  <input id="submitBtn" class="crmbutton small save" type="button" value="  发布  " style="width:70px"/>&nbsp;&nbsp;
  <input id="cancleBtn" class="crmbutton small cancel" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</tbody></table>

</div>

<jsp:include page="../common/choice_supplier.jsp" flush="true"/>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>

</body>
</html>
