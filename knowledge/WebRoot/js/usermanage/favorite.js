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
    	}
    };
    
    var toolbar = new Ext.Toolbar([
    	{text : '删除收藏',iconCls:'remove',handler:function(){
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
             GridColumnObject('收藏标题','title'),
             GridColumnObject('收藏类型','type'),
             GridColumnObject('创建时间','createDate')
        ]
    });
    stores.favoriteStore.loadPage();		
});