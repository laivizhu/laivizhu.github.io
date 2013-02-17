<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 感悟生活</title>
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
						        <a href="user_addArticle.jsp" class="btn">发表博文</a>
						      </li>
					    </ul>
				</div>

		     	<section id="article">
		     		<!-- Example row of columns -->
			     	<div class="row" id="articleListDivId">
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
	<script type="text/javascript" src="../js/common/navigate.js"></script>
	<script type="text/javascript">
		var getMoreData=function(id){
			laivi.getJson('article_get.action?font=true&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getLessData("+result.data.id+")'>Fold &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		var getLessData=function(id){
			laivi.getJson('article_get.action?fold=true&font=true&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getMoreData("+result.data.id+")'>More &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		$(document).ready(laivi.init(function(){
			loadLocalNavigate(navigate.user);
			laivi.scrollBreakPage('article_list.action', $("#articleListDivId"), function(item){
				return "<div class='span8'><a href='../knowledge/article_view.jsp?id="+item.id+"'><h4>"+item.title+"</h4></a><p id='content"+item.id+"'>"+item.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.id+")'>More &raquo;</a></p><div align='right'><p>"+item.createDate+"|"+item.user+"<a class='btn' onclick=deleteObject('article_delete.action?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a>|<a class='btn' href='user_addArticle.jsp?id="+item.id+"'><i class='icon-edit'></i>编辑</a></p></div></div>";
			});
		}));
	
	</script>
  </body>
</html>