var LaiviCarousel = function(options,afterHandler){
	this.options = options;
	this.init(function(){
		if(afterHandler) {
			afterHandler();
		}
	});
};

LaiviCarousel.prototype.init = function(afterHandler){
    var content = "<div id='myCarousel' class='carousel slide'><div class='carousel-inner'>";
    var dataUrl=this.options.url;
    var activeIndex=this.options.activeIndex;
    var container = this.options.parentContainer;
    if(activeIndex==null){
    	activeIndex=0;
    }
    $.getJSON(dataUrl,this.options.params,function(result){
		if(result.success){
			if(result.totalProperty!=0){
				$.each(result.root,function(i,item){
					if(i==activeIndex){
						content += "<div class='item active' align='center'>";
					}else{
						content += "<div class='item' align='center'>";
					}
					content += "<img src='picture/"+item.path+"' alt=''>";
					content +="<div class='carousel-caption' align='left'>";
					content +="<h4>"+item.description+"</h4>";
					content += "</div>";
					content += "</div>";
				});
				content +="<div><a class='carousel-control left' href='#myCarousel' data-slide='prev'>&lsaquo;</a><a class='carousel-control right' href='#myCarousel' data-slide='next'>&rsaquo;</a></div>";
			}else{
				content+="<div class='item active'><h4>暂无数据</h4></div></div>";
			}
			$(container).append(content);
		}else{
			console.log(result.msg);
		}
	});
	if(afterHandler) {
		afterHandler();
	}
};
