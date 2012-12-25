<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script src="../js/highcharts.js"></script>
<script src="../js/exporting.js"></script>
<script type="text/javascript">
$(function () {
    var chart_assurance;
	var chart_history;
    $(document).ready(function() {
        chart_assurance = new Highcharts.Chart({
            chart: {
                renderTo: 'container6',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '质保事件',
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
                name: '质保事件',
                data: [0, 0.1, 0.4, 0.2, 0.4, 0.8, 0.9, 0.7]
            }]
        });
		
		chart_history = new Highcharts.Chart({
            chart: {
                renderTo: 'container7',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            title: {
                text: '质保完成状态',
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
                name: '新增质保事件',
                data: [0, 0.2, 0.2, 0.2, 0.4, 0.85, 0.9, 0.75]
            },{
                name: '完成质保事件',
                data: [0, 0.1, 0.4, 0.2, 0.45, 0.8, 0.95, 0.7]
            }]
        });
		
		
    });
});
</script>
<div id="div4" class="small" style="width:100%;position:relative;display:none">
  <form name="quanlityManagement" action="" >
    <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
      <tbody>
        <tr>
          <td colspan="20" class="detailedViewHeader"><strong>供应商质保需求清单</strong> </td>
        </tr>
        <tr height="30">
           <td width="5%" align="left" class="lvtCol">编码号</td>
           <td width="5%" align="left" class="lvtCol">质保<br />单号</td>
           <td width="5%" align="left" class="lvtCol">移库凭<br />证号</td>
           <td width="5%" align="left" class="lvtCol">风场返<br />回日期</td>
           <td width="5%" align="left" class="lvtCol">来源</td>
           <td width="5%" align="left" class="lvtCol">联系人</td>
           <td width="5%" align="left" class="lvtCol">物料号</td>
           <td width="5%" align="left" class="lvtCol">名称</td>
           <td width="5%" align="left" class="lvtCol">规格</td>
           <td width="5%" align="left" class="lvtCol">图号</td>
           <td width="5%" align="left" class="lvtCol">序列号</td>
           <td width="5%" align="left" class="lvtCol">变频器<br />序列号</td>
           <td width="5%" align="left" class="lvtCol">数量</td>
           <td width="5%" align="left" class="lvtCol">供应商</td>
           <td width="5%" align="left" class="lvtCol">KWE收货<br />日期</td>
           <td width="5%" align="left" class="lvtCol">是否可<br />寄出</td>
           <td width="5%" align="left" class="lvtCol">KWE发出<br />日期</td>
           <td width="5%" align="left" class="lvtCol">是否可<br />质保</td>
           <td width="5%" align="left" class="lvtCol">质保结果</td>
           <td width="5%" align="left" class="lvtCol">供应商<br />返回日期</td>
        </tr>
        <tr height="25"  bgcolor="white" class="lvtColData">
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
        </tr>
        <tr height="25"  bgcolor="white" class="lvtColData">
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
           <td align="left" class="">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="20" class="detailedViewHeader"><strong>质保趋势图</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="20" class="dvtCellInfo">
              <div id="container6" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
         <tr>
          <td colspan="20" class="detailedViewHeader"><strong>供应商质保历史汇总</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="20" class="dvtCellInfo">
              <div id="container7" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
      </tbody>
    </table>   
  </form>

</div>
