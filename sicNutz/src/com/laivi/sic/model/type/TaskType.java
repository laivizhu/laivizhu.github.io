package com.laivi.sic.model.type;


/**
 * User: laivi.zhu
 * Time: 12-6-18 下午11:32
 */
public enum TaskType implements BasicType<TaskType>{
	ONCE("确认"),
	ALERT("警告"),
	INFORMATION("信息"),
	REQUEST("请求");
	
	private final String text;
	
	TaskType(String text){
		this.text=text;
	}
	
	public String toText() {
		return text;
	}
		
	public static TaskType fromText(String value) {
		for (TaskType type : values()) {
			if (type.toText().equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + value);
	}
	
	@Override
	public TaskType getFromText(String text) {
		return TaskType.fromText(text);
	}

}