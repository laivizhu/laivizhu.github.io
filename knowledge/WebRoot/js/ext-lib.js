Ext.namespace("Fmp");
var pagecount=25;
var formItemWidth=200;
var submitFailure = function(form, action) {
    switch (action.failureType) {
        case Ext.form.Action.CLIENT_INVALID:
        	Fmp.alert('信息不完整，操作失败');
            break;
        case Ext.form.Action.CONNECT_FAILURE:
        	Fmp.alertError('连接服务器异常');
            break;
        case Ext.form.Action.SERVER_INVALID:
        	Fmp.alertError(action.result.msg);
    }
};


Fmp.Label = Ext.extend(Ext.form.Label, {
	constructor : function(config) {
		config.width = config.width || formItemWidth;
		Fmp.Label.superclass.constructor.call(this);
	}
});
Ext.reg('fmp-label', Fmp.Label);


Fmp.TextField = Ext.extend(Ext.form.TextField, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.emptyText || (!config.allowBlank ? '请输入' + config.field : null);
		config.blankText = config.blankText || ('请输入' + config.field);
		config.fieldLabel = config.fieldLabel || config.field;
		Fmp.TextField.superclass.constructor.call(this, config);
	}
});
Ext.reg('fmp-text', Fmp.TextField);

Fmp.TextArea = Ext.extend(Ext.form.TextArea, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.emptyText || (!config.allowBlank ? '请输入' + config.field : null);
		config.blankText = config.blankText || ('请输入' + config.field);
		config.fieldLabel = config.fieldLabel || config.field;
		Fmp.TextArea.superclass.constructor.call(this, config);
	}
});
Ext.reg('fmp-textarea', Fmp.TextField);

Fmp.htmlEditor=Ext.extend(Ext.form.HtmlEditor,{
	constructor:function(config){
		config.id=config.id|| config.name+'_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.emptyText || (!config.allowBlank ? '请输入' + config.field : null);
		config.blankText = config.blankText || ('请输入' + config.field);
		config.fieldLabel = config.fieldLabel || config.field;
		Fmp.htmlEditor.superclass.constructor.call(this,config);
	}
});
Ext.reg('fmp-htmleditor',Fmp.htmlEditor);

Fmp.NumberField = Ext.extend(Ext.form.NumberField, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.allowDecimals = config.allowDecimals || false;
		config.emptyText = config.emptyText || !config.allowBlank ? '请输入' + config.field : null;
		config.blankText = config.blankText || '请输入' + config.field;
		config.fieldLabel = config.fieldLabel || config.field;
		Fmp.NumberField.superclass.constructor.call(this, config);
	}
});
Ext.reg('fmp-number', Fmp.NumberField);


Fmp.FileUpload = Ext.extend(Ext.form.TextField, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.inputType = 'file';
		config.fieldLabel = config.fieldLabel || config.field;
		Fmp.FileUpload.superclass.constructor.call(this, config);
	}
});
Ext.reg('fmp-file', Fmp.FileUpload);


Fmp.DateField = Ext.extend(Ext.form.DateField, {
	constructor : function(config) {
		config.id = config.id || config.name + '_field';
		config.width = config.width || formItemWidth;
		config.allowBlank = config.allowBlank || false;
		config.emptyText = config.emptyText || !config.allowBlank ? '请输入' + config.field : null;
		config.blankText = config.blankText || '请输入' + config.field;
		config.fieldLabel = config.fieldLabel || config.field;
		Fmp.DateField.superclass.constructor.call(this, config);
	}
});
Ext.reg('fmp-date', Fmp.DateField);


Fmp.Hidden = Ext.extend(Ext.form.Hidden, {
	constructor : function(config) {
		Fmp.Hidden.superclass.constructor.call(this, config);
	}
});
Ext.reg('fmp-hidden', Fmp.Hidden);


Fmp.ComboStore = Ext.extend(Ext.data.Store, {
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
		Fmp.ComboStore.superclass.constructor.call(this, config);
	}
});
Ext.reg('fmp-cbstore', Fmp.ComboStore);


