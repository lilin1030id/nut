package org.hotnosh.nut.protocol;

import org.hotnosh.nut.common.Url;

/**
 * Created on 2017/4/13.
 */
public interface Protocol {

   <T> void export(T target, Class<? super T> interfaceClass, Url url);

   <T> T refer(Class<T> interfaceClass, Url url);
}
