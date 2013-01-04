<%--
	User: janlu.sword@gmail.com
	Time: 12-11-11 下午11:08
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>信息记录管理</title>
	<jsp:include page="../common/includeJs.jsp"/>
	<script type="text/javascript" src="../js/system/information.js"></script>
</head>
<body>
<div id="informationListDivId"></div>

<div id="InformationAdd" style="margin:0;display:none;">
<br />
 <form id="InformationAddFormId" method="post" action="information_add.action">
 	<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
      <tr>
        <td width="30%" align="right" valign="middle" class="td_border">类别：</td>
        <td width="70%" align="left" valign="middle" class="td_border">
        <select name="materialCategory.categoryType" id="categorySelectID" style="width:90%;">
        </select>
        </td>
     </tr>
     <tr>
        <td align="right" valign="middle" class="td_border">类别名称：</td>
        <td align="left" valign="middle" class="td_border">
        <input id="materialCategoryInputNameId" type="text" size="25" maxlength="25" style="width:89%;" name="materialCategory.name"/></td>
     </tr>
  	</table>
        <table width="100%">
        <tr>
        <td colspan="2" align="center" height="40">
          <input class="crmbutton small save" type="submit" value="保存" style="width:70px"/>&nbsp;
          <input class="crmbutton small cancel" type="reset" value="取消"  onclick="dialogClose()" style="width:70px"/>
        </td>
        </tr>
    </table>
 </form>
</div>
</body>
</html>
		