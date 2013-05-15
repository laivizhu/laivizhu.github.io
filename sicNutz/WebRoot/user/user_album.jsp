<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 记忆时光</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/docs.css"/>
    <link rel="stylesheet" type="text/css" href="../css/jbox_Green/jbox.css"/>
  </head>
  <body>
    <jsp:include page="../common/navigate.jsp"/>
    <div class="container">
		<div class="row">
			<jsp:include page="../common/navigate_left.jsp"/>
		    <div class="span9">
		    	<!-- Main hero unit for a primary marketing message or call to action -->
		    	<div style="position: fixed; float: right;width:100px;height:60px; right:10px;" >
		    		<ul class="nav nav-pills">
						      <li>
						        <a href="album_add.jsp" class="btn"><i class='icon-camera'></i>创建相册</a>
						      </li>
					    </ul>
				</div>

		     	<section id="album">
		     		<!-- Example row of columns -->
			     	<div class="row" id="albumListDivId">
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
	<script type="text/javascript" src="../js/common/navigate.js"></script>
	<script type="text/javascript">
		$(document).ready(sic.basic.init(function(){
			loadLocalNavigate(navigate.user);
			sic.pageLoding.scrollBreakPage('../media/album/albumList.nut?album.type=PICTURE', $("#albumListDivId"), function(item){
				return "<div class='span4'><div class='thumbnail'><a href='album_view.jsp?id="+item.id+"'><img src='../images/default/album.jpg'></a><div class='caption'><p>"+item.name+"</p><p>"+item.description+"</p><p><a class='btn' href='#' onclick=deleteObject('album_delete.action?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a>&nbsp;<a class='btn' href='album_add.jsp?id="+item.id+"'><i class='icon-edit'></i>编辑</a></p></div></div></div>";
			});
		}));
	
	</script>
  </body>
</html>