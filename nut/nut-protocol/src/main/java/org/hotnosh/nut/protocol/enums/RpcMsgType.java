package org.hotnosh.nut.protocol.enums;

/**
 * Created on 2017/4/14.
 */
public enum RpcMsgType {
    bizReq(0, "业务请求消息"),
    bizRes(1, "业务响应消息");

    private Integer code;
    private String name;

    RpcMsgType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
