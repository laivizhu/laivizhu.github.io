<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合同管理-采购平台</title>
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.0.custom.css"/>  
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/calc.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
<script language="javascript">
 $(document).ready(function(e) {
		$("#diviationEdit").dialog({
			autoOpen: false,
			title: "偏差编辑",
			modal:true,
			width:800,
			height:500,
			resizable:false,
		});
		$("#diviation_changeId").dialog({
			autoOpen: false,
		//	title: "新增偏差",
			modal:true,
			width:800,
			height:500,
			resizable:false,
            
		});
		
		$("#diviation_insertId").dialog({
			autoOpen: false,
		//	title: "新增偏差",
			modal:true,
			width:800,
			height:500,
			resizable:false,
            
		});
    });
 function showDiviationEditDialog(arg)
    {
    	$("#diviationEdit").dialog("open");
    }
function changediviation(){
    $("#diviationEdit").dialog("close");
    $("#diviation_changeId").dialog("open");
}

function insertdiviation(){
    $("#diviationEdit").dialog("close");
    $("#diviation_insertId").dialog("open");	 
}
function confirmDiviation(){
    $("#diviationEdit").dialog("close");
    $("#diviation_changeId").dialog("close");
    $("#diviation_insertId").dialog("close");
}
function changedetail(x)
{
  var detail=document.getElementById(x).value;
  if(detail=="1"){
     document.getElementById("detail").value="备品备件，是指由乙方在本合同项下提供的用以维持在本合同项下的全部产品和服务在质保期内正常运行所需的部件。";
  }
  if(detail=="1.1"){
     document.getElementById("detail").value="易耗品, 乙方提供的满足调试、试运行和质量保证期运行、维护等所需的油品、材料、易损件。";
  } 
  if(detail=="1.1.1"){
     document.getElementById("detail").value="技术服务，指由乙方提供的与本合同产品和服务有关的设计、监造、检验、安装、验收、性能验收试验、运行、检修时相应的技术指导、技术配合、技术培训等全过程的服务。";
  }  
}
function changediviationid(x)
{
  var newid=document.getElementById(x).value;
  if(newid=="1"){
     document.getElementById("newid").value="1.4";
  }
  if(newid=="1.1"){
     document.getElementById("newid").value="1.1.2";
  }  
}
</script>
<style type="text/css">
<!--
input[type="file"] {
-webkit-box-align: baseline;
color: inherit;
text-align: start;
}
-->
</style>
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
    <td class="level2SelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="contract_compliance.jsp">合同合规</a> </td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="contract_query.jsp">合同查询</a> </td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="contract_setting.jsp">参数设置</a> </td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
   <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 框架合同 &gt; 合同变更</td>
   <td width="100%" align="center">&nbsp;</td>
   <td align="right" style="padding-right:15px;"><jsp:include page="../common/toolbar.jsp" flush="true"/></td>
</tr></tbody>
</table>


<!-- 网站中部 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top" style="padding-left:10px; padding-top:20px;" >
<!-- -->
<div class="small">
<form name="EditView" method="" action="" onsubmit="">

<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px">&nbsp;</td>
<td style="width:15%" align="center" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>合同 变更</b></td>
<td class="dvtTabCache" style="width:85%">&nbsp;</td>
</tr><tr>
</tr></tbody></table>
</td>
</tr>
<tr>
<td valign="top" align="left">

<div id="basicTab" >

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
<tbody><tr>
<td align="left">


