package com.tony.examples.cxf.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tony.examples.cxf.ERROR;
import com.tony.examples.cxf.ServiceException;
import com.tony.examples.cxf.protocol.ExceptionReport;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Service Exception Mapper
 */
@Provider
@Priority(Priorities.USER)
public class ServiceExceptionMapper implements ExceptionMapper<Throwable> {

    private Logger logger = LoggerFactory.getLogger(ServiceExceptionMapper.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response toResponse(Throwable e) {
        // Error Logging
        if (e instanceof ServiceException) {
            ServiceException ae = (ServiceException) e;
            try {
                switch (ERROR.valueOf(ae.getMessage()).level()) {
                    case 0:
                        logger.info(e.getMessage(), e);
                        break;
                    case 1:
                        logger.warn(e.getMessage(), e);
                        break;
                    case 2:
                        logger.error(e.getMessage(), e);
                        break;
                    default:
                        logger.error(e.getMessage(), e);
                        break;
                }
            } catch (IllegalArgumentException iae) {
                logger.error(e.getMessage(), e);
            }
        } else {
            logger.error(e.getMessage(), e);
        }

        ExceptionReport exceptionReport = createExceptionReport(e, true);

        try {
            int status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();

            if (e instanceof WebApplicationException) {
                WebApplicationException we = (WebApplicationException) e;
                status = we.getResponse().getStatus();
            } else if (e instanceof ServiceException) {
                ServiceException ae = (ServiceException) e;
                exceptionReport.setCode(ae.getCode());
                exceptionReport.setLocator(ae.getLocator());
            }

            return Response.status(status).entity(objectMapper.writeValueAsString(exceptionReport))
                    .type("application/json; charset=UTF-8").build();
        } catch (Exception dbe) {
            logger.error(dbe.getMessage(), dbe);

            String errorMsg = String.format("{\"code\":\"%s\", \"message\":\"%s\", \"stackTrace\":\"%s\"}",
                    ERROR.COMMON_UNKNOWN.code(), ERROR.COMMON_UNKNOWN.value(), ExceptionUtils.getFullStackTrace(dbe));

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMsg)
                    .type("application/json; charset=UTF-8").build();
        }
    }

    private ExceptionReport createExceptionReport(Throwable rse, boolean isDebug) {
        ExceptionReport exceptionReport = new ExceptionReport();
        exceptionReport.setCode(ERROR.COMMON_UNKNOWN.code());
        exceptionReport.setMessage(rse.getMessage());
        if (isDebug) {
            exceptionReport.setStackTrace(ExceptionUtils.getFullStackTrace(rse));
        }
        return exceptionReport;
    }
}
