package com.tony.examples.cxf.provider;


import com.tony.examples.cxf.annotation.Decrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import java.io.IOException;

/**
 * Message Payload Decrypt Interceptor Provider(NOT WORKING)
 */
@Provider
@Decrypt
@Priority(Priorities.ENTITY_CODER)
public class DecryptReaderFilter implements ReaderInterceptor {

    private Logger logger = LoggerFactory.getLogger(DecryptReaderFilter.class);

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        logger.info("Decrypt TEST");
        return context.proceed();
    }
}