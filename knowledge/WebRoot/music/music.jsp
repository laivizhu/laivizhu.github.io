<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <title>Laivi 回忆园地</title>
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
  <body data-spy="scroll" data-target=".bs-docs-sidebar">
  <jsp:include page="../common/navigate.jsp"/>
    
    <div class="container">
		<div class="row">
		    <div class="span3 bs-docs-sidebar">
		      <ul class="nav nav-list bs-docs-sidenav affix">
		      	<li><a href="#picture"><i class="icon-chevron-right"></i>全部</a>
		      		<ul class="nav nav-list">
		      			<li><a href="#">nav</a></li>
		      			<li><a href="#">nav</a></li>
		      		</ul>
		      	</li>
		      	<li><a href="#all"><i class="icon-chevron-right"></i>全部</a></li>
		      	<li><a href="#"><i class="icon-chevron-right"></i>全部</a></li>
		      </ul>
		    </div>
		    <div class="span9">
		    	<!-- Main hero unit for a primary marketing message or call to action -->
		    	<section id="all">
			    	<div class="hero-unit">
				        <h1>Hello, world!</h1>
				        <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
				        <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
			      	</div>
		    	</section>
		     	<section id="picture">
		     		<!-- Example row of columns -->
			     	<div class="row" id="pictureListDivId">
	      			</div>
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
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			laivi.scrollBreakPage('picture_list.action', $("#pictureListDivId"), function(item){
				return "<div class='span3'><div class='thumbnail'><a href='"+item.path+"' target='blank'><img src='"+item.path+"'/></a><div class='caption'><p>"+item.description+"</p></div></div></div>";
			});
		});
	
	</script>
  </body>
</html>
