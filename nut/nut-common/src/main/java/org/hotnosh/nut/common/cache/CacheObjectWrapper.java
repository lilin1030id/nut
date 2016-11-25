package org.hotnosh.nut.common.cache;

import java.util.Date;

/**
 * 缓存对象包装器
 * @author lilin
 *
 */
public class CacheObjectWrapper<T> {
	
	public final static long DefaultTimeout = 60000; //1分钟
	
	//超时时间
	protected Long timeout; 
    //上次更新时间
	protected Long updateTime; 
	//要保存的对象
	protected T data;
	//是否超时
	
	public CacheObjectWrapper(T data){
		this.updateTime =  new Date().getTime();
		this.data = data;		 
	}
	
	public CacheObjectWrapper(T data, Long timeout){
		this.updateTime =  new Date().getTime();
		this.data = data;
		this.timeout = timeout;
	}
	
	public CacheObjectWrapper(Long updateTime, T data, Long timeout){
		this.updateTime = (null == updateTime || 0>=updateTime) ? new Date().getTime() : updateTime;
		this.data = data;
		this.timeout  = timeout;
	}
	 
//	private boolean isTimeout(long time) {		 
//		return time - preUpdateTime > timeout ;
//	}
	
	private boolean isTimeout() {		
		if (null == timeout) {
			return false;
		}
		return new Date().getTime() - updateTime > timeout ;
	}
	
	public T getData(){		 
		return isTimeout() ? null : data;
	}
	
	public T getData(boolean isUpdateTime){		 
		if (isTimeout()) {
			return null;
		}
		if (isUpdateTime) {
			updateTime = new Date().getTime();
		}		
		return data;
	}
	
}
