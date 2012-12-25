// JavaScript Document
function cascadeChoose(url,level1,level2,level3,level4,isParent){
		level1.click(function(){
			var levelVal = level1.val();
			if(levelVal != null){
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
			}else{
				level1.empty();
				level2.empty();
				level3.empty();
				if(level4!=null){
					level4.empty();
				}
				categoryList(url,level1,"categoryValue=0");
			}
			setLevel1Disable(level2,level3,level4);
		});
		
		level2.click(function(){
			var levelVal = level2.val();
			if(levelVal != -1){
				level3.empty();
				if(level4!=null){
					level4.empty();
				}
				if(isParent){
					categoryList(url,level3,"categoryValue=2&id="+levelVal);
				}else{
					categoryList(url,level3,"categoryValue=2");
				}
				
			}else{
				level2.empty();
				level3.empty();
				if(level4!=null){
					level4.empty();
				}
				categoryList(url,level2,"categoryValue=1");
			}
			setLevel2Disable(level2,level3,level4);
		});
		
		level3.click(function(){
			var levelVal = level3.val();
			if(levelVal != -1){
				if(level4!=null){
					level4.empty();
					if(isParent){
						categoryList(url,level4,"categoryValue=3&id="+levelVal);
					}else{
						categoryList(url,level4,"categoryValue=3");
					}
				}
			}else{
				level3.empty();
				if(level4!=null){
					level4.empty();
				}
				categoryList(url,level3,"categoryValue=2");
			}
			setLevel3Disable(level2,level3,level4);
		});
}

function setLevel1Disable(level2,level3,level4){
	level2.attr("disabled",false);
	level3.attr("disabled","diabled");
	level4.attr("disabled","diabled");
}

function setLevel2Disable(level2,level3,level4){
	level2.attr("disabled",false);
	level3.attr("disabled",false);
	level4.attr("disabled","diabled");
}

function setLevel3Disable(level2,level3,level4){
	level2.attr("disabled",false);
	level3.attr("disabled",false);
	level4.attr("disabled",false);
}