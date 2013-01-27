<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi 网站</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/datepicker.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/docs.css"/>
    <link rel="stylesheet" type="text/css" href="../css/jbox_Green/jbox.css"/>
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="/knowledge/index.jsp" target="_parent">Laivi 网站</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="/knowledge/index.jsp" target="_parent">首页</a></li>
              <li><a href="#">论坛</a></li>
              <li><a href="/knowledge/picture/picture.jsp" target="_parent">记忆点滴</a></li>
              <li><a href="/knowledge/shopping/shopping.jsp" target="_parent">商城</a></li>
              <li><a href="/knowledge/knowledge/article.jsp" target="_parent">博客</a></li>
              <li><a href="/knowledge/knowledge/knowledge.jsp" target="_parent">知识</a></li>
            </ul>
            <s:if test="#session.user==null">
            	<div>
				    <form id="loginFormId" class="navbar-form pull-right" action="user_login.action">
		              <input class="input-medium" type="text" name="user.account" placeholder="Account">
		              <input class="input-medium" type="password" name="user.password" placeholder="Password">
		              <button type="button" class="btn btn-small" onclick="userLogin()">Login</button>
		            </form>
            	</div>
            </s:if>
            <s:else>
            	<div class="nav-collapse collapse">
	            	<ul class="nav pull-right">
	            		<li><a href='/knowledge/user/user.jsp?id=<s:property value="#session.user.id"/>' target="_parent"><s:property value="#session.user.userName"/></a></li>
	            		<li><a href="../user_logout.action" target="_parent">注销</a></li>
	            	</ul>
            	</div>
            </s:else>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="../js/jquery.jBox-zh-CN.js"></script>
	<script type="text/javascript" src="../js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="../js/basic.js"></script>
  </body>
</html>
