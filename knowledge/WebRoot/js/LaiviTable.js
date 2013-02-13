//global infos
function doColumnCallback(id,itemID,j){
	var callback = gOptions[id].columns[j].callback;
	if(callback != null){
		var datas = gTable[id].data.root;
		if(datas != null && datas.length > 0){
			var data = datas[itemID];
			callback(data);
		}else{
			callback();
		}
	}				
}
function doToExcel(id){
	alert("待实现");
}
//多选处理
function doCheckAll(id){
	var checkAll = document.getElementById("CheckAll."+id);
	var checked = checkAll.checked;
	var checkArray =document.getElementsByName("Check."+id);
	$.each(checkArray,function(i,item){
		item.checked = checked;
	});
	var selectChanged = gOptions[id].selectChanged;
	//获取显示的数据
	var currentDatas = gTable[id].getDatas();
	var selectedItems = gTable[id].getSelectedItems();
	//remove
	if(!checked){
		var removed = [];
		$.each(currentDatas,function(i,item){
			var len = selectedItems.length;
			for(var i=0;i<len;i++){
				if(item.id == selectedItems[i].id){
					removed.push(selectedItems[i]);
					selectedItems.splice(i,1);
					break;
				}
			}
		});
		selectChanged(null,removed);
	}else{//add
		var added = [];
		$.each(currentDatas,function(i,item){
			var len = selectedItems.length;
			var contained = false;
			for(var i=0;i<len;i++){
				if(item.id == selectedItems[i].id){
					contained = true;
					break;
				}
			}
			if(!contained){
				added.push(item);
				selectedItems.push(item);
			}
		});
		selectChanged(added,null);
	}
	
}
function doCheckClick(id,index){
	var selectedItems = gTable[id].getSelectedItems();
	var currentDatas = gTable[id].getDatas();
	var selectChanged = gOptions[id].selectChanged;
	
	var checkBox = document.getElementById("Check."+index+"."+id);
	var checked = checkBox.checked;
	if(checked){//增加
		selectedItems.push(currentDatas[index]);
		if(selectChanged != null){
			var added = [];
			added.push(currentDatas[index]);
			selectChanged(added,null);
		}
	}else{//删除
		var len = selectedItems.length;
		for(var i=0;i<len;i++){
			if(selectedItems[i].id == currentDatas[index].id ){
				var removed = [];
				removed.push(currentDatas[index]);
				selectedItems.splice(i,1);
				
				selectChanged(null,removed);
				break;
			}
		}
	}
}
function doSpecialOperation(id,opID){
	var specialOperations = gOptions[id].specialOperations;
	var operation = specialOperations[opID];
	//has callback
	var callback = operation.callback;
	//radio 没选中
	if(gOptions[id].selectType == 1 && gTable[id].radioID == -1){
		callback();//没选中，函数参数为空
		return;
	}
	
	if(callback != null){
		var datas = gTable[id].data.root;
		if(gOptions[id].selectType == 1 && datas != null && datas.length > 0){
			callback(datas[gTable[id].radioID],datas[gTable[id].radioID].callbackdata);
		}else{
			callback();
		}
		
	}else{//no callback
		
	}
}
function doCommonOperation(id,opID,itemID){
	var commonOperations = gOptions[id].commonOperations;
	var operation = commonOperations[opID];
	
	//has callback
	var callback = operation.callback;
	if(callback != null){
		var datas = gTable[id].data.root;
		if(datas != null && datas.length > 0){
			callback(datas[itemID],datas[itemID].callbackdata);
		}else{
			callback();
		}
		
	}else{//no callback
		
	}
}
function doRadioClick(id,itemID){
	//alert(itemID);
	gTable[id].radioID = itemID;
}
function doPageDown(id){
	gTable[id].pageDown();
}
function doPageUp(id){
	gTable[id].pageUp();
}

//sort

