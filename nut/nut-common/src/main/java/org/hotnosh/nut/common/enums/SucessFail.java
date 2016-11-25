package org.hotnosh.nut.common.enums;


/**
 * 是否枚举类
 * 
 * @author lilin
 * 
 */
public enum SucessFail {

	success(1, "success", "成功"), //成功
	fail(0, "fail", "失败"); // 失败

	private Integer index;
	private String code;
	private String name;

	private SucessFail(Integer index, String code, String name) {
		this.index = index;
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public Integer getIndex() {
		return index;
	}

	public boolean equals(String code) {		 
		return null == code ? false : (code.equals(this.code)); 
	}
	
	public boolean equals(Integer index) {
		return null == index ? false : (index.equals(this.index)); 
	}
	
	public static SucessFail getEnum(String code) {
		if (null == code) {
			return null;
		}
		for (SucessFail type : SucessFail.values()) {
			if (type.code.equals(code)) {
				return type;
			}
		}
		return null;
	}
	
	public static SucessFail getEnum(Integer index) {
		if (null == index) {
			return null;
		}
		for (SucessFail type : SucessFail.values()) {
			if (type.index.equals(index)) {
				return type;
			}
		}
		return null;
	}

}
