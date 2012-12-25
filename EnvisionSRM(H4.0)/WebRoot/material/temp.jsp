<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>类别寻源</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/content.css"/>
  <link rel="stylesheet" type="text/css" href="../css/common.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
  <script language="javascript" type="text/javascript" src="../js/common.js"></script>
</head>

<body class="small" style="margin:0;padding:0;"><div class="content_tab_detail">
<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>审批状态</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td align="center" valign="middle" class="td_border_title">项目</td>
    <td align="center" valign="middle" class="td_border_title"><p>是否通过审核</p></td>
    </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">改善机会分析</td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox8" id="checkbox8" /></td>
    </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">制定方案</td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox9" id="checkbox9" /></td>
    </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">收益机会预估</td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox10" id="checkbox10" /></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">风险记录</td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox11" id="checkbox11" /></td>
  </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>
<p></p>
<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>收益机会预估</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="33%" align="center" valign="middle" class="td_border_title">物料名称</td>
    <td width="33%" align="center" valign="middle" class="td_border_title"><p>收益实现难度</p></td>
    <td width="33%" align="center" valign="middle" class="td_border_title"><p>潜在收益</p></td>
    </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title"><span class="td_border">
      <input type="text" size="25" maxlength="25" class="input_style" />
    </span></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title"><span class="td_border">
      <input type="text" size="25" maxlength="25" class="input_style" />
    </span></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>
<p></p>
<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>改善机会分析</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="20%" align="center" valign="middle" class="td_border_title">项目</td>
    <td align="center" valign="middle" class="td_border_title">内容优化机会</td>
    </tr>
    <tr>
    <td align="center" valign="middle" class="td_border">现状概述</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea12" rows="5" class="textarea_style"></textarea></td>
    </tr>
    <tr>
    <td align="center" valign="middle" class="td_border">原理及目标</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea12" rows="5" class="textarea_style"></textarea></td>
    </tr>
    <tr>
    <td align="center" valign="middle" class="td_border">方案内容</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea12" rows="5" class="textarea_style"></textarea></td>
    </tr>
    <tr>
    <td align="center" valign="middle" class="td_border">潜在收益</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea12" rows="5" class="textarea_style"></textarea></td>
    </tr>
    <tr>
    <td align="center" valign="middle" class="td_border">主要风险</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea12" rows="5" class="textarea_style"></textarea></td>
    </tr>
    <tr>
    <td align="center" valign="middle" class="td_border">所需资源</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea12" rows="5" class="textarea_style"></textarea></td>
    </tr>
    <tr>
    <td align="center" valign="middle" class="td_border">参考性</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea12" rows="5" class="textarea_style"></textarea></td>
    </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>

</form>
<p></p>
<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>改善机会分析</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="33%" align="center" valign="middle" class="td_border_title">现状</td>
    <td width="33%" align="center" valign="middle" class="td_border_title">问题总结</td>
    <td width="33%" align="center" valign="middle" class="td_border_title">优化机会</td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea11" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border">
      <textarea rows="5" class="textarea_style"></textarea>
      </td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea4" rows="5" class="textarea_style"></textarea></td>
    </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>

</form>

<p></p>
<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>SWOT分析</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="10%" rowspan="2" align="center" valign="middle" class="td_border" style=" font-weight:bold; font-size:large;">内<br/><br />部</td>
    <td width="45%" height="25" align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;">本类别的优势（S）</td>
    <td width="45%" align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;">本类别的劣势（W）</td>
    </tr>
  <tr>
    <td align="center" height="100" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;" ><textarea name="textarea6" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;"><textarea name="textarea8" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    </tr>
  <tr>
    <td  rowspan="2" align="center" valign="middle" class="td_border" style=" font-weight:bold; font-size:large;">外<br/><br />部</td>
    <td height="25" align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;">本类别的机会（O）</td>
    <td align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;">本类别的挑战（T）</td>
    </tr>
  <tr>
    <td align="center" height="100" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;" ><textarea name="textarea6" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border" style="background-color:#E1E1E1; font-weight:bold;"><textarea name="textarea8" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>

