package org.hotnosh.nut.protocol.domain;

import java.io.Serializable;

/**
 * Created on 2017/4/14.
 */
public interface Message extends Serializable{

    RpcHeader getHeader();

    RpcBody getBody();

    int getSize();
}
