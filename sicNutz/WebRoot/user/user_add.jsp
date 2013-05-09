<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Laivi注册</title>
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
		    	<form id="userAddFormId" class="form-signin">
					<table>
						<tr>
							<td>用户账号:</td>
							<td><input type="text" name="user.account" class="input-block-level"></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input type="password" name="user.password" class="input-block-level"></td>
						</tr>
						<tr>
							<td>确认密码:</td>
							<td><input type="password" name="confirmPassword" class="input-block-level"></td>
						</tr>
						<tr>
							<td>用户名:</td>
							<td><input type="text" name="user.userName" class="input-block-level"></td>
						</tr>
						<tr>
							<td>邮箱:</td>
							<td><input type="text" name="user.email" class="input-block-level"></td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<button type="reset" class="btn btn-warning">重置</button>
								&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-success">提交</button>
							</td>
						</tr>
					</table>
				</form>
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
			sic.common.submitForm($("#userAddFormId"), '../user/add.nut', function(){
				window.location.href="../index.jsp";
			}, false, false);
		}));
	</script>
  </body>
</html>