function doSort(id,columnIndex){
	//alert(id);
	gTable[id].sort(columnIndex);
}
//global
var gOptions;
var gTable;
//enum
var SelectType = {
	"Radio":1,
	"Check":2
};
var SortType = {
	"None":0,//未定义
	"Desc":1,//降序
	"Asc":2//升序
};
//members
/*
 * 	options:{
 * 		parentContainer:"#mydiv",
 * 		url:"table_list.action",
 * 		
 * 		columns:[
 * 			{name:"ID",with:"10%"}
 * 		],
 * 		operations:[
 * 			{name:"添加",url:"table_add.action",isAjax:0},
 * 			{name:"删除",url:"table_add.action",isAjax:1}
 * 		],
 *      
 *      selectType:0
 *	}
 *  selectType:0:noslect,1:radio,2:checkbox
 */

function HouQianTable(options){
	this.mOptions = options;
	this.currentPage = 1;
	this.totalPage = 0;
	this.radioID = -1;
	this.data = 0;
	this.selectedItems = [];
	this.sortParams = {"column":-1,"type":SortType.None};//排序参数
	
	var id = this.mOptions.parentContainer;
	if(id.indexOf("#") == 0){
		id = id.substring(1);
	}
	this.id = id;
	if(gOptions == null){
		gOptions = [];
	}
	if(gTable == null){
		gTable = [];
	}
	gOptions[id] = options;
	gTable[id] = this;
	if(this.mOptions.hideHeader == true){
		this.isHideHeader =  true;
	}else{
		this.isHideHeader = false;
	}
	this.refreshCallback = null;
	this.init();
}

//functions
//init
HouQianTable.prototype.init = function(){
	//append header
	if(this.mOptions.specialOperations == null || this.mOptions.specialOperations.length == 0){
		$(this.mOptions.parentContainer).append("<div style=\"margin-top:3px;\"/>");
	}
	$(this.mOptions.parentContainer).append("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" class=\"lvtBg\">"+
      "<tbody><tr></td>");
	//add search box
	this.appendCommonSearchBox();
	//append top navigation
	this.appendTopNavigation();
	
	//append content
	this.appendContent();
	
	//append bottom navigation
	this.appendBottomNavigation();
	
	//append footer
	$(this.mOptions.parentContainer).append("</td></tr></tbody></table>");
	
	//request data
	this.requestData(0,this.mOptions.pageCount,this.mOptions.completeCallback);
};
HouQianTable.prototype.setRefreshCallback = function(callback){
	this.refreshCallback = callback;
};
HouQianTable.prototype.getSelectedItem = function(){
	if(this.radioID == -1){
		return null;
	}
	
	if(this.data == null || this.data.root == null){
		return null;
	}
	
	var datas = this.data.root;
	
	return datas[this.radioID];
};
HouQianTable.prototype.getSelectedItems = function(){
	return this.selectedItems;
};
HouQianTable.prototype.getDatas = function(){
	var datas = this.data.root;
	
	return datas;
};
HouQianTable.prototype.setDatas = function(datas){
	
};
HouQianTable.prototype.getItemCount = function(){
	if(this.data != null){
		return this.data.totalItem;
	}
	return 0;
};

