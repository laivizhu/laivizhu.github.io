<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>1.支出数据分析</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/content.css"/>
  <link rel="stylesheet" type="text/css" href="../css/common.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
  <script language="javascript" type="text/javascript" src="../js/common.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  <script src="highcharts.js"></script>
  <script src="exporting.js"></script>
  <script type="text/javascript">
$(function () {
    var chart1;
	var chart2;
	var chart3;
	var chart4;
    $(document).ready(function() {
        chart1 = new Highcharts.Chart({
            chart: {
                renderTo: 'container1',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '物料货源地/物料数量占比'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
            	percentageDecimals: 1
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        formatter: function() {
                            return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                        }
                    }
                }
            },
            
			series: [{
                type: 'pie',
                name: 'Browser share',
                data: [
                    ['江苏',   50.63],
					['山东省',   1.0],
					['辽宁省',   13.1],
                    {
                        name: '上海',
                        y: 21.30,
                        sliced: true,
                        selected: true
                    },
					['天津',   3.1],
                    ['印度',   1.0],
                    ['浙江',   9.1],
                    ['北京',   0.77]
                ]
            }]
        });
    });
    
	$(document).ready(function() {
        chart2 = new Highcharts.Chart({
            chart: {
                renderTo: 'container2',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '物料货源地/金额占比'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
            	percentageDecimals: 1
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        formatter: function() {
                            return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                        }
                    }
                }
            },
            
			series: [{
                type: 'pie',
                name: 'Browser share',
                data: [
                    ['江苏',   56],
					['山东省',   1],
					['辽宁省',   2],
                    {
                        name: '上海',
                        y: 4,
                        sliced: true,
                        selected: true
                    },
					['天津',   33],
                    ['印度',   0],
                    ['浙江',   3],
                    ['北京',   1]
                ]
            }]
        });
    });
	
	$(document).ready(function() {
        chart3 = new Highcharts.Chart({
            chart: {
                renderTo: 'container3',
                zoomType: 'xy'
            },
            title: {
                text: '物料累计占比'
            },
            subtitle: {
                text: 'Source: WorldClimate.com'
            },
            xAxis: [{
                categories: ['供应商1', '供应商2', '供应商3', '供应商4', '供应商5', '供应商6','供应商7', '供应商8', '供应商9', '供应商10', '供应商11', '供应商12', '供应商13', '供应商14', '供应商15', '供应商16', '供应商17', '供应商18']
            }],
            yAxis: [{ // Primary yAxis
                labels: {
                    formatter: function() {
                        return this.value +'元';
                    },
                    style: {
                        color: '#89A54E'
                    }
                },
                title: {
                    text: '支出',
                    style: {
                        color: '#89A54E'
                    }
                }
            }, { // Secondary yAxis
                title: {
                    text: '百分比',
                    style: {
                        color: '#4572A7'
                    }
                },
                labels: {
                    formatter: function() {
                        return this.value +' %';
                    },
                    style: {
                        color: '#4572A7'
                    }
                },
                opposite: true
            }],
            tooltip: {
                formatter: function() {
                    return ''+
                        this.x +': '+ this.y +
                        (this.series.name == '百分比' ? ' mm' : '元');
                }
            },
            legend: {
                layout: 'vertical',
                align: 'left',
                x: 120,
                verticalAlign: 'top',
                y: 100,
                floating: true,
                backgroundColor: '#FFFFFF'
            },
            series: [{
                name: '百分比',
                color: '#4572A7',
                type: 'column',
                yAxis: 1,
                data: [22.3, 40, 43, 49, 51, 54.4, 62.8, 68.9, 71.2, 79.8, 88.1, 93.9, 95.4, 95.8, 97.8, 98.9, 99, 99.6]
    
            }, {
                name: '支出',
                color: '#89A54E',
                type: 'spline',
                data: [3000000, 2090300, 2090300, 2003000, 1870000, 1800000, 1700000, 1400000, 1208920, 1008920, 900892, 740892, 650892, 400892, 390892, 200129]
            }]
        });
    });
	
	$(document).ready(function() {
        chart4 = new Highcharts.Chart({
            chart: {
                renderTo: 'container4',
                zoomType: 'xy'
            },
            title: {
                text: '供应商支出及累计占比'
            },
            subtitle: {
                text: 'Source: WorldClimate.com'
            },
            xAxis: [{
                categories: ['供应商1', '供应商2', '供应商3', '供应商4', '供应商5', '供应商6','供应商7', '供应商8', '供应商9', '供应商10', '供应商11', '供应商12', '供应商13', '供应商14', '供应商15', '供应商16', '供应商17', '供应商18']
            }],
            yAxis: [{ // Primary yAxis
                labels: {
                    formatter: function() {
                        return this.value +'元';
                    },
                    style: {
                        color: '#89A54E'
                    }
                },
                title: {
                    text: '支出',
                    style: {
                        color: '#89A54E'
                    }
                }
            }, { // Secondary yAxis
                title: {
                    text: '百分比',
                    style: {
                        color: '#4572A7'
                    }
                },
                labels: {
                    formatter: function() {
                        return this.value +' %';
                    },
                    style: {
                        color: '#4572A7'
                    }
                },
                opposite: true
            }],
            tooltip: {
                formatter: function() {
                    return ''+
                        this.x +': '+ this.y +
                        (this.series.name == 'Rainfall' ? ' mm' : '元');
                }
            },
            legend: {
                layout: 'vertical',
                align: 'left',
                x: 120,
                verticalAlign: 'top',
                y: 100,
                floating: true,
                backgroundColor: '#FFFFFF'
            },
            series: [{
                name: '百分比',
                color: '#4572A7',
                type: 'column',
                yAxis: 1,
                data: [22.3, 40, 43, 49, 51, 54.4, 62.8, 68.9, 71.2, 79.8, 88.1, 93.9, 95.4, 95.8, 97.8, 98.9, 99, 99.6]
    
            }, {
                name: '支出',
                color: '#89A54E',
                type: 'spline',
                data: [3000000, 2090300, 2090300, 2003000, 1870000, 1800000, 1700000, 1400000, 1208920, 1008920, 900892, 740892, 650892, 400892, 390892, 200129]
            }]
        });
    });
});
</script>
</head>

