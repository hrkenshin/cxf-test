package com.tony.examples.cxf.annotation;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Message Payload Encrypt Annotation
 */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface Encrypt {
}
