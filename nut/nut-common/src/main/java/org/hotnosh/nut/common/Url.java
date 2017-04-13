package org.hotnosh.nut.common;

/**
 * Created on 2017/4/13.
 */
public class Url {
    private String protocol;

    private String host;

    private final int port;

    public Url() {
        this.port = 0;
    }

    public Url(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
