package org.hotnosh.nut.common.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 固定容量的阻塞式BlockingFixedLinkedHashMap，如果Map中元素个数大于容量capacity，则在put时会把最老的元素删除，以空出空间给新的元素
 * @author lilin
 *
 * @param <K>
 * @param <V>
 */
public class BlockingFixedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
  
	private static final long serialVersionUID = 203412383968826408L;

	private int capacity;

	private final Lock lock = new ReentrantLock();

	public BlockingFixedLinkedHashMap(int initCapacity) {
		super(0 > initCapacity ? Integer.MAX_VALUE : initCapacity);
		this.capacity = 0 > initCapacity ? Integer.MAX_VALUE : initCapacity;
	}

	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacity;
	}

	@Override
	public boolean containsKey(Object key) {
		try {
			lock.lock();
			return super.containsKey(key);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public V get(Object key) {
		try {
			lock.lock();
			return super.get(key);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public V put(K key, V value) {
		try {
			lock.lock();
			return super.put(key, value);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public V remove(Object key) {
		try {
			lock.lock();
			return super.remove(key);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public int size() {
		try {
			lock.lock();
			return super.size();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void clear() {
		try {
			lock.lock();
			super.clear();
		} finally {
			lock.unlock();
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public Map<K, V> getEntrys(Set<K> keys) {
		Map<K, V> data = new HashMap<K, V>();
		try {
			lock.lock();
			for (K key : keys) {
				data.put(key, super.get(key));
			}
		} finally {
			lock.unlock();
		}
		return data;
	}

}
