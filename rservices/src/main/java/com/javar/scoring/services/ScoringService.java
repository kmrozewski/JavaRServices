package com.javar.scoring.services;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;

import com.google.common.collect.ImmutableMap;
import com.javar.rserve.execute.RServe;
import com.javar.rserve.lambda.CheckedLambda;
import com.javar.scoring.models.ModelDataFrame;

public abstract class ScoringService<T extends ModelDataFrame> {

    private static final String INPUT_DATA_NAME = "input_data";
    private RServe rServe;

    protected abstract ImmutableMap<String, Object> getModelDataFrameMappings(T modelDataFrame);

    @Inject
    public ScoringService(RServe rServe) {
        this.rServe = rServe;
    }

    protected String run(T modelDataFrame, String rScript) {
        try {
            REXP rDataFrame = createDataFrame(getModelDataFrameMappings(modelDataFrame));

            return rServe.execute(evaluateScript(rDataFrame), rScript);
        } catch (REXPMismatchException e) {
            throw new WebApplicationException("Wrong data format", BAD_REQUEST);
        }
    }

    private CheckedLambda<String> evaluateScript(REXP rDataFrame) {
        return ((rConnection, rScript) -> {
            rConnection.assign(INPUT_DATA_NAME, rDataFrame);

            return rConnection.eval(rScript).asString();
        });
    }

    private REXP createDataFrame(ImmutableMap<String, Object> modelDataFrameMappings) throws REXPMismatchException {
        RList list = new RList();
        list.putAll(modelDataFrameMappings);

        return REXP.createDataFrame(list);
    }
}
