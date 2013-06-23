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
			<div class="row">
				<div class="span6" id="recommArticleListId">
				</div>
				<div class="span6">
					
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>高分评价</h2></td>
						<td align="right"><a class="btn" href="article_list.jsp?type=HIGHT">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="hightScoreArticleListId" width="100%">
					</table>
				</div>
			</div>

			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>热门</h2></td>
						<td align="right"><a class="btn" href="article_list.jsp?type=HOT">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="hotArticleListId" width="100%">
					</table>
				</div>
			</div>

			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>最新</h2></td>
						<td align="right"><a class="btn" href="article_list.jsp?type=NEW">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="newarticleListId" width="100%">
					</table>
				</div>
			</div>

			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>随机</h2></td>
						<td align="right"><a class="btn" href="article_list.jsp">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="randomArticleListId" width="100%">
					</table>
				</div>
			</div>
			
			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>情感</h2></td>
						<td align="right"><a class="btn" href="article_list.jsp?tagId=3">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="loveArticleListId" width="100%">
					</table>
				</div>
			</div>
			
			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>生活</h2></td>
						<td align="right"><a class="btn" href="article_list.jsp?tagId=6">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="lifeArticleListId" width="100%">
					</table>
				</div>
			</div>
			
			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>感悟</h2></td>
						<td align="right"><a class="btn" href="article_list.jsp?tagId=7">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="thinkArticleListId" width="100%">
					</table>
				</div>
			</div>
			
			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>技术</h2></td>
						<td align="right"><a class="btn" href="blog/article.jsp?tagId=11">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="techolgyArticleListId" width="100%">
					</table>
				</div>
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
	<script type="text/javascript" src="../js/common/laivi-Carousel.js"></script>
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript">
		var getDataList=function(url,obj){
			sic.common.getJson(url, function(result){
				if(result.totalProperty>0){
					$.each(result.root,function(i,item){
						obj.append("<tr><td align='left'><a href='article_view.jsp?id="+item.id+"' title='"+item.title+"'>"+item.title+"</a></td><td align='right'>"+item.createDate.substring(0,10)+"</td></tr>");
					});
				}else{
					obj.append("<tr><td class='alert alert-block'>暂无数据</td></tr>")
				}
				
			},false,{
				'page.pageNumber':1,
	        	'page.pageSize':10
			});
		};
		
		
		$(document).ready(sic.basic.init(function() {
			new LaiviCarousel({
				parentContainer:'#recommArticleListId',
				url:'../blog/article/getRecommArticle.nut'
			});
			getDataList('../blog/article/getArticleByType.nut?type=HOT',$('#hotArticleListId'));
			getDataList('../blog/article/getArticleByType.nut?type=RANDOM',$('#randomArticleListId'));
			getDataList('../blog/article/getArticleByType.nut?type=HIGHT',$('#hightScoreArticleListId'));
			getDataList('../blog/article/getArticleByType.nut?type=NEW',$('#newarticleListId'));
			getDataList('../blog/article/getArticleByType.nut?tagId=11',$('#techolgyArticleListId'));
			getDataList('../blog/article/getArticleByType.nut?tagId=3',$('#loveArticleListId'));
			getDataList('../blog/article/getArticleByType.nut?tagId=6',$('#lifeArticleListId'));
			getDataList('../blog/article/getArticleByType.nut?tagId=7',$('#thinkArticleListId'));
		}));
	</script>
</body>
</html>
