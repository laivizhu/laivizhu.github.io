<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'table.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/common.css"/>
	<script language="javascript" type="text/javascript" src="js/jquery-1.8.2.js"></script>
	<script language="javascript" type="text/javascript" src="js/HouqianTable.js"></script>
	<script type="text/javascript">
		$(document).ready(
			function(){
				var table = new HouQianTable({
					url:"material/materialCategory_list.action",
					parentContainer:"#div1",
					columns:[
						{name:"categoryType",width:"52%"},
						{name:"类别名",width:"10%"},
						{name:"parent",width:"10%"},
						{name:"islock",width:"10%"}
						
					],
					commonOperations:[
						{name:"查看",url:"view.jsp",isAjax:false},
						{name:"编辑",url:"modify.jsp",isAjax:false},
						{name:"删除",url:"delete.jsp",isAjax:true}
					],
					specialOpertions:[
						{name:"具体操作",url:"setDefault.jsp",isAjax:true}
					],
					pageCount:2,
					isIDVisible:false,
					selectType:1
				});
			}
		);
	</script>
  </head>
  
  <body>
<div id="div1" class="small" style="width:100%;position:relative;">
</div>

</body>
</html>