HouQianTable.prototype.requestData = function(start,count,completeCallback){
	var options = this.mOptions;
	var table = this;
	var id = this.id;
	var selectedItems = table.selectedItems;
	var sortParams = table.buildSortString();
	
	var div = this.mOptions.parentContainer;
	var tabIndex = this.getUrlParam();
	//alert(parseData.table);
	var url = "";
	if(this.mOptions.url.indexOf("?")>0){
		url = this.mOptions.url+"&start="+start+"&limit="+count+"&rand="+Math.random()+"&sortParams="+sortParams;
	}else if(this.mOptions.url != '#'){
		url = this.mOptions.url+"?start="+start+"&limit="+count+"&rand="+Math.random()+"&sortParams="+sortParams;
	}
	//show loading
	var loading = document.getElementById("loading."+id);
	if(loading != null && this.mOptions.url != '#'){
		loading.style.display = "";
	}
	
	$.getJSON(url,
			function(data){
				table.data = data;
		
				var tableContent = "";
				var datas = data.root;
				$.each(datas,function(i,item){
					var tableTr = "<tr bgcolor=\"white\" onmouseover=\"this.className='lvtColDataHover'\" onmouseout=\"this.className='lvtColData'\">";
					
					if(options.selectType == SelectType.Radio){
						tableTr += "<td ><div align=\"center\"><input type=\"radio\" name=\"name01\" onclick=\"doRadioClick('"+id+"',"+i+")\"/></div></td>";
					}else if(options.selectType == SelectType.Check){
						if(table.inSelectedItems(selectedItems,item)){
							tableTr += "<td ><div align=\"center\"><input type=\"checkbox\" name=\"Check."+id+"\" checked id =\"Check."+i+"."+id+"\" onclick=\"doCheckClick('"+id+"',"+i+")\"/></div></td>";
						}else{
							tableTr += "<td ><div align=\"center\"><input type=\"checkbox\" name=\"Check."+id+"\" id =\"Check."+i+"."+id+"\" onclick=\"doCheckClick('"+id+"',"+i+")\"/></div></td>";
						}
					}
					
					//columns
					
					var columns = options.columns;
					$.each(columns,function(j,column){
						var value = item[column.bindingProperty];
						if(column.editor != null){
							value = column.editor(item); 
						}
						if(column.callback != null){
							tableTr += "<td  height=\"19px\" align=\"left\" ><a href=\"#"+tabIndex+"\" onclick=\"doColumnCallback('"+id+"',"+i+","+j+");\">"+value+"</a></td>";
						}else{
							tableTr += "<td  height=\"19px\" align=\"left\" >"+value+"</td>";
						}
						
					});
					var operations = options.commonOperations;
					if(operations != null){
						tableTr += "<td align=\"left\">";
						var length = operations.length;
						$.each(operations,function(j,operation){
							if(j<length-1){
								tableTr += "<a href=\"#"+tabIndex+"\" onclick=\"doCommonOperation('"+id+"',"+j+","+i+");\">"+operation.name+"</a>&nbsp;|&nbsp";
							}else{
								tableTr += "<a href=\"#"+tabIndex+"\" onclick=\"doCommonOperation('"+id+"',"+j+","+i+");\">"+operation.name+"</a>";
							}
						});
						tableTr += "</td>";
					}
					
					
					tableTr += "</tr>";
					
					tableContent += tableTr;
				});
				$(div).find("#tableContent").empty();
				var tableProperty = table.buildTableProperty();
				$(div).find("#tableContent").append(tableProperty+tableContent);
				
				
				var totalPage = Math.ceil(data.totalItem/table.mOptions.pageCount);
				table.totalPage = totalPage;
				//total page update
				$(div).find("#totalPage1").empty();
				$(div).find("#totalPage1").append(""+totalPage);
				$(div).find("#totalPage2").empty();
				$(div).find("#totalPage2").append(""+totalPage);
				
				//current page
				$(div).find("#currentPage1").empty();
				$(div).find("#currentPage1").append(""+table.currentPage);
				$(div).find("#currentPage2").empty();
				$(div).find("#currentPage2").append(""+table.currentPage);
				
				//hide loading
				if(loading != null){
					loading.style.display = "none";
				}
				
				if(completeCallback != null){
					completeCallback();
				}
			}
		);
	
	
};
HouQianTable.prototype.pageUp = function(){
	if(this.currentPage > 1){
		this.currentPage--;
		this.requestData((this.currentPage-1)*this.mOptions.pageCount, this.mOptions.pageCount);
	}
};
HouQianTable.prototype.pageDown = function(){
	if(this.currentPage < this.totalPage){
		this.currentPage++;
		this.requestData((this.currentPage-1)*this.mOptions.pageCount, this.mOptions.pageCount);
	}
};
HouQianTable.prototype.refresh = function(url){
	this.currentPage = 1;
	if(url != null){
		this.mOptions.url = url;
	}
	
	this.requestData((this.currentPage-1)*this.mOptions.pageCount, this.mOptions.pageCount,this.refreshCallback);
};

