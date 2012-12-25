<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>审批意见</title>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
</head>

<body>

<table width="100%" border="0" class="small">
  <tr class="detailedViewHeader">
    <td width="40%"><b>合同编号</b></td>
  </tr>
  <tr>
    <td class="dvtCellLabel">EPACN0012012092710701</td>
  </tr>
  <tr class="detailedViewHeader">
    <td><b>不同意原因</b></td>
  </tr>
  <tr>
    <td><textarea></textarea></td>
  </tr>
</table>
<br />
<div align="center">
<input title="保存" class="crmbutton small save" onclick="javascript:saveSuccess('success')" type="button"  value="  保存  " style="width:70px"/>
<input title="取消" class="crmbutton small cancel" onclick="javascript:saveSuccess('back')" type="button" value="  取消  " style="width:70px"/>
</div>
</body>
</html>