<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Laivi 感悟生活</title>
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
		<div class="hero-unit">
			<h1>Welcome Back</h1>
			<p>hello</p>
			<p>
				<a class="btn btn-primary btn-large">Learn more &raquo;</a>
			</p>
		</div>
		<div class="row">
			<div class="span3 row">
				<div class="span3">
					<h2>推荐</h2>
					<div style="height:120px">
						<table id="proposalArticleListId" width="100%">
						</table>
					</div>
				</div>

				<div class="span3">
					<h2>热门</h2>
					<div style="height:120px">
						<table id="hotArticleListId" width="100%">
						</table>
					</div>
				</div>

				<div class="span3">
					<h2>最新</h2>
					<div style="height:120px">
						<table id="articleListId" width="100%">
						</table>
					</div>
				</div>

				<div class="span3">
					<h2>随机</h2>
					<div style="height:120px">
						<table id="randomArticleListId" width="100%">
						</table>
					</div>
				</div>
			</div>
			<div class="span9">
				<div class="row" id="articleListDivId"></div>
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
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript">
		var getDataList=function(url,obj){
			sic.common.getJson(url, function(result){
				$.each(result.root,function(i,item){
					obj.append("<tr><td align='left'><a href='article_view.jsp?id="+item.id+"' title='"+item.title+"'>"+item.title.substring(0,8)+"</a></td><td align='right'>"+item.createDate.substring(0,10)+"</td></tr>");
				});
			},false);
		};
		
		var getMoreData = function(id) {
			sic.common.getJson('../blog/article/get.nut?id=' + id,
							function(result) {
								var comb = "<a class='btn btn-primary btn-small' onclick='getLessData("+ result.data.id+ ")'>Fold &raquo;</a>";
								$('#content' + id).html(result.data.content + comb);
							});
		};
		var getLessData = function(id) {
			sic.common.getJson('../blog/article/get.nut?fold=true&id=' + id,
							function(result) {
								var comb = "<a class='btn btn-primary btn-small' onclick='getMoreData("+ result.data.id+ ")'>More &raquo;</a>";
								$('#content' + id).html(result.data.content + comb);
							});
		};
		$(document).ready(sic.basic.init(function() {
			sic.pageLoding.pageLoad('../blog/article/getAll.nut',$("#articleListDivId"),
					function(item) {
						return "<div class='span9'><a href='article_view.jsp?id="
								+ item.article.id
								+ "'><h2>"
								+ item.article.title
								+ "</h2></a><p id='content"+item.article.id+"'>"
								+ item.article.content
								+ "<a class='btn btn-primary btn-small' onclick='getMoreData("
								+ item.article.id
								+ ")'>More &raquo;</a></p><div align='right'><p>"
								+ item.article.createDate
								+ "|"
								+ item.user.name
								+ "</p></div></div>";
			});
			getDataList('../blog/article/getHotArticles.nut',$('#hotArticleListId'));
			getDataList('../blog/article/getRandomArticle.nut',$('#randomArticleListId'));
		}));
	</script>
</body>
</html>
