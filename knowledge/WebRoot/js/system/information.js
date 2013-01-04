Ext.onReady(function(){
    var stores={
    		knowledgeStore:new Fmp.JsonStore({
    			items:['id','title','question','content','tags'],
    			url:'knowledge_list.action'
    		}),
    		tagStore:new Fmp.ComboStore({
    			url:'tag_comboList.action?tag.type=1'
    		})
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
                         url:'knowledge_delete.action?knowledgeIds='+knowledgeIds,
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
    	}
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
             GridColumnObject('标签','tags')
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