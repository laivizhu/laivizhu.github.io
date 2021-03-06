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

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
      	<h2 id="titleContentId"></h2>
      		<form action="article_add.action" id="articleAddFormId">
      			<input type="text" class="input-block-level" name="article.title" id="titleFormFieldId">
      			<select  name="article.tagId" id="tagIdFormFieldId">
      				<option value='0'>--请选择--</option>
      			</select>
      			<br>
      			<label class='radio inline'>
      				<input type="radio" name="article.auth"  value="PUBLIC" checked>公开（所有人可以看）
      			</label>
      			<label class='radio inline'>
      				<input type="radio" name="article.auth"  value="FRIEND">朋友可见（只有朋友可以看）
      			</label>
      			<label class='radio inline'>
      				<input type="radio" name="article.auth"  value="SELF">私有（只有自己可以看）
      			</label>
      			<textarea rows="17" style="width:100%" name="article.content" id='articleContentId'></textarea>
      			<div align='center'><p><button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-success">提交</button></p></div>
      		</form>
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
	<script  src="../kindeditor/kindeditor-min.js"></script>
	<script  src="../kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript">
		$(document).ready(sic.basic.init(function(){
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[id="articleContentId"]', {
					allowFileManager : true,
					afterBlur:function(){
						this.sync();
					}
				});
			});

			var id=sic.basic.getUrlVar('id');
			if(id!=null&&id!=0){
				$("#titleContentId").html("修改博文");
				sic.common.setFormVaule('../blog/article/get.nut?id='+id,true,function(result){
					editor.html(result.data.content);
					//$("input[@type=radio]").attr("checked",result.data.auth);
					sic.basic.setRadioValue("article.auth",result.data.auth);
                    sic.common.comboList($("#tagIdFormFieldId"), '../tag/comboList.nut?tag.type=ARTICLE',function(){
                        $("#tagIdFormFieldId").val(result.data.tag.id);
                    });
				});
				sic.common.submitForm($("#articleAddFormId"), '../blog/article/update.nut?article.id='+id, function(){
					window.location.href="user_article.jsp";
				}, false, false);
			}else{
				$("#titleContentId").html("发表博文");
                sic.common.comboList($("#tagIdFormFieldId"), '../tag/comboList.nut?tag.type=ARTICLE');
				sic.common.submitForm($("#articleAddFormId"), '../blog/article/add.nut', function(){
					window.location.href="user_article.jsp";
				}, false, false);
			}
		}));
	</script>
  </body>
</html>
