<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 商城</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/datepicker.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/docs.css"/>
    <link rel="stylesheet" type="text/css" href="../css/jbox_Green/jbox.css"/>
  </head>
  <body>
    <div class="container">
		<div class="row">
		    <div class="span3 bs-docs-sidebar">
		      <ul class="nav nav-list bs-docs-sidenav affix" id="categoryListULId">
		      	
		      </ul>
		    </div>
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
			laivi.getJson('category_list.action?category.level=1', function(result){
				$.each(result.root,function(i,item){
					$("#categoryListULId").append("<li><a href='shopping_commotity.jsp?categoryId="+item.id+"' target='main'><i class='icon-chevron-right'></i>"+item.name+"</a></li>");
				});
			});
		});
	
	</script>
  </body>
</html>
