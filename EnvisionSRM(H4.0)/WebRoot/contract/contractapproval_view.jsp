<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>合同管理-采购平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript">
function DispContent( i , count)
{
var test = document.getElementById('test'+i);	
var div = document.getElementById( 'div' + i );
if(i==1){
   var test2 = document.getElementById('test'+count);
   var div2 = document.getElementById( 'div' + count );	
   if( div.style.display == "none" )
    {
	 div2.style.display= "none";
     div.style.display = '';
    }
	if(test.className == "dvtUnSelectedCell")
	{
	  test.className="dvtSelectedCell";
	  test2.className="dvtUnSelectedCell";
	}
}else{
	var test2 = document.getElementById('test'+ 1 );
	var div2 = document.getElementById( 'div' + 1 );	
	if( div.style.display == "none" )
    {
	 div2.style.display= "none";
     div.style.display = '';
    }
	if(test.className == "dvtUnSelectedCell")
	{
	  test.className="dvtSelectedCell";
	  test2.className="dvtUnSelectedCell";
	}
}
}

function supplierChoose(){
   var	sUrl = "suppliers_choose.jsp";
	var sFeatures = "height=500, width=800, top=100, left=100, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=yes";
	var rtnValue = window.open(sUrl,"",sFeatures);
	if (typeof(rtnValue)!="undefined" && rtnValue!="" )
	 { 
	  var str1=rtnValue+"";
	  var str=str1.split("&");
	  var z= str.length;
	  var deviceremark="";
      document.forms[0].productname[i].value = str[0];
      document.forms[0].pic_name[i].value=str[1];
	 }	 
}

