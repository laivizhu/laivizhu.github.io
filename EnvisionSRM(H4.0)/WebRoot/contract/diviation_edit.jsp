<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>偏差编辑界面</title>
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
 
<style type="text/css">
.small
{
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #000000;
}
</style>

</head>

<body>

<div align="right">

  <input title="新增" class="crmbutton small save" onclick="changediviation()" type="button"  value="  新增  " style="width:70px"/>
<input title="插入" class="crmbutton small cancel" onclick="insertdiviation()" type="button" value="  插入  " style="width:70px"/>
<input title="保存" class="crmbutton small save" onclick="confirmDiviation()" type="button"  value="  保存  " style="width:70px"/>
</div>
<table id="diviationList" width="100%" border="0" class="small">
  <tr class="detailedViewHeader">
    <td width="15%" height="30"><b>序号</b></td>
    <td width="40%"><b>预览</b></td>
    <td width="40%"><b>偏差</b></td>
    <td width="5%"><b>操作</b></td>
  </tr>
</table>

<br />

</body>
</html>