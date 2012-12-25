<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合同管理-采购平台</title>
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
	<link rel="stylesheet" type="text/css" href="../css/common.css"/>
	<script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
	<script language="javascript" type="text/javascript" src="../js/HouqianTable.js"></script>
	<script type="text/javascript">
		$(document).ready(
			function(){
				var table = new HouQianTable({
					url:"contract/contract_yearcontractList.action",
					parentContainer:"#contract",
					columns:[
						{name:"年度合同名称",width:"27%",bindingProperty:"name"},
						{name:"模板类型",width:"20%",bindingProperty:"type"},
						{name:"开始时间",width:"10%",bindingProperty:"begindate"},
						{name:"截止时间",width:"10%",bindingProperty:"enddate"},
						{name:"负责人",width:"10%",bindingProperty:"person"},
						{name:"状态",width:"10%",bindingProperty:"iseffective"}
					],
					commonOperations:[
						{name:"查看",callback:view_contract},
						{name:"下载",callback:download_contract},
					],
					specialOperations:[
						{name:"上传",callback:contractUpload}
					],
					pageCount:8,
					selectType:0
				});
			}
		);
function download_contract(data,callbackdata){
   window.location="download_yearcontractDownload.action?filename="+callbackdata;
}		
function view_contract(data){
   window.location="view_yearcontractView.action?id="+data.id;
}
function contractUpload(id){
   window.location="maincontract_upload.jsp";
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
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_maincontractlist.jsp">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">合同查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
      <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 年度合同 &gt; 年度合同模板列表
    </td>
	<td width="100%" align="center" valign="middle">
    	
    </td>
	<td align="right" style="padding-right:10px;">&nbsp;</td>
    <td align="right" style="padding-right:20px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td> 
   
</tr></tbody>
</table>

<!-- 工作台 -->

<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">
<!-- 内容开始 -->
<div class="contentListDiv">

<table align="center" border="0" cellpadding="0" cellspacing="0"  width="100%">
<tbody>
 <tr>
<td>
	<table class="small" border="0" cellpadding="3" cellspacing="0" width="100%">
	<tbody><tr>
		<td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
		<td class="dvtSelectedCell" align="center" nowrap="nowrap" style="width:10%" onclick="DispContent(1,2);" >年度合同模板列表</td>
		<td class="dvtTabCache" style="width:100%;">&nbsp;</td>
	   </tr>
             </tbody></table>
         </td></tr>
 <tr>
<td align="left" valign="top">
	<table class="dvtContentSpace" border="0" cellpadding="3" cellspacing="0" width="100%">
		<tbody><tr>
			<td align="left">
				<!-- content cache -->
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody><tr>
			<td style="padding: 10px;">

	   <!-- PUBLIC CONTENTS STARTS-->
<div id="contract" class="small" style="width:100%;position:relative;"></div>
</td></tr></tbody></table>
</td></tr></tbody></table>
       </td></tr></tbody></table>
      </div>
   
</td>
 </tr>
</tbody></table>


<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>
