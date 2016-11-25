package org.hotnosh.nut.common.utils;

/**
 * 对于value的处理util
 * @author lilin
 *
 */
public class ValueUtil {
	
	public static String getNotNull(String value) { 
		return null == value ? "" : value.trim();
	}

	public static String getNotNull(String value, String defaultValue) {
		if (null == defaultValue) {
			defaultValue = "";
		}
		return null == value ? defaultValue : value;
	}
	
	
	public static Integer getNotNull(Integer value, Integer defaultValue) {
		if (null == defaultValue) {
			defaultValue = 0;
		}
		return null == value ? defaultValue : value;
	}
	
	public static Integer getNotNull(Integer value) { 
		return null == value ? 0 : value;
	}
	
	public static Long getNotNull(Long value, Long defaultValue) {
		if (null == defaultValue) {
			defaultValue = 0l;
		}
		return null == value ? defaultValue : value;
	}
	
	public static Long getNotNull(Long value) { 
		return null == value ? 0 : value;
	}
	
	public static Double getNotNull(Double value, Double defaultValue) {
		if (null == defaultValue) {
			defaultValue = 0d;
		}
		return null == value ? defaultValue : value;
	}
	
	public static Double getNotNull(Double value) { 
		return null == value ? 0d : value;
	}
	
	public static Float getNotNull(Float value, Float defaultValue) {
		if (null == defaultValue) {
			defaultValue = 0f;
		}
		return null == value ? defaultValue : value;
	}
	
	public static Float getNotNull(Float value) { 
		return null == value ? 0f : value;
	}
	
}
