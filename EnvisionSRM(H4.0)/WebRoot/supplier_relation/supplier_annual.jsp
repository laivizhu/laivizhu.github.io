<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>供应商年度评价</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript">
function DispContent( i , count)
{
var m=i;
var test = document.getElementById('test'+i);	
var div = document.getElementById( 'div' + i );

for(var n=1;n<7;n++){
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_importance.jsp">物料重要性分析</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_attraction.jsp">相对吸引力分析</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_subdivide.jsp">供应商关系细分分析</a> </td>
      <td class="level2SelTab" nowrap="nowrap"><a href="supplier_annual.jsp">供应商年度评价</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_distinguish.jsp">供应商区分及策略</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_information.jsp">供应商信息维护</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置：供应商关系管理 &gt; 供应商年度评价</td>
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
        <div class="contentViewDiv">
          <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
              <tr>
                <td><table class="small" border="0" cellpadding="3" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test1" class="dvtSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(1,6);">选择物料小组</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test2" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(2,6);">供应商SE结果</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test3" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(3,6);">远景-供应商RA分析</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test4" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(4,6);">远景-供应商SRS</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test5" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(5,6);">供应商战略划分SD</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test6" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(6,6);">供应商区分化管理策略</td>
                        <td class="dvtTabCache" style="width: 100%;">&nbsp;</td>
                      </tr>
                    </tbody>
                </table></td>
              </tr>
              <tr>
                <td align="left" valign="top"><table class="dvtContentSpace" border="0" cellpadding="3" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td align="left">
                          <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tbody>
                              <tr>
                                <td style="padding: 10px;">
                                  <jsp:include page="supplier_out_1.jsp" flush="true"/>
                                  <jsp:include page="supplier_out_2.jsp" flush="true"/>
                                  <jsp:include page="supplier_out_3.jsp" flush="true"/>
                                  <jsp:include page="supplier_out_4.jsp" flush="true"/>
                                  <jsp:include page="supplier_out_5.jsp" flush="true"/>
                                  <jsp:include page="supplier_out_6.jsp" flush="true"/>
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