<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级导航 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="category.jsp">物料类别设置</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="material_main.jsp">物料主数据查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="expenditure.jsp">物料支出分析</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="sourcing.jsp">类别管理七步法</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap">您现在的位置： 采购项目管理 &gt; 类别管理七步法 &gt; 1.分析类别支出</td>
  <td width="100%">&nbsp;</td>
  <td align="right" style="padding-right:15px;">
  	<jsp:include page="../common/toolbar.jsp" flush="true"/>
  </td>
</tr></tbody>
</table>

<!-- Content -->	
<table width="100%" class="content_background" cellpadding="0" cellspacing="0" border="0" align="center" ><tbody><tr>
<td width="100%" align="left" valign="top">
<!-- 内容开始 -->
<div id="tabs" class="content_tab">
<div style="padding-left:15px;">
  <a href="sourcing.jsp" target="_self" style="font-weight:bold;">1.&nbsp;分析类别支出</a> &gt; 
  <a href="sourcing2.jsp" target="_self">2.&nbsp;分析采购需求</a> &gt;
  <a href="sourcing3.jsp" target="_self">3.&nbsp;组建类别团队</a> &gt;
  <a href="sourcing4.jsp" target="_self">4.&nbsp;分析供应市场</a> &gt;
  <a href="sourcing5.jsp" target="_self">5.&nbsp;制定类别策略</a> &gt;
  <a href="sourcing6.jsp" target="_self">6.&nbsp;制定实施计划</a> &gt;
  <a href="sourcing7.jsp" target="_self">7.&nbsp;查询方案进度</a>
</div>
<hr style="width:99%; margin-top:10px; margin-bottom:10px; margin-left:8px;"  />
<div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab1" class="content_tab_title_selected" align="center" onclick="showTab(1,6);">支出数据分析</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab2" class="content_tab_title_unselected" align="center" onclick="showTab(2,6);">物料卡片</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab3" class="content_tab_title_unselected" align="center" onclick="showTab(3,6);">物料重要性分析</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab4" class="content_tab_title_unselected" align="center" onclick="showTab(4,6);">供应风险分析</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab5" class="content_tab_title_unselected" align="center" onclick="showTab(5,6);">类别支出结果输出</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab6" class="content_tab_title_unselected" align="center" onclick="showTab(6,6);">物料重要性结果输出</td>
    <td class="content_tab_title_cache" style="width:100%"></td>
  </tr></tbody></table>
