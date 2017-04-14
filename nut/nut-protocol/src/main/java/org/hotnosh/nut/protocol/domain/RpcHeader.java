package org.hotnosh.nut.protocol.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * Created on 2017/4/14.
 */
public class RpcHeader implements Serializable {

    public static final int DefaultVersion = 0;

    //header size
    private int size;

    //protocol version
    private int version = DefaultVersion;

    /**
     * msg type
     * @see org.hotnosh.nut.protocol.enums.RpcMsgType
     */
    private int type;

    private Map<String, String> attachments;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, String> attachments) {
        this.attachments = attachments;
    }
}
