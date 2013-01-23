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
		    <div class="span3 bs-docs-sidebar">
		      <ul class="nav nav-list bs-docs-sidenav affix">
		      	<li><a href="#picture"><i class="icon-chevron-right"></i>个人信息</a></li>
		      	<li><a href="#all"><i class="icon-chevron-right"></i>博文记录</a></li>
		      	<li><a href="#"><i class="icon-chevron-right"></i>知识管理</a></li>
		      </ul>
		    </div>
		    <div class="span9">
		    	<!-- Main hero unit for a primary marketing message or call to action -->
		    	<section id="all">
			    	<div>
				        <ul class="nav nav-tabs" id="myTab">
						  <li class="active"><a href="#basic" data-toggle="tab">个人基本信息</a></li>
						  <li><a href="#favorite" data-toggle="tab">收藏</a></li>
						  <li><a href="#messages" data-toggle="tab">消息</a></li>
						</ul>
						<div class='tab-content'>
							<div class='tab-pane fade in active' id='basic'>
								<div class="span8">
									<form action="" class="form-signin">
										<table>
											<tr>
												<td>用户名:</td>
												<td><input type="text" name="userName" class="input-block-level"></td>
											</tr>
											<tr>
												<td>Email:</td>
												<td><input type="text" name="email" class="input-block-level"></td>
											</tr>
											<tr>
												<td>生日:</td>
												<td><input type="text" name="email" class="input-block-level"></td>
											</tr>
										</table>
									</form>
								</div>
							</div>
							<div class='tab-pane fade' id='favorite'>
								<div class="row" id="favoriteListDivId">
									
	      						</div>
							</div>
							<div class='tab-pane fade' id='messages'>
								<p>messages</p>
							</div>
						</div>
			      	</div>
		    	</section>
		     	<section id="picture">
		     		
		     	</section>
		      	
		      	
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
	<script type="text/javascript" src="../js/bootstrap/bootstrap-tab.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#myTab a').click(function (e) {
			  e.preventDefault();
			  $(this).tab('show');
			});
			laivi.scrollBreakPage('favorite_list.action', $("#favoriteListDivId"), function(item){
				if(item.type==1){
					return "<div class='span8'><a href='/knowledge/knowledge/knowledge_view.jsp?id="+item.favoriteId+"'><h2>"+item.title+"</h2></a></div>";
				}else if(item.type==2){
					return "<div class='span8'><a href='/knowledge/knowledge/article_view.jsp?id="+item.favoriteId+"'><h2>"+item.title+"</h2></a></div>";
				}else if(item.type==3){
					return "<div class='span8'><a href='/knowledge/shopping/commotity_view.jsp?id="+item.favoriteId+"'><h2>"+item.title+"</h2></a></div>";
				}
			});
		});
	
	</script>
  </body>
</html>
