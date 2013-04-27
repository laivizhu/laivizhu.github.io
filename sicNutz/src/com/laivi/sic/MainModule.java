package com.laivi.sic;

import org.nutz.mvc.annotation.Chain;
import org.nutz.mvc.annotation.ChainBy;
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
	"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","com.laivi.sic","org.nutz.validation"
})
@ChainBy(args={"/ioc/process.js"})
@SetupBy(value=NutzSetUp.class)
@Chain("myChain")
public class MainModule {

}
