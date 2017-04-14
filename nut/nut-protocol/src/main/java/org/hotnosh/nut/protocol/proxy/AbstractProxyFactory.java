package org.hotnosh.nut.protocol.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * Created on 2017/4/14.
 */
public abstract class AbstractProxyFactory implements ProxyFactory {


    public <T> T getProxy(Class<T> type, InvocationHandler handler) {
        Class<?>[] types = new Class[] {type};
        return doProxy(types, handler);
    }

    protected abstract <T> T doProxy(Class<?>[] types, InvocationHandler handler);
}
