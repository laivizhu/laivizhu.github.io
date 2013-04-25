package com.laivi.sic;

import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@Encoding(input="utf8",output="utf8")
@Modules(scanPackage=true)
@Ok("json")
@Fail("json")
@IocBy(type=ComboIocProvider.class,args={
	"*org.nutz.ioc.loader.json.JsonLoader","/ioc",
	"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","com.laivi.sic"
})
@SetupBy(value=NutzSetUp.class)
public class MainModule {

}
