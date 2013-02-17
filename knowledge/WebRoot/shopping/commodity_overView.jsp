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
		    <div class="row span8">
				<div style="position: fixed; float: right;width:100px;height:60px; right:10px;" >
		    		<ul class="nav nav-pills">
				      <li>
				        <a href="shopping_shoppingCart.jsp" class="btn">查看购物车</a>
				      </li>
					</ul>
				</div>
		      	<div class="span3" id="imageDivId">
		      			
		      	</div>
			    <div class="span3" id="otherDivId">
			      		
			    </div>
		
		      	<div class="span8" id="descriptionDivId">
		      		
		      	</div>
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
		var addShoppingCart=function(commodityId){
			laivi.confirm('确认要加入购物车吗?', function(){
				laivi.getJson('order_addShoppingItem?commodityId='+commodityId, function(){
					laivi.alert('添加成功');
				});
			});
		};
		$(document).ready(laivi.init(function(){
			loadRemoteNavigate('category_list.action?category.level=Root','shopping_commotity.jsp?categoryId=');
			
			var id=laivi.getUrlVar("id");
			laivi.getJson('commodity_get.action?font=true&id='+id, function(result){
				var item=result.data;
				$("#imageDivId").append("<img src='../admin/shopping/picture/"+item.pictrue+"'/></a>");
				$("#otherDivId").append("<p>"+item.name+"</p><p> 数量:"+item.saveCount+"&nbsp;&nbsp;价格:"+item.price+"</p><p><button class='btn' onclick='addShoppingCart("+item.id+")'><i class='icon-shopping-cart'></i>加入购物车</button></p>");
				$("#descriptionDivId").append("<h2>商品描述</h2><p>"+item.description+"</p>");
			});
		}));
		
		
	</script>
  </body>
</html>
