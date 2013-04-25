Ext.namespace("LaiviExt");
var pagecount=25;
var formItemWidth=200;
var field=new Ext.form.Field();

var submitFailure = function(form, action) {
    switch (action.failureType) {
        case Ext.form.Action.CLIENT_INVALID:
        	LaiviExt.alert('信息不完整，操作失败');
            break;
        case Ext.form.Action.CONNECT_FAILURE:
        	LaiviExt.alertError('连接服务器异常');
            break;
        case Ext.form.Action.SERVER_INVALID:
        	LaiviExt.alertError(action.result.msg);
    }
};


LaiviExt.Label = Ext.extend(Ext.form.Label, {
	constructor : function(config) {
		config.width = config.width || formItemWidth;
		LaiviExt.Label.superclass.constructor.call(this);
	}
});
Ext.reg('laiviExt-label', LaiviExt.Label);


LaiviExt.TextField = Ext.extend(Ext.form.TextField, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.emptyText || (!config.allowBlank ? '请输入' + config.field : null);
		config.blankText = config.blankText || ('请输入' + config.field);
		config.fieldLabel = config.fieldLabel || config.field;
		LaiviExt.TextField.superclass.constructor.call(this, config);
	}
});
Ext.reg('laiviExt-text', LaiviExt.TextField);

LaiviExt.TextArea = Ext.extend(Ext.form.TextArea, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.emptyText || (!config.allowBlank ? '请输入' + config.field : null);
		config.blankText = config.blankText || ('请输入' + config.field);
		config.fieldLabel = config.fieldLabel || config.field;
		LaiviExt.TextArea.superclass.constructor.call(this, config);
	}
});
Ext.reg('laiviExt-textarea', LaiviExt.TextField);

LaiviExt.htmlEditor=Ext.extend(Ext.form.HtmlEditor,{
	constructor:function(config){
		config.id=config.id|| config.name+'_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.emptyText || (!config.allowBlank ? '请输入' + config.field : null);
		config.blankText = config.blankText || ('请输入' + config.field);
		config.fieldLabel = config.fieldLabel || config.field;
		LaiviExt.htmlEditor.superclass.constructor.call(this,config);
	}
});
Ext.reg('laiviExt-htmleditor',LaiviExt.htmlEditor);

LaiviExt.NumberField = Ext.extend(Ext.form.NumberField, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.allowDecimals = config.allowDecimals || false;
		config.emptyText = config.emptyText || !config.allowBlank ? '请输入' + config.field : null;
		config.blankText = config.blankText || '请输入' + config.field;
		config.fieldLabel = config.fieldLabel || config.field;
		LaiviExt.NumberField.superclass.constructor.call(this, config);
	}
});
Ext.reg('laiviExt-number', LaiviExt.NumberField);


LaiviExt.FileUpload = Ext.extend(Ext.form.TextField, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.inputType = 'file';
		config.fieldLabel = config.fieldLabel || config.field;
		LaiviExt.FileUpload.superclass.constructor.call(this, config);
	}
});
Ext.reg('laiviExt-file', LaiviExt.FileUpload);


LaiviExt.DateField = Ext.extend(Ext.form.DateField, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.emptyText || !config.allowBlank ? '请输入' + config.field : null;
		config.blankText = config.blankText || '请输入' + config.field;
		config.fieldLabel = config.fieldLabel || config.field;
		LaiviExt.DateField.superclass.constructor.call(this, config);
	}
});
Ext.reg('laiviExt-date', LaiviExt.DateField);


LaiviExt.Hidden = Ext.extend(Ext.form.Hidden, {
	constructor : function(config) {
		LaiviExt.Hidden.superclass.constructor.call(this, config);
	}
});
Ext.reg('laiviExt-hidden', LaiviExt.Hidden);


LaiviExt.ComboStore = Ext.extend(Ext.data.Store, {
	constructor : function(config) {
		config.reader = config.reader || new Ext.data.JsonReader({
			root: 'root'
		}, [
			{name:'text' },
			{name:'value' },
			{name:'approveid' }
		]);
		config.id = config.id || config.name + '_store';
		config.proxy = config.proxy || new Ext.data.HttpProxy({ url : config.url });
		LaiviExt.ComboStore.superclass.constructor.call(this, config);
	}
});
Ext.reg('laiviExt-cbstore', LaiviExt.ComboStore);