function diviationEdit(){
   var	sUrl = "diviation_edit.jsp";
	var sFeatures = "height=500, width=800, top=100, left=100, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=yes";
	var rtnValue = window.open(sUrl,"",sFeatures);
	if (typeof(rtnValue)!="undefined" && rtnValue!="" )
	 { 
	  var str1=rtnValue+"";
	  var str=str1.split("&");
	  var z= str.length;
	  var deviceremark="";
      document.forms[0].productname[i].value = str[0];
      document.forms[0].pic_name[i].value=str[1];
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

<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>

<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>

<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
    <s:if test="#session.loginInfo.role_id == 1">
      <td class="level2UnSelTab" nowrap="nowrap"><a href="yearcontractList.action">年度合同模板</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">合同查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
    </s:if>
    <s:elseif test="#session.loginInfo.role_id == 0">
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_approval.jsp">合同审批</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">合同查询</a></td>
    </s:elseif>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap"> 您现在的位置： 合同管理 &gt; 框架合同 &gt; 合同审批</td>
      <td width="100%" align="center">&nbsp;</td>
      <td align="right" style="padding-right:15px;"><jsp:include page="../common/toolbar.jsp" flush="true"/></td>
    </tr>
  </tbody>
</table>

<!-- 网站中部 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
  <tbody>
    <tr>
      <td width="100%" align="left" valign="top" style="padding-left:10px; padding-top:20px;" ><!-- -->
        
        <div class="small">
        <form name="EditView" method="" action="" onsubmit="">
        <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
          <tbody>
            <tr>
              <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
                  <tbody>
                    <tr>
                      <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
                      <td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>框架合同 信息</b></td>
                      <td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
                    </tr>
                    <tr> </tr>
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
                              <tr>
                                <td style="padding:10px"><!-- General details -->
                                  
                                  <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                    <tbody>
                                      <tr style="height:25px">
                                        <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                            <tbody>
                                              <tr>
                                                <td colspan="4" class="detailedViewHeader"><b>合同基本信息</b></td>
                                              </tr>
                                              <tr style="height:25px">
                                                <td width="19%" class="dvtCellLabel" align="right">合同编号</td>
                                                <td width="32%"  align="left" class="dvtCellInfo">EPACN0012012092710701</td>
                                                <td width="23%" class="dvtCellLabel" align="right">供应商名称</td>
                                                <td width="26%" align="left" class="dvtCellInfo">深圳市达力科技开发有限公司 </td>
                                                <!-- Non Editable field, only configured value will be loaded --> 
                                              </tr>
                                              <tr style="height:25px">
                                                <td width="19%" class="dvtCellLabel" align="right">采购负责人</td>
                                                <td width="32%"  align="left" class="dvtCellInfo">张三</td>
                                                <td width="23%" class="dvtCellLabel" align="right">状态</td>
                                                <td width="26%" align="left" class="dvtCellInfo">待审批</td>
                                                <!-- Non Editable field, only configured value will be loaded --> 
                                              </tr>
                                              <tr>
                                                <td colspan="4" class="detailedViewHeader"><b>主合同条款</b></td>
                                              </tr>
                                              <tr style="height:25px">
                                                <td width="19%" class="dvtCellLabel" align="right"><font color="red"></font>年度合同类型</td>
                                                <td colspan="" align="left" class="dvtCellInfo">生产性物料年度合同模板</td>
                                                <td colspan="" align="right" class="dvtCellLabel">当前年度合同</td>
                                                <td colspan="" align="left" class="dvtCellInfo"><a href="#">12年度合同</a></td>
                                              </tr>
                                              <tr>
                                                <td colspan="4" class="detailedViewHeader"><b>合同附件信息</b></td>
                                              </tr>
                                            <td width="19%" height="31" align="right" class="dvtCellLabel"><font color="red"></font></td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><b>附件信息</b></td>
                                              <td width="26%" align="left" class="dvtCellInfo"><b>备注说明</b></td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="19%" class="dvtCellLabel" align="right"><font color="red"></font>*偏差</td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><a href="#">合同偏差V01.pdf</a></td>
                                              <td width="26%" align="left" class="dvtCellInfo">无
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="19%" class="dvtCellLabel" align="right"><font color="red"></font>*保密协议</td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><a href="#">保密协议.pdf</a></td>
                                              <td width="26%" align="left" class="dvtCellInfo">无 </td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="19%" class="dvtCellLabel" align="right"><font color="red"></font>*价格协议</td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><a href="#">价格协议.xls</a></td>
                                              <td width="26%" align="left" class="dvtCellInfo">无 </td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="19%" height="21" align="right" class="dvtCellLabel"><font color="red"></font>质量协议</td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><a href="#">质量协议.pdf</a></td>
                                              <td width="26%" align="left" class="dvtCellInfo">无 </td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="19%" class="dvtCellLabel" align="right"><font color="red"></font>采购说明书</td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><a href="#">采购说明书1.pdf</a> ; <a href="#">采购说明书2.pdf</a></td>
                                              <td width="26%" align="left" class="dvtCellInfo">无 </td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="19%" class="dvtCellLabel" align="right"><font color="red"></font>技术协议</td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><a href="#">技术协议1.pdf</a> ; <a href="#">技术协议2.pdf</a></td>
                                              <td width="26%" align="left" class="dvtCellInfo">无 </td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="19%" class="dvtCellLabel" align="right"><font color="red"></font>监造协议</td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><a href="#">监造协议1.pdf</a> ; <a href="#">监造协议2.pdf</a></td>
                                              <td width="26%" align="left" class="dvtCellInfo">无 </td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="19%" height="25" align="right" class="dvtCellLabel"><font color="red"></font>物流协议</td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><a href="#">物流协议1.pdf</a> ; <a href="#">物流协议2.pdf</a></td>
                                              <td width="26%" align="left" class="dvtCellInfo">无 </td>
                                            </tr>
                                            <tr style="height:25px">
                                              <td width="19%" class="dvtCellLabel" align="right"><font color="red"></font>EHS协议</td>
                                              <td colspan="2" align="left" class="dvtCellInfo"><a href="#">EHS协议.pdf</a></td>
                                              <td width="26%" align="left" class="dvtCellInfo">无 </td>
                                            <tr>
                                              <td colspan="4" style="padding:5px" height="40"><div align="center">
                                                  <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  返回  " style="width:70px" />
                                                </div></td>
                                            </tr>
                                          </table>
                                          <span id="assign_user" style="display:block"></span></td>
                                      </tr>
                                  </table></td>
                              </tr>
                          </table></td>
                      </tr>
                  </table>
                </div>
                
                <!-- Basic Information Tab Closed -->
  </td></tr>
  </tbody></table>
</form>
</div>

</td></tr></tbody></table>

<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>