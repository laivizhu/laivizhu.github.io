<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合同管理-采购平台</title>
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript">
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

function supplierChoose(){
   var	sUrl = "suppliers_choose.jsp";
	var sFeatures = "height=500, width=800, top=100, left=100, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=yes";
	var rtnValue = window.open(sUrl,"",sFeatures);
	if (typeof(rtnValue)!="undefined" && rtnValue!="" )
	 { 
	  var str1=rtnValue+"";
	  var str=str1.split("&");
	  var z= str.length;
	  var deviceremark="";
      document.forms[0].productname[i].value = str[0];
      document.forms[0].pic_name[i].value=str[1];
	 }	 
}

function diviationEdit(){
   var	sUrl = "diviation_edit.jsp";
	var sFeatures = "height=500, width=800, top=100, left=100, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=yes";
	var rtnValue = window.open(sUrl,"",sFeatures);
	if (typeof(rtnValue)!="undefined" && rtnValue!="" )
	 { 
	  var str1=rtnValue+"";
	  var str=str1.split("&");
	  var z= str.length;
	  var deviceremark="";
      document.forms[0].productname[i].value = str[0];
      document.forms[0].pic_name[i].value=str[1];
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

<body class="small" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0"  rightmargin="0" bottommargin="0">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>

<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>

<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
<tbody><tr>
    <td class="level2UnSelTab" nowrap="nowrap"><a href="yearcontractList.action">年度合同</a></td>
    <td class="level2SelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="contractCompliance.jsp">合同合规</a> </td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="contractSearch.jsp">合同查询</a> </td>
    <td class="level2UnSelTab" nowrap="nowrap"> <a href="contractParaSetting.jsp">参数设置</a> </td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
     <td  width="300px" style="padding-left:10px;padding-right:10px; font-weight:normal;color:black;" class="moduleName" nowrap="nowrap">
    您现在的位置： 合同管理 &gt; 框架合同 &gt; 查看扫描件</td>
	<td class="sep1">&nbsp;</td>  
    <td>
    <table width="auto" align="right"><tr>
	<td nowrap="nowrap">常用工具：</td>  
    <td>
    <img width="27" height="27" src="../images/btnL3Calendar.gif" alt="月历" title="月历" border="0" onclick="fnvshobj(this,'miniCal');getMiniCal();" style="cursor:pointer;"/>
    </td>
    <td>
    <img width="27" height="27" src="../images/btnL3Clock.gif" alt="世界时钟" title="世界时钟" border="0" onclick="fnvshobj(this,'wclock');" style="cursor:pointer;"/>
    </td>
    <td>
    <img width="27" height="27" src="../images/btnL3Calc.gif" alt="计算器" title="计算器" border="0" onclick="fnvshobj(this,'calculator_cont');fetch_calc();" style="cursor:pointer;"/>
    </td>
    <td>
    <img width="27" height="27" src="../images/tbarChat.gif" alt="在线交谈" title="在线交谈" border="0" onclick="" style="cursor:pointer;"/>
    </td>
    <td width="50px" nowrap="nowrap">&nbsp;</td>  
    <td nowrap="nowrap">版面设置：</td>
    <td>
    <img width="27" height="27" onclick="fnAddWindow(this,'addWidgetDropDown');" onmouseout="fnRemoveWindow();" src="../images/btnL3Add.gif" border="0" title="新建..." alt="新建..." style="cursor:pointer;"/>
    </td>
    <td>
    <img width="27" height="27" src="../images/btnL3AllMenu.gif" alt="开启所有选单" title="开启所有选单" border="0" onmouseout="fninvsh('allMenu');" onclick="$('allMenu').style.display='block'; $('allMenu').style.visibility='visible';placeAtCenter($('allMenu'))" style="cursor:pointer;"/>
    </td>
    <td>
    <img width="27" height="27" onclick="showOptions('changeLayoutDiv');" src="../images/orgshar.gif" border="0" title="变更版面" alt="变更版面" style="cursor:pointer;"/>
    </td>
    </tr></table>
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
<td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b> 扫描件信息</b></td>
<td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
</tr><tr>
</tr></tbody></table>
</td>
</tr>
<tr>
<td valign="top" align="left">

<div id="basicTab" style="">

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
    <td width="30%" align="left" class="dvtCellInfo"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
      
        <tr>
          <td colspan="4" class="detailedViewHeader"><b>合同基本信息</b></td>
        </tr>
        <tr style="height:25px">
          <td width="25%" class="dvtCellLabel" align="right">合同编号</td>
          <td width="25%"  align="left" class="dvtCellInfo">EPACN0012012092710701</td>
          <td width="25%" class="dvtCellLabel" align="right">供应商名称</td>
          <td width="25%" align="left" class="dvtCellInfo">深圳市达力科技开发有限公司
          </td>
          <!-- Non Editable field, only configured value will be loaded -->         
        </tr>
        <tr style="height:25px">
          <td width="25%" class="dvtCellLabel" align="right">采购负责人</td>
          <td width="25%"  align="left" class="dvtCellInfo">张三</td>
          <td width="25%" class="dvtCellLabel" align="right">状态</td>
          <td width="25%" align="left" class="dvtCellInfo">已审批</td>
          <!-- Non Editable field, only configured value will be loaded -->         
        </tr>
        <tr>
          <td colspan="4" class="detailedViewHeader"><b>主合同条款</b></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>年度合同</td>
          <td colspan="3" align="left" class="dvtCellInfo"><a href="#">12年度合同</a></td>
        </tr>
         <tr>
          <td colspan="4" class="detailedViewHeader"><b>合同附件信息</b></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>偏差</td>
          <td colspan="3" width="30%" align="left" class="dvtCellInfo">
           <a href="javascript:diviationView()">查看偏差</a></td>
        </tr>
          <tr style="height:25px">
          <td width="20%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>保密协议NDA</td>
          <td colspan="3" width="30%" align="left" class="dvtCellInfo"><a href="#">保密协议.doc</a></td>
        </tr>
          <tr style="height:25px">
          <td width="20%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>质量协议</td>
          <td colspan="3" width="30%" align="left" class="dvtCellInfo"><a href="#">质量协议.doc</a></td>
        </tr>
          <tr style="height:25px">
          <td width="20%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>采购说明书</td>
          <td colspan="3" width="30%" align="left" class="dvtCellInfo"><a href="#">采购说明书1.doc</a>  ; <a href="#">采购说明书2.doc</a></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>技术协议</td>
          <td colspan="3" width="30%" align="left" class="dvtCellInfo"><a href="#">技术协议1.doc</a>  ; <a href="#">技术协议2.doc</a></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" height="25" class="dvtCellLabel" align="right"><font color="red"></font>监造协议</td>
          <td colspan="3" width="30%" align="left" class="dvtCellInfo"><a href="#">监造协议1.doc</a>  ; <a href="#">监造协议2.doc</a></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" height="25" align="right" class="dvtCellLabel"><font color="red"></font>物流协议</td>
          <td colspan="3" width="30%" align="left" class="dvtCellInfo"><a href="#">物流协议1.doc</a>  ; <a href="#">物流协议2.doc</a></td>
        </tr>
          <tr style="height:25px">
          <td width="20%" height="25" align="right" class="dvtCellLabel"><font color="red"></font>价格协议</td>
          <td colspan="3" width="30%" align="left" class="dvtCellInfo"><a href="#">价格协议.xls</a></td>
        </tr>
        <tr>
          <td colspan="4" class="detailedViewHeader"><b>合同扫描件信息</b></td>
        </tr>
         <tr style="height:25px">
          <td width="20%" height="25" align="right" class="dvtCellLabel"><font color="red"></font>扫描件清单</td>
          <td colspan="3" width="30%" align="left" class="dvtCellInfo"><a href="#">技术协议.PDF</a>  ;<a href="#">价格协议.</a><a href="#">PDF</a></td>
        </tr>
        <tr>
          <td colspan="4" style="padding:5px"><div align="right">
            <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  返回  " style="width:70px" />
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

<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>