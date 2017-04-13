package org.hotnosh.nut.protocol.server;

import org.hotnosh.nut.common.Url;

/**
 * Created on 2017/4/13.
 */
public interface Server {

    Url getUrl();

    void start();

    void close();
}
