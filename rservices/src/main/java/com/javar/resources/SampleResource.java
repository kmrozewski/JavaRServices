package com.javar.resources;

import static javax.ws.rs.core.Response.Status.OK;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.javar.services.SampleService;

@Path("/sample")
public class SampleResource {

    private SampleService sampleService;

    @Inject
    public SampleResource(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GET
    @Path("/get")
    public Response get(@QueryParam("name") String name) {
        String data = "Hello " + name + "!";

        return Response.status(OK).entity(data).build();
    }

    @GET
    @Path("/sum")
    public Response getSum(@QueryParam("a") int a, @QueryParam("b") int b) {
        sampleService.initialize();

        return Response.status(OK).entity("Result " + sampleService.getSum2(a, b).toString()).build();
    }
}
