var changeTab = function(i){
	
	var currentTab = document.getElementById(gTab.tabID + i);	
	var currentPage = document.getElementById(gTab.pageID + i );
	
	//change state
	var length = gTab.options.tabs.length;
	for(var j = 0;j < length; j++){
	   if(i==j){
		   
		   currentPage.style.display = '';
		   currentTab.className="dvtSelectedCell";
		   
	   }else{
		   
	     var tab= document.getElementById(gTab.tabID + j);
	     var page = document.getElementById(gTab.pageID + j);
	     page.style.display ="none";
	     tab.className = "dvtUnSelectedCell";
	   }
	}

	//load
	if(!gTab.tabsLoaded[i]){
		var page = gTab.options.tabs[i].page;
		var pageID = gTab.pageID + i;
		gTab.tabsLoaded[i] = true;
		$.get(page, function(result){
		    $("#"+pageID).html(result);
		  });
	}
	
	//change url 
	var url = location.href;
	var index = url.lastIndexOf("#");
	if(index == -1){
		location.href += "#" + i;
	}else{
		var subStr = url.substring(0, index);
		location.href = subStr + "#" + i;
	}
	
};

var gTab;

var HouqianTab = function(options){
	this.options = options;
	this.tabID = "houqiantab";
	this.pageID = "houqianpage";
	this.tabsLoaded = [];
	gTab = this;
	this.init();
};

HouqianTab.prototype.init = function(){
	var tabs = this.options.tabs;
	var tabsLoaded = this.tabsLoaded;
	$.each(tabs,function(i,tab){
		tabsLoaded[i] = false;
	});
	
    var content = "<div class=\"contentListDiv\">"+
				      "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"+
				        "<tbody>"+
				          "<tr>"+
				            "<td>"+
				            	"<table class=\"small\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">"+
				                    "<tbody>"+
				                      "<tr>";
    var tabs = this.options.tabs;
    var tabID = this.tabID;
    var pageID = this.pageID;
    $.each(tabs,function(i,tab){
    	content += "<td class=\"dvtTabCache\" style=\"width: 10px;\" nowrap=\"nowrap\">&nbsp;</td>";
    	content += "<td id=\""+tabID+i+"\" class=\"dvtSelectedCell\" align=\"center\" nowrap=\"nowrap\" onClick=\"changeTab("+i+");\">"+tab.name+"</td>";
    });
	content += "<td class=\"dvtTabCache\" style=\"width: 100%;\">&nbsp;</td>";	                        
				                        
				                        
				                        
	content +=		                     "</tr>"+
				                   "</tbody>"+
				             	"</table>"+
				              "</td>"+
				          "</tr>"+
				          "<tr>"+
				            "<td align=\"left\" valign=\"top\"><table class=\"dvtContentSpace\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">"+
				                "<tbody>"+
				                  "<tr>"+
				                    "<td align=\"left\"><!-- content cache -->"+
				                      "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"+
				                        "<tbody>"+
				                          "<tr>"+
				                            "<td style=\"padding: 10px;\">";
	$.each(tabs,function(i,tag){
		content += "<div id=\""+pageID+i+"\">";
		content += "</div>";
	});
				                      		  
				                         
	content +=			                   "</td>"+
				                          "</tr>"+
				                        "</tbody>"+
				                      "</table>"+
				                     "</td>"+
				                  "</tr>"+
				                "</tbody>"+
				              "</table>"+
				            "</td>"+
				          "</tr>"+
				        "</tbody>"+
				      "</table>";
	var container = this.options.parentContainer;
	$(container).append(content);
	
	var index = this.getUrlParam();
	changeTab(index);
};
HouqianTab.prototype.getUrlParam = function(){ 
    var url = location.href; 
    var index = url.lastIndexOf("#");
    if(index == -1){
    	return 0;
    }else{
    	return url.substring(index+1,url.length);
    }
};

