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
              <li><a href="#">论坛</a></li>
              <li><a href="#">记忆点滴</a></li>
              <li><a href="/knowledge/shopping/shopping.jsp">商城</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">信息记录 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="#">博客</a></li>
                  <li><a href="#">知识</a></li>
                  <li class="divider"></li>
                  <li class="nav-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
            </ul>
            <form class="navbar-form pull-right">
              <input class="span2" type="text" placeholder="userName">
              <input class="span2" type="password" placeholder="Password">
              <button type="submit" class="btn">登入</button>
            </form>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
