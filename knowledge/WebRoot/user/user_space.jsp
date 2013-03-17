<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 商城</title>
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
		    <jsp:include page="../common/navigate_left.jsp"/>
		    <div class="span9">
		    	<!-- Main hero unit for a primary marketing message or call to action -->
			    	<div>
				        <ul class="nav nav-tabs" id="myTab">
						  <li class="active"><a href="#person" data-toggle="tab">个人动态</a></li>
						  <li><a href="#friends" data-toggle="tab">朋友动态</a></li>
						  <li><a href="#config" data-toggle="tab">空间配置</a></li>
						</ul>
						<div class='tab-content'>
							<div class='tab-pane fade in active' id='person'>
								<div class="row" >
									<div class="span8">
										<form id="autoGraphAddFormId">
											<textarea rows="5" style="width:100%" name="autoGraph.content" id="contentFormFieldId"></textarea>
											<div align='center'><p><button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-success">提交</button></p></div>
										</form>
									</div>
									<div class="span8 row" id="personListDivId">
									</div>
								</div>
								<hr>
							</div>
							<div class='tab-pane fade' id='friends'>
								<div class="row" id="friendsListDivId">
									
	      						</div>
							</div>
							<div class='tab-pane fade' id='config'>
								<p>Config</p>
							</div>
						</div>
			      	</div>
		     	
		      	
		      	
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
	<script type="text/javascript" src="../js/bootstrap/bootstrap-tab.js"></script>
	<script  src="../kindeditor/kindeditor-min.js"></script>
	<script  src="../kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
	<script type="text/javascript" src="../js/common/navigate.js"></script>
	<script type="text/javascript">
		$(document).ready(laivi.init(function(){
			loadLocalNavigate(navigate.user);
			$('#myTab a').click(function (e) {
			  e.preventDefault();
			  $(this).tab('show');
			});
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[id="contentFormFieldId"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'forecolor', 'hilitecolor','|', 'emoticons', 'image', 'link'],
					afterBlur:function(){
						this.sync();
					}
				});
			});
			laivi.submitForm($("#autoGraphAddFormId"),'autoGraph_add.action',function(){
				window.location.reload();
			},false,false);
			
			laivi.pageLoad('autoGraph_listFriendAutoGraph.action', $("#friendsListDivId"), function(item){
				return "<div class='span8'><p>"+item.content+"</p><p><div align='right'>"+item.createDate+"|"+item.user.userName+"</div></p></div>";
			});
			
			laivi.pageLoad('autoGraph_list.action', $("#personListDivId"), function(item){
				return "<div class='span8'><p>"+item.content+"</p><p><div align='right'>"+item.createDate+"|<a class='btn' onclick=deleteObject('autoGraph_delete.action?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a></div></p></div>";
			});
		}));
	</script>
  </body>
</html>
