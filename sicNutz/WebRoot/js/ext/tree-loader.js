
/**
 * 动态加载JSON格式的数据
 * @param data : 数据源对象，例如：Docs.classData
 * @param rooText : 字符串　根节点的标签
 * @param rootId : 字符串  根节点的id
*/
var createJsonTreePanel = function(data/*,rootText,rootId*/){
	var mytree = new Ext.tree.TreePanel({
		animate:true,//以动画形式伸展,收缩子节点
		//title:"Extjs静态树",
		//collapsible:true,
		rootVisible:true,//是否显示根节点
		autoScroll:true,
		autoHeight:true,
		//height:'100%',
		width:'100%',
		lines:true,//节点之间连接的横竖线

		//树加载器（TreeLoader）的目的是从URL延迟加载树节点Ext.tree.TreeNode的子节点。返回值必须是以树格式的javascript数组
		loader: new Ext.tree.TreeLoader({
			preloadChildren: true,//若为true，则loader在节点第一次访问时加载"children"的属性
			clearOnLoad: false//（可选）默认为true。在读取数据前移除已存在的节点
		}),
		root: new Ext.tree.AsyncTreeNode(data),
		collapseFirst:false ,
		
		//添加事件
		listeners : {
		//当点击时在右边主窗口中加载相应的资源
		click : function(node, e){			
					e.stopEvent();//停止href属性产品的链接操作(自动)
						
					if(node.isLeaf()){//如果是非叶子节点，则不用加载相应资源
						//alert(node.isLeaf());
						loadPanel(node);//加载叶子节点对应的资源
						//alert(node.text);							
					}
				}
		}
	});
	return mytree;
}

var createTreeDataPanel = function(data/*,rootText,rootId*/){
	var mytree = new Ext.tree.TreePanel({
		animate:true,//以动画形式伸展,收缩子节点
		//title:"Extjs静态树",
		//collapsible:true,
		rootVisible:true,//是否显示根节点
		autoScroll:true,
		autoHeight:true,
		//height:'100%',
		width:'100%',
		lines:true,//节点之间连接的横竖线

		//树加载器（TreeLoader）的目的是从URL延迟加载树节点Ext.tree.TreeNode的子节点。返回值必须是以树格式的javascript数组
		loader: new Ext.tree.TreeLoader({
			preloadChildren: true,//若为true，则loader在节点第一次访问时加载"children"的属性
			clearOnLoad: false//（可选）默认为true。在读取数据前移除已存在的节点
		}),
		root: data,
		collapseFirst:false ,
		
		//添加事件
		listeners : {
		//当点击时在右边主窗口中加载相应的资源
		click : function(node, e){			
					e.stopEvent();//停止href属性产品的链接操作(自动)
						
					if(node.isLeaf()){//如果是非叶子节点，则不用加载相应资源
						//alert(node.isLeaf());
						loadPanel(node);//加载叶子节点对应的资源
						//alert(node.text);							
					}
				}
		}
	});
	return mytree;
}

/**
 * 动态加载TXT格式的数据
 * @param txtFileName : Txt数据源文件名（包含路径）
 * @param rooText : 字符串　根节点的标签
 * @param rootId : 字符串  根节点的id
*/
var createTxtTreePanel = function(txtFileName,rootText,rootId){
	var mytree=new Ext.tree.TreePanel({
		//el:"container",//应用到的html元素id
		animate:true,//以动画形式伸展,收缩子节点
		//title:"Extjs静态树",
		//collapsible:true,
		rootVisible:true,//是否显示根节点
		autoScroll:true,
		autoHeight:true,
		//height:'100%',
		width:'100%',
		lines:true,//节点之间连接的横竖线

		//树加载器（TreeLoader）的目的是从URL延迟加载树节点Ext.tree.TreeNode的子节点。返回值必须是以树格式的javascript数组
		loader: new Ext.tree.TreeLoader({
			preloadChildren: true,//若为true，则loader在节点第一次访问时加载"children"的属性
			clearOnLoad: false,//（可选）默认为true。在读取数据前移除已存在的节点
			dataUrl:txtFileName
		}),                
		root: new Ext.tree.AsyncTreeNode({
			text:rootText,
			id:rootId,"singleClickExpand":true,
			expanded:true
		}),
		collapseFirst:false,
		//添加事件
		listeners : {
		//当点击时在右边主窗口中加载相应的资源
		click : function(node, e){
					e.stopEvent();//停止href属性产品的链接操作(自动)
					if(node.isLeaf()){//如果是非叶子节点，则不用加载相应资源
						loadPanel(node);//加载叶子节点对应的资源
					}
				}
		}
	});
	return mytree;
}


