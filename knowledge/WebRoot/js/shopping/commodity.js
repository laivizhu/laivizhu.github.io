Ext.onReady(function(){
    var stores={
    		commodityStore:new Fmp.JsonStore({
    			items:['id','name','category','saveCount','price','description'],
    			url:'commodity_list.action'
    		}),
    		rootStore:new Fmp.ComboStore({
    			url:'category_parentList.action?category.level=2'
    		}),
    		secondStore:new Fmp.ComboStore({}),
    		categoryStore:new Fmp.ComboStore({}),
    		keyStore:new Fmp.ComboStore({
    			url:'commodity_getKeywordCombolList.action'
    		}),
    };

    var handler={
    	addcommodity:function(){
    		commodityForm.form.reset();
    		Ext.getCmp('secondComboId').disable();
			Ext.getCmp('categoryComboId').disable();
    		commodityForm.isAdd = true;
		    win.setTitle("新增商品");
		    win.show();
    	},
    	deletecommodity:function(){
    		 var commodityIds=Fmp.getSelectedIds(commodityGrid);
             if(!Fmp.isEmpty(commodityIds)){
            	 Fmp.confirm('确认要删除吗？',function(){
         			Fmp.ajaxCall({
                         url:'commodity_deletes.action?ids='+commodityIds,
                         successHandler:function(){
                        	 stores.commodityStore.loadPage();
                         }
                     });
         		});
             }
    	},
    	updatecommodity:function(){
    		commodityForm.form.reset();
    		Ext.getCmp('secondComboId').enable();
			Ext.getCmp('categoryComboId').enable();
    		commodityForm.isAdd = false;
		    win.setTitle("修改商品");
		    var commodityId=Fmp.getSelectedIds(commodityGrid,true);
            if(!Fmp.isEmpty(commodityId)){
            	commodityForm.load({
                    url: 'commodity_get.action?id='+commodityId
                });
		        win.show();
            }
    	},
    	addFavorite:function(){
    		var commodityId=Fmp.getSelectedIds(commodityGrid,true);
            if(!Fmp.isEmpty(commodityId)){
            	Fmp.confirm('确认要添加到收藏夹吗？',function(){
         			Fmp.ajaxCall({
                         url:'favorite_add.action?favorite.type=COMMOTITY&id='+commodityId+'&favorite.title='+Ext.util.JSON.encode(Fmp.getSelectedField(commodityGrid,'title')),
                         successHandler:function(){
                        	 Fmp.alert("添加成功");
                         }
                     });
         		});
            }
    	},
    	addShoppingCard:function(){
    		 var commodityId=Fmp.getSelectedIds(commodityGrid,true);
             if(!Fmp.isEmpty(commodityId)){
            	 Fmp.confirm('确认要添加到购物车吗？',function(){
            		 Fmp.ajaxCall({
            			 url:'order_addShoppingItem?commodityId='+commodityId,
            			 successHandler:function(){
            				 Fmp.alert("添加成功");
            			 }
            		 });
            	 });
             }
    	}
    };
    
    var toolbar = new Ext.Toolbar([
        {text : '新增商品',iconCls:'add',handler:function(){
        		handler.addcommodity();
        	}
        },
        {text : '修改商品',iconCls:'update',handler:function(){
    			handler.updatecommodity();
        	}
    	},{
    		text : '删除商品',iconCls:'remove',handler:function(){
    			handler.deletecommodity();
    		}
    	},
    	{text : '添加到收藏夹',iconCls:'add',handler:function(){
				handler.addFavorite();
			}
    	},{
    		text:'加入购物车',iconCls:'shoppingCard',handler:function(){
    			handler.addShoppingCard();
    		}
    	},
    	getSearchCom(stores.keyStore,'commodity_search.action',stores.commodityStore)
    ]);
    
    var cb = new Ext.grid.CheckboxSelectionModel();
    var commodityGrid=new Fmp.GridPanel({
        renderTo: 'commodityListDivId',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:stores.commodityStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('商品名','name'),
             GridColumnObject('商品类别','category'),
             GridColumnObject('商品价格','price'),
             GridColumnObject('商品数量','saveCount'),
             GridColumnObject('商品描述','description')
        ]
    });
    stores.commodityStore.loadPage();		
	
    var commodityForm=new Fmp.FormPanel({
    	fileUpload:true,
        items:[
            {xtype:'fmp-text', field:'商品名', name:'commodity.name'},
            {xtype:'fmp-combo',field:'商品大类',name:'rootCategoryId',store:stores.rootStore,listeners:{
        		'select':function(combo,record,index){
        			if(record.get('value')==null ||record.get('value')==0){
        				Ext.getCmp('secondComboId').disable();
        				Ext.getCmp('categoryComboId').disable();
        			}else{
        				Ext.getCmp('secondComboId').enable();
        				Ext.getCmp('secondComboId').setUrl('category_childrenList?category.parentId='+record.get('value'));
        			}
        		}
            }},
            {xtype:'fmp-combo',id:'secondComboId',field:'商品二级类型',name:'secondCategoryId',disabled:true,store:stores.secondStore,listeners:{
        		'select':function(combo,record,index){
        			if(record.get('value')==null ||record.get('value')==0){
        				Ext.getCmp('categoryComboId').disable();
        			}else{
        				Ext.getCmp('categoryComboId').enable();
        				Ext.getCmp('categoryComboId').setUrl('category_childrenList?category.parentId='+record.get('value'));
        			}
        		}
        	}},
            {xtype:'fmp-combo',id:'categoryComboId',field:'商品类型',name:'categoryId',disabled:true,store:stores.categoryStore},
            {xtype:'fmp-text',field:'商品价格',name:'commodity.price'},
            {xtype:'fmp-number',field:'商品数量',name:'commodity.saveCount'},
            {xtype:'fmp-htmleditor',field:'商品描述',name:'commodity.description',width:500},
            {xtype:'fmp-file',field:'商品图片',name:'picture'},
            {xtype:'fmp-hidden',name:'id'}
        ],
        closeHandler:function(){
            win.hide();
        },
        submitHandler:function(){
            if(commodityForm.isAdd){
            	commodityForm.submit({
                     url:'commodity_add.action',
                     successHandler:function(){
                    	 stores.commodityStore.loadPage();
                     }
                 });
            }else{
            	commodityForm.submit({
                     url:'commodity_update.action',
                     successHandler:function(){
                    	 stores.commodityStore.loadPage();
                     }
                 });
            }
            win.hide();
        }
    });
	//创建弹出窗口
	var win = new Fmp.Window({width:650,height:450,items:[commodityForm]});
});