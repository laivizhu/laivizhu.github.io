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
      		<form action="knowledge_add.action" id="knowledgeAddFormId">
      			<input type="text" class="input-block-level" name="knowledge.title" id="titleFormFieldId">
      			<select id="tagSelectId" name="knowledge.tagIds" id="tagIdsFormFieldId">
      				<option value='0'>--请选择--</option>
      			</select>
      			<textarea rows="20" style="width:100%" name="knowledge.question" id='questionContentId'></textarea>
      			<textarea rows="20" style="width:100%" name="knowledge.content" id='knowledgeContentId'></textarea>
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
			var editor;
			var editor1;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[id="knowledgeContentId"]', {
					allowFileManager : true,
					afterBlur:function(){
						this.sync();
					}
				});
				editor1 = K.create('textarea[id="questionContentId"]', {
					allowFileManager : true,
					afterBlur:function(){
						this.sync();
					}
				});
			});
			laivi.comboList($("#tagSelectId"), 'tag_comboList.action?tag.type=KNOWLEDGE');
			var id=laivi.getUrlVar('id');
			if(id!=null&&id!=0){
				$("#titleContentId").html("修改知识");
				laivi.setFormVaule('knowledge_get.action?font=true&fold=false&id='+id,true,function(result){
					editor.html(result.data.content);
					editor1.html(result.data.question);
				});
				laivi.submitForm($("#knowledgeAddFormId"), 'knowledge_update.action?id='+id, function(){
					window.location.href="user_knowledge.jsp";
				}, false, false);
			}else{
				$("#titleContentId").html("新建知识");
				laivi.submitForm($("#knowledgeAddFormId"), 'knowledge_add.action', function(){
					window.location.href="user_knowledge.jsp";
				}, false, false);
			}
			
		}));
	</script>
  </body>
</html>
