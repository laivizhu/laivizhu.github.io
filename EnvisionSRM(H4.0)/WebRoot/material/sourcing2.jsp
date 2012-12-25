<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>2.分析采购需求</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/content.css"/>
  <link rel="stylesheet" type="text/css" href="../css/common.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
  <script language="javascript" type="text/javascript" src="../js/common.js"></script>
</head>

<body class="small" style="margin:0;padding:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级导航 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="category.jsp">物料类别设置</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="material_main.jsp">物料主数据查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="expenditure.jsp">物料支出分析</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="sourcing.jsp">类别管理七步法</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap">您现在的位置： 采购项目管理 &gt; 类别管理七步法 &gt; 2.分析采购需求</td>
  <td width="100%">&nbsp;</td>
  <td align="right" style="padding-right:15px;">
  	<jsp:include page="../common/toolbar.jsp" flush="true"/>
  </td>
</tr></tbody>
</table>

<!-- Content -->	
<table width="100%" class="content_background" cellpadding="0" cellspacing="0" border="0" align="center" ><tbody><tr>
<td width="100%" align="left" valign="top">
<!-- 内容开始 -->
<div id="tabs" class="content_tab">
<div style="padding-left:15px;">
  <a href="sourcing.jsp" target="_self">1.&nbsp;分析类别支出</a> &gt; 
  <a href="sourcing2.jsp" target="_self" style="font-weight:bold;">2.&nbsp;分析采购需求</a> &gt;
  <a href="sourcing3.jsp" target="_self">3.&nbsp;组建类别团队</a> &gt;
  <a href="sourcing4.jsp" target="_self">4.&nbsp;分析供应市场</a> &gt;
  <a href="sourcing5.jsp" target="_self">5.&nbsp;制定类别策略</a> &gt;
  <a href="sourcing6.jsp" target="_self">6.&nbsp;制定实施计划</a> &gt;
  <a href="sourcing7.jsp" target="_self">7.&nbsp;查询方案进度</a>
</div>
<hr style="width:98%; margin-top:10px; margin-bottom:10px;"  />

<!-- Content Tab Tabs -->
<div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab1" class="content_tab_title_selected" align="center" onclick="showTab(1,4);">确认内部客户</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab2" class="content_tab_title_unselected" align="center" onclick="showTab(2,4);">明确需求</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab3" class="content_tab_title_unselected" align="center" onclick="showTab(3,4);">分析需求</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab4" class="content_tab_title_unselected" align="center" onclick="showTab(4,4);">明确机遇</td>
    <td class="content_tab_title_cache" style="width:100%"></td>
  </tr></tbody></table>
</div>

<!-- Content Tab Divs -->
<div class="content_tab_detail">
    <div id="div1" class="content_tab_div_selected">
    <form action="#" method="post">
    <table width="100%">
    <tr>
    <td align="left">
     <div style="margin-left:10px">
        <input class="crmbutton small save" type="submit" value="新增策略" style="width:70px"/>
        </div>
       </td>
    </tr>
    </table>
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
        <td width="20%" align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
        <td width="20%" align="center" valign="middle" class="td_border">
            <textarea rows="5" class="textarea_style"></textarea>
        </td>
        <td width="15%" align="center" valign="middle" class="td_border"><textarea name="textarea2" rows="5" class="textarea_style"></textarea></td>
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
    <div style="height:80px;"></div>
    </div>
    <div id="div2" class="content_tab_div_unselected">
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
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">成本</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">物流</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">发展</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="td_border_title">管理</td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
    <td align="center" valign="middle" class="td_border"><textarea name="textarea6" rows="5" class="textarea_style"></textarea></td>
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
<div style="margin-top:93px;"></div>
    </div>
    <div id="div3" class="content_tab_div_unselected">
    	<form action="#" method="post">
        <table width="100%">
    <tr>
    <td align="left">
      <div style="margin-left:10px">
        <input class="crmbutton small save" type="submit" value="新增需求" style="width:70px"/>
        </div></td>
    </tr>
    </table>
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
    	<textarea rows="5" class="textarea_style"></textarea>
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
		<div style="height:105px;"></div>
    </div>
    <div id="div4" class="content_tab_div_unselected">
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
    <td align="center" valign="middle" class="td_border_title">
      物料小组A
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
		<div style="height:80px;"></div>
    </div>
    
</div>

<!-- Ends of Content Tab-->
</div>


</td>
</tr></tbody></table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>