LaiviExt.ComboField = Ext.extend(Ext.form.ComboBox, {
	constructor : function(config) {
		config.id = config.id || (config.name + '_field');
		config.width = config.width || formItemWidth;
		config.triggerAction = config.triggerAction || 'all';
		config.editable = config.editable || false;
		config.displayField = config.displayField || 'text';
		config.valueField = config.valueField || 'value';
		config.mode = config.mode || 'remote';
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.fieldLabel || !config.allowBlank ? '请选择' + config.field : null;
		config.blankText = config.blankText || '请选择' + config.field;
		config.loadingText = config.loadingText || '请选择' + config.field;
		config.fieldLabel = config.fieldLabel || config.field;
		config.hiddenName = config.hiddenName || config.name;
		if (config.mode == 'local') {
			config.store = config.store || new Ext.data.SimpleStore({
				fields: [config.displayField, config.valueField],
				data : config.data
			});
		} else {
			config.store = config.store || new LaiviExt.ComboStore({name:config.name, url:config.url});
		}

		LaiviExt.ComboField.superclass.constructor.call(this, config);

		if (config.onselect != null) {
			this.on("select", config.onselect);
		}
	},
	setUrl: function(url) {
		this.store.proxy = new Ext.data.HttpProxy({url : url});
		this.store.reload();
		return this;
	},
	getText: function() {
		var text;
		for (var i = 0; i < this.store.getCount(); ++i) {
			if (this.store.getAt(i).get('value') == this.getValue()) {
				text = this.store.getAt(i).get('text');
				break;
			}
		}
		return text;
	}
});
Ext.reg('laiviExt-combo', LaiviExt.ComboField);

LaiviExt.LovComboField = Ext.extend(Ext.ux.form.LovCombo, {
	constructor : function(config) {
		config.id = config.id || (config.name + '_field');
		config.width = config.width || formItemWidth;
		config.triggerAction = config.triggerAction || 'all';
		config.editable = config.editable || false;
		config.displayField = config.displayField || 'text';
		config.valueField = config.valueField || 'value';
		config.mode = config.mode || 'remote';
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.fieldLabel || !config.allowBlank ? '请选择' + config.field : null;
		config.blankText = config.blankText || '请选择' + config.field;
		config.loadingText = config.loadingText || '请选择' + config.field;
		config.fieldLabel = config.fieldLabel || config.field;
		config.hiddenName = config.hiddenName || config.name;
		if (config.mode == 'local') {
			config.store = config.store || new Ext.data.SimpleStore({
				fields: [config.displayField, config.valueField],
				data : config.data
			});
		} else {
			config.store = config.store || new LaiviExt.ComboStore({name:config.name, url:config.url});
		}
		LaiviExt.LovComboField.superclass.constructor.call(this, config);
		if (config.onselect != null) {
			this.on("select", config.onselect);
		}
	},
	setUrl: function(url) {
		this.store.proxy = new Ext.data.HttpProxy({url : url});
		this.store.reload();
		return this;
	}
});
Ext.reg('laiviExt-lovcombo', LaiviExt.LovComboField);

LaiviExt.JsonStore = Ext.extend(Ext.data.Store, {
	constructor : function(config) {
		var list = [];
		if (config.items != null) {
			for (var i = 0; i < config.items.length; ++i) {
				list.push({name: config.items[i]});
			}
		}
		config.reader = config.reader || new Ext.data.JsonReader({
			totalProperty: 'totalProperty',
			root: 'root'
		}, list);
		config.proxy = config.proxy || new Ext.data.HttpProxy({url : config.url});
		LaiviExt.JsonStore.superclass.constructor.call(this, config);
	},
	setUrl: function(url) {
		this.proxy = new Ext.data.HttpProxy({url : url});
		return this;
	},
	loadPage: function() {
		this.load({
			params:{start:0,limit:pagecount},
			callback:function(r,option,success){
				if(success==false){
					LaiviExt.alert('加载数据失败');
				}
			}
		});
	},
	loadParam:function(params){
		this.load({
			params:params,
			callback:function(r,option,success){
				if(success==false){
					LaiviExt.alert('加载数据失败');
				}
			}
		});
	}
});
Ext.reg('laiviExt-store', LaiviExt.JsonStore);

LaiviExt.Window = Ext.extend(Ext.Window, {
	constructor : function(config) {
		config.layout = config.layout || 'fit';
		config.closeAction = config.closeAction || 'hide';
		config.resizable = config.resizable || true;
		config.shadow = config.shadow || true;
		config.modal = config.modal || true;
		config.closable = config.closable || true;
		config.animCollapse = config.animCollapse || true;
		LaiviExt.Window.superclass.constructor.call(this, config);
	}
});
Ext.reg('laiviExt-win', LaiviExt.Window);

