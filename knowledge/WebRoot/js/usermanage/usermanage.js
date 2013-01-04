Ext.onReady(function(){
    var store={
        userStore:new Fmp.JsonStore({
            items:['id','userName','account','enable','reset','description'],
            url:'user_list.action'
        }),
        roleStore:new Fmp.ComboStore({
            url:'user_roleList.action'
        }),
        userRoleStore:new Fmp.JsonStore({
            items:['id','name','description','type'],
            url:'user_userRoleList.action'
        })
    };

    var handler={
        addUser:function(){
            userForm.form.reset();
		    userForm.isAdd = true;
		    win.setTitle("新增用户信息");
		    win.show();
        },
        modifyUser:function(){
            userForm.form.reset();
		    userForm.isAdd = false;
		    win.setTitle("修改用户信息");
            var userId=Fmp.getSelectedIds(userGrid,true);
            if(!Fmp.isEmpty(userId)){
                userForm.load({
                    url: 'user_get.action?id='+userId
                });
		        win.show();
            }

        },
        deleteUser:function(){
            var userIds=Fmp.getSelectedIds(userGrid);
            if(!Fmp.isEmpty(userIds)){
                Ext.MessageBox.confirm("提示","您确定要删除所选用户吗？",function(btnId){
                    if(btnId == 'yes'){
                        Fmp.ajaxCall({
                            url:'user_delete.action?userIds='+userIds,
                            successHandler:function(){
                                  store.userStore.loadPage();
                            }
                        });
                    }
		        });
            }
        },
        disableUser:function(){
            var userIds=Fmp.getSelectedIds(userGrid);
            if(!Fmp.isEmpty(userIds)){
                Ext.MessageBox.confirm("提示","您确定要禁用或启用所选用户吗？",function(btnId){
                    if(btnId == 'yes'){
                        Fmp.ajaxCall({
                            url:'user_disableOrEnableUser.action?userIds='+userIds,
                            successHandler:function(){
                                  store.userStore.loadPage();
                            }
                        });
                    }
		        });
            }
        },
        resetUser:function(){
            var userIds=Fmp.getSelectedIds(userGrid);
            if(!Fmp.isEmpty(userIds)){
                Ext.MessageBox.confirm("提示","您确定要重置所选用户密码吗？",function(btnId){
                    if(btnId == 'yes'){
                        Fmp.ajaxCall({
                            url:'user_resetPassword.action?userIds='+userIds,
                            successHandler:function(){
                                  store.userStore.loadPage();
                            }
                        });
                    }
		        });
            }
        },
        distributeRole:function(){
            var userId=Fmp.getSelectedIds(userGrid,true);
            if(!Fmp.isEmpty(userId)){
                 var userRoleForm=new Fmp.FormPanel({
                     items:[
                         {
                            xtype:'fmp-combo',field:'角色分类:',mode:'local',allowBlank : false,
                            id:'userRoleComboId',
                            emptyText:'请选择查看用户是否拥有角色类型',
						    data:[
						      ['没有的角色', '0'],
						      ['拥有的角色', '1']
						    ]
                         }
                     ]
                 });
                var userRoleCb = new Ext.grid.CheckboxSelectionModel();
                var userRoleToolBar= new Ext.Toolbar([
                	{text : '给用户添加角色',iconCls:'add',
                        handler : function(){
                            handler.addUserRoles(userId,userRoleGrid);
                        }
                    },
              		{text : '删除用户角色',iconCls:'remove',
                         handler : function(){
                             handler.deleteUserRoles(userId,userRoleGrid);
                         }
                    }
                ]);
                Ext.getCmp("userRoleComboId").on("select",function(combox){
                    if(combox.getValue()==1){
                        store.userRoleStore.loadParam({type:1,id:userId});
                    }else{
                        store.userRoleStore.loadParam({type:0,id:userId});
                    }
			    });
                var userRoleGrid=new Fmp.GridPanel({
                    height:400,tbar : userRoleToolBar,sm : userRoleCb,store:store.userRoleStore,
                    showRowNum:true,
                    columns:[
                        userRoleCb,
                        GridColumnObject('角色名','name'),
                        GridColumnObject('角色描述','description'),
                        GridColumnObject('状态','type')
                    ]
                });
                var userRoleWin = new Fmp.Window({
                    layout : 'form',title:'用户角色分配表',
                    width:800, closeAction:'destroy', height:500,items:[userRoleForm,userRoleGrid]
                });
                store.userRoleStore.loadParam({type:1,id:userId});
                userRoleWin.show();
            }
        },
        addUserRoles:function(userId,roleGrid){
            var rolesId=Fmp.getSelectedIds(roleGrid,true);
            if(!Fmp.isEmpty(rolesId)){
                Ext.MessageBox.confirm("提示","确定要添加所选角色吗？",function(btnId){
				    if(btnId == 'yes'){
                         Fmp.ajaxCall({
                             url:'user_rolesAdd.action?id='+userId+"&rolesId="+rolesId
                         });
                        store.userRoleStore.loadParam({type:1,id:userId});
                    }
                });
            }
        },
        deleteUserRoles:function(userId,roleGrid){
            var rolesId=Fmp.getSelectedIds(roleGrid,true);
            if(!Fmp.isEmpty(rolesId)){
                Ext.MessageBox.confirm("提示","确定要删除所选角色吗？",function(btnId){
				    if(btnId == 'yes'){
                         Fmp.ajaxCall({
                             url:'user_rolesDelete.action?id='+userId+"&rolesId="+rolesId
                         });
                        store.userRoleStore.loadParam({type:0,id:userId});
                    }
                });
            }
        }
    }
	
	//创建工具栏组件
	var toolbar = new Ext.Toolbar([
		{text : '新增用户',iconCls:'add',
            handler : function(){
                $('user.account_field').enable();
                $('password').enable();
                $('password').show();
                $('confirmPassword').enable();
                $('confirmPassword').show();
                handler.addUser();
            }
        },
		{text : '修改用户',iconCls:'update',
            handler : function(){
                $('password').disable();
                $('password').hide();
                $('user.account_field').disable();
                $('confirmPassword').disable();
                $('confirmPassword').hide();
                handler.modifyUser();
            }
        },
		{text : '删除用户',iconCls:'remove',
            handler : function(){
                 handler.deleteUser();
            }
        },
		{text : '启用或禁用用户',iconCls:'deal',
            handler : function(){
                handler.disableUser();
            }
        },
		{text : '重置用户密码',iconCls:'deal',
            handler : function(){
                handler.resetUser();
            }
        },
		{text : '分配用户角色',iconCls:'distribute',
            handler : function(){
                handler.distributeRole();
            }
        }
	]);
	//创建Grid表格组件
	var cb = new Ext.grid.CheckboxSelectionModel();
    var userGrid=new Fmp.GridPanel({
        renderTo: 'userList',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:store.userStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('用户账号','account'),
             GridColumnObject('用户名','userName'),
             GridColumnObject('是否可用','enable',renderEnable),
             GridColumnObject('是否需要重置密码','reset',renderReset)
        ]
    });
    store.userStore.loadPage();
    var userForm=new Fmp.FormPanel({
        items:[
            {xtype:'fmp-text', field:'用户账号', name:'user.account'},
            {xtype:'fmp-text', field:'密码', name:'user.password',inputType:'password',id:'password'},
            {xtype:'fmp-text', field:'确认密码', name:'confirmPassword',inputType:'password',
                id:'confirmPassword',vtype: 'password',initialPassField: 'password'},
            {xtype:'fmp-text', field:'用户姓名', name:'user.userName'},
            {xtype:'fmp-lovcombo',store:store.roleStore,name:'rolesId',field:'角色'},
            {xtype:'fmp-textarea',name:'user.description',field:'个人描述',height: 100},
            {xtype:'fmp-hidden',name:'id'}
        ],
        closeHandler:function(){
            win.hide();
        },
        submitHandler:function(){
            if(userForm.isAdd){
                 userForm.submit({
                     url:'user_add.action',
                     successHandler:function(){
                         store.userStore.loadPage();
                     }
                 });
            }else{
                 userForm.submit({
                     url:'user_update.action',
                     successHandler:function(){
                         store.userStore.loadPage();
                     }
                 });
            }

            win.hide();
        }
    });
	//创建弹出窗口
	var win = new Fmp.Window({width:380,height:330,items:[userForm]});

	function renderEnable(enable){
		if(!enable){
			return "<font color='blue'>不可用</font>";
		}else{
			return "可用";
		}
	}
	
	function renderReset(reset){
		if(!reset){
			return "不需要重置";
		}else if(reset==1){
			return "<font color='red'>需要重置</font>";
		}
	}
});