</div>

<div class="content_tab_detail">
  
  <div id="div1" class="content_tab_div_selected">
   <div id="searchBox">
  <form id="searcMaterialCategory" method="post" action="#">
  <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
    <td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 物料</span></td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b> 在</b>&nbsp;
        <select name="searchCondition" class="search_input"  style="width:120px">
            <option value="name" selected="selected">物料ID</option>
            <option value="createTime">SAP Code</option>
            <option value="createTime">物料名称</option>
            <option value="modifyTime">所属类别</option>
            <option value="modifyTime">创建时间</option>
            <option value="modifyTime">修改时间</option>
        </select>
        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找&nbsp;&nbsp;&nbsp;&nbsp;</b>
        <input type="text" name="keyword" class="search_input" style="width:150px" />&nbsp;&nbsp;
        <input name="submit" type="button" value=" 立刻查找 " class="search_button"/>
	</td>
    <td></td>
  </tr></tbody></table>
  </form>
  </div>
  <div style="height:20px;"></div>
  
  <form id="deleteAll" name="deleteAll" method="post" action="">
  <table border="0" cellspacing="0" cellpadding="2" width="100%"><tr>
    <td width="20%" height="25" style="white-space:nowrap;"><input class="crmbutton small edit" type="button" value="设置为缺省"/></td>
	<td width="60%" align="center" nowrap="nowrap">
    共 10 页，
    <a href="#"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a>
    &nbsp;当前第&nbsp;1&nbsp;页&nbsp;
    <a href="#"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a>
	</td>
    <td width="20%" align="right" style="padding-right:15px; white-space:nowrap;">每页显示 6 条记录</td>	
  </tr></table>
  <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
	  
      	<!-- List Content Title -->
        <tr>
          <td width="3%" class="lvtCol"></td>
          <td width="10%" height="25" align="left" class="lvtCol">物料ID</td>
          <td width="10%" align="left" class="lvtCol">SAP Code</td>
          <td width="30%" align="left" class="lvtCol">物料名称</td>
          <td width="27%" align="left" class="lvtCol">所属类别</td>
          <td width="10%" align="left" class="lvtCol">创建时间</td>
          <td width="10%" align="left" class="lvtCol">修改时间</td>
        </tr>
        
        <div id="list">
        <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
          <td width="3%" align="center"><input type="radio" name="selectedid_approval" id="116" value="116" onclick="check_object(this);" toggleselectall(this.name,"selectall")=""></td>
          <td align="left" height="19" >1000001</td>
          <td align="left" >2000001</td>
          <td align="left" >定制紧固件</td>
          <td align="left" >定制紧固件</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >2012-11-04</td>
       
        </tr>
        <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
        <td width="3%" align="center"><input type="radio" name="selectedid_approval" id="116" value="116" onclick="check_object(this);" toggleselectall(this.name,"selectall")=""></td>
          <td height="19" align="left" >1000002</td>
          <td align="left" >2000002</td>
          <td align="left" >定制塑料件</td>
          <td align="left" >定制塑料件</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >2012-11-04</td>
          
        </tr>
        <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
        <td width="3%" align="center"><input type="radio" name="selectedid_approval" id="116" value="116" onclick="check_object(this);" toggleselectall(this.name,"selectall")=""></td>
          <td height="19" align="left" >1000003</td>
          <td align="left" >2000003</td>
          <td align="left" >主轴承</td>
          <td align="left" >轴承</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >2012-11-04</td>
          
        </tr>
        <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
        <td width="3%" align="center"><input type="radio" name="selectedid_approval" id="116" value="116" onclick="check_object(this);" toggleselectall(this.name,"selectall")=""></td>
          <td height="19" align="left" >1000004</td>
          <td align="left" >2000004</td>
          <td align="left" >弹性支承</td>
          <td align="left" >弹性支承</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >2012-11-04</td>
          
        </tr>
        <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
        <td width="3%" align="center"><input type="radio" name="selectedid_approval" id="116" value="116" onclick="check_object(this);" toggleselectall(this.name,"selectall")=""></td>
          <td height="19" align="left" >1000005</td>
          <td align="left" >2000005</td>
          <td align="left" >轴承座</td>
          <td align="left" >铸件类</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >2012-11-04</td>
          
        </tr>
        <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
        <td width="3%" align="center"><input type="radio" name="selectedid_approval" id="116" value="116" onclick="check_object(this);" toggleselectall(this.name,"selectall")=""></td>
          <td height="19" align="left" >1000006</td>
          <td align="left" >2000006</td>
          <td align="left" >小锻件</td>
          <td align="left" >锻件类</td>
          <td align="left" >2012-11-01</td>
          <td align="left" >2012-11-04</td>
         
        </tr>        
        </div>
	  </table>
  <table border="0" cellspacing="0" cellpadding="2" width="100%"><tr>
    <td width="20%" height="25" style="padding-left:15px; white-space:nowrap;">&nbsp;</td>
	<td width="60%" align="center" nowrap="nowrap">
    共 10 页，
    <a href="#"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a>
    &nbsp;当前第&nbsp;1&nbsp;页&nbsp;
    <a href="#"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a>
	</td>
    <td width="20%" align="right" style="padding-right:15px; white-space:nowrap;">每页显示 6 条记录</td>	
  </tr></table>
  </form>
  <div style="margin-top:14px;"></div>
  </div>
  
  <div id="div2" class="content_tab_div_unselected">
  <form action="#" method="post">
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody>
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>物料基本信息</b></td>
  </tr>
  <tr>
	<td width="15%" class="dvtCellLabel" align="right">物料ID：</td>
	<td width="85%" align="left" class="dvtCellInfo">1000001</td>
  </tr>
  <tr>
	<td width="15%" class="dvtCellLabel" align="right">SAP Code：</td>
	<td width="85%" align="left" class="dvtCellInfo">2000001</td>
  </tr>
  <tr>
	<td width="15%" class="dvtCellLabel" align="right">物料名称：</td>
	<td width="85%" align="left" class="dvtCellInfo">叶片</td>
  </tr>
   <tr>
	<td width="15%" class="dvtCellLabel" align="right">物料说明：</td>
	<td width="85%" align="left" class="dvtCellInfo">对风机非常重要</td>
  </tr>
  
  <tr>
  	<td width="100%" height="20" colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>物料属性特点</b></td>
  </tr>
  
  <tr>
	<td align="right" valign="top" class="dvtCellLabel" style="padding-top:10px;">特点</td>
	<td align="left"  valign="top" class="dvtCellInfo" style="padding:5px;">
	  <textarea name="dispose2" cols="40" rows="5" style="height:150px;"></textarea>   	
    </td>
  </tr>
  
  <tr>
  	<td width="100%" height="20" colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>主要生产工艺</b></td>
  </tr>
  
  <tr>
	<td align="right" valign="top" class="dvtCellLabel" style="padding-top:10px;">工艺：</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;">
	  <textarea name="dispose3" cols="40" rows="5" style="height:150px;"></textarea>
	
    	
    </td>
  </tr>
  
  
  
   <tr>
  	<td width="100%" height="20" colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>主要上游产品</b></td>
  </tr>
  
  <tr>
	<td align="right" valign="top" class="dvtCellLabel" style="padding-top:10px;">产品：</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;">
    	<textarea name="dispose" cols="40" rows="5" style="height:150px;"></textarea>
    </td>
  </tr>
  <tr>
  	<td width="100%" height="20" colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>行业领先供应商</b></td>
  </tr>
  
  <tr>
	<td align="right" valign="top" class="dvtCellLabel" style="padding-top:10px;">供应商：</td>
	<td align="left" class="dvtCellInfo" style="padding:5px;">
    	<textarea name="dispose" cols="40" rows="5" style="height:150px;"></textarea>
    </td>
  </tr>
  <tr>
  	<td width="100%" height="20" colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td colspan="2" class="detailedViewHeader"><b>企业现有供应商</b></td>
  </tr>
  
  <tr>
	<td align="right" valign="top" class="dvtCellLabel" colspan="10">
      <table border="0" cellspacing="1" cellpadding="3" width="100%" class="small">
        <tr>
          <th width="10%" align="left" >供应商ID</th>
          <th width="25%" align="left" >供应商名称</th>
          <th width="15%" align="left">支出金额（万元）</th>
          <th width="15%" align="left">付款方式</th>
          <th width="15%" align="left">合作年限</th>
          <th width="20%" align="left">所在地</th>
        </tr>        
        <tr>
       	  <td align="left" height="19" >1000001</td>
          <td align="left" >LM江苏</td>
          <td align="left" >22,879</td>
          <td align="left" >提货前付清</td>
          <td align="left" >2</td>
          <td align="left" >江阴</td>
        </tr>
        <tr>
       	  <td align="left" height="19" >1000002</td>
          <td align="left" >LM天津</td>
          <td align="left" >4114</td>
          <td align="left" >提货前付清</td>
          <td align="left" >3</td>
          <td align="left" >天津</td>
        </tr>
        <tr>
       	  <td align="left" height="19" >1000003</td>
          <td align="left" >LM北京</td>
          <td align="left" >3,123</td>
          <td align="left" >提货前付清</td>
          <td align="left" >2</td>
          <td align="left" >北京</td>
        </tr>
            
	  </table>
    
    </td>
	
  </tr>
  
  <tr>
	<td colspan="3" align="center" width="100%" height="40" style="padding-right:20px;">
      <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
	  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
    </td>
  </tr>
