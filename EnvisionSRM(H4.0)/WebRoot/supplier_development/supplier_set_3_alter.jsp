<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>供应商基本信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.0.custom.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript" type="text/javascript" src="../js/calc.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
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
   var	sUrl = "../common/choice_supplier.jsp";
	var sFeatures = "height=500, width=800, top=100, left=250, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=yes;scroll=yes";
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
	var sFeatures = "height=500, width=800, top=100, left=250, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=yes;scroll=yes";
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

var i = 1;
function addFile(dvID, inputNamePrefix)
{
var dv = document.getElementById(dvID);

var file = document.createElement("input");
file.type = "file";
file.id = file.name = inputNamePrefix + i;

dv.appendChild(file);

var btn = document.createElement("input");
btn.type = "button";
btn.id = btn.name = "btn" + i;
btn.value = "删除" ;

btn.onclick = function() {
var b = document.getElementById(btn.id);
dv.removeChild(b.nextSibling); //remove <BR>
dv.removeChild(b.previousSibling); //file
dv.removeChild(b); //btn
}

dv.appendChild(btn);

dv.appendChild(document.createElement("BR"));

i++;
}
</script>
<style type="text/css">
<!--
.STYLE1 {
	color: red;
	font-size: 12;
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
      <td class="level2SelTab" nowrap="nowrap"><a href="supplier_set.jsp">供应商注册管理</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_sourceProject.jsp">供应商寻源项目管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_develop.jsp">寻源进度报告</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_securit.jsp">供应商保密协议管理</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap"> 您现在的位置：供应商日常管理 &gt; 供应商基本信息管理 &gt; 供应商信息修改</td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>


<!-- 网站中部 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top" style="padding-left:10px; padding-top:20px;" ><!-- -->
    <div class="small">
    <form method="post" action="" >
    <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
      <tbody>
        <tr>
          <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
              <tbody>
                <tr>
                  <td class="dvtTabCache" style="width:10px" >&nbsp;</td>
                  <td style="width:15%" align="center" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')">供应商信息修改</td>
                  <td class="dvtTabCache" style="width:85%">&nbsp;</td>
                </tr>
                <tr> </tr>
              </tbody>
            </table></td>
        </tr>
        <tr>
          <td valign="top" align="left"><div id="basicTab" style="display: block; ">
              <table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
                <tbody><tr><td align="left">
            <table border="0" cellspacing="0" cellpadding="0" width="100%">
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
                        <td colspan="6" class="detailedViewHeader"><b>供应商信息</b></td>
                      </tr>
                      <tr style="height:25px">
                        <td width="151" class="dvtCellLabel" align="right"> 供应商名称</td>
                        <td width="214" align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="aaa" /></td>
                        <td width="149" align="right" class="dvtCellLabel">负责人</td>
                        <td width="237" align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="张伟达" /></td>
                        <td width="148" class="dvtCellLabel" align="right">申请时间</td>
                        <td width="282" align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="2012-10-11" /></td>
                      </tr>
                      <tr style="height:25px">
                        <td class="dvtCellLabel" align="right">是否生产性物料</td>
                        <td width="214" align="left" class="dvtCellInfo"><input type="radio" value="1" name="supplierBasic.isProductivityMaterial">是 <input type="radio" value="0" name="supplierBasic.isProductivityMaterial">否</td>
                        <td width="149" align="right" class="dvtCellLabel">负责人Email</td>
                        <td width="237" align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="测试1" /></td>
                        <td width="148" class="dvtCellLabel" align="right">负责人手机号</td>
                        <td width="282" align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="子类测试" /></td>
                      </tr>
                      <tr style="height:25px">
                        <td width="151" class="dvtCellLabel" align="right">负责人姓名</td>
                        <td width="214" align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="类别1" /></td>
                        <td width="149" align="right" class="dvtCellLabel">类别团队</td>
                        <td width="237" align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="张伟达" /></td>
                        <td width="148" class="dvtCellLabel" align="right">机型平台</td>
                        <td width="282" align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="测试" /></td>
                      </tr>
                      <tr style="height:25px">
                        <td class="dvtCellLabel" align="right">供应商名称</td>
                        <td align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="测试" /></td>
                        <td class="dvtCellLabel" align="right">生产性物料</td>
                        <td align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="测试" /></td>
                        <td align="right" class="dvtCellLabel">供应商确认时间</td>
                        <td align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="2012-10-11" /></td>
                      </tr>
                      <tr style="height:25px">
                        <td align="right" class="dvtCellLabel">供应商联系方式</td>
                        <td align="left" class="dvtCellInfo"><input type="text" class="detailedViewTextBox" style="width:60%;" value="1234567" /></td>
                        <td class="dvtCellLabel" align="right">&nbsp;</td>
                        <td align="left" class="dvtCellInfo">&nbsp;</td>
                        <td width="148" class="dvtCellLabel" align="right">&nbsp;</td>
                        <td width="282" align="left" class="dvtCellInfo">&nbsp;</td>
                      </tr>
                      <tr>
                        <td colspan="6" class="detailedViewHeader"><b>供应商信息调查表</b></td>
                      </tr>
                      <tr style="height:25px">
                        <td class="dvtCellLabel" align="right"><font color="red"></font>供应商信息调查表</td>
                        <td colspan="6" align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                      </tr>
                      <tr>
                        <td colspan="10" class="detailedViewHeader"><b>合同附件信息 </b>(注：*号表示必须填写项)</td>
                      </tr>
                      <tr style="height:25px">
                        <td width="151" height="25" align="right" class="dvtCellLabel"></td>
                        <td colspan="2" align="left" class="dvtCellInfo"><b>附件文件</b></td>
                        <td width="237" height="25" align="right" class="dvtCellInfo"></td>
                        <td align="left" class="dvtCellInfo" colspan="3"><b>附件文件</b></td>
                      </tr>
                      <tr style="height:25px">
                        <td class="dvtCellLabel" align="right">*企业法人营业执照</td>
                        <td colspan="2"  align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                        <td class="dvtCellLabel" align="right">*法人代表及经办人身份证明</td>
                        <td colspan="2"  align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                      </tr>
                      <tr style="height:25px">
                        <td class="dvtCellLabel" align="right">*组织机构代码证</td>
                        <td colspan="2" align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                        <td class="dvtCellLabel" align="right">*国税地税登记证、一般纳税人资格证</td>
                        <td colspan="2"  align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                      </tr>
                      <tr style="height:25px">
                        <td class="dvtCellLabel" align="right"><font color="red"></font>银行帐号信息</td>
                        <td colspan="2" align="left" valign="top" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                        <td class="dvtCellLabel" align="right">生产许可证</td>
                        <td colspan="2"  align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                      </tr>
                      <tr style="height:25px">
                        <td class="dvtCellLabel" align="right"><font color="red"></font>环境管理认证证书</td>
                        <td colspan="2" align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                        <td class="dvtCellLabel" align="right">专利证明材料</td>
                        <td colspan="2"  align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                      </tr>
                      <tr style="height:25px">
                        <td class="dvtCellLabel" align="right"><font color="red"></font>质量管理认证证书</td>
                        <td colspan="2" align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                        <td class="dvtCellLabel" align="right">供应商介绍</td>
                        <td colspan="2"  align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                      </tr>
                      <tr style="height:25px">
                        <td height="25" align="right" class="dvtCellLabel"><font color="red"></font>企业资信等级证书</td>
                        <td colspan="2" align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                        <td class="dvtCellLabel" align="right">其他补充材料</td>
                        <td colspan="2"  align="left" class="dvtCellInfo"><a href="#">测试.doc</a></td>
                      </tr>
                                      <tr>
                                        <td height="40px;" colspan="6" style="padding:5px"><div align="center">
                                            <input title="通过 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="" type="submit" name="button" value="  修改  " style="width:70px" />
                                            <input title="不通过 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  不修改  " style="width:70px" />
                                          </div></td>
                                      </tr>
                                    </tbody>
                                  </table>
                                  <span id="assign_user" style="display:block"></span></td>
                              </tr>
                            </tbody>
                          </table></td>
                      </tr>
                    </tbody>
                  </table>
                </td></tr></tbody>
              </table>
            </div>
            <!-- Basic Information Tab Closed -->
          </td>
        </tr>
      </tbody>
    </table>
</table>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
