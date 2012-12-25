<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script src="../js/highcharts.js"></script>
<script src="../js/exporting.js"></script>
<script type="text/javascript">
$(function () {
    var chart_track;
	var chart_arrival;
	var chart_accuracy;
    $(document).ready(function() {
        chart_track = new Highcharts.Chart({
            chart: {
                renderTo: 'container3',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '生产和计划数据分析',
                x: -20 //center
            },
            /* subtitle: {
                text: '各节点为供应商竞价数额',
                x: -20
            }, */
            xAxis: {
                categories: ['7-23', '7-25', '7-27', '7-29', '8-02', '8-04',
                    '8-06', '8-08', '8-10', '8-12', '8-14', '8-16']
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
                name: '生产和计划',
                data: [1100, 1240, 1120, 1080, 1040, 1000, 1140, 1120, 1080, 1040, 1000]
            }]
        });
		
		chart_arrival = new Highcharts.Chart({
            chart: {
                renderTo: 'container4',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '生产零件到货率',
                x: -20 //center
            },
            subtitle: {
                text: '统计数据为供应商各物料第周的到货率',
                x: -20
            },
            xAxis: {
                categories: ['2012-28周','2012-29周']
            },
            yAxis: {
                 title: {
                    text: '百分比(%)'
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
                        this.x +': '+ this.y +'%';
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
                name: '生产零件到货率',
                data: [90, 100]
            }]
        });
		
		chart_accuracy=new Highcharts.Chart({
            chart: {
                renderTo: 'container5',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '日常交付准确率',
                x: -20 //center
            },
           
            xAxis: {
                categories: ['8月份','9月份','10月份','11月份','12月份']
            },
            yAxis: {
                 title: {
                    text: '百分比(%)'
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
                        this.x +': '+ this.y +'%';
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
                name: '日常交付准确率',
                data: [90, 100, 89, 95, 98]
            }]
        });
		
    });
});
</script>
<div id="div3" class="small" style="width:100%;position:relative;display:none">
  <form name="quanlityManagement" action="" >
    <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
      <tbody>
        <tr>
          <td colspan="10" class="detailedViewHeader"><strong>计划行的接受状态</strong> </td>
        </tr>
        <tr height="30">
           <td width="5%" height="27" align="left" class="lvtCol">序号</td>
           <td width="10%" align="left" class="lvtCol">到货日期</td>
           <td width="10%" align="left" class="lvtCol">建议发货</td>
           <td width="15%" align="left" class="lvtCol">供应商编号</td>
           <td width="25%" align="left" class="lvtCol">品名</td>
           <td width="5%" align="left" class="lvtCol">数量</td>
           <td width="5%" align="left" class="lvtCol">已到</td>
           <td width="10%" align="left" class="lvtCol">单位</td>
           <td width="10%" align="left" class="lvtCol">确认供货</td>
           <td width="5%" align="left" class="lvtCol">是否接受</td>
        </tr>
        <tr height="25"  bgcolor="white" class="lvtColData">
           <td align="left" class="">1</td>
           <td align="left" class="">2012-07-25</td>
           <td align="left" class="">2012-07-24</td>
           <td align="left" class="">V1059</td>
           <td align="left" class="">底座部件(前后)</td>
           <td align="left" class="">5</td>
           <td align="left" class="">1</td>
           <td align="left" class="">TAO</td>
           <td align="left" class="">无需操作</td>
           <td align="left" class="">接受</td>
        </tr>
        <tr height="25"  bgcolor="white" class="lvtColData">
           <td align="left" class="">2</td>
           <td align="left" class="">2012-07-25</td>
           <td align="left" class="">2012-07-24</td>
           <td align="left" class="">V1059</td>
           <td align="left" class="">底座侧面护板</td>
           <td align="left" class="">14</td>
           <td align="left" class="">2</td>
           <td align="left" class="">EA</td>
           <td align="left" class="">无需操作</td>
           <td align="left" class="">接受</td>
        </tr>
        <tr>
          <td colspan="10" class="detailedViewHeader"><strong>生产跟踪</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="10" class="dvtCellInfo">
              <div id="container3" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
         <tr>
          <td colspan="10" class="detailedViewHeader"><strong>供应商物料日常交付及时率</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="10" class="dvtCellInfo">
              <div id="container4" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
         <tr>
          <td colspan="10" class="detailedViewHeader"><strong>供应商物料日常交付准确率</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="10" class="dvtCellInfo">
              <div id="container5" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
      </tbody>
    </table>
    
  </form>
</div>
