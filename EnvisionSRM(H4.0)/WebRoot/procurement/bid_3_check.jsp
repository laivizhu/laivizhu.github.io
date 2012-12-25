<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>年度招标</title>
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
<body class="small" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0"  rightmargin="0" bottommargin="0">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2SelTab" nowrap="nowrap"><a href="bid_frame.jsp">年度招标</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="auction_frame.jsp">电子竞标</a></td>
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
      <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 采购项目管理 &gt; 年度招标 &gt; 供应商投标确认 </td>
      <td width="100%" align="center" valign="middle"></td>
      <td align="right" style="padding-right:15px;"><jsp:include page="../common/toolbar.jsp" flush="true"/>
      </td>
    </tr>
  </tbody>
</table>
<!-- 网站中部 -->
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
  <tbody>
    <tr>
      <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
          <tbody>
            <tr>
              <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
              <td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')">供应商投标确认详情</td>
              <td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
            </tr>
            <tr> </tr>
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
                                        <td colspan="10" class="detailedViewHeader"><strong>供应商确认详情</strong></td>
                                      </tr>
                                      <tr style="height:25px">
                                        <td align="right" class="dvtCellLabel" colspan="2">竞标编号</td>
                                        <td  align="left" class="dvtCellInfo" colspan="8">201210201</td>
                                      </tr>
                                      <tr style="height:25px">
                                        <td class="dvtCellLabel" align="right" colspan="2">发起人</td>
                                        <td  align="left" class="dvtCellInfo" colspan="8">采购员A</td>
                                      </tr>
                                      <tr style="height:25px">
                                        <td class="dvtCellLabel" align="right" colspan="2">项目名称</td>
                                        <td  align="left" class="dvtCellInfo" colspan="8"><p>2012下半年电子产品采购</p></td>
                                      </tr>
                                      <tr style="height:25px">
                                        <td class="dvtCellLabel" align="right" colspan="2">邀请招标供应商清单</td>
                                        <td  align="left" class="dvtCellInfo" colspan="8"><p>上海信得股份有限公司，山东莱海有限公司，黑龙江成铁有限公司，大同铸造有限公司，青岛碣石有限公司</p></td>
                                      </tr>
                                      <tr style="height:25px">
                                        <td class="dvtCellLabel" align="right" colspan="2">已回应的供应商</td>
                                        <td  align="left" class="dvtCellInfo" colspan="8">黑龙江成铁有限公司，大同铸造有限公司，青岛碣石有限公司</td>
                                      </tr>
                                      <tr>
                                        <td class="dvtCellLabel" align="right" colspan="2">时间周期</td>
                                        <td  align="left" class="dvtCellInfo" colspan="8">30天</td>
                                      </tr>
                                      <tr style="height:25px">
                                        <td class="dvtCellLabel" align="right" colspan="2">物料信息</td>
                                        <td  align="left" class="dvtCellInfo" colspan="8">风机叶</td>
                                      </tr>
                                      <tr style="height:25px">
                                        <td class="dvtCellLabel" align="right" colspan="2">已确认投标供应商比例</td>
                                        <td  align="left" class="dvtCellInfo" colspan="8">3/5</td>
                                      </tr>
                                      <tr>
                                        <td class="dvtCellLabel" align="right" colspan="2">附件</td>
                                        <td  align="left" class="dvtCellInfo" colspan="8"><a href="#">201210201风机叶采购招标</a></td>
                                      </tr>
                                    </tbody>
                                  </table></td>
                              </tr>
                              <tr style="height:25px">
                                <td width="30%" align="left" class="dvtCellInfo">
                                  <div class="calDIV" style="overflow:auto;">
                                    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                    <tbody>
                                      <tr>
                                        <td colspan="15" class="detailedViewHeader"><strong>供应商详细情况</strong></td>
                                      </tr>
                                      <tr>
                                        <td rowspan="2" width="10%" class="lvtCol">供应商编号</td>
                                        <td rowspan="2" width="14%" class="lvtCol">供应商名称</td>
                                        <td rowspan="2" width="7%" class="lvtCol">投标状态</td>
                                        <td rowspan="2" width="9%" class="lvtCol">押金确认</td>
                                        <td width="30%" colspan="4" class="lvtCol"><div align="center">竞标文件</div></td>
                                        <td width="30%" colspan="4" class="lvtCol"><div align="center">竞标协议</div></td>
                                      </tr> 
                                      <tr bgcolor="white" style="height:25px">
                                        <td class="lvtCol">内容确认</td>
                                        <td class="lvtCol">正本文件确认</td>
                                        <td class="lvtCol">邮寄单号</td>
                                        <td class="lvtCol">附件</td>
                                        
                                        <td class="lvtCol">内容确认</td>
                                        <td class="lvtCol">正本文件确认</td>
                                        <td class="lvtCol">邮寄单号</td>
                                        <td class="lvtCol">附件</td>
                                      </tr>
                                      <tr bgcolor="white" style="height:25px">
                                        <td class="dvtCellInfo">20112311</td>
                                        <td class="dvtCellInfo">厚谦咨询</td>
                                        <td class="dvtCellInfo">测试</td>
                                        <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">测试数据</td>
                                        <td class="dvtCellInfo"><a href="check_history.jsp">测试数据1.pdf</a></td>
                                        
                                           <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">测试数据</td>
                                        <td class="dvtCellInfo"><a href="check_history.jsp">测试数据1.pdf</a></td>
                                      </tr>

                                      <tr>
                                        <td height="40" colspan="15" style="padding:5px"><div align="center">
                                            <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('bid_frame.jsp')" type="button" name="button" value="  返回  " style="width:70px" />
                                          </div></td>
                                      </tr>
                                    </tbody>
                                  </table>
                                </div>  
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
<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>