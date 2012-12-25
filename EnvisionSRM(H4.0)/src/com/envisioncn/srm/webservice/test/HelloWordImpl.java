package com.envisioncn.srm.webservice.test;

import javax.jws.WebService;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

@WebService(endpointInterface = "com.envisioncn.srm.webservice.test.HelloWord")
public class HelloWordImpl implements HelloWord{

	public String sayHello() {
		// TODO Auto-generated method stub
		return "hello";
	}
	
	public void go(){
		System.out.println("gogogo!!!");
	}
	public static void main(String[] args){
		 JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
         svr.setServiceClass(HelloWordClient.class);
         svr.setAddress("http://localhost:8080/EnvisionSRM/webServices/HelloWorld");
         HelloWordClient hw = (HelloWordClient) svr.create();
         
         System.out.println("hello:"+hw.sayHello());
         //hw.go();
	}
	
}
