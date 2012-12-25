<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>登录 - 采购管理平台</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="css/login.css"/>
  <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
  <script type="text/javascript" src="js/jquery.form.js"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
        $("#loginForm").ajaxForm({
			url:"./system/login.action",
			beforeSubmit:validator,
			success:function(returnData){
					var data = $.parseJSON(returnData);
					if(data.success == true)
						window.location.href = "./workbench/index.jsp";
					else
						alert(data.msg);
				}
		});
    });
	
	function validator()
	{
		if($("#loginAccount").val() =="")
		{
			alert("账号不能为空");
			return false;
		}
		else if($("#password").val() == "")
		{
			alert("密码不能为空");
			return false;
		}
	}
  </script>
</head>

<body>

<div style="margin-top:300px; margin-left:100px; height:50px" >
</div>

<div class="login_div">
  <form id="loginForm" name="loginForm" method="post">
	<label class="login_label">帐 号</label>
	<input type="text" id="loginAccount" name="loginAccount" class="login_input"/>
	<label class="login_label">密 码</label>
	<input type="password" id="password" name="password" class="login_input"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="登 录" class="login_button"/>
</form>
</div>

<div class="login_copyright">
	<span style="color:#999">远景能源 版权所有 © 2012-2013</span>
</div>
</body>

</html>