LaiviExt.Panel=Ext.extend(Ext.Panel,{
	constructor : function(config) {
		config = config || {};
		config.loadMask = config.loadMask || true;
		config.viewConfig = config.viewConfig || { autoFill : true};
	}
});

Ext.reg('laiviExt-panel', LaiviExt.Panel);

LaiviExt.GridPanel = Ext.extend(Ext.grid.GridPanel, {
	constructor : function(config) {
		config = config || {};
		config.style = config.style || 'margin:0 auto';
		config.loadMask = config.loadMask || true;
		config.config = config.loadMask || true;
		config.animCollapse = config.loadMask || false;
		config.stripeRows = config.stripeRows || true;
		if (config.fitClient) {
			config.width = config.width || document.body.clientWidth;
			config.height = config.height || document.body.clientHeight;
		}
		config.viewConfig = config.viewConfig || { autoFill : true, emptyText: '暂无数据' };
		LaiviExt.foreach(config.columns, function(x) {
			x.sortable = x.sortable || true;
		});
//		for (var i = 0; i < config.columns.length; ++i) {
//			config.columns[i].sortable = config.columns[i].sortable || true;
//		}
		!config.showRowNum || (config.columns = [new Ext.grid.RowNumberer({ width : 20  })].concat(config.columns));
		!config.showPaging || (config.bbar = {xtype:'laiviExt-paging', store:config.store});
		LaiviExt.GridPanel.superclass.constructor.call(this, config);
		!config.cellclick || this.addListener('cellclick', config.cellclick);
	}
});
Ext.reg('laiviExt-grid', LaiviExt.GridPanel);
LaiviExt.EditorGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {
	constructor : function(config) {
		config.style = config.style || 'margin:0 auto';
		config.loadMask = config.loadMask || true;
		config.config = config.loadMask || true;
		config.animCollapse = config.loadMask || false;
		config.stripeRows = config.stripeRows || true;
		config.viewConfig = config.viewConfig || { autoFill : true, emptyText: '暂无数据' };
		if (config.fitClient) {
			config.width = config.width || document.body.clientWidth;
			config.height = config.height || document.body.clientHeight;
		}
		LaiviExt.foreach(config.columns, function(x) {
			x.sortable = x.sortable || true;
		});
//		for (var i = 0; i < config.columns.length; ++i) {
//			config.columns[i].sortable = config.columns[i].sortable || true;
//		}
		!config.showRowNum || (config.columns = [new Ext.grid.RowNumberer({ width : 20  })].concat(config.columns));
		!config.showPaging || (config.bbar = {xtype:'laiviExt-paging', store:config.store});
		LaiviExt.GridPanel.superclass.constructor.call(this, config);
		!config.cellclick || this.addListener('cellclick', config.cellclick);
	}
});
Ext.reg('laiviExt-editGrid', LaiviExt.EditorGridPanel);

LaiviExt.PagingToolbar = Ext.extend(Ext.PagingToolbar, {
	constructor:function(config) {
		config.pageSize = pagecount;
		config.displayInfo = true;
		config.displayMsg = '显示第{0}到{1}行,总共{2}行';
		config.emptyMsg = '暂无数据';
		config.firstText = "首页";
		config.prevText = "上一页";
		config.nextText = "下一页";
		config.lastText = "末页";
		config.refreshText = "刷新";
		config.beforePageText = "第";
		config.afterPageText = "页，共{0}页";
		LaiviExt.PagingToolbar.superclass.constructor.call(this, config);
	}
});
Ext.reg('laiviExt-paging', LaiviExt.PagingToolbar);

