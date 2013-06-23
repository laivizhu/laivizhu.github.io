<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi SIC</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap/docs.css"/>
    <link rel="stylesheet" type="text/css" href="css/jbox_Green/jbox.css"/>
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
  </head>
  <body>
  <jsp:include page="common/navigate.jsp"/>
 
    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
        <h1>Welcome Back</h1>
        <p>hello</p>
        <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
      
        <div class="span3">
          <h2>网站信息</h2>
          <div style="height:240px">
          <table id="informationListId" width="100%">
          </table>
          </div>
          <p><a class="btn" href="knowledge/information.jsp">More &raquo;</a></p>
        </div>
        
        <div class="span3">
          <h2>论坛动态</h2>
          <div style="height:240px">
          <ul id="postsListId">
          </ul>
          </div>
          <p><a class="btn" href="#">More &raquo;</a></p>
       </div>
       
        <div class="span3">
          <h2>优秀文章</h2>
         <div style="height:240px">
          <table id="articleListId" width="100%">
          </table>
          </div>
          <p><a class="btn" href="blog/article.jsp">More &raquo;</a></p>
        </div>
        
        <div class="span3">
          <h2>美丽回忆</h2>
         <div style="height:240px">
          <ul id="pictureListId">
          </ul>
          </div>
          <p><a class="btn" href="picture/picture.jsp">More &raquo;</a></p>
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
    
    <script type="text/javascript" src="js/jquery/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="js/jquery/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="js/common/sic-basic.js"></script>
	<script type="text/javascript" src="js/common/laivi-Carousel.js"></script>
	<script type="text/javascript">
		var getDataList=function(url,obj){
			sic.common.getJson(url, function(result){
				$.each(result.root,function(i,item){
					obj.append("<tr><td align='left'><a href='blog/article_view.jsp?id="+item.id+"' title='"+item.title+"'>"+item.title.substring(0,8)+"</a>("+item.viewCount+")</td><td align='right'>"+item.createDate.substring(0,10)+"</td></tr>");
				});
			},false,{
				'page.pageNumber':1,
	        	'page.pageSize':10
			});
		};
		
		$(document).ready(sic.basic.init(function(){
			getDataList('blog/article/getArticleByType.nut?type=HOT',$('#articleListId'));
		}));
		
	</script>
	
  </body>
</html>