<p></p><p></p>
<form action="#" method="post">
  <table width="98%" align="center" cellpadding="3" cellspacing="0">
    <tr>
      <td class="detailedViewHeader"><b>波特五力</b></td>
    </tr>
  </table>
  <table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border" style="border:1px solid #DDDDDD;">
    <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td height="25" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">进入者威胁</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center" valign="middle" style="background-color:#E1E1E1">
      <textarea name="textarea10" rows="10" wrap="hard" class="textarea_style"></textarea>
    </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center" valign="middle"><img src="../images/arrow_down.png" width="80" height="30" /></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="30%" height="25" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">供应商协议能力</td>
    <td width="5%" rowspan="2" align="center" valign="middle"><img src="../images/arrow_right.png" width="30" height="80" /></td>
    <td width="30%" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">市场竞争</td>
    <td width="5%" rowspan="2" align="center" valign="middle"><img src="../images/arrow_left.png" width="30" height="80" /></td>
    <td width="30%" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">客户议价能力</td>
  </tr>
  <tr>
    <td align="center" height="100" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">
      <textarea name="textarea6" rows="10" wrap="hard" class="textarea_style"></textarea>
    </td>
    <td align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;"><textarea name="textarea8" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;"><textarea name="textarea9" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td height="25" align="center" valign="middle"><img src="../images/arrow_up.png" width="80" height="30" /></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td height="25" align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">替代者威胁</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center" valign="middle" style="background-color:#E1E1E1; font-weight:bold;">
      <textarea name="textarea10" rows="10" wrap="hard" class="textarea_style"></textarea>
    </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>

<p></p><p></p>
<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>供应链分析</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="30%" height="25" align="center" valign="middle" class="td_border_title">供应链现状</td>
    <td width="5%" rowspan="2" align="center" valign="middle" class="td_border_title"><img src="../images/arrow_right.png" width="30" height="80" /></td>
    <td width="30%" align="center" valign="middle" class="td_border_title">启示</td>
    <td width="5%" rowspan="2" align="center" valign="middle" class="td_border_title"><img src="../images/arrow_right.png" width="30" height="80" /></td>
    <td width="30%" align="center" valign="middle" class="td_border_title">策略关注点</td>
    </tr>
  <tr>
    <td align="center" height="100" valign="middle" class="td_border" ><textarea name="textarea6" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea8" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea9" rows="10" wrap="hard" class="textarea_style"></textarea></td>
    </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>


<p></p><p></p>
<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>风险记录</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="10%" align="center" valign="middle" class="td_border_title">序号</td>
    <td width="15%" align="center" valign="middle" class="td_border_title">风险描述</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">提出人</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">提出时间</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">严重程度</td>
    <td width="15%" align="center" valign="middle" class="td_border_title">解决方案</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">责任人</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">计划解决日期</td>
    <td width="10%" align="center" valign="middle" class="td_border_title">问题状态</td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">1</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" wrap="hard" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border">
    <select name="select" id="select">
    	<option value="0">张飞</option>
        <option value="1">诸葛亮</option>
    </select>
    </td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border">
    <select name="select3" id="select3">
      <option value="1">不严重</option>
      <option value="0">一般</option>
      <option value="1">很严重</option>
    </select></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea7" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><select name="select2" id="select2">
      <option value="0">张飞</option>
      <option value="1">诸葛亮</option>
    </select></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><select name="select4" id="select4">
      <option value="1">已解决</option>
      <option value="0">正在进行中</option>
      <option value="1">尚未开始</option>
    </select></td>
  </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>



<p></p><p></p>
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>当前类别团队</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="25%" align="right" valign="middle" class="td_border_title">团队名称：</td>
    <td width="75%" valign="middle" class="td_border">风机类别团队</td>
    </tr>
  <tr>
    <td align="right" valign="middle" class="td_border_title">团队负责人：</td>
    <td valign="middle" class="td_border">刘备</td>
  </tr>
  <tr>
    <td align="right" valign="middle" class="td_border_title">创建时间：</td>
    <td valign="middle" class="td_border">2012-11-08</td>
  </tr>
  <tr>
    <td align="right" valign="middle" class="td_border_title">修改时间：</td>
    <td valign="middle" class="td_border">2012-11-11</td>
  </tr>
  <tr>
    <td align="right" valign="middle" class="td_border_title">团队成员：</td>
    <td valign="middle" class="td_border">张飞、关羽、诸葛亮</td>
  </tr>

</table>

