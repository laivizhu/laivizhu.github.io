Ext.onReady(function(){
    var stores={
    		tagStore:new Fmp.JsonStore({
    			items:['id','name','type','createDate'],
    			url:'tag_list.action'
    		}),
    		typeStore:new Fmp.ComboStore({
    			url:'tag_typeList.action'
    		}),
    		keyStore:new Fmp.ComboStore({
    			url:'tag_getKeywordCombolList.action'
    		}),
    };

    var handler={
    	addTag:function(){
    		tagForm.form.reset();
    		tagForm.isAdd = true;
		    win.setTitle("新增标签");
		    win.show();
    	},
    	deleteTag:function(){
    		 var tagIds=Fmp.getSelectedIds(tagGrid);
             if(!Fmp.isEmpty(tagIds)){
            	 Fmp.confirm('确认要删除吗？',function(){
         			Fmp.ajaxCall({
                         url:'tag_delete.action?tagIds='+tagIds,
                         successHandler:function(){
                        	 stores.tagStore.loadPage();
                         }
                     });
         		});
             }
    	},
    	updateTag:function(){
    		tagForm.form.reset();
    		tagForm.isAdd = false;
		    win.setTitle("修改标签");
		    var tagId=Fmp.getSelectedIds(tagGrid,true);
            if(!Fmp.isEmpty(tagId)){
            	tagForm.load({
                    url: 'tag_get.action?id='+tagId
                });
		        win.show();
            }
    	}
    };
    
    var toolbar = new Ext.Toolbar([
        {text : '新增标签',iconCls:'add',handler:function(){
        		handler.addTag();
        	}
        },
        {text : '修改标签',iconCls:'update',handler:function(){
    			handler.updateTag();
        	}
    	},
    	{text : '删除标签',iconCls:'remove',handler:function(){
    			handler.deleteTag();
    		}
    	},getSearchCom(stores.keyStore,'tag_search.action',stores.tagStore)
    ]);
    
    var cb = new Ext.grid.CheckboxSelectionModel();
    var tagGrid=new Fmp.GridPanel({
        renderTo: 'tagListDivId',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:stores.tagStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('标签名','name'),
             GridColumnObject('标签类型','type'),
             GridColumnObject('创建时间','createDate')
        ]
    });
    stores.tagStore.loadPage();		
	
    var tagForm=new Fmp.FormPanel({
        items:[
            {xtype:'fmp-text', field:'标签名', name:'tag.name'},
            {xtype:'fmp-combo',field:'标签类型',name:'tag.type',store:stores.typeStore},
            {xtype:'fmp-hidden',name:'id'}
        ],
        closeHandler:function(){
            win.hide();
        },
        submitHandler:function(){
            if(tagForm.isAdd){
            	tagForm.submit({
                     url:'tag_add.action',
                     successHandler:function(){
                    	 stores.tagStore.loadPage();
                     }
                 });
            }else{
            	tagForm.submit({
                     url:'tag_update.action',
                     successHandler:function(){
                    	 stores.tagStore.loadPage();
                     }
                 });
            }

            win.hide();
        }
    });
	//创建弹出窗口
	var win = new Fmp.Window({width:380,height:200,items:[tagForm]});
});