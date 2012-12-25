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
function doSpecialOperation(id,opID){
	//radio 没选中
	if(gOptions[id].selectType == 1 && gTable[id].radioID == -1){
		callback();//没选中，函数参数为空
	}
	var specialOperations = gOptions[id].specialOperations;
	var operation = specialOperations[opID];
	
	//has callback
	var callback = operation.callback;
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

var gOptions;
var gTable;
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
	var id = this.mOptions.parentContainer;
	this.id = id;
	if(gOptions == null){
		gOptions = [];
	}
	if(gTable == null){
		gTable = [];
	}
	gOptions[id] = options;
	gTable[id] = this;
	this.init();
}

//functions
//init
HouQianTable.prototype.init = function(){
	//append header
	$(this.mOptions.parentContainer).append("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" class=\"lvtBg\">"+
      "<tbody><tr></td>");
	
	//append top navigation
	this.appendTopNavigation();
	
	//append content
	this.appendContent();
	
	//append bottom navigation
	this.appendBottomNavigation();
	
	//append footer
	$(this.mOptions.parentContainer).append("</td></tr></tbody></table>");
	
	//request data
	this.requestData(0,this.mOptions.pageCount);
};
HouQianTable.prototype.requestData = function(start,count){
	var options = this.mOptions;
	var table = this;
	var id = this.id;
	var div = this.mOptions.parentContainer;
	var tabIndex = this.getUrlParam();
	//alert(parseData.table);
	var url = "";
	if(this.mOptions.url.indexOf("?")>0){
		url = this.mOptions.url+"&start="+start+"&limit="+count+"&rand="+Math.random();
	}else{
		url = this.mOptions.url+"?start="+start+"&limit="+count+"&rand="+Math.random();
	}
	$.getJSON(url,
			function(data){
				table.data = data;
				
				var tableContent = "";
				var datas = data.root;
				$.each(datas,function(i,item){
					var tableTr = "<tr bgcolor=\"white\" onmouseover=\"this.className='lvtColDataHover'\" onmouseout=\"this.className='lvtColData'\">";
					
					if(options.selectType == 1){
						tableTr += "<td ><div align=\"center\"><input type=\"radio\" name=\"id\" onclick=\"doRadioClick('"+id+"',"+i+")\"/></div></td>";
					}
					
					//columns
					
					var columns = options.columns;
					$.each(columns,function(j,column){
						
						if(column.callback != null){
							tableTr += "<td  height=\"19px\" align=\"left\" ><a href=\"#"+tabIndex+"\" onclick=\"doColumnCallback('"+id+"',"+i+","+j+");\">"+item[column.bindingProperty]+"</a></td>";
						}else{
							tableTr += "<td  height=\"19px\" align=\"left\" >"+item[column.bindingProperty]+"</td>";
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
HouQianTable.prototype.refresh = function(){
	this.currentPage = 1;
	this.requestData((this.currentPage-1)*this.mOptions.pageCount, this.mOptions.pageCount);
};
HouQianTable.prototype.appendTopNavigation = function(){
	var content = "<!-- 上部分导航 -->"+
            "<table border=\"0\" cellspacing=\"0\" cellpadding=\"2\" width=\"98%\" class=\"small\">"+
              "<tbody>"+
                "<tr>"+
                  "<td width=\"38%\" nowrap=\"nowrap\" style=\"padding-right:10px\"><span class=\"calDIV\" style=\"overflow:auto;\">";
    
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
                  "<td width=\"32%\" align=\"center\" nowrap=\"nowrap\" class=\"small\"> 共 <span id=\"totalPage1\"> 1</span> 页，<img src=\"../images/previous_disabled.gif\" border=\"0\" onclick=\"doPageUp('"+id+"');\" align=\"absmiddle\" alt=\"上一页\"/>&nbsp;当前第&nbsp;<span id=\"currentPage1\">1</span>&nbsp;页&nbsp;<img src=\"../images/next_disabled.gif\" border=\"0\" onclick=\"doPageDown('"+id+"');\" align=\"absmiddle\" alt=\"下一页\"/></td>"+
                  "<td width=\"30%\" align=\"right\" class=\"small\" style=\"padding-right:20px\">每页显示 	"+this.mOptions.pageCount+" 条记录</td>"+
                "</tr>"+
              "</tbody>"+
            "</table>";
    
     $(this.mOptions.parentContainer).append(content);
};

HouQianTable.prototype.appendBottomNavigation = function(){
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
                  "<td width=\"32%\" align=\"center\" nowrap=\"nowrap\" class=\"small\"> 共 <span id=\"totalPage2\"> 1</span> 页，<img src=\"../images/previous_disabled.gif\" border=\"0\" align=\"absmiddle\"  onclick=\"doPageUp('"+id+"');\" alt=\"上一页\"/>&nbsp;当前第&nbsp;<span id=\"currentPage2\">1</span>&nbsp;页&nbsp;<img src=\"../images/next_disabled.gif\" border=\"0\" align=\"absmiddle\"  onclick=\"doPageDown('"+id+"');\" alt=\"下一页\"/></td>"+
                  "<td width=\"30%\" align=\"right\" class=\"small\" style=\"padding-right:20px\">每页显示 "+this.mOptions.pageCount+" 条记录</td>"+
                "</tr>"+
              "</tbody>"+
            "</table>";
    $(this.mOptions.parentContainer).append(content);
};
HouQianTable.prototype.buildTableProperty = function(){
	//table properties
	var tableProperty = "<tr>";
	//selectType
	if(this.mOptions.selectType == 1){
		tableProperty = tableProperty + "<td height=\"28px\" width=\"3%\" class=\"lvtCol\"><div align=\"center\"></div></td>";
		var columns = this.mOptions.columns;
		var length = columns.length;
		for(var i=0;i<length;i++){
			tableProperty += "<td width=\""+columns[i].width+"\" align=\"left\" class=\"lvtCol\">"+columns[i].name+"</td>";
		}
	}else{//no select type
		var columns = this.mOptions.columns;
		var length = columns.length;
		for(var i=0;i<length;i++){
			tableProperty += "<td height=\"28px\" width=\""+columns[i].width+"\" align=\"left\" class=\"lvtCol\">"+columns[i].name+"</td>";
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

HouQianTable.prototype.getUrlParam = function(){ 
    var url = location.href; 
    var index = url.lastIndexOf("#");
    if(index == -1){
    	return 0;
    }else{
    	return url.substring(index+1,url.length);
    }
};

