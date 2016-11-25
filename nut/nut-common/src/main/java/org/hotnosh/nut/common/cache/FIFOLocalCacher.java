package org.hotnosh.nut.common.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 先进先出本地缓存<br>
 * 超时的记录会删除 默认容量500个元素<br>
 * 
 * @author lilin
 *
 * @param <K>
 * @param <V>
 */
public class FIFOLocalCacher<K, V> {

	private static final int DefaultInitCapacity = 500;

	private Integer capacity;

	private BlockingFixedLinkedHashMap<K, CacheObjectWrapper<V>> map;

	public FIFOLocalCacher() {
	}

	public FIFOLocalCacher(Integer capacity) {
		this.capacity = (null == capacity || 0 > capacity) ? DefaultInitCapacity
				: capacity;
	}

	public Integer getCapacity() {
		return null == capacity ? DefaultInitCapacity : capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = (null == capacity || 0 > capacity) ? DefaultInitCapacity
				: capacity;
	}

	public void init() {
		map = new BlockingFixedLinkedHashMap<K, CacheObjectWrapper<V>>(getCapacity());
	}

	public void set(K key, V value) {
		CacheObjectWrapper<V> objectWrapper = new CacheObjectWrapper<V>(value);
		try {
			map.put(key, objectWrapper);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void set(K key, V value, Long timeout) {
		CacheObjectWrapper<V> objectWrapper = new CacheObjectWrapper<V>(value, timeout);
		try {
			map.put(key, objectWrapper);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public V get(K key) {
		CacheObjectWrapper<V> objectWrapper = map.get(key);
		if (null == objectWrapper) {
			return null;
		}
		V data = objectWrapper.getData();
		if (null == data) {
			map.remove(key);
		}
		return data;
	}
	
	public List<V> getAll() {
		List<V> list = new ArrayList<V>();
		for (Map.Entry<K, CacheObjectWrapper<V>> entry : map.entrySet()) {
			if (null == entry.getValue()) {
				continue;
			}
			V data = entry.getValue().getData();
			if (null == data) {
				continue;
			}
			list.add(data);
		}
		return list;
	}
	
	public void remove(K key) {
		map.remove(key);
	}
	
	public void clear() {
		map.clear();
	}
	
	public String toString() {
		StringBuilder builder  =  new StringBuilder();
		Iterator<K> iterator =	map.keySet().iterator();
		while (iterator.hasNext()) {
			K key =iterator.next();
			builder.append(key);
			builder.append("=");
			builder.append(map.get(key).getData());
			builder.append(",");
		}
		return builder.toString();
	}

}
