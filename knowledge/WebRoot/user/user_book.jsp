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
		    	<!-- Main hero unit for a primary marketing message or call to action -->
		    	<div style="position: fixed; float: right;width:100px;height:60px; right:10px;" >
		    		<ul class="nav nav-pills">
						      <li>
						        <a href="book_add.jsp" class="btn"><i class='icon-book'></i>上传书籍</a>
						      </li>
					</ul>
				</div>

				<div>
					<ul class="nav nav-tabs" id="myTab">
						  <li class="active"><a href="#myBook" data-toggle="tab">我的书籍</a></li>
						  <li><a href="#myCreateBook" data-toggle="tab">我创作的书籍</a></li>
						  <li><a href="#myBookMark" data-toggle="tab">我的书签</a></li>
					</ul>
					<div class='tab-content'>
						<div class='tab-pane fade in active' id='myBook'>
							<div class="row" id="bookListDivId">
	      					</div>
						</div>
						<div class='tab-pane fade' id='myCreateBook'>
							<div class="span8">
								<div align='right'>
									<a href="user_addBook.jsp" class="btn btn-success"><i class='icon-book'></i>创作书籍</a>
								</div>
							</div>
							<div class="row" id="myCreateBookListDivId">
	      					</div>
						</div>
						
						<div class='tab-pane fade' id='myBookMark'>
							<div class="row" id="bookMarkListDivId">
								
      						</div>
						</div>
					</div>
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
	<script type="text/javascript" src="../js/bootstrap/bootstrap-tab.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript" src="../js/common/navigate.js"></script>
	<script type="text/javascript">
		$(document).ready(laivi.init(function(){
			loadLocalNavigate(navigate.user);
			$('#myTab a').click(function (e) {
			  e.preventDefault();
			  $(this).tab('show');
			});
			laivi.scrollBreakPage('book_list.action?book.createIs=false', $("#bookListDivId"), function(item){
				return "<div class='span3'><div class='thumbnail'><a href='user_viewBook.jsp?id="+item.id+"'><img src='../picture/musicAlbum.jpg'></a><div class='caption'><p>"+item.name+"</p><p><a class='btn' href='#' onclick=deleteObject('book_delete.action?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a>&nbsp;<a class='btn' href='book_add.jsp?id="+item.id+"'><i class='icon-edit'></i>编辑</a>"+item.path+"</p></div></div></div>";
			});
			laivi.scrollBreakPage('book_list.action?book.createIs=true', $("#myCreateBookListDivId"), function(item){
				return "<div class='span4'><div class='thumbnail'><a href='user_viewBook.jsp?id="+item.id+"'><img src='../picture/musicAlbum.jpg'></a><div class='caption'><p>"+item.name+"</p><p>"+item.description+"</p><p><a class='btn' href='#' onclick=deleteObject('book_delete.action?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a>&nbsp;<a class='btn' href='book_add.jsp?id="+item.id+"'><i class='icon-edit'></i>编辑</a>"+item.path+"</p></div></div></div>";
			});
			laivi.scrollBreakPage('book_bookMarklist.action', $("#bookMarkListDivId"), function(item){
				return "<div class='span8'><p><a href='../book/chapter_view.jsp?id="+item.chapter.id+"'>"+item.chapter.title+"</a></p><div align='right'><button onclick=deleteObject('book_deleteBookMark.action?id="+item.id+"')><i class='icon-remove'></i>删除</button></div></div>";
			});
		}));
	
	</script>
  </body>
</html>