package org.hotnosh.nut.protocol.net;

import org.hotnosh.nut.protocol.domain.Message;

import java.util.List;

/**
 * Created on 2017/4/14.
 */
public interface Channel {

    void write(Message msg);

    List<Message> read();
}
