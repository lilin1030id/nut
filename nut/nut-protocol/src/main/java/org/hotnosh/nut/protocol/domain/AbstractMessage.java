package org.hotnosh.nut.protocol.domain;

/**
 * Created on 2017/4/14.
 */
public abstract class AbstractMessage implements Message {

    //msg size
    private int size;

    protected RpcHeader header;

    protected RpcBody body;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public RpcHeader getHeader() {
        return header;
    }

    public RpcBody getBody() {
        return body;
    }
}