//sort
HouQianTable.prototype.sort = function(columnIndex){
	var id = this.id;
	var columns = this.mOptions.columns;
	var column = columns[columnIndex];
	var sortParams = this.sortParams;
	//设置就的图片隐藏
	if(sortParams.column >= 0){//已经有sort，要隐藏旧的
		var sortImage = document.getElementById("SortDesc."+sortParams.column+"."+id);
		sortImage.hidden = true;
		sortImage = document.getElementById("SortAsc."+sortParams.column+"."+id);
		sortImage.hidden = true;
	}
	//计算排序类型
	var sortType = SortType.Desc;
	if(sortParams.column == columnIndex){//如果是同一个列
		if(sortParams.type == SortType.Desc){
			sortType = SortType.Asc;
		}else if(sortParams.type == SortType.Asc){
			sortType = SortType.Desc;
		}
	}
	//设置图片
	if(sortType == SortType.Desc){
		var sortImage = document.getElementById("SortDesc."+columnIndex+"."+id);
		sortImage.hidden = false;
	}else if(sortType == SortType.Asc){
		var sortImage = document.getElementById("SortAsc."+columnIndex+"."+id);
		sortImage.hidden = false;
	}
	//保存排序参数
	sortParams.column = columnIndex;
	sortParams.type = sortType;
	//后台排序
	this.refresh();
};
HouQianTable.prototype.appendTopNavigation = function(){
	if(this.isHideHeader){
		return;
	}
	var content = "<!-- 上部分导航 -->"+
            "<table border=\"0\" cellspacing=\"0\" cellpadding=\"2\" width=\"98%\" class=\"small\">"+
              "<tbody>"+
                "<tr>"+
                  "<td width=\"19%\" nowrap=\"nowrap\" style=\"padding-right:10px\"><span class=\"calDIV\" style=\"overflow:auto;\">";
    
	//operations
	var operations = this.mOptions.specialOperations;
	var id = this.id;
	if(operations != null){
		$.each(operations,function(i,operation){
			
			content += "<input class=\"crmbutton small edit\" type=\"button\" value=\""+operation.name+"\" onclick=\"doSpecialOperation('"+id+"',"+i+");\" style=\"width:80\" />";

		});
	}
	

	content += 		"</span>"+
				   "</td>"+
				   "<td width=\"19%\" nowrap=\"nowrap\" class=\"small\" style=\padding-right:20px\"><img id=\"loading."+id+"\" src=\"../images/loading2.gif\" style=\"display:none;\"/></td>"+
                  "<td width=\"32%\" align=\"center\" nowrap=\"nowrap\" class=\"small\"> 共 <span id=\"totalPage1\"> 1</span> 页，<img src=\"../images/previous_disabled.gif\" border=\"0\" onclick=\"doPageUp('"+id+"');\" align=\"absmiddle\" title=\"上一页\"/>&nbsp;当前第&nbsp;<span id=\"currentPage1\">1</span>&nbsp;页&nbsp;<img src=\"../images/next_disabled.gif\" border=\"0\" onclick=\"doPageDown('"+id+"');\" align=\"absmiddle\" title=\"下一页\"/></td>"+
                  "<td width=\"30%\" align=\"right\" class=\"small\" style=\"padding-right:20px\">每页显示 	"+this.mOptions.pageCount+" 条记录&nbsp;&nbsp;&nbsp;<img src=\"../images/excel.gif\" border=\"0\" onclick=\"doToExcel('"+id+"');\" align=\"absmiddle\" title=\"导出Excel\"/></td>"+
                "</tr>"+
              "</tbody>"+
            "</table>";
	
     $(this.mOptions.parentContainer).append(content);
     if(this.mOptions.specialOperations == null || this.mOptions.specialOperations.length == 0){
 		$(this.mOptions.parentContainer).append("<div style=\"margin-top:3px;\"/>");
 	}
};

