<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 阅读</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/docs.css"/>
    <link rel="stylesheet" type="text/css" href="../css/jbox_Green/jbox.css"/>
    <link rel="stylesheet" type="text/css" href="../css/apprise.css"/>
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
		<div class="span12" align="center">
			<p>
				<button class="btn btn-small" onclick="jumpChapter('pre')"><i class="icon-arrow-left"></i>前一章</button>
				<button class="btn btn-small" onclick="jumpChapter('list')"><i class="icon-list"></i>返回目录</button>
				<button class="btn btn-small" onclick="jumpChapter('next')"><i class="icon-arrow-right"></i>下一章</button>
			</p>
		</div>
		<hr>
		<div class="span12" align="right">
				<p><button class="btn btn-small" onclick="addFavorite('BOOK')" id='favoriteButtonId'><i class="icon-heart"></i>收藏</button>
				   <button class="btn btn-small" onclick=""><i class="icon-share"></i>分享</button>
				   <button class="btn btn-small" onclick="addBookMark()" id='fromOtherButtonId'><i class="icon-bookmark"></i>加入书签</button>
				</p>
		</div>
		<div class="span12">
			<input type='hidden' id="idFormFieldId">
			<h2 id="titleFormFieldId"></h2>
        	<p><label id="contentFormFieldId"></label></p>
		</div>
		<div class="span12" align="right">
				<p><button class="btn btn-small" onclick="addFavorite('BOOK')" id='favoriteButtonId'><i class="icon-heart"></i>收藏</button>
				   <button class="btn btn-small" onclick=""><i class="icon-share"></i>分享</button>
				   <button class="btn btn-small" onclick="addBookMark()" id='fromOtherButtonId'><i class="icon-bookmark"></i>加入书签</button>
				</p>
		</div>
		<hr>
		<div class="span12" align="center">
			<p>
				<button class="btn btn-small" onclick="jumpChapter('pre')"><i class="icon-arrow-left"></i>前一章</button>
				<button class="btn btn-small" onclick="jumpChapter('list')"><i class="icon-list"></i>返回目录</button>
				<button class="btn btn-small" onclick="jumpChapter('next')"><i class="icon-arrow-right"></i>下一章</button>
			</p>
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
		$(document).ready(laivi.init(function(){
			var chapterId=laivi.getUrlVar("id");
			$('#idFormFieldId').val(chapterId);
			laivi.setFormVaule("book_getBookChapter.action?id="+chapterId, false);
		}));
		
		var jumpChapter=function(dir){
			var chapterId=$('#idFormFieldId').val();			
			if(dir!='list'){
				laivi.setFormVaule('book_getBookChapter.action?id='+chapterId+'&dir='+dir, false);
			}else{
				//window.location.href="";
				history.back();
			}
		};
		var addBookMark=function(){
			var chapterId=$('#idFormFieldId').val();
			laivi.getJson('book_addBookMark.action?id='+chapterId, function(){
				laivi.alert('添加书签成功');
			});
		}
	</script>
  </body>
</html>
