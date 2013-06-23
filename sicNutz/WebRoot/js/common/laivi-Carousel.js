var LaiviCarousel = function(options,afterHandler){
	this.options = options;
	this.init(function(){
		if(afterHandler) {
			afterHandler();
		}
	});
};

LaiviCarousel.prototype.init = function(afterHandler){
    var content = "<div id='myCarousel' class='carousel slide'>";
    var dataUrl=this.options.url;
    var activeIndex=this.options.activeIndex;
    var container = this.options.parentContainer;
    if(activeIndex==null){
    	activeIndex=0;
    }
    $.getJSON(dataUrl,this.options.params,function(result){
		if(result.success){
			if(result.totalProperty!=0){
				content +="<ol class='carousel-indicators'>";
				for(var j=0;j<result.totalProperty;j++){
					if(j==0){
						content+="<li data-target='#myCarousel' data-slide-to='0' class='active'></li>";
					}else{
						content+="<li data-target='#myCarousel' data-slide-to='"+j+"'></li>";
					}
				}
				content +="</ol><div class='carousel-inner'>";
				$.each(result.root,function(i,item){
					if(i==activeIndex){
						content += "<div class='item active' align='center'>";
					}else{
						content += "<div class='item' align='center'>";
					}
					content += "<img src='"+item.path+"' alt=''>";
					content +="<div class='carousel-caption' align='left'>";
					
					content +="<h4><a href='"+item.url+"'>"+item.title+"</a></h4>";
					content +="<p>"+item.description+"</p>";
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
