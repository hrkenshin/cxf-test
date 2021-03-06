package com.tony.examples.cxf;

import com.tony.examples.cxf.annotation.Decrypt;
import com.tony.examples.cxf.annotation.Encrypt;
import com.tony.examples.cxf.protocol.HelloRequest;
import com.tony.examples.cxf.protocol.HelloResponse;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * TEST API
 */
@Component
@Path("/test")
@Encrypt
@Decrypt
public class TestService {

    @GET
    @RolesAllowed({"GUEST"})
    @Path("/hello.do")
    public String hello(@Valid @NotNull @QueryParam("name") String name) {
        return "Hello~ " + name;
    }

    @POST
    @RolesAllowed({"USER"})
    @Path("/hello.do")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public HelloResponse hello(@Valid HelloRequest request) {

        HelloResponse response = new HelloResponse();
        response.setAts(System.currentTimeMillis());
        response.setHello("Hello~ " + request.getName());
        response.setToday(new Date());

        return response;
    }

}