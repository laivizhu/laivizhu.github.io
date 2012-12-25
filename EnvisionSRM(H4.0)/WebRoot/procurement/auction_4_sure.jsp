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
    
  <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
  <tbody>
    <tr>
      <td>
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
      <tbody><tr>
        <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
        <td style="width:15%" align="center" class="dvtSelectedCell" id="bi" nowrap="nowrap">
         确认参加竞标的供应商
        </td>
        <td class="dvtTabCache" style="width:100%;" nowrap="nowrap">&nbsp;</td>
		
       
       </tr></tbody>
       </table>              
      </td>
    </tr>
    <tr>
      <td valign="top" align="left">
		<div id="basicTab" style="display: block; ">
		  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
		  <tbody><tr>
                <td align="left">
                  <div class="calDIV" style="overflow:auto; width:100%; margin:10px auto;">
                  <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
                    <tbody>
                        <tr>
                          <td class="lvtCol"></td>
                          <td class="lvtCol">供应商名称</td>
                          <td class="lvtCol">行业</td>
                          <td class="lvtCol">发报价状态</td>
                          <td class="lvtCol">报价</td>
                          <td class="lvtCol">电话</td>
                          <td class="lvtCol">城市</td>
                          <td class="lvtCol">负责人</td>
                          <td class="lvtCol">创办时间</td>
                        </tr>
                      <tr bgcolor="white"  id="row_116" class="lvtColData">
                        <td width="3%"><input type="checkbox" name="selectedid_approval" id="116" value="116" onclick="check_object(this);"/>                    </td>
                        <td>得力文具有限公司</td>
                        <td>办公用品</td>
                        <td>未发送报价</td>
                        <td>null</td>
                        <td>010-86687123</td>
                        <td>北京市丰台区</td>
                        <td>林安琪</td>
                        <td>2008-04-10</td>	
                      </tr>
                       <tr bgcolor="white"  id="row_116" class="lvtColData">
                          <td width="3%"><input type="checkbox" name="selectedid_approval" id="116" value="116" onclick="check_object(this);"/>                      </td>
                          <td>惠安股份有限公司</td>
                          <td>办公用品</td>
                          <td>已发送报价</td>
                          <td>1100</td>
                          <td>010-86682124</td>
                          <td>上海市</td>
                          <td>陈力丹</td>
                          <td>2005-02-12</td>
                        </tr>
                        <tr bgcolor="white"  id="row_116" class="lvtColData">
                          <td width="3%"><input type="checkbox" name="selectedid_approval" id="116" value="116" onclick="check_object(this);"/>                      </td>
                          <td>齐心文具有限公司</td>
                          <td>办公用品</td>
                          <td>已发送报价</td>
                          <td>1200</td>
                          <td>010-81324222</td>
                          <td>上海市</td>
                          <td>刘小龙</td>
                          <td>2002-10-04</td>
                        </tr>
                        <tr bgcolor="white"  id="row_116" class="lvtColData">
                          <td width="3%"><input type="checkbox" name="selectedid_approval" id="116" value="116" onclick="check_object(this);"/>                      </td>
                          <td>晨光文具有限公司</td>
                          <td>办公用品</td>
                          <td>已发送报价</td>
                          <td>900</td>
                          <td>010-86432900</td>
                          <td>河北省石家庄市</td>
                          <td>陈晓旭</td>
                          <td>2006-05-12</td>
                        </tr>
                    </tbody>
                  </table>
                
                    <div align="center">
                      <p>
                        <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="" type="submit" name="button2" value="  确定  " style="width:70px" />&nbsp;
                        <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('auction_frame.jsp')" type="button" name="button" value="  取消  " style="width:70px" />
                        </p>
                    </div>
                  </div>            
                </td>
        </tr>
        </tbody>
        </table>
        </div>
      </td>
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
