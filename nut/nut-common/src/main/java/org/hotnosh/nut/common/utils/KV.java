package org.hotnosh.nut.common.utils;

/**
 * 成对的数据结构
 * 
 * @author lilin
 * 
 */
public class KV<K, V> {

	private K key;// key

	private V value; // value

	public KV() {
	}

	public KV(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pair [key=" + key + ", value=" + value + "]";
	}

}
