<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>供应商基本信息管理</title>
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <jsp:include page="../common/basicInclude.jsp" />
  <script language="javascript" type="text/javascript" src="../js/material/material_main_view.js"></script>
 
<style type="text/css">
<!--

.STYLE1 {color: red; font-size: 12; }
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="category.jsp">物料类别设置</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="material_main.jsp">物料主数据查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="expenditure.jsp">物料支出分析</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="sourcing.jsp">类别管理七步法</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:15px" nowrap="nowrap">您现在的位置： 物料管理 &gt; 物料主数据查询 </td>
  <td width="100%">&nbsp;</td>
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
<form method="post" action="" >

<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px" >&nbsp;</td>
<td style="width:15%" align="center" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')">浏览物料主数据</td>
<td class="dvtTabCache" style="width:85%">&nbsp;</td>
</tr><tr>
</tr></tbody></table></td>
</tr>
<tr>
<td valign="top" align="left"><div id="basicTab" style="display: block; ">
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
    <tbody>
      <tr>
        <td align="left"><table border="0" cellspacing="0" cellpadding="0" width="100%">
          <tbody>
            <tr>
              <td id="autocom"></td>
            </tr>
            <tr>
              <td style="padding:10px"><!-- General details -->
                    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                      <tbody>
                        <tr style="height:25px">
                          <td >
                           <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
                              <tbody>
                                <tr>
                                  <td colspan="6" class="detailedViewHeader"><b>物料基本数据</b></td>
                                </tr>
                              </tbody></table>
                           <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
                              <tbody>
                                <tr style="height:25px">
                                  <td width="151" class="dvtCellLabel" align="right">物料号</td>
                                  <td width="214" align="left" class="dvtCellInfo"><label id="codeFormFieldId"></label></td>
                                  <td width="149" align="right" class="dvtCellLabel">物料描述</td>
                                  <td width="237" align="left" class="dvtCellInfo"><label id="nameFormFieldId"></label></td>
                                  <td width="148" class="dvtCellLabel" align="right">基本单位</td>
                                  <td width="282" align="left" class="dvtCellInfo"><label id="basicUnitFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td class="dvtCellLabel" align="right">规格</td>
                                  <td width="214" align="left" class="dvtCellInfo"><label id="normFormFieldId"></label></td>
                                  <td width="149" align="right" class="dvtCellLabel">图号</td>
                                  <td width="237" align="left" class="dvtCellInfo"><label id="drawNoFormFieldId"></label></td>
                                  <td width="148" class="dvtCellLabel" align="right">物料组</td>
                                  <td width="282" align="left" class="dvtCellInfo"><label id="materialSAPGroupFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td width="151" class="dvtCellLabel" align="right">采购组</td>
                                  <td width="214" align="left" class="dvtCellInfo"><label id="purchaseGroupFormFieldId"></label></td>
                                  <td align="right" class="dvtCellLabel">&nbsp;</td>
                                  <td align="left" class="dvtCellInfo">&nbsp;</td>
                                  <td class="dvtCellLabel" align="right">&nbsp;</td>
                                  <td align="left" class="dvtCellInfo">&nbsp;</td>
                                </tr>
                               </tbody></table>
                             <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
                              <tbody>
                                <tr>
                                  <td colspan="6" class="detailedViewHeader"><b>供应商信息</b></td>
                                </tr>
                                <tr style="height:25px">
                                  <td width="151" class="dvtCellLabel" align="right">供应商账户号</td>
                                  <td width="214" align="left" class="dvtCellInfo"><label id="supplierAccountNoFormFieldId"></label></td>
                                  <td width="149" align="right" class="dvtCellLabel">订单单位</td>
                                  <td width="237" align="left" class="dvtCellInfo"><label id="orderUnitFormFieldId"></label></td>
                                  <td width="148" class="dvtCellLabel" align="right">订单到基本单位分母</td>
                                  <td width="282" align="left" class="dvtCellInfo"><label id="denoUnitFormFieldId"></label></td>
                                </tr>
                                
                                 <tr style="height:25px">
                                  <td width="151" class="dvtCellLabel" align="right">订单到基本单位分子</td>
                                  <td width="214" align="left" class="dvtCellInfo"><label id="moleUnitFormFieldId"></label></td>
                                  <td width="149" align="right" class="dvtCellLabel">税代码</td>
                                  <td width="237" align="left" class="dvtCellInfo"><label id="taxCodeFormFieldId"></label></td>
                                  <td width="148" class="dvtCellLabel" align="right">最小订单数量</td>
                                  <td width="282" align="left" class="dvtCellInfo"><label id="minOrderCountFormFieldId"></label></td>
                                </tr>
                                 <tr style="height:25px">
                                  <td width="151" class="dvtCellLabel" align="right">标准数量</td>
                                  <td width="214" align="left" class="dvtCellInfo"><label id="standCountFormFieldId"></label></td>
                                  <td width="149" align="right" class="dvtCellLabel">计划交货时间</td>
                                  <td width="237" align="left" class="dvtCellInfo"><label id="exchangeTimeFormFieldId"></label></td>
                                  <td width="148" class="dvtCellLabel" align="right">采购组供应商</td>
                                  <td width="282" align="left" class="dvtCellInfo"><label id="purchGroupFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td width="151" class="dvtCellLabel" align="right">确认控制</td>
                                  <td width="214" align="left" class="dvtCellInfo"><label id="confirmControlFormFieldId"></label></td>
                                  <td width="149" align="right" class="dvtCellLabel">物料编号</td>
                                  <td width="237" align="left" class="dvtCellInfo"><label id="materialCodeFormFieldId"></label></td>
                                  <td class="dvtCellLabel" align="right">&nbsp;</td>
                                  <td align="left" class="dvtCellInfo">&nbsp;</td>
                                </tr>
                               </tbody></table>

                                <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
                                  <tbody>
                                  <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>价格单位及有效期</b></td>
                                  </tr>
                                  <tr><td>
                                      <div id="priceTableId"></div>
                                  </td></tr>
                                  </tbody>
                                </table>
                               
                               
                                <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
                                  <tbody>
                                 <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>货源清单记录</b></td>
                                </tr>
                                  <tr><td>
                                      <div id="orderTableId"></div>
                                  </td></tr>
                                  </tbody>
                                </table>
                                
                                <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
                                  <tbody>
                                <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>配额</b></td>
                                </tr>
                                  <tr><td>
                                      <div id="quotaTableId"></div>
                                  </td></tr>
                                  </tbody>
                                </table>
                                
                          </td>
                        </tr>
                      </tbody>
                    </table></td>
            </tr>
          </tbody>
        </table></td>
      </tr>
    </tbody>
  </table>
</div>
  <!-- Basic Information Tab Closed --></td>
</tr>
</tbody></table>
  </table>

<!-- 网站底部 -->

<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>