<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>插入偏差</title>
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
<script type="text/javascript">

</script>
</head>

<body>
<div align="left" >
  <tr>
    <td colspan="4" class="detailedViewHeader" ><b>插入偏差</b>(备注：即针对所选择序号下插入一条新的合同协议)</td>
  </tr>
</div>
<table width="100%" border="0" class="small">
  <tr class="detailedViewHeader">
    <td width="25%" height="30"><b>当前序号</b>(选择需要插入协议的父序号)</td>
    <td width="25%"><b>新增序号</b></td>
    <td width="50%"><b>偏差</b>(插入新协议的内容)</td>
  </tr>
  <tr>
    <td class="dvtCellLabel"><select name="diviationid1" id="diviationid1" style="width:100%" onchange="changediviationid(this.id)">
      
    </select></td>
    <td class="dvtCellInfo"><input name="newid" id="newid" value="" readonly="readonly" /></td> 
    <td><textarea name="diviationContent1" id="diviationContent1"></textarea></td>
  </tr>  
</table>
<br />
<div align="center">
  <input title="确定" class="crmbutton small save" onclick="showDiviationInsertDialog()" type="button"  value="  确定  " style="width:70px"/>
  &nbsp;
<input title="取消" class="crmbutton small cancel" onclick="diviationCancel()" type="button" value="  取消  " style="width:70px"/>

</div>
</body>
</html>