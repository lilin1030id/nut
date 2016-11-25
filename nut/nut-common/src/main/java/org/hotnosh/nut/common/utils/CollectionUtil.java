package org.hotnosh.nut.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 集合util
 * 
 * @author lilin
 *
 */
public class CollectionUtil {

	public static <T> boolean isEmpty(List<T> list) {
		return null == list || 0 >= list.size();
	}

	public static <T> boolean isEmpty(Set<T> set) {
		return null == set || 0 >= set.size();
	}

	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return null == map || 0 >= map.size();
	}

	/**
	 * 数组转化为list
	 * 
	 * @param array
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> arrayToList(T[] array) throws Exception {
		List<T> list = new ArrayList<T>();
		if (null == array || 0 >= array.length) {
			return list;
		}
		for (T t : array) {
			list.add(t);
		}
		return list;
	}

	/**
	 * 数组转化为set
	 * 
	 * @param array
	 * @return
	 * @throws Exception
	 */
	public static <T> Set<T> arrayToSet(T[] array) {
		Set<T> set = new HashSet<T>();
		if (null == array || 0 >= array.length) {
			return set;
		}
		for (T t : array) {
			set.add(t);
		}
		return set;
	}

	/**
	 * set转化为list
	 *
	 * @param set
	 * @return
	 */
	public static <T> List<T> setToList(Set<T> set) {
		if (null == set || 0 >= set.size()) {
			return Collections.emptyList();
		}
		List<T> list = new ArrayList<T>();
		list.addAll(set);
		return list;
	}

	/**
	 * set转化为list
	 *
	 * @param set
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Set<T> listToSet(List<T> list) {
		if (null == list || 0 >= list.size()) {
			return Collections.EMPTY_SET;
		}
		Set<T> set = new HashSet<T>();
		set.addAll(list);
		return set;
	}

	/**
	 * orginList中的元素全部加到targetList中，如果其中有null元素 ， 则忽略
	 * 
	 * @param orginList
	 * @param targetList
	 */
	public static <T> void trimNull(List<T> orginList) {
		if (null == orginList || 0 >= orginList.size()) {
			return;
		}
		List<T> targetList = new ArrayList<T>();
		for (T t : orginList) {
			if (null != t) {
				targetList.add(t);
			}
		}
		orginList.clear();
		orginList.addAll(targetList);
	}

	/**
	 * 得到orginList中的所有非空元素的List集合的浅拷贝
	 * 
	 * @param orginList
	 * @param targetList
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getNoNullCopy(List<T> orginList) {
		if (null == orginList || 0 >= orginList.size()) {
			return Collections.EMPTY_LIST;
		}
		List<T> targetList = new ArrayList<T>();
		for (T t : orginList) {
			if (null != t) {
				targetList.add(t);
			}
		}
		return targetList;
	}
}
