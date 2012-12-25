<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

</script>
<style type="text/css">
<!--

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
 <tbody>
  <tr>
     <td class="level2UnSelTab" nowrap="nowrap"><a href="yearcontractList.action">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
     <td width="100%">&nbsp;</td>
  </tr>
 </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 合同合规 &gt; 查看合同合规性</td>
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
 <tbody>
   <tr>
     <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
     <tbody><tr>
      <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
      <td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>数量与价格合规性</b></td>
      <td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
    </tr></tbody></table>
     </td>
   </tr>
   <tr>
     <td valign="top" align="left">
     
<div id="basicTab" >
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
   <tbody><tr>
    <td align="left"><table border="0" cellspacing="0" cellpadding="0" width="100%">
      <tbody><tr>
        <td id="autocom"></td>
      </tr>
      <tr>
        <td style="padding:10px"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
          <tbody><tr style="height:25px">
             <td  align="left"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
               <tbody><tr>
                 <td colspan="8" class="detailedViewHeader"><b>合同基本信息</b></td>
               </tr>
               <tr style="height:25px">
                 <td height="25" colspan="2" align="right" class="dvtCellLabel">合同编号</td>
                 <td width="19%"  align="left" class="dvtCellInfo">EPACN0012012092710701</td>
                 <td colspan="2" align="right" class="dvtCellLabel">供应商名称</td>
                 <td colspan="2" align="left" class="dvtCellInfo">深圳市达力科技开发有限公司</td>      
               </tr>
               <tr style="height:25px">
                 <td height="25" colspan="2" align="right" class="dvtCellLabel">采购负责人</td>
                 <td width="19%"  align="left" class="dvtCellInfo">张三</td>
                 <td colspan="2" align="right" class="dvtCellLabel">状态</td>
                 <td colspan="2" align="left" class="dvtCellInfo">待审批</td>
               </tr>
               <tr height="25">
                 <td colspan="8">&nbsp;</td>
               </tr>
               <tr>
                 <td colspan="8" class="detailedViewHeader"><b>数量与价格合规性审查</b></td>
               </tr>
               <tr style="height:25px">
                 <td height="25" colspan="3" align="center" class="dvtCellLabel"><b>合同信息记录</b></td>
                 <td height="25" colspan="4" align="center" class="dvtCellLabel"><b>SAP信息记录</b></td>
               </tr>
               <tr style="height:25px">
                 <td width="15%" height="25" align="center" class="dvtCellInfo">物料名称</td>
                 <td width="14%" align="center" class="dvtCellInfo">数量(个)</td>
           <td height="25" align="center" class="dvtCellInfo">单价(RMB)</td>
           <td width="13%" height="25" align="center" class="dvtCellInfo">数量(个)</td>
           <td width="13%" align="center" class="dvtCellInfo">开始时间</td>
           <td width="14%" height="25" align="center" class="dvtCellInfo">开始时间</td>
           <td width="12%" align="center" class="dvtCellInfo">平均价(RMB)</td>
         </tr>
               <tr style="height:25px">
           <td rowspan="4" align="center" class="dvtCellInfo">物料A</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">1-500</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">5.00</td>
           <td rowspan="2" align="center" class="dvtCellInfo">1-500</td>
           <td height="25" align="center" class="dvtCellInfo">2012/1</td>
           <td height="25" align="center" class="dvtCellInfo">2012/3</td>
           <td height="25" align="center" class="dvtCellInfo">4.80</td>
         </tr>
               <tr style="height:25px">
           <td height="25" align="center" class="dvtCellInfo">2012/3</td>
           <td height="25" align="center" class="dvtCellInfo">2012/6</td>
           <td height="25" align="center" class="dvtCellInfo">4.85</td>
         </tr>
               <tr style="height:25px">
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">500-1000</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">6.00</td>
           <td rowspan="2" align="center" class="dvtCellInfo">500-1000</td>
           <td height="25" align="center" class="dvtCellInfo">2012/6</td>
           <td height="25" align="center" class="dvtCellInfo">2012/9</td>
           <td height="25" align="center" class="dvtCellInfo">5.80</td>
         </tr>
               <tr style="height:25px">
           <td height="25" align="center" class="dvtCellInfo">2012/9</td>
           <td height="25" align="center" class="dvtCellInfo">2012/12</td>
           <td height="25" align="center" class="dvtCellInfo">6.20</td>
         </tr>
               <tr style="height:25px">
           <td rowspan="4" align="center" class="dvtCellInfo">物料B</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">1-500</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">5.00</td>
           <td rowspan="2" align="center" class="dvtCellInfo">1-500</td>
           <td height="25" align="center" class="dvtCellInfo">2012/1</td>
           <td height="25" align="center" class="dvtCellInfo">2012/3</td>
           <td height="25" align="center" class="dvtCellInfo">4.80</td>
         </tr>
               <tr style="height:25px">
           <td height="25" align="center" class="dvtCellInfo">2012/3</td>
           <td height="25" align="center" class="dvtCellInfo">2012/6</td>
           <td height="25" align="center" class="dvtCellInfo">4.85</td>
         </tr>
               <tr style="height:25px">
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">500-1000</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">6.00</td>
           <td rowspan="2" align="center" class="dvtCellInfo">500-1000</td>
           <td height="25" align="center" class="dvtCellInfo">2012/6</td>
           <td height="25" align="center" class="dvtCellInfo">2012/9</td>
           <td height="25" align="center" class="dvtCellInfo">5.80</td>
         </tr>
               <tr style="height:25px">
           <td height="25" align="center" class="dvtCellInfo">2012/9</td>
           <td height="25" align="center" class="dvtCellInfo">2012/12</td>
           <td height="25" align="center" class="dvtCellInfo">6.20</td>
         </tr>
               <tr>
            <td colspan="8" style="padding:5px" height="40"><div align="center">
              <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  返回  " style="width:70px" />
              </div></td>
          </tr>
               </tbody></table>
             </td></tr>
          </tbody></table>
         </td>
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
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>