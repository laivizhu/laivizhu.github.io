<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.0.custom.css"/>

<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
<script language="javascript" type="text/javascript" src="../js/calc.js"></script>
<script type="text/javascript" src="../js/excanvas.js"></script>
<script type="text/javascript" src="../js/coolclock.js"></script>
<script type="text/javascript" src="../js/moreskins.js"></script>

<script language="javascript" type="text/javascript">
	
	$(document).ready(function(e) {
		
		
		$("#calc").dialog({
			autoOpen: false,
			title: "计算器",
			modal:false,
			width:250,
			height:250,
			position:[510,85],
			resizable:false
		});
		$("#showCalc").click(function()
		{
			$("#calc").dialog("open");
		});

		$("#calendar").dialog({
			autoOpen:false,
			title:"日历",
			modal:false,
			width:250,
			height:250,
			position:[250,85],
			resizable:false,		
		});
		$("#showCalendar").click(function(){
			var calendar = $("#calendar");
			calendar.datepicker();
			calendar.dialog("open");
		});
			
		$("#weather").dialog({
			autoOpen:false,
			modal:false,
			title:"天气预报",
			width:250,
			height:250,
			position:[510,340],
			resizable:false	
			
		});
		
		$("#showWeather").click(function(){
			var weather = $("#weather");
			weather.dialog("open");
		});
		
		$("#clock").dialog({
			autoOpen:false,
			title:"世界时钟",
			modal:false,
			width:250,
			height:250,
			position:[250,340],
			resizable:false	
		});
		
		$("#showClock").click(function(){
		
			$("#clock").dialog("open");
		});
		
		
		
		
		
    });
	
		
</script>

<table>
<tbody><tr>
  <td nowrap="nowrap">常用工具</td>  
  <td>
  <img id="showCalendar" width="27" height="27" src="../images/btnL3Calendar.gif" alt="日历" title="日历" border="0" style="cursor:pointer;"/>
  </td>
  <td>
  <img id="showClock" width="27" height="27" src="../images/btnL3Clock.gif" alt="时钟" title="时钟" border="0" style="cursor:pointer;"/>
  </td>
  <td>
  <img id="showCalc" width="27" height="27" src="../images/btnL3Calc.gif" alt="计算器" title="计算器" border="0" style="cursor:pointer;"/>
  </td>
   <td>
  <img id="showWeather" width="27" height="27" src="../images/weather_img3.png" alt="天气" title="天气" border="0" style="cursor:pointer;"/>
  </td>

  
</tr></tbody></table>

<div id="calendar" style="background-color:#F7F7F7;padding:10px 20px; margin:0px; display:none;">
</div>

