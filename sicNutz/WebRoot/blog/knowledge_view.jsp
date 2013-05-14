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
			<input type='hidden' id="idFormFieldId">
			<h2 align="center" id="titleFormFieldId"></h2>
            <hr>
            <div class="span12" align="right">
				<p><button class="btn btn-small" onclick="fromOther('KNOWLEDGE','favoriteButtonId','收藏',0)" id='favoriteButtonId'><i class="icon-heart"></i>收藏</button>
				   <button class="btn btn-small" onclick="fromOther('KNOWLEDGE','shareButtonId','分享',1)" id="shareButtonId"><i class="icon-share"></i>分享</button>
				   <button class="btn btn-small"onclick="fromOther('KNOWLEDGE','fromOtherButtonId','转载',2)" id="fromOtherButtonId"><i class="icon-share-alt"></i>转载</button>
				</p>
			</div>
            <h3>问题描述</h3>
            <hr>
            <p><label id="questionFormFieldId"></label></p>
            <h3>解决方案</h3>
            <hr>
        	<p><label id="answerFormFieldId"></label></p>
		</div>
	</div>

      <hr>
      <footer>
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
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript">
		$(document).ready(sic.basic.init(function(){
			var knowledgeId=sic.basic.getUrlVar("id");
			$('#idFormFieldId').val(knowledgeId);
			sic.common.setFormVaule("../blog/knowledge/get.nut?font=true&id="+knowledgeId, false);
			sic.fromOther.getFromOther(knowledgeId,'KNOWLEDGE');
		}));
	</script>
  </body>
</html>
