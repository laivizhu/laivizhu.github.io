<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.0.custom.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript" type="text/javascript" src="../js/calc.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_set.jsp">供应商注册管理</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_sourceProject.jsp">供应商寻源项目管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_develop.jsp">寻源进度报告</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="supplier_securit.jsp">供应商保密协议管理</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap">您现在的位置：供应商关系管理 &gt; 供应商保密协议管理</td>
      <td width="100%" align="center" valign="middle"></td>
      <td align="right" style="padding-right:15px;"><jsp:include page="../common/toolbar.jsp" flush="true"/>
      </td>
    </tr>
  </tbody>
</table>
<!-- 网站中部 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
  <tbody>
    <tr>
      <td width="100%" align="left" valign="top" style="padding-left:10px; padding-top:20px;" >
        <div class="contentListDiv">
        
        <form method="post" action="securit_confirmCancel.action" >
        <input type="hidden" name="id" value="<s:property value="%{#request.securitBean.id}"/>"/>
        <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
          <tbody>
            <tr>
              <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
                  <tbody>
                    <tr>
                      <td class="dvtTabCache" style="width:10px" >&nbsp;</td>
                      <td style="width:15%" align="center" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><strong>终止保密协议</strong></td>
                      <td class="dvtTabCache" style="width:85%">&nbsp;</td>
                    </tr>
                  </tbody>
                </table></td>
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
                              <tr><td style="padding:10px"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                    <tbody>
                                      <tr style="height:25px"><td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                            <tbody>
                                              <tr>
                                                <td colspan="4" class="detailedViewHeader"><strong>终止保密协议</strong></td>
                                              </tr>
                                              <tr style="height:25px">
                                                <td width="43%" align="right" class="dvtCellLabel">保密协议名称</td>
                                                <td width="57%" align="left" class="dvtCellInfo"><s:property value="%{#request.securitBean.name}"/></td>
                                              </tr>
                                              <tr style="height:25px">
                                                <td align="right" class="dvtCellLabel">供应商名称</td>
                                                <td align="left" class="dvtCellInfo"><s:property value="%{#request.supplierName}"/></td>
                                              </tr>
  <s:if test="#request.isStandard == true"> 
  <tr style="height:25px">
    <td class="dvtCellLabel" align="right">标准保密协议</td>
    <td align="left" class="dvtCellInfo"><s:property value="%{#request.securitBean.securitSupplier}"/></td>
  </tr>
  </s:if>
  
  <s:else>
  <tr style="height:25px">
    <td class="dvtCellLabel" align="right">非标准保密协议</td>
    <td align="left" class="dvtCellInfo"><s:property value="%{#request.securitBean.securitSupplier}"/></td>
  </tr>
  </s:else>
                                              <tr style="height:25px">
                                                <td class="dvtCellLabel" align="right">备注</td>
                                                <td align="left" class="dvtCellInfo"><s:property value="%{#request.securitBean.remark}"/></td>
                                              </tr>
                                              <tr style="height:25px">
                                                <td class="dvtCellLabel" align="right">失效原因</td>
                                                <td align="left" class="dvtCellInfo"><textarea style="width:305px;overflow-y:auto;" id="effectReason"></textarea></td>
                                              </tr>
                                              <tr>
                                                <td colspan="10" style="padding:5px" height="40px;"><div align="center">
                                                    <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save" type="submit" name="button" value="确定" style="width:70px" />&nbsp;
                                                    <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('supplier_securit.jsp')"  type="button" name="button" value="  取消  " style="width:70px" />
                                                  </div></td>
                                              </tr>
                                            </tbody>
                                      </table></td></tr>
                                    </tbody>
                              </table></td></tr>
                            </tbody>
                          </table></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
        </form>
        </div>
      </td>
      </tr></tbody>
</table>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
