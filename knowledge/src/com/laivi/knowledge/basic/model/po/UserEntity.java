package com.laivi.knowledge.basic.model.po;

import java.util.Date;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 21, 2013
 */
@SuppressWarnings("serial")
public abstract class UserEntity extends BasicEntity {

	abstract public long getUserId();
	
	abstract public Date getCreateDate();

}