</tbody></table>
</form>
  </div>
  
  <div id="div3" class="content_tab_div_unselected">
  
  <form>
  <table width="98%" align="center" cellpadding="3" cellspacing="0">
  <tr>
    <td colspan="3" class="detailedViewHeader"><b>填写物料重要性分析评估表</b></td>
  </tr>
  </table>
<table width="98%" cellpadding="3" cellspacing="0" align="center" class="table_border">
  <tr>
    <td height="50px" colspan="7" align="center" valign="middle" class="td_border_title">物料属性：70%</td>
    <td colspan="3" align="center" valign="middle" class="td_border_title">市场属性：30%</td>
    </tr>
  <tr>
    <td width="10%" align="center" class="td_border_title">权重</td>
    <td width="10%" align="center" class="td_border">0.15</td>
    <td width="10%" align="center" class="td_border">0.15</td>
    <td width="10%" align="center" class="td_border">0.15</td>
    <td width="10%" align="center" class="td_border">0.15</td>
    <td width="10%" align="center" class="td_border">0.24</td>
    <td width="10%" align="center" class="td_border">0.16</td>
    <td width="10%" align="center" class="td_border">0.8</td>
    <td width="10%" align="center" class="td_border">0.1</td>
    <td width="10%" align="center" class="td_border">0.1</td>
  </tr>
  <tr>
    <td class="td_border_title" align="center">评分部门</td>
    <td class="td_border" align="center">SQE</td>
    <td class="td_border" align="center">质量工程</td>
    <td class="td_border" colspan="2" align="center">制造/现场</td>
    <td class="td_border" colspan="2" align="center">研发</td>
    <td class="td_border" colspan="3" align="center">采购</td>
    </tr>
  <tr>
    <td class="td_border" align="center" style="height:60px;">&nbsp;</td>
    <td class="td_border" align="center">物料质量问题对于风机性能的影响程度</td>
    <td class="td_border" align="center">质量对风机运行的影响</td>
    <td class="td_border" align="center">供应停顿对生产的影响程度</td>
    <td class="td_border" align="center">质量对于装配的影响</td>
    <td class="td_border" align="center">物料的可替换性，60%</td>
    <td class="td_border" align="center">物料替换的开发周期，40%</td>
    <td class="td_border" align="center">竞争关系，即市场上供应商的数量</td>
    <td class="td_border" align="center">货源地运输</td>
    <td class="td_border" align="center">供应链复杂度</td>
  </tr>
  <tr>
    <td class="td_border_title" align="center">叶片</td>
    <td class="td_border" align="center"><input name="textfield" type="text" id="textfield" size="2" maxlength="2" class="td_input"/></td>
    <td class="td_border" align="center"><input name="textfield2" type="text" id="textfield2" size="2" maxlength="2" class="td_input" /></td>
    <td class="td_border" align="center"><input name="textfield3" type="text" id="textfield3" size="2" maxlength="2" class="td_input" /></td>
    <td class="td_border" align="center"><input name="textfield4" type="text" id="textfield4" size="2" maxlength="2" class="td_input" /></td>
    <td class="td_border" align="center"><input name="textfield5" type="text" id="textfield5" size="2" maxlength="2" class="td_input" /></td>
    <td class="td_border" align="center"><input name="textfield6" type="text" id="textfield6" size="2" maxlength="2" class="td_input" /></td>
    <td class="td_border" align="center"><input name="textfield7" type="text" id="textfield7" size="2" maxlength="2" class="td_input" /></td>
    <td class="td_border" align="center"><input name="textfield8" type="text" id="textfield8" size="2" maxlength="2" class="td_input" /></td>
    <td class="td_border" align="center"><input name="textfield9" type="text" id="textfield9" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border_title" align="center">齿轮箱</td>
    <td class="td_border" align="center"><input name="textfield10" type="text" id="textfield10" size="2" maxlength="2" class="td_input" /></td>
    <td class="td_border" align="center"><input name="textfield11" type="text" id="textfield11" size="2" maxlength="2" class="td_input"/></td>
    <td class="td_border" align="center"><input name="textfield12" type="text" id="textfield12" size="2" maxlength="2" class="td_input"/></td>
    <td class="td_border" align="center"><input name="textfield13" type="text" id="textfield13" size="2" maxlength="2" class="td_input"/></td>
    <td class="td_border" align="center"><input name="textfield14" type="text" id="textfield14" size="2" maxlength="2" class="td_input"/></td>
    <td class="td_border" align="center"><input name="textfield15" type="text" id="textfield15" size="2" maxlength="2" class="td_input"/></td>
    <td class="td_border" align="center"><input name="textfield16" type="text" id="textfield16" size="2" maxlength="2" class="td_input"/></td>
    <td class="td_border" align="center"><input name="textfield17" type="text" id="textfield17" size="2" maxlength="2" class="td_input"/></td>
    <td class="td_border" align="center"><input name="textfield18" type="text" id="textfield18" size="2" maxlength="2" class="td_input"/></td>
  </tr>
