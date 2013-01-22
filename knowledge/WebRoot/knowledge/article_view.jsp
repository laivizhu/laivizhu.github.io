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
		<div class="span12">
			<h2 id="titleFormFieldId"></h2>
        	<p><label id="contentFormFieldId"></label></p>
		</div>
		<div class="span12">
			<h3>评论</h3>
		</div>
		<div id="replyListDivId">
			
		</div>
		
		<div class="span12">
			<form class="form-horizontal" id="replyFormId">
				<textarea rows="10" style="width:100%" name="reply.context" id='replyContentId'></textarea>
				<div align='right'><p><button type="reset" class="btn">重置</button>&nbsp;&nbsp;&nbsp;<button type="submit" class="btn">提交</button></p></div>
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
    
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script  src="../kindeditor/kindeditor-min.js"></script>
	<script  src="../kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript">
		
		$(document).ready(function(){
			var articleId=laivi.getUrlVar("id");
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[id="replyContentId"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});
			});
			laivi.setFormVaule("article_get.action?type=1&id="+articleId, false);
			laivi.getJson('reply_list.action?id='+articleId, function(result){
				if(result.totalProperty>0){
					$.each(result.root,function(i,item){
						$("#replyListDivId").append("<div class='span12'><p>"+item.context+"</p><div align='right'><p><a onclick=deleteObject('reply_delete.action?id="+item.id+"')>删除</a>|"+item.createDate+"|"+item.user+"</p></div></div>");
					});
				}else{
					$("#replyListDivId").append("<div class='span12'><h5>暂无评论<h5></div>");
				}
				
			});
			laivi.submitForm($("#replyFormId"), 'reply_add.action?reply.articleId='+articleId, function(){
				window.location.reload();
			}, false, false);
		});
	</script>
  </body>
</html>
