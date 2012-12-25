<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/content.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
  <script language="javascript" type="text/javascript" src="../js/general.js"></script>
  <script language="javascript" type="text/javascript" src="../js/calc.js"></script>
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
  <form name="contractApproval" action="" >
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr>
            <td colspan="4" class="detailedViewHeader"><b>选择供应商</b></td>
        </tr>
        <tr style="height:25px">
            <td colspan="2" class="dvtCellLabel" align="right"> 供应商选择</td>
            <td width="80%" colspan="2" align="left" class="dvtCellInfo"><input type="text" id="supplierNameInputId2" name="supplierNameInputId" class="detailedViewTextBox" style="width:18%;" value="供应商1" />
浏览供应商: <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer"/> <img src="../images/clear.gif" alt="清除" title="清除"   onclick="document.EditView.lastname2.value=''; document.EditView.lastname2.value='';"  align="absmiddle" style="cursor:hand;cursor:pointer" /></td>
        </tr> 
      </tbody>
    </table>
    
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
        <tr>
            <td colspan="4" class="detailedViewHeader"><b>时间范围</b></td>
        </tr>
      <tbody>  
        <tr style="height:25px">
            <td width="20%" class="dvtCellLabel" align="right"> 起始时间</td>
            <td width="30%" align="left" class="dvtCellInfo">
            <input type="text" name="lastname" tabindex="" class="detailedViewTextBox" style="width:50%;" value="" />            </td>
            <td width="20%" class="dvtCellLabel" align="right">结束时间</td>
            <td width="30%" align="left" class="dvtCellInfo">
            <input type="text" name="lastname" tabindex="" class="detailedViewTextBox" style="width:50%;" value="" />            </td>
        </tr>
      </tbody>
    </table>
    
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
      <tbody>  
        <tr>
          <td colspan="9" class="detailedViewHeader" align="center"><strong>DPPM 报告输出</strong> </td>
        </tr>
        <tr class="lvtColData">
           <td colspan="9" class="dvtCellInfo">
              <div id="container1" style="width:85%; height: 300px; margin: 0 auto"></div>
           </td>
        </tr>
         <tr>
          <td colspan="9" class="detailedViewHeader" align="center"><strong>供应商质量事件</strong> </td>
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
