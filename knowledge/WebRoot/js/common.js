var plug={
	raty:function(taget,getScoreUrl,setScoreUrl){
		laivi.getJson(getScoreUrl, function(result){
			$(taget).raty({
				score:result.data.score,
				click:function(score,event){
					laivi.getJson(setScoreUrl+'&score.score='+score, function(){
						laivi.alert('谢谢你的评价！');
						$(taget).raty({
							score:score,
							readOnly:true,
							noRatedMsg:'已经评价了'
						});
					});
				}
			});
		});
	}
};