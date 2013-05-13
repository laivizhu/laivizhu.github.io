var sicValue={
		page:{
			pageCount:10,
			pageSize:0,
			firstTime:true
		}
};

var sic={
		//**********************************************基本函数处理**********************************************
		basic:{
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
			    return sic.basic.getUrlVars()[name];
			},
			isIncludeParam:function(url){					//判断一个url是否有参数
				if(url.indexOf('?')!=-1){
					return true;
				}else{
					return false;
				}
			},
			getRandParamUrl:function(url){					//在url后构造随机数参数
				if(sic.basic.isIncludeParam(url)){
					return url+'&searialRand='+parseInt(100*Math.random());
				}else{
					return url+'?searialRand='+parseInt(100*Math.random());
				}
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
		    }
		},
		//**********************************************消息函数处理**********************************************
		msg:{
			alert:function(msg,tip){
				$.jBox.alert(msg, tip||'提示');
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
			error:function(msg,tip){
				$.jBox.error(msg, tip||'错误');
			},
			showLoding:function(title){
				$.jBox.tip(title, 'loading');
			},
		},
		//**********************************************后台请求函数处理**********************************************
		common:{
			jumpToTop:function(speed){
				var defaultSpeed=1000;
				if(speed!=null){
					defaultSpeed=speed;
				}
				$("html,body").animate({scrollTop: 0}, defaultSpeed);
			},
			getJson:function(url,successHandler,isLoding,params){
				url=sic.basic.getRandParamUrl(url);
				if(isLoding!=null && isLoding){
					sic.msg.showLoding('加载中');
				}
				$.getJSON(url,params,function(result){
					if(result.success){
						if(successHandler!=null){
							successHandler(result);
						}
						$.jBox.closeTip();
					}else{
						sic.msg.error(result.msg);
					}
				});
			},
			setFormVaule:function(url,isInput,OtherHandler,params){
				if(isInput==null){
					isInput=false;
				}
				url=sic.basic.getRandParamUrl(url);
				sic.common.getJson(url, function(result){
					for(var key in result.data){
						if($("#"+key+"FormFieldId")==null){
							continue;
						}
						if(isInput){
							$("#"+key+"FormFieldId").val(result.data[key]);
						}else{
							if(key=='id'){
								$("#"+key+"FormFieldId").val(result.data[key]);
							}else{
								$("#"+key+"FormFieldId").html(result.data[key]);
							}
						}
					}
					if(OtherHandler!=null){
						OtherHandler(result);
					}
				},true,params);
			},
			submitForm:function(formObject,url,successHandler,isIncludeFile,isClick){
				if(isIncludeFile==null){
					isIncludeFile=false;
				}
				if(isClick==null){
					isClick=false;
				}
				url=sic.basic.getRandParamUrl(url);
				var options = { 
				    target:formObject,
				    url: url,
				    beforeSubmit:function(){
				    	sic.msg.showLoding("处理中");
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
					    			sic.msg.alert(data.responseText);
					    		}
					    	}else{
					    		sic.msg.error(data.msg);
					    	}
				    	}else{
				    		if(data.success){
					    		successHandler(data);
					    	}else{
					    		sic.msg.error(data.msg);
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
				    			sic.msg.alert(data.responseText);
				    		}
				    	}else{
				    		sic.msg.alert(data.msg);
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
			isNotNull:function(data,msg){					//判断数据是否为空，并提示错误
				if(data==null){
					sic.msg.alert(msg||'请选择一条记录');
					return false;
				}else{
					return true;
				}
			},
			
			comboList:function(combo,url,successHandler){					//在下拉框中设置从后台获取的数据
				url=sic.basic.getRandParamUrl(url);
				$.getJSON(url,function(data){
					$.each(data.root,function(i,item){
						console.log(item.name);
						combo.append("<option value='"+item.id+"'>"+item.name+"</option>");
					});
					if(successHandler!=null){
						successHandler();
					}
				});
			}
		},
		//**********************************************分页加载数据函数处理**********************************************
		pageLoding:{
			getScrollOnceData:function(url,start,obj,getDataDiv){
				if(url.indexOf('?')!=-1){
					url=url+'&page.pageNumber='+start+'&page.pageSize='+sicValue.page.pageCount;
				}else{
					url=url+'?page.pageNumber='+start+'&page.pageSize='+sicValue.page.pageCount;
				}
				sic.common.getJson(url, function(data){
					if(data.totalProperty>0){
						if(data.totalProperty%pageCount==0){
							sicValue.page.pageSize=data.totalProperty/sicValue.page.pageCount;
						}else{
							sicValue.page.pageSize=(data.totalProperty/sicValue.page.pageCount)+1;
						}
						$.each(data.root,function(i,item){
							obj.append(getDataDiv(item));
						});
					}else{
						if(firstTime){
							obj.append("<div><div class='alert alert-block'><h4>暂无记录</h4></div></div>");
							sicValue.page.firstTime=false;
						}
					}
				},true);
			},
			scrollBreakPage:function(url,obj,getDataDiv){
				sicValue.page.pageSize=0;
				var range = 700;
				var num=0;
		        obj.html("");
				sic.pageLoding.getScrollOnceData(url,0,obj,function(item){
					return getDataDiv(item);
				});
				$(window).scroll(function(){
					//console.log("document.height:"+$(document).height());
					//console.log("document.scrollTop:"+$(document).scrollTop());
					if(range>=($(document).height()-$(document).scrollTop()) && sicValue.page.pageSize>=num) {
						num++;
						sic.pageLoding.getScrollOnceData(url,num,obj,function(item){
							return getDataDiv(item);
						});
					}
				});
			},
			pageLoad:function(url,obj,getValue,currentPage){
		        if(currentPage==null){
		            currentPage=0;
		        }
		        sic.common.getJson(url,function(result){
		            if(result.totalProperty>0){
		                if($("#loadMoreDivId")!=null){
		                    $("#loadMoreDivId").remove();
		                }
		                $.each(result.root,function(i,item){
		                    obj.append(getValue(item));
		                });
		                if(result.totalProperty>(currentPage+1)*sicValue.pageCount){
		                    obj.append("<div class='span8' id='loadMoreDivId'><div class='alert alert-info' align='center'><h2><button id='loadMoreButtonId' class='btn btn-success'>加载更多</h2></button></div></div>");
		                    $("#loadMoreButtonId").click(function(){
		                        $("#loadMoreButtonId").html("加载中...");
		                        sic.pageLoding.pageLoad(url,obj,function(item){
		                            return getValue(item);
		                        },currentPage+1);
		                    });
		                }
		            }else{
		                if(currentPage==null || currentPage==0){
		                    obj.append("<div class='span8'><div class='alert alert-block'><h4>暂无记录</h4></div></div>");
		                }
		            }
		        },false,{
		        	page:{
		        		pageNumber:currentPage,
		        		pageSize:sicValue.page.pageCount
		        	}
		        });
		    }
		},
		//**********************************************插件函数处理**********************************************
		plug:{
			getSoundManager:function(soundurl){
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
			},
			newJplayer:function(list){
				new jPlayerPlaylist({
					jPlayer: "#sic_jplayerDivId",
					cssSelectorAncestor: "sic_containerDivId"
				},list,{
					swfPath: "jplayer",
					supplied: "wma,mp3",
					wmode: "window"
				});
			},
			raty:function(taget,getScoreUrl,setScoreUrl){
				sic.common.getJson(getScoreUrl, function(result){
					$(taget).raty({
						score:result.data.score,
						click:function(score,event){
							sic.common.getJson(setScoreUrl+'&score.score='+score, function(){
								sic.msg.alert('谢谢你的评价！');
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
		}
};
//**********************************************登入，注册，注销函数处理**********************************************
function userLogin(){
	sic.common.submitForm($('#loginFormId'), 'login.nut', function(){
		window.location.reload();
	}, false, true);
}

function userRegiest(){
	window.location.href="/sicNutz/user/user_add.jsp";
}

function userLogout(){
	sic.msg.confirm('确认要注销吗？', function(){
		sic.common.getJson('logout.nut', function(){
			window.location.href="/sicNutz/index.jsp";
		});
	});
}

//**********************************************删除对象处理**********************************************
function deleteObject(url,msg){
	var message;
	if(msg==null){
		message='确认要删除吗？';
	}else{
		message=msg;
	}
	sic.msg.confirm(message, function(){
		sic.common.getJson(url, function(){
			window.location.reload();
		});
	});
}


//**********************************************添加收藏处理**********************************************
function addFavorite(type,name){
	var title;
	if(name==null){
		title=$('#titleFormFieldId').html();
	}else{
		title=$('#'+name).html();
	}
	sic.common.getJson('../common/favorite/add.nut', function(){
		sic.msg.alert('添加收藏成功');
		var value=$('#favoriteButtonId').html();
		$('#favoriteButtonId').html('收藏('+(parseInt(value.substring(value.indexOf('(')+1,value.indexOf(')')))+1)+')');
		$('#favoriteButtonId').addClass('disabled');
		$('#favoriteButtonId').attr('disabled',true);
	},false,{
		'font':true,
		'favorite.title':title,
		'favorite.type':type,
		'favorite.url':window.location.href
	});
}

