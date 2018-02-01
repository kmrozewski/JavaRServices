package com.javar.scoring.services;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import static com.javar.util.ScriptReader.read;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.javar.rserve.execute.RServe;
import com.javar.rserve.lambda.CheckedLambda;
import com.javar.scoring.model1.Model1DataFrame;
import com.javar.scoring.models.ModelDataFrame;
import com.javar.scoring.models.ScoringResponse;

public abstract class ScoringService<T extends ModelDataFrame> {

    private static final String INPUT_DATA_NAME = "input_data";
    private final ObjectMapper mapper = new ObjectMapper();
    private RServe rServe;

    protected abstract String getRScriptPath();
    protected abstract ImmutableMap<String, Object> getModelDataFrameMappings(T modelDataFrame);

    @Inject
    public ScoringService(RServe rServe) {
        this.rServe = rServe;
    }

    protected ScoringResponse<T> run(T modelDataFrame) {
        try {
            String rScript = read(this.getClass(), getRScriptPath());
            REXP rDataFrame = this.createDataFrame(getModelDataFrameMappings(modelDataFrame));
            String result = rServe.execute(evaluateScript(rDataFrame), rScript);

            ScoringResponse<Model1DataFrame> response = new ScoringResponse<>();

            return mapper.readValue(result, response.getClass());
        } catch (IOException e) {
            throw new RuntimeException("Failed to map response from R to ScoringResponse", e);
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
