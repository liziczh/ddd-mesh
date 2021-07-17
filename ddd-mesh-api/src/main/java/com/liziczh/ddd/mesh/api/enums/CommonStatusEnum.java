package com.liziczh.ddd.mesh.api.enums;

import java.util.Objects;

public enum CommonStatusEnum {
	VALID("0", "正常"),
	INVALID("1", "失效");

	private String code;
	private String name;

	private CommonStatusEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}

	public static CommonStatusEnum getEnum(String code){
		if(Objects.nonNull(code)){
			for(CommonStatusEnum value: CommonStatusEnum.values()){
				if(value.getCode().equals(code)){
					return value;
				}
			}

		}
		return null;
	}

}
