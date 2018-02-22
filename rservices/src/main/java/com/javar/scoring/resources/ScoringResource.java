package com.javar.scoring.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javar.scoring.model1.Model1DataFrame;
import com.javar.scoring.model1.Model1Service;
import com.javar.scoring.model2.Model2DataFrame;
import com.javar.scoring.model2.Model2Service;
import com.javar.scoring.model4.Model4DataFrame;
import com.javar.scoring.model4.Model4Service;
import com.javar.scoring.models.InputDataRequest;
import com.javar.scoring.models.ScoringResponse;

@Path("/scoring/predict")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ScoringResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Model1Service model1Service;
    private Model2Service model2Service;
    private Model4Service model4Service;

    @Inject
    public ScoringResource(Model1Service model1Service, Model2Service model2Service, Model4Service model4Service) {
        this.model1Service = model1Service;
        this.model2Service = model2Service;
        this.model4Service = model4Service;
    }

    @POST
    @Path("/model1")
    public Response getResultFromModel1(InputDataRequest<Model1DataFrame> inputDataRequest) {
        logger.info("Model1 request \n{}", inputDataRequest);
        Model1DataFrame modelDataFrame = inputDataRequest.getDataFrame();
        ScoringResponse response = model1Service.predict(modelDataFrame);

        return Response.status(OK).entity(response).build();
    }

    @POST
    @Path("/model2")
    public Response getResultFromModel2(InputDataRequest<Model2DataFrame> inputDataRequest) {
        logger.info("Model2 request \n{}", inputDataRequest);
        Model2DataFrame modelDataFrame = inputDataRequest.getDataFrame();
        ScoringResponse response = model2Service.predict(modelDataFrame);

        return Response.status(OK).entity(response).build();
    }

    @POST
    @Path("/model4")
    public Response getResultFromModel4(InputDataRequest<Model4DataFrame> inputDataRequest) {
        logger.info("Model4 request \n{}", inputDataRequest);
        Model4DataFrame modelDataFrame = inputDataRequest.getDataFrame();
        ScoringResponse response = model4Service.predict(modelDataFrame);

        return Response.status(OK).entity(response).build();
    }
}
