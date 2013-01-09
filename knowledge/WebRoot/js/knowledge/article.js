Ext.onReady(function(){
    var stores={
    		articleStore:new Fmp.JsonStore({
    			items:['id','title','content','tagIds','createDate'],
    			url:'article_list.action'
    		}),
    		tagStore:new Fmp.ComboStore({
    			url:'tag_comboList.action?tag.type=2'
    		}),
    		keyStore:new Fmp.ComboStore({
    			url:'article_getKeywordCombolList.action'
    		}),
    };

    var handler={
    	addarticle:function(){
    		articleForm.form.reset();
    		articleForm.isAdd = true;
		    win.setTitle("新增文章");
		    win.show();
    	},
    	deletearticle:function(){
    		 var articleIds=Fmp.getSelectedIds(articleGrid);
             if(!Fmp.isEmpty(articleIds)){
            	 Fmp.confirm('确认要删除吗？',function(){
         			Fmp.ajaxCall({
                         url:'article_deletes.action?ids='+articleIds,
                         successHandler:function(){
                        	 stores.articleStore.loadPage();
                         }
                     });
         		});
             }
    	},
    	updatearticle:function(){
    		articleForm.form.reset();
    		articleForm.isAdd = false;
		    win.setTitle("修改文章");
		    var articleId=Fmp.getSelectedIds(articleGrid,true);
            if(!Fmp.isEmpty(articleId)){
            	articleForm.load({
                    url: 'article_get.action?id='+articleId
                });
		        win.show();
            }
    	}
    };
    
    var toolbar = new Ext.Toolbar([
        {text : '新增文章',iconCls:'add',handler:function(){
        		handler.addarticle();
        	}
        },
        {text : '修改文章',iconCls:'update',handler:function(){
    			handler.updatearticle();
        	}
    	},
    	{text : '删除文章',iconCls:'remove',handler:function(){
    			handler.deletearticle();
    		}
    	},getSearchCom(stores.keyStore,'article_search.action',stores.articleStore)
    ]);
    
    var cb = new Ext.grid.CheckboxSelectionModel();
    var articleGrid=new Fmp.GridPanel({
        renderTo: 'articleListDivId',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:stores.articleStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('文章标题','title'),
             GridColumnObject('文章内容','content'),
             GridColumnObject('标签','tagIds'),
             GridColumnObject('创建时间','createDate')
        ]
    });
    stores.articleStore.loadPage();		
	
    var articleForm=new Fmp.FormPanel({
        items:[
            {xtype:'fmp-text', field:'文章名', name:'article.title'},
            {xtype:'fmp-lovcombo',field:'标签',name:'article.tagIds',store:stores.tagStore},
            {xtype:'fmp-htmleditor', field:'文章内容', name:'article.content',width:500,height:350},
            {xtype:'fmp-hidden',name:'id'}
        ],
        closeHandler:function(){
            win.hide();
        },
        submitHandler:function(){
            if(articleForm.isAdd){
            	articleForm.submit({
                     url:'article_add.action',
                     successHandler:function(){
                    	 stores.articleStore.loadPage();
                     }
                 });
            }else{
            	articleForm.submit({
                     url:'article_update.action',
                     successHandler:function(){
                    	 stores.articleStore.loadPage();
                     }
                 });
            }
            win.hide();
        }
    });
	//创建弹出窗口
	var win = new Fmp.Window({width:800,height:500,items:[articleForm]});
});