/* ===================================================
 * laiviBasic.js v0.1
 * ===================================================
 * Copyright 2013 Laivi.zhu
 *
 * Released under the MIT and GPL licenses.
 * ========================================================== */
(function(jQuery){
	jQuery.extend({
		laivi:{
			version:0.1,
			defaults:{
				
			}
		}
	});
	
	jQuery.fn.extend({
		laivi:function(options){
			var that = this;
            var thisOptions = jQuery.extend({}, jQuery.laivi.defaults, options);
            
            
		}
	});
})(jQuery);