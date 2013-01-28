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
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
  </head>
  <body>
  	<jsp:include page="../common/navigate.jsp"/>
  	<div class="container">
		<div class="row">
			<jsp:include page="../common/navigate_left.jsp"/>
		    
		    <div class="row span8" id="shoppingItemListDivId">
        
      		</div>
		</div>
		
		<hr>
		<footer>
			  <p class="pull-right"><a href="#">Back to top</a></p>
		 <div align="center">
		 	<p>&copy; Laivi 2013-2014</p>
		 	<p><a href="mailto:laivi.zhu@gmail.com">联系我们:laivi.zhu@gmail.com</a></p>
		 </div>
		</footer>
	</div>

    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript" src="../js/common/navigate.js"></script>
	<script type="text/javascript">
		$(document).ready(laivi.init(function(){
			loadRemoteNavigate('category_list.action?category.level=1','shopping_commotity.jsp?categoryId=');
			laivi.getJson('order_itemList.action', function(result){
				if(result.totalProperty>0){
					$.each(result.root,function(i,item){
						$('#shoppingItemListDivId').append("<div class='span12'><p>"+item.name+"</p></div>");
					});
				}else{
					$('#shoppingItemListDivId').append("<div class='span12'><h2>还没有什么商品加入购物车</h2></div>");
				}
			});
		}));
	</script>
  </body>
</html>
