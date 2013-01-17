<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi个人信息管理系统首页</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
   	<link rel="stylesheet" type="text/css" href="resources/css/ext-all.css" />
  	<link rel="stylesheet" type="text/css" href="resources/main.css" />
    <script type="text/javascript" src="js/ext-base.js"></script>
    <script type="text/javascript" src="js/ext-all.js"></script>
    <script type="text/javascript" src="js/XmlTreeLoader.js"></script>
    <script type="text/javascript" src="js/xml-tree-loader.js"></script>
  	<script type="text/javascript" src="js/tree-loader.js"></script>
	<script type="text/javascript">
		var panelItems = new Array();
		panelItems.push(treePanel('信息查询',
			parentNode('各类信息查询',
				parentNode('错误知识查询',
					leafNode('错误记录查询', 'search/search.jsp', '错误知识的查询')))
		));
		panelItems.push(treePanel('信息记录管理',
			parentNode('各类信息记录管理',
				parentNode('标签管理',
					leafNode('标签管理', 'knowledge/tag.jsp', '信息标签的相关操作')),
				parentNode('信息记录管理',
					leafNode('信息记录的管理','knowledge/knowledge.jsp','信息记录的添加，删除和查看')),
				parentNode('博客文章管理',
					leafNode('博客文章的管理','knowledge/article.jsp','博客文章的添加，删除和查看')),
				parentNode('图片管理',
					leafNode('图片管理', 'knowledge/picture_add.jsp', '图片的相关操作')))
		));
		panelItems.push(treePanel('商店管理',
			parentNode('商品信息管理',
				parentNode('商品管理',
					leafNode('商品类别管理', 'shopping/category.jsp', '商品类别的相关操作')))
		));
		panelItems.push(treePanel('系统管理',
			parentNode('系统管理',
				parentNode('用户权限分配管理',
					leafNode('用户信息管理', 'usermanage/usermanage.jsp', '用户的浏览，添加和删除等操作')),
				parentNode('系统信息管理',
					leafNode('系统公告信息管理', 'system/information.jsp', '系统公告信息的相关操作'),
					leafNode('查看系统公告信息', 'system/information_list.jsp', '查看系统公告信息')))
		));
		
	</script>
    <script src="js/main.js"></script>
	<script type="text/javascript">
		Ext.onReady(function(){
			Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
			Ext.QuickTips.init();
			new Ext.Viewport({ layout: 'border', items: [headerPanel, treePanel, mainPanel ] });
		});
    </script>
  </head>
  <body>
  <div id="header" >
  	<a href="<c:url value='/user_logout.action' />" title="安全退出系统" >
		<img src="resources/images/exit.gif" style="width:83px;height:24px;margin-top:1px; float:right; "/>
	</a>
	<div class="top-title">
		<h1>信息管理系统</h1>
	</div>
  </div>
  <input type="hidden" id="loginusername" value="<sec:authentication property='name'/>">
	<div id="welcome">欢迎您,
    <font color="#ff0000" size="+1"><s:property value="#session.user.userName"/></font>
	</div>
  </body>
</html>
