package org.hotnosh.nut.protocol;

import org.hotnosh.nut.common.Url;
import org.hotnosh.nut.protocol.domain.Message;
import org.hotnosh.nut.protocol.domain.RpcRequest;
import org.hotnosh.nut.protocol.proxy.ProxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created on 2017/4/14.
 */
public abstract class AbstractProtocol implements Protocol {

    private ProxyFactory proxyFactory;

    public <T> T refer(Class<T> interfaceClass, Url url) {
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Message req = new RpcRequest(method.getName(), method.getParameterTypes(), args);


                return null;
            }
        };

        return proxyFactory.getProxy(interfaceClass, handler);
    }

    public ProxyFactory getProxyFactory() {
        return proxyFactory;
    }

    public void setProxyFactory(ProxyFactory proxyFactory) {
        this.proxyFactory = proxyFactory;
    }
}
