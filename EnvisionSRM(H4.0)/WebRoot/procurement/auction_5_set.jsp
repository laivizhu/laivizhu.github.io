<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>电子竞标</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script language="javascript" type="text/javascript"
	src="../js/general.js"></script>
<script language="javascript">
	function DispContent(i, count) {
		var test = document.getElementById('test' + i);
		var div = document.getElementById('div' + i);
		if (i == 1) {
			var test2 = document.getElementById('test' + count);
			var div2 = document.getElementById('div' + count);
			if (div.style.display == "none") {
				div2.style.display = "none";
				div.style.display = '';
			}
			if (test.className == "dvtUnSelectedCell") {
				test.className = "dvtSelectedCell";
				test2.className = "dvtUnSelectedCell";
			}
		} else {
			var test2 = document.getElementById('test' + 1);
			var div2 = document.getElementById('div' + 1);
			if (div.style.display == "none") {
				div2.style.display = "none";
				div.style.display = '';
			}
			if (test.className == "dvtUnSelectedCell") {
				test.className = "dvtSelectedCell";
				test2.className = "dvtUnSelectedCell";
			}
		}
	}

	function supplierChoose() {
		var sUrl = "suppliers_choose.jsp";
		var sFeatures = "height=500, width=800, top=100, left=100, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=yes";
		var rtnValue = window.open(sUrl, "", sFeatures);
		if (typeof (rtnValue) != "undefined" && rtnValue != "") {
			var str1 = rtnValue + "";
			var str = str1.split("&");
			var z = str.length;
			var deviceremark = "";
			document.forms[0].productname[i].value = str[0];
			document.forms[0].pic_name[i].value = str[1];
		}
	}

	function diviationEdit() {
		var sUrl = "diviation_edit.jsp";
		var sFeatures = "height=500, width=800, top=100, left=100, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=yes;scroll=yes";
		var rtnValue = window.open(sUrl, "", sFeatures);
		if (typeof (rtnValue) != "undefined" && rtnValue != "") {
			var str1 = rtnValue + "";
			var str = str1.split("&");
			var z = str.length;
			var deviceremark = "";
			document.forms[0].productname[i].value = str[0];
			document.forms[0].pic_name[i].value = str[1];
		}
	}
</script>
<script type="text/javascript">
	function show2() {
		if (confirm("是否保存新建项目?")) {
			alert("保存成功");
		} else {
			alert("保存取消");
		}
	}
