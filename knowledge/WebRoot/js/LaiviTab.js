var changeTab = function(i,afterHandler){
	var currentTab = document.getElementById(gTab.tabID + i);	
	var currentPage = document.getElementById(gTab.pageID + i );
	
	//change state
	var length = gTab.options.tabs.length;
	for(var j = 0;j < length; j++){
	   if(i==j){
		   currentPage.style.display='';
		   currentPage.className="tab-pane fade in active";
		   currentTab.className="active";
		   
	   }else{
	     var tab= document.getElementById(gTab.tabID + j);
	     var page = document.getElementById(gTab.pageID + j);
	     page.style.display ="none";
	     tab.className = "";
	   }
	}

	//load
	if(!gTab.tabsLoaded[i] || gTab.options.isAjax ){
		var page = gTab.options.tabs[i].page;
		var pageID = gTab.pageID + i;
		gTab.tabsLoaded[i] = true;
		$.get(page, function(result){
		    $("#"+pageID).html(result);
		    if(afterHandler!=null){
				afterHandler();
			}
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

var LaiviTab = function(options,afterHandler){
	this.options = options;
	this.tabID = "laiviTab";
	this.pageID = "laiviPage";
	this.tabsLoaded = [];
	gTab = this;
	this.init(function(){
		if(afterHandler) {
			afterHandler();
		}
	});
};

LaiviTab.prototype.init = function(afterHandler){
	var tabs = this.options.tabs;
	var tabsLoaded = this.tabsLoaded;
	$.each(tabs,function(i,tab){
		tabsLoaded[i] = false;
	});

    var content = "<ul class='nav nav-tabs'>";
    var tabs = this.options.tabs;
    var tabID = this.tabID;
    var pageID = this.pageID;
    $.each(tabs,function(i,tab){
    	content += "<li id='"+tabID+i+"'><a onClick=changeTab("+i+") data-toggle='tab'>"+tab.name+"</a></li>";
    });
		                        
	content +="</ul><div class='tab-content'>";
	$.each(tabs,function(i,tag){
		content += "<div id='"+pageID+i+"' class='tab-pane fade'>";
		content += "</div>";
	});
				                         
	content +="</div>";
	var container = this.options.parentContainer;
	$(container).append(content);
	
	var index = this.getUrlParam();
	changeTab(index,function(){
		afterHandler();
	});
};

LaiviTab.prototype.getUrlParam = function(){ 
    var url = location.href; 
    var index = url.lastIndexOf("#");
    if(index == -1){
    	return 0;
    }else{
    	return url.substring(index+1,url.length);
    }
};