</table>
<table width="100%">
<tr>
<td colspan="10" align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>
  
  </div>
  
  <div id="div4" class="content_tab_div_unselected">
  <form>
<table width="98%" align="center" cellpadding="3" cellspacing="0">
  <tr>
    <td colspan="3" class="detailedViewHeader"><b>1、战略重要性评估维度（X轴）</b></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="15%" height="28" align="center" valign="middle" class="td_border_title">&nbsp;</td>
    <td width="15%" align="center" valign="middle" class="td_border_title">X轴</td>
    <td width="50%" align="center" valign="middle" class="td_border_title">选项</td>
    <td width="20%" align="center" valign="middle" class="td_border_title">分数</td>
  </tr>
  <tr>
    <td rowspan="8" align="center" valign="middle" class="td_border_title">支出金额</td>
    <td rowspan="8" align="center" valign="middle" class="td_border_title">年度支出金额</td>
    <td class="td_border">&lt;0.01%</td>
    <td rowspan="8" align="center" class="td_border"><input name="textfield7" type="text" id="textfield7" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">0.01% ~ 0.05%</td>
    </tr>
  <tr>
    <td class="td_border">0.05% ~ 0.1%</td>
    </tr>
  <tr>
    <td class="td_border">0.1% ~ 0.5%</td>
    </tr>
  <tr>
    <td class="td_border">0.5% ~ 1%</td>
    </tr>
  <tr>
    <td class="td_border">1% ~ 5%</td>
    </tr>
  <tr>
    <td class="td_border">5% ~10%</td>
    </tr>
  <tr>
    <td class="td_border">&gt; 10%</td>
    </tr>
  <tr>
    <td rowspan="3" align="center" valign="middle" class="td_border_title">账期</td>
    <td rowspan="3" align="center" valign="middle" class="td_border_title">物料小组账期</td>
    <td class="td_border">90天</td>
    <td rowspan="3" align="center" class="td_border"><input name="textfield19" type="text" id="textfield19" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">30天</td>
    </tr>
  <tr>
    <td class="td_border">全额付款</td>
    </tr>
  <tr>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">价格弹性</td>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">价格弹性</td>
    <td class="td_border">当需求增加时，不引起价格变化</td>
    <td rowspan="5" align="center" class="td_border"><input name="textfield20" type="text" id="textfield20" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">当需求增加时，引起价格较小变化</td>
    </tr>
  <tr>
    <td class="td_border">当需求增加时，引起价格中等变化</td>
    </tr>
  <tr>
    <td class="td_border">当需求增加时，引起价格较大变化</td>
    </tr>
  <tr>
    <td class="td_border">当需求增加时，引起很大的价格变化</td>
    </tr>
