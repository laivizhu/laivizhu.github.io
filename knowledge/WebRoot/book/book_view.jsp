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
		    <div class="span9">
		     	<div class="row" id="chapterListDivId">
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
		var getMoreData=function(id){
			laivi.getJson('book_getChapter.action?id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getLessData("+result.data.id+")'>Fold &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		var getLessData=function(id){
			laivi.getJson('book_getChapter.action?fold=true&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getMoreData("+result.data.id+")'>More &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		$(document).ready(laivi.init(function(){
			var bookId=laivi.getUrlVar("id");
			loadLocalNavigate(navigate.user);
			laivi.scrollBreakPage('book_listChapter.action?id='+bookId, $("#chapterListDivId"), function(item){
				return "<div class='span9'><a href='chapter_view.jsp?id="+item.id+"'><h2>"+item.title+"</h2></a><p id='content"+item.id+"'>"+item.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.id+")'>More &raquo;</a></p><div align='right'><p><a class='btn' href='#' onclick=deleteObject('book_deleteChapter.action?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a></p></div></div>";
			});
		}));
	</script>
  </body>
</html>