Fmp.ComboField = Ext.extend(Ext.form.ComboBox, {
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
			config.store = config.store || new Fmp.ComboStore({name:config.name, url:config.url});
		}

		Fmp.ComboField.superclass.constructor.call(this, config);

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
Ext.reg('fmp-combo', Fmp.ComboField);

Fmp.LovComboField = Ext.extend(Ext.ux.form.LovCombo, {
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
			config.store = config.store || new Fmp.ComboStore({name:config.name, url:config.url});
		}
		Fmp.LovComboField.superclass.constructor.call(this, config);
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
Ext.reg('fmp-lovcombo', Fmp.LovComboField);

Fmp.JsonStore = Ext.extend(Ext.data.Store, {
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
		Fmp.JsonStore.superclass.constructor.call(this, config);
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
					Fmp.alert('加载数据失败');
				}
			}
		});
	},
	loadParam:function(params){
		this.load({
			params:params,
			callback:function(r,option,success){
				if(success==false){
					Fmp.alert('加载数据失败');
				}
			}
		});
	}
});
Ext.reg('fmp-store', Fmp.JsonStore);

Fmp.Window = Ext.extend(Ext.Window, {
	constructor : function(config) {
		config.layout = config.layout || 'fit';
		config.closeAction = config.closeAction || 'destroy';
		config.resizable = config.resizable || true;
		config.shadow = config.shadow || true;
		config.modal = config.modal || true;
		config.closable = config.closable || true;
		config.animCollapse = config.animCollapse || true;
		Fmp.Window.superclass.constructor.call(this, config);
	}
});
Ext.reg('fmp-win', Fmp.Window);

Fmp.Panel=Ext.extend(Ext.Panel,{
	constructor : function(config) {
		config = config || {};
		config.loadMask = config.loadMask || true;
		config.viewConfig = config.viewConfig || { autoFill : true};
	}
});

Ext.reg('fmp-panel', Fmp.Panel);

Fmp.GridPanel = Ext.extend(Ext.grid.GridPanel, {
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
		Fmp.foreach(config.columns, function(x) {
			x.sortable = x.sortable || true;
		});
//		for (var i = 0; i < config.columns.length; ++i) {
//			config.columns[i].sortable = config.columns[i].sortable || true;
//		}
		!config.showRowNum || (config.columns = [new Ext.grid.RowNumberer({ width : 20  })].concat(config.columns));
		!config.showPaging || (config.bbar = {xtype:'fmp-paging', store:config.store});
		Fmp.GridPanel.superclass.constructor.call(this, config);
		!config.cellclick || this.addListener('cellclick', config.cellclick);
	}
});
Ext.reg('fmp-grid', Fmp.GridPanel);
Fmp.EditorGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {
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
		Fmp.foreach(config.columns, function(x) {
			x.sortable = x.sortable || true;
		});
//		for (var i = 0; i < config.columns.length; ++i) {
//			config.columns[i].sortable = config.columns[i].sortable || true;
//		}
		!config.showRowNum || (config.columns = [new Ext.grid.RowNumberer({ width : 20  })].concat(config.columns));
		!config.showPaging || (config.bbar = {xtype:'fmp-paging', store:config.store});
		Fmp.GridPanel.superclass.constructor.call(this, config);
		!config.cellclick || this.addListener('cellclick', config.cellclick);
	}
});
Ext.reg('fmp-editGrid', Fmp.EditorGridPanel);

Fmp.PagingToolbar = Ext.extend(Ext.PagingToolbar, {
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
		Fmp.PagingToolbar.superclass.constructor.call(this, config);
	}
});
Ext.reg('fmp-paging', Fmp.PagingToolbar);

Fmp.FormPanel = Ext.extend(Ext.FormPanel, {
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
		Fmp.FormPanel.superclass.constructor.call(this, config);
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
					Fmp.alertError(action.result.msg);
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
Ext.reg('fmp-form', Fmp.FormPanel);

Fmp.Viewport = Ext.extend(Ext.Viewport, {
	constructor: function(config) {
		config.layout = config.layout || 'fit';
		Fmp.Viewport.superclass.constructor.call(this, config);
	}
});

Ext.apply(Fmp, {
	onReady: function(func) {
		Ext.onReady(function() {
			Ext.QuickTips.init();
			Ext.form.Field.prototype.msgTarget = 'side';
			try {
				func();
			} catch(error) {
				Fmp.alertError(error);
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
					Fmp.alertError(result.msg);
				}
			},
			failure : function() {
				Fmp.alertError("操作失败");
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
	getSelectedIds:function(grid,isSingle){
        isSingle=isSingle||false;
		var recs=grid.getSelectionModel().getSelections();
		if(recs.length>0){
            if(isSingle){
                if(recs.length>1){
                    Fmp.alert("只能选择一个对象");
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
			Fmp.alert("没有选择对象");
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
		Fmp.onReady(x);
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


