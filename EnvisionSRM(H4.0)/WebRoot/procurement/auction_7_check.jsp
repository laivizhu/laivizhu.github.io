<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>电子竞标</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '竞价曲线表',
                x: -20 //center
            },
            subtitle: {
                text: '各节点为供应商竞价数额',
                x: -20
            },
            xAxis: {
                categories: ['第1次竞价', '第2次竞价', '第3次竞价', '第4次竞价', '第5次竞价', '第6次竞价',
                    '第7次竞价', '第8次竞价', '第9次竞价', '第10次竞价', '第11次竞价', '第12次竞价']
            },
            yAxis: {
                title: {
                    text: 'price (元)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function() {
                        return '<b>'+ this.series.name +'</b><br/>'+
                        this.x +': '+ this.y +'元';
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -10,
                y: 100,
                borderWidth: 0
            },
            series: [{
                name: '得力文具用品',
                data: [1200, 1140, 1120, 1080, 1040, 1000]
            }, {
                name: '文胜文具用品',
                data: [1190, 1150, 1090, 1050, 1030, 990]
            }, {
                name: '捷运办公用品',
                data: [1180, 1160, 1100, 1070, 1020, 970]
            }, {
                name: '和美文具用品',
                data: [1170, 1130, 1110, 1060, 1010, 980]
            }]
        });
    });
    
});
</script>
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
.STYLE2 {
	color: #000033;
	font-weight: bold;
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
      <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 采购项目管理管理 &gt; 电子竞标 </td>
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
          <form name="EditView" method="" action="" onsubmit="">
            <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
              <tbody>
                <tr>
                  <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
                      <tbody>
                        <tr>
                          <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
                          <td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>正在竞标</b></td>
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
                                            <td width="30%" align="left" class="dvtCellInfo"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                <tbody>
                                                  <tr>
                                                    <td colspan="4" class="detailedViewHeader"><b>基本信息</b></td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td height="30" colspan="4" align="right" class="dvtCellLabel"><span class="STYLE2">剩余时间:1小时22分钟21秒</span></td>
                                                    <!-- Non Editable field, only configured value will be loaded -->
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td width="23%" class="dvtCellLabel" align="right">竞标编号</td>
                                                    <td width="28%"  align="left" class="dvtCellInfo">201209301</td>
                                                    <td width="19%" align="right" class="dvtCellLabel">项目名称</td>
                                                    <td width="30%"  align="left" class="dvtCellInfo">测试数据D</td>
                                                    <!-- Non Editable field, only configured value will be loaded -->
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td class="dvtCellLabel" align="right">物料信息</td>
                                                    <td  align="left" class="dvtCellInfo">文具</td>
                                                    <td class="dvtCellLabel" align="right">竞标状态</td>
                                                    <td  align="left" class="dvtCellInfo">待确认竞标</td>
                                                  </tr>
                                                  <tr>
                                                    <td class="dvtCellLabel" align="right">起始价格</td>
                                                    <td  align="left" class="dvtCellInfo">1200</td>
                                                    <td class="dvtCellLabel" align="right">价格步进</td>
                                                    <td  align="left" class="dvtCellInfo">10元</td>
                                                  </tr>
                                                  <tr>
                                                    <td class="dvtCellLabel" align="right">竞标方式</td>
                                                    <td  align="left" class="dvtCellInfo">只看到价格</td>
                                                    <td class="dvtCellLabel" align="right">物料信息</td>
                                                    <td  align="left" class="dvtCellInfo">文具</td>
                                                  </tr>
                                                  <tr>
                                                    <td class="dvtCellLabel" align="right">竞标开始时间</td>
                                                    <td  align="left" class="dvtCellInfo">2012-10-1 13：00</td>
                                                    <td class="dvtCellLabel" align="right">竞标结束时间</td>
                                                    <td  align="left" class="dvtCellInfo">2012-10-1 15：00</td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td width="23%" class="dvtCellLabel" align="right">供应商名称</td>
                                                    <td colspan="3" class="dvtCellInfo" align="lift">齐心文具股份有限公司，北京文海文教有限公司，文联教育用品有限公司，上海盛夏办公用品，谋而合办公用品</td>
                                                  </tr>
                                                  <tr>
                                                    <td colspan="4" class="detailedViewHeader"><b>竞标正在进行中……</b></td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td width="23%" class="dvtCellLabel" align="right">供应商名称</td>
                                                    <td colspan="3" class="dvtCellLabel" align="lift">实时报价</td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td width="23%"  align="right" class="dvtCellInfo">北京文海文教有限公司</td>
                                                    <td colspan="3" align="left" class="dvtCellInfo">1130元</td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td  align="right" class="dvtCellInfo">齐心文具股份有限公司</td>
                                                    <td  align="left" colspan="3" class="dvtCellInfo">1150元</td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td  align="right" class="dvtCellInfo">文联教育用品有限公司</td>
                                                    <td  align="left" colspan="3" class="dvtCellInfo">1050元</td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td  align="right" class="dvtCellInfo">齐心文具股份有限公司</td>
                                                    <td  align="left" colspan="3" class="dvtCellInfo">1040元</td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td  align="right" class="dvtCellInfo">上海盛夏办公用品</td>
                                                    <td  align="left" colspan="3" class="dvtCellInfo">1010元</td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td  align="right" class="dvtCellInfo">齐心文具股份有限公司</td>
                                                    <td  align="left"  colspan="3" class="dvtCellInfo">1000元</td>
                                                  </tr>
                                                  <tr style="height:25px">
                                                    <td width="23%"  align="right" class="dvtCellInfo">谋而合办公用品</td>
                                                    <td  colspan="3" align="left" class="dvtCellInfo">990元</td>
                                                  </tr>
                                                  <tr>
                                                    <td colspan="4" class="detailedViewHeader"><b>查看曲线</b></td>
                                                  </tr>
                                                  <tr>
                                                    <td colspan="4">
													  <script src="../js/highcharts.js"></script>
													  <script src="../js/modules/exporting.js"></script>
													  <div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
                                                    </td>
                                                  </tr>
                                                  <tr>
                                                    <td height="40" colspan="4" style="padding:5px"><div align="center">
                                                        <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('auction_frame.jsp')" type="button" name="button" value="  返回  " style="width:70px" />
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
          </form>
        </div></td>
    </tr>
  </tbody>
</table>
<!-- 网站底部 -->
<p>&nbsp;</p>
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
