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
  </head>
  <body>
    <jsp:include page="../common/navigate.jsp"/>
    <div class="container">
		<div class="row">
			<jsp:include page="../common/navigate_left.jsp"/>
		    <div class="span9">
		    	<!-- Main hero unit for a primary marketing message or call to action -->
		    	<div style="position: fixed; float: right;width:100px;height:60px; right:10px;" >
		    		<ul class="nav nav-pills">
						      <li>
						        <a href="user_addKnowledge.jsp" class="btn">记录知识</a>
						      </li>
					    </ul>
				</div>

			    <div class="row">
			    	<div class="span8" align="center" style="margin-top: 30px;">
						<input type="text" id="searchWord" class="search-query" style="height:30px;width:400px;"/>
						<button type="button" class="btn btn-success" onclick="searchKnowledge()">搜索</button>
					</div>
					<div class="row span8" id="knowledgeListDivId">
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
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script type="text/javascript" src="../js/common/navigate.js"></script>
	<script type="text/javascript">
		var getMoreData=function(id){
			sic.common.getJson('../blog/knowledge/get.nut?id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getLessData("+result.data.id+")'>Fold &raquo;</a>";
				$('#content'+id).html(result.data.answer+comb);
			});
		};
		var getLessData=function(id){
			sic.common.getJson('../blog/knowledge/get.nut?fold=true&id='+id, function(result){
				var comb="<a class='btn btn-primary btn-small' onclick='getMoreData("+result.data.id+")'>More &raquo;</a>";
				$('#content'+id).html(result.data.answer+comb);
			});
		};
		
		var searchKnowledge=function(){
			var searchWord=$("#searchWord").val();
			if(sic.common.isNotNull(searchWord, '请输入搜索文章关键字')){
				sic.common.getJson('../blog/knowledge/search.nut?key=title&value='+searchWord, function(result){
					$("#knowledgeListDivId").html("");
					$.each(result.root,function(i,item){
						$("#knowledgeListDivId").append("<div class='span8'><a href='../blog/knowledge_view.jsp?id="+item.id+"'><h4>"+item.title+"</h4></a><p><div align='right'>"+item.createDate+" 作者："+item.user+"</div></p><p id='content"+item.id+"'>"+item.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.id+")'>More &raquo;</a></p><div align='right'><p><a class='btn' onclick=deleteObject('../blog/knowledge/remove.nut?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a>|<a class='btn' href='user_addKnowledge.jsp?id="+item.id+"'><i class='icon-edit'></i>编辑</a></p></div></div>");
					});
				});
				
			}
		};
		
		$(document).ready(sic.basic.init(function(){
			loadLocalNavigate(navigate.user);
			new LaiviTypeahead({
				url:'../blog/knowledge/listAllTitle.nut',
				object:'#searchWord'
			});
			/*laivi.scrollBreakPage('article_list.action', $("#articleListDivId"), function(item){
				return "<div class='span8'><a href='../knowledge/article_view.jsp?id="+item.id+"'><h4>"+item.title+"</h4></a><p id='content"+item.id+"'>"+item.content+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.id+")'>More &raquo;</a></p><div align='right'><p>"+item.createDate+"|"+item.user+"<a class='btn' onclick=deleteObject('article_delete.action?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a>|<a class='btn' href='user_addArticle.jsp?id="+item.id+"'><i class='icon-edit'></i>编辑</a></p></div></div>";
			});*/
            sic.pageLoding.pageLoad('../blog/knowledge/list.nut', $("#knowledgeListDivId"), function(item){
                return "<div class='span8'><a href='../blog/knowledge_view.jsp?id="+item.id+"'><h4>"+item.title+"</h4></a><p>"+item.question+"</p><p id='content"+item.id+"'>"+item.answer+"<a class='btn btn-primary btn-small' onclick='getMoreData("+item.id+")'>More &raquo;</a></p><div align='right'><p>"+item.createDate+"|"+item.user.name+"<a class='btn' onclick=deleteObject('../blog/knowledge/remove.nut?id="+item.id+"')><i class='icon-remove-circle'></i>删除</a>|<a class='btn' href='user_addKnowledge.jsp?id="+item.id+"'><i class='icon-edit'></i>编辑</a></p></div></div>";
            });
		}));
	
	</script>
  </body>
</html>