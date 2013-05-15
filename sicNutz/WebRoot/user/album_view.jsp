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
		    <div class="span12">
		    	<!-- Main hero unit for a primary marketing message or call to action -->
		    	<div style="position: fixed; float: right;width:100px;height:60px; right:5px;" >
		    		<ul class="nav nav-pills">
						      <li>
						      	<button class="btn" id="uploadPictureButtonId"><i class='icon-upload'></i>上传照片</button>
						      </li>
					    </ul>
				</div>
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
    
    
    <script type="text/javascript" src="../js/jquery/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="../js/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript">
		$(document).ready(sic.basic.init(function(){
			var albumId=sic.basic.getUrlVar('id');
			$("#uploadPictureButtonId").click(function(){
				window.location.href='picture_add.jsp?id='+albumId;
			});
			sic.pageLoding.scrollBreakPage('../media/picture/pictureList.nut?albumId='+albumId, $("#pictureListDivId"), function(item){
				return "<div class='span3'><div class='thumbnail'><a href='../upload/picture/"+item.path+"' target='blank'><img src='../upload/picture/"+item.path+"'/></a><div class='caption'><p>"+item.description+"</p></div></div></div>";
			});
		}));
	
	</script>
  </body>
</html>