HouQianTable.prototype.appendBottomNavigation = function(){
	if(this.isHideHeader){
		return;
	}
	if(this.mOptions.specialOperations == null || this.mOptions.specialOperations.length == 0){
		$(this.mOptions.parentContainer).append("<div style=\"margin-top:2px;\"/>");
	}
	var content = "<!-- 下部分导航 -->"+
            "<table border=\"0\" cellspacing=\"0\" cellpadding=\"2\" width=\"98%\">"+
              "<tbody>"+
                "<tr>"+
                  "<td width=\"38%\" nowrap=\"nowrap\" style=\"padding-right:10px\">";
	//operations
	var operations = this.mOptions.specialOperations;
	var id = this.id;
	if(operations != null){
		$.each(operations,function(i,operation){
			
			content += "<input class=\"crmbutton small edit\" type=\"button\" value=\""+operation.name+"\" onclick=\"doSpecialOperation('"+id+"',"+i+");\" style=\"width:80\" />";

		});
	}
    
	content +=     "</td>"+
                  "<td width=\"32%\" align=\"center\" nowrap=\"nowrap\" class=\"small\"> 共 <span id=\"totalPage2\"> 1</span> 页，<img src=\"../images/previous_disabled.gif\" border=\"0\" align=\"absmiddle\"  onclick=\"doPageUp('"+id+"');\" title=\"上一页\"/>&nbsp;当前第&nbsp;<span id=\"currentPage2\">1</span>&nbsp;页&nbsp;<img src=\"../images/next_disabled.gif\" border=\"0\" align=\"absmiddle\"  onclick=\"doPageDown('"+id+"');\" title=\"下一页\"/></td>"+
                  "<td width=\"30%\" align=\"right\" class=\"small\" style=\"padding-right:20px\">每页显示 "+this.mOptions.pageCount+" 条记录&nbsp;&nbsp;&nbsp;<img src=\"../images/excel.gif\" border=\"0\" onclick=\"doToExcel('"+id+"');\" align=\"absmiddle\" title=\"导出Excel\"/></td>"+
                "</tr>"+
              "</tbody>"+
            "</table>";
    $(this.mOptions.parentContainer).append(content);
    if(this.mOptions.specialOperations == null || this.mOptions.specialOperations.length == 0){
		$(this.mOptions.parentContainer).append("<div style=\"margin-top:3px;\"/>");
	}
};
HouQianTable.prototype.buildTableProperty = function(){
	var id = this.id;
	//table properties
	var tableProperty = "<tr>";
	
	//selectType
	if(this.mOptions.selectType == SelectType.Radio){//单选
		tableProperty = tableProperty + "<td height=\"28px\" width=\"3%\" class=\"lvtCol\"><div align=\"center\"></div></td>";
	}else if(this.mOptions.selectType == SelectType.Check){//多选
		tableProperty = tableProperty + "<td height=\"28px\" width=\"3%\" class=\"lvtCol\">"+
		"<div align=\"center\"><input type=\"checkbox\" id=\"CheckAll."+id+"\" value=\"-1\" onclick=\"doCheckAll('"+id+"')\"></div></td>";	
	}
	
	//设置值
	var columns = this.mOptions.columns;
	var length = columns.length;
	var sortColumnIndex = this.sortParams.column;
	var sortType = this.sortParams.type;
	for(var i=0;i<length;i++){
		if(this.mOptions.sortable != null && this.mOptions.sortable == true){
			tableProperty += "<td width=\""+columns[i].width+"\" align=\"left\" class=\"lvtCol\" onclick=\"doSort('"+id+"',"+i+");\" >"+columns[i].name;
			
			if(sortColumnIndex == i && sortType == SortType.Desc){
				tableProperty += "<img src=\"../images/arrow_down.gif\" id=\"SortDesc."+i+"."+id+"\" border=\"0\">";
			}else{
				tableProperty += "<img src=\"../images/arrow_down.gif\" hidden id=\"SortDesc."+i+"."+id+"\" border=\"0\">";
			}
			
			if(sortColumnIndex == i && sortType == SortType.Asc){
				tableProperty += "<img src=\"../images/arrow_up.gif\" id=\"SortAsc."+i+"."+id+"\" border=\"0\"></td>";
			}else{
				tableProperty += "<img src=\"../images/arrow_up.gif\" id=\"SortAsc."+i+"."+id+"\" hidden border=\"0\"></td>";
			}
		}else{
			tableProperty += "<td width=\""+columns[i].width+"\" align=\"left\" class=\"lvtCol\" onclick=\"doSort('"+id+"',"+i+");\" >"+columns[i].name+"</td>";
		}
	}
	
	//通用操作
	var commonOperations = this.mOptions.commonOperations;
	if(commonOperations != null){
		var length = commonOperations.length;
		if(length >= 3){
			tableProperty += "<td width=\"15%\" align=\"left\" class=\"lvtCol\">操作</td>";
		}else if(length>0){
			tableProperty += "<td width=\"10%\" align=\"left\" class=\"lvtCol\">操作</td>";
		}
	}
	
	tableProperty +="</tr>";
	
	return tableProperty;
};
HouQianTable.prototype.appendContent = function(){
	//table header
	var tableHeader = "<div class=\"calDIV\" style=\"overflow:auto;\">"+
              "<table border=\"0\" cellspacing=\"1\" cellpadding=\"3\" width=\"100%\" class=\"lvt small\">"+
                "<tbody id=\"tableContent\">";
	
    
    var tableProperty = this.buildTableProperty();
    //table footer
    var tableFooter = "</tbody></table></div>";
    
    $(this.mOptions.parentContainer).append(tableHeader+tableProperty+tableFooter);
};
HouQianTable.prototype.appendCommonSearchBox = function(){
	var content =	"<table width=\"652\" height=\"40\" cellpadding=\"5\" cellspacing=\"0\" align=\"center\" border=\"0\" class=\"search_table\">"+
						"<tbody>"+
							"<tr>"+
								"<td></td>"+
								"<td align=\"left\" nowrap=\"nowrap\"><span class=\"search_title\">搜索 - 物料类别</span></td>"+
								"<td nowrap=\"nowrap\" align=\"right\" valign=\"middle\"><b>在</b>&nbsp;"+
									"<select id=\"categoryASearchConditionId\" name=\"searchCondition\" class=\"search_input\" style=\"width:120px\">"+
										"<option value=\"name\">类别名称</option>"+
									"</select>"+ 
									"<b>中&nbsp;&nbsp;&nbsp;&nbsp;查找&nbsp;&nbsp;&nbsp;&nbsp;</b>"+
									"<input type=\"text\" name=\"keyword\" class=\"search_input\" style=\"width:150px\" id=\"categoryKeywordId\">&nbsp;&nbsp;"+
									"<input type=\"button\" value=\" 立刻查找 \" class=\"search_button\" onclick=\"categorySearch()\">"+
								"</td>"+
								"<td></td>"+
							"</tr>"+
						"</tbody>"+
					"</table>";
};
HouQianTable.prototype.getUrlParam = function(){ 
    var url = location.href; 
    var index = url.lastIndexOf("#");
    if(index == -1){
    	return 0;
    }else{
    	return url.substring(index+1,url.length);
    }
};

HouQianTable.prototype.inSelectedItems = function(items,item){
	var len = items.length;
	for(var i=0;i<len;i++){
		if(items[i].id == item.id){
			return true;
		}
	}
	
	return false;
};

HouQianTable.prototype.buildSortString = function(){
	var sortParams = this.sortParams;
	var columnIndex = sortParams.column;
	var type = sortParams.type;
	if(columnIndex < 0){
		return "";
	}else{
		var column = this.mOptions.columns[columnIndex];
		var sortParams = "{\"property\":\""+column.bindingProperty+"\",\"type\":"+type+"}";
		return sortParams;
	}
	
};

