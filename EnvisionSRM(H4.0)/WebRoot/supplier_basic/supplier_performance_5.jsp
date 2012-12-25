<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script src="../js/highcharts.js"></script>
<script src="../js/exporting.js"></script>
<script type="text/javascript">
$(function () {
    var chart_claimant;
	var chart_claimantstatue;
    $(document).ready(function() {
        chart_claimant = new Highcharts.Chart({
            chart: {
                renderTo: 'container8',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '索赔事件',
                x: -20 //center
            },
            /* subtitle: {
                text: '各节点为供应商竞价数额',
                x: -20
            }, */
            xAxis: {
                categories: ['5月份', '6月份',
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
                        this.x +': '+ this.y +'';
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
                name: '索赔事件',
                data: [0.3, 0.1, 0.45, 0.25, 0.4, 0.8, 0.9, 0.7]
            }]
        });
		
		chart_claimantstatue = new Highcharts.Chart({
            chart: {
                renderTo: 'container9',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '索赔完成状态',
                x: -20 //center
            },
           /*  subtitle: {
                text: '各节点为供应商竞价数额',
                x: -20
            }, */
            xAxis: {
                categories: ['5月份','6月份','7月份', '8月份', '9月份', '10月份', '11月份', '12月份']
            },
            yAxis: {
               /*  title: {
                    text: ''
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
                        this.x +': '+ this.y +'';
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
                name: '新增索赔事件',
                data: [0, 0.25, 0.12, 0.2, 0.45, 0.85, 0.9, 0.75]
            },{
                name: '完成索赔事件',
                data: [0, 0.1, 0.4, 0.2, 0.45, 0.8, 0.95, 0.75]
            }]
        });
		
		
    });
});
</script>
<div id="div5" class="small" style="width:100%;position:relative;display:none">
  <form name="quanlityManagement" action="" >
    <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
      <tbody>
        <tr>
          <td colspan="8" class="detailedViewHeader"><strong>供应商索赔要求<strong>历史</strong>清单</strong> </td>
        </tr>
        <tr height="30">
           <td width="5%" height="27" align="left" class="lvtCol">序号</td>
           <td width="15%" align="left" class="lvtCol">索赔事件</td>
           <td width="10%" align="left" class="lvtCol">触发时间</td>
           <td width="10%" align="left" class="lvtCol">触发人</td>
           <td width="10%" align="left" class="lvtCol">索赔金额</td>
           <td width="10%" align="left" class="lvtCol">责任采购</td>
           <td width="10%" align="left" class="lvtCol">状态</td>
           <td width="20%" align="left" class="lvtCol">索赔金额明细</td>
        </tr>
        <tr height="25"  bgcolor="white" class="lvtColData">
           <td align="left" class="">1</td>
           <td align="left" class="">尺寸错误</td>
           <td align="left" class="">2012-11-01</td>
           <td align="left" class="">lily</td>
           <td align="left" class="">3000</td>
           <td align="left" class="">mark</td>
          <td align="left" class="">完成</td>
           <td align="left" class=""><a href="#">尺寸错误索赔事件.doc</a></td>
        </tr>
        <tr>
          <td colspan="8" class="detailedViewHeader"><strong>供应商索赔趋势图（当年）</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="8" class="dvtCellInfo">
              <div id="container8" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
         <tr>
          <td colspan="8" class="detailedViewHeader"><strong>供应商索赔历史汇总</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="8" class="dvtCellInfo">
              <div id="container9" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
      </tbody>
    </table>
    
  </form>
 
</div>