LaiviExt.FormPanel = Ext.extend(Ext.FormPanel, {
	constructor: function(config) {
		config = config || {};
		config.labelSeparator = config.labelSeparator || "：";
		config.frame = config.frame || true;
		config.border = config.border || false;
		config.buttonAlign = config.buttonAlign || "center";
		config.labelAlign = config.labelAlign || "right";
		if (config.closeHandler && config.submitHandler) {
			config.buttons = config.buttons || [
				{ text : '关闭', iconCls:'close', handler : config.closeHandler  },
				{ text : '提交', iconCls:'save',handler : config.submitHandler }
			];
		}
		for (var i = 0; config.items && i < config.items.length; ++i) {
			if (config.items[i].closeHandler && config.items[i].submitHandler) {
				config.items[i].buttons = config.items[i].buttons || [
					{ text : '关闭', iconCls:'close', handler : config.items[i].closeHandler  },
					{ text : '提交', iconCls:'save',handler : config.items[i].submitHandler }
				];
				break;
			}
		}
		LaiviExt.FormPanel.superclass.constructor.call(this, config);
	},
	doSubmit : function(url, successHandler) {
		this.submit({url:url, successHandler:successHandler});
	},
	submit: function(config) {
		config = config || {};
		this.form.submit({
			clientValidation:config.clientValidation || true,
			waitMsg : config.waitMsg || '正在提交数据请稍后',
			waitTitle : config.waitTitle || '提示',
			url : config.url,
			method:config.method || 'POST',
			params: config.params,
			success:config.success || function(form, action) {
				if (action.result.success) {
                    if(config.successHandler!=null){
                         config.successHandler();
                    }
				} else {
					LaiviExt.alertError(action.result.msg);
				}
			},
			failure:config.failure || submitFailure
		});
	},
	load : function(config) {
		config = config || {};
		this.form.load({
			clientValidation : config.clientValidation || true,
			url : config.url,
			method : config.method || 'POST',
			success: config.success,
			failure : config.failure || submitFailure
		});
	}
});
Ext.reg('laiviExt-form', LaiviExt.FormPanel);

LaiviExt.Viewport = Ext.extend(Ext.Viewport, {
	constructor: function(config) {
		config.layout = config.layout || 'fit';
		LaiviExt.Viewport.superclass.constructor.call(this, config);
	}
});

Ext.apply(LaiviExt, {
	onReady: function(func) {
		Ext.onReady(function() {
			Ext.QuickTips.init();
			Ext.form.Field.prototype.msgTarget = 'side';
			try {
				func();
			} catch(error) {
				LaiviExt.alertError(error);
			}
		});
	},
	ajaxCall:function(config) {
		config = config || {};
		Ext.Ajax.request({
			url : config.url,
			params : config.params,
			method : config.method || 'POST',
			success : function(response) {
				var result = Ext.util.JSON.decode(response.responseText);
				if (result.success) {
                    if(config.successHandler!=null){
                         config.successHandler(result);
                    }
				} else {
					LaiviExt.alertError(result.msg);
				}
			},
			failure : function() {
				LaiviExt.alertError("操作失败");
			}
		});
	},
	removeChildById: function(id) {
		var div = document.getElementById(id);
		if (div != null) {
			while (div.hasChildNodes()) {
				div.removeChild(div.firstChild);
			}
		}
	},
	foreach: function(itemList, setFunc) {
		for (var i = 0; i < itemList.length; ++i) {
			setFunc(itemList[i]);
		}
	},
	isEmpty : function(item) {
		return item == null || item == '';
	},
	alert: function(msg) {
		Ext.Msg.alert("提示",msg);
	},
	alertError: function(msg) {
		Ext.Msg.alert("错误",msg);
	},
	confirm: function(title, handler) {
		Ext.MessageBox.confirm("提示", title, function(res) {
			if (res == 'yes') {
				handler();
			}
		});
	},
	inline: function(item1, item2, width) {
		return  {
			layout : "column",
			items : [
				{
					columnWidth : width == null ? 0.5 : width,
					layout : "form",
					items : [ item1 ]
				},
				{
					columnWidth : width == null ? 0.5 : width,
					layout : "form",
					items : [  item2]
				}
			]
		};
	},
	setVisible: function(x, visible) {
		if (x != null) {
			x.style.display = visible ? 'inline' : 'none';
		}
	},
	gridButton : function(config) {
		return "<input type='button' class='btn-grid' value='" + config.text
				+ "' onclick='" + config.onclick + "'>";
	},
	getSelectedField:function(grid,field){
		var recs=grid.getSelectionModel().getSelections();
		if(recs.length>0){
			return recs[0].get(field);
		}else{
			LaiviExt.alert("选择一个对象");
            return;
		}
	},
	getSelectedIds:function(grid,isSingle){
        isSingle=isSingle||false;
		var recs=grid.getSelectionModel().getSelections();
		if(recs.length>0){
            if(isSingle){
                if(recs.length>1){
                    LaiviExt.alert("只能选择一个对象");
                    return;
                }
            }
			var ids='';
			for(var i = 0 ; i < recs.length ; i++){
				ids+=recs[i].get('id');
				if(i!=(recs.length-1)){
					ids+=',';
				}
			}
			return ids;
		}else{
			LaiviExt.alert("没有选择对象");
		}
	}
});

Array.prototype.contains = function(obj) {
	for (var i = 0; i < this.length; ++i) {
		if (this[i] == obj) {
			return true;
		}
	}
	return false;
};