</table>
<table width="98%" align="center" cellpadding="3" cellspacing="0">
  <tr>
    <td colspan="3" class="detailedViewHeader"><b>2、供应风险（Y轴）</b></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
  <tr>
    <td width="15%" height="28" align="center" valign="middle" class="td_border_title">&nbsp;</td>
    <td width="15%" align="center" valign="middle" class="td_border_title">Y轴</td>
    <td width="50%" align="center" valign="middle" class="td_border_title">选项</td>
    <td width="20%" align="center" valign="middle" class="td_border_title">分数</td>
  </tr>
  <tr>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">物料属性</td>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">供应停顿造成影响</td>
    <td class="td_border">存在解决办法，对业务没有影响</td>
    <td rowspan="5" align="center" class="td_border"><input name="textfield9" type="text" id="textfield9" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">需要很短时间找到可替代的供应商，对业务影响很小</td>
    </tr>
  <tr>
    <td class="td_border">需要一些时间来找到可替代的供应商，对业务影响中等</td>
    </tr>
  <tr>
    <td class="td_border">需要很长时间来找到可替代的供应商，短期有较大影响</td>
    </tr>
  <tr>
    <td class="td_border">在中长期内很难找到可替代的供应商，有很大影响</td>
    </tr>
  
  <tr>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">物料属性</td>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">产品技术复杂程度<br/>技术规格要求复杂程度</td>
    <td class="td_border">普通规格，普通形式</td>
    <td rowspan="5" align="center" class="td_border"><input name="textfield21" type="text" id="textfield21" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">标准的规格，标准形式和设计</td>
    </tr>
  <tr>
    <td class="td_border">对标准规格有小幅改动，对标准形式和设计有小幅改动</td>
    </tr>
  <tr>
    <td class="td_border">完全定制的规格，复杂的形式和设计</td>
    </tr>
  <tr>
    <td class="td_border">全新的规格指标，全新的形式和设计</td>
    </tr>
  <tr>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">物料属性</td>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">产品组合及生产制程复杂程度<br/>生产工艺负责程度</td>
    <td class="td_border">简单，生产制程少</td>
    <td rowspan="5" align="center" class="td_border"><input name="textfield22" type="text" id="textfield22" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">简单，生产制程多</td>
    </tr>
  <tr>
    <td class="td_border">中等，生产制程中等</td>
    </tr>
  <tr>
    <td class="td_border">负责，生产制程少</td>
    </tr>
  <tr>
    <td class="td_border">负责，生产制程多</td>
    </tr>
  <tr>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">物料属性</td>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">采购该物料的历史</td>
    <td class="td_border">采购该物料超过10年</td>
    <td rowspan="5" align="center" class="td_border"><input name="textfield23" type="text" id="textfield23" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">采购该物料介于5年到10年之间</td>
    </tr>
  <tr>
    <td class="td_border">采购该物料介于3年到5年之间</td>
    </tr>
  <tr>
    <td class="td_border">采购该物料介于1年到3年之间</td>
    </tr>
  <tr>
    <td class="td_border">采购该物料少于1年</td>
    </tr>
  <tr>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">市场属性</td>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">供需关系</td>
    <td class="td_border">供应远大于需求，中长期内供应不可能下降</td>
    <td rowspan="5" align="center" class="td_border"><input name="textfield24" type="text" id="textfield24" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">供应大于需求，短期内供应能够对需求做出反应</td>
    </tr>
  <tr>
    <td class="td_border">供应与需求平衡，供应会很快对需求的增长做出反应</td>
    </tr>
  <tr>
    <td class="td_border">需求大于供应，供应会很慢才能对需求的增长作出反应</td>
    </tr>
  <tr>
    <td class="td_border">需求远大于供应，供应很难对需求的增长作出反应</td>
    </tr>
  <tr>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">市场属性</td>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">竞争关系，即市场上供应商的数量</td>
    <td class="td_border">充分竞争市场，众多供应商水平接近（超过10个）</td>
    <td rowspan="5" align="center" class="td_border"><input name="textfield25" type="text" id="textfield25" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">存在许多有竞争力的供应商（超过6个）</td>
    </tr>
  <tr>
    <td class="td_border">存在一些有竞争力的供应商（4~6个）</td>
    </tr>
  <tr>
    <td class="td_border">寡头垄断市场，有几个有竞争力的供应商（2~3个）</td>
    </tr>
  <tr>
    <td class="td_border">只有单一垄断性的供应商（包括区域垄断）</td>
    </tr>
  <tr>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">市场属性</td>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">进入壁垒</td>
    <td class="td_border">相对于整个供应市场和市场容量，近乎不存在进入壁垒（少量资金）</td>
    <td rowspan="5" align="center" class="td_border"><input name="textfield26" type="text" id="textfield26" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">相对于整个供应市场和市场容量，进入门槛较低（少量投资，通用人才）</td>
    </tr>
  <tr>
    <td class="td_border">相对于整个供应市场和市场容量，进入门槛中等（中等投资，通用人才，技术）</td>
    </tr>
  <tr>
    <td class="td_border"><p>相对于整个供应市场和市场容量，进入门槛高（大量资金、许可）</p></td>
    </tr>
  <tr>
    <td class="td_border">相对于整个供应市场和市场容量，进入门槛极高（大量资金、人才、许可证有限）</td>
    </tr>
  <tr>
    <td rowspan="3" align="center" valign="middle" class="td_border_title">市场属性</td>
    <td rowspan="3" align="center" valign="middle" class="td_border_title">货源地运输</td>
    <td class="td_border">短距离</td>
    <td rowspan="3" align="center" class="td_border"><input name="textfield27" type="text" id="textfield27" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">中距离</td>
    </tr>
  <tr>
    <td class="td_border">长距离</td>
    </tr>
  <tr>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">市场属性</td>
    <td rowspan="5" align="center" valign="middle" class="td_border_title">供应链复杂度</td>
    <td class="td_border">一个在技术上/资源上垄断的供应商</td>
    <td rowspan="5" align="center" class="td_border"><input name="textfield28" type="text" id="textfield28" size="2" maxlength="2" class="td_input" /></td>
  </tr>
  <tr>
    <td class="td_border">一个在技术上、资源上垄断的供应商和少数几个（1~5个）分销商/贸易商/代理</td>
    </tr>
  <tr>
    <td class="td_border">一个在技术上、资源上垄断的供应商和众多（5个以上）分销商/贸易商/代理</td>
    </tr>
  <tr>
    <td class="td_border">几个（1~3个）在技术上/资源上垄断的供应商和众多（5个以上）分销商/贸易商/代理</td>
    </tr>
  <tr>
    <td class="td_border">众多（3个以上）在技术上/资源上垄断的供应商和众多（5个以上）分销商/贸易商/代理</td>
    </tr>
