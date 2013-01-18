Ext.onReady(function(){
    var stores={
    		favoriteStore:new Fmp.JsonStore({
    			items:['id','title','type','createDate'],
    			url:'favorite_list.action'
    		}),
    		typeStore:new Fmp.ComboStore({
    			url:'favorite_typeList.action'
    		}),
    		keyStore:new Fmp.ComboStore({
    			url:'favorite_getKeywordCombolList.action'
    		}),
    };

    var handler={
    	addfavorite:function(){
    		
    	},
    	deletefavorite:function(){
    		 var favoriteIds=Fmp.getSelectedIds(favoriteGrid);
             if(!Fmp.isEmpty(favoriteIds)){
            	 Fmp.confirm('确认要删除吗？',function(){
         			Fmp.ajaxCall({
                         url:'favorite_deletes.action?ids='+favoriteIds,
                         successHandler:function(){
                        	 stores.favoriteStore.loadPage();
                         }
                     });
         		});
             }
    	},
    	updatefavorite:function(){
  
    	}
    };
    
    var toolbar = new Ext.Toolbar([
    	{text : '删除标签',iconCls:'remove',handler:function(){
    			handler.deletefavorite();
    		}
    	},getSearchCom(stores.keyStore,'favorite_search.action',stores.favoriteStore)
    ]);
    
    var cb = new Ext.grid.CheckboxSelectionModel();
    var favoriteGrid=new Fmp.GridPanel({
        renderTo: 'favoriteListDivId',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:stores.favoriteStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('标签名','name'),
             GridColumnObject('标签类型','type'),
             GridColumnObject('创建时间','createDate')
        ]
    });
    stores.favoriteStore.loadPage();		
});