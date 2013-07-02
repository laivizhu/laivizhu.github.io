<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title id='pageTitleId'>Laivi 感悟生活</title>
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
						<button class="btn btn-small" onclick="recommon('ARTICLE','recommButtonId')" id='recommButtonId'><i class="icon-heart"></i>推荐</button>
					</c:if>
				   <button class="btn btn-small" onclick="fromOther('ARTICLE','favoriteButtonId','收藏',0)" id='favoriteButtonId'><i class="icon-heart"></i>收藏</button>
				   <button class="btn btn-small" onclick="fromOther('ARTICLE','shareButtonId','分享',1)" id="shareButtonId"><i class="icon-share"></i>分享</button>
				   <button class="btn btn-small" onclick="fromOther('ARTICLE','fromOtherButtonId','转载',2)" id='fromOtherButtonId'><i class="icon-share-alt"></i>转载</button>
				</p>
			</div>
        	<p><label id="contentFormFieldId"></label></p>
		</div>
		<div class="span12" align="center">
			<div id="articleStarDivId"></div>
		</div>
		<c:if test="${user!=null}">
			<div class="span12" align="right">
				<div>
					<button class="btn btn-small" id="articleDelButtonId" onclick="delArticle()"><i class="icon-remove-circle"></i>删除</button>
					<button class="btn btn-small" id="articleEditButtonId" onclick="editArticle()"><i class="icon-edit"></i>编辑</button>
				</div>
			</div>
		</c:if>
		
		<div class="span12" align="left" id="roundArticleDivId">
			
		</div>
        <div class="span12">
            <h3>同类文章</h3>
        </div>
        <div id="likeArticleListDivId">
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
		function delArticle(){
			deleteObject('../blog/article/delete.nut?id='+sic.basic.getUrlVar("id"));
		}
		
		function editArticle(){
			window.location.href="../user/user_addArticle.jsp?id="+sic.basic.getUrlVar("id");
		}
		
		
	
		$(document).ready(sic.basic.init(function(){
			var articleId=sic.basic.getUrlVar("id");
			$('#idFormFieldId').val(articleId);
			sic.common.setFormVaule("../blog/article/get.nut?id="+articleId, false);
			sic.fromOther.getFromOther(articleId,'ARTICLE');
			sic.recomm.getRecomm(articleId,'ARTICLE');
            sic.common.getJson("../blog/article/addViewCount.nut?id="+articleId);
            sic.common.getJson("../blog/article/getRoundArticle.nut?id="+articleId,function(result){
            	if(result.data.pre!=null){
            		$("#roundArticleDivId").append("<a href='article_view.jsp?id="+result.data.pre.id+"'><strong>上一篇:</strong>"+result.data.pre.title+"</a></br>");
            	}
            	if(result.data.next!=null){
            		$("#roundArticleDivId").append("<a href='article_view.jsp?id="+result.data.next.id+"'><strong>下一篇:</strong>"+result.data.next.title+"</a>");
            	}
            });
            sic.common.getJson("../common/recomm/getProposal.nut?type=ARTICLE&id="+articleId,function(result){
            	var content="";
            	if(result.totalProperty!=0){
            		$.each(result.root,function(i,item){
            			console.log(i);
            			if(i%3==0){
            				//$('#likeArticleListDivId').append("<ul>");
            				content+="<ul class='list1' style='float:left;'>";
            				isChange=true;
            			}
                		//$('#likeArticleListDivId').append("<li class='span3'><h3><a href='article_view.jsp?id="+item.id+"'>"+item.title+"</a></h3></li>");
                		content+="<li><h3><a href='article_view.jsp?id="+item.id+"'>"+item.title+"</a></h3></li>";
                		if((i+1)%3==0){
                			//$('#likeArticleListDivId').append("</ul>");
                			content+="</ul>";
                		}
                	});
            		$('#likeArticleListDivId').append(content);
            		console.log(content);
            	}else{
            		$('#likeArticleListDivId').append("<div class='span12'><div class='alert alert-block'><h4>暂无相关推荐</h4></div></div>");
            	}
            	
            });
            sic.pageLoding.pageLoad('../reply/listByType.nut?reply.type=ARTICLE&reply.objId='+articleId,$("#replyListDivId"),function(item){
                 return "<div class='span12'><p>"+item.content+"</p><div align='right'><p><a class='btn btn-warning' onclick=deleteObject('../reply/delete.nut?id="+item.id+"')>删除</a>|"+item.createDate+"|"+item.user.name+"</p></div></div>";
            });
			sic.common.submitForm($("#replyFormId"), '../reply/add.nut?reply.type=ARTICLE&reply.objId='+articleId, function(){
				window.location.reload();
			}, false, false);
			sic.plug.raty('#articleStarDivId','../score/getScore.nut?score.type=ARTICLE&score.objectId='+articleId, '../score/add.nut?score.type=ARTICLE&score.objectId='+articleId);
		}));
	</script>
  </body>
</html>
