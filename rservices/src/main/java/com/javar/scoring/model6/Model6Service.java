package com.javar.scoring.model6;

import static com.javar.scoring.model6.Model6Mappings.getMappings;
import static com.javar.util.ScriptReader.read;

import java.io.IOException;

import javax.inject.Inject;

import com.google.common.collect.ImmutableMap;
import com.javar.rserve.execute.RServe;
import com.javar.scoring.services.ScoringService;

public class Model6Service extends ScoringService<Model6DataFrame> {

    private static final String R_SCRIPT_PATH = "rScripts/model6_predict.R";
    private final String rScript = read(this.getClass(), R_SCRIPT_PATH);

    @Inject
    public Model6Service(RServe rServe) {
        super(rServe);
    }

    @Override
    protected ImmutableMap<String, Object> getModelDataFrameMappings(Model6DataFrame modelDataFrame) {
        return getMappings(modelDataFrame);
    }

    public Model6Response predict(Model6DataFrame modelDataFrame) {
        try {
            String results = run(modelDataFrame, rScript);
            logger.info("Model6 response from R: \n{}", results);
            Model6Response response = mapper.readValue(results, Model6Response.class).setId(modelDataFrame.getId());
            response.getInputData().setId(modelDataFrame.getId());

            return response;
        } catch (IOException e) {
            throw new RuntimeException("Unable to map R script response to Model6Response", e);
        }
    }
}
