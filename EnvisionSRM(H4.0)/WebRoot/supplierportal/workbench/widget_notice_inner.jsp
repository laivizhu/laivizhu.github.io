<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/widget.css"/>
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>

<div id="widget_notice_inner" class="widgetMainFrame">

<!-- Widget Handle -->
<table width="100%" cellpadding="0" cellspacing="0" class="widgetHandle">
  <tbody><tr>
	<td width="70%" nowrap="nowarp" class="widgetHandleTitle">内部公告</td>
	<td align="right" width="30%" nowrap="nowrap">
		<img src="../images/windowRefresh.gif" border="0" alt="刷新" title="刷新" hspace="1" align="absmiddle" style="cursor:pointer;">
        <img src="../images/windowMinMax.gif" border="0" alt="最大化" title="最大化" hspace="1" align="absmiddle" style="cursor:pointer;" onclick="maxWidget('widget_notice_inner');">
        <img src="../images/windowClose.gif" border="0" alt="关闭" title="关闭" hspace="1" align="absmiddle" style="cursor:pointer;" onclick="delWidget('widget_notice_inner');">
	</td>
  </tr></tbody>
</table>
	

<table width="100%" cellpadding="0" cellspacing="0" class="widgetContent small"><tbody>
  <tr>
    <td class="widget_content_title">公告标题</td>
	<td class="widget_content_title" width="60px">发布时间</td>
  </tr>
  <div id="content">
  <tr>
    <td class="widgetContentDetail"><a href="#" title="关于中秋节放假通知的最新信息">关于中秋放假</a></td>
    <td class="widgetContentDetail">09-20 </td>
  </tr>
  <tr>
    <td  class="widgetContentDetail"> <a href="#" title="发票填写的最新规范">发票填写的规定</a></td>
    <td  class="widgetContentDetail">09-30</td>
  </tr>
  <tr>
    <td class="widgetContentDetail"><a href="#" title="关于中秋节放假通知的最新信息">关于中秋放假</a></td>
    <td class="widgetContentDetail"> 09-30</td>
  </tr>
  <tr>
    <td  class="widgetContentDetail"> <a href="#" title="发票填写的最新规范">发票填写的规定</a></td>
    <td  class="widgetContentDetail">09-30 </td>
  </tr>
  <tr>
    <td class="widgetContentDetail"><a href="#" title="关于中秋节放假通知的最新信息">关于中秋放假</a></td>
    <td class="widgetContentDetail"> 09-30</td>
  </tr>
  <tr>
    <td  class="widgetContentDetail"> <a href="#" title="发票填写的最新规范">发票填写的规定</a></td>
    <td  class="widgetContentDetail">09-30 </td>
  </tr>
  <tr>
    <td class="widgetContentDetail"><a href="#" title="关于中秋节放假通知的最新信息">关于中秋放假</a></td>
    <td class="widgetContentDetail"> 09-30</td>
  </tr>
  <tr>
    <td  class="widgetContentDetail"> <a href="#" title="发票填写的最新规范">发票填写的规定</a></td>
    <td  class="widgetContentDetail">09-30 </td>
  </tr>
  </div>
</table>

<table width="100%" class="small">
<tbody><tr>
  <td align="right" valign="top" class="widgetBottom">
  <a href="../infocenter/noticeInnerList.action" target="_self">更多  </a>
  </td>
</tr></tbody>
</table>
</div>

<script type="text/javascript" language="javascript">
	$(document).ready(function(e) {
		//
		$("#widget_notice_inner_max").dialog({
			title:"内部公告",
			autoOpen:false,
			modal:true,
			width:600,
			height:395,
			resizable:false
		});
        
    });
</script>
<div id="widget_notice_inner_max" class="widget_frame_max small">
<p></p>
<table width="98%" align="center" border="0" cellspacing="1" cellpadding="3"  class="lvt small">
  <tbody>
    <tr>
	  <td width="15%" align="left" class="lvtCol">公告ID</td>
      <td width="55%" align="left" class="lvtCol">公告标题</td>
      <td width="15%" align="left" class="lvtCol">发布人</td>
      <td width="15%" align="left" class="lvtCol">发布时间</td>
    </tr>
    
  
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100001</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则</a></td>
      <td align="left" >admin</td>
      <td align="left" >2012-12-09</td>
    </tr>
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100002</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则2</a></td>
      <td align="left" >张三</td>
      <td align="left" >2012-12-09</td>
    </tr>
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100003</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则3</a></td>
      <td align="left" >李四</td>
      <td align="left" >2012-12-09</td>
    </tr>
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100004</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则4</a></td>
      <td align="left" >admin</td>
      <td align="left" >2012-12-09</td>
    </tr>
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100005</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则5</a></td>
      <td align="left" >admin</td>
      <td align="left" >2012-12-09</td>
    </tr>
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100006</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则6</a></td>
      <td align="left" >admin</td>
      <td align="left" >2012-12-09</td>
    </tr>
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100007</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则7</a></td>
      <td align="left" >admin</td>
      <td align="left" >2012-12-09</td>
    </tr>
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100008</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则8</a></td>
      <td align="left" >admin</td>
      <td align="left" >2012-12-09</td>
    </tr>
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100009</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则9</a></td>
      <td align="left" >admin</td>
      <td align="left" >2012-12-09</td>
    </tr>
    <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
      <td height="19" align="left">100010</td>
      <td align="left" ><a href="#">关于远景能源最新人事任命细则10</a></td>
      <td align="left" >admin</td>
      <td align="left" >2012-12-09</td>
    </tr>
  
</tbody></table>
<br />
<table width="98%" align="center" border="0" cellspacing="0" cellpadding="2" class="small"><tr>
	<td width="20%" height="20" nowrap="nowrap">每页显示 10 条记录</td>
	<td width="60%" align="center" nowrap="nowrap">
    共 2 页，
    <a href="#" style="text-decoration:none;"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a>
    &nbsp;当前第&nbsp;1&nbsp;页&nbsp;
    <a href="#" style="text-decoration:none;"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a>
	</td>
    <td width="20%" align="right"><a href="../infocenter/noticeInnerList.action" target="_self">更多  </a></td>	
</tr></table>  


</div>