<div id="calc" class="calc" style=" background-color:#F7F7F7; margin:0; padding-left:50px; padding-top:10px;">
<table width="160px" cellpadding="2" cellspacing="0" style=" border:1px solid #CCCCCC;"><tbody>
  <tr>
    <td colspan="10">
    <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
          <tbody><tr>
            <td width="10%"><input type="text" class="calcMem" name="mem" value="M" readonly="readonly"></td>
            <td width="90%" style="padding-right:2px;" ><input type="text" class="calcResult" name="answer" maxlength="30" onchange="CheckNumber(this.value)" readonly="readonly"></td>
          </tr></tbody></table>
  </td>
  </tr>
    <tr>
        <td colspan="3">&nbsp;</td>
        <td width="25"> <input type="button" name="CE" class="calcCancBtn" value="CE" onclick="CECalc(); return false;">
        </td>
        <td width="25"> <input type="reset" name="C" class="calcCancBtn" value="C" onclick="ClearCalc(); return false;">
        </td>
      </tr>
    <tr>
        <td width="25"> <input type="button" name="backspace" class="calcBackBtn" value="" onclick="Backspace(document.calculator.answer.value); return false;"></td>
        <td width="25"> <input type="button" name="recip" class="calcBlackBtn" value="1/x" onclick="RecipButton(); return false;"></td>
        <td width="25"> <input type="button" name="sqrt" class="calcBlackBtn" value="sqrt" onclick="SqrtButton(); return false;"></td>
        <td width="25"> <input type="button" name="negate" class="calcBlackBtn" value="+/-" onclick="NegateButton(); return false;"></td>
        <td width="25"> <input type="button" name="percent" class="calcBlackBtn" value="%" onclick="PercentButton(); return false;"></td>
      </tr>
    <tr>
        <td width="25"> <input type="button" name="MC" class="calcMemBtn" value="MC" onclick="MemoryClear(); return false;"></td>
        <td width="25"> <input type="button" name="calc7" class="calcGreyBtn" value="7" onclick="CheckNumber('7'); return false;"></td>
        <td width="25"> <input type="button" name="calc8" class="calcGreyBtn" value="8" onclick="CheckNumber('8'); return false;"></td>
        <td width="25"> <input type="button" name="calc9" class="calcGreyBtn" value="9" onclick="CheckNumber('9'); return false;"></td>
        <td width="25"> <input type="button" name="divide" class="calcBlackBtn" value="/" onclick="DivButton(1); return false;"></td>
      </tr>
    <tr>
        <td width="25"> <input type="button" name="MR" class="calcMemBtn" value="MR" onclick="MemoryRecall(Memory); return false;"></td>
        <td width="25"> <input type="button" name="calc4" class="calcGreyBtn" value="4" onclick="CheckNumber('4'); return false;"></td>
        <td width="25"> <input type="button" name="calc5" class="calcGreyBtn" value="5" onclick="CheckNumber('5'); return false;"></td>
        <td width="25"> <input type="button" name="calc6" class="calcGreyBtn" value="6" onclick="CheckNumber('6'); return false;"></td>
        <td width="25"> <input type="button" name="multiply" class="calcBlackBtn" value="x" onclick="MultButton(1); return false;"></td>
      </tr>
    <tr>
        <td width="25"> <input type="button" name="MS" class="calcMemBtn" value="M-" onclick="MemorySubtract(document.calculator.answer.value); return false;"></td>
        <td width="25"> <input type="button" name="calc1" class="calcGreyBtn" value="1" onclick="CheckNumber('1'); return false;"></td>
        <td width="25"> <input type="button" name="calc2" class="calcGreyBtn" value="2" onclick="CheckNumber('2'); return false;"></td>
        <td width="25"> <input type="button" name="calc3" class="calcGreyBtn" value="3" onclick="CheckNumber('3'); return false;"></td>
        <td width="25"> <input type="button" name="minus" class="calcBlackBtn" value="-" onclick="SubButton(1); return false;"></td>
      </tr>
    <tr>
        <td width="25"> <input type="button" name="Mplus" class="calcMemBtn" value="M+" onclick="MemoryAdd(document.calculator.answer.value); return false;"></td>
        <td width="25"> <input type="button" name="calc0" class="calcGreyBtn" value="0" onclick="CheckNumber('0'); return false;"></td>
        <td width="25"> <input type="button" name="dot" class="calcGreyBtn" value="." onclick="CheckNumber('.'); return false;"></td>
        <td width="25"> <input type="button" name="equal" class="calcBlackBtn" value="=" onclick="EqualButton(0); return false;"></td>
        <td width="25"> <input type="button" name="plus" class="calcBlackBtn" value="+" onclick="AddButton(1); return false;"></td>
      </tr>
</tbody></table>

</div>

<div id="clock" style="display:none; background-color:#F7F7F7; padding:0; margin:0;">
<table width="100%" align="center" border="0" cellpadding="4" cellspacing="0">
  <tr><td width="100%" align="center" valign="middle">
  <!--
  选择时区：
	<select id="chooseTimezone" style="width:100px;">
    	<option value="+8">北京</option>
        <option value="+2">丹麦</option>
        <option value="+2">日本</option>
        <option value="+2">纽约</option>
        <option value="+2">芬兰</option>
    </select>
    <!-->
  </td></tr>
  <tr><td width="100%" align="center" valign="middle">
    <canvas id="timezone" class="CoolClock:swissRail:80::+8"></canvas>
  </td></tr>
  <tr><td width="100%" align="center" valign="middle">
    <span id="showCity">北京</span>时间
  </td></tr>
</table>    
</div>

<div id="weather" style="background-color:#F7F7F7;display:none; padding:15px 0;">
<table width="100%" align="center" cellpadding="0" cellspacing="0"><tr><td height="200" align="center" valign="middle">
<!-- <iframe src="http://m.weather.com.cn/m/pn12/weather.htm?id=101020100T" width="220" height="150" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe> -->
</td></tr></table>
</div>






