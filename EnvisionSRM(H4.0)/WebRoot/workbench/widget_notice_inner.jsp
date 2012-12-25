<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/widget.css"/>
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
<script language="javascript" type="text/javascript" src="../js/HouqianTable.js"></script>

<script language="javascript" type="text/javascript">
	$(document).ready(function(e) {
		
		$("#widget_notice_inner_max").dialog({
			title:"内部公告",
			autoOpen:false,
			modal:true,
			width:600,
			height:420,
			resizable:false
		});
		
		//刷新
		refreshWidget();
		
		//---
		var table = new HouQianTable({
		url:"../infocenter/noticeInner_list.action",
		parentContainer:"#widget_notice_inner_max_list",
		columns:[
			{name:"公告标题",width:"40%",bindingProperty:"title",callback:function(data){
				window.location.href = "../infocenter/notice_inner_view.jsp?id="+data.id;
			}},
			{name:"公告类型",width:"15%",bindingProperty:"type"},
			{name:"发布人",width:"15%",bindingProperty:"author"},
			{name:"创建时间",width:"15%",bindingProperty:"createTime"},
			{name:"修改时间",width:"15%",bindingProperty:"modifyTime"},		
		],
		pageCount:10,
		selectType:0
	});
        
    });
	
	function refreshWidget(){
	
		$.getJSON("../infocenter/noticeInner_list.action",{start:0,limit:8,time:Math.random()},function(returnData){
			var content = $("#widget_notice_inner").find("tbody[name='content']");;
			content.html("");
			$.each(returnData.root,function(i,item){
				var a1 = $("<a>");
				a1.html(item.title);
				a1.herf("../infocenter/notice_inner_view.jsp?id="+item.id);
				var td1 = $("<td>");
				td1.addClass("widgetContentDetail");
				td1.append(a1);
				var td2 = $("<td>");
				td2.addClass("widgetContentDetail");
				td2.html(item.createTime.substring(5,9));
				var tr = $("<tr>");
				tr.append(td1);
				tr.append(td2);
				//alert(tr.html());
				content.append(tr);
				
			});
		
		});
	
	}



</script>

<div id="widget_notice_inner" class="widgetMainFrame">

<!-- Widget Handle -->
<table width="100%" cellpadding="0" cellspacing="0" class="widgetHandle">
  <tbody><tr>
	<td width="70%" nowrap="nowarp" class="widgetHandleTitle">内部公告</td>
	<td align="right" width="30%" nowrap="nowrap">
		<img src="../images/windowRefresh.gif" border="0" alt="刷新" title="刷新" hspace="1" align="absmiddle" style="cursor:pointer;" onclick="refreshWidget();">
        <img src="../images/windowMinMax.gif" border="0" alt="最大化" title="最大化" hspace="1" align="absmiddle" style="cursor:pointer;" onclick="maxWidget('widget_notice_inner');">
        <img src="../images/windowClose.gif" border="0" alt="关闭" title="关闭" hspace="1" align="absmiddle" style="cursor:pointer;" onclick="delWidget('widget_notice_inner');">
	</td>
  </tr></tbody>
</table>
	
<div class="widgetContent small">
<table width="100%" cellpadding="0" cellspacing="0"><tbody>
  <tr>
    <td class="widget_content_title">公告标题</td>
	<td class="widget_content_title" width="60px">发布时间</td>
  </tr>
  </tbody>
  <tbody name="content">
 
  </tbody>
</table>
</div>
<table width="100%" class="small">
<tbody><tr>
  <td align="right" valign="top" class="widgetBottom">
  <a href="../infocenter/notice_inner_list.jsp" target="_self">更多  </a>
  </td>
</tr></tbody>
</table>
</div>


<div id="widget_notice_inner_max" class="widget_frame_max small" style="display:none;">
<br />
<div id="widget_notice_inner_max_list">
	
</div>

</div>










