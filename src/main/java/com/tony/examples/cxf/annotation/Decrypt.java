package com.tony.examples.cxf.annotation;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Message Payload Decrypt Annotation
 */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface Decrypt {
}
