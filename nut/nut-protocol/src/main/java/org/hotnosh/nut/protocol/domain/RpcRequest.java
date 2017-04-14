package org.hotnosh.nut.protocol.domain;

import org.hotnosh.nut.protocol.enums.RpcMsgType;

/**
 * Created on 2017/4/14.
 */
public class RpcRequest extends AbstractMessage {
    public RpcRequest(String methodName, Class<?>[] types, Object[] args) {
        header = new RpcHeader();
        body = new RpcBody();

        header.setType(RpcMsgType.bizReq.getCode());
        body.setMethodName(methodName);
        body.setParamTypes(types);
        body.setParams(args);
    }
}
