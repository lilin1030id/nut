package org.hotnosh.nut.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 字符串处理
 *
 * @author lilin
 *
 */
public class StringUtil {

	/**
	 * 判断是不是手机号
	 * 
	 * @param keyword
	 * @return
	 */
	public static boolean isMobileNumber(String keyword) {
		return null != keyword && keyword.matches("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
	}

	/**
	 *
	 * @param str
	 * @param separator
	 * @return
	 * @throws Exception
	 */
	public static KV<Long, Long> spiltToLongRange(String str, String separator) throws Exception {
		if (null == str) {
			throw new Exception("str is null.");
		}
		str = trim(str);
		KV<Long, Long> pair = new KV<Long, Long>();
		if (null == separator) {
			pair.setKey(Long.parseLong(str));
			return pair;
		}
		String[] splitArray = str.trim().split(separator);
		if (0 >= splitArray.length || splitArray.length > 2) {
			throw new Exception("str is illegal, splitArray.length=" + splitArray.length + " , str=" + str);
		}
		if (2 == splitArray.length) {
			if (!StringUtil.isEmpty(splitArray[0])) {
				pair.setKey(Long.parseLong(splitArray[0]));
			}
			if (!StringUtil.isEmpty(splitArray[1])) {
				pair.setValue(Long.parseLong(splitArray[1]));
			}
		}
		if (str.startsWith(separator) && !StringUtil.isEmpty(splitArray[1])) {
			pair.setValue(Long.parseLong(splitArray[1]));
		}
		if (str.endsWith(separator) && !StringUtil.isEmpty(splitArray[0])) {
			pair.setKey(Long.parseLong(splitArray[0]));
		}
		return pair;
	}

	public static KV<Integer, Integer> spiltToIntRange(String str, String separator) throws Exception {
		if (null == str) {
			throw new Exception("str is null.");
		}
		str = trim(str);
		KV<Integer, Integer> pair = new KV<Integer, Integer>();
		if (null == separator) {
			pair.setKey(Integer.parseInt(str));
			return pair;
		}
		String[] splitArray = str.trim().split(separator);
		if (0 >= splitArray.length || splitArray.length > 2) {
			throw new Exception("str is illegal, splitArray.length=" + splitArray.length + " , str=" + str);
		}
		if (2 == splitArray.length) {
			if (!StringUtil.isEmpty(splitArray[0])) {
				pair.setKey(Integer.parseInt(splitArray[0]));
			}
			if (!StringUtil.isEmpty(splitArray[1])) {
				pair.setValue(Integer.parseInt(splitArray[1]));
			}
		}
		if (str.startsWith(separator) && !StringUtil.isEmpty(splitArray[1])) {
			pair.setValue(Integer.parseInt(splitArray[1]));
		}
		if (str.endsWith(separator) && !StringUtil.isEmpty(splitArray[0])) {
			pair.setKey(Integer.parseInt(splitArray[0]));
		}
		return pair;
	}

	public static KV<Double, Double> spiltToDoubleRange(String str, String separator) throws Exception {
		if (null == str) {
			throw new Exception("str is null.");
		}
		str = trim(str);
		KV<Double, Double> pair = new KV<Double, Double>();
		if (null == separator) {
			pair.setKey(Double.parseDouble(str));
			return pair;
		}
		String[] splitArray = str.trim().split(separator);
		if (0 >= splitArray.length || splitArray.length > 2) {
			throw new Exception("str is illegal, splitArray.length=" + splitArray.length + " , str=" + str);
		}
		if (2 == splitArray.length) {
			if (!StringUtil.isEmpty(splitArray[0])) {
				pair.setKey(Double.parseDouble(splitArray[0]));
			}
			if (!StringUtil.isEmpty(splitArray[1])) {
				pair.setValue(Double.parseDouble(splitArray[1]));
			}
		} else {
			if (str.startsWith(separator) && !StringUtil.isEmpty(splitArray[1])) {
				pair.setValue(Double.parseDouble(splitArray[1]));
			}
			if (str.endsWith(separator) && !StringUtil.isEmpty(splitArray[0])) {
				pair.setKey(Double.parseDouble(splitArray[0]));
			}
		}
		return pair;
	}

	/**
	 * 把字符串切分成字符串列表
	 *
	 * @param str
	 * @param separator
	 * @return
	 * @throws Exception
	 */
	public static List<String> spiltToString(String str, String separator) throws Exception {
		if (null == str) {
			throw new Exception("str is null.");
		}
		List<String> l = new ArrayList<String>();
		if (null == separator) {
			l.add(str);
			return l;
		}
		String[] splitArray = str.trim().split(separator);
		for (String subStr : splitArray)
			l.add(subStr);
		return l;
	}

	public static String[] spiltToStringArray(String str, String separator) throws Exception {
		if (null == str) {
			throw new Exception("str is null.");
		}
		String[] splitArray = str.trim().split(separator);
		return splitArray;
	}

	public static List<Long> spiltToLong(String str, String separator) throws Exception {
		if (null == str) {
			throw new Exception("str is null.");
		}
		List<Long> l = new ArrayList<Long>();
		if (null == separator) {
			l.add(Long.parseLong(str));
			return l;
		}
		String[] splitArray = str.trim().split(separator);
		for (String numStr : splitArray) {
			l.add(Long.parseLong(trim(numStr)));
		}
		return l;
	}

	public static List<Integer> spiltToInteger(String str, String separator) throws Exception {
		if (isEmpty(str)) {
			throw new Exception("str is empty.");
		}
		List<Integer> l = new ArrayList<Integer>();
		if (null == separator) {
			l.add(Integer.parseInt(str));
			return l;
		}
		String[] splitArray = str.trim().split(separator);
		for (String numStr : splitArray)
			l.add(Integer.parseInt(numStr));
		return l;
	}

	public static List<Double> spiltToDouble(String str, String separator) throws Exception {
		if (null == str) {
			throw new Exception("str is null.");
		}
		List<Double> l = new ArrayList<Double>();
		if (null == separator) {
			l.add(Double.parseDouble(str));
			return l;
		}
		String[] splitArray = str.trim().split(separator);
		for (String numStr : splitArray)
			l.add(Double.parseDouble(numStr));
		return l;
	}

	public static boolean isEmpty(String string) {
		if (null == string || "".equals(string.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 切割类似"price:asc,sell:desc"这样的字符串成为map
	 *
	 * @param str
	 * @param mainSeparator
	 *            类似上面的“,”
	 * @param subSeparator
	 *            类似上面的“:”
	 * @return
	 */
	public static Map<String, String> splitToMap(String str, String mainSeparator, String subSeparator)
			throws Exception {
		if (isEmpty(str)) {
			return new HashMap<String, String>();
		}
		String[] strArray = str.trim().split(mainSeparator);
		Map<String, String> map = new HashMap<String, String>(strArray.length);

		for (String kv : strArray) {
			String[] kvArray = kv.trim().split(subSeparator);
			if (kvArray.length != 2 || isEmpty(kvArray[0]) || isEmpty(kvArray[1])) {
				throw new Exception("the format of str is error, error: \"" + kv + "\" in " + str);
			}
			map.put(kvArray[0], kvArray[1]);
		}
		return map;
	}

	public static String toArrayStatement(String splitTag, String pre, String end, List<?> list) {
		if (null == list || 0 >= list.size() || null == splitTag) {
			return null;
		}
		pre = (null == pre) ? "" : pre;
		end = (null == end) ? "" : end;

		StringBuilder builder = new StringBuilder();
		builder.append(pre);
		boolean isFirst = true;

		for (Object obj : list) {
			if (isFirst) {
				isFirst = false;
			} else {
				builder.append(splitTag);
			}
			builder.append(obj);
		}
		builder.append(end);
		return builder.toString();
	}

	public static String toArrayStatement(String splitTag, String pre, String end, Object... objArray) {
		if (null == objArray || 0 >= objArray.length || null == splitTag) {
			return null;
		}
		pre = (null == pre) ? "" : pre;
		end = (null == end) ? "" : end;

		StringBuilder builder = new StringBuilder();
		builder.append(pre);
		boolean isFirst = true;

		for (Object obj : objArray) {
			if (isFirst) {
				isFirst = false;
			} else {
				builder.append(splitTag);
			}
			builder.append(obj);
		}
		builder.append(end);
		return builder.toString();
	}

	public static String toArrayStatement(String splitTag, String pre, String end, Set<?> set) {
		if (null == set || 0 >= set.size() || null == splitTag) {
			return null;
		}
		pre = (null == pre) ? "" : pre;
		end = (null == end) ? "" : end;

		StringBuilder builder = new StringBuilder();
		builder.append(pre);
		boolean isFirst = true;

		for (Object obj : set) {
			if (isFirst) {
				isFirst = false;
			} else {
				builder.append(splitTag);
			}
			builder.append(obj);
		}
		builder.append(end);
		return builder.toString();
	}

	public static List<String> toStringList(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		List<String> list = new ArrayList<String>(array.length);
		list.addAll(Arrays.asList(array));
		return list;
	}

	public static List<Integer> toIntegerList(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		List<Integer> list = new ArrayList<Integer>(array.length);
		for (String item : array) {
			Integer val = Integer.parseInt(item);
			list.add(val);
		}
		return list;
	}

	public static List<Long> toLongList(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		List<Long> list = new ArrayList<Long>(array.length);
		for (String item : array) {
			Long val = Long.parseLong(item);
			list.add(val);
		}
		return list;
	}

	public static List<Float> toFloatList(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		List<Float> list = new ArrayList<Float>(array.length);
		for (String item : array) {
			Float val = Float.parseFloat(item);
			list.add(val);
		}
		return list;
	}

	public static List<Double> toDoubleList(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		List<Double> list = new ArrayList<Double>(array.length);
		for (String item : array) {
			Double val = Double.parseDouble(item);
			list.add(val);
		}
		return list;
	}

	public static Set<String> toStringSet(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		Set<String> set = new HashSet<String>(array.length);
		set.addAll(Arrays.asList(array));
		return set;
	}

	public static Set<Double> toDoubleSet(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		Set<Double> set = new HashSet<Double>(array.length);
		for (String item : array) {
			Double val = Double.parseDouble(item);
			set.add(val);
		}
		return set;
	}

	public static Set<Float> toFloatSet(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		Set<Float> set = new HashSet<Float>(array.length);
		for (String item : array) {
			Float val = Float.parseFloat(item);
			set.add(val);
		}
		return set;
	}

	public static Set<Long> toLongSet(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		Set<Long> set = new HashSet<Long>(array.length);
		for (String item : array) {
			Long val = Long.parseLong(item);
			set.add(val);
		}
		return set;
	}

	public static Set<Integer> toIntegerSet(String str, String splitChar) throws Exception {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		Set<Integer> set = new HashSet<Integer>(array.length);
		for (String item : array) {
			Integer val = Integer.parseInt(item);
			set.add(val);
		}
		return set;
	}

	// 将a-b转为[a b]
	public static String toRangeStr(String str, String splitChar) {
		if (isEmpty(str)) {
			return null;
		}
		String[] array = str.split(splitChar);
		return "[" + array[0] + " " + array[1] + "]";
	}

	public static String toRangeStr(Object val1, String splitChar, Object val2) {
		if (null == val1 || null == val2) {
			return null;
		}
		String str1 = null == val1 ? "" : val1 + "";
		String str2 = null == val2 ? "" : val2 + "";
		return str1 + splitChar + str2;
	}

	public static String toPureArrayStatement(String splitStr, Object... objArray) {
		return toArrayStatement(splitStr, null, null, objArray);
	}

	public static String toPureArrayStatement(String splitStr, List<Object> objList) {
		return toArrayStatement(splitStr, null, null, objList);
	}

	/**
	 * 后期将一些其他的字符做为trim的空字符列表中
	 *
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		if (null == str)
			return null;
		return str.trim();
	}

	/**
	 * 删除头尾是tag的头尾
	 * 
	 * @param str
	 * @param tag
	 * @return
	 */
	public static String trim(String str, String tag) {
		if (null == str) {
			return null;
		}
		if (null == tag || 0 >= tag.length()) {
			return str;
		}
		if (str.equals(tag)) {
			return "";
		}
		int tagLen = tag.length();
		int i = 0, k = 0, j = str.length() - 1;
		for (; i < str.length(); i++, k++) {
			if (k >= tagLen) {
				k = 0;
			}
			if (str.charAt(i) != tag.charAt(k)) {
				i = i - k;
				break;
			}
		}
		k = tagLen - 1;
		for (; j >= 0; j--, k--) {
			if (k < 0) {
				k = tagLen - 1;
			}
			if (str.charAt(j) != tag.charAt(k) || i >= j) {
				j = j + (tagLen - k);
				break;
			}
		}
		return str.substring(i, j);
	}

	public static void main(String[] args) {
		String str = "abckkkabc";
		String tag = " ";

		System.out.println("val=" + trim(str, tag));
	}

}
