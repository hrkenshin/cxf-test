package com.tony.examples.cxf;

import com.tony.examples.cxf.annotation.Decrypt;
import com.tony.examples.cxf.protocol.HelloRequest;
import com.tony.examples.cxf.protocol.HelloResponse;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * TEST API
 */
//@Path("/test")
//@Decrypt
public interface RestService {

//    @GET
//    @RolesAllowed({"USER"})
//    @Path("/hello.do")
//    @Decrypt
    public String hello(@Valid @NotNull @QueryParam("name") String name);

//    @POST
//    @RolesAllowed({"GUEST", "USER"})
//    @Path("/hello.do")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public HelloResponse hello(@Valid HelloRequest request);
}