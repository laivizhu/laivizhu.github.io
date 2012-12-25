function showTab(now,count)
{
	for(var i=1; i<count+1; i++)
	{
		var tab  = $("#tab" + i);
		var div = $("#div" + i);
		
		if(i == now)
		{
			tab.removeClass("content_tab_title_unselected");
			tab.addClass("content_tab_title_selected");
			div.removeClass("content_tab_div_unselected");
			div.addClass("content_tab_div_selected");
		}
		else
		{
			tab.removeClass("content_tab_title_selected");
			tab.addClass("content_tab_title_unselected");
			div.removeClass("content_tab_div_selected");
			div.addClass("content_tab_div_unselected");
		}
	}
}

function DispContent( i , count){
	var m=i;
	var test = document.getElementById('test'+i);	
	var div = document.getElementById( 'div' + i );

	for(var n=1;n<6;n++){
	   if(m==n){
		   if( div.style.display == "none" ){
			   div.style.display = '';
		   }
		   if(test.className == "dvtUnSelectedCell"){
			   test.className="dvtSelectedCell";
		   }
	   }else{
	     var test_1= document.getElementById('test'+n);
	     var div_1 = document.getElementById('div'+n);
	     if( div_1.style.display =="none"){
	    	 div_1.style.display ="none";
	     }else 
	    	 div_1.style.display ="none";
	     if(test_1.className =="dvtUnSelectedCell"){
	    	 test_1.className="dvtUnSelectedCell";
	     }else
	    	 test_1.className="dvtUnSelectedCell";
	   }
	}
}

var houQian={
	confirm:function(title,OkHandler,NoHandler){
		$.jBox.confirm(title,'提示',function(v, h, f){
			if (v == 'ok'){
				OkHandler();
			}else{
				if(NoHandler!=null){
					NoHandler();
				}
				return true;
			}
		});
	},
	errorMsg:function(msg,tip){
		tip=tip||'错误';
		$.jBox.error(msg, '错误');
	},
	alert:function(msg,tip){
		tip=tip||'提示';
		$.jBox.alert(msg, tip);
	},
	getJson:function(url,successHandler,params){
		url=houQian.getRandParamUrl(url);
		$.getJSON(url,params,function(result){
			if(result.success){
				successHandler(result);
			}else{
				houQian.errorMsg(result.msg);
			}
		});
	},
	setFormVaule:function(url,isInput,params){
		if(isInput==null){
			isInput=false;
		}
		url=houQian.getRandParamUrl(url);
		houQian.getJson(url, function(result){
			for(var key in result.data){
				if($("#"+key+"FormFieldId")==null){
					continue;
				}
				if(isInput){
					var value=result.data[key]+"";
					if(value.indexOf('.xlsx')!=-1||value.indexOf('.pdf')!=-1){
						$("#"+key+"FormFieldId").html(result.data[key]);
					}else{
						$("#"+key+"FormFieldId").val(result.data[key]);
					}
				}else{
					$("#"+key+"FormFieldId").html(result.data[key]);
				}
			}
		},params);
	},
	submitForm:function(formObject,url,successHandler,isIncludeFile,isClick){
		if(isIncludeFile==null){
			isIncludeFile=false;
		}
		if(isClick==null){
			isClick=false;
		}
		url=houQian.getRandParamUrl(url);
		var options = { 
		    target:formObject,
		    url: url, 
		    dataType:'json',
		    type:'post',
		    success:function(data){
		    	if(isIncludeFile){
		    		successHandler(data);
		    	}else{
		    		if(data.success){
			    		successHandler(data);
			    	}else{
			    		houQian.errorMsg(data.msg);
			    	}
		    	}
		    },
		    error:function(data){
		    	if(isIncludeFile){
		    		var msg=data.responseText+"";
		    		if(msg.indexOf('success')!=-1){
		    			successHandler(data);
		    		}else{
		    			houQian.alert(data.responseText);
		    		}
		    	}else{
		    		houQian.alert(data.msg);
		    	}
		    }
		}; 
		if(isClick){
			formObject.ajaxSubmit(options);
		}else{
			formObject.ajaxForm(options);
		}
	},
	getUrlVars: function(){							//解析一个url，获取一个属性Map
		var vars = [], hash;
		var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
		for(var i = 0; i < hashes.length; i++){
			hash = hashes[i].split('=');
			vars.push(hash[0]);
			vars[hash[0]] = hash[1];
		}
		return vars;
	},
	getUrlVar: function(name){						//解析一个url，通过属性名获取对应的值
	    return houQian.getUrlVars()[name];
	},
	isIncludeParam:function(url){					//判断一个url是否有参数
		if(url.indexOf('?')!=-1){
			return true;
		}else{
			return false;
		}
	},
	getRandParamUrl:function(url){					//在url后构造随机数参数
		if(houQian.isIncludeParam(url)){
			return url+'&searialRand='+parseInt(100*Math.random());
		}else{
			return url+'?searialRand='+parseInt(100*Math.random());
		}
	},
	isNotNull:function(data,msg){					//判断数据是否为空，并提示错误
		msg=msg||'请选择一条记录';
		if(data==null){
			houQian.alert(msg);
			return false;
		}else{
			return true;
		}
	},
	comboList:function(combo,url){					//在下拉框中设置从后台获取的数据
		url=houQian.getRandParamUrl(url);
		$.getJSON(url,function(data){
			$.each(data.root,function(i,item){
				combo.append("<option value='"+item.id+"'>"+item.name+"</option>");
			});
		});
	}
};