<p>&nbsp;</p><p>&nbsp;</p>
<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>类别改善机会</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="16%" align="center" valign="middle" class="td_border_title">物料小组</td>
    <td width="12%" align="center" valign="middle" class="td_border_title">优化供应源</td>
    <td width="12%" align="center" valign="middle" class="td_border_title">改善供需关系</td>
    <td width="12%" align="center" valign="middle" class="td_border_title">优化总成本</td>
    <td width="12%" align="center" valign="middle" class="td_border_title">优化流程</td>
    <td width="12%" align="center" valign="middle" class="td_border_title">整合支出</td>
    <td width="12%" align="center" valign="middle" class="td_border_title"><p>质量标准化</p></td>
    <td width="12%" align="center" valign="middle" class="td_border_title">避免支出</td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title"><span class="td_border">
      <input type="text" size="30" maxlength="30" class="input_style" />
    </span></td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox" id="checkbox" /></td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox3" id="checkbox3" /></td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox4" id="checkbox4" /></td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox5" id="checkbox5" /></td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox6" id="checkbox6" /></td>
    <td align="center" valign="middle" class="td_border"><input type="checkbox" name="checkbox7" id="checkbox7" /></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">说明</td>
    <td colspan="7" align="center" valign="middle" class="td_border"><textarea name="textarea5" rows="5" class="textarea_style"></textarea></td>
    </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>

<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>分析需求</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td align="center" valign="middle" class="td_border_title">利益关系者</td>
    <td align="center" valign="middle" class="td_border_title">质量</td>
    <td align="center" valign="middle" class="td_border_title">成本</td>
    <td align="center" valign="middle" class="td_border_title">物流</td>
    <td align="center" valign="middle" class="td_border_title">发展</td>
    <td align="center" valign="middle" class="td_border_title">管理</td>
  </tr>
  <tr>
    <td width="25%" align="center" valign="middle" class="td_border">
    	<input type="text" size="30" maxlength="30" class="input_style" />
    </td>
    <td width="15%" align="center" valign="middle" class="td_border">
    	<textarea rows="5" class="textarea_style"></textarea>
    </td>
    <td width="15%" align="center" valign="middle" class="td_border"><textarea name="textarea" rows="5" class="textarea_style"></textarea></td>
    <td width="15%" align="center" valign="middle" class="td_border"><textarea name="textarea2" rows="5" class="textarea_style"></textarea></td>
    <td width="15%" align="center" valign="middle" class="td_border"><textarea name="textarea3" rows="5" class="textarea_style"></textarea></td>
    <td width="15%" align="center" valign="middle" class="td_border"><textarea name="textarea4" rows="5" class="textarea_style"></textarea></td>
  </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>

</form>

<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>明确需求</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="25%" align="center" valign="middle" class="td_border_title">&nbsp;</td>
    <td width="25%" align="center" valign="middle" class="td_border_title">短期（0~6个月）</td>
    <td width="25%" align="center" valign="middle" class="td_border_title">中期（7~18个月）</td>
    <td width="25%" align="center" valign="middle" class="td_border_title">长期（18个月以上）</td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">质量</td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">成本</td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">物流</td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">发展</td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">管理</td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
    <td align="center" valign="middle" class="td_border"><input type="text" size="25" maxlength="25" class="input_style" /></td>
  </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>

<form action="#" method="post">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>确认内部客户表</b></td>
    </tr></table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td rowspan="2" align="center" valign="middle" class="td_border_title">内部客户/利益关系者</td>
    <td rowspan="2" align="center" valign="middle" class="td_border_title">关注点</td>
    <td colspan="4" align="center" valign="middle" class="td_border_title">沟通策略</td>
    </tr>
  <tr>
    <td align="center" valign="middle" class="td_border">沟通目的</td>
    <td align="center" valign="middle" class="td_border">沟通信息</td>
    <td align="center" valign="middle" class="td_border">沟通方式</td>
    <td align="center" valign="middle" class="td_border">沟通频率</td>
  </tr>
  <tr>
    <td width="20%" align="center" valign="middle" class="td_border">
    	<input type="text" size="30" maxlength="30" class="input_style" />
    </td>
    <td width="20%" align="center" valign="middle" class="td_border">
    	<textarea rows="5" class="textarea_style"></textarea>
    </td>
    <td width="15%" align="center" valign="middle" class="td_border"><textarea name="textarea" rows="5" class="textarea_style"></textarea></td>
    <td width="15%" align="center" valign="middle" class="td_border"><textarea name="textarea2" rows="5" class="textarea_style"></textarea></td>
    <td width="15%" align="center" valign="middle" class="td_border"><textarea name="textarea3" rows="5" class="textarea_style"></textarea></td>
    <td width="15%" align="center" valign="middle" class="td_border"><textarea name="textarea4" rows="5" class="textarea_style"></textarea></td>
  </tr>
</table>
<table width="100%">
<tr>
<td align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>

</form>




</div></body></html>