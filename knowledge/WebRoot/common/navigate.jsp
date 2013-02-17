<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="/knowledge/index.jsp">Laivi 网站</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="/knowledge/index.jsp">首页</a></li>
              <li><a href="/knowledge/bbs/bbs.jsp">论坛</a></li>
              <li><a href="/knowledge/picture/picture.jsp">记忆点滴</a></li>
              <li><a href="/knowledge/music/music.jsp">音乐天地</a></li>
              <li><a href="/knowledge/shopping/shopping.jsp">商城</a></li>
              <li class="dropdown">
                <a href="/knowledge/knowledge/article.jsp" class="dropdown-toggle" data-toggle="dropdown">信息记录 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="/knowledge/knowledge/article.jsp">博客</a></li>
                  <li class="divider"></li>
                  <li class="nav-header">知识管理</li>
                  <li><a href="/knowledge/knowledge/knowledge.jsp">知识</a></li>
                </ul>
              </li>
            </ul>
            <s:if test="#session.user==null">
            	<div>
				    <form id="loginFormId" class="navbar-form pull-right" action="user_login.action">
		              <input class="input-medium" type="text" name="user.account" placeholder="Account">
		              <input class="input-medium" type="password" name="user.password" placeholder="Password">
		              <button type="button" class="btn btn-small" onclick="userLogin()">Login</button>
		              <button type="button" class="btn btn-small" onclick="userRegiest()">Create New</button>
		            </form>
		            
            	</div>
            </s:if>
            <s:else>
            	<div class="nav-collapse collapse">
	            	<ul class="nav pull-right">
	            		<li><a href='/knowledge/user/user.jsp?id=<s:property value="#session.user.id"/>'><s:property value="#session.user.userName"/></a></li>
	            		<li><a href="#" onclick="userLogout()">注销</a></li>
	            	</ul>
            	</div>
            </s:else>
            
           
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
    <div id="backTopDivId" style="display: none; width: 50px; height: 95px; position: fixed; left: 50%; top: 480px; margin-left: 600px; z-index: 100; text-align: center; cursor: pointer;">
    	<a href="#">
    		<img src='/knowledge/images/back-top.png' alt='返回顶部' title='返回顶部' border='0'>
    	</a>
    </div>

    <div id="backDivId" style="display: none;position: fixed; float: right;width:30px;height:60px;right:10px;top:550px;">
    	<button onclick="history.back()" class="btn btn-small btn-warning">back</button>
    </div>