package com.laivi.sic.model.po.system;

import org.nutz.dao.entity.annotation.Name;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.TaskType;

@SuppressWarnings("serial")
public class Task extends AUserEntity{

	@Name
	private String key;
	
	private TaskType type;
	
	private String title;
	
	private String serviceClass;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}
}
