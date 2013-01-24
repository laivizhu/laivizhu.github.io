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
									<form action="user_update.action" class="form-horizontal">
										<fieldset>
											 <div class="control-group">
											 	<label class="control-label">用户名:</label>
											 	<div class="controls">
											 		<input type="text" name="userName" class="input-xlarge focused" id="userNameFormFieldId">
											 	</div>
											 </div>
											 <div class="control-group">
											 	<label class="control-label">Email:</label>
											 	<div class="controls">
											 		<input type="text" name="email" class="input-xlarge" id="emailFormFieldId">
											 	</div>
											 </div>
											 <div class="control-group">
											 	<label class="control-label">生日:</label>
											 	<div class="controls">
											 		<input id="birthdayFormFieldId" type="text" name="birthday" class="input-xlarge focused">
											 	</div>
											 </div>
											 <!-- <div class="control-group">
											 	<label class="control-label">生日:</label>
											 	<div class="form-inline">
											 		<div class="input-append date" id="birthdayDateComId">
											 			<input type="text" name="birthday" class="input-xlarge focused" size=16>
											 			<span class="add-on"><i class="icon-th"></i></span>
											 		</div>
											 		  
											 	</div>
											 </div> -->
											 <div class="form-actions">
									            <button type="submit" class="btn btn-primary">保存</button>
									            <button class="btn">重置</button>
									          </div>
																				 
										</fieldset>
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
		     	
		      	
		      	
		    </div>
  		</div>
      <hr>
    </div>
    
    
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap-tab.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#birthdayFormFieldId").datepicker({
				formate:'yyyy-mm-dd'
			});
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
