Ext.onReady(function(){
    var stores={
    		albumStore:new Fmp.JsonStore({
    			items:['id','name','description','user','type','createDate'],
    			url:'album_list.action'
    		}),
    		typeStore:new Fmp.ComboStore({
    			url:'album_typeList.action'
    		}),
    		keyStore:new Fmp.ComboStore({
    			url:'album_getKeywordCombolList.action'
    		})
    };

    var handler={
    	addalbum:function(){
    		albumForm.form.reset();
    		albumForm.isAdd = true;
		    win.setTitle("新增专辑");
		    win.show();
    	},
    	deletealbum:function(){
    		 var albumIds=Fmp.getSelectedIds(albumGrid);
             if(!Fmp.isEmpty(albumIds)){
            	 Fmp.confirm('确认要删除吗？',function(){
         			Fmp.ajaxCall({
                         url:'album_deletes.action?ids='+albumIds,
                         successHandler:function(){
                        	 stores.albumStore.loadPage();
                         }
                     });
         		});
             }
    	},
    	updatealbum:function(){
    		albumForm.form.reset();
    		albumForm.isAdd = false;
		    win.setTitle("修改专辑");
		    var albumId=Fmp.getSelectedIds(albumGrid,true);
            if(!Fmp.isEmpty(albumId)){
            	albumForm.load({
                    url: 'album_get.action?id='+albumId
                });
		        win.show();
            }
    	}
    };
    
    var toolbar = new Ext.Toolbar([
        {text : '新增专辑',iconCls:'add',handler:function(){
        		handler.addalbum();
        	}
        },
        {text : '修改专辑',iconCls:'update',handler:function(){
    			handler.updatealbum();
        	}
    	},
    	{text : '删除专辑',iconCls:'remove',handler:function(){
    			handler.deletealbum();
    		}
    	},
    	getSearchCom(stores.keyStore,'album_search.action',stores.albumStore)
    ]);
    
    var cb = new Ext.grid.CheckboxSelectionModel();
    var albumGrid=new Fmp.GridPanel({
        renderTo: 'albumListDivId',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:stores.albumStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('专辑名','name'),
             GridColumnObject('专辑类型','type'),
             GridColumnObject('专辑描述','description'),
             GridColumnObject('用户','user'),
             GridColumnObject('创建时间','createDate')
        ]
    });
    stores.albumStore.loadPage();		
	
    var albumForm=new Fmp.FormPanel({
        items:[
            {xtype:'fmp-text', field:'专辑名', name:'album.name'},
            {xtype:'fmp-combo',field:'专辑类型',name:'album.type',store:stores.typeStore},
            {xtype:'fmp-htmleditor', field:'专辑描述', name:'album.description',width:600,height:250},
            {xtype:'fmp-hidden',name:'id'}
        ],
        closeHandler:function(){
            win.hide();
        },
        submitHandler:function(){
            if(albumForm.isAdd){
            	albumForm.submit({
                     url:'album_add.action',
                     successHandler:function(){
                    	 stores.albumStore.loadPage();
                     }
                 });
            }else{
            	albumForm.submit({
                     url:'album_update.action',
                     successHandler:function(){
                    	 stores.albumStore.loadPage();
                     }
                 });
            }
            win.hide();
        }
    });
	//创建弹出窗口
	var win = new Fmp.Window({width:800,height:450,items:[albumForm]});
});