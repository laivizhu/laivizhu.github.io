var navigate={
	user:[
	  {url:'user_space.jsp',title:'个人空间'},
	  {url:'user_friend.jsp',title:'朋友管理'},
      {url:'user.jsp',title:'个人信息'},
      {url:'user_article.jsp',title:'博文记录'},
      {url:'user_knowledge.jsp',title:'知识管理'},
      {url:'user_album.jsp',title:'相册'},
      {url:'user_book.jsp',title:'书籍'},
      {url:'user_musicAlbum.jsp',title:'音乐专辑'}
    ]
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