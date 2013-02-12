var currentDialog;
var pageCount=10;
var pageSize=0;
var firstTime=true;
var laivi={
	init:function(otherHandler){
		$(window).scroll(function(){
			if($(document).scrollTop()==0){
				$("#backTopDivId").hide();
			}else{
				$("#backTopDivId").show();
			}
		});
		otherHandler();
	},
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
	getJson:function(url,successHandler,isLoding,params){
		url=laivi.getRandParamUrl(url);
		if(isLoding!=null && isLoding){
			laivi.showLoding('加载中');
		}
		$.getJSON(url,params,function(result){
			if(result.success){
				successHandler(result);
				$.jBox.closeTip();
			}else{
				laivi.errorMsg(result.msg);
			}
		});
	},
	setFormVaule:function(url,isInput,OtherHandler,params){
		if(isInput==null){
			isInput=false;
		}
		url=laivi.getRandParamUrl(url);
		laivi.getJson(url, function(result){
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
			if(OtherHandler!=null){
				OtherHandler(result);
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
		url=laivi.getRandParamUrl(url);
		var options = { 
		    target:formObject,
		    url: url,
		    beforeSubmit:function(){
		    	laivi.showLoding("处理中");
		    },
		    dataType:'json',
		    type:'post',
		    success:function(data){
		    	if(isIncludeFile){
		    		if(data.success){
		    			var msg=data.responseText+"";
			    		if(msg.indexOf('success')!=-1){
			    			successHandler(data);
			    		}else{
			    			laivi.alert(data.responseText);
			    		}
			    	}else{
			    		laivi.errorMsg(data.msg);
			    	}
		    	}else{
		    		if(data.success){
			    		successHandler(data);
			    	}else{
			    		laivi.errorMsg(data.msg);
			    	}
		    	}
		    	$.jBox.closeTip();
		    },
		    error:function(data){
		    	if(isIncludeFile){
		    		var msg=data.responseText+"";
		    		if(msg.indexOf('success')!=-1){
		    			successHandler(data);
		    		}else{
		    			laivi.alert(data.responseText);
		    		}
		    	}else{
		    		laivi.alert(data.msg);
		    	}
		    	$.jBox.closeTip();
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
	    return laivi.getUrlVars()[name];
	},
	isIncludeParam:function(url){					//判断一个url是否有参数
		if(url.indexOf('?')!=-1){
			return true;
		}else{
			return false;
		}
	},
	getRandParamUrl:function(url){					//在url后构造随机数参数
		if(laivi.isIncludeParam(url)){
			return url+'&searialRand='+parseInt(100*Math.random());
		}else{
			return url+'?searialRand='+parseInt(100*Math.random());
		}
	},
	getCurrentDateString:function(){
		var d=new Date();
		return (d.getFullYear())+'年/'+ (d.getMonth() + 1) + '月/' + (d.getDate()) + '日/星期'+(d.getDay()==0?'日':d.getDay());
	},
	isNotNull:function(data,msg){					//判断数据是否为空，并提示错误
		msg=msg||'请选择一条记录';
		if(data==null){
			laivi.alert(msg);
			return false;
		}else{
			return true;
		}
	},
	comboList:function(combo,url,successHandler){					//在下拉框中设置从后台获取的数据
		url=laivi.getRandParamUrl(url);
		$.getJSON(url,function(data){
			$.each(data.root,function(i,item){
				console.log(item.text);
				combo.append("<option value='"+item.value+"'>"+item.text+"</option>");
			});
			if(successHandler!=null){
				successHandler();
			}
		});
	},
	showLoding:function(title){
		$.jBox.tip(title, 'loading');
	},
	closeLoding:function(title){
		$.jBox.tip(title, 'success');
	},
	dialogOpen:function(object,title,height,width){
		currentDialog=object;
		object.dialog({
			autoOpen:false,
			title:title,
			width:width,
			height:height,
			modal:true,
			resizable:false
		});
		object.dialog("open");
	},
	dialogClose:function(){
		currentDialog.dialog("close");
	},
	getRadioValue:function(name){
		var obj;    
	    obj=document.getElementsByName(name);
	    if(obj!=null){
	        var i;
	        for(i=0;i<obj.length;i++){
	            if(obj[i].checked){
	                return obj[i].value;            
	            }
	        }
	    }
	    return null;
	},
	getScrollOnceData:function(url,start,obj,getDataDiv){
		if(url.indexOf('?')!=-1){
			url=url+'&start='+start+'&limit='+pageCount;
		}else{
			url=url+'?start='+start+'&limit='+pageCount;
		}
		laivi.getJson(url, function(data){
			if(data.totalProperty>0){
				if(data.totalProperty%pageCount==0){
					pageSize=data.totalProperty/pageCount;
				}else{
					pageSize=(data.totalProperty/pageCount)+1;
				}
				$.each(data.root,function(i,item){
					obj.append(getDataDiv(item));
				});
			}else{
				if(firstTime){
					obj.append("<div class='span8'><h4>暂无记录</h4></div>");
					firstTime=false;
				}
			}
		},true);
	},
	scrollBreakPage:function(url,obj,getDataDiv){
		pageSize=0;
		var range = 700;
		var num=0;
		laivi.getScrollOnceData(url,0,obj,function(item){
			return getDataDiv(item);
		});
		$(window).scroll(function(){
			//console.log("document.height:"+$(document).height());
			//console.log("document.scrollTop:"+$(document).scrollTop());
			if(range>=($(document).height()-$(document).scrollTop()) && pageSize>=num) {
				num++;
				laivi.getScrollOnceData(url,num*pageCount,obj,function(item){
					return getDataDiv(item);
				});
			}
		});
	},
	newJplayer:function(list){
		new jPlayerPlaylist({
			jPlayer: "#laivi_jplayerDivId",
			cssSelectorAncestor: "#laivi_containerDivId"
		},list,{
			swfPath: "jplayer",
			supplied: "wma,mp3",
			wmode: "window"
		});
	}
};

function getSoundManager(soundurl){
	soundManager = new SoundManager();
	// soundManager.waitForWindowLoad = true;
	// 是否打开调试模式，打开话对viewport有一定影响
	soundManager.debugMode = true;
	// 这个是soundManager提供的swf文件所在的文件夹
	soundManager.url = soundurl+'js/soundManage/swf';
	soundManager.beginDelayedInit();
	soundManager.onload = function() {
		// 这里面放入你要播放的声音
		// 系统声音
		soundManager.createSound({
			id : 'systemSound',
			url : soundurl+'js/soundManage/mp3/system.mp3',
			// autoLoad: true,//自动加载
			// multiShot: false,//true 在同一时刻只能有一个频段的声音
			//autoPlay : true,
		// 自动播放 这个是系统的背景音
		    volume: 100
		});
		// 信息音
		soundManager.createSound({
			id : 'msgSound',
			url : soundurl+'js/soundManage/mp3/msg.mp3',
		    volume: 100
		});
		// 加入音
		soundManager.createSound({
			id : 'joinSound',
			url : soundurl+'js/soundManage/mp3/join.mp3',
		    volume: 100
		});
	};
	return soundManager;
}

function userLogin(){
	laivi.submitForm($('#loginFormId'), 'user_login.action', function(){
		window.location.reload();
	}, false, true);
}

function userRegiest(){
	window.location.href="/knowledge/user/user_add.jsp";
}

function userLogout(){
	laivi.confirm('确认要注销吗？', function(){
		laivi.getJson('user_logout.action?fold=true', function(){
			window.location.href="/knowledge/index.jsp";
		});
	});
}

function deleteObject(url,msg){
	var message;
	if(msg==null){
		message='确认要删除吗？';
	}else{
		message=msg;
	}
	laivi.confirm(message, function(){
		laivi.getJson(url, function(){
			window.location.reload();
		});
	});
}

