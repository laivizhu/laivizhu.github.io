// JavaScript Document
function cascadeChoose(url,level1,level2,level3,level4,isParent){
		level2.attr("disabled","diabled");
		level3.attr("disabled","diabled");
		if(level4!=null){
			level4.attr("disabled","diabled");
		}
	
		level1.change(function(){
			var levelVal = level1.val();
			if(levelVal != null && levelVal!=0){
				level2.empty();
				level3.empty();
				if(level4!=null){
					level4.empty();
				}
				if(isParent){
					categoryList(url,level2,"categoryValue=1&id="+levelVal);
				}else{
					categoryList(url,level2,"categoryValue=1");
				}
				setLevel1Disable(level2,level3,level4);
			}else{
				level2.empty();
				level3.empty();
				level2.attr("disabled","diabled");
				level3.attr("disabled","diabled");
				if(level4!=null){
					level4.empty();
					level4.attr("disabled","diabled");
				}
			}
			
		});
		
		level2.change(function(){
			var levelVal = level2.val();
			if(levelVal != null && levelVal!=0){
				level3.empty();
				if(level4!=null){
					level4.empty();
				}
				if(isParent){
					categoryList(url,level3,"categoryValue=2&id="+levelVal);
				}else{
					categoryList(url,level3,"categoryValue=2");
				}
				setLevel2Disable(level2,level3,level4);
			}else{
				level2.empty();
				level3.empty();
				level3.attr("disabled","diabled");
				if(level4!=null){
					level4.empty();
					level4.attr("disabled","diabled");
				}
				categoryList(url,level2,"categoryValue=1");
			}
			
		});
		
		level3.change(function(){
			var levelVal = level3.val();
			if(levelVal !=null && levelVal!=0){
				if(level4!=null){
					level4.empty();
					if(isParent){
						categoryList(url,level4,"categoryValue=3&id="+levelVal);
					}else{
						categoryList(url,level4,"categoryValue=3");
					}
				}
				setLevel3Disable(level2,level3,level4);
			}else{
				level3.empty();
				if(level4!=null){
					level4.empty();
					level4.attr("disabled","diabled");
				}
				categoryList(url,level3,"categoryValue=2");
			}
			
		});
}

function setLevel1Disable(level2,level3,level4){
	level2.attr("disabled",false);
	level3.attr("disabled","diabled");
	if(level4!=null){
		level4.attr("disabled","diabled");
	}
	
}

function setLevel2Disable(level2,level3,level4){
	level2.attr("disabled",false);
	level3.attr("disabled",false);
	if(level4!=null){
		level4.attr("disabled","diabled");
	}
}

function setLevel3Disable(level2,level3,level4){
	level2.attr("disabled",false);
	level3.attr("disabled",false);
	if(level4!=null){
		level4.attr("disabled",false);
	}
	
}