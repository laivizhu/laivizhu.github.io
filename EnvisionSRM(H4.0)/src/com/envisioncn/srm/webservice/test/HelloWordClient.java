package com.envisioncn.srm.webservice.test;

import javax.jws.WebService;


/**
 * Copyright Envision
 *
 * @author Leon.Han
 * @version 1.0
 * @data 2012-11-29
 */
@WebService
public interface HelloWordClient {
	public String sayHello();
	public void go();
}
