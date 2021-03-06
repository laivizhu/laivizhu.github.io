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

			    <div class="row">
			    	<div class="span8" align="center" style="margin-top: 30px;">
						<input type="text" id="searchWord" class="search-query" style="height:30px;width:400px;"/>
						<button type="button" class="btn btn-success" onclick="searchArticle()">搜索</button>
					</div>
					<div class="span8">
						<div class="span8" id="tagListDivId">
						</div>
					</div>
					<div class="row span8" id="articleListDivId">
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
    
    
    <script type="text/javascript" src="../js/jquery/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="../js/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="../js/common/laivi-typeahead.js"></script>
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript" src="../js/common/navigate.js"></script>
	<script type="text/javascript">
		var getMoreData=function(id){
			sic.common.getJson('../blog/article/get.nut?fold=false&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getLessData("+result.data.id+")'>Fold &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		var getLessData=function(id){
			sic.common.getJson('../blog/article/get.nut?fold=true&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getMoreData("+result.data.id+")'>More &raquo;</a>";
				$('#content'+id).html(result.data.content+comb);
			});
		};
		
		var searchArticle=function(){
			var searchWord=$("#searchWord").val();
			if(sic.common.isNotNull(searchWord, '请输入搜索文章关键字')){
				$("#articleListDivId").html("");
				sic.pageLoding.pageLoad('../blog/article/search.nut?notBreakPage=true&key=title&value='+searchWord, $("#articleListDivId"), function(item){
	            	var keyword="";
	            	if(!item.selfIs){
	            		if(item.shareIs) keyword="分享";
	            		if(item.favoriteIs) keyword="收藏";
	            		if(item.fromOtherIs) keyword="转载";
	            	}
	            	return "<div class='span8'><a href='../blog/article_view.jsp?id="+item.article.id+"'><h4>"+(item.selfIs?"":"<font color='red'>["+keyword+"]</font>")+item.article.title+"</h4></a><p><div align='right'>"+item.article.createDate+" 作者："+item.user.name+" 访问量："+item.article.viewCount+"</div></p><p id='content"+item.article.id+"'>"+item.article.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.article.id+")'>More &raquo;</a></p><div align='right'><p><a class='btn' onclick=deleteObject('../blog/article/delete.nut?id="+item.article.id+"')><i class='icon-remove-circle'></i>删除</a>|<a class='btn' href='user_addArticle.jsp?id="+item.article.id+"'><i class='icon-edit'></i>编辑</a></p></div></div>";
	            });
			}
		};
		
		$(document).ready(sic.basic.init(function(){
			loadLocalNavigate(navigate.user);
			new LaiviTypeahead({
				url:'../blog/article/listAllTitle.nut',
				object:'#searchWord'
			});
			var tagId=sic.basic.getUrlVar('tagId');
			var url=null;
			if(tagId!=null){
				url='../blog/article/listByTag.nut?tagId='+tagId;
			}else{
				url='../common/fromother/listByCategory.nut?type=ARTICLE';
			}
            sic.pageLoding.pageLoad(url, $("#articleListDivId"), function(item){
            	var keyword="";
            	if(!item.selfIs){
            		if(item.shareIs) keyword="分享";
            		if(item.favoriteIs) keyword="收藏";
            		if(item.fromOtherIs) keyword="转载";
            	}
            	return "<div class='span8'><a href='../blog/article_view.jsp?id="+item.article.id+"'><h4>"+(item.selfIs?"":"<font color='red'>["+keyword+"]</font>")+item.article.title+"</h4></a><p><div align='right'>"+item.article.createDate+" 作者："+item.user.name+" 访问量："+item.article.viewCount+"</div></p><p id='content"+item.article.id+"'>"+item.article.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.article.id+")'>More &raquo;</a></p>"+
            		"</div><div class='span8'><table width='100%'><tr><td align='left'>"+
            		"&nbsp;"+
            		"</td><td align='right'><a class='btn' onclick=deleteObject('../blog/article/delete.nut?id="+item.article.id+"')><i class='icon-remove-circle'></i>删除</a>&nbsp;<a class='btn' href='user_addArticle.jsp?id="+item.article.id+"'><i class='icon-edit'></i>编辑</a></td><tr></table></div>";
            });
			
			sic.common.getJson('../tag/comboList.nut?tag.type=ARTICLE',function(result){
				$("#tagListDivId").append("<table width='100%'><tr>");
				$.each(result.root,function(i,item){
					$("#tagListDivId").append("<td><a href='user_article.jsp?tagId="+item.id+"'><font color='green'>"+item.name+"</font></a>&nbsp;&nbsp;</td>");
				});
				$("#tagListDivId").append("</tr></table>");
			});
		}));
	
	</script>
  </body>
</html>