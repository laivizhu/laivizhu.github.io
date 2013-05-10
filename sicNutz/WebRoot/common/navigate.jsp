<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
<!--
		var toDir=function(dir){
			var options = {			
				showHeight : 150,
				speed : 1000
			};
			if(dir=='top'){
				$("html,body").animate({scrollTop: 0}, options.speed);
			}else if(dir=='before'){
				history.back();
			}else{
				$("html,body").animate({scrollTop: $(document).height()-700}, options.speed);
			}
			
		};
//-->
</script>
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="/sicNutz/index.jsp">Laivi SIC</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="/sicNutz/index.jsp">首页</a></li>
              <li><a href="/sicNutz/bbs/bbs.jsp">论坛</a></li>
              <li><a href="/sicNutz/picture/picture.jsp">记忆点滴</a></li>
              <li><a href="/sicNutz/music/music.jsp">音乐天地</a></li>
              <li><a href="/sicNutz/book/book.jsp">书城</a></li>
              <li><a href="/sicNutz/shopping/shopping.jsp">商城</a></li>
              <li class="dropdown">
                <a href="/sicNutz/blog/article.jsp" class="dropdown-toggle" data-toggle="dropdown">信息记录 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="/sicNutz/blog/article.jsp">博客</a></li>
                  <li class="divider"></li>
                  <li class="nav-header">知识管理</li>
                  <li><a href="/sicNutz/blog/sicNutz.jsp">知识</a></li>
                </ul>
              </li>
              <li><a href="/sicNutz/aboutus/aboutus.jsp">关于我们</a></li>
            </ul>
            <c:choose>
            	<c:when test="${user==null}">
            		<div>
					    <form id="loginFormId" class="navbar-form pull-right" action="user_login.action">
			              <input class="input-medium" type="text" name="email" placeholder="Email">
			              <input class="input-medium" type="password" name="password" placeholder="Password">
			              <button type="button" class="btn btn-small" onclick="userLogin()">Login</button>
			              <button type="button" class="btn btn-small" onclick="userRegiest()">Create New</button>
			            </form>
            		</div>
            	</c:when>
            	<c:otherwise>
            		<div class="nav-collapse collapse">
	            	<ul class="nav pull-right">
	            		<li><a href='/sicNutz/user/user.jsp?id=<c:out value="${user.id}"/>'><c:out value="${user.email}"/></a></li>
	            		<li><a href="#" onclick="userLogout()">注销</a></li>
	            	</ul>
            		</div>
            	</c:otherwise>
            </c:choose>
    
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
    <div id="backTopDivId" style="display: none; width: 50px; height: 95px; position: fixed;top: 250px; right: 10px; z-index: 100; text-align: center; cursor: pointer;">
    	<p><a onclick="toDir('top')">
    		<img src='/sicNutz/images/back-top.png' alt='返回顶部' title='返回顶部' border='0'>
    	</a></p>
    	<p><a onclick="toDir('before')">
    		<img src='/sicNutz/images/back-before.png' alt='返回前一页' title='返回前一页' border='0'>
    	</a></p>
    	<p><a onclick="toDir('bottom')">
    		<img src='/sicNutz/images/back-bottom.png' alt='返回底部' title='返回底部' border='0'>
    	</a>
    	</p>
    </div>