<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>电子竞标</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript">
function DispContent( i , count)
{
var m=i;
var test = document.getElementById('test'+i);	
var div = document.getElementById( 'div' + i );

for(var n=1;n<8;n++){
   if(m==n){
     if( div.style.display == "none" )
    {
     div.style.display = '';
    }
	if(test.className == "dvtUnSelectedCell")
	{
	  test.className="dvtSelectedCell";
	}
   }else{
     var test_1= document.getElementById('test'+n);
     var div_1 = document.getElementById( 'div' + n );
     if( div_1.style.display == "none" ){div_1.style.display ="none";}
     else div_1.style.display ="none";
     if(test_1.className == "dvtUnSelectedCell"){test_1.className = "dvtUnSelectedCell";}
     else test_1.className = "dvtUnSelectedCell";
   }
}
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
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 采购项目管理管理 &gt; 电子竞标 </td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>
<!-- 工作台 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
  <tbody>
    <tr>
      <td align="left" valign="top" width="100%">
        <div class="contentListDiv">
          <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
              <tr>
                <td><table class="small" border="0" cellpadding="3" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test1" class="dvtSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(1,7);">准备竞标项目</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test2" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(2,7);">确认竞标协议</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test3" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(3,7);">发送询价单</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test4" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(4,7);">启动竞标--确认供应商</td>
                        <td class="dvtTabCache" style="width: 10px;">&nbsp;</td>
                        <td id="test5" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(5,7);">启动竞标--竞标设置</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test6" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(6,7);">查询竞标状态</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test7" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(7,7);">竞标评估</td>
                        <td class="dvtTabCache" style="width: 100%;">&nbsp;</td>
                      </tr>
                    </tbody>
                </table></td>
              </tr>
              <tr>
                <td align="left" valign="top"><table class="dvtContentSpace" border="0" cellpadding="3" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td align="left"><!-- content cache -->
                          <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tbody>
                              <tr>
                                <td style="padding: 10px;"><!-- PUBLIC CONTENTS STARTS-->
                                  <jsp:include page="auction_1.jsp" flush="true"/>
                                  <jsp:include page="auction_2.jsp" flush="true"/>
                                  <jsp:include page="auction_3.jsp" flush="true"/>
                                  <jsp:include page="auction_4.jsp" flush="true"/>
                                  <jsp:include page="auction_5.jsp" flush="true"/>
                                  <jsp:include page="auction_6.jsp" flush="true"/>
                                  <jsp:include page="auction_7.jsp" flush="true"/>
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
      </td>
    </tr>
  </tbody>
</table>



<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
