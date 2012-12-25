<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>电子竞标</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.0.custom.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript" type="text/javascript" src="../js/calc.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
<script language="javascript">
	function supplierChoose() {
		$("#supplier").dialog({
			autoOpen : false,
			title : "选择供应商",
			modal : true,
			width : 800,
			height : 500,
			resizable : false,
		});

		$("#supplier").dialog("open");
	}

	function materialChoose() {
		$("#material").dialog({
			autoOpen : false,
			title : "选择物料",
			modal : true,
			width : 800,
			height : 500,
			resizable : false,
		});

		$("#material").dialog("open");
	}
</script>

</head>
<body class="small" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0"  rightmargin="0" bottommargin="0">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="bid_frame.jsp">年度招标</a> </td>
      <td class="level2SelTab" nowrap="nowrap"><a href="auction_frame.jsp">电子竞标</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="strategy_material.jsp">物料类别策略执行</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="strategy_supplier.jsp">供应商管理策略执行</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 采购项目管理管理 &gt; 电子竞标 &gt; 新建竞标项目</td>
      <td width="100%" align="center" valign="middle"></td>
      <td align="right" style="padding-right:15px;"><jsp:include page="../common/toolbar.jsp" flush="true"/>
      </td>
    </tr>
  </tbody>
</table>
<!-- 工作台 -->
<div class="contentListDiv">
  <form name="EditView" method="" action="" onsubmit="">
    <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
      <tbody>
        <tr>
          <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
            <tbody>
              <tr>
                <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
                <td style="width:15%" align="center" nowrap=""
															class="dvtSelectedCell" id="bi"
															onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>新建竞标项目</b> </td>
                <td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
              </tr>
            </tbody>
          </table></td>
        </tr>
        <tr>
          <td valign="top" align="left"><div id="basicTab2" style="display: block; ">
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
                                      <td width="30%" align="left" class="dvtCellInfo"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                          <tbody>
                                            <tr>
                                              <td colspan="4" class="detailedViewHeader"><strong>新建竞标项目</strong> </td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="37%" class="dvtCellLabel" align="right">竞标项目名称</td>
                                              <td width="63%" colspan="3" align="left" class="dvtCellInfo"><input type="text" name="lastname2" tabindex="" class="detailedViewTextBox" style="width:300px;" value="" /></td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="37%" class="dvtCellLabel" align="right"> 供应商清单 </td>
                                              <td colspan="3" align="left" class="dvtCellInfo"><input type="text" name="lastname" tabindex="" class="detailedViewTextBox"  style="width:300px;" value="" />
                                                浏览供应商: <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer"/> <img src="../images/clear.gif" alt="清除" title="清除" onclick="document.EditView.lastname2.value=''; document.EditView.lastname2.value='';" align="absmiddle" style="cursor:hand;cursor:pointer" /> </td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="37%" class="dvtCellLabel" align="right"><font color="red"></font>上传竞标文件</td>
                                              <td colspan="3" width="63%" align="left" class="dvtCellInfo"><input type="file" style="width:308px;"/></td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="37%" class="dvtCellLabel" align="right">上传竞标协议</td>
                                              <td colspan="3" align="left" class="dvtCellInfo"><input type="file" style="width:308px;"/></td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="37%" class="dvtCellLabel" align="right">备注</td>
                                              <td width="63%" align="left" class="dvtCellInfo"><textarea name="textarea" style="width:303px;overflow-y:auto;"></textarea></td>
                                            </tr>
                                            <tr>
                                              <td height="40px;" colspan="4" style="padding:5px"><div align="center">
                                                  <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" 
                                                     onclick="show2();" type="submit" name="button" value="保存" style="width:70px" />
                                                &nbsp;
                                                <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" 
                                                     onclick="window.location.href('auction_frame.jsp')" 
                                                     type="button" name="button" value="  取消  " style="width:70px" />
                                              </div></td>
                                            </tr>
                                          </tbody>
                                      </table></td>
                                    </tr>
                                  </tbody>
                              </table></td>
                      </tr>
                    </tbody>
                  </table></td>
                </tr>
              </tbody>
            </table>
          </div></td>
        </tr>
      </tbody>
    </table>
  </form>
</div>





<!--<jsp:include page="../common/supplierChoose.jsp" flush="true"/>-->
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
<div id="material" style="display:none">
 <jsp:include page="../common/choice_supplies.jsp" flush="true"/>
</div> 

<div id="supplier" style="display:none">
 <jsp:include page="../common/choice_supplier.jsp" flush="true"/>
</div> 