</script>
<style type="text/css">
<!--
input[type="file"] {
	-webkit-box-align: baseline;
	color: inherit;
	text-align: start;
}
-->
</style>
</head>
<body class="small" leftmargin="0" topmargin="0" marginheight="0"
	marginwidth="0" rightmargin="0" bottommargin="0">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true" />
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true" />
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
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 采购项目管理管理 &gt; 电子竞标 </td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>
<!-- 网站中部 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0"
		border="0" align="center">
  <tbody>
    <tr>
      <td width="100%" align="left" valign="top"
					style="padding-left:10px; padding-top:20px;"><!-- -->
        <div class="contentViewDiv">
          <form name="EditView" method="" action="" onsubmit="">
            <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
              <tbody>
                <tr>
                  <td><table border="0" cellspacing="0" cellpadding="3"
												width="100%" class="small">
                      <tbody>
                        <tr>
                          <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
                          <td style="width:15%" align="center" nowrap=""
															class="dvtSelectedCell" id="bi"
															onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')">确认竞标项目</td>
                          <td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
                        </tr>
                        <tr> </tr>
                      </tbody>
                    </table></td>
                </tr>
                <tr>
                  <td valign="top" align="left"><div id="basicTab" style="display: block; ">
                      <table border="0" cellspacing="0" cellpadding="3"
													width="100%" class="dvtContentSpace">
                        <tbody>
                          <tr>
                            <td align="left"><table border="0" cellspacing="0" cellpadding="0"
																	width="100%">
                                <tbody>
                                  <tr>
                                    <td id="autocom"></td>
                                  </tr>
                                  <tr>
                                    <td style="padding:10px"><!-- General details -->
                                      <table border="0" cellspacing="0" cellpadding="0"
																					width="100%" class="small">
                                        <tbody>
                                          <tr style="height:25px">
                                            <td width="30%" align="left" class="dvtCellInfo"><table
																									border="0" cellspacing="0" cellpadding="0"
																									width="100%" class="small">
                                                <tbody>
                                                  <tr>
                                                    <td colspan="4" class="detailedViewHeader"><strong>最低价格设置</strong></td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td width="39%" class="dvtCellLabel" align="right">起始价格</td>
                                                    <td width="61%" colspan="3" align="left"
																												class="dvtCellInfo"><input type="text"
																												name="lastname2" tabindex=""
																												class="detailedViewTextBox"
																												onfocus="this.className='detailedViewTextBoxOn'"
																												onblur="this.className='detailedViewTextBox'"
																												style="width:30%;" value="" /></td>
                                                    <!-- Non Editable field, only configured value will be loaded -->
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td width="39%" class="dvtCellLabel"
																												align="right">价格步进</td>
                                                    <td width="61%" colspan="3" align="left"
																												class="dvtCellInfo"><input type="text"
																												name="lastname2" tabindex=""
																												class="detailedViewTextBox"
																												onfocus="this.className='detailedViewTextBoxOn'"
																												onblur="this.className='detailedViewTextBox'"
																												style="width:30%;" value="" /></td>
                                                    <!-- Non Editable field, only configured value will be loaded -->
                                                  </tr>
                                                  <tr style="height:25px"> </tr>
                                                  <tr>
                                                    <td colspan="4" class="detailedViewHeader"><strong>竞标方式</strong></td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td class="dvtCellLabel" align="right"><font color="red"></font>竞标方式</td>
                                                    <td colspan="3" align="left" class="dvtCellInfo"><select style="width:30%" onchange="c(this.value,this.parentNode)">
                                                        <option/>
                                                        <option value="t1">只看到价格</option>
                                                        <option value="t2">只看到排名</option>
                                                        <option value="t3">价格和排名都可看到</option>
                                                        <!--                                                    <input id="t1" name="t1" value="提示：参与竞标的供应商，可看到当前的价格情况。"  disabled="disabled" style="display:none" style="width:320px">
                                                    <input id="t1" name="t2" value="提示：参与竞标的供应商，可看到当前供应商的排名情况。" disabled="disabled" style="display:none" style="width:330px">
                                                    <input id="t1" name="t3" value="提示：参与竞标的供应商，可同时看到价格和排名。" disabled="disabled" style="display:none" style="width:320px">
                                                    <input id="t1" name="t4" value="提示：只有价格最低的供应商才会被告知,其他供应商都不会接到通知，除非他变成价格最低者。" disabled="disabled" style="display:none" style="width:600px">
                                                    <input id="t1" name="t5" value="提示：当前最低的价格会通知所有的竞标者。" disabled="disabled" style="display:none" style="width:300px">-->
                                                      </select>
                                                    </td>
                                                  </tr>
                                                  <tr style="height:25px"> </tr>
                                                  <tr>
                                                    <td colspan="4" class="detailedViewHeader"><strong>时间限定</strong> </td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td width="39%" class="dvtCellLabel"
																												align="right"><font color="red"></font>竞标开始时间</td>
                                                    <td colspan="3" width="61%" align="left"
																												class="dvtCellInfo"><input type="text"
																												name="lastname4" tabindex=""
																												class="detailedViewTextBox"
																												onfocus="this.className='detailedViewTextBoxOn'"
																												onblur="this.className='detailedViewTextBox'"
																												style="width:20%;" value="" />
                                                      <span class="style1">(YYYY-MM-DD hh:mm:ss)</span></td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td width="39%" height="25" align="right"
																												class="dvtCellLabel">竞标结束时间</td>
                                                    <td colspan="3" width="61%" align="left"
																												class="dvtCellInfo"><input type="text"
																												name="lastname5" tabindex=""
																												class="detailedViewTextBox"
																												onfocus="this.className='detailedViewTextBoxOn'"
																												onblur="this.className='detailedViewTextBox'"
																												style="width:20%;" value="" />
                                                      <span class="style1">(YYYY-MM-DD hh:mm:ss)</span></td>
                                                  </tr>
                                                  <tr>
                                                    <td height="40" colspan="4" style="padding:5px"><div align="center">
                                                        <input title="保存 [Alt+S]" accesskey="S"
																														class="crmbutton small save"
																														onclick="show2();"
																														type="submit" name="button" value="  保存  "
																														style="width:70px" />
                                                        &nbsp;
                                                        <input
																														title="取消 [Alt+X]" accesskey="X"
																														class="crmbutton small cancel"
																												onclick="window.location.href('auction_frame.jsp')"
																														type="button" name="button" value="  取消  "
																														style="width:70px" />
                                                      </div></td>
                                                  </tr>
                                                </tbody>
                                              </table>
                                              <span id="assign_user" style="display:block"></span> </td>
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
                    <!-- Basic Information Tab Closed -->
                  </td>
                </tr>
              </tbody>
            </table>
          </form>
        </div></td>
    </tr>
  </tbody>
</table>
<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true" />
</body>
</html>
