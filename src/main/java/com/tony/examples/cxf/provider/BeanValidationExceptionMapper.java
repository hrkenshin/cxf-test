package com.tony.examples.cxf.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tony.examples.cxf.ERROR;
import com.tony.examples.cxf.protocol.ExceptionReport;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean Validation Exception Mapper
 */
@Provider
@Priority(Priorities.USER)
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    private Logger logger = LoggerFactory.getLogger(BeanValidationExceptionMapper.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response toResponse(ConstraintViolationException cve) {
        ExceptionReport exceptionReport = createExceptionReport(cve, true);

        try {
            logger.warn(exceptionReport.getMessage(), cve);

            return Response.status(Response.Status.BAD_REQUEST).entity(objectMapper.writeValueAsString(exceptionReport)).
                    type("application/json; charset=UTF-8").build();
        } catch (Exception dbe) {
            logger.error(dbe.getMessage(), dbe);

            String stackTrace = ExceptionUtils.getFullStackTrace(dbe);

            String errorMsg = String.format("{\"code\":\"%s\", \"message\":\"%s\", \"stackTrace\":\"%s\"}",
                    ERROR.COMMON_BAD_REQUEST.code(), dbe.getMessage(), stackTrace);

            return Response.status(Response.Status.BAD_REQUEST).entity(errorMsg)
                    .type("application/json; charset=UTF-8").build();
        }
    }

    private ExceptionReport createExceptionReport(ConstraintViolationException cve, boolean isDebug) {
        ExceptionReport exceptionReport = new ExceptionReport();

        List<String> msgList = new ArrayList<>();
        for (ConstraintViolation<?> violation : cve.getConstraintViolations()) {
            msgList.add(violation.getPropertyPath() + " : " + violation.getMessage());
        }

        exceptionReport.setCode(ERROR.COMMON_BAD_REQUEST.code());
        exceptionReport.setMessage(msgList.toString());
        if (isDebug) {
            exceptionReport.setStackTrace(ExceptionUtils.getFullStackTrace(cve));
        }
        return exceptionReport;
    }
}