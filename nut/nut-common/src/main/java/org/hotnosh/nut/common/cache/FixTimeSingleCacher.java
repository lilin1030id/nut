package org.hotnosh.nut.common.cache;

import java.util.Date;

/**
 * 单个数据的定时缓存器（也可以设置为永久的）
 * @author lilin
 *
 * @param <T>
 */
public class FixTimeSingleCacher<T> extends CacheObjectWrapper<T> {

	public final static long DefaultTimeout = 60000; // 1分钟
 
	public FixTimeSingleCacher(){
		super(null);		 
	}
	
	public FixTimeSingleCacher(T data){
		super(data);		 
	}

	public FixTimeSingleCacher(T data, Long liveTime){
		super(data, liveTime);	
	}

	public FixTimeSingleCacher(Long updateTime, T data, Long liveTime){
		super(updateTime, data, liveTime);	
	} 

	public T getData() {
		return super.getData();
	}
  
	public void reset(T data, Long liveTime){
		this.updateTime =  new Date().getTime();
		this.data = data;
		this.timeout = liveTime;
	}
	
}
