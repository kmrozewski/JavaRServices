package com.javar.scoring.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.javar.scoring.model1.Model1DataFrame;
import com.javar.scoring.model1.Model1Service;
import com.javar.scoring.models.InputDataRequest;
import com.javar.scoring.models.ScoringResponse;

@Path("/scoring/predict")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ScoringResource {

    private Model1Service model1Service;

    @Inject
    public ScoringResource(Model1Service model1Service) {
        this.model1Service = model1Service;
    }

    @POST
    @Path("/model1")
    public Response getResultFromModel1(InputDataRequest inputDataRequest) {
        Model1DataFrame modelDataFrame = (Model1DataFrame) inputDataRequest.getDataFrame();
        ScoringResponse response = model1Service.predict(modelDataFrame);

        return Response.status(OK).entity(response).build();
    }
}
