<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合同管理-采购平台</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript">
$(document).ready(function(e) {
	$("#submitBtn2").click(function(){
			var form = $("#contractCancelReason");
			form.ajaxForm({
				url:"frameContract_addCancelReason.action",
				beforeSubmit:validate,
				//dataType:"json",
				success:function(returnData){
					alert(returnData.msg);
					window.location.href = "contract_setting.jsp";
				}
			});
		});
	});
	
function validate(formData, jqForm, options)
{
	var reason=$("#reason").val();
	if(reason==""){
			alert("取消原因不能为空！");
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="yearcontractList.action">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">合同查询</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
     <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 参数设置 &gt; 新增取消原因</td>
	<td width="100%" align="center">&nbsp;</td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
    
  
</tr></tbody>
</table>


<!-- 网站中部 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">
<!-- 内容开始 -->
<div class="contentListDiv">

<form id="contractCancelReason" name="contractCancelReason" action="" method="post" >
<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
<td class="dvtTabCache" style="width:10px" >&nbsp;</td>
<td id="test1" class="dvtSelectedCell" align="center" nowrap="nowrap" style="width:10%">新增取消原因</td>
<td class="dvtTabCache" style="width:100%" >&nbsp;</td>
</tr><tr>
</tr></tbody></table>
</td>
</tr>
<tr>
<td valign="top" align="left">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
<tbody><tr>
<td id="autocom"></td>
</tr>
<tr>
<td >
<!-- General details -->
<table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
<tbody>
  <tr style="height:25px">
    <td width="30%" align="left" class="dvtCellInfo"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
        <tr>
          <td colspan="2" style="padding:5px">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="2" class="detailedViewHeader"><b>合同取消原因信息</b></td>
        </tr>
        <tr style="height:25px">
          <td width="30%" height="33" align="right" class="dvtCellLabel">合同取消原因</td>
          <td align="left" class="dvtCellInfo"><input type="text" name="reason" id="reason" class="detailedViewTextBox" style="width:50%;" value="" /></td>
          </tr>
        <tr>
          <td colspan="2" style="padding:5px" height="40"><div align="center">
            <input id="submitBtn2" title="保存 [Alt+S]" accesskey="S" class="crmbutton small save"  type="submit" value="  保存  " style="width:70px" />
            &nbsp;
            <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  取消  " style="width:70px" />
            </div></td>
        </tr>
      </tbody>
    </table></td>
  </tr>
</tbody></table></td>
</tr>
</tbody></table>
</td>
</tr>
</tbody></table>
</form>
</div>
<!-- Basic Information Tab Closed -->
</td>
</tr>

</tbody></table>

<!-- 网站底部 -->

<jsp:include page="../common/bottom.jsp" flush="true"/>

</body>
</html>