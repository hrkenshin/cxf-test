package com.tony.examples.cxf.provider;

import com.tony.examples.cxf.annotation.Encrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

/**
 * Message Payload Encrypt Interceptor Provider(NOT WORKING)
 *
 * @author 이승백
 */
@Provider
@Encrypt
@Priority(Priorities.ENTITY_CODER)
public class EncryptWriterFilter implements WriterInterceptor {

    private Logger logger = LoggerFactory.getLogger(EncryptWriterFilter.class);

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        logger.info("Encrypt TEST");
        context.proceed();
    }
}
