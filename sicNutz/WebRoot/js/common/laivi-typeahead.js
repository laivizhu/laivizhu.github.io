var LaiviTypeahead=function(options){
	this.options = options;
	this.init();
};

LaiviTypeahead.prototype.init = function(){
	var dataUrl=this.options.url;
	var object = this.options.object;
	$(object).attr('data-provide','typeahead');
	$(object).attr('data-items','10');
	$.getJSON(dataUrl,this.options.params,function(result){
		if(result.success){
			$(object).attr('data-source',"["+result.root+"]");
		}else{
			console.log(result.msg);
		}
	});
	
};