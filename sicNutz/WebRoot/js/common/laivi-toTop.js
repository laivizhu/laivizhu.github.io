;(function($){
	"use strict";
	$.fn.laiviToTop = function(options) {
		var defaults = {			
			showHeight : 150,
			speed : 1000
		};
		var options = $.extend(defaults,options);
		$("body").prepend("<div style='display: none; width: 50px; height: 95px; position: fixed;top: 480px; right: 10px; z-index: 100; text-align: center; cursor: pointer;' id='backTopDivId'><a><img src='/knowledge/images/back-top.png' alt='返回顶部' title='返回顶部' border='0'></a></div>");
		var $toTop = $(this);
		var $top = $("#totop");
		$toTop.scroll(function(){
			var scrolltop=$(this).scrollTop();		
			if(scrolltop>=options.showHeight){				
				$top.show();
			}
			else{
				$top.hide();
			}
		});	
		$top.click(function(){
			$("html,body").animate({scrollTop: 0}, options.speed);	
		});
	};
})(JQuery);