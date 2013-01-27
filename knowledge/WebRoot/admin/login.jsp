<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
  String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Laivi个人信息管理系统登录页面</title>
<jsp:include page="../common/font_includeJs.jsp"/>
<script type="text/javascript">
Fmp.onReady(function() {
	var stores={
		roleStore:new Fmp.ComboStore({
			url:'user_roleList.action'
		})
	};

	var userForm = new Fmp.FormPanel({
    	items : [
			{xtype:'fmp-text', width: 200, field:'用户账号', name:'user.account'},
			{xtype:'fmp-text', width: 200, field:'密码', name:'user.password',inputType:'password',id:'password'},
			{xtype:'fmp-text', width: 200, field:'确认密码', name:'confirmPassword',inputType:'password',id:'confirmpassword',vtype: 'password',initialPassField: 'password'},
			{xtype:'fmp-textarea',width:200,field:'用户姓名',name : 'user.userName'},
			{xtype:'fmp-lovcombo',width:200,field:'角色',name:'user.roleId',store:stores.roleStore},
			{xtype:'fmp-textarea', width: 200, field:'个人描述', name:'user.description'}
    	],
	 	closeHandler:function(){
			win.hide();
	 	},
	  	submitHandler:function(){
            userForm.submit({
                url:'user_add.action' ,
                successHandler:function(){
                    win.hide();
                    Fmp.alert("注册成功");
                }
            });
	  	}
  	});
	var win=new Fmp.Window({items:[userForm], title:'用户注册申请', width:380, height:320});

	Ext.get('regiest').on('click', function() {
		userForm.form.reset();
		win.setTitle("用户注册申请");
		win.show();
	});

	Ext.get('remeberchecked').on('click', function(e, t, o) {
		if (t.checked) {
			var forgetForm =new Fmp.FormPanel({
				items : [
					{xtype:'fmp-text', width: 200, field:'用户账号', name:'user.userName'}
				],
				closeHandler:function(){
					forgetWin.destroy();
				},
				submitHandler:function(){
					forgetForm.submit({
						url:'user_forgetPassword.action',
						successHandler:function(){
							forgetWin.destroy();
							Fmp.alert('申请重置密码成功');
						}
					});
				}
			});
			var forgetWin=new Fmp.Window({items:[forgetForm],title:'密码重置',width:380,height:150});
			forgetWin.show();
		}
	});
	laivi.submitForm($("#loginFormId"), "user_loginAdmin.action", function(){
		window.location.href="index.jsp";
	}, false, false);
});

</script>

<style type="text/css">
  <!--
  body {
    margin-left: 0px;
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 0px;
    overflow: hidden;
  }

  .STYLE3 {
    color: #528311;
    font-size: 12px;
  }

  .STYLE4 {
    color: #42870a;
    font-size: 12px;
  }

  -->
</style>

</head>

<body>
<form id="loginFormId" action="user_loginAdmin.action" method="post">
  <table width="100%" height="100%">
    <tr>
      <td height="608" background="../images/login_03.gif">
        <table width="862" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="266" background="../images/login_04.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="95">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="424" height="95" background="../images/login_06.gif">&nbsp;</td>
                  <td width="183" background="../images/login_07.gif">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="21%" height="20">
                          <div align="center"><span class="STYLE3">账号</span></div>
                        </td>
                        <td width="79%" height="20">
                          <input type="text" name="user.account" class="text-input"></td>
                      </tr>
                      <tr>
                        <td height="20">
                          <div align="center"><span class="STYLE3">密码</span></div>
                        </td>
                        <td height="20"><input type="password" name="user.password" class="text-input"></td>
                      </tr>
                      <tr>
                        <td height="20" colspan="2" align="center">
                          <input type="checkbox" id='remeberchecked'/>
                          <span class="STYLE3">忘记密码</span></td>
                      </tr>
                      <tr>
                        <td height="30" align="center" colspan="2">
                          <input type="submit" class="btn21-blue" value="登录">
                          <input type="reset" class="btn21-blue" value="重置">
                          <input type="button" class="btn21-blue" value="注册" id='regiest'/>
                        </td>
                      </tr>

                    </table>
                  </td>
                  <td width="255" background="../images/login_08.gif">&nbsp;</td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td height="247" valign="top" background="../images/login_09.gif">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="22%" height="30">&nbsp;</td>
                  <td width="56%">&nbsp;</td>
                  <td width="22%">&nbsp;</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td height="30">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="44%" height="20">&nbsp;</td>
                        <td width="56%" class="STYLE4">&nbsp;</td>
                      </tr>
                    </table>
                  </td>
                  <td>&nbsp;</td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td bgcolor="#a2d962">&nbsp;</td>
    </tr>
  </table>
</form>
</body>
</html>
