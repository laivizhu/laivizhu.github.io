<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 书城</title>
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
		    
		    <div class="row span9" id="bookListDivId">
        		
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
		$(document).ready(laivi.init(function(){
			loadRemoteNavigate('tag_comboList.action?tag.type=BOOK','book.jsp?book.tagId=');
			var tagId=laivi.getUrlVar("book.tagId");
			if(tagId==null){
				laivi.scrollBreakPage('book_list.action', $("#bookListDivId"), function(item){
					return "<div class='span2'><div class='thumbnail'><img src='../picture/musicAlbum.jpg'><div class='caption'><p>"+item.name+"</p><p>价格:"+item.price+"个积分</p><p><button class='btn' onclick=addMyBookShelf("+item.id+")>购买</button></p></div></div></div>";
				});
			}else{
				laivi.scrollBreakPage('book_tagCategoryList.action?book.tagId='+tagId, $("#bookListDivId"), function(item){
					return "<div class='span2'><div class='thumbnail'><img src='../picture/musicAlbum.jpg'><div class='caption'><p>"+item.name+"</p><p>价格:"+item.price+"个积分</p><p><button class='btn' onclick=addMyBookShelf("+item.id+")>购买</button></p></div></div></div>";
				});
			}
		}));
		
		var addMyBookShelf=function(bookId){
			laivi.confirm('确认要购买加入书架吗？', function(){
				laivi.getJson('book_addUserBookShelf.action?id='+bookId, function(){
					laivi.alert('已经添加到书架中');
				});
			});
		};
	</script>
  </body>
</html>
