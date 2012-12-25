var pageSize=8;
var currentDialog;

var categoryList=function(url,level,params){
	if(params!=null){
		url=url+"?"+params+getRandParam();
	}else{
		url=url+getRandParam(false);
	}
	
	$.getJSON(url,function(data){
		$.each(data.root,function(i,item){
			level.append("<option value='"+item.id+"'>"+item.name+"</option>");
		});
	});
};

var dialogOpen=function(object,title,height,width){
	currentDialog=object;
	object.dialog({
		autoOpen:false,
		title:title,
		width:width,
		height:height,
		modal:true,
		resizable:false
	});
	//$("body").css("overflow","hidden");
	object.dialog("open");
};

var dialogClose=function(){
	currentDialog.dialog("close");
};

var getRandParam=function(isHaveParam){
	if(isHaveParam==null || isHaveParam){
		return '&searialRand='+parseInt(100*Math.random());
	}else{
		return '?searialRand='+parseInt(100*Math.random());
	}
};
