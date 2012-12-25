<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>供应商改善对策报告</title>
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_performance.jsp">供应商日常绩效管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_monthManage.jsp">供应商月度绩效评价</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="complaint_list.jsp">供应商投诉</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="advice_list.jsp">供应商合理化建议</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="supplier_report.jsp">供应商改善对策报告</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_terrace.jsp">供应商质量管理平台</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_document.jsp">供应商质量文档中心</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap">您现在的位置：供应商日常管理 &gt; 供应商改善对策报告 </td>
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
      <td width="100%" align="left" valign="top" style="padding-left:10px; padding-top:20px;" ><!-- -->
        <div class="contentViewDiv">
        <form method="post" action="" >
        <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
          <tbody>
            <tr>
              <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
                  <tbody>
                    <tr>
                      <td class="dvtTabCache" style="width:10px" >&nbsp;</td>
                      <td style="width:15%" align="center" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><strong>终审改善对策报告书</strong></td>
                      <td class="dvtTabCache" style="width:85%">&nbsp;</td>
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
                                                   <td colspan="4" class="detailedViewHeader"><strong>终审改善对策报告书</strong></td>
                                              </tr>
                                                
                                                <tr style="height:25px">
                                                  <td width="20%" align="right" class="dvtCellLabel">供应商名称</td>
                                                  <td width="30%" align="left" class="dvtCellInfo">
                                                  供应商1</td>
                                                  <td align="right" class="dvtCellLabel">远景内部负责部门</td>
                                                  <td align="left" class="dvtCellInfo"><input name="" type="radio" value="" />
                                                    采购部 &nbsp;
                                                    <input name="" type="radio" value="" />
                                                  质量工程部 </td>
                                                </tr>
                                        
                                                <tr style="height:25px">
                                                  <td align="right" class="dvtCellLabel">零部件名称</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                  <td align="right" class="dvtCellLabel">图纸编号</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                </tr>
                                                
                                                <tr style="height:25px">
                                                  <td align="right" class="dvtCellLabel">部件序列号</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                  <td align="right" class="dvtCellLabel">缺陷等级</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                </tr>
                                                
                                                <tr style="height:25px">
                                                  <td align="right" class="dvtCellLabel">图纸版本号</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                  <td align="right" class="dvtCellLabel">发现地点</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                </tr>
                                                
                                                <tr style="height:25px">
                                                  <td align="right" class="dvtCellLabel">发现人员</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                  <td align="right" class="dvtCellLabel">发生时间</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                </tr>
                                                
                                                <tr style="height:25px">
                                                  <td class="dvtCellLabel" align="right">上传改善对策报告书</td>
                                                  <td align="left" class="dvtCellInfo">1</td>
                                                  <td class="dvtCellLabel" align="right">附件(图片、视频、相关文件等)</td>
                                                  <td align="left" class="dvtCellInfo">1</td>
                                                </tr>
                                                
                                                <tr style="height:25px">
                                                  <td align="right" class="dvtCellLabel">潜在影响范围</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                  <td class="dvtCellLabel" align="right">问题描述</td>
                                                  <td align="left" class="dvtCellInfo">测试</td>
                                                </tr>
                                            </tbody></table>
                                            <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                         <tbody>
                                                         <tr>
                                                           <td colspan="10" class="detailedViewHeader"><strong>供应商改善对策报告书</strong></td>
                                                        </tr>
                                                
                                                         <tr>
                                                            <td width="20%" class="dvtCellLabel">临时措施</td>
                                                            <td width="15%" class="dvtCellLabel">验证结果</td>
                                                            <td width="15%" class="dvtCellLabel">负责人</td>
                                                           <td width="10%" class="dvtCellLabel">完成时间</td>
                                                            <td width="10%" class="dvtCellLabel">状态</td>
                                                            <td width="20%" class="dvtCellLabel">附件</td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td class="dvtCellInfo">测试数据A</td>
                                                            <td class="dvtCellInfo">测试2</td>
                                                            <td class="dvtCellInfo">2012-10-12</td>
                                                            <td class="dvtCellInfo">weiweili@test.com</td>
                                                            <td class="dvtCellInfo">2012-10-12</td>
                                                            <td class="dvtCellInfo">weiweili@test.com</td>
                                                          </tr> 
                                                          
                                                          <tr>
                                                            <td width="20%" class="dvtCellLabel">根本原因分析</td>
                                                            <td width="15%" class="dvtCellLabel">验证结果</td>
                                                            <td width="15%" class="dvtCellLabel">负责人</td>
                                                            <td width="10%" class="dvtCellLabel">完成时间</td>
                                                            <td width="10%" class="dvtCellLabel">状态</td>
                                                            <td width="20%" class="dvtCellLabel">附件</td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td class="dvtCellInfo">测试数据A</td>
                                                            <td class="dvtCellInfo">测试2</td>
                                                            <td class="dvtCellInfo">2012-10-12</td>
                                                            <td class="dvtCellInfo">weiweili@test.com</td>
                                                            <td class="dvtCellInfo">2012-10-12</td>
                                                            <td class="dvtCellInfo">weiweili@test.com</td>
                                                          </tr> 
                                                          
                                                          <tr>
                                                            <td width="20%" class="dvtCellLabel">永久性纠正措施</td>
                                                            <td width="15%" class="dvtCellLabel">验证结果</td>
                                                            <td width="15%" class="dvtCellLabel">负责人</td>
                                                            <td width="10%" class="dvtCellLabel">完成时间</td>
                                                            <td width="10%" class="dvtCellLabel">状态</td>
                                                            <td width="20%" class="dvtCellLabel">附件</td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td class="dvtCellInfo">测试数据A</td>
                                                            <td class="dvtCellInfo">测试2</td>
                                                            <td class="dvtCellInfo">2012-10-12</td>
                                                            <td class="dvtCellInfo">weiweili@test.com</td>
                                                            <td class="dvtCellInfo">2012-10-12</td>
                                                            <td class="dvtCellInfo">weiweili@test.com</td>
                                                          </tr> 
                                                          
                                                                                                                    <tr>
                                                            <td colspan="2" width="20%" class="dvtCellLabel">防止再发生（图纸，规范，操作标准等变更）</td>
                                                            <td width="20%" class="dvtCellLabel">负责人</td>
                                                            <td width="20%" class="dvtCellLabel">完成时间</td>
                                                            <td width="20%" class="dvtCellLabel">状态</td>
                                                            <td width="20%" class="dvtCellLabel">附件</td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td colspan="2" class="dvtCellInfo">测试数据A</td>
                                                            <td class="dvtCellInfo">2012-10-12</td>
                                                            <td class="dvtCellInfo">weiweili@test.com</td>
                                                            <td class="dvtCellInfo">2012-10-12</td>
                                                            <td class="dvtCellInfo">weiweili@test.com</td>
                                                          </tr> 
                                                         </tbody>
                                                     </table>   
                                            <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                         <tbody>
                                                         <tr>
                                                           <td colspan="4" class="detailedViewHeader"><strong>供应商改善对策报告书</strong></td>
                                                        </tr>
                                                         <tr style="height:25px">
                                                          <td width="30%" class="dvtCellLabel" align="right">责任SQE结案审查意见</td>
                                                          <td width="70%" align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
                                                        </tr>
                                                     <tr style="height:25px">
                                                          <td width="30%" class="dvtCellLabel" align="right">附件相关文件等</td>
                                                       <td align="left" class="dvtCellInfo"><input type="file" style="width:82%;"/></td>
                                                     </tr>

                                                         </tbody>
                                                     </table>              
                                                  <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                     <tbody>
                                                    <tr>
                                                      <td colspan="10" height="40px;" style="padding:5px"><div align="center">
                                                        <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save"  onclick="show2();" type="submit" name="button2" value="确定" style="width:70px" />&nbsp;
                                                          <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('supplier_report.jsp')"  type="button" name="button" value="  取消  " style="width:70px" />
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
</table>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
