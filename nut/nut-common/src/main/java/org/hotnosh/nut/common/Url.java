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

    private Url(Builder builder) {
        this.protocol = builder.protocol;
        this.host = builder.host;
        this.port = builder.port;
    }

    public static Builder newUrl() {
        return new Builder();
    }


    public static final class Builder {
        private String protocol;
        private String host;
        private int port;

        private Builder() {
        }

        public Url build() {
            return new Url(this);
        }

        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
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
}
