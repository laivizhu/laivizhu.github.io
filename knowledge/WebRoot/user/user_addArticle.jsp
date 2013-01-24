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
    <div class="container">
      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="span10">
      		<form action="article_add.action" id="articleAddFormId">
      			<input type="text" class="input-block-level" name="article.title" placeholder="博文题目">
      			<select id="tagSelectId" name="article.tagIds">
      				<option value='0'>--请选择标签--</option>
      			</select>
      			<textarea rows="12" style="width:100%" name="article.content" id='articleContentId'></textarea>
      			<div align='center'><p><button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-success">提交</button></p></div>
      		</form>
      </div>
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
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[id="articleContentId"]', {
					allowFileManager : true,
					afterBlur:function(){
						this.sync();
					}
				});
			});
			laivi.comboList($("#tagSelectId"), 'tag_comboList.action?tag.type=2');
			laivi.submitForm($("#articleAddFormId"), 'article_add.action', function(){
				window.location.href="user_article.jsp";
			}, false, false);
		});
	</script>
  </body>
</html>
