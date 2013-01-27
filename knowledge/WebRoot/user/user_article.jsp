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
    
    <div class="container">
		<div class="row">
		    <div class="span10">
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
    </div>
    
    
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript">
		var getMoreData=function(id){
			laivi.getJson('article_get.action?type=1&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getLessData("+result.data.id+")'>Fold &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		var getLessData=function(id){
			laivi.getJson('article_get.action?fold=true&type=1&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getMoreData("+result.data.id+")'>More &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		$(document).ready(function(){
			laivi.scrollBreakPage('article_list.action', $("#articleListDivId"), function(item){
				return "<div class='span10'><a href='user_viewArticle.jsp?id="+item.id+"'><h4>"+item.title+"</h4></a><p id='content"+item.id+"'>"+item.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.id+")'>More &raquo;</a></p><div align='right'><p><a onclick=deleteObject('article_delete.action?id="+item.id+"')>删除</a>|"+item.createDate+"|"+item.user+"</p></div></div>";
			});
		});
	
	</script>
  </body>
</html>