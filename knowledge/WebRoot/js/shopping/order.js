Ext.onReady(function(){
    var stores={
    		orderStore:new Fmp.JsonStore({
    			items:['id','code','totalPrice','createDate','user','status'],
    			url:'order_list.action'
    		}),
    		itemStore:new Fmp.JsonStore({
    			items:['id','name','price','count','category'],
    			url:'order_itemList.action'
    		}),
    		keyStore:new Fmp.ComboStore({
    			url:'order_getKeywordCombolList.action'
    		}),
    		itemKeyStore:new Fmp.ComboStore({
    			url:'shoppingItem_getKeywordCombolList.action'
    		})
    };

    var handler={
    	vieworder:function(){
    		var orderId=Fmp.getSelectedIds(orderGrid,true);
    		if(!Fmp.isEmpty(orderId)){
    			stores.itemStore.setUrl('order_itemList.action?id='+orderId);
    			stores.itemStore.load();
    			if(Fmp.getSelectedField(orderGrid,'status')!='购物中'){
    				//Ext.getCmp('removeButtonId').disable=true;
    				//Ext.getCmp('updateButtonId').disable=true;
    			}
    			win.show();
    		}
    	},
    	submitOrder:function(){
    		var orderId=Fmp.getSelectedIds(orderGrid,true);
    		if(!Fmp.isEmpty(orderId)){
    			if(Fmp.getSelectedField(orderGrid,'status')!='购物中'){
    				Fmp.alert('订单已经提交');
    				return;
    			}
    			Fmp.confirm('确认要提交订单吗？',function(){
    				Fmp.ajaxCall({
    					url:'order_commit.action?status=2&id='+orderId,
    					successHandler:function(){
    						stores.orderStore.load();
    					}
    				});
    			});
    		}
    	},
    	deleteorder:function(){
    		 var orderIds=Fmp.getSelectedIds(orderGrid,true);
             if(!Fmp.isEmpty(orderIds)){
            	 if(Fmp.getSelectedField(orderGrid,'status')!='购物中'){
     				Fmp.alert('订单已经提交');
     				return;
     			 }
            	 Fmp.confirm('确认要删除吗？',function(){
         			Fmp.ajaxCall({
                         url:'order_delete.action?id='+orderIds,
                         successHandler:function(){
                        	 stores.orderStore.loadPage();
                         }
                     });
         		});
             }
    	},
    	deleteItem:function(){
    		var orderId=Fmp.getSelectedIds(orderGrid,true);
    		var itemIds=Fmp.getSelectedIds(shoppingItemGrid,true);
            if(!Fmp.isEmpty(itemIds)){
           	 Fmp.confirm('确认要删除吗？',function(){
        			Fmp.ajaxCall({
                        url:'order_deleteShoppingItem.action?shoppingItemId='+itemIds+"&id="+orderId,
                        successHandler:function(){
                       	 stores.itemStore.load();
                        }
                    });
        		});
            }
    	},
    	updateItem:function(){
    		ItemForm.form.reset();
    		var itemId=Fmp.getSelectedIds(shoppingItemGrid,true);
            if(!Fmp.isEmpty(itemId)){
            	ItemForm.load({
                    url: 'shoppingItem_get.action?id='+itemId
                });
            	itemWin.show();
            }
    	}
    };
    
    var toolbar = new Ext.Toolbar([
        {text : '查看订单',iconCls:'add',handler:function(){
        		handler.vieworder();
        	}
        },
    	{text : '删除订单',iconCls:'remove',handler:function(){
    			handler.deleteorder();
    		}
    	},{
	   		text:'提交订单',iconCls:'save',handler:function(){
	   			handler.submitOrder();
	   		}
	   	},
    	getSearchCom(stores.keyStore,'order_search.action',stores.orderStore)
    ]);
    
    var cb = new Ext.grid.CheckboxSelectionModel();
    var orderGrid=new Fmp.GridPanel({
        renderTo: 'orderListDivId',height:document.body.clientHeight,tbar : toolbar,sm : cb,store:stores.orderStore,
        showRowNum:true, showPaging:true,
        columns:[
            cb,
             GridColumnObject('订单号','code'),
             GridColumnObject('订单总价格','totalPrice'),
             GridColumnObject('订单用户','user'),
             GridColumnObject('订单状态','status'),
             GridColumnObject('订单创建时间','createDate')
        ]
    });
    stores.orderStore.loadPage();
    
    var itemToolbar = new Ext.Toolbar([
	    {text : '删除商品',iconCls:'remove',id:'removeButtonId',handler:function(){
	       		handler.deleteItem();
	       	}
	    },
	   	{text : '修改订购商品',iconCls:'update',id:'updateButtionId',handler:function(){
	   			handler.updateItem();
	   		}
	   	}
	 ]);
    var itemCb=new Ext.grid.CheckboxSelectionModel();
    var shoppingItemGrid=new Fmp.GridPanel({
    	height:350,sm:itemCb,store:stores.itemStore,tbar:itemToolbar,
    	showRowNum:true,
    	columns:[
    	    itemCb,
    	    GridColumnObject('商品名','name'),
    	    GridColumnObject('商品类别','category'),
    	    GridColumnObject('订购数量','count'),
    	    GridColumnObject('订购单价','price')
    	]
    });
    var win = new Fmp.Window({title:'订单商品浏览',width:750,height:450,items:[shoppingItemGrid]});
    
    var ItemForm=new Fmp.FormPanel({
		items:[
		       {xtype:'fmp-number',field:'订购数量',name:'shoppingItem.count'},
		       {xtype:'fmp-hidden',name:'id'}
		],
		closeHandler:function(){
            itemWin.hide();
        },
        submitHandler:function(){
        	ItemForm.submit({
                url:'shoppingItem_update.action',
                successHandler:function(){
                	stores.itemStore.load();
                	stores.orderStore.loadPage();
                }
            });
        	itemWin.hide();
        }
	});
	var itemWin = new Fmp.Window({title:'商品数量修改',width:350,height:200,items:[ItemForm]});
});