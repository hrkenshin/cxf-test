package com.tony.examples.cxf.provider;

import com.tony.examples.cxf.ERROR;
import org.apache.cxf.interceptor.security.AccessDeniedException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Security Exception Mapper
 */
@Provider
@Priority(Priorities.USER)
public class SecurityExceptionMapper implements ExceptionMapper<AccessDeniedException> {

    @Override
    public Response toResponse(AccessDeniedException e) {
        String message = String.format("{\"code\":\"%s\", \"message\":\"%s\"}",
                ERROR.COMMON_AUTH_CHECK_FAIL.code(), e.getMessage());
        return Response.status(Response.Status.FORBIDDEN).entity(message).type("application/json; charset=UTF-8").build();
    }
}