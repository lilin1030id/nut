package org.hotnosh.nut.protocol.proxy;

/**
 * Created on 2017/4/13.
 */
public interface ProxyFactory {

    /**
     * 获取代理对象
     * @param interfaceClass
     * @param <T>
     * @return
     */
    <T> T getProxy(Class<T> interfaceClass);
}