Array.prototype.remove = function(obj) {
	for (var i = 0; i < this.length; ++i) {
		if (this[i] == obj) {
			this.splice(i, 1);
			return;
		}
	}
};

Array.prototype.max = function() {
	var res = this.length > 0 ? this[0] : 0;
	for (var i = 0; i < this.length; ++i) {
		res = res > this[i] ? res : this[i];
	}
	return res;
};

Array.prototype.min = function() {
	var res = this.length > 0 ? this[0] : 0;
	for (var i = 0; i < this.length; ++i) {
		res = res < this[i] ? res : this[i];
	}
	return res;
};
Ext.MessageBox.buttonText = {
	ok : "确定",
	cancel : "取消",
	yes : "是",
	no : "否"
};
function $(x) {
	if ('function' == typeof(x)) {
		LaiviExt.onReady(x);
	} else {
		return Ext.getCmp(x);
	}
}
function Set() {
	this.elements = [];
	this.size = function() {
		return this.elements.length;
	};
	this.isEmpty = function() {
		return (this.elements.length < 1);
	};
	this.clear = function() {
		this.elements = [];
	};
	this.contains = function(x) {
		return this.elements.contains(x);
	};
	this.add = function(x) {
		if (!this.contains(x)) {
			this.elements.push(x);
		}
	};
	this.remove = function(x) {
		this.elements.remove(x);
	};
}

function Map() {
	this.elements = new Array();
	this.size = function() {
		return this.elements.length;
	};
	this.isEmpty = function() {
		return (this.elements.length < 1);
	};
	this.clear = function() {
		this.elements = new Array();
	};
	this.put = function(_key, _value) {
		if (this.containsKey(_key)) {
			this.remove(_key);
		}
		this.elements.push({ key : _key, value : _value });
	};
	this.remove = function(_key) {
		try {
			for (var i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					this.elements.splice(i, 1);
				}
			}
		} catch (e) {
		}
	};
	this.get = function(_key) {
		try {
			for (var i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					return this.elements[i].value;
				}
			}
		} catch (e) {
			return null;
		}
	};
	this.element = function(_index) {
		if (_index < 0 || _index >= this.elements.length) {
			return null;
		}
		return this.elements[_index];
	};
	this.containsKey = function(_key) {
		try {
			for (var i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					return true;
				}
			}
		} catch (e) {
		}
		return false;
	};
	this.containsValue = function(_value) {
		try {
			for (var i = 0; i < this.elements.length; i++) {
				if (this.elements[i].value == _value) {
					return true;
				}
			}
		} catch (e) {
		}
		return false;
	};
}

function GridColumnObject(headValue,indexValue,renderFunction){
	var gridColumn={
			header:headValue,
			dataIndex: indexValue,
			sortable: true,
			renderer:renderFunction
	};
	return gridColumn;
}

Ext.apply(Ext.form.VTypes, {
  password : function(val, field) {
    if (field.initialPassField) {
      var pwd = Ext.getCmp(field.initialPassField);
      return (val == pwd.getValue());
    }
    return true;
  },
  passwordText : '密码不匹配'
});

function getSearchCom(store,url,dataStore){
	var searchCom=["->",field,{
		text: "搜索",
		iconCls:'search',
		handler: function () {
			var searchUrl;
			var tempUrl='key='+Ext.getCmp('key_field').getValue()+'&value='+field.getValue();
			var startDate=Ext.getCmp('startDateSearchId').getValue();
			if(startDate!=null && startDate!=''){
				tempUrl=tempUrl+'&startDate='+startDate.format('Y-m-d');
			}
			var endDate=Ext.getCmp('endDateSearchId').getValue();
			if(endDate!=null && endDate!=''){
				tempUrl=tempUrl+'&endDate='+endDate.format('Y-m-d');
			}
			if(url.indexOf('?')!=-1){
				searchUrl=url+"&"+tempUrl;
			}else{
				searchUrl=url+"?"+tempUrl;
			}
			dataStore.setUrl(searchUrl).loadPage();
		}
	},"->","关键字：",new LaiviExt.ComboField({
		field:'关键字：',
		width:150,
		name:'key',
		store:store
	}),"->","结束日期：",new LaiviExt.DateField({
		name: 'endDate',
	    id: 'endDateSearchId',
	    width: 90,
	    blankText :'请选择结束日期',
	    anchor: '99%'
	}), "->","开始日期：",new LaiviExt.DateField({
		name: 'startDate',
	    id: 'startDateSearchId',
	    width: 90,
	    blankText :'请选择开始日期',
	    anchor: '99%'
	})];
	return searchCom;
}

