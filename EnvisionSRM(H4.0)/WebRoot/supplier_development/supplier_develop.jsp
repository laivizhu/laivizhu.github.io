<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>寻源进度报告</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript">
  
  function DispContent( i , count)
{
var m=i;
var test = document.getElementById('test'+i);	
var div = document.getElementById( 'div' + i );
var div_projectInfo=document.getElementById('projectInfo');
if(i==1){
	div_projectInfo.style.display ="none";
}else{
	div_projectInfo.style.display ="";
}
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
<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>

<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>

<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_set.jsp">供应商注册管理</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_sourceProject.jsp">供应商寻源项目管理</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="supplier_develop.jsp">寻源进度报告</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_securit.jsp">供应商保密协议管理</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
   <td style="padding-left:15px;" nowrap="nowrap">您现在的位置：采购项目管理 &gt; OA寻源进度报告</td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>

<!--  -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">
<!-- 内容开始 -->
<div class="contentViewDiv">
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody>

  <tr>
	<td align="left" class="detailedViewHeader" colspan="6"><b>采购寻源项目信息 </b></td>
  </tr>
  <tr>
    <td align="left" colspan="6" class="dvtCellLabel"><span style="font-weight:bold">基本信息</span></td>
  </tr>
  <tr>
    <td align="right" width="15%" class="dvtCellLabel">申请名称</td>
    <td align="left" width="85%" class="dvtCellInfo" colspan="5">黄岛寻源仪采购项目</td>
  </tr>
  <tr>
    <td align="right" class="dvtCellLabel">申请人</td>
    <td align="left" width="20%" class="dvtCellInfo">胡洋</td>
    <td align="right" width="15%" class="dvtCellLabel">申请编号 </td>
    <td align="left" width="20%" class="dvtCellInfo">201211R-001</td>
    <td align="right" width="15%" class="dvtCellLabel">申请时间</td>
    <td align="left" width="15%" class="dvtCellInfo">2012-10-02</td>
  </tr>
  <tr>
    <td align="right" class="dvtCellLabel">物料类别</td>
    <td align="left" class="dvtCellInfo">机械类别</td>
    <td align="right" class="dvtCellLabel">物料子类 </td>
    <td align="left" class="dvtCellInfo">齿轮箱</td>
    <td align="right" class="dvtCellLabel">物料描述* </td>
    <td align="left" class="dvtCellInfo">定制紧固件</td>
  </tr>
  <tr>
    <td align="right" class="dvtCellLabel">机型平台</td>
    <td align="left" class="dvtCellInfo">机械平台</td>
    <td align="right" class="dvtCellLabel">物料属性 </td>
    <td align="left" class="dvtCellInfo">生产性物料</td>
    <td align="right" class="dvtCellLabel">类别团队</td>
    <td align="left" class="dvtCellInfo">定制紧固件物料小组</td>
  </tr>
  <tr>
    <td align="right" class="dvtCellLabel">申请开发原因* </td>
    <td align="left" width="55%" colspan="3" class="dvtCellInfo">分析物料质量问题对于风机性能的影响程度</td>
    <td align="right" class="dvtCellLabel">所属项目编号* </td>
    <td align="left" class="dvtCellInfo">201201YJ001</td>
  </tr>
  <tr>
    <td align="right" width="15%" class="dvtCellLabel">原因详细描述* </td>
    <td align="left" width="85%" class="dvtCellInfo" colspan="5">物料的可替换性60%，物料替换的开发周期40%</td>
  </tr>
</tbody>
</table>
<div id="projectInfo" style="display:none">
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody>
  <tr>
    <td align="left" colspan="6" class="dvtCellLabel"><span style="font-weight:bold">项目计划信息</span></td>
  </tr>
  <tr>
    <td align="right" width="15%" class="dvtCellLabel">寻源项目名称</td>
    <td align="left" width="20%" class="dvtCellInfo">机械紧固件寻源</td>
    <td align="right" width="15%" class="dvtCellLabel">寻源项目负责人 </td>
    <td align="left" width="20%" class="dvtCellInfo">胡小得</td>
    <td align="right" width="15%" class="dvtCellLabel">寻源项目编号</td>
    <td align="left" width="15%" class="dvtCellInfo">201210005</td>
  </tr>
  <tr>
    <td align="right" class="dvtCellLabel">研发代表</td>
    <td align="left" class="dvtCellInfo">机械研发团队</td>
    <td align="right" class="dvtCellLabel">SQE代表 </td>
    <td align="left" class="dvtCellInfo">质量工程团队</td>
    <td align="right" class="dvtCellLabel">其他成员 </td>
    <td align="left" class="dvtCellInfo">辅助设计者</td>
  </tr>
  <tr>
         <td align="right" width="15%" class="dvtCellLabel">备选供应商信息收集<br />完成时间* </td>
         <td align="left"  class="dvtCellInfo">2012-10-01</td>
         <td align="right" width="15%" class="dvtCellLabel">寻源项目开始时间* </td>
         <td align="left" class="dvtCellInfo">2012-10-10</td>
         <td align="right" class="dvtCellLabel">供应商资质终审完成时间*</td>
         <td align="left" width="15%" class="dvtCellInfo">2012-10-15</td>
      </tr>
      <tr>
         <td align="right" width="15%" class="dvtCellLabel">样件协议 签订时间*</td>
         <td align="left"  class="dvtCellInfo">2012-10-16</td>
         <td align="right" width="15%" class="dvtCellLabel">样件开发完成时间* </td>
         <td align="left"  class="dvtCellInfo">2012-10-20</td>
         <td align="right" class="dvtCellLabel">合格供应商确认时间*</td>
         <td align="left" width="15%" class="dvtCellInfo">2012-10-25</td>
      </tr>
</tbody></table>
</div>

<!-- 寻源进度条开始 --> 
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
 <tbody>  
   <tr height="15"><td></td></tr>
   <tr>
	<td align="left" class="detailedViewHeader"><b>采购寻源项目进度信息 </b></td>
   </tr>
   <tr height="15"><td><img src="../images/schedule.png" style="border-bottom-style:hidden"/></td></tr>
 </tbody>
</table>
<!-- 寻源进度条结束 -->   
<div style="height:5px"></div>  
  
<!-- 寻源进度信息开始 -->  
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
 <tbody>  
 <tr>
                <td><table class="small" border="0" cellpadding="3" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test1" class="dvtSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(1,7);">需求申请</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test2" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(2,7);">供应商信息收集</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test3" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(3,7);">项目开始</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test4" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(4,7);">资质终审</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test5" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(5,7);">样件协议</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test6" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(6,7);">样件开发</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test7" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onclick="DispContent(7,7);">合格供应商确认</td>
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
                      <jsp:include page="supplier_develop_1.jsp" flush="true"/>
                      <jsp:include page="supplier_develop_2.jsp" flush="true"/>
                      <jsp:include page="supplier_develop_3.jsp" flush="true"/>
                      <jsp:include page="supplier_develop_4.jsp" flush="true"/>
                      <jsp:include page="supplier_develop_5.jsp" flush="true"/>
                      <jsp:include page="supplier_develop_6.jsp" flush="true"/>
                      <jsp:include page="supplier_develop_7.jsp" flush="true"/>
                    </td>
                  </tr>
                </tbody>
              </table></td>
          </tr>
        </tbody>
      </table></td>
   </tr>

</tbody></table>
<!-- 寻源进度信息结束 -->

</div>

  </td></tr>
</tbody></table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>
