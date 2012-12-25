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
</script>
<style type="text/css">
<!--
.lvtCol {
border-top: 1px solid white;
border-left: 1px solid #DDD;
border-right: 0px solid white;
border-bottom: 0px solid white;
background: #F6F6F6 url(../images/mailSubHeaderBg-grey.gif) bottom repeat-x;
font-weight: bold;
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
 <tbody>
  <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_maincontractlist.jsp">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
    <td width="100%">&nbsp;</td>
  </tr>
 </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 合同查询 &gt; 查看合同整体信息</td>
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
  <td id="test1" style="width:15%" align="center" nowrap="" class="dvtSelectedCell" onClick="DispContent(1,2);" >合同信息V01</td>
  <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
  <td id="test2" style="width:15%" align="center" nowrap="" class="dvtUnSelectedCell" onClick="DispContent(2,2);" >合同信息V02</td>
  <td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
</tr><tr>
</tr></tbody></table>
</td>
</tr>
<tr>
<td valign="top" align="left">

<div id="div1" class="small" style="width:100%;position:relative;">

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
<table border="0" cellspacing="1" cellpadding="1" width="100%" class="small">
<tbody>
  <tr style="height:25px">
    <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
      
        <tr>
          <td colspan="8" class="detailedViewHeader"><b>合同基本信息</b></td>
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">合同编号</td>
          <td colspan="2"  align="left" class="dvtCellInfo">供应商编号01+年度合同01+V01</td>
          <td colspan="2" class="dvtCellLabel" align="right">供应商名称</td>
          <td colspan="2" align="left" class="dvtCellInfo">深圳市达力科技开发有限公司
          </td>       
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">年度合同</td>
          <td colspan="2"  align="left" class="dvtCellInfo">生产性物料年度合同</td>
          <td colspan="2" class="dvtCellLabel" align="right">审批状态</td>
          <td colspan="2" align="left" class="dvtCellInfo">已审批</td>      
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">签约日期</td>
          <td colspan="2"  align="left" class="dvtCellInfo">2012-07-15</td>
          <td colspan="2" class="dvtCellLabel" align="right">货币</td>
          <td colspan="2" align="left" class="dvtCellInfo">人民币</td>      
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">交货日期</td>
          <td colspan="2"  align="left" class="dvtCellInfo">2012-09-03</td>
          <td colspan="2" class="dvtCellLabel" align="right">采购负责人</td>
          <td colspan="2" align="left" class="dvtCellInfo">vivi</td>      
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">创建时间</td>
          <td colspan="2"  align="left" class="dvtCellInfo">2012-07-03</td>
          <td colspan="2" class="dvtCellLabel" align="right">创建人</td>
          <td colspan="2" align="left" class="dvtCellInfo">vivi</td>      
        </tr>
         <tr>
           <td colspan="8" class="detailedViewHeader"><b>合同附件信息</b></td>
         </tr>
          <tr style="height:25px">
          <td colspan="2" height="25" align="right" class="dvtCellLabel"><font color="red"></font></td>
          <td colspan="2" align="left" class="dvtCellInfo"><b>附件信息</b></td>
          <td colspan="2" align="left" class="dvtCellInfo"><b>创建时间</b></td>
          <td colspan="2" align="left" class="dvtCellInfo"><b>备注说明</b></td>
          
        </tr>
         <tr style="height:25px">
          <td colspan="2"height="25" align="right" class="dvtCellLabel"><font color="red"></font>偏差</td>
          <td colspan="2"align="left" class="dvtCellInfo">
           <a href="javascript:diviationView()">查看偏差</a>
          </td>
          <td colspan="2" align="left" class="dvtCellInfo">2012-10-29</td>
          <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
          <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>保密协议</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">保密协议.pdf</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
          <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>价格协议</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">价格协议.xls</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
          <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>质量协议</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">质量协议.pdf</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
          <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
         <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>采购说明书</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">采购说明书1.pdf</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
         <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>技术协议</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">技术协议1.pdf</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
         <tr style="height:25px">
          <td colspan="2"height="25" align="right" class="dvtCellLabel"><font color="red"></font>监造协议</td>
          <td  colspan="2"align="left" class="dvtCellInfo">无</td>
          <td  colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
          <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>物流协议</td>
          <td colspan="2"align="left" class="dvtCellInfo">无<a href="#"></a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right"><font color="red"></font>EHS协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">EHS协议.pdf</a></td>
          <td colspan="2" align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
        <tr>
           <td colspan="8" class="detailedViewHeader"><b>合同偏差信息</b></td>
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="lvtCol" align="center">年度合同章节</td>
          <td colspan="2" align="center" class="lvtCol"><a href="#">偏差序号</a></td>
          <td colspan="2" align="center" class="lvtCol">年度合同协议内容</td>
           <td colspan="2" align="center" class="lvtCol">偏差内容</td>
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" align="center" class="dvtCellInfo">第三章</td>
          <td colspan="2" align="center" class="dvtCellInfo">3.1</td>
          <td colspan="2" align="left" class="dvtCellInfo" >乙方交付的所有产品和服务要符合标准关于包装、储运指示标志的规定及产品</td>
          <td colspan="2" align="left" class="dvtCellInfo">除《通用采购条款》第三章的相关规定外，供货方还需要满足以下要求。</td>
        </tr>
         <tr style="height:25px">
          <td colspan="2" height="25" align="center" class="dvtCellInfo">第三章</td>
          <td colspan="2" align="center" class="dvtCellInfo">3.2</td>
          <td colspan="2" align="left" class="dvtCellInfo" >包装、保存和标识应符合规格说明图纸或订单的要求，如无要求，刚将采用商业上接受的最佳实践，并至少与有关法律规定相一致。</td>
          <td colspan="2" align="left" class="dvtCellInfo">所有货物均应在妥当考虑货物的性质之同时，以适当方式包装，而包装材料应适于防止货物在运输过程中发生损坏并保证货物抵达目的地时的完整性。</td>
        </tr>
        <tr>
           <td colspan="8" class="detailedViewHeader"><b>价格协议详细信息</b></td>
        </tr>
       <tr style="height:25px">
          <td width="11%" height="25" align="center" class="lvtCol">序号</td>
          <td width="10%" align="center" class="lvtCol">名称</td>
          <td width="13%" align="center" class="lvtCol">规格</td>
           <td width="9%" align="center" class="lvtCol">单价(含税)</td>
           <td width="16%" align="center" class="lvtCol">数量</td>
           <td width="10%" align="center" class="lvtCol">单位</td>
           <td width="15%" align="center" class="lvtCol">总价(含税)</td>
           <td width="16%" align="center" class="lvtCol">备注</td>
        </tr>
        <tr style="height:25px">
          <td width="11%" height="25" align="center" class="dvtCellInfo" >1</td>
          <td width="10%" align="center" class="dvtCellInfo" >物料A</td>
          <td width="13%" align="center" class="dvtCellInfo" >XXX-00</td>
           <td width="9%" align="center" class="dvtCellInfo" >15</td>
           <td width="16%" align="center" class="dvtCellInfo" >2000</td>
           <td width="10%" align="center" class="dvtCellInfo" >个</td>
           <td width="15%" align="center" class="dvtCellInfo" >30000</td>
           <td width="16%" align="center" class="dvtCellInfo" >XXXX</td>
        </tr>
         <tr style="height:25px">
          <td width="11%" height="25" align="center" class="dvtCellInfo" >2</td>
          <td width="10%" align="center" class="dvtCellInfo" >物料B</td>
          <td width="13%" align="center"  class="dvtCellInfo">XXX-01</td>
           <td width="9%" align="center"  class="dvtCellInfo">10</td>
           <td width="16%" align="center"  class="dvtCellInfo">3000</td>
           <td width="10%" align="center"  class="dvtCellInfo">个</td>
           <td width="15%" align="center" class="dvtCellInfo">30000</td>
           <td width="16%" align="center"  class="dvtCellInfo">XXXX</td>
        </tr>
        <tr>
          <td colspan="8" style="padding:5px" height="40"><div align="center">
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

<!-- div信息 -->

<div id="div2" class="small" style="width:100%;position:relative;display:none">

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
    <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
      
        <tr>
          <td colspan="8" class="detailedViewHeader"><b>合同基本信息</b></td>
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">合同编号</td>
          <td colspan="2"  align="left" class="dvtCellInfo">供应商编号01+年度合同01+V02</td>
          <td colspan="2" class="dvtCellLabel" align="right">供应商名称</td>
          <td colspan="2" align="left" class="dvtCellInfo">深圳市达力科技开发有限公司
          </td>       
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">年度合同</td>
          <td colspan="2"  align="left" class="dvtCellInfo">生产性物料年度合同</td>
          <td colspan="2" class="dvtCellLabel" align="right">审批状态</td>
          <td colspan="2" align="left" class="dvtCellInfo">已审批</td>      
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">签约日期</td>
          <td colspan="2"  align="left" class="dvtCellInfo">2012-07-15</td>
          <td colspan="2" class="dvtCellLabel" align="right">货币</td>
          <td colspan="2" align="left" class="dvtCellInfo">人民币</td>      
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">交货日期</td>
          <td colspan="2"  align="left" class="dvtCellInfo">2012-09-03</td>
          <td colspan="2" class="dvtCellLabel" align="right">采购负责人</td>
          <td colspan="2" align="left" class="dvtCellInfo">vivi</td>      
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right">创建时间</td>
          <td colspan="2"  align="left" class="dvtCellInfo">2012-07-03</td>
          <td colspan="2" class="dvtCellLabel" align="right">创建人</td>
          <td colspan="2" align="left" class="dvtCellInfo">vivi</td>      
        </tr>
         <tr>
           <td colspan="8" class="detailedViewHeader"><b>合同附件信息</b></td>
         </tr>
          <tr style="height:25px">
          <td colspan="2" height="25" align="right" class="dvtCellLabel"><font color="red"></font></td>
          <td colspan="2" align="left" class="dvtCellInfo"><b>附件信息</b></td>
          <td colspan="2" align="left" class="dvtCellInfo"><b>创建时间</b></td>
          <td colspan="2" align="left" class="dvtCellInfo"><b>备注说明</b></td>
          
        </tr>
         <tr style="height:25px">
          <td colspan="2"height="25" align="right" class="dvtCellLabel"><font color="red"></font>偏差</td>
          <td colspan="2"align="left" class="dvtCellInfo">
           <a href="javascript:diviationView()">查看偏差</a>
          </td>
          <td colspan="2" align="left" class="dvtCellInfo">2012-10-29</td>
          <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
          <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>保密协议</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">保密协议.pdf</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
          <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>价格协议</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">价格协议V01.xls</a>;<a href="#">价格协议V02.xls</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
          <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>质量协议</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">质量协议.pdf</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
          <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
         <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>采购说明书</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">采购说明书1.pdf</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
         <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>技术协议</td>
          <td colspan="2"align="left" class="dvtCellInfo"><a href="#">技术协议1.pdf</a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
         <tr style="height:25px">
          <td colspan="2"height="25" align="right" class="dvtCellLabel"><font color="red"></font>监造协议</td>
          <td  colspan="2"align="left" class="dvtCellInfo">无</td>
          <td  colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
          <tr style="height:25px">
          <td colspan="2"height="25" class="dvtCellLabel" align="right"><font color="red"></font>物流协议</td>
          <td colspan="2"align="left" class="dvtCellInfo">无<a href="#"></a></td>
          <td colspan="2"align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="dvtCellLabel" align="right"><font color="red"></font>EHS协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><a href="#">EHS协议.pdf</a></td>
          <td colspan="2" align="left" class="dvtCellInfo">2012-10-29</td>
           <td colspan="2" align="left" class="dvtCellInfo">无</td>
        </tr>
        <tr>
           <td colspan="8" class="detailedViewHeader"><b>合同偏差信息</b></td>
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" class="lvtCol" align="center">年度合同章节</td>
          <td colspan="2" align="center" class="lvtCol"><a href="#">偏差序号</a></td>
          <td colspan="2" align="center" class="lvtCol">年度合同协议内容</td>
           <td colspan="2" align="center" class="lvtCol">偏差内容</td>
        </tr>
        <tr style="height:25px">
          <td colspan="2" height="25" align="center" class="dvtCellInfo">第三章</td>
          <td colspan="2" align="center" class="dvtCellInfo">3.1</td>
          <td colspan="2" align="left" class="dvtCellInfo" >乙方交付的所有产品和服务要符合标准关于包装、储运指示标志的规定及产品</td>
          <td colspan="2" align="left" class="dvtCellInfo">除《通用采购条款》第三章的相关规定外，供货方还需要满足以下要求。</td>
        </tr>
         <tr style="height:25px">
          <td colspan="2" height="25" align="center" class="dvtCellInfo">第三章</td>
          <td colspan="2" align="center" class="dvtCellInfo">3.2</td>
          <td colspan="2" align="left" class="dvtCellInfo" >包装、保存和标识应符合规格说明图纸或订单的要求，如无要求，刚将采用商业上接受的最佳实践，并至少与有关法律规定相一致。</td>
          <td colspan="2" align="left" class="dvtCellInfo">所有货物均应在妥当考虑货物的性质之同时，以适当方式包装，而包装材料应适于防止货物在运输过程中发生损坏并保证货物抵达目的地时的完整性。</td>
        </tr>
        <tr>
           <td colspan="8" class="detailedViewHeader"><b>价格协议详细信息</b></td>
        </tr>
       <tr style="height:25px">
          <td width="11%" height="25" align="center" class="lvtCol">序号</td>
          <td width="10%" align="center" class="lvtCol">名称</td>
          <td width="13%" align="center" class="lvtCol">规格</td>
           <td width="9%" align="center" class="lvtCol">单价(含税)</td>
           <td width="16%" align="center" class="lvtCol">数量</td>
           <td width="10%" align="center" class="lvtCol">单位</td>
           <td width="15%" align="center" class="lvtCol">总价(含税)</td>
           <td width="16%" align="center" class="lvtCol">备注</td>
        </tr>
        <tr style="height:25px">
          <td width="11%" height="25" align="center" class="dvtCellInfo" >1</td>
          <td width="10%" align="center" class="dvtCellInfo" >物料A</td>
          <td width="13%" align="center" class="dvtCellInfo" >XXX-00</td>
           <td width="9%" align="center" class="dvtCellInfo" >15</td>
           <td width="16%" align="center" class="dvtCellInfo" >2000</td>
           <td width="10%" align="center" class="dvtCellInfo" >个</td>
           <td width="15%" align="center" class="dvtCellInfo" >30000</td>
           <td width="16%" align="center" class="dvtCellInfo" >XXXX</td>
        </tr>
         <tr style="height:25px">
          <td width="11%" height="25" align="center" class="dvtCellInfo" >2</td>
          <td width="10%" align="center" class="dvtCellInfo" >物料B</td>
          <td width="13%" align="center"  class="dvtCellInfo">XXX-01</td>
           <td width="9%" align="center"  class="dvtCellInfo">10</td>
           <td width="16%" align="center"  class="dvtCellInfo">3000</td>
           <td width="10%" align="center"  class="dvtCellInfo">个</td>
           <td width="15%" align="center" class="dvtCellInfo">30000</td>
           <td width="16%" align="center"  class="dvtCellInfo">XXXX</td>
        </tr>
        <tr>
          <td colspan="8" style="padding:5px" height="40"><div align="center">
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