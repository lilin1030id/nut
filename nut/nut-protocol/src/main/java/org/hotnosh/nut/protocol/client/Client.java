package org.hotnosh.nut.protocol.client;

import org.hotnosh.nut.common.Url;
import org.hotnosh.nut.protocol.net.Channel;

/**
 * Created on 2017/4/13.
 */
public interface Client {

    Channel createChannel(Url url);
}
