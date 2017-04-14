package org.hotnosh.nut.protocol.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * Created on 2017/4/13.
 */
public interface ProxyFactory {

    /**
     * 获取代理对象
     * @param type
     * @param <T>
     * @return
     */
    <T> T getProxy(Class<T> type, InvocationHandler handler);
}
