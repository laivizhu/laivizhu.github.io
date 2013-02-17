<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 知识总结</title>
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
		<div class="span12" align="right">
				<p><button class="btn btn-small" onclick="addFavorite('KNOWLEDGE')" id='favoriteButtonId'><i class="icon-heart"></i>收藏</button>
				   <button class="btn btn-small" href="#"><i class="icon-share"></i>分享</button>
				   <button class="btn btn-small" href="#"><i class="icon-share-alt"></i>转载</button>
				</p>
		</div>
		
	</div>

      <hr>

      <footer>
      	  <p class="pull-right"><button class='btn btn-warning' onclick="history.back()">Back</button><a class='btn' href="#">Back to top</a></p>
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
		$(document).ready(laivi.init(function(){
			var knowledgeId=laivi.getUrlVar("id");
			laivi.setFormVaule("knowledge_get.action?font=true&id="+knowledgeId, false);
		}));
	</script>
  </body>
</html>