</table>

<table width="100%">
<tr>
<td colspan="10" align="center" height="40">
  <input class="crmbutton small save" type="submit" value="  保存  " style="width:70px"/>&nbsp;&nbsp;
  <input class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
</td>
</tr>
</table>
</form>
  </div>
  
  <div id="div5" class="content_tab_div_unselected">
<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>物料货源地/物料数量占比</b></td>
  </tr></table>
		<div id="container1" align="center" style="min-width:800px;height: 400px; margin: 0 auto"></div>
		
		
		  <table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>物料货源地/金额占比</b></td>
  </tr></table>
		<div id="container2" align="center" style="min-width: 800px; height: 400px; margin: 0 auto"></div>
		
	<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>物料累计占比</b></td>
    </tr></table>
		<div id="container3" align="center"  style="min-width: 800px; height: 400px; margin: 0 auto"></div>
		
	<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>供应商支出及累计占比</b></td>
  </tr></table>
		<div id="container4" align="center" style="min-width: 800px; height: 400px; margin: 0 auto"></div>
  
  </div>
  
  <div id="div6" class="content_tab_div_unselected">
  <!--<div id="container3" style="width: 80%; height: 400px; margin: 0 auto"></div>-->
  	<table width="98%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>物料重要性分析结果</b></td>
  </tr></table>
 <div align="center"> <img src="../images/temp3.jpg" name="p" /> </div>
  </div>

  
  
 
</div>


</td>
</tr></tbody></table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>