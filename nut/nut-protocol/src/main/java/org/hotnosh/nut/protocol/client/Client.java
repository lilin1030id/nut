package org.hotnosh.nut.protocol.client;

import org.hotnosh.nut.protocol.domain.RpcRequest;
import org.hotnosh.nut.protocol.domain.RpcResponse;

/**
 * Created on 2017/4/13.
 */
public interface Client {

    /**
     * 发送请求
     * @param request
     * @return
     */
    RpcResponse send(RpcRequest request);
}