/**
 * 动态加载xml格式的数据
 * @param xmlFileName : xml数据源文件名（包含路径）
 * @param rooText : 字符串　根节点的标签
 * @param rootId : 字符串  根节点的id
*/
var createXmlTreePanel = function(xmlFileName,rootText,rootId){
	var mytree = new Ext.tree.TreePanel({
		//el:"container",//应用到的html元素id
		animate:true,//以动画形式伸展,收缩子节点
		//title:"Extjs静态树",
		//collapsible:true,
		rootVisible:true,//是否显示根节点
		autoScroll:true,
		autoHeight:true,
		//height:'100%',
		width:'100%',
		lines:true,//节点之间连接的横竖线

		//树加载器（TreeLoader）的目的是从URL延迟加载树节点Ext.tree.TreeNode的子节点。返回值必须是以树格式的javascript数组
		 loader: new Ext.app.BookLoader({
		//loader: new Ext.ux.tree.XmlTreeLoader({
			preloadChildren: true,//若为true，则loader在节点第一次访问时加载"children"的属性
			clearOnLoad: false,//（可选）默认为true。在读取数据前移除已存在的节点
	        dataUrl:xmlFileName
	     }),               		
		root: new Ext.tree.AsyncTreeNode({
			text:rootText,
			rootVisible:true,//是否显示根节点
			autoScroll:true,
			autoHeight:true,"singleClickExpand":true,
			id:rootId,
			expanded:true
		}),
		collapseFirst:false,
		//添加事件
		listeners : {
		//当点击时在右边主窗口中加载相应的资源
		click : function(node, e){
					//alert(node.isLeaf());
					e.stopEvent();//停止href属性产品的链接操作(自动)
					if(node.isLeaf()){//如果是非叶子节点，则不用加载相应资源
						loadPanel(node);//加载叶子节点对应的资源
					}
				}
		}
	});
	return mytree;
}

/**
 * 创建Panel组件，并加载指定的Tree数据
 * @param panelTitle : Panel标题
 * @param data : Tree数据源
 * @param rootText : 字符串　根节点的标签
 * @param rootId : 字符串  根节点的id
 * @param dataType : 需要加载Tree的数据格式,值：json、txt、xml
 */
var createPanel = function(panelTitle,data/*,rootText,rootId*/,dataType){
	var myPanel;
	if(data=='')
	{
		myPanel = new Ext.Panel({
			title: panelTitle,
			html: "<div style='text-align:center; background-color:#eeeeee; height:100%; line-height:100%;padding-top:150px'><font color='#ff0000'>Sorry,这部分功能您没有操作权限<br/><br/>申请开通权限请与管理员联系<font></div>",
			border: false,
			iconCls: 'settings',
			autoScroll:true
			
		});
		return myPanel;

	}
		
	var obj={};
	switch (dataType) {
		case 'json' :
			obj = createJsonTreePanel(data/*,rootText,rootId*/);
			break;
		case 'txt' :
			obj = createTxtTreePanel(data/*,rootText,rootId*/);
			break;
		case 'xml' :
			obj = createXmlTreePanel(data/*,rootText,rootId*/);
			break;
		case 'treedata' :
			obj = createTreeDataPanel(data/*,rootText,rootId*/);
			break;
		default :
	} 
	
	
	
		myPanel = new Ext.Panel({
			title: panelTitle,
			//html: '<p>Some settings in here.</p>',
			border: false,
			iconCls: 'settings',
			autoScroll:true,
			items:[obj]
		});



	
	return myPanel;
}
	
/**
 * 向TabPanel组件中添加窗口或激活已经存在的窗口
 * 并将指定资源加载进窗口
 * @param node : 传入的Node节点
*/
var loadPanel = function(node) {
	var id=node.id;//获取节点的id
	var href = node.attributes.href;//获取节点中的href属性
	var text = node.text;
var qtip = node.attributes.qtip;
	//alert(qtip);
	//alert("href=" + href);
	//alert("text=" + text);
	//var qtip = node.attributes.qtip;
	var tab = mainPanel.getComponent(id);//获取指定id的组件对象
	
	if(tab) {
		//检验当前Tab选项卡是否存在，如果存在只需要激活
		mainPanel.setActiveTab(tab);
		//tab.getUpdater().refresh(); //刷新
		return;
	}
	//如果选项卡不存在，则以下为创建选项卡代码
	var autoLoad = {url: href, nocache: true,scripts:true};//根据href生成autoLoad对象
	
	tab = mainPanel.add(new Ext.Panel ({
	//创建新选项卡的配置
		id : id,			//设置ID
		title : text,			//设置选项卡标题
		tabTip : qtip, 
		//toolTip:qtip,				//提示内容
		html : '<iframe width=100% height=100% src=' + href + ' />',
		//autoLoad: autoLoad,		//设置自动加载的资源URL
		autoScroll: false,
		closable : true			//是否可以关闭
	}));
	mainPanel.setActiveTab(tab);//创建选项卡后，将其激活	
}





function treePanel(panelTitle, data) {
    return createPanel(panelTitle, data, 'treedata');
}


function parentNode(text) {
    var parent = new Ext.tree.TreeNode({
        "iconCls" : "icon-docs",
        "text" : text,
        "singleClickExpand" : true,
        "expanded" : true,
        "leaf" : false
    });

    for (var i = 1; i < arguments.length; ++i) {
        parent.appendChild(arguments[i]);
    }
    return parent;
}

function leafNode(text, href, qtip) {
    return new Ext.tree.TreeNode({
        "iconCls" : 'icon-pkg',
        "text" : text,
        "qtip" :qtip,
        singleClickExpand : true,
        expanded : true,
        href : href,
        leaf : true
    });
}