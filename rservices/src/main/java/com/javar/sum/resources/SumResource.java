package com.javar.sum.resources;

import static javax.ws.rs.core.Response.Status.OK;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.javar.sum.services.SumService;

@Path("/sample/sum")
public class SumResource {

    private SumService service;

    @Inject
    public SumResource(SumService service) {
        this.service = service;
    }

    @GET
    public Response getSum(@QueryParam("x") int x, @QueryParam("y") int y) {
        return Response.status(OK).entity(service.calculateSum(x, y)).build();
    }
}
