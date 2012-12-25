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
		
		$("#supplierid").dialog({
			autoOpen: false,
			title: "供应商选择",
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
  function supplierChoose(){

    	$("#supplierid").dialog("open");
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
function DispContent( i , count)
{
var test = document.getElementById('test'+i);	
var div = document.getElementById( 'div' + i );
if(i==1){
   var test2 = document.getElementById('test'+count);
   var div2 = document.getElementById( 'div' + count );	
   if( div.style.display == "none" )
    {
	 div2.style.display= "none";
     div.style.display = '';
    }
	if(test.className == "dvtUnSelectedCell")
	{
	  test.className="dvtSelectedCell";
	  test2.className="dvtUnSelectedCell";
	}
}else{
	var test2 = document.getElementById('test'+ 1 );
	var div2 = document.getElementById( 'div' + 1 );	
	if( div.style.display == "none" )
    {
	 div2.style.display= "none";
     div.style.display = '';
    }
	if(test.className == "dvtUnSelectedCell")
	{
	  test.className="dvtSelectedCell";
	  test2.className="dvtUnSelectedCell";
	}
}
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

<!-- 网站导航 --><!-- 二级菜单 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
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
     <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 框架合同 &gt; 编辑框架合同</td>
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
  <td width="100%" align="left" valign="top" style="padding-left:10px; padding-top:20px;" >
<!-- -->
<div class="small">
<form name="EditView" method="" action="" onsubmit="">

<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
<td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>框架合同 信息</b></td>
<td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
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
          <td colspan="4" class="detailedViewHeader"><b>合同基本信息</b></td>
        </tr>
        <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right">合同编号</td>
          <td width="25%"  align="left" class="dvtCellInfo">供应商编号+年度合同号+V01</td>
          <td width="20%" class="dvtCellLabel" align="right">供应商名称</td>
          <td width="35%" align="left" class="dvtCellInfo"><input type="text" name="lastname2" tabindex="" class="detailedViewTextBox" onfocus="this.className='detailedViewTextBoxOn'" onblur="this.className='detailedViewTextBox'" style="width:58%;" value="深圳市达力科技开发有限公司" />
                               浏览供应商:
          <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer">
          <img src="../images/clear.gif" alt="清除" title="清除" language="javascript" onclick="document.EditView.lastname2.value=''; document.EditView.lastname2.value='';" align="absmiddle" style="cursor:hand;cursor:pointer">
          </td>
          <!-- Non Editable field, only configured value will be loaded -->          
        </tr>
        <tr style="height:25px">
          <td class="dvtCellLabel" align="right">采购负责人</td>
          <td align="left" class="dvtCellInfo">张三</td>
          <td class="dvtCellLabel" align="right">状态</td>
          <td align="left" class="dvtCellInfo">待审批</td>
          <!-- Non Editable field, only configured value will be loaded -->         
        </tr>
        <tr>
          <td colspan="4" class="detailedViewHeader"><b>主合同条款</b></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>年度合同类型</td>
           <td colspan="" align="left" valign="middle" class="dvtCellInfo">
            <select style="width:75%">
              <option value="">---请选择模板类型---</option>
              <option value="生产性物料年度合同模板" selected="selected">生产性物料年度合同模板</option>
              <option value="非生产性物料年度合同模板">非生产性物料年度合同模板</option>
            </select>
          </td>
          <td align="right" valign="middle" class="dvtCellLabel">当前年度合同</td>
          <td colspan="" align="left" valign="middle" class="dvtCellInfo">
            <input type="text" name="" value="12年度合同"/> 
          </td>
        </tr>
         <tr>
          <td colspan="4" class="detailedViewHeader"><b>合同附件信息</b></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font></td>
          <td colspan="2" width="15%" align="left" class="dvtCellInfo"><b>附件信息</b></td>
          <td width="15%" align="left" class="dvtCellInfo"><b>备注说明</b></td>
         </tr>
         <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>*偏差</td>
          <td width="8%" align="left" class="dvtCellInfo">
            <a href="#">合同偏差V01.xls            </a></td>
          <td width="7%" align="left" class="dvtCellInfo"><a href="#">
            <input type="button" value="编辑偏差" onclick="showDiviationEditDialog()"/>
          </a></td>
          <td width="15%" align="left" class="dvtCellInfo"><input type="text" style="width:80%"  value="无"/></td>
         </tr>
          <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>*保密协议</td>
          <td width="8%" align="left" class="dvtCellInfo"><a href="#">保密协议.pdf</a></td>
          <td width="7%" align="left" class="dvtCellInfo"><input type="file" name="浏览2" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="15%" align="left" class="dvtCellInfo"><input type="text" style="width:80%"  value="无"/></td>
          </tr>
           <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>*价格协议</td>
          <td width="8%" align="left" class="dvtCellInfo"><a href="#">价格协议.xls</a></td>
          <td width="7%" align="left" class="dvtCellInfo"><input type="file" name="浏览" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="15%" align="left" class="dvtCellInfo"><input type="text" style="width:80%"  value="无"/></td>
          </tr>
          <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>质量协议</td>
          <td width="8%" align="left" class="dvtCellInfo"><a href="#">质量协议.pdf</a></td>
          <td width="7%" align="left" class="dvtCellInfo"><input type="file" name="浏览3" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="15%" align="left" class="dvtCellInfo"><input type="text" style="width:80%"  value="无"/></td>
          </tr>
          <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>采购说明书</td>
          <td width="8%" align="left" class="dvtCellInfo"><a href="#">采购说明书1.pdf</a> ; <a href="#">采购说明书2.pdf</a></td>
          <td width="7%" align="left" class="dvtCellInfo"><input type="file" name="浏览4" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="15%" align="left" class="dvtCellInfo"><input type="text" style="width:80%"  value="无"/></td>
          </tr>
         <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>技术协议</td>
          <td width="8%" align="left" class="dvtCellInfo"><a href="#">技术协议1.pdf</a> ; <a href="#">技术协议2.pdf</a></td>
          <td width="7%" align="left" class="dvtCellInfo"><input type="file" name="浏览5" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="15%" align="left" class="dvtCellInfo"><input type="text" style="width:80%"  value="无"/></td>
         </tr>
         <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>监造协议</td>
          <td width="8%" align="left" class="dvtCellInfo"><a href="#">监造协议1.pdf</a> ; <a href="#">监造协议2.pdf</a></td>
          <td width="7%" align="left" class="dvtCellInfo"><input type="file" name="浏览6" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="15%" align="left" class="dvtCellInfo"><input type="text" style="width:80%"  value="无"/></td>
         </tr>
         <tr style="height:25px">
          <td width="20%" height="25" align="right" class="dvtCellLabel"><font color="red"></font>物流协议</td>
          <td width="8%" align="left" class="dvtCellInfo"><a href="#">物流协议1.pdf</a> ; <a href="#">物流协议2.pdf</a></td>
          <td width="7%" align="left" class="dvtCellInfo"><input type="file" name="浏览7" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="15%" align="left" class="dvtCellInfo"><input type="text" style="width:80%"  value="无"/></td>
         </tr>
          <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>EHS协议</td>
          <td width="8%" align="left" class="dvtCellInfo"><a href="#">EHS协议.pdf</a></td>
          <td width="7%" align="left" class="dvtCellInfo"><input type="file" name="浏览8" tabindex="" class="detailedViewTextBox" style="width:100%;" value="" /></td>
          <td width="15%" align="left" class="dvtCellInfo"><input type="text" style="width:80%"  value="无"/></td>
          </tr>
        <tr>
          <td colspan="4" style="padding:5px" height="40"><div align="center">
            <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="" type="submit" name="button" value="  保存  " style="width:70px" />
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
<div id="supplierid" style="display:none">
 <jsp:include page="../common/choice_supplier.jsp" flush="true"/>
</div>  
<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>