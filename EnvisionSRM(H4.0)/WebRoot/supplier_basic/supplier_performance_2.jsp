<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script src="../js/highcharts.js"></script>
<script src="../js/exporting.js"></script>
<script type="text/javascript">
$(function () {
    var chart_DPPM;
	var chart_quality;
    $(document).ready(function() {
        chart_DPPM = new Highcharts.Chart({
            chart: {
                renderTo: 'container1',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: 'DPPM曲线表',
				
                x: -20 //center
            },
            /* subtitle: {
                text: '各节点为供应商竞价数额',
                x: -20
            }, */
            xAxis: {
                categories: ['1月份', '2月份', '3月份', '4月份', '5月份', '6月份',
                    '7月份', '8月份', '9月份', '10月份', '11月份', '12月份']
            },
            yAxis: {
               /*  title: {
                    text: 'price (元)'
                }, */
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
                name: 'DPPM',
                data: [1200, 1140, 1120, 1080, 1040, 1000, 1140, 1120, 1080, 1040, 1000]
            }]
        });
		
		chart_quality = new Highcharts.Chart({
            chart: {
                renderTo: 'container2',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '质量事件（严重&致命事件）次数',
                x: -20 //center
            },
           /*  subtitle: {
                text: '各节点为供应商竞价数额',
                x: -20
            }, */
            xAxis: {
                categories: ['6月份','7月份', '8月份', '9月份', '10月份', '11月份', '12月份']
            },
            yAxis: {
                title: {
                    text: 'time(次)'
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
                name: '质量事件',
                data: [1200, 1140, 1120, 1080, 1040, 1000, 1140]
            }]
        });
		
		
    });
});
</script>
<div id="div2" class="small" style="width:100%;position:relative;display:none">
  <form name="quanlityManagement" action="" >
    <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
      <tbody>
        <tr>
          <td colspan="9" class="detailedViewHeader"><strong>供应商日常质量管理</strong> </td>
        </tr>
        <tr height="30">
           <td width="10%" height="27" align="left" class="lvtCol">时间</td>
           <td width="10%" align="left" class="lvtCol">供应商</td>
           <td width="10%" align="left" class="lvtCol">部件</td>
           <td width="10%" align="left" class="lvtCol">缺陷分类</td>
           <td width="10%" align="left" class="lvtCol">发现地</td>
           <td width="10%" align="left" class="lvtCol">问题描述</td>
           <td width="10%" align="left" class="lvtCol">问题分类</td>
           <td width="20%" align="left" class="lvtCol">原因及改进措施</td>
           <td width="10%" align="left" class="lvtCol">状态</td>
        </tr>
        <tr height="25"  bgcolor="white" class="lvtColData">
           <td align="left" class="">5月</td>
           <td align="left" class="">隆玛</td>
           <td align="left" class="">安装板</td>
           <td align="left" class="">一般</td>
           <td align="left" class="">三铸机</td>
           <td align="left" class="">送货错误</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">供应商加强出货时检验</td>
           <td align="left" class="">进行中</td>
        </tr>
        <tr height="25"  bgcolor="white" class="lvtColData">
           <td align="left" class="">5月</td>
           <td align="left" class="">隆玛</td>
           <td align="left" class="">导轨</td>
           <td align="left" class="">一般</td>
           <td align="left" class="">三铸机</td>
           <td align="left" class="">尺寸错误</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">加强过程检验</td>
           <td align="left" class="">进行中</td>
        </tr>
        <tr>
          <td colspan="9" class="detailedViewHeader"><strong>DPPM</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="9" class="dvtCellInfo">
              <div id="container1" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
         <tr>
          <td colspan="9" class="detailedViewHeader"><strong>供应商质量事件</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="9" class="dvtCellInfo">
              <div id="container2" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
      </tbody>
    </table>
    
  </form>
</div>
