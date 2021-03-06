<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>合同操作-采购平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.0.custom.css"/>

  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
  <script language="javascript" type="text/javascript" src="../js/HouqianTab.js"></script>
<script language="javascript">
	$(document).ready(
		function(){
			var tab = new HouqianTab({
				parentContainer:"#tabdiv",
				tabs:[
					{name:"合同定制",page:"../contract/contract_customizediv.jsp"},
					{name:"提交审批",page:"../contract/contract_submitdiv.jsp"},
					{name:"合同上传",page:"../contract/contractScanCopyBlock.jsp"}
				]
			});
		}
	);
	

</script>
</head>

<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>

<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>

<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_maincontractlist.jsp">年度合同模板</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">合同查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_approval.jsp">合同审批</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap">  您现在的位置： 合同管理 &gt; 框架合同 </td>
      <td width="100%" align="center" valign="middle"></td>
      <td align="right" style="padding-right:10px;">&nbsp;</td>
      <td align="right" style="padding-right:20px;"><jsp:include page="../common/toolbar.jsp" flush="true"/></td>
    </tr>
  </tbody>
</table>

<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
  <tbody>
    <tr>
      <td width="100%" align="left" valign="top" id="tabdiv">
		<!-- 内容开始 --> 
       	
      </td>
    </tr>
  </tbody>
</table>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
