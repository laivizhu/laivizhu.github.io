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
		    	<div style="position: fixed; float: right;width:100px;height:60px; right:10px;" >
		    		<ul class="nav nav-pills">
						      <li>
						        <button onclick="addBookChapter()" class="btn"><i class='icon-book'></i>新增章节</button>
						      </li>
					</ul>
				</div>
				<br>
		     	<div class="row" id="chapterListDivId">
	      		</div>		      	
		      	
		    </div>
  		</div>
      <hr>
      <footer>
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
		var bookId;
		var addBookChapter=function(){
			window.location.href='user_addBookChapter.jsp?bookId='+bookId;
		};
		
		var getMoreData=function(id){
			sic.common.getJson('../media/chapter/get.nut?id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getLessData("+result.data.id+")'>Fold &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		var getLessData=function(id){
			sic.common.getJson('../media/chapter/get.nut?fold=true&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getMoreData("+result.data.id+")'>More &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		$(document).ready(sic.basic.init(function(){
			bookId=sic.basic.getUrlVar("id");
			loadLocalNavigate(navigate.user);
			sic.pageLoding.pageLoad('../media/chapter/listChapter.nut?id='+bookId, $("#chapterListDivId"), function(item){
				return "<div class='span9'><a href='../book/chapter_view.jsp?id="+item.id+"'><h2>"+item.title+"</h2></a><p id='content"+item.id+"'>"+item.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.id+")'>More &raquo;</a></p><div align='right'><p><a class='btn' href='#' onclick=deleteObject('../media/chapter/delete.nut?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a><a class='btn' href='user_addBookChapter.jsp?bookId="+item.book.id+"&id="+item.id+"'>编辑</a></p></div></div>";
			});
		}));
	</script>
  </body>
</html>
