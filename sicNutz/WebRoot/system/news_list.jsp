<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Laivi 新闻资讯</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap/docs.css" />
<link rel="stylesheet" type="text/css" href="../css/jbox_Green/jbox.css" />
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
</head>
<body>
	<jsp:include page="../common/navigate.jsp" />

	<div class="container">
		<div class="row">
			<div class="span12" align="center" style="margin-top: 30px;">
				<input type="text" id="searchWord" class="search-query" style="height:30px;width:800px;"/>
				<button type="button" class="btn btn-success" onclick="searchNews()">搜索</button>
			</div>
			<p></p><br>
			<hr>
			<div class="span12">
				<div class="row" id="newsListDivId"></div>
			</div>
		</div>
		<hr>
		<footer>
		<div align="center">
			<p>&copy; Laivi 2013-2014</p>
			<p>
				<a href="mailto:laivi.zhu@gmail.com">联系我们:laivi.zhu@gmail.com</a>
			</p>
		</div>
		</footer>
	</div>


	<script type="text/javascript" src="../js/jquery/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.form.js"></script>
	<script type="text/javascript"
		src="../js/jquery/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="../js/common/laivi-typeahead.js"></script>
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript">
		var getDataList=function(url,obj){
			sic.common.getJson(url, function(result){
				$.each(result.root,function(i,item){
					obj.append("<tr><td align='left'><a href='news_view.jsp?id="+item.id+"' title='"+item.title+"'>"+item.title.substring(0,8)+"</a></td><td align='right'>"+item.createDate.substring(0,10)+"</td></tr>");
				});
			},false);
		};
		
		var getMoreData = function(id) {
			sic.common.getJson('../system/news/get.nut?id=' + id,
							function(result) {
								var comb = "<a class='btn btn-primary btn-small' onclick='getLessData("+ result.data.id+ ")'>Fold &raquo;</a>";
								$('#content' + id).html(result.data.content + comb);
							});
		};
		var getLessData = function(id) {
			sic.common.getJson('../system/news/get.nut?fold=true&id=' + id,
							function(result) {
								var comb = "<a class='btn btn-primary btn-small' onclick='getMoreData("+ result.data.id+ ")'>More &raquo;</a>";
								$('#content' + id).html(result.data.content + comb);
							});
		};
		var searchNews=function(){
			var searchWord=$("#searchWord").val();
			if(sic.common.isNotNull(searchWord, '请输入搜索文章关键字')){
				$("#newsListDivId").html("");
				sic.pageLoding.pageLoad('../system/news/search.nut?key=title&value='+searchWord, $("#newsListDivId"), function(item){
	            	return "<div class='row'><div class='span4'><img src='"+item.path+"' alt=''></div><div class='span8'><a href='../system/news_view.jsp?id="+item.id+"'><h4>"+item.title+"</h4></a><p><div align='right'>"+item.createDate+" 作者："+item.user.name+" 访问量："+item.viewCount+"</div></p><p id='content"+item.id+"'>"+item.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.id+")'>More &raquo;</a></p></div>";
	            },null,12);
			}
		};
		$(document).ready(sic.basic.init(function() {
			new LaiviTypeahead({
				url:'../system/news/listAllTitle.nut',
				object:'#searchWord'
			});
			var url="../system/news/listByTag.nut";
			var type=sic.basic.getUrlVar("type");
			var tagId=sic.basic.getUrlVar("tagId");
			if(type!=null){
				url+="?type="+type;
			}else if(tagId!=null){
				url+="?tagId="+tagId;
			}
			sic.pageLoding.pageLoad(url,$("#newsListDivId"),
					function(item) {
						return "<div class='row'><div class='span4'><img src='"+item.path+"' alt=''></div><div class='span8'><a href='../system/news_view.jsp?id="+item.id+"'><h4>"+item.title+"</h4></a><p><div align='right'>"+item.createDate+" 作者："+item.user.name+" 访问量："+item.viewCount+"</div></p><p id='content"+item.id+"'>"+item.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.id+")'>More &raquo;</a></p></div>";
			},null,12);
		}));
	</script>
</body>
</html>
