<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 阅读</title>
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
		<div class="span12" align="center">
			<p>
				<button class="btn btn-small" onclick="jumpChapter('pre')"><i class="icon-arrow-left"></i>前一章</button>
				<button class="btn btn-small" onclick="jumpChapter('list')"><i class="icon-list"></i>返回目录</button>
				<button class="btn btn-small" onclick="jumpChapter('next')"><i class="icon-arrow-right"></i>下一章</button>
			</p>
		</div>
		<hr>
		<div class="span12" align="right">
				<p>
				   <button class="btn btn-small" onclick="addBookMark()" id='addMarkButtonId'><i class="icon-bookmark"></i>加入书签</button>
				</p>
		</div>
		<div class="span12">
			<input type='hidden' id="idFormFieldId">
			<h2 id="titleFormFieldId"></h2>
        	<p><label id="contentFormFieldId"></label></p>
		</div>
		<hr>
		<div class="span12" align="center">
			<p>
				<button class="btn btn-small" onclick="jumpChapter('pre')"><i class="icon-arrow-left"></i>前一章</button>
				<button class="btn btn-small" onclick="jumpChapter('list')"><i class="icon-list"></i>返回目录</button>
				<button class="btn btn-small" onclick="jumpChapter('next')"><i class="icon-arrow-right"></i>下一章</button>
			</p>
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
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript">
		$(document).ready(sic.basic.init(function(){
			var chapterId=sic.basic.getUrlVar("id");
			$('#idFormFieldId').val(chapterId);
			sic.common.setFormVaule("../media/chapter/get.nut?id="+chapterId, false);
			sic.common.getJson('../media/chapter/isAddMark.nut?id='+chapterId,function(result){
				if(result.data.isAddMark){
					sic.basic.setDisable($("#addMarkButtonId"));
				}else{
					sic.basic.setEnable($("#addMarkButtonId"));
				}
			});
		}));
		
		var jumpChapter=function(dir){
			var chapterId=$('#idFormFieldId').val();			
			if(dir!='list'){
				sic.common.setFormVaule('../media/chapter/getChapter.nut?id='+chapterId+'&dir='+dir, false,function(result){
					sic.common.getJson('../media/chapter/isAddMark.nut?id='+result.data.id,function(result){
						if(result.data.isAddMark){
							sic.basic.setDisable($("#addMarkButtonId"));
						}else{
							sic.basic.setEnable($("#addMarkButtonId"));
						}
					});
				});
				
				sic.common.jumpToTop();
			}else{
				history.back();
			}
		};
		var addBookMark=function(){
			var chapterId=$('#idFormFieldId').val();
			sic.common.getJson('../media/mark/add.nut?mark.chapterId='+chapterId, function(){
				sic.msg.alert('添加书签成功');
				sic.basic.setDisable($("#addMarkButtonId"));
			});
		};
	</script>
  </body>
</html>
