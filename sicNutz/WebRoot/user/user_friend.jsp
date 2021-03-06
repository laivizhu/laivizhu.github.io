<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 朋友管理</title>
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
					  <li class="active"><a href="#myFriendList" data-toggle="tab">我的朋友</a></li>
					  <li><a href="#searchFriend" data-toggle="tab">查找朋友</a></li>
					  <li><a href="#friendMessage" data-toggle="tab">朋友消息管理</a></li>
					</ul>
					<div class='tab-content'>
						<div class='tab-pane fade in active' id='myFriendList'>
							<div class="row" id="friendListDivId">
								
							</div>
						</div>
						<div class='tab-pane fade' id='searchFriend'>
							<div class="row">
								<div class="span8" align="center">
									<input type="text" id="searchWord" class="search-query" style="height:30px;width:400px;"/>
									<button type="button" class="btn btn-success" onclick="searchFriend()">搜索</button>
								</div>
								<div class="span8 row" id="searchFriendListDivId">
								</div>
      						</div>
						</div>
						<div class='tab-pane fade' id='friendMessage'>
							<div class="row" id="messageListDivId">
								
							</div>
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
    
    
    <script type="text/javascript" src="../js/jquery/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="../js/common/laivi-typeahead.js"></script>
	<script  src="../kindeditor/kindeditor-min.js"></script>
	<script  src="../kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript" src="../js/common/navigate.js"></script>
	<script type="text/javascript">
		$(document).ready(sic.basic.init(function(){
			loadLocalNavigate(navigate.user);
			new LaiviTypeahead({
				url:'../user/friend/listAllFriendsName.nut',
				object:'#searchWord'
			});
			$('#myTab a').click(function (e) {
			  e.preventDefault();
			  $(this).tab('show');
			});
			
			sic.pageLoding.pageLoad('../user/friend/listUserFriends.nut', $("#friendListDivId"), function(item){
				return "<div class='span2'><p>"+item.friend.name+"</p><p><div align='right'><button class='btn' onclick=deleteObject('friend_delete.action?id="+item.id+"')><i class='icon-remove-circle'></i>删除</button></div></p></div>";
			});
			
			sic.pageLoding.pageLoad('../common/message/listFriendMessage.nut', $("#messageListDivId"), function(item){
				return "<div class='span2'><p><h5>"+item.title+"</h5></p><p>"+item.content+"</p><p><div align='right'><button type='button' class='btn btn-success' onclick=confirmMsg("+item.id+",'DOUBLE')>同意</button>&nbsp;&nbsp;&nbsp;<button type='button' class='btn-warning' onclick=confirmMsg("+item.id+",'REJECT')>拒绝</button></div></p></div>";
			});
		}));
		
		var confirmMsg=function(id,status){
			var msg='确认要';
			if(status=='REJECT'){
				msg=msg+'拒绝';
			}else{
				msg=msg+'同意';
			}
			sic.msg.confirm(msg, function(){
				sic.common.getJson('../user/friend/confirm.nut?id='+id+'&friend.direction='+status, function(){
					window.location.reload();
				});	
			});
		};
		
		var searchFriend=function(){
			var searchWord=$("#searchWord").val();
			if(sic.common.isNotNull(searchWord, '请输入搜索用户名')){
				sic.common.getJson('../user/search.nut?key=name&value='+searchWord, function(result){
					$("#searchFriendListDivId").html("");
					$.each(result.root,function(i,item){
						$("#searchFriendListDivId").append("<div class='span2'><p>"+item.name+"</p><p><div align='right'><a class='btn' onclick=deleteObject('../user/friend/add.nut?friend.friendId="+item.id+"','确认要添加用户')><i class='icon-plus'></i>加为好友</a></div></p></div>");
					});
				});
			}
		};
	</script>
  </body>
</html>
