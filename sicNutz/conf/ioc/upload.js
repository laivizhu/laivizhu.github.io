var ioc = {
		upload : {
			type : "org.nutz.mvc.upload.UploadAdaptor",
			args : [{refer : "uploadCtx"}]
		},
		uploadCtx : {
			type : "org.nutz.mvc.upload.UploadingContext",
			args : [{refer: "filePool"}],
			fields : {
				ignoreNull : true,
				maxFileSize : 20480000,
				nameFilter : ".+(jpg|png|mp3|wma|txt)"
			}
		},
		filePool : {
			type : "com.laivi.sic.action.interceptor.WebFilePool",
			args : ["/upload/", 2000]
		}
};