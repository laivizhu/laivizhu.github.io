Ext.onReady(function(){
    var stores={
    		informationStore:new Fmp.JsonStore({
    			items:['id','title','content','createDate','user','level'],
    			url:'information_list.action'
    		}),
    		levelStore:new Fmp.ComboStore({
    			url:'information_typeList.action'
    		}),
    		keyStore:new Fmp.ComboStore({
    			url:'information_getKeywordCombolList.action'
    		}),
    };

    var handler={
    	addKnowledge:function(){
    		informationForm.form.reset();
    		informationForm.isAdd = true;
		    win.setTitle("新增信息");
		    win.show();
    	},
    	deleteKnowledge:function(){
    		 var informationIds=Fmp.getSelectedIds(informationGrid);
             if(!Fmp.isEmpty(informationIds)){
            	 Fmp.confirm('确认要删除吗？',function(){
         			Fmp.ajaxCall({
                         url:'information_deletes.action?ids='+informationIds,
                         successHandler:function(){
                        	 stores.informationStore.loadPage();
                         }
                     });
         		});
             }
    	},
    	updateKnowledge:function(){
    		informationForm.form.reset();
    		informationForm.isAdd = false;
		    win.setTitle("修改信息");
		    var informationId=Fmp.getSelectedIds(informationGrid,true);
            if(!Fmp.isEmpty(informationId)){
            	informationForm.load({
                    url: 'information_get.action?id='+informationId
                });
		        win.show();
            }
    	}
    };
    
    var toolbar = new Ext.Toolbar([
        {text : '新增信息',iconCls:'add',handler:function(){
        		handler.addKnowledge();
        	}
        },
        {text : '修改信息',iconCls:'update',handler:function(){
    			handler.updateKnowledge();
        	}
    	},
    	{text : '删除信息',iconCls:'remove',handler:function(){
    			handler.deleteKnowledge();
    		}
    	},getSearchCom(stores.keyStore,'information_search.action',stores.informationStore)
    ]);
    
    var cb = new Ext.grid.CheckboxSelectionModel();
    var informationGrid=new Fmp.GridPanel({
        renderTo: 'informationListDivId',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:stores.informationStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('信息标题','title'),
             GridColumnObject('信息内容','content'),
             GridColumnObject('发布日期','createDate'),
             GridColumnObject('发布人','user'),
             GridColumnObject('信息情况等级','level')
        ]
    });
    stores.informationStore.loadPage();		
	
    var informationForm=new Fmp.FormPanel({
        items:[
            {xtype:'fmp-text', field:'信息名', name:'information.title'},
            {xtype:'fmp-combo',field:'标签',name:'information.level',store:stores.levelStore},
            {xtype:'fmp-htmleditor', field:'信息内容', name:'information.content',width:500},
            {xtype:'fmp-hidden',name:'id'}
        ],
        closeHandler:function(){
            win.hide();
        },
        submitHandler:function(){
            if(informationForm.isAdd){
            	informationForm.submit({
                     url:'information_add.action',
                     successHandler:function(){
                    	 stores.informationStore.loadPage();
                     }
                 });
            }else{
            	informationForm.submit({
                     url:'information_update.action',
                     successHandler:function(){
                    	 stores.informationStore.loadPage();
                     }
                 });
            }
            win.hide();
        }
    });
	//创建弹出窗口
	var win = new Fmp.Window({width:700,height:300,items:[informationForm]});
});