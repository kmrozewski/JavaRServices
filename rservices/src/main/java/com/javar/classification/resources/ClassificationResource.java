package com.javar.classification.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.javar.classification.models.IrisDataFrame;
import com.javar.classification.models.RandomForestRequest;
import com.javar.classification.models.RandomForestResponse;
import com.javar.classification.services.ClassificationService;

@Path("/classification")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ClassificationResource {

    private ClassificationService service;

    @Inject
    public ClassificationResource(ClassificationService service) {
        this.service = service;
    }

    @POST
    @Path("/randomForest")
    public Response getResult(RandomForestRequest request) {
        IrisDataFrame dataFrame = request.getDataFrame();
        RandomForestResponse response = service.predict(dataFrame);

        return Response.status(OK).entity(response).build();
    }
}
