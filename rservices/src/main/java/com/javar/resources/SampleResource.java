package com.javar.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/get")
public class SampleResource {

    @Inject
    public SampleResource() {}

    @GET
    public Response get(@QueryParam("name") String name) {
        String data = "Hello " + name + "!";

        return Response.status(200).entity(data).build();
    }
}
