var pageSize=0;
$(document).ready(function(){
	var keyword=laivi.getUrlVar('value');
	var range = 600;
	var num=0;
	getJsonData(keyword,0);
	$(window).scroll(function(){
		if(($(document).height()-$(document).scrollTop()) <= range && pageSize>=num) {
			num++;
			getJsonData(keyword,num*pagecount);
		}
	});
});

function getDataDiv(item){
	var data="<h2>"+item.title+"</h2>"+"</br><hr>"+"<p>"+item.question+"</p>"+"</br><hr><p>"+item.content+"</p></br><hr color='red'>";
	return data;
}

function getJsonData(keyword,start){
	var result=$("#resultDivId");
	laivi.getJson('picture_showResult.action?value='+keyword+'&start='+start+'&limit='+pagecount, function(data){
		if(data.totalProperty>0){
			if(data.totalProperty%pagecount==0){
				pageSize=data.totalProperty/pagecount;
			}else{
				pageSize=(data.totalProperty/pagecount)+1;
			}
			$.each(data.root,function(i,item){
				result.append(getDataDiv(item));
			});
		}else{
			result.append("未搜到相关信息");
		}
	});
}