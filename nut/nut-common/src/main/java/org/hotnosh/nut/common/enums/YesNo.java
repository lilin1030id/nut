package org.hotnosh.nut.common.enums;


/**
 * 是否枚举类
 * 
 * @author lilin
 * 
 */
public enum YesNo {

	yes(1, "yes", "是"), // 是
	no(0, "no", "否"); // 否

	private Integer index;
	private String code;
	private String name;

	private YesNo(Integer index, String code, String name) {
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
	
	public static YesNo getEnum(String code) {
		if (null == code) {
			return null;
		}
		for (YesNo type : YesNo.values()) {
			if (type.code.equals(code)) {
				return type;
			}
		}
		return null;
	}
	
	public static YesNo getEnum(Integer index) {
		if (null == index) {
			return null;
		}
		for (YesNo type : YesNo.values()) {
			if (type.index.equals(index)) {
				return type;
			}
		}
		return null;
	}

}
