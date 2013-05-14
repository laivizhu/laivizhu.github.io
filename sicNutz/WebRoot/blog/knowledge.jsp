<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 知识积累</title>
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
		      	<li><a href="#knowledge"><i class="icon-chevron-right"></i>全部</a></li>
		      	<li><a href="#"><i class="icon-chevron-right"></i>全部</a></li>
		      </ul>
		    </div>
		    <div class="span9">
		    	<!-- Main hero unit for a primary marketing message or call to action -->
		     	<section id="knowledge">
		     		<!-- Example row of columns -->
			     	<div class="row" id="knowledgeListDivId">
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
		var getMoreData=function(id){
			sic.common.getJson('../blog/knowledge/get.nut?id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getLessData("+result.data.id+")'>Fold &raquo;</a>";
				$('#content'+id).html(result.data.answer+comb);
			});
		};
		var getLessData=function(id){
			sic.common.getJson('../blog/knowledge/get.nut?fold=true&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getMoreData("+result.data.id+")'>More &raquo;</a>";
				$('#content'+id).html(result.data.answer+comb);
			});
		};
		$(document).ready(sic.basic.init(function(){
			sic.pageLoding.pageLoad('../blog/knowledge/getAll.nut', $("#knowledgeListDivId"), function(item){
				return "<div class='span9'><a href='knowledge_view.jsp?id="+item.knowledge.id+"'><h2>"+item.knowledge.title+"</h2></a><p>"+item.knowledge.question+"</p><p id='content"+item.knowledge.id+"'>"+item.knowledge.answer+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.knowledge.id+")'>More &raquo;</a></p><div align='right'><p>"+item.knowledge.createDate+"|"+item.user.name+"</p></div></div>";
			});
		}));
	</script>
  </body>
</html>
