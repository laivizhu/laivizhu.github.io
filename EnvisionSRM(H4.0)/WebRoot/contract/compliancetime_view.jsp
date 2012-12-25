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
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
<td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>时间与价格合规性</b></td>
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
    <td  align="left"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
      
        <tr>
          <td colspan="7" class="detailedViewHeader"><b>合同基本信息</b></td>
        </tr>
        <tr style="height:25px">
          <td height="25" colspan="2" align="right" class="dvtCellLabel">合同编号</td>
          <td width="19%"  align="left" class="dvtCellInfo">EPACN0012012092710701</td>
          <td colspan="2" align="right" class="dvtCellLabel">供应商名称</td>
          <td width="20%" align="left" class="dvtCellInfo">深圳市达力科技开发有限公司
          </td>
          <!-- Non Editable field, only configured value will be loaded -->         
        </tr>
        <tr style="height:25px">
          <td height="25" colspan="2" align="right" class="dvtCellLabel">采购负责人</td>
          <td width="19%"  align="left" class="dvtCellInfo">张三</td>
          <td colspan="2" align="right" class="dvtCellLabel">状态</td>
          <td width="20%" align="left" class="dvtCellInfo">待审批</td>
          <!-- Non Editable field, only configured value will be loaded -->         
        </tr>
        <tr height="25">
          <td colspan="7" class="">&nbsp;</td>
        </tr>
         <tr>
           <td colspan="7" class="detailedViewHeader"><b>时间与价格合规性审查</b></td>
         </tr>
         <tr style="height:25px">
           <td height="25" colspan="3" align="center" class="dvtCellLabel"><b>合同信息记录</b></td>
           <td height="25" colspan="3" align="center" class="dvtCellLabel"><b>SAP信息记录</b></td>
         </tr>
         <tr style="height:25px">
           <td width="15%" height="25" align="center" class="dvtCellInfo">物料名称</td>
           <td width="14%" align="center" class="dvtCellInfo">时间</td>
           <td height="25" align="center" class="dvtCellInfo">单价(RMB)</td>
           <td width="17%" height="25" align="center" class="dvtCellInfo">时间</td>
           <td width="15%" align="center" class="dvtCellInfo">数量(个)</td>
           <td height="25" align="center" class="dvtCellInfo">单价(RMB)</td>
         </tr>
         <tr style="height:25px">
           <td rowspan="4" align="center" class="dvtCellInfo">物料A</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">2012/1-2012/6</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">15.00</td>
           <td height="12" align="center" class="dvtCellInfo">2012/1-2012/3</td>
           <td height="12" align="center" class="dvtCellInfo">300</td>
           <td height="12" align="center" class="dvtCellInfo">15.50</td>
         </tr>
         <tr style="height:25px">
           <td height="13" align="center" class="dvtCellInfo">2012/3-2012/6</td>
           <td height="13" align="center" class="dvtCellInfo">200</td>
           <td height="13" align="center" class="dvtCellInfo">14.80</td>
         </tr>
         <tr style="height:25px">
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">2012/6-2012/12</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">18.00</td>
           <td height="12" align="center" class="dvtCellInfo">2012/6-2012/9</td>
           <td height="12" align="center" class="dvtCellInfo">400</td>
           <td height="12" align="center" class="dvtCellInfo">14.00</td>
         </tr>
         <tr style="height:25px">
           <td height="13" align="center" class="dvtCellInfo">2012/9-2012/12</td>
           <td height="13" align="center" class="dvtCellInfo">600</td>
           <td height="13" align="center" class="dvtCellInfo">14.50</td>
         </tr>
         
         
          <tr style="height:25px">
           <td rowspan="4" align="center" class="dvtCellInfo">物料B</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">2012/1-2012/6</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">15.00</td>
           <td height="12" align="center" class="dvtCellInfo">2012/1-2012/3</td>
           <td height="12" align="center" class="dvtCellInfo">300</td>
           <td height="12" align="center" class="dvtCellInfo">15.50</td>
         </tr>
         <tr style="height:25px">
           <td height="13" align="center" class="dvtCellInfo">2012/3-2012/6</td>
           <td height="13" align="center" class="dvtCellInfo">200</td>
           <td height="13" align="center" class="dvtCellInfo">14.80</td>
         </tr>
         <tr style="height:25px">
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">2012/6-2012/12</td>
           <td height="25" rowspan="2" align="center" class="dvtCellInfo">18.00</td>
           <td height="12" align="center" class="dvtCellInfo">2012/6-2012/9</td>
           <td height="12" align="center" class="dvtCellInfo">400</td>
           <td height="12" align="center" class="dvtCellInfo">14.00</td>
         </tr>
         <tr style="height:25px">
           <td height="13" align="center" class="dvtCellInfo">2012/9-2012/12</td>
           <td height="13" align="center" class="dvtCellInfo">600</td>
           <td height="13" align="center" class="dvtCellInfo">14.50</td>
         </tr>
         
         
         
         
        <tr>
          <td colspan="7" style="padding:5px" height="40"><div align="center">
            <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  返回  " style="width:70px" />
          </div></td>
        </tr>
      </tbody>
    </table> </td>
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
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>