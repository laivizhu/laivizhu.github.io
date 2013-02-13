package com.laivi.knowledge.user.model.type;

public enum RoleType {
	ROLE_ADMIN("管理员"),
    ROLE_USER("普通用户");
	private final String description;

	RoleType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static RoleType parse(String s) {
		for (RoleType role : values()) {
			if (role.toString().equals(s)) {
				return role;
			}
		}
		return null;
	}
}
