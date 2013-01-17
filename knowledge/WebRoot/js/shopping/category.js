Ext.onReady(function(){
    var stores={
    		categoryStore:new Fmp.JsonStore({
    			items:['id','name','level','parent'],
    			url:'category_list.action?category.level=0'
    		}),
    		typeStore:new Fmp.ComboStore({
    			url:'category_typeList.action'
    		}),
    		parentStore:new Fmp.ComboStore({
    			url:'category_parentList.action'
    		}),
    		keyStore:new Fmp.ComboStore({
    			url:'category_getKeywordCombolList.action'
    		}),
    };

    var handler={
    	addcategory:function(){
    		categoryForm.form.reset();
    		Ext.getCmp('parentComboId').hide();
			Ext.getCmp('parentComboId').disable();
    		categoryForm.isAdd = true;
		    win.setTitle("新增商品类别");
		    win.show();
    	},
    	deletecategory:function(){
    		 var categoryIds=Fmp.getSelectedIds(categoryGrid);
             if(!Fmp.isEmpty(categoryIds)){
            	 Fmp.confirm('确认要删除吗？',function(){
         			Fmp.ajaxCall({
                         url:'category_deletes.action?ids='+categoryIds,
                         successHandler:function(){
                        	 stores.categoryStore.loadPage();
                         }
                     });
         		});
             }
    	},
    	updatecategory:function(){
    		categoryForm.form.reset();
    		categoryForm.isAdd = false;
		    win.setTitle("修改商品类别");
		    var categoryId=Fmp.getSelectedIds(categoryGrid,true);
            if(!Fmp.isEmpty(categoryId)){
            	categoryForm.load({
                    url: 'category_get.action?id='+categoryId
                });
		        win.show();
            }
    	}
    };
    
    var toolbar = new Ext.Toolbar([
        {text : '新增商品类别',iconCls:'add',handler:function(){
        		handler.addcategory();
        	}
        },
        {text : '修改商品类别',iconCls:'update',handler:function(){
    			handler.updatecategory();
        	}
    	},
    	{text : '删除商品类别',iconCls:'remove',handler:function(){
    			handler.deletecategory();
    		}
    	},getSearchCom(stores.keyStore,'category_search.action',stores.categoryStore)
    ]);
    
    var cb = new Ext.grid.CheckboxSelectionModel();
    var categoryGrid=new Fmp.GridPanel({
        renderTo: 'categoryListDivId',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:stores.categoryStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('商品类别名','name'),
             GridColumnObject('商品类别等级','level'),
             GridColumnObject('父类别','parent')
        ]
    });
    stores.categoryStore.loadPage();		
	
    var categoryForm=new Fmp.FormPanel({
        items:[
            {xtype:'fmp-text', field:'商品类别名', name:'category.name'},
            {xtype:'fmp-combo',field:'商品类别类型',name:'category.level',store:stores.typeStore,listeners:{
            	'select':function(combo,record,index){
            		if(record.get('value')==1||record.get('value')==null ||record.get('value')==0){
            			Ext.getCmp('parentComboId').hide();
            			Ext.getCmp('parentComboId').disable();
            		}else{
            			Ext.getCmp('parentComboId').show();
            			Ext.getCmp('parentComboId').enable();
            			Ext.getCmp('parentComboId').setUrl('category_parentList.action?category.level='+record.get('value'));
            		}
            	}
            }},
            {xtype:'fmp-combo',id:'parentComboId',field:'商品父类别',name:'category.parentId',store:stores.parentStore,hidden:true,disabled:true},
            {xtype:'fmp-hidden',name:'id'}
        ],
        closeHandler:function(){
            win.hide();
        },
        submitHandler:function(){
            if(categoryForm.isAdd){
            	categoryForm.submit({
                     url:'category_add.action',
                     successHandler:function(){
                    	 stores.categoryStore.loadPage();
                     }
                 });
            }else{
            	categoryForm.submit({
                     url:'category_update.action',
                     successHandler:function(){
                    	 stores.categoryStore.loadPage();
                     }
                 });
            }
            win.hide();
        }
    });
	//创建弹出窗口
	var win = new Fmp.Window({width:380,height:200,items:[categoryForm]});
});