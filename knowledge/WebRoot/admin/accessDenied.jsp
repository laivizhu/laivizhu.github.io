<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Access Denied</title>
    <style type="text/css">
div.error {
    width: 400px;
    border: 2px solid red;
    background-color: yellow;
    text-align: center;
}
    </style>
  </head>
  <body>
  
  <div align="center">
  	<h1>Access Denied</h1>
  	<hr>
  	<div id='error' class="error">
  		<h2>没有权限，访问拒绝！！！</h2>
  		${requestScope['SPRING_SECURITY_403_EXCEPTION'].message}
  	</div>
  </div>
    
  </body>
</html>

