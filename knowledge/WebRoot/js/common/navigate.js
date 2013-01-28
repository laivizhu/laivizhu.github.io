var navigate={
	user:[{url:'user.jsp',title:'个人信息'},{url:'user_article.jsp',title:'博文记录'},{url:'#',title:'知识管理'},{url:'user_album.jsp',title:'相册'}]
};


var loadLocalNavigate=function(list){
	$.each(list,function(i,item){
		$("#navigateLeftULId").append("<li><a href='"+item.url+"'><i class='icon-chevron-right'></i>"+item.title+"</a></li>");
	});
};

var loadRemoteNavigate=function(getUrl,viewUrl){
	laivi.getJson(getUrl, function(result){
		$.each(result.root,function(i,item){
			$("#navigateLeftULId").append("<li><a href='"+viewUrl+item.id+"'><i class='icon-chevron-right'></i>"+item.name+"</a></li>");
		});
	});
};