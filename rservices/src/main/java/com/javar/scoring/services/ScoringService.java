package com.javar.scoring.services;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.javar.rserve.execute.RServe;
import com.javar.rserve.lambda.CheckedLambda;
import com.javar.scoring.models.ModelDataFrame;

public abstract class ScoringService<T extends ModelDataFrame> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected abstract ImmutableMap<String, Object> getModelDataFrameMappings(T modelDataFrame);

    private static final String INPUT_DATA_NAME = "input_data";
    private RServe rServe;

    @Inject
    public ScoringService(RServe rServe) {
        this.rServe = rServe;
    }

    protected String run(T modelDataFrame, String rScript) {
        try {
            REXP rDataFrame = createDataFrame(modelDataFrame);
            logger.info("Created R DataFrame {}", rDataFrame);

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

    private REXP createDataFrame(T modelDataFrame) throws REXPMismatchException {
        RList list = new RList();
        list.putAll(getModelDataFrameMappings(modelDataFrame));

        return REXP.createDataFrame(list);
    }
}
