<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 商城</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/docs.css"/>
    <link rel="stylesheet" type="text/css" href="../css/jbox_Green/jbox.css"/>
  </head>
  <body>
    <div class="container">
      <!-- Example row of columns -->
      <div class="row" id="commotityListDivId">
        
      </div>
    </div>
    
    
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var categoryId=laivi.getUrlVar("categoryId");
			laivi.scrollBreakPage('commodity_categoryList.action?categoryId='+categoryId, $("#commotityListDivId"), function(item){
				return "<div class='span3'><div class='thumbnail'><a href='commodity_overView.jsp?id="+item.id+"'><img src='../admin/shopping/picture/"+item.pictrue+"'/></a><div class='caption'><p> 数量:"+item.saveCount+"&nbsp;&nbsp;价格:"+item.price+"</p></div></div></div>";
			});
		});
	
	</script>
  </body>
</html>
