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
		<div style="position: fixed; float:right;width:85px;height:60px; right:0px;top:50px;" >
    		<ul class="nav nav-pills">
			      <li>
			        <a href="news_add.jsp" class="btn">新增新闻</a>
			      </li>
			</ul>
		</div>
		<div class="hero-unit">
			<div class="row">
				<div class="span6" id="recommNewsListId">
				</div>
				<div class="span6">
					
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>热门</h2></td>
						<td align="right"><a class="btn" href="news_list.jsp?type=HOT">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="hotNewsListId" width="100%">
					</table>
				</div>
			</div>

			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>最新</h2></td>
						<td align="right"><a class="btn" href="news_list.jsp?type=NEW">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="newNewsListId" width="100%">
					</table>
				</div>
			</div>

			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>随机</h2></td>
						<td align="right"><a class="btn" href="news_list.jsp">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="randomNewsListId" width="100%">
					</table>
				</div>
			</div>
			
			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>IT资讯</h2></td>
						<td align="right"><a class="btn" href="news_list.jsp?tagId=16">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="loveNewsListId" width="100%">
					</table>
				</div>
			</div>
			
			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>南方周末</h2></td>
						<td align="right"><a class="btn" href="news_list.jsp?tagId=17">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="lifeNewsListId" width="100%">
					</table>
				</div>
			</div>
			
			<div class="span6">
				<table width="100%">
					<tr>
						<td align="left"><h2>生活资讯</h2></td>
						<td align="right"><a class="btn" href="news_list.jsp?tagId=18">More &raquo;</a></td>
					</tr>
				</table>
				<div style="height:240px">
					<table id="thinkNewsListId" width="100%">
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
						obj.append("<tr><td align='left'><a href='news_view.jsp?id="+item.id+"' title='"+item.title+"'>"+item.title+"</a></td><td align='right'>"+item.createDate.substring(0,10)+"</td></tr>");
					});
				}else{
					obj.append("<tr><td class='alert alert-block'>暂无数据</td></tr>");
				}
			},false,{
				'page.pageNumber':1,
	        	'page.pageSize':10
			});
		};
		
		$(document).ready(sic.basic.init(function() {
			new LaiviCarousel({
				parentContainer:'#recommNewsListId',
				url:'../system/news/getRecommNews.nut',
				params:{
					'page.pageNumber':1,
		        	'page.pageSize':10
				}
			});
			getDataList('../system/news/listByTag.nut?type=HOT',$('#hotNewsListId'));
			getDataList('../system/news/listByTag.nut?type=RANDOM',$('#randomNewsListId'));
			getDataList('../system/news/listByTag.nut?type=NEW',$('#newNewsListId'));
			getDataList('../system/news/listByTag.nut?tagId=16',$('#loveNewsListId'));
			getDataList('../system/news/listByTag.nut?tagId=17',$('#lifeNewsListId'));
			getDataList('../system/news/listByTag.nut?tagId=18',$('#thinkNewsListId'));
		}));
	</script>
</body>
</html>
