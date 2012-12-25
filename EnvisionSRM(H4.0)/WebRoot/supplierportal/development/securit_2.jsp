<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>

<div id="div2" class="small" style="width:100%;position:relative;display:none">
  <form id="#" enctype="multipart/form-data" method="post" action="supplierPortalSecurit_supplierAdd.action"  target="_parent">
  <table width="100%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>上传保密协议</b></td>
  </tr></table>
  <table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
    <tbody> 
      <s:if test="#request.isStandard == true">  
      <tr style="height:25px">
        <td width="37%" align="right" class="dvtCellLabel">标准保密协议</td>
        <td width="63%" align="left" class="dvtCellInfo"><input type="file" style="width:308px;" name="upload"/></td>
      </tr>
      </s:if>
      <s:else>
      <tr style="height:25px">
        <td width="37%"  class="dvtCellLabel" align="right">非标准保密协议</td>
        <td width="63%" align="left" class="dvtCellInfo"><input type="file" style="width:308px;" name="upload"/></td>
      </tr>
      </s:else>
      <tr>
        <td colspan="10" style="padding:5px" height="40px;"><div align="center">
          <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save" type="submit" name="button2" value="确定" style="width:70px" />
          &nbsp;
          <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onClick="requestTemplate();"  type="button" name="button" value="  取消  " style="width:70px" />
        </div></td>
      </tr>
    </tbody>
  </table>
  </form>
</div>


