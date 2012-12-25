<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>合同管理-采购平台</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="../css/style.css"/>

<script language="javascript" type="text/javascript" src="../js/general.js"></script>
</script>
</head>

<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
<td valign="top"><img src="../images/showPanelTopLeft.gif"/></td>
<td class="showPanelBg" valign="top" width="100%" style="padding:10px;">
<br/>
<!--  内部内容div-->
<div class="small" style="padding: 10px;">
<form id="yearcontract" name="yearcontract" action="yearcontractUpload.action" method="post" >
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px" >&nbsp;</td>
<td style="width:15%" align="center"  class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>上传信息</b></td>
<td class="dvtTabCache" style="width:85%" >&nbsp;</td>
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
          <td colspan="4" style="padding:5px">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="4" class="detailedViewHeader"><b>年度合同上传信息</b></td>
        </tr>
        <tr style="height:25px">
          <td width="20%" height="33" align="right" class="dvtCellLabel">年度合同名称</td>
          <td width="30%" align="left" class="dvtCellInfo"><input type="text" name="name" tabindex="" class="detailedViewTextBox" onfocus="this.className='detailedViewTextBoxOn'" onblur="this.className='detailedViewTextBox'" style="width:58%;" value="2012年度合同" /></td>
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>年度合同附件 </td>
          <td width="80%" align="left" class="dvtCellInfo"><input type="file" name="path" tabindex="" class="detailedViewTextBox" onfocus="this.className='detailedViewTextBoxOn'" onblur="this.className='detailedViewTextBox'" style="width:80%;" value="" /></td>
        </tr>
        <tr style="height:25px">
          <td width="20%" height="31" align="right" class="dvtCellLabel"><font color="red"></font>生效起始日期</td>
          <td width="30%" align="left" class="dvtCellInfo"><input type="text" name="begindate" tabindex="" class="detailedViewTextBox" onfocus="this.className='detailedViewTextBoxOn'" onblur="this.className='detailedViewTextBox'" style="width:58%;" value="2012-10-01" /></td>
          <td width="20%" class="dvtCellLabel" align="right"><font color="red"></font>生效截止日期 </td>
          <td width="80%" align="left" class="dvtCellInfo"><input type="text" name="enddate" tabindex="" class="detailedViewTextBox" onfocus="this.className='detailedViewTextBoxOn'" onblur="this.className='detailedViewTextBox'" style="width:58%;" value="2013-10-30" /></td>
        </tr>
        <tr>
          <td colspan="4" style="padding:5px"><div align="center">
            <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save"  type="button" value="  保存  " style="width:70px" onclick="check()"/>
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

<!-- div内容结束-->
</td>
</tr>
</tbody></table>
