<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title id='pageTitleId'>Laivi 新闻资讯</title>
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
		<div class="span12">
			<input type='hidden' id="idFormFieldId">
			<h2 id="titleFormFieldId"></h2>
			<div class="span12" align="right">
				<p>
					<c:if test="${system!=null}">
						<button class="btn btn-small" onclick="recommon('NEWS','recommButtonId')" id='recommButtonId'><i class="icon-heart"></i>推荐</button>
					</c:if>
				</p>
			</div>
        	<p><label id="contentFormFieldId"></label></p>
		</div>
		<c:if test="${user!=null}">
			<div class="span12" align="right">
				<div>
					<button class="btn btn-small" id="articleDelButtonId" onclick="delNews()"><i class="icon-remove-circle"></i>删除</button>
					<button class="btn btn-small" id="articleEditButtonId" onclick="editNews()"><i class="icon-edit"></i>编辑</button>
				</div>
			</div>
		</c:if>
		
		<div class="span12" align="left" id="roundNewsDivId">
			
		</div>
        <div class="span12">
            <h3>同类新闻</h3>
        </div>
        <div id="likeNewsListDivId">

        </div>
		<div class="span12">
			<h3>评论</h3>
		</div>
		<div id="replyListDivId">
			
		</div>

		
		<div class="span12">
			<form class="form-horizontal" id="replyFormId">
				<textarea rows="10" style="width:100%" name="reply.content" id='replyContentId'></textarea>
				<div align='right'><p><button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-success">提交</button></p></div>
			</form>
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
	<script type="text/javascript" src="../js/plug/raty/jquery.raty.js"></script>
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript">
		function delNews(){
			deleteObject('../system/news/delete.nut?id='+sic.basic.getUrlVar("id"));
		}
		
		function editNews(){
			window.location.href="../user/user_addArticle.jsp?id="+sic.basic.getUrlVar("id");
		}
	
		$(document).ready(sic.basic.init(function(){
			var newsId=sic.basic.getUrlVar("id");
			$('#idFormFieldId').val(newsId);
			sic.common.setFormVaule("../system/news/get.nut?id="+newsId, false);
			sic.recomm.getRecomm(newsId,'NEWS');
            sic.common.getJson("../system/news/addViewCount.nut?id="+newsId);
            sic.common.getJson("../system/news/getRoundNews.nut?id="+newsId,function(result){
            	if(result.data.pre!=null){
            		$("#roundNewsDivId").append("<a href='news_view.jsp?id="+result.data.pre.id+"'><strong>上一篇:</strong>"+result.data.pre.title+"</a></br>");
            	}
            	if(result.data.next!=null){
            		$("#roundNewsDivId").append("<a href='news_view.jsp?id="+result.data.next.id+"'><strong>下一篇:</strong>"+result.data.next.title+"</a>");
            	}
            });
            sic.common.getJson("../common/recomm/getProposal.nut?type=NEWS&id="+newsId,function(result){
            	if(result.totalProperty!=0){
            		$.each(result.root,function(i,item){
                		$('#likeNewsListDivId').append("<div class='span3'><h3><a href='article_view.jsp?id="+item.id+"'>"+item.title+"</a></h3></div>");
                	});
            	}else{
            		$('#likeNewsListDivId').append("<div class='span12'><div class='alert alert-block'><h4>暂无相关推荐</h4></div></div>");
            	}
            	
            });
            sic.pageLoding.pageLoad('../reply/listByType.nut?reply.type=NEWS&reply.objId='+newsId,$("#replyListDivId"),function(item){
                 return "<div class='span12'><p>"+item.content+"</p><div align='right'><p><a class='btn btn-warning' onclick=deleteObject('../reply/delete.nut?id="+item.id+"')>删除</a>&nbsp;"+item.createDate+"&nbsp;"+item.user.name+"</p></div></div>";
            });
			sic.common.submitForm($("#replyFormId"), '../reply/add.nut?reply.type=NEWS&reply.objId='+newsId, function(){
				window.location.reload();
			}, false, false);
		}));
	</script>
  </body>
</html>
