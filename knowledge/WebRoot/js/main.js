//设置窗口首页显示的页面
var mainIndexUrl = "manager.html";
//设置底部版权信息页面
var buttonUrl = 'version.html';

Ext.BLANK_IMAGE_URL = 'resources/images/default/s.gif';

/**
 * 主窗口TabPanel组件
 * 作用：作为其它窗口的窗口
*/	

var mainPanel =new Ext.TabPanel({
	region: 'center',
	deferredRender: false,
	activeTab: 0,
	enableTabScroll : true,
	margins: '0 0 0 0',//设置边距
	items: [{
		autoLoad:{
			url:'information_list.jsp',
			scripts:true,
			nocache: true
		},
		title: '首页',                
		autoScroll: true,
		closable : true
	}]
});

/**
 * 左边功能区组件
 */
var treePanel = new Ext.Panel({
	//西　左边
	region: 'west',
	id: 'left-panel', // see Ext.getCmp() below
	title: '菜单导航',
	split: true,
	iconCls:'icon-tree',
	width: 200,
	minSize: 175,
	maxSize: 400,
	collapsible: true,
	margins: '0 0 0 5',
	layout: {
		type: 'accordion',
		animate: true//收起具有动画效果
	},
	items: panelItems//设置左边的功能区
});

/**
 * 声明一个顶部组件
*/
var headerPanel = new Ext.Panel({
	border: false,
	layout:'anchor',
	region:'north',
	cls: 'docs-header',
	height:60,
	items: [{
		id:'header-top',
		xtype:'box',
		el:'header',
		border:false,
		anchor: 'none -25'
	},new Ext.Toolbar({
		items:[{
			 iconCls:'icon-first'
			 },{
			 //此处加载登录用户信息
			 xtype:'label',
			 el:'welcome'
			
			 }, '->', {
				iconCls: 'icon-expand-all ',
				tooltip: '全屏显示主操作窗口',
				handler: function(){
					var w = Ext.getCmp('left-panel');
					w.collapse();					
					var b = Ext.getCmp('button1');
					b.collapse();
				}
			 },'-', {
				iconCls: 'icon-close-all ',
				tooltip: '恢复窗口布局',
				 handler: function(){
					var w = Ext.getCmp('left-panel');
					w.expand();					
					var b = Ext.getCmp('button1');
					b.expand();
				 }
			 },'->',{
					 	text:'一键关闭打开页面',
						iconCls:'close',
						tooltip:'关闭所有打开的页面',
						handler:function(){
							if(mainPanel.items.length>0){
								Ext.Msg.confirm("提示","确认需要关闭所有窗口吗?",function(btn){
									if(btn=='yes'){
										mainPanel.removeAll();
									}
								},this);
							}
						}
				 }
		]}
	)]
})

/**
 * 声明一个底部组件(版本信息)
*/
var buttonPanel = new Ext.Panel({
	//下南创建panl对象，因为viewport子项默认就是panel（xtype=panel）
	region: 'south',
	id:'button1',
	//contentEl: 'south',//可以将html标签ID为south，内容加载进来
	autoLoad:{url:buttonUrl,scripts:true},//加载页面
	//split: true,//设置是否可以使用鼠标调整大小(true:可以，否则不可以)
	height: 70,//设置高度
	//minSize: 60,//设置最小高度(主要用于手动调整大小)
	//maxSize: 70,//设置最大高度(主要用于手动调整大小)
	collapsible: true,//是否可以收缩起来
	//title: 'South',//标题
	margins: '0 0 0 0'//设置边距
});