<table border="0" cellspacing="0" cellpadding="0" width="100%">
<tbody><tr>
<td id="autocom"></td>
</tr>
<tr>
<td style="padding:10px">
<!-- General details -->
<table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
<tbody>
  <tr style="height:25px">
    <td><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
       
        <tr>
          <td colspan="5" class="detailedViewHeader"><b>合同基本信息</b></td>
        </tr>
        <tr style="height:25px">
          <td width="18%" class="dvtCellLabel" align="right">合同编号</td>
          <td width="17%"  align="left" class="dvtCellInfo">供应商编号+年度合同号+V01</td>
          <td width="15%" class="dvtCellLabel" align="right">供应商名称</td>
          <td colspan="2" align="left" class="dvtCellInfo">深圳市达力科技开发有限公司
          </td>
          <!-- Non Editable field, only configured value will be loaded -->          
        </tr>
        <tr style="height:25px">
          <td class="dvtCellLabel" align="right">采购负责人</td>
          <td align="left" class="dvtCellInfo">张三</td>
          <td class="dvtCellLabel" align="right">状态</td>
          <td colspan="2" align="left" class="dvtCellInfo">已审批</td>
          <!-- Non Editable field, only configured value will be loaded -->         
        </tr>
        <tr>
          <td colspan="5" class="detailedViewHeader"><b>主合同条款</b></td>
        </tr>
         <tr style="height:25px">
          <td width="18%" class="dvtCellLabel" align="right"><font color="red"></font>年度合同</td>
          <td colspan="" align="left" class="dvtCellInfo">生产性物料年度合同模板</td>
          <td colspan="" align="right" class="dvtCellLabel">当前年度合同</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">12年度合同</a></td>
        </tr>
         <tr>
          <td colspan="5" class="detailedViewHeader"><b>合同附件信息</b></td>
        </tr>
         <tr style="height:25px">
          <td width="18%" height="25" align="right" class="dvtCellLabel"></td>
          <td colspan="2" align="left" class="dvtCellInfo"><b>附件信息</b></td>
          <td width="24%" align="left" class="dvtCellInfo">&nbsp;</td>
          <td width="26%" align="left" class="dvtCellInfo"><b>备注说明</b></td>
         </tr>
         <tr style="height:25px">
          <td width="18%" height="25" align="right" class="dvtCellLabel"><font color="red"></font>偏差</td>
          <td colspan="2" align="left" class="dvtCellInfo">
            <a href="#">偏差附件V01.xl</a>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="编辑偏差" onclick="showDiviationEditDialog()"/></td>
          <td width="24%" align="left" class="dvtCellInfo"><span style=" color:#F00">备注：若变更偏差则合同版本号改变）</span></td>
          <td width="26%" align="left" class="dvtCellInfo"><input type="text" value="无" style="width:80%"/></td>
         </tr>
          <tr style="height:25px">
          <td width="18%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>保密协议NDA</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">保密协议.pdf</a></td>
          <td width="24%" align="left" class="dvtCellInfo"><input type="file" name="浏览2" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="26%" align="left" class="dvtCellInfo"><input type="text" value="无" style="width:80%"/></td>
          </tr>
          <tr style="height:25px">
          <td width="18%" height="25"class="dvtCellLabel" align="right"><font color="red"></font>价格协议</td>
          <td align="left" class="dvtCellInfo"><a href="#">价格协议V01.xls</a></td>
          <td align="left" class="dvtCellInfo"><a href="#">价格协议V02.xls</a></td>
          <td width="24%" align="left" class="dvtCellInfo"><input type="file" name="浏览" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /> <span style=" color:#F00">(备注：价格协议变更则合同版本号不改变)</span></td>
          <td width="26%" align="left" class="dvtCellInfo"><input type="text" value="无" style="width:80%"/></td>
          </tr>
          <tr style="height:25px">
          <td width="18%" height="25"class="dvtCellLabel" align="right"><font color="red"></font>质量协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">质量协议.pdf</a></td>
          <td width="24%" align="left" class="dvtCellInfo"><input type="file" name="浏览3" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="26%" align="left" class="dvtCellInfo"><input type="text" value="无" style="width:80%"/></td>
          </tr>
          <tr style="height:25px">
          <td width="18%" height="25"class="dvtCellLabel" align="right"><font color="red"></font>采购说明书</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">采购说明书1.pdf</a> ; <a href="#">采购说明书2.pdf</a></td>
          <td width="24%" align="left" class="dvtCellInfo"><input type="file" name="浏览4" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="26%" align="left" class="dvtCellInfo"><input type="text" value="无" style="width:80%"/></td>
          </tr>
         <tr style="height:25px">
          <td width="18%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>技术协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">技术协议1.pdf</a> ; <a href="#">技术协议2.pdf</a></td>
          <td width="24%" align="left" class="dvtCellInfo"><input type="file" name="浏览5" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="26%" align="left" class="dvtCellInfo"><input type="text" value="无" style="width:80%"/></td>
         </tr>
         <tr style="height:25px">
          <td width="18%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>监造协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">监造协议1.pdf</a> ; <a href="#">监造协议2.pdf</a></td>
          <td width="24%" align="left" class="dvtCellInfo"><input type="file" name="浏览6" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="26%" align="left" class="dvtCellInfo"><input type="text" value="无" style="width:80%"/></td>
         </tr>
         <tr style="height:25px">
          <td width="18%" height="25" align="right" class="dvtCellLabel"><font color="red"></font>物流协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">物流协议1.pdf</a> ; <a href="#">物流协议2.pdf</a></td>
          <td width="24%" align="left" class="dvtCellInfo"><input type="file" name="浏览7" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="26%" align="left" class="dvtCellInfo"><input type="text" value="无" style="width:80%"/></td>
         </tr>
          <tr style="height:25px">
          <td width="18%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>EHS协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">EHS协议.pdf</a></td>
          <td width="24%" align="left" class="dvtCellInfo"><input type="file" name="浏览8" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" />           </td>
          <td width="26%" align="left" class="dvtCellInfo"><input type="text" value="无" style="width:80%"/></td>
          </tr>
        <tr>
          <td colspan="5" style="padding:5px" height="40"><div align="center">
            <input title="确认 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="confirm('您变更了偏差，若确认变更，则会改变合同版本号。\n确认提交吗？');" type="submit" name="button" value="  确认  " style="width:70px" />
            &nbsp;
            <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  取消  " style="width:70px" />
          </div></td>
        </tr>
      </tbody>
    </table>      <span id="assign_user" style="display:block"></span></td>
  </tr>
</tbody></table></td>
</tr>
</tbody></table>
</td>
</tr>
</tbody></table>
</div>
<!-- Basic Information Tab Closed -->
  </td></tr>
  </tbody></table>
</form>
</div>

</td></tr></tbody></table>
<div id="diviationEdit" style="display:none">
 <jsp:include page="diviation_edit.jsp" flush="true"/>
</div>
<div id="diviation_changeId" style="display:none">
 <jsp:include page="diviation_change.jsp" flush="true"/>
</div> 
<div id="diviation_insertId" style="display:none">
 <jsp:include page="diviation_insert.jsp" flush="true"/>
</div>
<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>