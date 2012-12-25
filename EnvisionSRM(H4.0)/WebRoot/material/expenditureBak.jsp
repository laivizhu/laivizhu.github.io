<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>物料支出分析</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../css/content.css"/>
  <link rel="stylesheet" type="text/css" href="../css/common.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
  <script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
  <script language="javascript" type="text/javascript" src="../js/common.js"></script>
  
  <!-- cehn add script -->
  <script language="javascript" type="text/javascript" src="../js/material/expenditure.js"></script>
  
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
	                {
	                    name: '上海sss',
	                    y: 21.30,
	                    sliced: true,
	                    selected: true
	                },
					['山东省',   1.0],
					['辽宁省',   13.1],
	                
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
      <td class="level2SelTab" nowrap="nowrap"><a href="expenditure.jsp">物料支出分析</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="sourcing.jsp">类别管理七步法</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
  <td style="padding-left:10px;padding-right:10px;" nowrap="nowrap">您现在的位置： 物料管理 &gt; 物料支出分析</td>
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
<div class="content_tab_title">
  <table class="small" border="0" width="100%" cellpadding="3" cellspacing="0"><tbody><tr>
    <td class="content_tab_title_cache">&nbsp;</td>
    <td id="tab1" class="content_tab_title_selected" align="center" onclick="showTab(1,3);">支出数据分析</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab2" class="content_tab_title_unselected" align="center" onclick="showTab(2,3);">类别支出结果输出</td>
    <td class="content_tab_title_cache" style="width:10px;">&nbsp;</td>
    <td id="tab3" class="content_tab_title_unselected" align="center" onclick="showTab(3,3);">类别支出报表输出</td>
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
  
  <div id="div3" class="content_tab_div_unselected">
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