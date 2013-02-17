Ext.onReady(function(){
    var stores={
    		knowledgeStore:new Fmp.JsonStore({
    			items:['id','title','question','content','tagIds','createDate'],
    			url:'knowledge_list.action'
    		}),
    		tagStore:new Fmp.ComboStore({
    			url:'tag_comboList.action?tag.type=1'
    		}),
    		keyStore:new Fmp.ComboStore({
    			url:'knowledge_getKeywordCombolList.action'
    		}),
    };

    var handler={
    	addKnowledge:function(){
    		knowledgeForm.form.reset();
    		knowledgeForm.isAdd = true;
		    win.setTitle("新增信息");
		    win.show();
    	},
    	deleteKnowledge:function(){
    		 var knowledgeIds=Fmp.getSelectedIds(knowledgeGrid);
             if(!Fmp.isEmpty(knowledgeIds)){
            	 Fmp.confirm('确认要删除吗？',function(){
         			Fmp.ajaxCall({
                         url:'knowledge_deletes.action?ids='+knowledgeIds,
                         successHandler:function(){
                        	 stores.knowledgeStore.loadPage();
                         }
                     });
         		});
             }
    	},
    	updateKnowledge:function(){
    		knowledgeForm.form.reset();
    		knowledgeForm.isAdd = false;
		    win.setTitle("修改信息");
		    var knowledgeId=Fmp.getSelectedIds(knowledgeGrid,true);
            if(!Fmp.isEmpty(knowledgeId)){
            	knowledgeForm.load({
                    url: 'knowledge_get.action?id='+knowledgeId
                });
		        win.show();
            }
    	},
    	addFavorite:function(){
    		var knowledgeId=Fmp.getSelectedIds(knowledgeGrid,true);
            if(!Fmp.isEmpty(knowledgeId)){
            	Fmp.confirm('确认要添加到收藏夹吗？',function(){
         			Fmp.ajaxCall({
                         url:'favorite_add.action?favorite.type=KNOWLEDGE&id='+knowledgeId+'&favorite.title='+Ext.util.JSON.encode(Fmp.getSelectedField(knowledgeGrid,'title')),
                         successHandler:function(){
                        	 Fmp.alert("添加成功");
                         }
                     });
         		});
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
    	},
    	{text : '添加到收藏夹',iconCls:'add',handler:function(){
				handler.addFavorite();
			}
    	},getSearchCom(stores.keyStore,'knowledge_search.action',stores.knowledgeStore)
    ]);
    
    var cb = new Ext.grid.CheckboxSelectionModel();
    var knowledgeGrid=new Fmp.GridPanel({
        renderTo: 'knowledgeListDivId',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:stores.knowledgeStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('信息标题','title'),
             GridColumnObject('信息问题','question'),
             GridColumnObject('信息解决方案','content'),
             GridColumnObject('标签','tagIds'),
             GridColumnObject('创建时间','createDate')
        ]
    });
    stores.knowledgeStore.loadPage();		
	
    var knowledgeForm=new Fmp.FormPanel({
        items:[
            {xtype:'fmp-text', field:'信息名', name:'knowledge.title'},
            {xtype:'fmp-lovcombo',field:'标签',name:'knowledge.tagIds',store:stores.tagStore},
            {xtype:'fmp-htmleditor', field:'信息问题', name:'knowledge.question',width:500},
            {xtype:'fmp-htmleditor', field:'信息解决方案', name:'knowledge.content',width:500},
            {xtype:'fmp-hidden',name:'id'}
        ],
        closeHandler:function(){
            win.hide();
        },
        submitHandler:function(){
            if(knowledgeForm.isAdd){
            	knowledgeForm.submit({
                     url:'knowledge_add.action',
                     successHandler:function(){
                    	 stores.knowledgeStore.loadPage();
                     }
                 });
            }else{
            	knowledgeForm.submit({
                     url:'knowledge_update.action',
                     successHandler:function(){
                    	 stores.knowledgeStore.loadPage();
                     }
                 });
            }

            win.hide();
        }
    });
	//创建弹出窗口
	var win = new Fmp.Window({width:800,height:500,items:[knowledgeForm]});
});