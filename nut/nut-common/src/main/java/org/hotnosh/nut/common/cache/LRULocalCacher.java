package org.hotnosh.nut.common.cache;

import java.util.Iterator;

/**
 * 最久没有使用的本地缓存<br>
 * 就是最近一次访问最远的先排除出缓存<br>
 * 默认容量500<br>
 * 
 * @author lilin
 *
 * @param <K>
 * @param <V>
 */
public class LRULocalCacher<K, V> {

	private static final int DefaultInitCapacity = 500;

	private Integer capacity;

	private BlockingFixedLinkedHashMap<K, CacheObjectWrapper<V>> map;

	public LRULocalCacher() {
		this.capacity = DefaultInitCapacity;
	}

	public LRULocalCacher(Integer capacity) {
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
		map = new BlockingFixedLinkedHashMap<K, CacheObjectWrapper<V>>(capacity);
	}

	public void set(K key, V value) {
		CacheObjectWrapper<V> objectWrapper = new CacheObjectWrapper<V>(value);
		try {
			map.put(key, objectWrapper);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public void set(K key, V value, Long timeout) {
		CacheObjectWrapper<V> objectWrapper = new CacheObjectWrapper<V>(value,
				timeout);
		try {
			map.put(key, objectWrapper);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public V get(K key) {
		CacheObjectWrapper<V> objectWrapper = map.remove(key);
		if (null == objectWrapper) {
			return null;
		}
		V data = objectWrapper.getData(true);
		if (null == data) {
			return null;
		}
		map.put(key, objectWrapper);
		return data;
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
