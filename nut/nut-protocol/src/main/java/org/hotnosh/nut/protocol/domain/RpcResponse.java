package org.hotnosh.nut.protocol.domain;

import org.hotnosh.nut.protocol.enums.RpcMsgType;

/**
 * Created on 2017/4/14.
 */
public class RpcResponse extends AbstractMessage {
    public RpcResponse(int status, Object result, Throwable ex) {
        header = new RpcHeader();
        body = new RpcBody();

        header.setType(RpcMsgType.bizRes.getCode());
        body.setStatus(status);
        body.setResult(result);
        body.setException(ex);
    }
}
